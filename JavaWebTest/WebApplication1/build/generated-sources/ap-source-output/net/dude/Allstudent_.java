package net.dude;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import net.dude.User_1;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-03T19:04:36")
@StaticMetamodel(Allstudent.class)
public class Allstudent_ { 

    public static volatile SingularAttribute<Allstudent, String> college;
    public static volatile SingularAttribute<Allstudent, Integer> no;
    public static volatile SingularAttribute<Allstudent, String> major;
    public static volatile SingularAttribute<Allstudent, String> nation;
    public static volatile SingularAttribute<Allstudent, String> sex;
    public static volatile SingularAttribute<Allstudent, String> grade;
    public static volatile CollectionAttribute<Allstudent, User_1> userCollection;
    public static volatile SingularAttribute<Allstudent, String> name;
    public static volatile SingularAttribute<Allstudent, String> iDnumber;
    public static volatile SingularAttribute<Allstudent, Integer> id;
    public static volatile SingularAttribute<Allstudent, Integer> state;

}