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
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ThachLN
 */
@Entity
@Table(name = "hks_role", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"cd"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HksRole.findAll", query = "SELECT h FROM HksRole h")
    , @NamedQuery(name = "HksRole.findById", query = "SELECT h FROM HksRole h WHERE h.id = :id")
    , @NamedQuery(name = "HksRole.findByCd", query = "SELECT h FROM HksRole h WHERE h.cd = :cd")
    , @NamedQuery(name = "HksRole.findByName", query = "SELECT h FROM HksRole h WHERE h.name = :name")
    , @NamedQuery(name = "HksRole.findByRoleType", query = "SELECT h FROM HksRole h WHERE h.roleType = :roleType")
    , @NamedQuery(name = "HksRole.findByRoleTypeName", query = "SELECT h FROM HksRole h WHERE h.roleTypeName = :roleTypeName")
    , @NamedQuery(name = "HksRole.findByEnabled", query = "SELECT h FROM HksRole h WHERE h.enabled = :enabled")
    , @NamedQuery(name = "HksRole.findByGroupId", query = "SELECT h FROM HksRole h WHERE h.groupId = :groupId")
    , @NamedQuery(name = "HksRole.findByCreated", query = "SELECT h FROM HksRole h WHERE h.created = :created")
    , @NamedQuery(name = "HksRole.findByCreatedbyUsername", query = "SELECT h FROM HksRole h WHERE h.createdbyUsername = :createdbyUsername")
    , @NamedQuery(name = "HksRole.findByLastmodified", query = "SELECT h FROM HksRole h WHERE h.lastmodified = :lastmodified")
    , @NamedQuery(name = "HksRole.findByLastmodifiedbyUsername", query = "SELECT h FROM HksRole h WHERE h.lastmodifiedbyUsername = :lastmodifiedbyUsername")})
public class HksRole implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "cd", nullable = false, length = 32)
    private String cd;
    @Column(name = "name", length = 64)
    private String name;
    @Basic(optional = false)
    @Column(name = "role_type", nullable = false, length = 10)
    private String roleType;
    @Basic(optional = false)
    @Column(name = "role_type_name", nullable = false, length = 200)
    private String roleTypeName;
    @Column(name = "enabled")
    private Boolean enabled;
    @Basic(optional = false)
    @Column(name = "group_id", nullable = false, length = 20)
    private String groupId;
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

    public HksRole() {
    }

    public HksRole(Integer id) {
        this.id = id;
    }

    public HksRole(Integer id, String cd, String roleType, String roleTypeName, String groupId, Date created, String createdbyUsername) {
        this.id = id;
        this.cd = cd;
        this.roleType = roleType;
        this.roleTypeName = roleTypeName;
        this.groupId = groupId;
        this.created = created;
        this.createdbyUsername = createdbyUsername;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCd() {
        return cd;
    }

    public void setCd(String cd) {
        this.cd = cd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public String getRoleTypeName() {
        return roleTypeName;
    }

    public void setRoleTypeName(String roleTypeName) {
        this.roleTypeName = roleTypeName;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
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
        if (!(object instanceof HksRole)) {
            return false;
        }
        HksRole other = (HksRole) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mksgroup.hks.entity.HksRole[ id=" + id + " ]";
    }
    
}
