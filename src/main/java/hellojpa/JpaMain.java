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

            // 영속

            Member member = em.find(Member.class, 150L);
            member.setName("AAAAA");

//            em.detach(member); // 영속성 컨텍스트에서 member와 관련된 모든게 다 빠짐 = 준영속 상태
            em.clear(); // 영속성 컨텍스트 비움

            Member member2 = em.find(Member.class, 150L);

            System.out.println("====================");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
