package tn.esprit.springproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
public class Enseignant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int idEns;
    private String nomEns;
    private String prenomEns;
    @Enumerated(EnumType.STRING)
    private Fonction fonction;
    private double salaire;
    @ManyToMany(mappedBy="enseignants")
    @JsonIgnore
     private Set<Module> modules;
    @ManyToOne
    @JsonIgnore
    private Departement departement;


}
