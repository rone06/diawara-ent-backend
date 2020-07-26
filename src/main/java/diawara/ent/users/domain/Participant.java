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
import javax.persistence.Table;

/**
 *
 * @author adrame
 */
@Entity
@Table(name = "Participant")
@NamedQueries({
    @NamedQuery(name = "Participant.findAll", query = "SELECT p FROM Participant p")})
public class Participant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idParticipant")
    private Integer idParticipant;
    @JoinColumn(name = "idDiscussion", referencedColumnName = "idDiscussion")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Discussion idDiscussion;
    @JoinColumn(name = "idIdentite", referencedColumnName = "idIdentite")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Identite idIdentite;

    public Participant() {
    }

    public Participant(Integer idParticipant) {
        this.idParticipant = idParticipant;
    }

    public Integer getIdParticipant() {
        return idParticipant;
    }

    public void setIdParticipant(Integer idParticipant) {
        this.idParticipant = idParticipant;
    }

    public Discussion getIdDiscussion() {
        return idDiscussion;
    }

    public void setIdDiscussion(Discussion idDiscussion) {
        this.idDiscussion = idDiscussion;
    }

    public Identite getIdIdentite() {
        return idIdentite;
    }

    public void setIdIdentite(Identite idIdentite) {
        this.idIdentite = idIdentite;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idParticipant != null ? idParticipant.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Participant)) {
            return false;
        }
        Participant other = (Participant) object;
        if ((this.idParticipant == null && other.idParticipant != null) || (this.idParticipant != null && !this.idParticipant.equals(other.idParticipant))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.toto.ppp.Participant[ idParticipant=" + idParticipant + " ]";
    }
    
}
