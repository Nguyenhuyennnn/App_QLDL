package csdl;

import csdl.TblPhongkhachsan;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-12-08T16:13:44")
@StaticMetamodel(TblKhachsan.class)
public class TblKhachsan_ { 

    public static volatile SingularAttribute<TblKhachsan, String> diachi;
    public static volatile SingularAttribute<TblKhachsan, String> tenks;
    public static volatile SingularAttribute<TblKhachsan, String> danhgia;
    public static volatile SingularAttribute<TblKhachsan, String> tentinh;
    public static volatile SingularAttribute<TblKhachsan, String> sdtlienhe;
    public static volatile SingularAttribute<TblKhachsan, Long> matinh;
    public static volatile CollectionAttribute<TblKhachsan, TblPhongkhachsan> tblPhongkhachsanCollection;
    public static volatile SingularAttribute<TblKhachsan, Long> maks;

}