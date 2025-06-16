package joe.aurora.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "stores")
@Getter
@Setter
public class Store {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "store_id", unique = true, nullable = false)
    final long id;

    @Column(name = "store_name")
    String name;

    public Store(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Store[id=%s, name=%s]", id, name);
    }
}