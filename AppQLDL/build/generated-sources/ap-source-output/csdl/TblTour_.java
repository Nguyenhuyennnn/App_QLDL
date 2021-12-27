package csdl;

import csdl.TblDattour;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-12-08T16:13:44")
@StaticMetamodel(TblTour.class)
public class TblTour_ { 

    public static volatile SingularAttribute<TblTour, Long> matour;
    public static volatile SingularAttribute<TblTour, String> tentour;
    public static volatile SingularAttribute<TblTour, String> ghichu;
    public static volatile CollectionAttribute<TblTour, TblDattour> tblDattourCollection;
    public static volatile SingularAttribute<TblTour, String> diadiem;
    public static volatile SingularAttribute<TblTour, Date> thoigian;
    public static volatile SingularAttribute<TblTour, Long> maphuongtien;
    public static volatile SingularAttribute<TblTour, String> tenphongks;
    public static volatile SingularAttribute<TblTour, Long> maphongks;
    public static volatile SingularAttribute<TblTour, String> tenpt;
    public static volatile SingularAttribute<TblTour, Long> madv;
    public static volatile SingularAttribute<TblTour, String> tendv;
    public static volatile SingularAttribute<TblTour, Float> gia;

}