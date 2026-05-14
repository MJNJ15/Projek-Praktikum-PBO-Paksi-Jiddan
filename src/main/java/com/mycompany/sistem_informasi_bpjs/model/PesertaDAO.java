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
                if (null != kelas) switch (kelas) {
                     case "Kelas1" -> peserta = new PesertaKelas1(id, nama, status, kelas, 150000, jumlahIuran);
                     case "Kelas2" -> peserta = new PesertaKelas1(id, nama, status, kelas, 100000, jumlahIuran);
                     case "Kelas3" -> peserta = new PesertaKelas1(id, nama, status, kelas, 50000, jumlahIuran);
                 }
                
                list.add(peserta);
            }  
        } catch(SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        return list;
    }
    
    public boolean insert(Peserta peserta) throws SQLException {
        String idPeserta = peserta.getIdPeserta();
        String namaPeserta = peserta.getNamaPeserta();
        String statusPeserta = peserta.getStatusPeserta();
        String kelasPeserta = peserta.getKelasPeserta();
        String jumlahIuran = peserta.getJumlahIuran();
        
        String sql = "INSERT INTO mahasiswa(id, nama, status, kelas, jumlah_iuran) VALUES('"+ idPeserta +"', '"+ namaPeserta +"', '"+ statusPeserta +"', '"+ kelasPeserta +"', '"+ jumlahIuran +"')";
        try(Connection conn = KoneksiDB.getConnection()) {
               Statement stat = conn.createStatement();
               stat.executeUpdate(sql);
               return true;
        } catch(SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }
    
    public boolean update(Peserta peserta) throws SQLException {
        String idPeserta = peserta.getIdPeserta();
        String namaPeserta = peserta.getNamaPeserta();
        String statusPeserta = peserta.getStatusPeserta();
        String kelasPeserta = peserta.getKelasPeserta();
        String jumlahIuran = peserta.getJumlahIuran();
        
        String sql = "UPDATE mahasiswa SET nama='"+ namaPeserta +"', status='"+ statusPeserta +"', kelas='"+ kelasPeserta +"', jumlah_iuran='"+ jumlahIuran +"' WHERE id='"+ idPeserta;
        try(Connection conn = KoneksiDB.getConnection()) {
               Statement stat = conn.createStatement();
               stat.executeUpdate(sql);
               return true;
        } catch(SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }
}
