package hellojpa;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("I") // DTYPE 에 들어갈 값 이름 정하고싶으면
public class Album extends Item{

    private String artist;
}
