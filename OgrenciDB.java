
package teslimedilecekproje;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author yusuf
 */
public class OgrenciDB extends FakulteBolumDoldur{
    
    @Override
    public void Sil(int ID) {
        try
        {
            Statement stmt = conn.createStatement();
            String SQL = "DELETE FROM OGRENCI WHERE ID ="+ID;
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
    public ArrayList Listele() {
        ArrayList <ArrayList> ogrenciler = new ArrayList();
        int i=0;
        try
        {
            Statement stmt = conn.createStatement();
            String SQL = "SELECT OGRENCI.ID, ISIM, SOYISIM, FAKULTE.FAKULTE, BOLUM.BOLUM, LISANS FROM OGRENCI "
                    + "JOIN FAKULTE ON OGRENCI.FAKULTE = FAKULTE.ID "
                    + "JOIN BOLUM ON OGRENCI.BOLUM = BOLUM.ID";
            ResultSet rs = stmt.executeQuery(SQL);
            while(rs.next())
            {
                ogrenciler.add(new ArrayList());
                ogrenciler.get(i).add(rs.getString("ID"));
                ogrenciler.get(i).add(rs.getString("ISIM"));
                ogrenciler.get(i).add(rs.getString("SOYISIM"));
                ogrenciler.get(i).add(rs.getString("FAKULTE"));
                ogrenciler.get(i).add(rs.getString("BOLUM"));
                ogrenciler.get(i).add(rs.getString("LISANS"));
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
        int lisans;
        if(veri.get(4).equals(true))
        {
            lisans=2;
        }
        else
        {
            lisans=4;
        }
        try
        {
            Statement stmt = conn.createStatement();
            String SQL = "INSERT INTO OGRENCI (ISIM, SOYISIM, FAKULTE, BOLUM, LISANS, SINIF) VALUES ('"+veri.get(0)+"','"+veri.get(1)+"',"+veri.get(2)+","+veri.get(3)+","+lisans+", 1)";
            stmt.executeUpdate(SQL);
        }
        catch(Exception err)
        {
            //popup ile uyarı verecek şekilde değiştirilecek
            //şimdilik sadece javaframe de yapabiliyorum
            System.out.println(err.getMessage());
        }
    }

    @Override
    public void Duzenle(ArrayList veri) {
        int lisans;
        if(veri.get(5).equals(true))
        {
            lisans=2;
        }
        else
        {
            lisans=4;
        }
        
        try
        {
            Statement stmt = conn.createStatement();
            String SQL = "UPDATE OGRENCI SET ISIM='"+veri.get(1)+"', SOYISIM='"+veri.get(2)+"', FAKULTE="+veri.get(3)+", BOLUM="+veri.get(4)+", LISANS="+lisans+" WHERE ID="+veri.get(0);
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
