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
@Table(name = "Identite")
@NamedQueries({
    @NamedQuery(name = "Identite.findAll", query = "SELECT i FROM Identite i")})
public class Identite implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idIdentite")
    private Integer idIdentite;
    @Size(max = 45)
    @Column(name = "nom")
    private String nom;
    @Size(max = 45)
    @Column(name = "prenom")
    private String prenom;
    @Size(max = 45)
    @Column(name = "adresse")
    private String adresse;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idIdentite", fetch = FetchType.LAZY)
    private Etudiant etudiant;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idIdentite", fetch = FetchType.LAZY)
    private List<Message> messageList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idIdentite", fetch = FetchType.LAZY)
    private Admin admin;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idIdentite", fetch = FetchType.LAZY)
    private Tuteur tuteur;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idIdentite", fetch = FetchType.LAZY)
    private List<Participant> participantList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idIdentite", fetch = FetchType.LAZY)
    private Professeur professeur;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idIdentite", fetch = FetchType.LAZY)
    private List<Discussion> discussionList;

    public Identite() {
    }

    public Identite(Integer idIdentite) {
        this.idIdentite = idIdentite;
    }

    public Integer getIdIdentite() {
        return idIdentite;
    }

    public void setIdIdentite(Integer idIdentite) {
        this.idIdentite = idIdentite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Tuteur getTuteur() {
        return tuteur;
    }

    public void setTuteur(Tuteur tuteur) {
        this.tuteur = tuteur;
    }

    public List<Participant> getParticipantList() {
        return participantList;
    }

    public void setParticipantList(List<Participant> participantList) {
        this.participantList = participantList;
    }

    public Professeur getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }

    public List<Discussion> getDiscussionList() {
        return discussionList;
    }

    public void setDiscussionList(List<Discussion> discussionList) {
        this.discussionList = discussionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIdentite != null ? idIdentite.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Identite)) {
            return false;
        }
        Identite other = (Identite) object;
        if ((this.idIdentite == null && other.idIdentite != null) || (this.idIdentite != null && !this.idIdentite.equals(other.idIdentite))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.toto.ppp.Identite[ idIdentite=" + idIdentite + " ]";
    }
    
}
