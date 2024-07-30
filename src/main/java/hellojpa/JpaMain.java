package hellojpa;

import jakarta.persistence.*;
import org.hibernate.Hibernate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction(); // JPA의 모든 데이터 변경은 트랜잭션 안에서 되어야 한다

        tx.begin();

        try {

            Member member = new Member();
            member.setUsername("member1");
            member.setHomeAddress(new Address("homeCity", "street", "10000"));

            member.getFavoriteFoods().add("치킨");
            member.getFavoriteFoods().add("족발");
            member.getFavoriteFoods().add("피자");

            member.getAddressHistory().add(new AddressEntity("old1", "street2", "10000"));
            member.getAddressHistory().add(new AddressEntity("old2", "street2", "10000"));

            em.persist(member);

            em.flush();
            em.clear();

            System.out.println("========== START ==========");
            Member findMember = em.find(Member.class, member.getId());

//            // 값 타입 조회
//            List<Address> addressHistory = findMember.getAddressHistory();
//            for (Address address : addressHistory) {
//                System.out.println("address = " + address.getCity());
//            }
//            Set<String> favoriteFoods = findMember.getFavoriteFoods();
//            for (String favoriteFood : favoriteFoods) {
//                System.out.println("favoriteFood = " + favoriteFood);
//            }

            // 값 타입 수정 -> set으로 하면 안되고 아예 갈아 끼워야함, set으로 하면 사이드 이펙트 날 확률 큼
            // homeCity -> newCity
            Address a = findMember.getHomeAddress();
            findMember.setHomeAddress(new Address("newCity", a.getStreet(), a.getZipcode()));

            // 치킨 -> 한식
            findMember.getFavoriteFoods().remove("치킨");
            findMember.getFavoriteFoods().add("한식");

            // old1 -> new1 = equals 재정의 중요!, 컬렉션 다룰때 equals, hashcode 재정의 의미 있음
            findMember.getAddressHistory().remove(new AddressEntity("old1", "street", "10000"));
            findMember.getAddressHistory().add(new AddressEntity( "newCity1", "street2", "10000"));

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

        emf.close();
    }

    private static void logic(Member m1, Member m2) {
        System.out.println("m1 == m2 : " + (m1 instanceof Member));
        System.out.println("m1 == m2 : " + (m2 instanceof Member));
    }

}
