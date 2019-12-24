
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
public class BolumDB {
    Connection conn;
    public BolumDB()
    {
        try
        {
            String host = "jdbc:derby://localhost:1527/ProjeV2";
            String uName = "yusuf";
            String uPass = "1234";
            conn = DriverManager.getConnection(host,uName,uPass);
        }
        catch(SQLException err)
        {
            //popup ile uyarı verecek şekilde değiştirilecek
            //şimdilik sadece javaframe de yapabiliyorum
            System.out.println(err.getMessage());
        }
    }
    
    public ArrayList BolumListele()
    {
        ArrayList <ArrayList> bolumler = new ArrayList();
        int i=0;
        try
        {
            Statement stmt = conn.createStatement();
            String SQL = "SELECT * FROM BOLUM";
            ResultSet rs = stmt.executeQuery(SQL);
            while(rs.next())
            {
                bolumler.add(new ArrayList());
                bolumler.get(i).add(rs.getString("ID"));
                bolumler.get(i).add(rs.getString("BOLUM"));
                i++;
            }
        }
        catch(SQLException err)
        {
            //popup ile uyarı verecek şekilde değiştirilecek
            //şimdilik sadece javaframe de yapabiliyorum
            System.out.println(err.getMessage());
        }
        return bolumler;
    }
    
    public ArrayList IliskiliBolumListele(int ID)
    {
        ArrayList <ArrayList> iliskiliBolumler = new ArrayList();
        int i=0;
        try
        {
            Statement stmt = conn.createStatement();
            String SQL = "SELECT FAKULTEBOLUMILISKISI.ID, FAKULTE, FAKULTEBOLUMILISKISI.BOLUM, BOLUM.BOLUM FROM FAKULTEBOLUMILISKISI JOIN BOLUM ON FAKULTEBOLUMILISKISI.BOLUM = BOLUM.ID WHERE FAKULTE="+ID;
            ResultSet rs = stmt.executeQuery(SQL);
            while(rs.next())
            {
                iliskiliBolumler.add(new ArrayList());
                iliskiliBolumler.get(i).add(rs.getString("ID"));
                iliskiliBolumler.get(i).add(rs.getString("BOLUM"));
                iliskiliBolumler.get(i).add(rs.getString(4));
                i++;
            }
        }
        catch(SQLException err)
        {
            //popup ile uyarı verecek şekilde değiştirilecek
            //şimdilik sadece javaframe de yapabiliyorum
            System.out.println(err.getMessage());
        }
        return iliskiliBolumler;
    }
    
    public ArrayList BasibosBolumListele(int ID)
    {
        ArrayList <ArrayList> basibosBolumler = new ArrayList();
        int i=0;
        try
        {
            Statement stmt = conn.createStatement();
            String SQL = "SELECT * FROM FAKULTEBOLUMILISKISI WHERE FAKULTE="+ID;
            ResultSet rs = stmt.executeQuery(SQL);
            while(rs.next())
            {
                basibosBolumler.add(new ArrayList());
                basibosBolumler.get(i).add(rs.getString("ID"));
                basibosBolumler.get(i).add(rs.getString("BOLUM"));
                i++;
            }
        }
        catch(SQLException err)
        {
            //popup ile uyarı verecek şekilde değiştirilecek
            //şimdilik sadece javaframe de yapabiliyorum
            System.out.println(err.getMessage());
        }
        return basibosBolumler;
    }
    
    public ArrayList FakulteListele()
    {
        ArrayList <ArrayList> fakulteler = new ArrayList();
        int i=0;
        try
        {
            Statement stmt = conn.createStatement();
            String SQL = "SELECT * FROM FAKULTE";
            ResultSet rs = stmt.executeQuery(SQL);
            while(rs.next())
            {
                fakulteler.add(new ArrayList());
                fakulteler.get(i).add(rs.getString("ID"));
                fakulteler.get(i).add(rs.getString("FAKULTE"));
                i++;
            }
        }
        catch(SQLException err)
        {
            //popup ile uyarı verecek şekilde değiştirilecek
            //şimdilik sadece javaframe de yapabiliyorum
            System.out.println(err.getMessage());
        }
        return fakulteler;
    }
            
