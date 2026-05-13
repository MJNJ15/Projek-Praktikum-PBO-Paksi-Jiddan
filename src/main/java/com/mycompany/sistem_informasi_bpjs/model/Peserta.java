/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistem_informasi_bpjs.model;

/**
 *
 * @author MJNJ
 */
abstract class Peserta {
    
    private String idPeserta;
    private String namaPeserta;
    private String statusPeserta;
    private String kelasPeserta;
    private int  iuranBulanan;
    private String jumlahIuran;

    public Peserta(String idPeserta, String namaPeserta, String statusPeserta, String kelasPeserta, int iuranBulanan, String jumlahIuran) {
        this.idPeserta = idPeserta;
        this.namaPeserta = namaPeserta;
        this.statusPeserta = statusPeserta;
        this.kelasPeserta = kelasPeserta;
        this.iuranBulanan = iuranBulanan;
        this.jumlahIuran = jumlahIuran;
    }

    public String getJumlahIuran() {
        return jumlahIuran;
    }

    public void setJumlahIuran(String jumlahIuran) {
        this.jumlahIuran = jumlahIuran;
    }

    public int getIuranBulanan() {
        return iuranBulanan;
    }

    public void setIuranBulanan(int iuranBulanan) {
        this.iuranBulanan = iuranBulanan;
    }

    public String getKelasPeserta() {
        return kelasPeserta;
    }

    public void setKelasPeserta(String kelasPeserta) {
        this.kelasPeserta = kelasPeserta;
    }

    public String getStatusPeserta() {
        return statusPeserta;
    }

    public void setStatusPeserta(String statusPeserta) {
        this.statusPeserta = statusPeserta;
    }

    public String getNamaPeserta() {
        return namaPeserta;
    }

    public void setNamaPeserta(String namaPeserta) {
        this.namaPeserta = namaPeserta;
    }

    public String getIdPeserta() {
        return idPeserta;
    }

    public void setIdPeserta(String idPeserta) {
        this.idPeserta = idPeserta;
    }
}
