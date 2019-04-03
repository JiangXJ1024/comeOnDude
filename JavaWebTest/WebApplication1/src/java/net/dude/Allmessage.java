/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.dude;

/**
 *
 * @author ASUS
 */
class Allmessage {
    private int FNO;
    private int Num;
    private int FinalNO;
    private int Type;
    private int State;
    private String Releasetime;
    private String Starttime;
    private String Endtime;
    private String Content;
    private String IdNumber;
    
    public String getIdNumber(){
        return IdNumber;
    }
    public void setIdNumber(String IdNumber) {
        this. IdNumber= IdNumber;
    }

    public int getFNO() {
        return FNO;
    }

    public void setFNO(int fno) {
        this.FNO = fno;
    }

    public int getNum(){
        return Num;
    }
    public void setNum(int num) {
        this.Num =num ;
    }
    public int getFinalno() {
        return FinalNO;
    }
    public void setFinalno(int finalno) {
        this. FinalNO= finalno;
    }
    public int getType(){
        return Type;
    }
    public void setType(int type) {
        this. Type= type;
    }
    public int getState() {
        return State;
    }
    public void setState(int state) {
        this. State= state;
    }
    public String getReleasetime(){
        return Releasetime;
    }
    public void setReleasetime(String releasetime) {
        this.Releasetime = releasetime;
    }
    public String getStarttime(){
        return Starttime;
    }
    public void setStarttime(String starttime) {
        this. Starttime= starttime;
    }
    public String getEndtime(){
        return Endtime;
    }
    public void setEndtime(String endtime) {
        this.Endtime = endtime;
    }
    public String getContent(){
        return Content;
    }
    public void setContent(String content) {
        this. Content= content;
    }
}
