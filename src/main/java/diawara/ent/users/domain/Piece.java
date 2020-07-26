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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author adrame
 */
@Entity
@Table(name = "Piece")
@NamedQueries({
    @NamedQuery(name = "Piece.findAll", query = "SELECT p FROM Piece p")})
public class Piece implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idPiece")
    private Integer idPiece;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "path")
    private String path;
    @Size(max = 45)
    @Column(name = "extension")
    private String extension;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPiece", fetch = FetchType.LAZY)
    private List<Message> messageList;

    public Piece() {
    }

    public Piece(Integer idPiece) {
        this.idPiece = idPiece;
    }

    public Piece(Integer idPiece, String path) {
        this.idPiece = idPiece;
        this.path = path;
    }

    public Integer getIdPiece() {
        return idPiece;
    }

    public void setIdPiece(Integer idPiece) {
        this.idPiece = idPiece;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPiece != null ? idPiece.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Piece)) {
            return false;
        }
        Piece other = (Piece) object;
        if ((this.idPiece == null && other.idPiece != null) || (this.idPiece != null && !this.idPiece.equals(other.idPiece))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.toto.ppp.Piece[ idPiece=" + idPiece + " ]";
    }
    
}
