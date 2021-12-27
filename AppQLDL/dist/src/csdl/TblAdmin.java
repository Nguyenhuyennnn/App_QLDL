/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csdl;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "tbl_admin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblAdmin.findAll", query = "SELECT t FROM TblAdmin t")
    , @NamedQuery(name = "TblAdmin.findByTaikhoan", query = "SELECT t FROM TblAdmin t WHERE t.taikhoan = :taikhoan")
    , @NamedQuery(name = "TblAdmin.findByQuyen", query = "SELECT t FROM TblAdmin t WHERE t.quyen = :quyen")})
public class TblAdmin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "TAIKHOAN")
    private String taikhoan;
    @Basic(optional = false)
    @Lob
    @Column(name = "MATKHAU")
    private String matkhau;
    @Basic(optional = false)
    @Column(name = "QUYEN")
    private String quyen;
    @Basic(optional = false)
    @Lob
    @Column(name = "HINHANH")
    private String hinhanh;
    @JoinColumn(name = "MANV", referencedColumnName = "MANV")
    @ManyToOne(optional = false)
    private Long manv;
   

    

    public TblAdmin() {
    }

    public TblAdmin(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    public TblAdmin(String taikhoan, String matkhau, String quyen, String hinhanh) {
        this.taikhoan = taikhoan;
        this.matkhau = matkhau;
        this.quyen = quyen;
        this.hinhanh = hinhanh;
    }

    public String getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getQuyen() {
        return quyen;
    }

    public void setQuyen(String quyen) {
        this.quyen = quyen;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public Long getManv() {
        return manv;
    }

    public void setManv(Long manv) {
        this.manv = manv;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taikhoan != null ? taikhoan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblAdmin)) {
            return false;
        }
        TblAdmin other = (TblAdmin) object;
        if ((this.taikhoan == null && other.taikhoan != null) || (this.taikhoan != null && !this.taikhoan.equals(other.taikhoan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "csdl.TblAdmin[ taikhoan=" + taikhoan + " ]";
    }
    
}
