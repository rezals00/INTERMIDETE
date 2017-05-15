package com.example.rezab.internediete.model;

/**
 * Created by rezab on 14/05/2017.
 */

public class HomeModel {
    public String Nama;
    public String Alamat;
    public String Email;
    public String no;

    public HomeModel(String nama, String alamat, String email, String no) {
        Nama = nama;
        Alamat = alamat;
        Email = email;
        this.no = no;
    }

    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String alamat) {
        Alamat = alamat;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getNama() {

        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }
}
