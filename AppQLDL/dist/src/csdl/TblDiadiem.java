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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "tbl_diadiem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblDiadiem.findAll", query = "SELECT t FROM TblDiadiem t")
    , @NamedQuery(name = "TblDiadiem.findByMadd", query = "SELECT t FROM TblDiadiem t WHERE t.madd = :madd")
    , @NamedQuery(name = "TblDiadiem.findByTendd", query = "SELECT t FROM TblDiadiem t WHERE t.tendd = :tendd")})
public class TblDiadiem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MADD")
    private Long madd;
    @Basic(optional = false)
    @Column(name = "TENDD")
    private String tendd;
    @JoinColumn(name = "MATINH", referencedColumnName = "MATINH")
    @ManyToOne(optional = false)
    private Long matinh;
    private String tentinh;

    public String getTentinh() {
        return tentinh;
    }

    public void setTentinh(String tentinh) {
        this.tentinh = tentinh;
    }
    public TblDiadiem() {
    }

    public TblDiadiem(Long madd) {
        this.madd = madd;
    }

    public TblDiadiem(Long madd, String tendd) {
        this.madd = madd;
        this.tendd = tendd;
    }

    public Long getMadd() {
        return madd;
    }

    public void setMadd(Long madd) {
        this.madd = madd;
    }

    public String getTendd() {
        return tendd;
    }

    public void setTendd(String tendd) {
        this.tendd = tendd;
    }

    public Long getMatinh() {
        return matinh;
    }

    public void setMatinh(Long matinh) {
        this.matinh = matinh;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (madd != null ? madd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblDiadiem)) {
            return false;
        }
        TblDiadiem other = (TblDiadiem) object;
        if ((this.madd == null && other.madd != null) || (this.madd != null && !this.madd.equals(other.madd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "csdl.TblDiadiem[ madd=" + madd + " ]";
    }
    
}
