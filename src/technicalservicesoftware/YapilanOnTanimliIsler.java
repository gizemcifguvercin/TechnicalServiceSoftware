/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package technicalservicesoftware;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Gizem
 */
public class YapilanOnTanimliIsler extends javax.swing.JFrame {
 private Connection baglanti;
    private ResultSet sonuc;
    private Statement ifade;
    private DatabaseAccessObject dao=new DatabaseAccessObject();
    
    
  private String TCBul(int cihaz_id){
        String sql="SELECT * FROM \"Cihaz\"";
        try {
            baglanti=dao.getBaglanti();
            ifade=baglanti.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            sonuc=ifade.executeQuery(sql);
            while(sonuc.next()){
                if(cihaz_id==sonuc.getInt("cihaz_id")){
                    return sonuc.getString("musteri_tc");
                }
   
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
      
    }
   private int GrupBul(String musteri_tc){
        String sql="SELECT * FROM \"Musteri\"";
        try {
           
            sonuc=ifade.executeQuery(sql);
            while(sonuc.next()){
                if(musteri_tc.equals(sonuc.getString("musteri_tc"))){
                    return sonuc.getInt("musteri_grup_id");
                }
   
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
      
    }
    private int IndirimBul(int grup_id){
        String sql="SELECT * FROM \"MusteriGruplari\"";
        try {
            baglanti=dao.getBaglanti();
            ifade=baglanti.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            sonuc=ifade.executeQuery(sql);
            while(sonuc.next()){
                if(grup_id==sonuc.getInt("grup_id")){
                    return sonuc.getInt("indirim_miktari");
                }
   
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    private double FiyatBul(int on_tanimli_is_id){
        String sql="SELECT * FROM \"OnTanimliIsler\"";
        try {
            baglanti=dao.getBaglanti();
            ifade=baglanti.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            sonuc=ifade.executeQuery(sql);
            while(sonuc.next()){
                if(on_tanimli_is_id==sonuc.getInt("on_tanimli_is_id")){
                    return sonuc.getDouble("on_tanimli_is_ucret");
                }
   
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }


    private void verileriGetir(){
        String sql="SELECT * FROM \"YapilanOnTanimliIsler\"";
        try {
            baglanti=dao.getBaglanti();
            ifade=baglanti.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            sonuc=ifade.executeQuery(sql);
            sonuc.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   private void verileriGoster(){
        txtBosalt();
        if (sonuc!=null){
            try {
                tf_kayit.setText(sonuc.getString("is_id")); 
                tf_kod.setText(sonuc.getString("on_tanimli_is_id"));
                tf_ckod.setText(sonuc.getString("cihaz_id"));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
   }
      public static String now(String dateFormat) 
    {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        return sdf.format(cal.getTime());
    }
    private void txtBosalt(){
        tf_kayit.setText("");
        tf_kod.setText("");
        tf_ckod.setText("");
        tf_tarih.setText("");
        tf_kayit.requestFocus();
    }
    public int kacinciontanimliis(){
            int row=0;
            try {
                baglanti=dao.getBaglanti();
                ifade=baglanti.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
                sonuc=ifade.executeQuery("SELECT * FROM \"YapilanOnTanimliIsler\"");
                if(sonuc!=null){
                    sonuc.last();
                    row=sonuc.getRow();
                    sonuc.beforeFirst(); //imlec basa alınır
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return row;
        }
    private void ilk_islemler(){
        tf_kayit.requestFocus();
        String DateTime = now("dd-MM-yyy");
        tf_tarih.setText(DateTime);
        tf_kayit.setText(String.valueOf(kacinciontanimliis()+1));
        verileriGetir();
    }
  
    public YapilanOnTanimliIsler() {
        initComponents();
        ilk_islemler();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tf_kayit = new javax.swing.JTextField();
        tf_kod = new javax.swing.JTextField();
        tf_ckod = new javax.swing.JTextField();
        tf_tarih = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        tf_ara = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Kayıt Numarası :");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("Ön Tanımlı Satış İşlemleri");

        jButton1.setText("İŞLEMLERE DÖN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Ön Tanımlı İş Kodu :");

        jLabel4.setText("Cihaz Kodu :");

        jLabel5.setText("Satış Tarihi :");

        tf_kayit.setEditable(false);
        tf_kayit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_kayitActionPerformed(evt);
            }
        });

        tf_tarih.setEditable(false);

        jButton2.setText("ONAYLA");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("ARA");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tf_kod, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tf_ara, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jButton3))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tf_tarih, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tf_ckod, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(28, 28, 28)
                            .addComponent(tf_kayit, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jButton1)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_kayit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_kod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_ckod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tf_tarih, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jButton2)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(tf_ara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton3))
                .addContainerGap(79, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_kayitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_kayitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_kayitActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       int id=Integer.parseInt(tf_kayit.getText());
       int kod=Integer.parseInt(tf_kod.getText());
       int ckod=Integer.parseInt(tf_ckod.getText());
       String tarih=tf_tarih.getText();
       String tc;
       int indirim_miktari;
       double db_fiyat;
       double musteriye_ozel_fiyat;
       try {
            
            tc=TCBul(ckod);
            indirim_miktari=IndirimBul(GrupBul(tc));
            db_fiyat=FiyatBul(kod);
            musteriye_ozel_fiyat=(db_fiyat-(db_fiyat*indirim_miktari/100));
            
           ifade=baglanti.createStatement();
                     String sql="INSERT INTO \"YapilanOnTanimliIsler\" VALUES ("+id+","+kod+","+ckod+",'"+tarih+"',"+musteriye_ozel_fiyat+")";
                     ifade.executeUpdate(sql);
            verileriGetir();
            //verileriGoster();
            } catch (SQLException e) {
                  e.printStackTrace();
            
            
        }
       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Islemler islem=new Islemler();
        islem.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int kayitid=Integer.parseInt(tf_ara.getText());
        try {
            int mevcut_satir=sonuc.getRow();
            sonuc.first();
            sonuc.previous();
            int row=0;
            boolean bulundu=false;
            while(sonuc.next()){
                row++;
                if(sonuc.getInt("is_id")==kayitid){
                    bulundu=true;
                    break;
                } 
            }
            if(bulundu){
                sonuc.absolute(row);
                }
            else{
                sonuc.absolute(mevcut_satir);
                       
                }
             verileriGoster();
        }
            catch (SQLException ex) {
        }                       
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(YapilanOnTanimliIsler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(YapilanOnTanimliIsler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(YapilanOnTanimliIsler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(YapilanOnTanimliIsler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new YapilanOnTanimliIsler().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField tf_ara;
    private javax.swing.JTextField tf_ckod;
    private javax.swing.JTextField tf_kayit;
    private javax.swing.JTextField tf_kod;
    private javax.swing.JTextField tf_tarih;
    // End of variables declaration//GEN-END:variables
}
