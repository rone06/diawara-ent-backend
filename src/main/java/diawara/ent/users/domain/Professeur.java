/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diawara.ent.users.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author adrame
 */
@Entity
@Table(name = "Professeur")
@NamedQueries({
    @NamedQuery(name = "Professeur.findAll", query = "SELECT p FROM Professeur p")})
public class Professeur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProfesseur")
    private Integer idProfesseur;
    @JoinColumn(name = "idIdentite", referencedColumnName = "idIdentite")
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Identite idIdentite;
    @JoinColumn(name = "iduser", referencedColumnName = "iduser")
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private User iduser;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "professeuridProfesseur", fetch = FetchType.LAZY)
    private List<NiveauhasProfesseur> niveauhasProfesseurList;

    public Professeur() {
    }

    public Professeur(Integer idProfesseur) {
        this.idProfesseur = idProfesseur;
    }

    public Integer getIdProfesseur() {
        return idProfesseur;
    }

    public void setIdProfesseur(Integer idProfesseur) {
        this.idProfesseur = idProfesseur;
    }

    public Identite getIdIdentite() {
        return idIdentite;
    }

    public void setIdIdentite(Identite idIdentite) {
        this.idIdentite = idIdentite;
    }

    public User getIduser() {
        return iduser;
    }

    public void setIduser(User iduser) {
        this.iduser = iduser;
    }

    public List<NiveauhasProfesseur> getNiveauhasProfesseurList() {
        return niveauhasProfesseurList;
    }

    public void setNiveauhasProfesseurList(List<NiveauhasProfesseur> niveauhasProfesseurList) {
        this.niveauhasProfesseurList = niveauhasProfesseurList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProfesseur != null ? idProfesseur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Professeur)) {
            return false;
        }
        Professeur other = (Professeur) object;
        if ((this.idProfesseur == null && other.idProfesseur != null) || (this.idProfesseur != null && !this.idProfesseur.equals(other.idProfesseur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.toto.ppp.Professeur[ idProfesseur=" + idProfesseur + " ]";
    }
    
}
