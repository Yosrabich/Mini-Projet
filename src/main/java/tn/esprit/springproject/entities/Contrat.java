package tn.esprit.springproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
public class Contrat implements Serializable {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Setter(AccessLevel.NONE)
private int idContrat;
@Temporal(TemporalType.DATE)
private Date dateDebutContrat;
@Temporal (TemporalType.DATE)
private Date dateFinContrat;
@Enumerated(EnumType.STRING)
private Specialite specialite;
private Boolean archive;
private Double montantContrat;
@ManyToOne
@JsonIgnore
    private Etudiant etudiant;
}
