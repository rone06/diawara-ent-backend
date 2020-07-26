/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diawara.ent.users.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author adrame
 */
@Entity
@Table(name = "Etudiant")
@NamedQueries({
    @NamedQuery(name = "Etudiant.findAll", query = "SELECT e FROM Etudiant e")})
public class Etudiant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEtudiant")
    private Integer idEtudiant;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "numeroEtudiant")
    private String numeroEtudiant;
    @JoinColumn(name = "idIdentite", referencedColumnName = "idIdentite")
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Identite idIdentite;
    @JoinColumn(name = "idNiveau", referencedColumnName = "idNiveau")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Niveau idNiveau;
    @JoinColumn(name = "idTuteur", referencedColumnName = "idIdentite")
    @ManyToOne(fetch = FetchType.LAZY)
    private Tuteur idTuteur;
    @JoinColumn(name = "idUser", referencedColumnName = "iduser")
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private User idUser;

    public Etudiant() {
    }

    public Etudiant(Integer idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    public Etudiant(Integer idEtudiant, String numeroEtudiant) {
        this.idEtudiant = idEtudiant;
        this.numeroEtudiant = numeroEtudiant;
    }

    public Integer getIdEtudiant() {
        return idEtudiant;
    }

    public void setIdEtudiant(Integer idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    public String getNumeroEtudiant() {
        return numeroEtudiant;
    }

    public void setNumeroEtudiant(String numeroEtudiant) {
        this.numeroEtudiant = numeroEtudiant;
    }

    public Identite getIdIdentite() {
        return idIdentite;
    }

    public void setIdIdentite(Identite idIdentite) {
        this.idIdentite = idIdentite;
    }

    public Niveau getIdNiveau() {
        return idNiveau;
    }

    public void setIdNiveau(Niveau idNiveau) {
        this.idNiveau = idNiveau;
    }

    public Tuteur getIdTuteur() {
        return idTuteur;
    }

    public void setIdTuteur(Tuteur idTuteur) {
        this.idTuteur = idTuteur;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEtudiant != null ? idEtudiant.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Etudiant)) {
            return false;
        }
        Etudiant other = (Etudiant) object;
        if ((this.idEtudiant == null && other.idEtudiant != null) || (this.idEtudiant != null && !this.idEtudiant.equals(other.idEtudiant))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.toto.ppp.Etudiant[ idEtudiant=" + idEtudiant + " ]";
    }
    
}
