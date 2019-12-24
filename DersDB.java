
package teslimedilecekproje;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author yusuf
 */
public class DersDB extends FakulteBolumDoldur{
    
    @Override
    public ArrayList Listele()
    {
        ArrayList <ArrayList> dersler = new ArrayList();
        int i=0;
        try
        {
            Statement stmt = conn.createStatement();
            String SQL = "SELECT DERSLER.ID, DERSADI, FAKULTE.FAKULTE, BOLUM.BOLUM, "
                    + "SINIF, VIZEDEGER, FINALDEGER, DERSLER.FAKULTE AS FA, DERSLER.BOLUM AS BA"
                    + " FROM DERSLER JOIN FAKULTE ON DERSLER.FAKULTE = FAKULTE.ID"
                    + " JOIN BOLUM ON DERSLER.BOLUM = BOLUM.ID";
            ResultSet rs = stmt.executeQuery(SQL);
            while(rs.next())
            {
                dersler.add(new ArrayList());
                dersler.get(i).add(rs.getString("ID"));
                dersler.get(i).add(rs.getString("DERSADI"));
                dersler.get(i).add(rs.getString("FAKULTE"));
                dersler.get(i).add(rs.getString("BOLUM"));
                dersler.get(i).add(rs.getString("SINIF"));
                dersler.get(i).add(rs.getString("VIZEDEGER"));
                dersler.get(i).add(rs.getString("FINALDEGER"));
                dersler.get(i).add(rs.getString("FA"));
                dersler.get(i).add(rs.getString("BA"));
                i++;
            }
        }
        catch(SQLException err)
        {
            //popup ile uyarı verecek şekilde değiştirilecek
            //şimdilik sadece javaframe de yapabiliyorum
            System.out.println(err.getMessage());
        }
        return dersler;
        
    }
    
    @Override
    public void Ekle(ArrayList veri)
    {
        try
        {
            Statement stmt = conn.createStatement();
            String SQL = "INSERT INTO DERSLER (DERSADI, FAKULTE, BOLUM, SINIF, VIZEDEGER, FINALDEGER) VALUES ('"+veri.get(0)+"',"+veri.get(1)+","+veri.get(2)+","+veri.get(3)+","+veri.get(4)+","+veri.get(5)+")";
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
    public void Duzenle(ArrayList veri)
    {
        try
        {
            Statement stmt = conn.createStatement();
            String SQL = "UPDATE DERSLER SET DERSADI='"+veri.get(1)+"', FAKULTE="+veri.get(2)+", BOLUM="+veri.get(3)+", SINIF="+veri.get(4)+", VIZEDEGER="+veri.get(5)+", FINALDEGER="+veri.get(6)+" WHERE ID="+veri.get(0);
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
    public void Sil(int ID)
    {
        try
        {
            Statement stmt = conn.createStatement();
            String SQL = "DELETE FROM DERSLER WHERE ID ="+ID;
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
