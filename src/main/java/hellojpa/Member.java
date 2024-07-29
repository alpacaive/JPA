//package hellojpa;
//
//import jakarta.persistence.*;
//
//import java.util.List;
//
//@Entity
//public class Member extends BaseEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq_gen")
//    @SequenceGenerator(name = "member_seq_gen", sequenceName = "MEMBER_SEQ", allocationSize = 1)
//    @Column(name = "MEMBER_ID")
//    private Long id;
//
//    @Column(name = "USERNAME")
//    private String username;
//
//    @ManyToOne(fetch = FetchType.LAZY) // 지연로딩
////    @ManyToOne(fetch = FetchType.EAGER) // 즉시로딩
//    @JoinColumn
//    private Team team;
//
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public Team getTeam() {
//        return team;
//    }
//
//    public void setTeam(Team team) {
//        this.team = team;
//    }
//
//    //    public void changeTeam(Team team) {
////        this.team = team;
////        team.getMembers().add(this); // 연관관게 편의 메서드
////    }
//
//}
