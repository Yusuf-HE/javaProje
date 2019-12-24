
package teslimedilecekproje;

//import java.awt.Image;
import java.sql.* ;
//import javax.swing.ImageIcon;
/**
 * @author yusuf
 */
public class TeslimEdilecekProje {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AnaMenu a = new AnaMenu();
        Ogrenci b = new Ogrenci();
        Ders c = new Ders();
        Bolum d = new Bolum();
        Karne e = new Karne();
        DersSecimi f = new DersSecimi();
        NotGirisi g = new NotGirisi();
        
        //Image im = new ImageIcon("/deneme1.png").getImage();
        //a.setIconImage(im);
        a.setVisible(true);
        a.menuler(b,c,d,e,f,g);
        
        b.anamenu(a);
        
        c.anamenu(a);
        
        d.anamenu(a);
        
        e.anamenu(a);
        
        f.anamenu(a);
        
        g.anamenu(a);
    }
    
}
