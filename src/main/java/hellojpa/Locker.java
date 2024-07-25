package hellojpa;

import jakarta.persistence.*;

@Entity
public class Locker {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "locker_seq_gen")
    @SequenceGenerator(name = "locker_seq_gen", sequenceName = "LOCKER_SEQ", allocationSize = 1)
    private Long id;

    private String name;

    @OneToOne(mappedBy = "locker")
    private Member member;

}
