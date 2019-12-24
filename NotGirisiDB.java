
package teslimedilecekproje;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author yusuf
 */
public class NotGirisiDB extends AbstractDB{

    @Override
    public ArrayList Listele() {
        ArrayList <ArrayList> secilenDersler = new ArrayList();
        
        int i=0;
        try
        {
            Statement stmt = conn.createStatement();
            String SQL = "SELECT SECILENDERSLER.ID, DERSADI, VIZEPUAN, FINALPUAN, ISIM, SECENKISI FROM SECILENDERSLER"
                    + " JOIN DERSLER ON DERS = DERSLER.ID"
                    + " JOIN OGRENCI ON SECENKISI = OGRENCI.ID";
            ResultSet rs = stmt.executeQuery(SQL);
            while(rs.next())
            {
                secilenDersler.add(new ArrayList());
                secilenDersler.get(i).add(rs.getString("ID"));
                secilenDersler.get(i).add(rs.getString("DERSADI"));
                secilenDersler.get(i).add(rs.getString("VIZEPUAN"));
                secilenDersler.get(i).add(rs.getString("FINALPUAN"));
                secilenDersler.get(i).add(rs.getString("ISIM"));
                secilenDersler.get(i).add(rs.getString("SECENKISI"));
                i++;
            }
        }
        catch(SQLException err)
        {
            //popup ile uyarı verecek şekilde değiştirilecek
            //şimdilik sadece javaframe de yapabiliyorum
            System.out.println(err.getMessage());
        }
        return secilenDersler;
    }
    
    public ArrayList ogrenciler()
    {
        
        ArrayList <ArrayList> ogrenciler = new ArrayList();
        
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
        //Kullanılmayacak alan
    }

    @Override
    public void Duzenle(ArrayList veri) {
        try
        {
            Statement stmt = conn.createStatement();
            String SQL = "UPDATE SECILENDERSLER SET VIZEPUAN="+veri.get(1)+", FINALPUAN="+veri.get(2)+" WHERE ID="+veri.get(0);
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
        //Kullanılmayacak diğer bir alan daha
    }
    
}
