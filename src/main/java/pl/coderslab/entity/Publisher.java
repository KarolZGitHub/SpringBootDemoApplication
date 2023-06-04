package pl.coderslab.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.pl.NIP;
import org.hibernate.validator.constraints.pl.REGON;

import java.util.List;

@Entity
@Table(name = "publisher")
@Data
@NoArgsConstructor

public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @NotBlank
    private String name;
    @OneToMany(mappedBy = "publisher")
    @ToString.Exclude
    private List<Book> books;
    @NIP
    @NotBlank
    private String nip;
    @REGON
    @NotBlank
    private String regon;

}
