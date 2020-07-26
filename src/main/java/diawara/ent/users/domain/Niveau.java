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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author adrame
 */
@Entity
@Table(name = "Niveau")
@NamedQueries({
    @NamedQuery(name = "Niveau.findAll", query = "SELECT n FROM Niveau n")})
public class Niveau implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idNiveau")
    private Integer idNiveau;
    @Size(max = 45)
    @Column(name = "classe")
    private String classe;
    @Size(max = 45)
    @Column(name = "ecole")
    private String ecole;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNiveau", fetch = FetchType.LAZY)
    private List<Etudiant> etudiantList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "niveau", fetch = FetchType.LAZY)
    private NiveauhasProfesseur niveauhasProfesseur;

    public Niveau() {
    }

    public Niveau(Integer idNiveau) {
        this.idNiveau = idNiveau;
    }

    public Integer getIdNiveau() {
        return idNiveau;
    }

    public void setIdNiveau(Integer idNiveau) {
        this.idNiveau = idNiveau;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getEcole() {
        return ecole;
    }

    public void setEcole(String ecole) {
        this.ecole = ecole;
    }

    public List<Etudiant> getEtudiantList() {
        return etudiantList;
    }

    public void setEtudiantList(List<Etudiant> etudiantList) {
        this.etudiantList = etudiantList;
    }

    public NiveauhasProfesseur getNiveauhasProfesseur() {
        return niveauhasProfesseur;
    }

    public void setNiveauhasProfesseur(NiveauhasProfesseur niveauhasProfesseur) {
        this.niveauhasProfesseur = niveauhasProfesseur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNiveau != null ? idNiveau.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Niveau)) {
            return false;
        }
        Niveau other = (Niveau) object;
        if ((this.idNiveau == null && other.idNiveau != null) || (this.idNiveau != null && !this.idNiveau.equals(other.idNiveau))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.toto.ppp.Niveau[ idNiveau=" + idNiveau + " ]";
    }
    
}
