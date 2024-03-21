/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
/**
 *
 * @author Asus Gk
 */
public class CRUD {
    private Double angka1, angka2, hasil;
    private String operator;
    private Connection koneksi;
    private PreparedStatement psmt;
    private Statement stat;
    private String query;
    
    public CRUD(){
        Koneksi connection = new Koneksi();
        koneksi = connection.getKoneksi();
    }
    
    public void setAngka1(Double angka1){
        this.angka1 = angka1;
    }
    
    public Double getAngka1(){
        return angka1;
    }
    
    public void setAngka2(Double angka2){
        this.angka2 = angka2;
    }
    
    public Double getAngka2(){
        return angka2;
    }
    
    public void setOperator(String operator){
        this.operator = operator;
    }
    
    public String getOperator(){
        return operator;
    }
    
    public void setHasil(Double hasil){
        this.hasil = hasil;
    }
    
    public Double getHasil(){
        return hasil;
    }
    
    public void simpanData(Double angka1, String operator, Double angka2, Double hasil){
        query = "insert into kalku (angka1, operator, angka2, hasil) values (?, ?, ?, ?)";
        
        try{
            psmt = koneksi.prepareStatement(query);
            psmt.setDouble(1, angka1);
            psmt.setString(2, operator);
            psmt.setDouble(3, angka2);
            psmt.setDouble(4, hasil);
            psmt.executeUpdate();
            psmt.close();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
}
