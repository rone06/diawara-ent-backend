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
import javax.validation.constraints.Size;

/**
 *
 * @author adrame
 */
@Entity
@Table(name = "Message")
@NamedQueries({
    @NamedQuery(name = "Message.findAll", query = "SELECT m FROM Message m")})
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMessage")
    private Integer idMessage;
    @Size(max = 1000)
    @Column(name = "texte")
    private String texte;
    @JoinColumn(name = "idDiscussion", referencedColumnName = "idDiscussion")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Discussion idDiscussion;
    @JoinColumn(name = "idIdentite", referencedColumnName = "idIdentite")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Identite emetteur;
    @JoinColumn(name = "idPiece", referencedColumnName = "idPiece")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Piece idPiece;
    @JoinColumn(name = "idTimestamps", referencedColumnName = "idTimestamps")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Timestamps idTimestamps;

    public Message() {
    }

    public Message(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public Discussion getIdDiscussion() {
        return idDiscussion;
    }

    public void setIdDiscussion(Discussion idDiscussion) {
        this.idDiscussion = idDiscussion;
    }

    public Identite getEmetteur() {
        return emetteur;
    }

    public void setEmetteur(Identite emetteur) {
        this.emetteur = emetteur;
    }

    public Piece getIdPiece() {
        return idPiece;
    }

    public void setIdPiece(Piece idPiece) {
        this.idPiece = idPiece;
    }

    public Timestamps getIdTimestamps() {
        return idTimestamps;
    }

    public void setIdTimestamps(Timestamps idTimestamps) {
        this.idTimestamps = idTimestamps;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMessage != null ? idMessage.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Message)) {
            return false;
        }
        Message other = (Message) object;
        if ((this.idMessage == null && other.idMessage != null) || (this.idMessage != null && !this.idMessage.equals(other.idMessage))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.toto.ppp.Message[ idMessage=" + idMessage + " ]";
    }
    
}
