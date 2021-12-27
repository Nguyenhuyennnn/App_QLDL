package csdl;

import csdl.TblNhanvien;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-12-08T16:13:44")
@StaticMetamodel(TblChucvu.class)
public class TblChucvu_ { 

    public static volatile SingularAttribute<TblChucvu, String> tencv;
    public static volatile SingularAttribute<TblChucvu, Long> macv;
    public static volatile SingularAttribute<TblChucvu, Integer> heso;
    public static volatile CollectionAttribute<TblChucvu, TblNhanvien> tblNhanvienCollection;

}