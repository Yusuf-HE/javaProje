/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teslimedilecekproje;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author yusuf
 */
public class DersSecimiDB extends AbstractDB{

    @Override
    public ArrayList Listele() {
        ArrayList <ArrayList> ogrenci = new ArrayList();
        int i=0;
        try
        {
            Statement stmt = conn.createStatement();
            String SQL = "SELECT ID, ISIM, FAKULTE, BOLUM, SINIF FROM OGRENCI";
            ResultSet rs = stmt.executeQuery(SQL);
            while(rs.next())
            {
                ogrenci.add(new ArrayList());
                ogrenci.get(i).add(rs.getString("ID"));
                ogrenci.get(i).add(rs.getString("ISIM"));
                ogrenci.get(i).add(rs.getString("FAKULTE"));
                ogrenci.get(i).add(rs.getString("BOLUM"));
                ogrenci.get(i).add(rs.getString("SINIF"));
                i++;
            }
        }
        catch(SQLException err)
        {
            //popup ile uyarı verecek şekilde değiştirilecek
            //şimdilik sadece javaframe de yapabiliyorum
            System.out.println(err.getMessage());
        }
        return ogrenci;
    }
    
    public ArrayList Dersler(){
        ArrayList <ArrayList> ders = new ArrayList();
        int i=0;
        try
        {
            Statement stmt = conn.createStatement();
            String SQL = "SELECT ID, DERSADI, FAKULTE, BOLUM FROM DERSLER";
            ResultSet rs = stmt.executeQuery(SQL);
            while(rs.next())
            {
                ders.add(new ArrayList());
                ders.get(i).add(rs.getString("ID"));
                ders.get(i).add(rs.getString("DERSADI"));
                ders.get(i).add(rs.getString("FAKULTE"));
                ders.get(i).add(rs.getString("BOLUM"));
                i++;
            }
        }
        catch(SQLException err)
        {
            //popup ile uyarı verecek şekilde değiştirilecek
            //şimdilik sadece javaframe de yapabiliyorum
            System.out.println(err.getMessage());
        }
        return ders;
    }
    
    public ArrayList AlınanDersler(){
        ArrayList <ArrayList> ders = new ArrayList();
        int i=0;
        try
        {
            Statement stmt = conn.createStatement();
            String SQL = "SELECT SECILENDERSLER.ID, DERSLER.ID AS DERSID, OGRENCI.ID AS OGRID , ISIM, OGRENCI.SINIF, DERSADI "
                    + "FROM SECILENDERSLER JOIN DERSLER ON SECILENDERSLER.DERS = DERSLER.ID "
                    + "JOIN OGRENCI ON SECENKISI = OGRENCI.ID";
            ResultSet rs = stmt.executeQuery(SQL);
            while(rs.next())
            {
                ders.add(new ArrayList());
                ders.get(i).add(rs.getString("ID"));
                ders.get(i).add(rs.getString("DERSID"));
                ders.get(i).add(rs.getString("OGRID"));
                ders.get(i).add(rs.getString("ISIM"));
                ders.get(i).add(rs.getString("SINIF"));
                ders.get(i).add(rs.getString("DERSADI"));
                i++;
            }
        }
        catch(SQLException err)
        {
            //popup ile uyarı verecek şekilde değiştirilecek
            //şimdilik sadece javaframe de yapabiliyorum
            System.out.println(err.getMessage());
        }
        return ders;
    }

    @Override
    public void Ekle(ArrayList veri) {
        try
        {
            Statement stmt = conn.createStatement();
            String SQL = "INSERT INTO SECILENDERSLER (DERS, SECENKISI) VALUES ("+veri.get(1)+","+veri.get(0)+")";
            stmt.executeUpdate(SQL);
        }
        catch(SQLException err)
        {
            //popup ile uyarı verecek şekilde değiştirilecek
            //şimdilik sadece javaframe de yapabiliyorum
            System.out.println(err.getMessage());
        }
    }

    @Override
    public void Duzenle(ArrayList veri) {
        try
        {
            Statement stmt = conn.createStatement();
            String SQL = "UPDATE OGRENCI SET SINIF="+veri.get(1)+" WHERE ID="+veri.get(0);
            stmt.executeUpdate(SQL);
        }
        catch(SQLException err)
        {
            //popup ile uyarı verecek şekilde değiştirilecek
            //şimdilik sadece javaframe de yapabiliyorum
            System.out.println(err.getMessage());
        }
    }

    @Override
    public void Sil(int ID) {
        try
        {
            Statement stmt = conn.createStatement();
            String SQL = "DELETE FROM SECILENDERSLER WHERE ID ="+ID;
            stmt.executeUpdate(SQL);
        }
        catch(SQLException err)
        {
            //popup ile uyarı verecek şekilde değiştirilecek
            //şimdilik sadece javaframe de yapabiliyorum
            System.out.println(err.getMessage());
        }
    }
    
}
