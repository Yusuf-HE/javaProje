
package teslimedilecekproje;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author yusuf
 */
public abstract class FakulteBolumDoldur extends AbstractDB{
    
    public ArrayList BolumListele(int ID)
    {
        ArrayList <ArrayList> bolumler = new ArrayList();
        int i=0;
        try
        {
            Statement stmt = conn.createStatement();
            String SQL = "SELECT FAKULTEBOLUMILISKISI.BOLUM, BOLUM.BOLUM FROM FAKULTEBOLUMILISKISI JOIN BOLUM ON FAKULTEBOLUMILISKISI.BOLUM = BOLUM.ID WHERE FAKULTEBOLUMILISKISI.FAKULTE="+ID;
            ResultSet rs = stmt.executeQuery(SQL);
            while(rs.next())
            {
                bolumler.add(new ArrayList());
                bolumler.get(i).add(rs.getString(1));
                bolumler.get(i).add(rs.getString(2));
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
}
