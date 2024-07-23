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
            member.setName("ZZZZZ");
//            em.persist(member); 오히려 이걸 하면 안됨, 자바 컬렉션을 다루듯 값만 바꾸면 됨
            // JPA는 변경 감지라는 기능으로 엔티티를 변경할 수 있게 기능이 제공됨
            // 영속 컨텍스트에서 데이터 원본을 스냅샷을 떠놔서 엔티티랑 비교해서 바뀌었으면 update 쿼리를 쏴줌

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
