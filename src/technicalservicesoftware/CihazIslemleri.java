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
import technicalservicesoftware.DatabaseAccessObject;
import technicalservicesoftware.Islemler;

/**
 *
 * @author Gizem
 */
public class CihazIslemleri extends javax.swing.JFrame {

    private Connection baglanti;
    private ResultSet sonuc;
    private Statement ifade;
    private DatabaseAccessObject dao=new DatabaseAccessObject();
    String teknik_default="1"; 

    private void verileriGetir(){
        String sql="SELECT * FROM \"Cihaz\"";
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
                tf_mno.setText(sonuc.getString("musteri_tc")); 
                tf_ad.setText(sonuc.getString("cihaz_adi"));
                tf_model.setText(sonuc.getString("cihaz_modeli"));
                tf_no.setText(sonuc.getString("cihaz_numarasi"));
                tf_kno.setText(sonuc.getString("cihaz_id"));
                

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
        tf_mno.setText("");
        tf_ad.setText("");
        tf_model.setText("");
        tf_no.setText("");
        tf_kno.setText("");
        
    }
    private void ilk_islemler(){
        tf_mno.requestFocus();
        tf_kno.setText(String.valueOf(kacincicihaz()+1));
        verileriGetir();
    }
    public int kacincicihaz(){
            int row=0;
            try {
                baglanti=dao.getBaglanti();
                ifade=baglanti.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
                sonuc=ifade.executeQuery("SELECT * FROM \"Cihaz\"");
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
    public CihazIslemleri() {
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
        tf_ad = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tf_model = new javax.swing.JTextField();
        tf_no = new javax.swing.JTextField();
        tf_kno = new javax.swing.JTextField();
        tf_mno = new javax.swing.JTextField();
        btn_geri = new javax.swing.JButton();
        btn_ara = new javax.swing.JButton();
        btn_kaydet = new javax.swing.JButton();
        btn_sil = new javax.swing.JButton();
        btn_guncelle = new javax.swing.JButton();
        btn_temizle = new javax.swing.JButton();
        btn_ikayit = new javax.swing.JButton();
        btn_skayit = new javax.swing.JButton();
        btn_okayit = new javax.swing.JButton();
        btn_nkayit = new javax.swing.JButton();
        tf_ara = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Cihaz Bilgilerinin Girilmesi");

        jLabel2.setText("Cihaz Adı :");

        jLabel3.setText("Cihaz Modeli :");

        jLabel4.setText("Cihaz Numarası : ");

        jLabel5.setText("Cihaz Kayıt Numarası :");

        jLabel6.setText("Müşteri TC :");

        tf_kno.setEditable(false);

        btn_geri.setText("İŞLEMLERE DÖN");
        btn_geri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_geriActionPerformed(evt);
            }
        });

