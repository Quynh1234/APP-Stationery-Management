/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package baitaplon_buinhuquynh;

/**
 *
 * @author quynh
 */
public class LogIn {
     private String taikhoan, matkhau;
    
    // Phuong thuc
    public LogIn(){
        super();
    }
    public LogIn(String tk, String mk){
        this.taikhoan = tk;
        this.matkhau = mk;
    }
    public String getTaikhoan() {
        return taikhoan;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

}
