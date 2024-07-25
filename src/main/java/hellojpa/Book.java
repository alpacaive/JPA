package hellojpa;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("B") // DTYPE 에 들어갈 값 이름 정하고싶으면
public class Book extends Item {

    private String author;
    private String isbn;
}
