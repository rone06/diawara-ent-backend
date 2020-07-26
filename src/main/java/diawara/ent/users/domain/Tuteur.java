/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diawara.ent.users.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "Tuteur")
@NamedQueries({
    @NamedQuery(name = "Tuteur.findAll", query = "SELECT t FROM Tuteur t")})
public class Tuteur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTuteur")
    private Integer idTuteur;
    @OneToMany(mappedBy = "idTuteur", fetch = FetchType.LAZY)
    private List<Etudiant> etudiantList;
    @JoinColumn(name = "idIdentite", referencedColumnName = "idIdentite")
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Identite idIdentite;
    @JoinColumn(name = "iduser", referencedColumnName = "iduser")
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private User iduser;

    public Tuteur() {
    }

    public Tuteur(Integer idTuteur) {
        this.idTuteur = idTuteur;
    }

    public Integer getIdTuteur() {
        return idTuteur;
    }

    public void setIdTuteur(Integer idTuteur) {
        this.idTuteur = idTuteur;
    }

    public List<Etudiant> getEtudiantList() {
        return etudiantList;
    }

    public void setEtudiantList(List<Etudiant> etudiantList) {
        this.etudiantList = etudiantList;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTuteur != null ? idTuteur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tuteur)) {
            return false;
        }
        Tuteur other = (Tuteur) object;
        if ((this.idTuteur == null && other.idTuteur != null) || (this.idTuteur != null && !this.idTuteur.equals(other.idTuteur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.toto.ppp.Tuteur[ idTuteur=" + idTuteur + " ]";
    }
    
}
