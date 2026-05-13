/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistem_informasi_bpjs.model;

import com.mycompany.sistem_informasi_bpjs.util.KoneksiDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MJNJ
 */
public class PesertaDAO {
    public List<Peserta> getAll() throws SQLException {
        List<Peserta> list = new ArrayList<>();
        String sql = "SELECT id, nama, status, kelas, jumlah_iuran FROM data_mahasiswa";
        
        try (Connection conn = KoneksiDB.getConnection()){
             Statement stat = conn.createStatement();
             ResultSet result = stat.executeQuery(sql); 
            
            while (result.next()) {
                String id = result.getString("id");
                String nama = result.getString("nama");
                String status = result.getString("status");
                String kelas = result.getString("kelas");
                String jumlahIuran = result.getString("jumlahIuran");
                
                Peserta peserta = null;
                if ("Kelas1".equals(kelas)) {
                    peserta = new PesertaKelas1(id, nama, status, kelas, 150000, jumlahIuran);
                } else if ("Kelas2".equals(kelas)) {
                    peserta = new PesertaKelas1(id, nama, status, kelas, 100000, jumlahIuran);
                } else if ("Kelas3".equals(kelas)) {
                    peserta = new PesertaKelas1(id, nama, status, kelas, 50000, jumlahIuran);
                }
                
                list.add(peserta);
            }
            
        } catch ( Exception e) {
            System.out.println(e);
        }
        
        return list;
    }
}
