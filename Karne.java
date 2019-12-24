
package teslimedilecekproje;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 * @author yusuf
 */
public class Karne extends javax.swing.JFrame {
    KarneDB karne = new KarneDB();
    ArrayList <ArrayList> dersler = new ArrayList();
    ArrayList <ArrayList> ogrenciler = new ArrayList();
    DefaultTableModel model;
    int ID;
    
    AnaMenu a;
    /**
     * Creates new form Karne
     */
    public Karne() {
        initComponents();
        setTitle("Karne(Not Dökümü)");
        setLocation(500, 200);
        
        dersler = karne.Listele();
        ogrenciler = karne.ogrenciler();
        model = (DefaultTableModel) jTable1.getModel();
        ComboBox1Yenile();
        TabloYenile();
    }
    
    public void ComboBox1Yenile()
    {
        jComboBox1.removeAllItems();
        for(ArrayList ders:ogrenciler)
        {
            jComboBox1.addItem(new ComboItem(ders.get(1).toString(), ders.get(0).toString()));
        }
        jComboBox1.setSelectedIndex(-1);
    }
    
    public String HarfNotu(Object deger1,Object deger2,Object deger3,Object deger4)
    {
        String sonuc;
        if(deger1 == null || deger3 == null)
        {
            return "";
        }
        else
        {
            float cevap = Float.parseFloat(deger1.toString())*Float.parseFloat(deger2.toString())+Float.parseFloat(deger3.toString())*Float.parseFloat(deger4.toString());
            
            if(cevap>90)
            {
                return "AA";
            }
            else if(cevap>80)
            {
                return "BA";
            }
            else if(cevap>70)
            {
                return "BB";
            }
            else if(cevap>60)
            {
                return "CB";
            }
            else if(cevap>50)
            {
                return "CC";
            }
            else if(cevap>40)
            {
                return "DC";
            }
            else if(cevap>30)
            {
                return "DD";
            }
            else
            {
                return "FF";
            }
        }
    }
    
    public void TabloYenile()
    {
        int sutun = model.getRowCount();
        for(int i=0;i<sutun;i++)
        {
            model.removeRow(model.getRowCount()-1);
        }
        if(ID==-1)
        {
            
        }
        else
        {
            for(ArrayList ders:dersler)
            {
                if(ders.get(3).toString().equals(Integer.toString(ID)))
                {
                    model.addRow(new Object[]{ders.get(0),ders.get(1),ders.get(2),
                        HarfNotu(ders.get(1), ders.get(4), ders.get(2), ders.get(5))});
                }
            }
        }
    }
    
    public void anamenu(AnaMenu a)
    {
        this.a=a;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1İtemStateChanged(evt);
            }
        });

        jButton1.setText("AnaMenü");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ders", "Vize", "Final", "HarfNotu"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 1, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        this.setVisible(false);
        a.setVisible(true);
    }//GEN-LAST:event_jButton1MouseClicked

    private void jComboBox1İtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1İtemStateChanged
        if(jComboBox1.getSelectedItem() == null)
        {
            ID=-1;
        }
        else
        {
            Object item = jComboBox1.getSelectedItem();
            String value = ((ComboItem)item).getValue();
            ID = Integer.parseInt(value);
            TabloYenile();
        }
    }//GEN-LAST:event_jComboBox1İtemStateChanged

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        dersler = karne.Listele();
        ogrenciler = karne.ogrenciler();
        ComboBox1Yenile();
        TabloYenile();
    }//GEN-LAST:event_formWindowActivated

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Karne.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Karne.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Karne.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Karne.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Karne().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<ComboItem> jComboBox1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
