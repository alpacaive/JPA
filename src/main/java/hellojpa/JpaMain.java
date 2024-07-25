//package hellojpa;
//
//import jakarta.persistence.*;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//public class JpaMain {
//
//    public static void main(String[] args) {
//
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction tx = em.getTransaction(); // JPA의 모든 데이터 변경은 트랜잭션 안에서 되어야 한다
//
//        tx.begin();
//
//        try {
//
//            Member member = new Member();
//            member.setUsername("user1");
//            member.setCreatedBy("Kim");
//            member.setCreatedDate(LocalDateTime.now());
//
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//
//            tx.commit();
//        } catch (Exception e) {
//            tx.rollback();
//        } finally {
//            em.close();
//        }
//
//        emf.close();
//    }
//}