    public void BolumEkle(String bolum)
    {
        try
        {
            Statement stmt = conn.createStatement();
            String SQL = "INSERT INTO BOLUM (BOLUM) VALUES ('"+bolum+"')";
            stmt.executeUpdate(SQL);
        }
        catch(SQLException err)
        {
            //popup ile uyarı verecek şekilde değiştirilecek
            //şimdilik sadece javaframe de yapabiliyorum
            System.out.println(err.getMessage());
        }
    }
    
    public void BolumDuzenle(String bolum,int ID)
    {
        try
        {
            Statement stmt = conn.createStatement();
            String SQL = "UPDATE BOLUM SET BOLUM='"+bolum+"' WHERE ID="+ID;
            stmt.executeUpdate(SQL);
        }
        catch(SQLException err)
        {
            //popup ile uyarı verecek şekilde değiştirilecek
            //şimdilik sadece javaframe de yapabiliyorum
            System.out.println(err.getMessage());
        }
    }
    
    public void BolumSil(int ID)
    {
        try
        {
            Statement stmt = conn.createStatement();
            String SQL = "DELETE FROM BOLUM WHERE ID ="+ID;
            stmt.executeUpdate(SQL);
        }
        catch(SQLException err)
        {
            //popup ile uyarı verecek şekilde değiştirilecek
            //şimdilik sadece javaframe de yapabiliyorum
            System.out.println(err.getMessage());
        }
    }
    
    public void FakulteEkle(String fakulte)
    {
        try
        {
            Statement stmt = conn.createStatement();
            String SQL = "INSERT INTO FAKULTE (FAKULTE) VALUES ('"+fakulte+"')";
            stmt.executeUpdate(SQL);
        }
        catch(SQLException err)
        {
            //popup ile uyarı verecek şekilde değiştirilecek
            //şimdilik sadece javaframe de yapabiliyorum
            System.out.println(err.getMessage());
        }
    }
    
    
    public void FakulteDuzenle(String fakulte,int ID)
    {
        try
        {
            Statement stmt = conn.createStatement();
            String SQL = "UPDATE FAKULTE SET FAKULTE='"+fakulte+"' WHERE ID="+ID;
            stmt.executeUpdate(SQL);
        }
        catch(SQLException err)
        {
            //popup ile uyarı verecek şekilde değiştirilecek
            //şimdilik sadece javaframe de yapabiliyorum
            System.out.println(err.getMessage());
        }
    }
    
    public void FakulteSil(int ID)
    {
        try
        {
            Statement stmt = conn.createStatement();
            String SQL = "DELETE FROM FAKULTE WHERE ID ="+ID;
            stmt.executeUpdate(SQL);
        }
        catch(SQLException err)
        {
            //popup ile uyarı verecek şekilde değiştirilecek
            //şimdilik sadece javaframe de yapabiliyorum
            System.out.println(err.getMessage());
        }
    }
    
    public void Ilıskilendir(int fakulteID,int bolumID)
    {
        try
        {
            Statement stmt = conn.createStatement();
            String SQL = "INSERT INTO FAKULTEBOLUMILISKISI (FAKULTE,BOLUM) VALUES ("+fakulteID+","+bolumID+")";
            stmt.executeUpdate(SQL);
        }
        catch(SQLException err)
        {
            //popup ile uyarı verecek şekilde değiştirilecek
            //şimdilik sadece javaframe de yapabiliyorum
            System.out.println(err.getMessage());
        }
    }
    
    public void IliskiKaldir(int ID)
    {
        try
        {
            Statement stmt = conn.createStatement();
            String SQL = "DELETE FROM FAKULTEBOLUMILISKISI WHERE ID="+ID;
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
