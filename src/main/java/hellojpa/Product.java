//package hellojpa;
//
//import jakarta.persistence.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//public class Product {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq_gen")
//    @SequenceGenerator(name = "product_seq_gen", sequenceName = "PRODUCT_SEQ", allocationSize = 1)
//    private Long id;
//
//    private String name;
//
//    @OneToMany(mappedBy = "product")
//    private List<MemberProduct> memberProducts = new ArrayList<>();
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//}
