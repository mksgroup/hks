/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mksgroup.hks.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ThachLN
 */
@Entity
@Table(name = "hks_status_object")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HksStatusObject.findAll", query = "SELECT h FROM HksStatusObject h")
    , @NamedQuery(name = "HksStatusObject.findById", query = "SELECT h FROM HksStatusObject h WHERE h.id = :id")
    , @NamedQuery(name = "HksStatusObject.findByClassName", query = "SELECT h FROM HksStatusObject h WHERE h.className = :className")
    , @NamedQuery(name = "HksStatusObject.findByObjectId", query = "SELECT h FROM HksStatusObject h WHERE h.objectId = :objectId")
    , @NamedQuery(name = "HksStatusObject.findByPreviousStatus", query = "SELECT h FROM HksStatusObject h WHERE h.previousStatus = :previousStatus")
    , @NamedQuery(name = "HksStatusObject.findByCurrentStatus", query = "SELECT h FROM HksStatusObject h WHERE h.currentStatus = :currentStatus")
    , @NamedQuery(name = "HksStatusObject.findByCreated", query = "SELECT h FROM HksStatusObject h WHERE h.created = :created")
    , @NamedQuery(name = "HksStatusObject.findByCreatedbyUsername", query = "SELECT h FROM HksStatusObject h WHERE h.createdbyUsername = :createdbyUsername")
    , @NamedQuery(name = "HksStatusObject.findByLastmodified", query = "SELECT h FROM HksStatusObject h WHERE h.lastmodified = :lastmodified")
    , @NamedQuery(name = "HksStatusObject.findByLastmodifiedbyUsername", query = "SELECT h FROM HksStatusObject h WHERE h.lastmodifiedbyUsername = :lastmodifiedbyUsername")})
public class HksStatusObject implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "class_name", nullable = false, length = 128)
    private String className;
    @Basic(optional = false)
    @Column(name = "object_id", nullable = false)
    private int objectId;
    @Column(name = "previous_status", length = 32)
    private String previousStatus;
    @Column(name = "current_status", length = 32)
    private String currentStatus;
    @Lob
    @Column(name = "comment", length = 65535)
    private String comment;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "status", fetch = FetchType.LAZY)
    private List<HksItems> hksItemsList;

    public HksStatusObject() {
    }

    public HksStatusObject(Integer id) {
        this.id = id;
    }

    public HksStatusObject(Integer id, String className, int objectId, Date created, String createdbyUsername) {
        this.id = id;
        this.className = className;
        this.objectId = objectId;
        this.created = created;
        this.createdbyUsername = createdbyUsername;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getObjectId() {
        return objectId;
    }

    public void setObjectId(int objectId) {
        this.objectId = objectId;
    }

    public String getPreviousStatus() {
        return previousStatus;
    }

    public void setPreviousStatus(String previousStatus) {
        this.previousStatus = previousStatus;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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

    @XmlTransient
    public List<HksItems> getHksItemsList() {
        return hksItemsList;
    }

    public void setHksItemsList(List<HksItems> hksItemsList) {
        this.hksItemsList = hksItemsList;
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
        if (!(object instanceof HksStatusObject)) {
            return false;
        }
        HksStatusObject other = (HksStatusObject) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mksgroup.hks.entity.HksStatusObject[ id=" + id + " ]";
    }
    
}
