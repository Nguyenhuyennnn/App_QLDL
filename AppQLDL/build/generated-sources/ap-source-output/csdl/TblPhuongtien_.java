package csdl;

import csdl.TblTour;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-12-08T16:13:44")
@StaticMetamodel(TblPhuongtien.class)
public class TblPhuongtien_ { 

    public static volatile SingularAttribute<TblPhuongtien, Long> maphuongtien;
    public static volatile CollectionAttribute<TblPhuongtien, TblTour> tblTourCollection;
    public static volatile SingularAttribute<TblPhuongtien, String> trangthai;
    public static volatile SingularAttribute<TblPhuongtien, String> sdtlienlac;
    public static volatile SingularAttribute<TblPhuongtien, String> loai;
    public static volatile SingularAttribute<TblPhuongtien, String> tenphuongtien;
    public static volatile SingularAttribute<TblPhuongtien, Float> gia;
    public static volatile SingularAttribute<TblPhuongtien, String> tentaixe;

}