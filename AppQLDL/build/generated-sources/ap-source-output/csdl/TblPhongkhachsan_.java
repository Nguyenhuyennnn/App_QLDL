package csdl;

import csdl.TblTour;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-12-08T16:13:44")
@StaticMetamodel(TblPhongkhachsan.class)
public class TblPhongkhachsan_ { 

    public static volatile SingularAttribute<TblPhongkhachsan, Long> maphongks;
    public static volatile CollectionAttribute<TblPhongkhachsan, TblTour> tblTourCollection;
    public static volatile SingularAttribute<TblPhongkhachsan, String> tenks;
    public static volatile SingularAttribute<TblPhongkhachsan, String> loai;
    public static volatile SingularAttribute<TblPhongkhachsan, String> tenphong;
    public static volatile SingularAttribute<TblPhongkhachsan, Float> gia;
    public static volatile SingularAttribute<TblPhongkhachsan, Long> maks;

}