package tn.esprit.khotwaback.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@Entity
@ToString
@NoArgsConstructor
@Setter
@Getter
public class Quizz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idQuizz;
    private String nomQuizz;
    @ManyToOne
    @JsonIgnore
    private Cours cours;
    @OneToMany(cascade = CascadeType.ALL ,mappedBy = "quizz")
    private List<Question> questions;

}
