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

//            // concat
//            String query = "select concat('a', 'b') from Member m";
//            // subString
//            String query = "select substring(m.username, 2, 3) from Member m ";
//            // locate
//            String query = "select locate('de', 'abcdefg') from Member m";
//            // size -> 컬렉션 크기
//            String query = "select size(t.members) from Team t";
//            // index -> 안쓰는게 좋다
//            String query = "select index(t.members) from Team t";
            // 사용자 정의 함수 호출
            String query = "select function('group_concat', m.username) FROM Member m";


            List<String> result = em.createQuery(query, String.class).getResultList();

            for (String s : result) {
                System.out.println("s = " + s);
            }


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
