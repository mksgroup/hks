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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "hks_attach_file")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HksAttachFile.findAll", query = "SELECT h FROM HksAttachFile h")
    , @NamedQuery(name = "HksAttachFile.findById", query = "SELECT h FROM HksAttachFile h WHERE h.id = :id")
    , @NamedQuery(name = "HksAttachFile.findByItemId", query = "SELECT h FROM HksAttachFile h WHERE h.itemId = :itemId")
    , @NamedQuery(name = "HksAttachFile.findByName", query = "SELECT h FROM HksAttachFile h WHERE h.name = :name")
    , @NamedQuery(name = "HksAttachFile.findByCreated", query = "SELECT h FROM HksAttachFile h WHERE h.created = :created")
    , @NamedQuery(name = "HksAttachFile.findByCreatedbyUsername", query = "SELECT h FROM HksAttachFile h WHERE h.createdbyUsername = :createdbyUsername")
    , @NamedQuery(name = "HksAttachFile.findByLastmodified", query = "SELECT h FROM HksAttachFile h WHERE h.lastmodified = :lastmodified")
    , @NamedQuery(name = "HksAttachFile.findByLastmodifiedbyUsername", query = "SELECT h FROM HksAttachFile h WHERE h.lastmodifiedbyUsername = :lastmodifiedbyUsername")})
public class HksAttachFile implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "item_id", nullable = false)
    private int itemId;
    @Basic(optional = false)
    @Lob
    @Column(name = "content", nullable = false)
    private byte[] content;
    @Column(name = "name", length = 512)
    private String name;
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
    @JoinColumn(name = "item", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private HksItems item;

    public HksAttachFile() {
    }

    public HksAttachFile(Integer id) {
        this.id = id;
    }

    public HksAttachFile(Integer id, int itemId, byte[] content, Date created, String createdbyUsername) {
        this.id = id;
        this.itemId = itemId;
        this.content = content;
        this.created = created;
        this.createdbyUsername = createdbyUsername;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public HksItems getItem() {
        return item;
    }

    public void setItem(HksItems item) {
        this.item = item;
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
        if (!(object instanceof HksAttachFile)) {
            return false;
        }
        HksAttachFile other = (HksAttachFile) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mksgroup.hks.entity.HksAttachFile[ id=" + id + " ]";
    }
    
}
