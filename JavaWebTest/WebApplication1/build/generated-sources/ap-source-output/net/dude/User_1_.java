package net.dude;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import net.dude.AllCome;
import net.dude.Allstudent;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-07T00:20:39")
@StaticMetamodel(User_1.class)
public class User_1_ { 

    public static volatile SingularAttribute<User_1, String> college;
    public static volatile SingularAttribute<User_1, Allstudent> no;
    public static volatile SingularAttribute<User_1, String> nation;
    public static volatile SingularAttribute<User_1, String> sex;
    public static volatile SingularAttribute<User_1, Integer> photo;
    public static volatile SingularAttribute<User_1, String> userName;
    public static volatile SingularAttribute<User_1, String> password;
    public static volatile SingularAttribute<User_1, String> major;
    public static volatile CollectionAttribute<User_1, AllCome> allComeCollection1;
    public static volatile SingularAttribute<User_1, String> grade;
    public static volatile SingularAttribute<User_1, String> name;
    public static volatile SingularAttribute<User_1, String> information;
    public static volatile SingularAttribute<User_1, Integer> id;
    public static volatile CollectionAttribute<User_1, AllCome> allComeCollection;

}