        btn_ara.setText("ARA");
        btn_ara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_araActionPerformed(evt);
            }
        });

        btn_kaydet.setText("KAYDET");
        btn_kaydet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_kaydetActionPerformed(evt);
            }
        });

        btn_sil.setText("SİL");
        btn_sil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_silActionPerformed(evt);
            }
        });

        btn_guncelle.setText("GÜNCELLE");
        btn_guncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guncelleActionPerformed(evt);
            }
        });

        btn_temizle.setText("YENİ KAYIT");
        btn_temizle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_temizleActionPerformed(evt);
            }
        });

        btn_ikayit.setText("İLK KAYIT");
        btn_ikayit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ikayitActionPerformed(evt);
            }
        });

        btn_skayit.setText("SON KAYIT");
        btn_skayit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_skayitActionPerformed(evt);
            }
        });

        btn_okayit.setText("ÖNCEKİ KAYIT");
        btn_okayit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_okayitActionPerformed(evt);
            }
        });

        btn_nkayit.setText("SONRAKİ KAYIT");
        btn_nkayit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nkayitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_geri))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tf_ara, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(btn_ikayit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                                            .addComponent(btn_kaydet, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btn_skayit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btn_sil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btn_okayit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_guncelle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_ara, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btn_nkayit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_temizle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tf_ad, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tf_model, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tf_no, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tf_kno, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tf_mno, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 63, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btn_geri))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(tf_mno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_ad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(tf_model, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tf_kno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_kaydet)
                    .addComponent(btn_sil)
                    .addComponent(btn_guncelle)
                    .addComponent(btn_temizle))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_okayit)
                    .addComponent(btn_nkayit)
                    .addComponent(btn_ikayit)
                    .addComponent(btn_skayit))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_ara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ara))
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_geriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_geriActionPerformed
        Islemler islem=new Islemler();
        islem.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_geriActionPerformed

    private void btn_kaydetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kaydetActionPerformed
        String tc=tf_mno.getText();
        String ad=tf_ad.getText();
        String model=tf_model.getText();
        String numara=tf_no.getText();
        int k=kacincicihaz()+1;
        try {
            sonuc.moveToInsertRow();
            sonuc.updateString("musteri_tc",tc);
            sonuc.updateString("cihaz_adi",ad);
            sonuc.updateString("cihaz_modeli", model);
            sonuc.updateString("cihaz_numarasi",numara);
            sonuc.updateInt("cihaz_id",k);
            sonuc.insertRow();
            verileriGetir();
           // verileriGoster();
            } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_kaydetActionPerformed

    private void btn_silActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_silActionPerformed
         Statement ifade;
      
        try {
              ifade=baglanti.createStatement();
              String sql="DELETE FROM \"Cihaz\""+" WHERE cihaz_id="+tf_kno.getText();
              ifade.executeUpdate(sql);
              verileriGetir();
             // verileriGoster();
            } catch (SQLException ex) {
                ex.printStackTrace();
        }    
    }//GEN-LAST:event_btn_silActionPerformed

    private void btn_guncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guncelleActionPerformed
        Statement ifade;
        String tc=tf_mno.getText();
        String ad=tf_ad.getText();
        String model=tf_model.getText();
        String numara=tf_no.getText(); 
        String cihaz_id=tf_kno.getText();
               try {
                     ifade=baglanti.createStatement();
                     String sql="UPDATE \"Cihaz\" SET "+
                         "musteri_tc='"+tc+
                         "', cihaz_adi='"+ad+"'"+
                         ", cihaz_modeli='"+model+
                         "', cihaz_numarasi='"+numara+"'"+
                         " WHERE cihaz_id="+cihaz_id;
                     ifade.executeUpdate(sql);
                     verileriGetir();
                     verileriGoster();
                   } catch (Exception ex) {
                       ex.printStackTrace();
               } 
    }//GEN-LAST:event_btn_guncelleActionPerformed

    private void btn_temizleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_temizleActionPerformed
       txtBosalt();
       ilk_islemler();
    }//GEN-LAST:event_btn_temizleActionPerformed

    private void btn_ikayitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ikayitActionPerformed
         try {
            sonuc.first();
            verileriGoster();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btn_ikayitActionPerformed

    private void btn_skayitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_skayitActionPerformed
        try {
            sonuc.last();
            verileriGoster();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btn_skayitActionPerformed

    private void btn_okayitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_okayitActionPerformed
        try {
            if(sonuc.previous()){
                if(sonuc.isBeforeFirst()){
                    sonuc.next();
                }
                verileriGoster();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btn_okayitActionPerformed

    private void btn_nkayitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nkayitActionPerformed
       try {
            if(sonuc.next()){
                if(sonuc.isAfterLast()){
                    sonuc.last();
                }
                verileriGoster();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }    
    }//GEN-LAST:event_btn_nkayitActionPerformed

    private void btn_araActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_araActionPerformed
        String cihaz_id=tf_ara.getText();
        try {
            int mevcut_satir=sonuc.getRow();
            sonuc.first();
            sonuc.previous();
            int row=0;
            boolean bulundu=false;
            while(sonuc.next()){
                row++;
                if(sonuc.getString("cihaz_id").equals(cihaz_id)){
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
                 ex.printStackTrace();
        }   
    }//GEN-LAST:event_btn_araActionPerformed

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
            java.util.logging.Logger.getLogger(CihazIslemleri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CihazIslemleri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CihazIslemleri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CihazIslemleri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CihazIslemleri().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ara;
    private javax.swing.JButton btn_geri;
    private javax.swing.JButton btn_guncelle;
    private javax.swing.JButton btn_ikayit;
    private javax.swing.JButton btn_kaydet;
    private javax.swing.JButton btn_nkayit;
    private javax.swing.JButton btn_okayit;
    private javax.swing.JButton btn_sil;
    private javax.swing.JButton btn_skayit;
    private javax.swing.JButton btn_temizle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField tf_ad;
    private javax.swing.JTextField tf_ara;
    private javax.swing.JTextField tf_kno;
    private javax.swing.JTextField tf_mno;
    private javax.swing.JTextField tf_model;
    private javax.swing.JTextField tf_no;
    // End of variables declaration//GEN-END:variables
}
