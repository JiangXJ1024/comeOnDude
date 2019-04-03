/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.dude;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User_1.findAll", query = "SELECT u FROM User_1 u")
    , @NamedQuery(name = "User_1.findById", query = "SELECT u FROM User_1 u WHERE u.id = :id")
    , @NamedQuery(name = "User_1.findByPhoto", query = "SELECT u FROM User_1 u WHERE u.photo = :photo")
    , @NamedQuery(name = "User_1.findByUserName", query = "SELECT u FROM User_1 u WHERE u.userName = :userName")
    , @NamedQuery(name = "User_1.findByPassword", query = "SELECT u FROM User_1 u WHERE u.password = :password")
    , @NamedQuery(name = "User_1.findByName", query = "SELECT u FROM User_1 u WHERE u.name = :name")
    , @NamedQuery(name = "User_1.findBySex", query = "SELECT u FROM User_1 u WHERE u.sex = :sex")
    , @NamedQuery(name = "User_1.findByNation", query = "SELECT u FROM User_1 u WHERE u.nation = :nation")
    , @NamedQuery(name = "User_1.findByGrade", query = "SELECT u FROM User_1 u WHERE u.grade = :grade")
    , @NamedQuery(name = "User_1.findByMajor", query = "SELECT u FROM User_1 u WHERE u.major = :major")
    , @NamedQuery(name = "User_1.findByCollege", query = "SELECT u FROM User_1 u WHERE u.college = :college")
    , @NamedQuery(name = "User_1.findByInformation", query = "SELECT u FROM User_1 u WHERE u.information = :information")})
public class User_1  {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Photo")
    private int photo;
    @Column(name = "UserName")
    private String userName;
    @Column(name = "Password")
    private String password;
    @Column(name = "Name")
    private String name;
    @Column(name = "Sex")
    private String sex;
    @Column(name = "Nation")
    private String nation;
    @Column(name = "Grade")
    private String grade;
    @Column(name = "Major")
    private String major;
    @Column(name = "College")
    private String college;
    @Column(name = "Information")
    private String information;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "firstNo")
    private Collection<AllCome> allComeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "finalNo")
    private Collection<AllCome> allComeCollection1;
    @JoinColumn(name = "No", referencedColumnName = "No")
    @ManyToOne(optional = false)
    private Allstudent no;

    public User_1() {
    }

    public User_1(Integer id) {
        this.id = id;
    }

    public User_1(Integer id, int photo) {
        this.id = id;
        this.photo = photo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

//    @XmlTransient
//    public Collection<AllCome> getAllComeCollection() {
//        return allComeCollection;
//    }
//
//    public void setAllComeCollection(Collection<AllCome> allComeCollection) {
//        this.allComeCollection = allComeCollection;
//    }
//
//    @XmlTransient
//    public Collection<AllCome> getAllComeCollection1() {
//        return allComeCollection1;
//    }
//
//    public void setAllComeCollection1(Collection<AllCome> allComeCollection1) {
//        this.allComeCollection1 = allComeCollection1;
//    }

    public Allstudent getNo() {
        return no;
    }

    public void setNo(Allstudent no) {
        this.no = no;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User_1)) {
            return false;
        }
        User_1 other = (User_1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.dude.User_1[ id=" + id + " ]";
    }
    
}
