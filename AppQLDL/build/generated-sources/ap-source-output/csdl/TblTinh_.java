package csdl;

import csdl.TblDiadiem;
import csdl.TblKhachsan;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-12-08T16:13:44")
@StaticMetamodel(TblTinh.class)
public class TblTinh_ { 

    public static volatile CollectionAttribute<TblTinh, TblKhachsan> tblKhachsanCollection;
    public static volatile CollectionAttribute<TblTinh, TblDiadiem> tblDiadiemCollection;
    public static volatile SingularAttribute<TblTinh, String> tentinh;
    public static volatile SingularAttribute<TblTinh, Long> matinh;

}