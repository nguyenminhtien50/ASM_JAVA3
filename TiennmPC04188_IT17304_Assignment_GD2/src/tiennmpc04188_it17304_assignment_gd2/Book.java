/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiennmpc04188_it17304_assignment_gd2;

import java.io.Serializable;

public class Book implements Serializable {

    String maSach;
    String tenSach;
    String theLoai;
    String NXB;
    String tacGia;
    int soLuong;
    int giNhap;
 
   

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public String getNXB() {
        return NXB;
    }

    public void setNXB(String NXB) {
        this.NXB = NXB;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getGiNhap() {
        return giNhap;
    }

    public void setGiNhap(int giNhap) {
        this.giNhap = giNhap;
    }





  

 

    public Book(String maSach, String tenSach, String theLoai, String NXB, String tacGia, int soLuong, int giNhap) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.theLoai = theLoai;
        this.NXB = NXB;
        this.tacGia = tacGia;
        this.soLuong = soLuong;
        this.giNhap = giNhap;
        
    
    }

    public Book() {
    }

}
