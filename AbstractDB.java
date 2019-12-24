
package teslimedilecekproje;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author yusuf
 */
public abstract class AbstractDB {
    Connection conn;
    public AbstractDB()
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
    
    public abstract ArrayList Listele();
    
    public abstract void Ekle(ArrayList veri);
    
    public abstract void Duzenle(ArrayList veri);
    
    public abstract void Sil(int ID);

}
