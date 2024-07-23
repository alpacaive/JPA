package hellojpa;

import jakarta.persistence.*;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction(); // JPA의 모든 데이터 변경은 트랜잭션 안에서 되어야 한다

        tx.begin();

        try {
//            // 비영속
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("HelloJPA");
//
//            // 영속 -> 여기서 DB에 쿼리문이 날아가지 않음
//            System.out.println("=== BEFORE ===");
//            em.persist(member);
//            System.out.println("=== AFTER ===");

            // 1차 캐시에서 조회
            Member findMember1 = em.find(Member.class, 101L); // DB에서 가져옴 = 쿼리문 날아감
            Member findMember2 = em.find(Member.class, 101L); // 1차 캐시에서 꺼내옴, 결론 : 쿼리 1번만 쏴야함

            // 영속 엔티티의 동일성 보장
            System.out.println("result = " + (findMember1 == findMember2)); // 동일성 비교 true

//            System.out.println("findMember.getId() = " + findMember.getId());
//            System.out.println("findMember.getName() = " + findMember.getName());

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
