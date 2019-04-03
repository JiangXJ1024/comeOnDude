/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.dude;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "all_come")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AllCome.findAll", query = "SELECT a FROM AllCome a")
    , @NamedQuery(name = "AllCome.findById", query = "SELECT a FROM AllCome a WHERE a.id = :id")
    , @NamedQuery(name = "AllCome.findByNumber", query = "SELECT a FROM AllCome a WHERE a.number = :number")
    , @NamedQuery(name = "AllCome.findByType", query = "SELECT a FROM AllCome a WHERE a.type = :type")
    , @NamedQuery(name = "AllCome.findByState", query = "SELECT a FROM AllCome a WHERE a.state = :state")
    , @NamedQuery(name = "AllCome.findByLastTime", query = "SELECT a FROM AllCome a WHERE a.lastTime = :lastTime")
    , @NamedQuery(name = "AllCome.findByStartTime", query = "SELECT a FROM AllCome a WHERE a.startTime = :startTime")
    , @NamedQuery(name = "AllCome.findByEndTime", query = "SELECT a FROM AllCome a WHERE a.endTime = :endTime")})
public class AllCome implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Number")
    private int number;
    @Basic(optional = false)
    @Column(name = "type")
    private int type;
    @Basic(optional = false)
    @Column(name = "State")
    private int state;
    @Basic(optional = false)
    @Column(name = "LastTime")
    private String lastTime;
    @Column(name = "StartTime")
    private String startTime;
    @Column(name = "EndTime")
    private String endTime;
    @Lob
    @Column(name = "Content")
    private String content;
    @JoinColumn(name = "FirstNo", referencedColumnName = "No")
    @ManyToOne(optional = false)
    private User_1 firstNo;
    @JoinColumn(name = "FinalNo", referencedColumnName = "No")
    @ManyToOne(optional = false)
    private User_1 finalNo;

    public AllCome() {
    }

    public AllCome(Integer id) {
        this.id = id;
    }

    public AllCome(Integer id, int number, int type, int state, String lastTime) {
        this.id = id;
        this.number = number;
        this.type = type;
        this.state = state;
        this.lastTime = lastTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getLastTime() {
        return lastTime;
    }

    public void setLastTime(String lastTime) {
        this.lastTime = lastTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User_1 getFirstNo() {
        return firstNo;
    }

    public void setFirstNo(User_1 firstNo) {
        this.firstNo = firstNo;
    }

    public User_1 getFinalNo() {
        return finalNo;
    }

    public void setFinalNo(User_1 finalNo) {
        this.finalNo = finalNo;
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
        if (!(object instanceof AllCome)) {
            return false;
        }
        AllCome other = (AllCome) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.dude.AllCome[ id=" + id + " ]";
    }
    
}
