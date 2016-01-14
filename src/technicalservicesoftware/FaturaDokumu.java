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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import static technicalservicesoftware.YapilanOnTanimliIsler.now;

/**
 *
 * @author Gizem
 */
public class FaturaDokumu extends javax.swing.JFrame {
   
    private Connection baglanti;
    private ResultSet sonuc;
    private Statement ifade;
    private DatabaseAccessObject dao = new DatabaseAccessObject();

    private void verileriGetir() {
        String sql = "SELECT * FROM \"Musteri\"";
        try {
            baglanti = dao.getBaglanti();
            ifade = baglanti.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            sonuc = ifade.executeQuery(sql);
            sonuc.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void verileriGoster() {
        txtBosalt();
        if (sonuc != null) {
            try {

                tf_tc.setText(sonuc.getString("musteri_tc"));
                tf_ad.setText(sonuc.getString("musteri_adi"));

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
    private void txtBosalt() {
        tf_ad.setText("");
    }
    private void ilk_islemler(){
        tf_tc.requestFocus();
        String DateTime = now("dd-MM-yyy");
        tf_ttarih.setText(DateTime);
        
        verileriGetir();
    }
    private String MusteriAdi(String tc) throws SQLException {
        String sql = "SELECT * FROM \"Musteri\"";
        baglanti = dao.getBaglanti();
        ifade = baglanti.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        sonuc = ifade.executeQuery(sql);
        while (sonuc.next()) {
            if ( tc.equals(sonuc.getString("musteri_tc"))) {
                return sonuc.getString("musteri_adi");
            }
        }
        return null;
    }
    private int CihazIdBul(String tc){
        String sql="SELECT * FROM \"Cihaz\"";
        try{
            baglanti=dao.getBaglanti();
            ifade=baglanti.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            sonuc=ifade.executeQuery(sql);
            while(sonuc.next()){
                if(tc.equals(sonuc.getString("musteri_tc"))){
                    return sonuc.getInt("cihaz_id");
                }
   
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
     private void MalzeBul(String tc,ArrayList b){
         String sql="SELECT * FROM \"MalzemeSatisi\"";
         try{
             baglanti=dao.getBaglanti();
            ifade=baglanti.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            sonuc=ifade.executeQuery(sql);
            while(sonuc.next()){
                if(tc.equals(sonuc.getString("musteri_tc"))){
                    b.add(sonuc.getInt("malzeme_id"));
                }
   
            }
         }catch (Exception e) {
            e.printStackTrace();
        }
      
     }
     private String malzeadbul(int id) {
        String sql="SELECT * FROM \"Malzeme\"";
        try {
            sonuc=ifade.executeQuery(sql);
            while(sonuc.next()){
                if(id==sonuc.getInt("malzeme_id")){
                    return sonuc.getString("malzeme_adi");
                }
            }
            } catch (Exception e) {
            e.printStackTrace();
        }
        return "BULUNAMADI";
    }
   
    
    private void isbul(int cihazno,ArrayList a){
        String tc = tf_tc.getText();
        cihazno=CihazIdBul(tc);
        String sql="SELECT * FROM \"YapilanOnTanimliIsler\"";
        try {
            baglanti=dao.getBaglanti();
            ifade=baglanti.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            sonuc=ifade.executeQuery(sql);
            while(sonuc.next()){
                if(cihazno==sonuc.getInt("cihaz_id")){
                    a.add(sonuc.getInt("on_tanimli_is_id"));
                }}
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private String isadbul(int id) {
        String sql="SELECT * FROM \"OnTanimliIsler\"";
        try {
            sonuc=ifade.executeQuery(sql);
            while(sonuc.next()){
                if(id==sonuc.getInt("on_tanimli_is_id")){
                    return sonuc.getString("on_tanimli_is_adi");
                }
            }
            } catch (Exception e) {
            e.printStackTrace();
        }
        return "BULUNAMADI";
    }
      
    private double malzemefiyat(String tc,ArrayList b){
        tc = tf_tc.getText();
        String sql="SELECT * FROM \"MalzemeSatisi\"";
        try {
            baglanti=dao.getBaglanti();
            ifade=baglanti.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            sonuc=ifade.executeQuery(sql);
            while(sonuc.next()){
                if(tc.equals(sonuc.getString("musteri_tc"))){
                    b.add(sonuc.getDouble("satildigi_ucret"));
                }}
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    private double isfiyat(String tc,ArrayList b){
        tc = tf_tc.getText();
        int cihaz = CihazIdBul(tc);
        String sql="SELECT * FROM \"YapilanOnTanimliIsler\"";
        try {
            baglanti=dao.getBaglanti();
            ifade=baglanti.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            sonuc=ifade.executeQuery(sql);
            while(sonuc.next()){
                if(cihaz==sonuc.getInt("cihaz_id")){
                    b.add(sonuc.getDouble("satildigi_ucret"));
                }}
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
   public FaturaDokumu() {
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

        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        tf_tc = new javax.swing.JTextField();
        tf_ad = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        tf_toplam = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        tf_ttarih = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtarea = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtarea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel6.setText("Teslim Tarihi :");

        jLabel8.setText("Müşteri TC :");

        jLabel9.setText("Müşteri Adı :");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("     Teslim Eden");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("     Teslim Alan");

        tf_ad.setEditable(false);

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel15.setText("TOPLAM TUTAR:");

        jLabel19.setText(" İMZA ");

        jLabel20.setText(" İMZA ");

        tf_toplam.setEditable(false);

        jButton1.setText("GÖSTER");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tf_ttarih.setEditable(false);

        jButton3.setText("İŞLEMLERE DÖN");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setText("TEKNİK SERVİS FATURA DÖKÜMÜ ");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("YAPILAN İŞLER");

        txtarea.setEditable(false);
        txtarea.setColumns(20);
        txtarea.setRows(5);
        jScrollPane1.setViewportView(txtarea);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("KULLANILAN MALZEMELER");

        txtarea1.setEditable(false);
        txtarea1.setColumns(20);
        txtarea1.setRows(5);
        jScrollPane2.setViewportView(txtarea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tf_ttarih, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel9))
                                    .addGap(21, 21, 21)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tf_ad, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                                        .addComponent(tf_tc)))
                                .addComponent(jScrollPane1)
                                .addComponent(jLabel2)
                                .addComponent(jScrollPane2)
                                .addComponent(jLabel6)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel15)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tf_toplam, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(170, 170, 170)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addComponent(jButton1))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(jLabel19)
                .addGap(261, 261, 261)
                .addComponent(jLabel20)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(tf_tc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tf_ad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(tf_ttarih, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(109, 109, 109)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jButton3)))
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_toplam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String tc = tf_tc.getText();
        String ad;
        int cihazid;
        cihazid=CihazIdBul(tc);
        int malzemeid;
        
        double a = 0;
        double b = 0;
        
        
        ArrayList<Double> is=new ArrayList<>();
        isfiyat(tc,is);
        for(int i=0;i<is.size();i++){
            a+=is.get(i).doubleValue();
        }
        ArrayList<Double> malze=new ArrayList<>();
        malzemefiyat(tc,malze);
        for(int i=0;i<malze.size();i++){
            b+=malze.get(i).doubleValue();
        }
        double fiyat=a+b;
        
        
        String data="";
        String malzeme="";
        ArrayList<Integer> is_idler=new ArrayList<>();
        isbul(cihazid,is_idler);
        for(int i=0;i<is_idler.size();i++){
            data+=isadbul(is_idler.get(i).intValue())+"\n";
        }
        ArrayList<Integer> adlar=new ArrayList<>();
        MalzeBul(tc,adlar);
        for(int i=0;i<adlar.size();i++){
            malzeme+=malzeadbul(adlar.get(i).intValue())+"\n";
        }
        tf_toplam.setText(Double.toString(fiyat));
        txtarea.setText(data);
        txtarea1.setText(malzeme);
        try {
            tf_tc.setText(tc);
            ad = MusteriAdi(tc);
            tf_ad.setText(ad);
            
        
        } catch (SQLException ex) {
            
        }
            

           
               
         
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         Islemler is=new Islemler();
        is.setVisible(true);
        this.setVisible(false);
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
            java.util.logging.Logger.getLogger(FaturaDokumu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FaturaDokumu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FaturaDokumu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FaturaDokumu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FaturaDokumu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField tf_ad;
    private javax.swing.JTextField tf_tc;
    private javax.swing.JTextField tf_toplam;
    private javax.swing.JTextField tf_ttarih;
    private javax.swing.JTextArea txtarea;
    private javax.swing.JTextArea txtarea1;
    // End of variables declaration//GEN-END:variables

    
}
