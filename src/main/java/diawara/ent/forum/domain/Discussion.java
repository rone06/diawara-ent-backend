/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diawara.ent.forum.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import diawara.ent.users.domain.Identite;

/**
 *
 * @author adrame
 */
@Entity
@Table(name = "Discussion")
@NamedQueries({
    @NamedQuery(name = "Discussion.findAll", query = "SELECT d FROM Discussion d"),
    @NamedQuery(name = "Discussion.findByIdDiscussion", query = "SELECT d FROM Discussion d WHERE d.idDiscussion = :idDiscussion")})
public class Discussion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDiscussion")
    private Integer idDiscussion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDiscussion")
    private List<Message> messageList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDiscussion")
    private List<Forum> forumList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDiscussion")
    private List<Participant> participantList;
    @JoinColumn(name = "idIdentite", referencedColumnName = "idIdentite")
    @ManyToOne(optional = false)
    private Identite idIdentite;
    @JoinColumn(name = "IdTimestamps", referencedColumnName = "idTimestamps")
    @ManyToOne(optional = false)
    private Timestamps idTimestamps;

    public Discussion() {
    }

    public Discussion(Integer idDiscussion) {
        this.idDiscussion = idDiscussion;
    }

    public Integer getIdDiscussion() {
        return idDiscussion;
    }

    public void setIdDiscussion(Integer idDiscussion) {
        this.idDiscussion = idDiscussion;
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }

    public List<Forum> getForumList() {
        return forumList;
    }

    public void setForumList(List<Forum> forumList) {
        this.forumList = forumList;
    }

    public List<Participant> getParticipantList() {
        return participantList;
    }

    public void setParticipantList(List<Participant> participantList) {
        this.participantList = participantList;
    }

    public Identite getIdIdentite() {
        return idIdentite;
    }

    public void setIdIdentite(Identite idIdentite) {
        this.idIdentite = idIdentite;
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
        hash += (idDiscussion != null ? idDiscussion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Discussion)) {
            return false;
        }
        Discussion other = (Discussion) object;
        if ((this.idDiscussion == null && other.idDiscussion != null) || (this.idDiscussion != null && !this.idDiscussion.equals(other.idDiscussion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.toto.Discussion[ idDiscussion=" + idDiscussion + " ]";
    }
    
}
