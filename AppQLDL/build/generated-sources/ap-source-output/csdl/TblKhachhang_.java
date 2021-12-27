package csdl;

import csdl.TblDattour;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-12-08T16:13:44")
@StaticMetamodel(TblKhachhang.class)
public class TblKhachhang_ { 

    public static volatile SingularAttribute<TblKhachhang, String> diachi;
    public static volatile SingularAttribute<TblKhachhang, Long> makh;
    public static volatile SingularAttribute<TblKhachhang, String> sdt;
    public static volatile SingularAttribute<TblKhachhang, String> hinhanh;
    public static volatile SingularAttribute<TblKhachhang, String> gioitinh;
    public static volatile CollectionAttribute<TblKhachhang, TblDattour> tblDattourCollection;
    public static volatile SingularAttribute<TblKhachhang, String> hotenkh;
    public static volatile SingularAttribute<TblKhachhang, String> loai;
    public static volatile SingularAttribute<TblKhachhang, String> cmnd;

}