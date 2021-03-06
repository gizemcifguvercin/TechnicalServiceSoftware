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
public class MusteriIslemleri extends javax.swing.JFrame {
  
    private Connection baglanti;
    private ResultSet sonuc;
    private Statement ifade;
    private DatabaseAccessObject dao=new DatabaseAccessObject();
    String teknik_default="1"; 

    private void verileriGetir(){
        String sql="SELECT * FROM \"Musteri\"";
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
                tf_adi.setText(sonuc.getString("musteri_adi")); 
                tf_tc.setText(sonuc.getString("musteri_tc"));
                tf_soyadi.setText(sonuc.getString("musteri_soyadi"));
                tf_tel.setText(sonuc.getString("musteri_telno"));
                tf_mail.setText(sonuc.getString("musteri_mail"));
                tf_mus_no.setText(sonuc.getString("musteri_id"));
                tf_kayit.setText(sonuc.getString("musteri_kayit"));
                tf_grup_no.setText(sonuc.getString("musteri_grup_id"));
                tf_servis_no.setText(sonuc.getString("m_teknik_servis_id"));

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
        tf_tc.setText("");
        tf_soyadi.setText("");
        tf_grup_no.setText("");
        tf_adi.setText("");
        tf_mail.setText("");
        tf_tel.setText("");
        tf_servis_no.setText("");
        tf_mus_no.setText("");
        tf_kayit.setText("");
        tf_tc.requestFocus();
    }
    private void ilk_islemler(){
        tf_tc.requestFocus();
        String DateTime = now("dd-MM-yyy");
        tf_kayit.setText(DateTime);
        tf_servis_no.setText(teknik_default);
        tf_mus_no.setText(String.valueOf(kacincikisi()+1));
        verileriGetir();
    }
  
    /**
     * Creates new form MusteriIslemleri
     */
    public MusteriIslemleri() {
        initComponents();
        ilk_islemler();
    }
    public int kacincikisi(){
            int row=0;
            try {
                baglanti=dao.getBaglanti();
                ifade=baglanti.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
                sonuc=ifade.executeQuery("SELECT * FROM \"Musteri\"");
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_geri = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        kaydet = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tf_tc = new javax.swing.JTextField();
        tf_soyadi = new javax.swing.JTextField();
        tf_adi = new javax.swing.JTextField();
        tf_tel = new javax.swing.JTextField();
        tf_mail = new javax.swing.JTextField();
        tf_kayit = new javax.swing.JTextField();
        tf_mus_no = new javax.swing.JTextField();
        tf_grup_no = new javax.swing.JTextField();
        tf_servis_no = new javax.swing.JTextField();
        btn_sil = new javax.swing.JButton();
        btn_guncelle = new javax.swing.JButton();
        tf_arama = new javax.swing.JTextField();
        btn_ara = new javax.swing.JButton();
        btn_temizle = new javax.swing.JButton();
        btn_ikayit = new javax.swing.JButton();
        btn_skayit = new javax.swing.JButton();
        btn_okayit = new javax.swing.JButton();
        btn_nkayit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_geri.setText("İŞLEMLERE DÖN");
        btn_geri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_geriActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Müşteri Bilgileri Girişi");

        kaydet.setText("KAYDET");
        kaydet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kaydetActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Adı :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Soyadı :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Tc :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Telefon :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Mail Adresi :");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Müşteri Numarasi :");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Kayıt Tarihi :");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Grup Numarası :");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Teknik Servis Numarası :");

        tf_kayit.setEditable(false);
        tf_kayit.setText("                    ");

        tf_mus_no.setEditable(false);
        tf_mus_no.setText("                   ");

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

