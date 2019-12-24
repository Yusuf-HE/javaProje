
package teslimedilecekproje;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author yusuf
 */
public class KarneDB extends AbstractDB{

    @Override
    public ArrayList Listele() {
        ArrayList <ArrayList> dersleri = new ArrayList();
        
        int i=0;
        try
        {
            Statement stmt = conn.createStatement();
            String SQL = "SELECT DERSADI, VIZEPUAN, FINALPUAN, SECENKISI, VIZEDEGER, FINALDEGER FROM SECILENDERSLER"
                    + " JOIN DERSLER ON DERS = DERSLER.ID";
            ResultSet rs = stmt.executeQuery(SQL);
            while(rs.next())
            {
                dersleri.add(new ArrayList());
                dersleri.get(i).add(rs.getString("DERSADI"));
                dersleri.get(i).add(rs.getString("VIZEPUAN"));
                dersleri.get(i).add(rs.getString("FINALPUAN"));
                dersleri.get(i).add(rs.getString("SECENKISI"));
                dersleri.get(i).add(rs.getString("VIZEDEGER"));
                dersleri.get(i).add(rs.getString("FINALDEGER"));
                i++;
            }
        }
        catch(SQLException err)
        {
            //popup ile uyarı verecek şekilde değiştirilecek
            //şimdilik sadece javaframe de yapabiliyorum
            System.out.println(err.getMessage());
        }
        return dersleri;
    }
    
    public ArrayList ogrenciler()
    {
        ArrayList <ArrayList> ogrenciler = new ArrayList<>();
        int i=0;
        try
        {
            Statement stmt = conn.createStatement();
            String SQL = "SELECT ID, ISIM FROM OGRENCI";
            ResultSet rs = stmt.executeQuery(SQL);
            while(rs.next())
            {
                ogrenciler.add(new ArrayList());
                ogrenciler.get(i).add(rs.getString("ID"));
                ogrenciler.get(i).add(rs.getString("ISIM"));
                i++;
            }
        }
        catch(SQLException err)
        {
            //popup ile uyarı verecek şekilde değiştirilecek
            //şimdilik sadece javaframe de yapabiliyorum
            System.out.println(err.getMessage());
        }
        return ogrenciler;
    }

    @Override
    public void Ekle(ArrayList veri) {
        //gereksiz alanlar
    }

    @Override
    public void Duzenle(ArrayList veri) {
        //gereksiz alanlar
    }

    @Override
    public void Sil(int ID) {
        //gereksiz alanlar
    }
    
}
