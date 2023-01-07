package com.praktikan.responsipmob;

public class Mahasiswa {

    private String NIM;
    private String nama;
    private String id;
    private char Kelas;
    private String Prodi;

    public char getKelas() {
        return Kelas;
    }

    public void setKelas(char kelas) {
        Kelas = kelas;
    }

    public String getProdi() {
        return Prodi;
    }

    public void setProdi(String prodi) {
        Prodi = prodi;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNIM() {
        return NIM;
    }

    public void setNIM(String NIM) {
        this.NIM = NIM;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
