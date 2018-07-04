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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "hks_items")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HksItems.findAll", query = "SELECT h FROM HksItems h")
    , @NamedQuery(name = "HksItems.findById", query = "SELECT h FROM HksItems h WHERE h.id = :id")
    , @NamedQuery(name = "HksItems.findByCatId", query = "SELECT h FROM HksItems h WHERE h.catId = :catId")
    , @NamedQuery(name = "HksItems.findByTitle", query = "SELECT h FROM HksItems h WHERE h.title = :title")
    , @NamedQuery(name = "HksItems.findByShortDesc", query = "SELECT h FROM HksItems h WHERE h.shortDesc = :shortDesc")
    , @NamedQuery(name = "HksItems.findByDesc", query = "SELECT h FROM HksItems h WHERE h.desc = :desc")
    , @NamedQuery(name = "HksItems.findByStatusId", query = "SELECT h FROM HksItems h WHERE h.statusId = :statusId")
    , @NamedQuery(name = "HksItems.findByAuthorUsername", query = "SELECT h FROM HksItems h WHERE h.authorUsername = :authorUsername")
    , @NamedQuery(name = "HksItems.findByViews", query = "SELECT h FROM HksItems h WHERE h.views = :views")
    , @NamedQuery(name = "HksItems.findByLikes", query = "SELECT h FROM HksItems h WHERE h.likes = :likes")
    , @NamedQuery(name = "HksItems.findByDownloads", query = "SELECT h FROM HksItems h WHERE h.downloads = :downloads")
    , @NamedQuery(name = "HksItems.findByComments", query = "SELECT h FROM HksItems h WHERE h.comments = :comments")
    , @NamedQuery(name = "HksItems.findByCreated", query = "SELECT h FROM HksItems h WHERE h.created = :created")
    , @NamedQuery(name = "HksItems.findByCreatedbyUsername", query = "SELECT h FROM HksItems h WHERE h.createdbyUsername = :createdbyUsername")
    , @NamedQuery(name = "HksItems.findByLastmodified", query = "SELECT h FROM HksItems h WHERE h.lastmodified = :lastmodified")
    , @NamedQuery(name = "HksItems.findByLastmodifiedbyUsername", query = "SELECT h FROM HksItems h WHERE h.lastmodifiedbyUsername = :lastmodifiedbyUsername")})
public class HksItems implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "cat_id", nullable = false)
    private int catId;
    @Lob
    @Column(name = "image")
    private byte[] image;
    @Basic(optional = false)
    @Column(name = "title", nullable = false, length = 512)
    private String title;
    @Column(name = "short_desc", length = 1024)
    private String shortDesc;
    @Column(name = "desc", length = 4000)
    private String desc;
    @Column(name = "status_id")
    private Integer statusId;
    @Basic(optional = false)
    @Column(name = "author_username", nullable = false, length = 128)
    private String authorUsername;
    @Basic(optional = false)
    @Column(name = "views", nullable = false)
    private int views;
    @Basic(optional = false)
    @Column(name = "likes", nullable = false)
    private int likes;
    @Basic(optional = false)
    @Column(name = "downloads", nullable = false)
    private int downloads;
    @Basic(optional = false)
    @Column(name = "comments", nullable = false)
    private int comments;
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
    @JoinColumn(name = "author", referencedColumnName = "username", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private HksUser author;
    @JoinColumn(name = "cat", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private HksCat cat;
    @JoinColumn(name = "status", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private HksStatusObject status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "item", fetch = FetchType.LAZY)
    private List<HksAttachFile> hksAttachFileList;

    public HksItems() {
    }

    public HksItems(Integer id) {
        this.id = id;
    }

    public HksItems(Integer id, int catId, String title, String authorUsername, int views, int likes, int downloads, int comments, Date created, String createdbyUsername) {
        this.id = id;
        this.catId = catId;
        this.title = title;
        this.authorUsername = authorUsername;
        this.views = views;
        this.likes = likes;
        this.downloads = downloads;
        this.comments = comments;
        this.created = created;
        this.createdbyUsername = createdbyUsername;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public String getAuthorUsername() {
        return authorUsername;
    }

    public void setAuthorUsername(String authorUsername) {
        this.authorUsername = authorUsername;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDownloads() {
        return downloads;
    }

    public void setDownloads(int downloads) {
        this.downloads = downloads;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
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

    public HksUser getAuthor() {
        return author;
    }

    public void setAuthor(HksUser author) {
        this.author = author;
    }

    public HksCat getCat() {
        return cat;
    }

    public void setCat(HksCat cat) {
        this.cat = cat;
    }

    public HksStatusObject getStatus() {
        return status;
    }

    public void setStatus(HksStatusObject status) {
        this.status = status;
    }

    @XmlTransient
    public List<HksAttachFile> getHksAttachFileList() {
        return hksAttachFileList;
    }

    public void setHksAttachFileList(List<HksAttachFile> hksAttachFileList) {
        this.hksAttachFileList = hksAttachFileList;
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
        if (!(object instanceof HksItems)) {
            return false;
        }
        HksItems other = (HksItems) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mksgroup.hks.entity.HksItems[ id=" + id + " ]";
    }
    
}
