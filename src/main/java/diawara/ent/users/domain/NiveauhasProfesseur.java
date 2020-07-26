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

/**
 *
 * @author adrame
 */
@Entity
@Table(name = "Niveau_has_Professeur")
@NamedQueries({
    @NamedQuery(name = "NiveauhasProfesseur.findAll", query = "SELECT n FROM NiveauhasProfesseur n")})
public class NiveauhasProfesseur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Niveau_idNiveau")
    private Integer niveauidNiveau;
    @JoinColumn(name = "Niveau_idNiveau", referencedColumnName = "idNiveau", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Niveau niveau;
    @JoinColumn(name = "Professeur_idProfesseur", referencedColumnName = "idProfesseur")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Professeur professeuridProfesseur;

    public NiveauhasProfesseur() {
    }

    public NiveauhasProfesseur(Integer niveauidNiveau) {
        this.niveauidNiveau = niveauidNiveau;
    }

    public Integer getNiveauidNiveau() {
        return niveauidNiveau;
    }

    public void setNiveauidNiveau(Integer niveauidNiveau) {
        this.niveauidNiveau = niveauidNiveau;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    public Professeur getProfesseuridProfesseur() {
        return professeuridProfesseur;
    }

    public void setProfesseuridProfesseur(Professeur professeuridProfesseur) {
        this.professeuridProfesseur = professeuridProfesseur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (niveauidNiveau != null ? niveauidNiveau.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NiveauhasProfesseur)) {
            return false;
        }
        NiveauhasProfesseur other = (NiveauhasProfesseur) object;
        if ((this.niveauidNiveau == null && other.niveauidNiveau != null) || (this.niveauidNiveau != null && !this.niveauidNiveau.equals(other.niveauidNiveau))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.toto.ppp.NiveauhasProfesseur[ niveauidNiveau=" + niveauidNiveau + " ]";
    }
    
}
