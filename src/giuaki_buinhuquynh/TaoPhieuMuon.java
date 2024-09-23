/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package giuaki_buinhuquynh;

/**
 *
 * @author quynh
 */
public class TaoPhieuMuon {
        private String txtID, txtmaBD, txtmaSach, txtngayMuon;
       private int txtsoLuong;
       
       public TaoPhieuMuon(){
           
       }

    public TaoPhieuMuon(String txtID, String txtmaBD, String txtmaSach, String txtngayMuon, int txtsoLuong) {
        this.txtID = txtID;
        this.txtmaBD = txtmaBD;
        this.txtmaSach = txtmaSach;
        this.txtngayMuon = txtngayMuon;
        this.txtsoLuong = txtsoLuong;
    }

    public String getTxtID() {
        return txtID;
    }

    public String getTxtmaBD() {
        return txtmaBD;
    }

    public String getTxtmaSach() {
        return txtmaSach;
    }

    public String getTxtngayMuon() {
        return txtngayMuon;
    }

    public int getTxtsoLuong() {
        return txtsoLuong;
    }

    public void setTxtID(String txtID) {
        this.txtID = txtID;
    }

    public void setTxtmaBD(String txtmaBD) {
        this.txtmaBD = txtmaBD;
    }

    public void setTxtmaSach(String txtmaSach) {
        this.txtmaSach = txtmaSach;
    }

    public void setTxtngayMuon(String txtngayMuon) {
        this.txtngayMuon = txtngayMuon;
    }

    public void setTxtsoLuong(int txtsoLuong) {
        this.txtsoLuong = txtsoLuong;
    }
       
       
}
