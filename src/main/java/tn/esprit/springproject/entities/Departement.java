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
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int idDepart;
    private String nomDepart;
    @OneToMany(mappedBy = "departement")
    @JsonIgnore
    private Set<Etudiant> etudiants;
    @OneToMany(mappedBy = "departement")
    @JsonIgnore
    private Set<Enseignant> enseignants;
    @ManyToOne ()
    private Universite universite;

}
