package csdl;

import csdl.TblHoadon;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-12-08T16:13:44")
@StaticMetamodel(TblDattour.class)
public class TblDattour_ { 

    public static volatile SingularAttribute<TblDattour, Long> matour;
    public static volatile SingularAttribute<TblDattour, Long> makh;
    public static volatile SingularAttribute<TblDattour, Date> thoigianbatdau;
    public static volatile SingularAttribute<TblDattour, String> tentour;
    public static volatile SingularAttribute<TblDattour, String> diadiembatdau;
    public static volatile SingularAttribute<TblDattour, String> hotenkh;
    public static volatile SingularAttribute<TblDattour, Long> madattour;
    public static volatile SingularAttribute<TblDattour, String> hotennv;
    public static volatile SingularAttribute<TblDattour, Integer> soluong;
    public static volatile CollectionAttribute<TblDattour, TblHoadon> tblHoadonCollection;
    public static volatile SingularAttribute<TblDattour, Long> manv;

}