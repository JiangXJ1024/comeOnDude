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
@Table(name = "allstudent")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Allstudent.findAll", query = "SELECT a FROM Allstudent a")
    , @NamedQuery(name = "Allstudent.findById", query = "SELECT a FROM Allstudent a WHERE a.id = :id")
    , @NamedQuery(name = "Allstudent.findByNo", query = "SELECT a FROM Allstudent a WHERE a.no = :no")
    , @NamedQuery(name = "Allstudent.findByState", query = "SELECT a FROM Allstudent a WHERE a.state = :state")
    , @NamedQuery(name = "Allstudent.findByName", query = "SELECT a FROM Allstudent a WHERE a.name = :name")
    , @NamedQuery(name = "Allstudent.findBySex", query = "SELECT a FROM Allstudent a WHERE a.sex = :sex")
    , @NamedQuery(name = "Allstudent.findByIDnumber", query = "SELECT a FROM Allstudent a WHERE a.iDnumber = :iDnumber")
    , @NamedQuery(name = "Allstudent.findByNation", query = "SELECT a FROM Allstudent a WHERE a.nation = :nation")
    , @NamedQuery(name = "Allstudent.findByGrade", query = "SELECT a FROM Allstudent a WHERE a.grade = :grade")
    , @NamedQuery(name = "Allstudent.findByMajor", query = "SELECT a FROM Allstudent a WHERE a.major = :major")
    , @NamedQuery(name = "Allstudent.findByCollege", query = "SELECT a FROM Allstudent a WHERE a.college = :college")})
public class Allstudent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "No")
    private int no;
    @Basic(optional = false)
    @Column(name = "State")
    private int state;
    @Column(name = "Name")
    private String name;
    @Column(name = "Sex")
    private String sex;
    @Column(name = "IDnumber")
    private String iDnumber;
    @Basic(optional = false)
    @Column(name = "Nation")
    private String nation;
    @Basic(optional = false)
    @Column(name = "Grade")
    private String grade;
    @Basic(optional = false)
    @Column(name = "Major")
    private String major;
    @Basic(optional = false)
    @Column(name = "College")
    private String college;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "no")
    private Collection<User_1> userCollection;

    public Allstudent() {
    }

    public Allstudent(Integer id) {
        this.id = id;
    }

    public Allstudent(Integer id, int no, int state, String nation, String grade, String major, String college) {
        this.id = id;
        this.no = no;
        this.state = state;
        this.nation = nation;
        this.grade = grade;
        this.major = major;
        this.college = college;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
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

    public String getIDnumber() {
        return iDnumber;
    }

    public void setIDnumber(String iDnumber) {
        this.iDnumber = iDnumber;
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

    @XmlTransient
    public Collection<User_1> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Collection<User_1> userCollection) {
        this.userCollection = userCollection;
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
        if (!(object instanceof Allstudent)) {
            return false;
        }
        Allstudent other = (Allstudent) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.dude.Allstudent[ id=" + id + " ]";
    }
    
}
