package pl.coderslab.entity;

import lombok.*;
import org.hibernate.validator.constraints.Range;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "{title.not.empty.error}")
    @Size(min = 5, message = "{title.too.short.error}")
    private String title;

    @Range(min = 1, max = 10)
    @ToString.Exclude
    private int rating;

    @Size(max = 600)
    private String description;

    @NotNull
    @ManyToOne
    private Publisher publisher;

    @NotNull
    @ManyToOne
    private Category category;

    @NotEmpty
    @ManyToMany(fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<Author> authors = new ArrayList<>();

    @Min(1)
    private int pages;

}
