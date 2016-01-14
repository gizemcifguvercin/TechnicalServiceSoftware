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

/**
 *
 * @author Gizem
 */
public class TeknikServisIslemleri extends javax.swing.JFrame {

    /**
     * Creates new form TeknikServisIslemleri
     */
    private Connection baglanti;
    private ResultSet sonuc;
    private Statement ifade;
    private DatabaseAccessObject dao=new DatabaseAccessObject();
    String teknik_default="1"; 

    private void verileriGetir(){
        String sql="SELECT * FROM \"TeknikServis\"";
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
                tf_ad.setText(sonuc.getString("teknik_servis_adi")); 
                tf_mail.setText(sonuc.getString("teknik_servis_mail"));
                tf_adres.setText(sonuc.getString("teknik_servis_adres"));
                tf_tel.setText(sonuc.getString("teknik_servis_tel"));
                tf_teknikservisno.setText(sonuc.getString("teknik_servis_id"));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
           
            
        }
    }
    
    private void txtBosalt(){
        tf_ad.setText("");
        tf_mail.setText("");
        tf_adres.setText("");
        tf_tel.setText("");
        tf_teknikservisno.setText("");
        tf_ad.requestFocus();
    }
    private void ilk_islemler(){
        tf_ad.requestFocus();
        tf_teknikservisno.setText(teknik_default);
        tf_teknikservisno.setText(String.valueOf(kacinciservis()+1));
        verileriGetir();
    }
  
    /**
     * Creates new form MusteriIslemleri
     */
   
    public int kacinciservis(){
            int row=0;
            try {
                baglanti=dao.getBaglanti();
                ifade=baglanti.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
                sonuc=ifade.executeQuery("SELECT * FROM \"TeknikServis\"");
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
    public TeknikServisIslemleri() {
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tf_ad = new javax.swing.JTextField();
        tf_mail = new javax.swing.JTextField();
        tf_adres = new javax.swing.JTextField();
        tf_tel = new javax.swing.JTextField();
        tf_teknikservisno = new javax.swing.JTextField();
        btn_kaydet = new javax.swing.JButton();
        btn_sil = new javax.swing.JButton();
        btn_guncelle = new javax.swing.JButton();
        btn_temizle = new javax.swing.JButton();
        btn_geri = new javax.swing.JButton();
        btn_ikayit = new javax.swing.JButton();
        btn_skayit = new javax.swing.JButton();
        btn_okayit = new javax.swing.JButton();
        btn_nkayit = new javax.swing.JButton();
        tf_ara = new javax.swing.JTextField();
        btn_ara = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Teknis Servis Bilgilerinin Girilmesi ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Tekink Servis Numarasıı :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Adı :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Maili :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Adres :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Telefon :");

        tf_teknikservisno.setEditable(false);

        btn_kaydet.setText("Kaydet");
        btn_kaydet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_kaydetActionPerformed(evt);
            }
        });

        btn_sil.setText("Sil");
        btn_sil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_silActionPerformed(evt);
            }
        });

        btn_guncelle.setText("Güncelle");
        btn_guncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guncelleActionPerformed(evt);
            }
        });

        btn_temizle.setText("Temizle");
        btn_temizle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_temizleActionPerformed(evt);
            }
        });

        btn_geri.setText("İşlemlere Dön");
        btn_geri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_geriActionPerformed(evt);
            }
        });

        btn_ikayit.setText("İlk Kayıt");
        btn_ikayit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ikayitActionPerformed(evt);
            }
        });

        btn_skayit.setText("Son Kayıt");
        btn_skayit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_skayitActionPerformed(evt);
            }
        });

        btn_okayit.setText("Önceki Kayıt");
        btn_okayit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_okayitActionPerformed(evt);
            }
        });

        btn_nkayit.setText("Sonraki Kayıt");
        btn_nkayit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nkayitActionPerformed(evt);
            }
        });

        btn_ara.setText("Ara");
        btn_ara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_araActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_geri))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(127, 127, 127))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel3))
                                    .addGap(135, 135, 135)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(119, 119, 119)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tf_ad)
                            .addComponent(tf_mail)
                            .addComponent(tf_adres)
                            .addComponent(tf_tel)
                            .addComponent(tf_teknikservisno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE))
                        .addGap(198, 198, 198))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btn_ikayit)
                                        .addComponent(btn_kaydet))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btn_skayit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btn_sil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(tf_ara, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btn_guncelle, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                                .addComponent(btn_okayit, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                .addComponent(btn_ara, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btn_temizle, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                .addComponent(btn_nkayit, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btn_geri))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tf_ad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tf_mail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tf_adres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tf_tel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tf_teknikservisno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_kaydet)
                    .addComponent(btn_sil)
                    .addComponent(btn_guncelle)
                    .addComponent(btn_temizle))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_ikayit)
                    .addComponent(btn_skayit)
                    .addComponent(btn_okayit)
                    .addComponent(btn_nkayit))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_ara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ara))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_geriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_geriActionPerformed
        Islemler islem=new Islemler();
        islem.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_geriActionPerformed

    private void btn_kaydetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kaydetActionPerformed
        String ad=tf_ad.getText();
        int teknikservis=Integer.parseInt(tf_teknikservisno.getText());
        String adres=tf_adres.getText();
        String mail=tf_mail.getText();
        String tel=tf_tel.getText();
        try {
            sonuc.moveToInsertRow();
            sonuc.updateString("teknik_servis_adi",ad );
            sonuc.updateString("teknik_servis_adres", adres);
            sonuc.updateString("teknik_servis_mail", mail);
            sonuc.updateString("teknik_servis_tel", tel);
            sonuc.updateInt("teknik_servis_id", teknikservis);
            sonuc.insertRow();
            verileriGetir();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_kaydetActionPerformed

    private void btn_silActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_silActionPerformed
        Statement ifade;
      
        try {
              ifade=baglanti.createStatement();
              String sql="DELETE FROM \"TeknikServis\""+" WHERE teknik_servis_id="+tf_teknikservisno.getText();
              ifade.executeUpdate(sql);
              verileriGetir();
             // verileriGoster();
            } catch (SQLException ex) {
                ex.printStackTrace();
        }    
    }//GEN-LAST:event_btn_silActionPerformed

    private void btn_guncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guncelleActionPerformed
        Statement ifade;
        String ad=tf_ad.getText();
        String adres=tf_adres.getText();
        String mail=tf_mail.getText();
        String tel=tf_tel.getText();
        int teknikservis=Integer.parseInt(tf_teknikservisno.getText());

               try {
                     ifade=baglanti.createStatement();
                     String sql="UPDATE \"TeknikServis\" SET "+
                         "teknik_servis_adi='"+ad+
                         "', teknik_servis_adres='"+adres+"'"+
                         ", teknik_servis_mail='"+mail+
                         "', teknik_servis_tel='"+tel+"'"+
                         " WHERE teknik_servis_id="+teknikservis;
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
        String teknikservisno=tf_ara.getText();
        try {
            int mevcut_satir=sonuc.getRow();
            sonuc.first();
            sonuc.previous();
            int row=0;
            boolean bulundu=false;
            while(sonuc.next()){
                row++;
                if(sonuc.getString("teknik_servis_id").equals(teknikservisno)){
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
            java.util.logging.Logger.getLogger(TeknikServisIslemleri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TeknikServisIslemleri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TeknikServisIslemleri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TeknikServisIslemleri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TeknikServisIslemleri().setVisible(true);
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
    private javax.swing.JTextField tf_adres;
    private javax.swing.JTextField tf_ara;
    private javax.swing.JTextField tf_mail;
    private javax.swing.JTextField tf_teknikservisno;
    private javax.swing.JTextField tf_tel;
    // End of variables declaration//GEN-END:variables
}