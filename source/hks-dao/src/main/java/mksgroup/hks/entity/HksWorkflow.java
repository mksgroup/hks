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
@Table(name = "hks_workflow")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HksWorkflow.findAll", query = "SELECT h FROM HksWorkflow h")
    , @NamedQuery(name = "HksWorkflow.findById", query = "SELECT h FROM HksWorkflow h WHERE h.id = :id")
    , @NamedQuery(name = "HksWorkflow.findBySeqNo", query = "SELECT h FROM HksWorkflow h WHERE h.seqNo = :seqNo")
    , @NamedQuery(name = "HksWorkflow.findByClassName", query = "SELECT h FROM HksWorkflow h WHERE h.className = :className")
    , @NamedQuery(name = "HksWorkflow.findByCurrentStatus", query = "SELECT h FROM HksWorkflow h WHERE h.currentStatus = :currentStatus")
    , @NamedQuery(name = "HksWorkflow.findByNextStatus", query = "SELECT h FROM HksWorkflow h WHERE h.nextStatus = :nextStatus")
    , @NamedQuery(name = "HksWorkflow.findByNextObjectType", query = "SELECT h FROM HksWorkflow h WHERE h.nextObjectType = :nextObjectType")
    , @NamedQuery(name = "HksWorkflow.findByRole", query = "SELECT h FROM HksWorkflow h WHERE h.role = :role")
    , @NamedQuery(name = "HksWorkflow.findByCreated", query = "SELECT h FROM HksWorkflow h WHERE h.created = :created")
    , @NamedQuery(name = "HksWorkflow.findByCreatedbyUsername", query = "SELECT h FROM HksWorkflow h WHERE h.createdbyUsername = :createdbyUsername")
    , @NamedQuery(name = "HksWorkflow.findByLastmodified", query = "SELECT h FROM HksWorkflow h WHERE h.lastmodified = :lastmodified")
    , @NamedQuery(name = "HksWorkflow.findByLastmodifiedbyUsername", query = "SELECT h FROM HksWorkflow h WHERE h.lastmodifiedbyUsername = :lastmodifiedbyUsername")})
public class HksWorkflow implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "seq_no", nullable = false)
    private int seqNo;
    @Basic(optional = false)
    @Column(name = "class_name", nullable = false, length = 128)
    private String className;
    @Column(name = "current_status", length = 32)
    private String currentStatus;
    @Column(name = "next_status", length = 32)
    private String nextStatus;
    @Column(name = "next_object_type", length = 128)
    private String nextObjectType;
    @Column(name = "role", length = 32)
    private String role;
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

    public HksWorkflow() {
    }

    public HksWorkflow(Integer id) {
        this.id = id;
    }

    public HksWorkflow(Integer id, int seqNo, String className, Date created, String createdbyUsername) {
        this.id = id;
        this.seqNo = seqNo;
        this.className = className;
        this.created = created;
        this.createdbyUsername = createdbyUsername;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(int seqNo) {
        this.seqNo = seqNo;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public String getNextStatus() {
        return nextStatus;
    }

    public void setNextStatus(String nextStatus) {
        this.nextStatus = nextStatus;
    }

    public String getNextObjectType() {
        return nextObjectType;
    }

    public void setNextObjectType(String nextObjectType) {
        this.nextObjectType = nextObjectType;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
        if (!(object instanceof HksWorkflow)) {
            return false;
        }
        HksWorkflow other = (HksWorkflow) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mksgroup.hks.entity.HksWorkflow[ id=" + id + " ]";
    }
    
}
