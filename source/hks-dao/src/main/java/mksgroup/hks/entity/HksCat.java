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
@Table(name = "hks_cat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HksCat.findAll", query = "SELECT h FROM HksCat h")
    , @NamedQuery(name = "HksCat.findById", query = "SELECT h FROM HksCat h WHERE h.id = :id")
    , @NamedQuery(name = "HksCat.findByName", query = "SELECT h FROM HksCat h WHERE h.name = :name")
    , @NamedQuery(name = "HksCat.findByParentId", query = "SELECT h FROM HksCat h WHERE h.parentId = :parentId")
    , @NamedQuery(name = "HksCat.findByCreated", query = "SELECT h FROM HksCat h WHERE h.created = :created")
    , @NamedQuery(name = "HksCat.findByCreatedbyUsername", query = "SELECT h FROM HksCat h WHERE h.createdbyUsername = :createdbyUsername")
    , @NamedQuery(name = "HksCat.findByLastmodified", query = "SELECT h FROM HksCat h WHERE h.lastmodified = :lastmodified")
    , @NamedQuery(name = "HksCat.findByLastmodifiedbyUsername", query = "SELECT h FROM HksCat h WHERE h.lastmodifiedbyUsername = :lastmodifiedbyUsername")})
public class HksCat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Column(name = "parent_id")
    private Integer parentId;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cat", fetch = FetchType.LAZY)
    private List<HksItems> hksItemsList;

    public HksCat() {
    }

    public HksCat(Integer id) {
        this.id = id;
    }

    public HksCat(Integer id, String name, Date created, String createdbyUsername) {
        this.id = id;
        this.name = name;
        this.created = created;
        this.createdbyUsername = createdbyUsername;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
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
        if (!(object instanceof HksCat)) {
            return false;
        }
        HksCat other = (HksCat) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mksgroup.hks.entity.HksCat[ id=" + id + " ]";
    }
    
}
