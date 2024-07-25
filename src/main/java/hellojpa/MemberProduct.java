//package hellojpa;
//
//import jakarta.persistence.*;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//
//@Entity
//public class MemberProduct {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_product_seq_gen")
//    @SequenceGenerator(name = "member_product_seq_gen", sequenceName = "MEMBER_PRODUCT_SEQ", allocationSize = 1)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "MEMBER_ID")
//    private Member member;
//
//    @ManyToOne
//    @JoinColumn(name = "PRODUCT_ID")
//    private Product product;
//
//    private int count;
//    private int price;
//    private LocalDateTime orderDateTime;
//
//}
