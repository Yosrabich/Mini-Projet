package tn.esprit.springproject.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
public class Etudiant implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int idEtudiant;
    @Enumerated(EnumType.STRING)
    private Option op;
private String nom;
private String prenom;
@ManyToMany (mappedBy = "etudiants")
@JsonIgnore
    private Set<Equipe> equipes;
@ManyToOne
@JsonIgnore
    private Departement departement;
@OneToMany(mappedBy="etudiant")
@JsonIgnore
    private Set<Contrat> contrats;
}