        btn_ara.setText("ARA");
        btn_ara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_araActionPerformed(evt);
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
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_geri))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel2))
                                .addGap(96, 96, 96)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tf_servis_no)
                                    .addComponent(tf_grup_no)
                                    .addComponent(tf_mus_no)
                                    .addComponent(tf_kayit, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                                    .addComponent(tf_mail)
                                    .addComponent(tf_tel)
                                    .addComponent(tf_tc)
                                    .addComponent(tf_soyadi)
                                    .addComponent(tf_adi)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tf_arama, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_ara, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(kaydet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_ikayit, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addComponent(btn_skayit, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(btn_sil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btn_guncelle, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_okayit))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btn_nkayit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_temizle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 184, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_ara)
                        .addComponent(tf_arama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(btn_geri))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tf_tc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tf_soyadi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_adi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tf_tel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(tf_mail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(tf_kayit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(tf_mus_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(tf_grup_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(tf_servis_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btn_ikayit)
                                    .addComponent(btn_skayit)
                                    .addComponent(btn_okayit)
                                    .addComponent(btn_nkayit)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(kaydet)
                                    .addComponent(btn_sil)
                                    .addComponent(btn_guncelle)
                                    .addComponent(btn_temizle))))
                        .addGap(47, 47, 47)))
                .addContainerGap(72, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_geriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_geriActionPerformed
        Islemler islem=new Islemler();
        islem.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_geriActionPerformed

    private void btn_temizleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_temizleActionPerformed
        txtBosalt();
        ilk_islemler();
    }//GEN-LAST:event_btn_temizleActionPerformed

    private void kaydetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kaydetActionPerformed
        String tc=tf_tc.getText();
        String soyad=tf_soyadi.getText();
        String ad=tf_adi.getText();
        String tel=tf_tel.getText();
        String kayit=tf_kayit.getText();
        int grupno=Integer.parseInt(tf_grup_no.getText());
        int tekniksno=Integer.parseInt(tf_servis_no.getText());
        String mail=tf_mail.getText(); 
        int k=kacincikisi()+1;
        try {
            sonuc.moveToInsertRow();
            sonuc.updateString("musteri_tc",tc);
            sonuc.updateString("musteri_soyadi",soyad);
            sonuc.updateString("musteri_adi", ad);
            sonuc.updateString("musteri_telno",tel);
            sonuc.updateString("musteri_mail",mail);
            sonuc.updateInt("musteri_id",k);
            sonuc.updateString("musteri_kayit",kayit);
            sonuc.updateInt("musteri_grup_id",grupno);
            sonuc.updateInt("m_teknik_servis_id", tekniksno);   
            sonuc.insertRow();
            verileriGetir();
           // verileriGoster();
            } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_kaydetActionPerformed

    private void btn_araActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_araActionPerformed
        String musteri_tc=tf_arama.getText();
        try {
            int mevcut_satir=sonuc.getRow();
            sonuc.first();
            sonuc.previous();
            int row=0;
            boolean bulundu=false;
            while(sonuc.next()){
                row++;
                if(sonuc.getString("musteri_tc").equals(musteri_tc)){
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
        }    }//GEN-LAST:event_btn_araActionPerformed

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

    private void btn_silActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_silActionPerformed
       Statement ifade;
      
        try {
              ifade=baglanti.createStatement();
              String sql="DELETE FROM \"Musteri\""+" WHERE musteri_id="+tf_mus_no.getText();
              ifade.executeUpdate(sql);
              verileriGetir();
             // verileriGoster();
            } catch (SQLException ex) {
                ex.printStackTrace();
        }    }//GEN-LAST:event_btn_silActionPerformed

    private void btn_guncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guncelleActionPerformed
        Statement ifade;
        String soyad=tf_soyadi.getText();
        String ad=tf_adi.getText();
        String tel=tf_tel.getText();
        String mail=tf_mail.getText(); 
        String musteri_id=tf_mus_no.getText();
               try {
                     ifade=baglanti.createStatement();
                     String sql="UPDATE \"Musteri\" SET "+
                         "musteri_adi='"+ad+
                         "', musteri_soyadi='"+soyad+"'"+
                         ", musteri_telno='"+tel+
                         "', musteri_mail='"+mail+"'"+
                         " WHERE musteri_id="+musteri_id;
                     ifade.executeUpdate(sql);
                     verileriGetir();
                     verileriGoster();
                   } catch (Exception ex) {
                       ex.printStackTrace();
               } 
        
    }//GEN-LAST:event_btn_guncelleActionPerformed

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
            java.util.logging.Logger.getLogger(MusteriIslemleri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MusteriIslemleri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MusteriIslemleri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MusteriIslemleri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MusteriIslemleri().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ara;
    private javax.swing.JButton btn_geri;
    private javax.swing.JButton btn_guncelle;
    private javax.swing.JButton btn_ikayit;
    private javax.swing.JButton btn_nkayit;
    private javax.swing.JButton btn_okayit;
    private javax.swing.JButton btn_sil;
    private javax.swing.JButton btn_skayit;
    private javax.swing.JButton btn_temizle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton kaydet;
    private javax.swing.JTextField tf_adi;
    private javax.swing.JTextField tf_arama;
    private javax.swing.JTextField tf_grup_no;
    private javax.swing.JTextField tf_kayit;
    private javax.swing.JTextField tf_mail;
    private javax.swing.JTextField tf_mus_no;
    private javax.swing.JTextField tf_servis_no;
    private javax.swing.JTextField tf_soyadi;
    private javax.swing.JTextField tf_tc;
    private javax.swing.JTextField tf_tel;
    // End of variables declaration//GEN-END:variables
}
