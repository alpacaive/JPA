package jpql;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction(); // JPA의 모든 데이터 변경은 트랜잭션 안에서 되어야 한다

        tx.begin();

        try {

            Team team = new Team();
            team.setName("teamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("teamA");
            member.setAge(10);
            member.setType(MemberType.ADMIN);
            member.setTeam(team);
            em.persist(member);

            em.flush();
            em.clear();

//            String query = "select m from Member m inner join m.team"; // 내부 조인
//            String query = "select m from Member m left outer join m.team"; // 외부 조인
//            String query = "select m from Member m, Team t where m.username = t.name"; // 세타 조인
//            String query = "select m from Member m left join m.team t on t.name = 'teamA'"; // 조인 대상 필터링
//            String query = "select m from Member m left join Team t on m.username = t.name"; // 연관관계 없는 엔티티 외부 조인

//            String query = "select mm.age, mm.username" +
//                    "from (select m.age, m.username from Member m) as mm";  // From 절의 서브쿼리는 현재 JPQL 에서 불가능하다

            String query = "select m.username, 'HELLO', TRUE From Member m where m.type = :userType"; // JPQL 타입 표현과 기타식

            List<Object[]> result = em.createQuery(query)
                    .setParameter("userType", MemberType.ADMIN)
                    .getResultList();

            System.out.println("result = " + result.size());

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

        emf.close();
    }

}
