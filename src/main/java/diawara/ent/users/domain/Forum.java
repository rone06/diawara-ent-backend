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
@Table(name = "Forum")
@NamedQueries({
    @NamedQuery(name = "Forum.findAll", query = "SELECT f FROM Forum f")})
public class Forum implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idForum")
    private Integer idForum;
    @Size(max = 45)
    @Column(name = "nomforum")
    private String nomforum;
    @JoinColumn(name = "idDiscussion", referencedColumnName = "idDiscussion")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Discussion idDiscussion;
    @JoinColumn(name = "idTimestamps", referencedColumnName = "idTimestamps")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Timestamps idTimestamps;

    public Forum() {
    }

    public Forum(Integer idForum) {
        this.idForum = idForum;
    }

    public Integer getIdForum() {
        return idForum;
    }

    public void setIdForum(Integer idForum) {
        this.idForum = idForum;
    }

    public String getNomforum() {
        return nomforum;
    }

    public void setNomforum(String nomforum) {
        this.nomforum = nomforum;
    }

    public Discussion getIdDiscussion() {
        return idDiscussion;
    }

    public void setIdDiscussion(Discussion idDiscussion) {
        this.idDiscussion = idDiscussion;
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
        hash += (idForum != null ? idForum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Forum)) {
            return false;
        }
        Forum other = (Forum) object;
        if ((this.idForum == null && other.idForum != null) || (this.idForum != null && !this.idForum.equals(other.idForum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.toto.ppp.Forum[ idForum=" + idForum + " ]";
    }
    
}
