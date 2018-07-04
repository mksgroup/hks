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
@Table(name = "hks_user_role", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"username"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HksUserRole.findAll", query = "SELECT h FROM HksUserRole h")
    , @NamedQuery(name = "HksUserRole.findById", query = "SELECT h FROM HksUserRole h WHERE h.id = :id")
    , @NamedQuery(name = "HksUserRole.findByUsername", query = "SELECT h FROM HksUserRole h WHERE h.username = :username")
    , @NamedQuery(name = "HksUserRole.findByRoleCd", query = "SELECT h FROM HksUserRole h WHERE h.roleCd = :roleCd")
    , @NamedQuery(name = "HksUserRole.findByRoleName", query = "SELECT h FROM HksUserRole h WHERE h.roleName = :roleName")
    , @NamedQuery(name = "HksUserRole.findByEnabled", query = "SELECT h FROM HksUserRole h WHERE h.enabled = :enabled")
    , @NamedQuery(name = "HksUserRole.findByGroupId", query = "SELECT h FROM HksUserRole h WHERE h.groupId = :groupId")
    , @NamedQuery(name = "HksUserRole.findByCreated", query = "SELECT h FROM HksUserRole h WHERE h.created = :created")
    , @NamedQuery(name = "HksUserRole.findByCreatedbyUsername", query = "SELECT h FROM HksUserRole h WHERE h.createdbyUsername = :createdbyUsername")
    , @NamedQuery(name = "HksUserRole.findByLastmodified", query = "SELECT h FROM HksUserRole h WHERE h.lastmodified = :lastmodified")
    , @NamedQuery(name = "HksUserRole.findByLastmodifiedbyUsername", query = "SELECT h FROM HksUserRole h WHERE h.lastmodifiedbyUsername = :lastmodifiedbyUsername")})
public class HksUserRole implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "username", nullable = false, length = 50)
    private String username;
    @Column(name = "role_cd", length = 50)
    private String roleCd;
    @Column(name = "role_name", length = 64)
    private String roleName;
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

    public HksUserRole() {
    }

    public HksUserRole(Integer id) {
        this.id = id;
    }

    public HksUserRole(Integer id, String username, String groupId, Date created, String createdbyUsername) {
        this.id = id;
        this.username = username;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRoleCd() {
        return roleCd;
    }

    public void setRoleCd(String roleCd) {
        this.roleCd = roleCd;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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
        if (!(object instanceof HksUserRole)) {
            return false;
        }
        HksUserRole other = (HksUserRole) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mksgroup.hks.entity.HksUserRole[ id=" + id + " ]";
    }
    
}
