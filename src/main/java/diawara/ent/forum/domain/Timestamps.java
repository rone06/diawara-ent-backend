/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diawara.ent.forum.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author adrame
 */
@Entity
@Table(name = "timestamps")
@NamedQueries({
    @NamedQuery(name = "Timestamps.findAll", query = "SELECT t FROM Timestamps t"),
    @NamedQuery(name = "Timestamps.findByCreateTime", query = "SELECT t FROM Timestamps t WHERE t.createTime = :createTime"),
    @NamedQuery(name = "Timestamps.findByUpdateTime", query = "SELECT t FROM Timestamps t WHERE t.updateTime = :updateTime"),
    @NamedQuery(name = "Timestamps.findByIdTimestamps", query = "SELECT t FROM Timestamps t WHERE t.idTimestamps = :idTimestamps")})
public class Timestamps implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "create_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Column(name = "update_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTimestamps")
    private Integer idTimestamps;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTimestamps")
    private List<Message> messageList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTimestamps")
    private List<Forum> forumList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTimestamps")
    private List<Discussion> discussionList;

    public Timestamps() {
    }

    public Timestamps(Integer idTimestamps) {
        this.idTimestamps = idTimestamps;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIdTimestamps() {
        return idTimestamps;
    }

    public void setIdTimestamps(Integer idTimestamps) {
        this.idTimestamps = idTimestamps;
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

    public List<Discussion> getDiscussionList() {
        return discussionList;
    }

    public void setDiscussionList(List<Discussion> discussionList) {
        this.discussionList = discussionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTimestamps != null ? idTimestamps.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Timestamps)) {
            return false;
        }
        Timestamps other = (Timestamps) object;
        if ((this.idTimestamps == null && other.idTimestamps != null) || (this.idTimestamps != null && !this.idTimestamps.equals(other.idTimestamps))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.toto.Timestamps[ idTimestamps=" + idTimestamps + " ]";
    }
    
}
