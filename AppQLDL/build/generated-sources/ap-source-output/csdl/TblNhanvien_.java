package csdl;

import csdl.TblAdmin;
import csdl.TblChitietdiemdanh;
import csdl.TblChitiettinhluong;
import csdl.TblDattour;
import csdl.TblHoadon;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-12-08T16:13:44")
@StaticMetamodel(TblNhanvien.class)
public class TblNhanvien_ { 

    public static volatile SingularAttribute<TblNhanvien, String> sdt;
    public static volatile SingularAttribute<TblNhanvien, String> tenCV;
    public static volatile SingularAttribute<TblNhanvien, String> gioitinh;
    public static volatile SingularAttribute<TblNhanvien, Long> maptc;
    public static volatile CollectionAttribute<TblNhanvien, TblDattour> tblDattourCollection;
    public static volatile SingularAttribute<TblNhanvien, Date> ngayvaolam;
    public static volatile SingularAttribute<TblNhanvien, Date> ngaysinh;
    public static volatile SingularAttribute<TblNhanvien, String> cmnd;
    public static volatile SingularAttribute<TblNhanvien, Long> manv;
    public static volatile CollectionAttribute<TblNhanvien, TblHoadon> tblHoadonCollection;
    public static volatile SingularAttribute<TblNhanvien, String> diachi;
    public static volatile CollectionAttribute<TblNhanvien, TblChitietdiemdanh> tblChitietdiemdanhCollection;
    public static volatile SingularAttribute<TblNhanvien, String> hinhanh;
    public static volatile CollectionAttribute<TblNhanvien, TblChitiettinhluong> tblChitiettinhluongCollection;
    public static volatile SingularAttribute<TblNhanvien, Long> macv;
    public static volatile SingularAttribute<TblNhanvien, String> tenPTC;
    public static volatile CollectionAttribute<TblNhanvien, TblAdmin> tblAdminCollection;
    public static volatile SingularAttribute<TblNhanvien, String> hotennv;

}