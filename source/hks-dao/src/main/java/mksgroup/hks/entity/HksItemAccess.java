/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mksgroup.hks.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ThachLN
 */
@Entity
@Table(name = "hks_item_access")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HksItemAccess.findAll", query = "SELECT h FROM HksItemAccess h")
    , @NamedQuery(name = "HksItemAccess.findById", query = "SELECT h FROM HksItemAccess h WHERE h.id = :id")
    , @NamedQuery(name = "HksItemAccess.findByAction", query = "SELECT h FROM HksItemAccess h WHERE h.action = :action")
    , @NamedQuery(name = "HksItemAccess.findByCreated", query = "SELECT h FROM HksItemAccess h WHERE h.created = :created")
    , @NamedQuery(name = "HksItemAccess.findByCreatedbyUsername", query = "SELECT h FROM HksItemAccess h WHERE h.createdbyUsername = :createdbyUsername")
    , @NamedQuery(name = "HksItemAccess.findByLastmodified", query = "SELECT h FROM HksItemAccess h WHERE h.lastmodified = :lastmodified")
    , @NamedQuery(name = "HksItemAccess.findByLastmodifiedbyUsername", query = "SELECT h FROM HksItemAccess h WHERE h.lastmodifiedbyUsername = :lastmodifiedbyUsername")})
public class HksItemAccess implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "action", nullable = false)
    private int action;
    @Basic(optional = false)
    @Column(name = "created", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Basic(optional = false)
    @Column(name = "createdby_username", nullable = false, length = 50)
    private String createdbyUsername;
    @Column(name = "lastmodified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastmodified;
    @Column(name = "lastmodifiedby_username", length = 50)
    private String lastmodifiedbyUsername;

    public HksItemAccess() {
    }

    public HksItemAccess(Integer id) {
        this.id = id;
    }

    public HksItemAccess(Integer id, int action, Date created, String createdbyUsername) {
        this.id = id;
        this.action = action;
        this.created = created;
        this.createdbyUsername = createdbyUsername;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getCreatedbyUsername() {
        return createdbyUsername;
    }

    public void setCreatedbyUsername(String createdbyUsername) {
        this.createdbyUsername = createdbyUsername;
    }

    public Date getLastmodified() {
        return lastmodified;
    }

    public void setLastmodified(Date lastmodified) {
        this.lastmodified = lastmodified;
    }

    public String getLastmodifiedbyUsername() {
        return lastmodifiedbyUsername;
    }

    public void setLastmodifiedbyUsername(String lastmodifiedbyUsername) {
        this.lastmodifiedbyUsername = lastmodifiedbyUsername;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HksItemAccess)) {
            return false;
        }
        HksItemAccess other = (HksItemAccess) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mksgroup.hks.entity.HksItemAccess[ id=" + id + " ]";
    }
    
}
