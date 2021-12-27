/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csdl;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "tbl_chitiettinhluong")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblChitiettinhluong.findAll", query = "SELECT t FROM TblChitiettinhluong t")
    , @NamedQuery(name = "TblChitiettinhluong.findByMasotinhluong", query = "SELECT t FROM TblChitiettinhluong t WHERE t.tblChitiettinhluongPK.masotinhluong = :masotinhluong")
    , @NamedQuery(name = "TblChitiettinhluong.findByManv", query = "SELECT t FROM TblChitiettinhluong t WHERE t.tblChitiettinhluongPK.manv = :manv")
    , @NamedQuery(name = "TblChitiettinhluong.findByLuongcanban", query = "SELECT t FROM TblChitiettinhluong t WHERE t.luongcanban = :luongcanban")
    , @NamedQuery(name = "TblChitiettinhluong.findBySongaylamviec", query = "SELECT t FROM TblChitiettinhluong t WHERE t.songaylamviec = :songaylamviec")
    , @NamedQuery(name = "TblChitiettinhluong.findByThuong", query = "SELECT t FROM TblChitiettinhluong t WHERE t.thuong = :thuong")
    , @NamedQuery(name = "TblChitiettinhluong.findByPhucap", query = "SELECT t FROM TblChitiettinhluong t WHERE t.phucap = :phucap")
    , @NamedQuery(name = "TblChitiettinhluong.findByTru", query = "SELECT t FROM TblChitiettinhluong t WHERE t.tru = :tru")
    , @NamedQuery(name = "TblChitiettinhluong.findByThue", query = "SELECT t FROM TblChitiettinhluong t WHERE t.thue = :thue")
    , @NamedQuery(name = "TblChitiettinhluong.findByTongluong", query = "SELECT t FROM TblChitiettinhluong t WHERE t.tongluong = :tongluong")
    , @NamedQuery(name = "TblChitiettinhluong.findByNgayphat", query = "SELECT t FROM TblChitiettinhluong t WHERE t.ngayphat = :ngayphat")})
public class TblChitiettinhluong implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
   
    @Basic(optional = false)
    @Column(name = "LUONGCANBAN")
    private float luongcanban;
    @Basic(optional = false)
    @Column(name = "SONGAYLAMVIEC")
    private int songaylamviec;
    @Basic(optional = false)
    @Column(name = "THUONG")
    private float thuong;
    @Basic(optional = false)
    @Column(name = "PHUCAP")
    private float phucap;
    @Basic(optional = false)
    @Column(name = "TRU")
    private float tru;
    @Basic(optional = false)
    @Column(name = "THUE")
    private float thue;
    @Basic(optional = false)
    @Column(name = "TONGLUONG")
    private float tongluong;
    @Basic(optional = false)
    @Column(name = "NGAYPHAT")
    @Temporal(TemporalType.DATE)
    private Date ngayphat;
    @JoinColumn(name = "MANV", referencedColumnName = "MANV", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Long masotinhluong;
    private Long manv;
    private String tennv;

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public Long getManv() {
        return manv;
    }

    public void setManv(Long manv) {
        this.manv = manv;
    }
    public Long getMasotinhluong() {
        return masotinhluong;
    }

    public void setMasotinhluong(Long masotinhluong) {
        this.masotinhluong = masotinhluong;
    }
    public TblChitiettinhluong() {
    }

    public float getLuongcanban() {
        return luongcanban;
    }

    public void setLuongcanban(float luongcanban) {
        this.luongcanban = luongcanban;
    }

    public int getSongaylamviec() {
        return songaylamviec;
    }

    public void setSongaylamviec(int songaylamviec) {
        this.songaylamviec = songaylamviec;
    }

    public float getThuong() {
        return thuong;
    }

    public void setThuong(float thuong) {
        this.thuong = thuong;
    }

    public float getPhucap() {
        return phucap;
    }

    public void setPhucap(float phucap) {
        this.phucap = phucap;
    }

    public float getTru() {
        return tru;
    }

    public void setTru(float tru) {
        this.tru = tru;
    }

    public float getThue() {
        return thue;
    }

    public void setThue(float thue) {
        this.thue = thue;
    }

    public float getTongluong() {
        return tongluong;
    }

    public void setTongluong(float tongluong) {
        this.tongluong = tongluong;
    }

    public Date getNgayphat() {
        return ngayphat;
    }

    public void setNgayphat(Date ngayphat) {
        this.ngayphat = ngayphat;
    }

    

    
}
