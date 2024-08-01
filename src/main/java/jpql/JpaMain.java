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

            Member member = new Member();
            member.setUsername("member1");
            member.setAge(10);

            em.persist(member);

            em.flush();
            em.clear();

//            // 엔티티 프로젝션
//            // 영속성 컨텍스트에서 관리됨
//            List<Team> result = em.createQuery("select m.team from Member m", Team.class)
//                    .getResultList(); // join query 나감

//            // 임베디드 타입 프로젝션 -> 임베디드 타입만으로는 안되고 소속된 엔티티로부터 시작해야 함
//            em.createQuery("select o.address from Order o", Address.class)
//                    .getResultList();

//            // 스칼라 타입 프로젝션
//            List<Object[]> resultList = em.createQuery("select m.username, m.age from Member m")
//                    .getResultList();

//            // object[] 타입으로 조회 -> 이 과정을 생략하는 법은 List<Object[]>
//            Object o = resultList.get(0);
//            Object[] result = (Object[]) o;

//            Object[] result = resultList.get(0);
//            System.out.println("result = " + result[0]);
//            System.out.println("age = " + result[1]);

            // new 명령어로 조회
            List<MemberDto> result = em.createQuery("select new jpql.MemberDto(m.username, m.age) from Member m", MemberDto.class)
                    .getResultList();

            MemberDto memberDto = result.get(0);
            System.out.println("memberDto.getUsername() = " + memberDto.getUsername());
            System.out.println("memberDto.getAge() = " + memberDto.getAge());

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
