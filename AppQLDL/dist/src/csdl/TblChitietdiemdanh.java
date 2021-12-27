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
@Table(name = "tbl_chitietdiemdanh")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblChitietdiemdanh.findAll", query = "SELECT t FROM TblChitietdiemdanh t")
    , @NamedQuery(name = "TblChitietdiemdanh.findByMasodd", query = "SELECT t FROM TblChitietdiemdanh t WHERE t.tblChitietdiemdanhPK.masodd = :masodd")
    , @NamedQuery(name = "TblChitietdiemdanh.findByManv", query = "SELECT t FROM TblChitietdiemdanh t WHERE t.tblChitietdiemdanhPK.manv = :manv")
    , @NamedQuery(name = "TblChitietdiemdanh.findByNgay", query = "SELECT t FROM TblChitietdiemdanh t WHERE t.tblChitietdiemdanhPK.ngay = :ngay")
    , @NamedQuery(name = "TblChitietdiemdanh.findByGiovao", query = "SELECT t FROM TblChitietdiemdanh t WHERE t.giovao = :giovao")
    , @NamedQuery(name = "TblChitietdiemdanh.findByGiora", query = "SELECT t FROM TblChitietdiemdanh t WHERE t.giora = :giora")
    , @NamedQuery(name = "TblChitietdiemdanh.findByTrangthai", query = "SELECT t FROM TblChitietdiemdanh t WHERE t.trangthai = :trangthai")
    , @NamedQuery(name = "TblChitietdiemdanh.findByGhichu", query = "SELECT t FROM TblChitietdiemdanh t WHERE t.ghichu = :ghichu")})
public class TblChitietdiemdanh implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    @Basic(optional = false)
    @Column(name = "GIOVAO")
    @Temporal(TemporalType.TIME)
    private Date giovao;
    @Basic(optional = false)
    @Column(name = "GIORA")
    @Temporal(TemporalType.TIME)
    private Date giora;
    @Basic(optional = false)
    @Column(name = "TRANGTHAI")
    private String trangthai;
    @Basic(optional = false)
    @Column(name = "GHICHU")
    private String ghichu;
    @JoinColumn(name = "MANV", referencedColumnName = "MANV", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TblNhanvien tblNhanvien;
    private Long madd;
    private Long manv;
    private Date ngay;
    private String hotennv;

    public String getHotennv() {
        return hotennv;
    }

    public void setHotennv(String hotennv) {
        this.hotennv = hotennv;
    }

    public Long getMadd() {
        return madd;
    }

    public void setMadd(Long madd) {
        this.madd = madd;
    }

    public Long getManv() {
        return manv;
    }

    public void setManv(Long manv) {
        this.manv = manv;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }
    
    public TblChitietdiemdanh() {
    }


    public Date getGiovao() {
        return giovao;
    }

    public void setGiovao(Date giovao) {
        this.giovao = giovao;
    }

    public Date getGiora() {
        return giora;
    }

    public void setGiora(Date giora) {
        this.giora = giora;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public TblNhanvien getTblNhanvien() {
        return tblNhanvien;
    }

    public void setTblNhanvien(TblNhanvien tblNhanvien) {
        this.tblNhanvien = tblNhanvien;
    }

}
