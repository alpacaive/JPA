//package hellojpa;
//
//import jakarta.persistence.*;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.Date;
//
//@Entity
//public class Member {
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
////    @Column(name = "TEAM_ID")
////    private Long teamId;
//
//    @ManyToOne
//    @JoinColumn(name = "TEAM_ID")
//    private Team team;
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
////    public void changeTeam(Team team) {
////        this.team = team;
////        team.getMembers().add(this); // 연관관게 편의 메서드
////    }
//}
