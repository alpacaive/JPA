package jpql;

import jakarta.persistence.*;

import java.util.List;

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

//            // TypeQuery, Query
//            TypedQuery<Member> query1 = em.createQuery("select m from Member m", Member.class);
//            TypedQuery<String> query2 = em.createQuery("select m.username from Member m", String.class);
//            Query query3 = em.createQuery("select m.username, m.age from Member m"); // (age = int, username = String) 타입이 여러개여서 TypeQuery 못쓴다

//            // 결과 조회 API
//            // ResultList
//            TypedQuery<Member> query = em.createQuery("select m from Member m", Member.class);
//            List<Member> resultList = query.getResultList();
//
//            for (Member member1 : resultList) {
//                System.out.println("member1 = " + member1);
//            }
//            // SingleResult
//            TypedQuery<Member> query = em.createQuery("select m from Member m where m.id = 10", Member.class);
//            Member result = query.getSingleResult();
//
//            System.out.println("result = " + result);

            // 파라미터 바인딩 -> 이름 기준, 위치 기준 지원하는데 위치 기준은 쓰지 않는걸 권장
            TypedQuery<Member> query = em.createQuery("select m from Member m where m.username = :username", Member.class);
            query.setParameter("username", "member1");
            Member result = query.getSingleResult();
            System.out.println("result = " + result.getUsername());

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
