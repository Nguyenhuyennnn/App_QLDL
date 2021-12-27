package csdl;

import csdl.TblNhanvien;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-12-08T16:13:44")
@StaticMetamodel(TblPhongtochuc.class)
public class TblPhongtochuc_ { 

    public static volatile SingularAttribute<TblPhongtochuc, String> truongphong;
    public static volatile SingularAttribute<TblPhongtochuc, Long> maptc;
    public static volatile SingularAttribute<TblPhongtochuc, String> tenptc;
    public static volatile CollectionAttribute<TblPhongtochuc, TblNhanvien> tblNhanvienCollection;

}