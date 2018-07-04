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
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ThachLN
 */
@Entity
@Table(name = "hks_user", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"cd"})
    , @UniqueConstraint(columnNames = {"username"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HksUser.findAll", query = "SELECT h FROM HksUser h")
    , @NamedQuery(name = "HksUser.findById", query = "SELECT h FROM HksUser h WHERE h.id = :id")
    , @NamedQuery(name = "HksUser.findByUsername", query = "SELECT h FROM HksUser h WHERE h.username = :username")
    , @NamedQuery(name = "HksUser.findByCd", query = "SELECT h FROM HksUser h WHERE h.cd = :cd")
    , @NamedQuery(name = "HksUser.findByEmail", query = "SELECT h FROM HksUser h WHERE h.email = :email")
    , @NamedQuery(name = "HksUser.findByFirstname", query = "SELECT h FROM HksUser h WHERE h.firstname = :firstname")
    , @NamedQuery(name = "HksUser.findByLastname", query = "SELECT h FROM HksUser h WHERE h.lastname = :lastname")
    , @NamedQuery(name = "HksUser.findByEnabled", query = "SELECT h FROM HksUser h WHERE h.enabled = :enabled")
    , @NamedQuery(name = "HksUser.findByCreated", query = "SELECT h FROM HksUser h WHERE h.created = :created")
    , @NamedQuery(name = "HksUser.findByCreatedbyUsername", query = "SELECT h FROM HksUser h WHERE h.createdbyUsername = :createdbyUsername")
    , @NamedQuery(name = "HksUser.findByLastmodified", query = "SELECT h FROM HksUser h WHERE h.lastmodified = :lastmodified")
    , @NamedQuery(name = "HksUser.findByLastmodifiedbyUsername", query = "SELECT h FROM HksUser h WHERE h.lastmodifiedbyUsername = :lastmodifiedbyUsername")
    , @NamedQuery(name = "HksUser.findByCanvas", query = "SELECT h FROM HksUser h WHERE h.canvas = :canvas")
    , @NamedQuery(name = "HksUser.findBySide", query = "SELECT h FROM HksUser h WHERE h.side = :side")
    , @NamedQuery(name = "HksUser.findByPositionX", query = "SELECT h FROM HksUser h WHERE h.positionX = :positionX")
    , @NamedQuery(name = "HksUser.findByPositionY", query = "SELECT h FROM HksUser h WHERE h.positionY = :positionY")})
public class HksUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "username", nullable = false, length = 50)
    private String username;
    @Column(name = "cd", length = 16)
    private String cd;
    @Column(name = "email", length = 50)
    private String email;
    @Column(name = "firstname", length = 20)
    private String firstname;
    @Column(name = "lastname", length = 50)
    private String lastname;
    @Lob
    @Column(name = "avatar")
    private byte[] avatar;
    @Column(name = "enabled")
    private Boolean enabled;
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
    @Column(name = "canvas")
    private Boolean canvas;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "side", precision = 22)
    private Double side;
    @Column(name = "position_x", precision = 22)
    private Double positionX;
    @Column(name = "position_y", precision = 22)
    private Double positionY;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "author", fetch = FetchType.LAZY)
    private List<HksItems> hksItemsList;

    public HksUser() {
    }

    public HksUser(Integer id) {
        this.id = id;
    }

    public HksUser(Integer id, String username, Date created, String createdbyUsername) {
        this.id = id;
        this.username = username;
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

    public String getCd() {
        return cd;
    }

    public void setCd(String cd) {
        this.cd = cd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
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

    public Boolean getCanvas() {
        return canvas;
    }

    public void setCanvas(Boolean canvas) {
        this.canvas = canvas;
    }

    public Double getSide() {
        return side;
    }

    public void setSide(Double side) {
        this.side = side;
    }

    public Double getPositionX() {
        return positionX;
    }

    public void setPositionX(Double positionX) {
        this.positionX = positionX;
    }

    public Double getPositionY() {
        return positionY;
    }

    public void setPositionY(Double positionY) {
        this.positionY = positionY;
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
        if (!(object instanceof HksUser)) {
            return false;
        }
        HksUser other = (HksUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mksgroup.hks.entity.HksUser[ id=" + id + " ]";
    }
    
}
