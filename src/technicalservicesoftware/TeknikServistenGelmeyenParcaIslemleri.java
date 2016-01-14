/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package technicalservicesoftware;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Gizem
 */
public class TeknikServistenGelmeyenParcaIslemleri extends javax.swing.JFrame {
    private Connection baglanti;
    private ResultSet sonuc;
    private Statement ifade;
    private DatabaseAccessObject dao=new DatabaseAccessObject();
    
    ArrayList<Integer> listmalzeme;
    ArrayList<Integer> listcihaz;
    ArrayList<Integer> cservis_idlist;
    ArrayList<Integer> mservis_idlist;

    ArrayList<String> mailler;
    ArrayList<String> dizi; 


    /**
     * Creates new form TeknikServistenGelmeyenParcaIslemleri
     */
    public TeknikServistenGelmeyenParcaIslemleri() {
        initComponents();
        
    }
    private ArrayList verileriGetirMalzeme(ArrayList listmalzeme){
        String DateTime = now("dd-MM-yyy");
        String sql="SELECT * FROM \"TeknikServisArasiIslemler\" WHERE teslim_tarihi<='"+DateTime+"'",data="",newline="\n";
        int row=0;
        try {
            baglanti=dao.getBaglanti();
            ifade=baglanti.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            sonuc=ifade.executeQuery(sql);
            sonuc.last();
            row=sonuc.getRow();
            sonuc.first();
                
                data="****Malzeme ID****"+"               "+"****Teslim Tarihi****"+newline;
                for(int i=0;i<row;i++){
                    if(sonuc.getInt("gonderilen_malzeme_id")!=0){
                    data+="             "+sonuc.getInt("gonderilen_malzeme_id")+"                                          "+sonuc.getString("teslim_tarihi");
                    data+=newline;
                    listmalzeme.add(sonuc.getInt("gonderilen_malzeme_id"));
                    sonuc.next();
                  }
                    else{
                        sonuc.next(); 
                    }
                  
             }
           
        } catch (Exception e) {
          
        }
        jTextArea1.setText(data);
        return listmalzeme;
    }
    private ArrayList verileriGetirCihaz(ArrayList listcihaz){
        String DateTime = now("dd-MM-yyy");
        String sql="SELECT * FROM \"TeknikServisArasiIslemler\" WHERE teslim_tarihi<='"+DateTime+"'",data="",newline="\n";
        int row=0;
        try {
            baglanti=dao.getBaglanti();
            ifade=baglanti.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            sonuc=ifade.executeQuery(sql);
            sonuc.last();
            row=sonuc.getRow();
            sonuc.first();
            
                data="****Cihaz ID****"+"               "+"****Teslim Tarihi****"+newline;
               for(int i=0;i<row;i++){
                   if(sonuc.getInt("gonderilen_cihaz_id")!=0){
                   data+="             "+sonuc.getInt("gonderilen_cihaz_id")+"                                          "+sonuc.getString("teslim_tarihi");
                   data+=newline;
                   
                  listcihaz.add(sonuc.getInt("gonderilen_cihaz_id"));
                  sonuc.next();
                  } 
                   else{
                       sonuc.next();
                   }

             }
           
        } catch (Exception e) {
            
        }
        jTextArea1.setText(data);
        return listcihaz;
    }
   
     public static String now(String dateFormat) 
    {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        return sdf.format(cal.getTime());
    }
     private ArrayList malzemeservis_id(ArrayList list,ArrayList mservis_idlist){
        String DateTime = now("dd-MM-yyy");
        String sql="SELECT * FROM \"TeknikServisArasiIslemler\" WHERE teslim_tarihi<='"+DateTime+"'";
        int deg;
        int row=0;
        try {
            baglanti=dao.getBaglanti();
            ifade=baglanti.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            sonuc=ifade.executeQuery(sql);
            sonuc.last();
            row=sonuc.getRow();
            sonuc.first();
            for(int y=0;y<list.size();y++){
                for(int i=0;i<row;i++){
                deg=(Integer)list.get(y);
                if(sonuc.getInt("gonderilen_malzeme_id")==deg){
                     mservis_idlist.add(sonuc.getInt("alan_servis_id"));
                     
                }
               
                sonuc.next();
            }
            }
            
                
            
        } catch (Exception e) {
          
        }
        return mservis_idlist;
        
    }
     private ArrayList cihazservis_id(ArrayList list, ArrayList cservis_idlist){
        String DateTime = now("dd-MM-yyy");
        String sql="SELECT * FROM \"TeknikServisArasiIslemler\" WHERE teslim_tarihi<='"+DateTime+"'";
        int deg;
        int row=0;
        try {
            baglanti=dao.getBaglanti();
            ifade=baglanti.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            sonuc=ifade.executeQuery(sql);
            sonuc.last();
            row=sonuc.getRow();
            sonuc.first();
            for(int y=0;y<list.size();y++){
                for(int i=0;i<row;i++){
                deg=(Integer)list.get(y);
                if(sonuc.getInt("gonderilen_cihaz_id")==deg){
                     mservis_idlist.add(sonuc.getInt("alan_servis_id"));
                     
                }
               
                sonuc.next();
            }
            }
                
            
        } catch (Exception e) {
           
        }
        return cservis_idlist;
        
    }
     private ArrayList MailAdresleriniAl(ArrayList id,ArrayList dizi){
        String sql="SELECT * FROM \"TeknikServis\"";
        int row;
        try {
            baglanti=dao.getBaglanti();
            ifade=baglanti.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            sonuc=ifade.executeQuery(sql);
            sonuc.last();
            row=sonuc.getRow();
            sonuc.first();
            for(int i=0;i<id.size();i++){
                for(int y=0;y<row;y++){
                   if(sonuc.getInt("teknik_servis_id")==(Integer)id.get(i)){
                    dizi.add(sonuc.getString("teknik_servis_mail"));
                    } 
                   sonuc.next();
                }
                
                
            }

        } catch (Exception e) {
            
        }
        return dizi;
        
    }
    private void MailGonder(ArrayList list,String Baslik,String Mesaj){
        Properties props=System.getProperties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host","smtp.gmail.com");
        props.put("mail.smtp.user","xxxx@gmail.com");
        props.put("mail.smtp.password","xxxx");
        props.put("mail.smtp.port", 587);
        props.put("mail.smtp.auth", "true");
        Session session=Session.getDefaultInstance(props,null);
        MimeMessage mime=new MimeMessage(session);
            try {
                for(int i=0;i<list.size();i++){
                InternetAddress to=new InternetAddress(String.valueOf(list.get(i)));
                mime.addRecipient(Message.RecipientType.TO, to);
                mime.setFrom();
                mime.setSubject(Baslik);//başlık
                mime.setText(Mesaj);//mail gövdesi
                Transport t=session.getTransport("smtp");
                t.connect("smtp.gmail.com","xxxx@gmail.com","xxxx");
                t.sendMessage(mime, mime.getAllRecipients());
                System.out.println("gndr");
                t.close();
                // System.out.println("mail gönderildi");
                }
                
            } catch (Exception e) {
                
            }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Teslim Tarihi Geciken Cihazların Malzemelerin Listesi");

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(51, 51, 51));
        jTextArea1.setColumns(20);
        jTextArea1.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton2.setText("Malzemeler");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Cihazlar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setText("Geciken Malzemeler İçin Mail Gönder");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setText("Geciken Cihazlar İçin Mail Gönder");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("İŞLEMLERE DÖN");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
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
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4)))
                        .addGap(0, 123, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton4))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        listmalzeme=new ArrayList<>();
        verileriGetirMalzeme(listmalzeme);
       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        listcihaz=new ArrayList<>();
        verileriGetirCihaz(listcihaz);
      
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        mailler=new ArrayList<>();
        dizi=new ArrayList<>();
        listmalzeme=new ArrayList<>();
        mservis_idlist=new ArrayList<>();
        ArrayList<Integer> a=verileriGetirMalzeme(listmalzeme);
        ArrayList<Integer> b=new ArrayList<>();
        
        
        b=malzemeservis_id(a,mservis_idlist); 
        mailler=MailAdresleriniAl(b,dizi);
        MailGonder(mailler,"MALZEMELER GECIKTI","Enkısa sürede elimize ulaşmasını rica ederiz");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        mailler=new ArrayList<>();
        dizi=new ArrayList<>();
        listcihaz=new ArrayList<>();
        cservis_idlist=new ArrayList<>();
        ArrayList<Integer> a=verileriGetirCihaz(listcihaz);
        ArrayList<Integer> b=new ArrayList<>();

        b=cihazservis_id(a,cservis_idlist); 
        mailler=MailAdresleriniAl(b,dizi);
        MailGonder(mailler,"Cihazlar GECIKTI","Enkısa sürede elimize ulaşmasını rica ederiz");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Islemler islem=new Islemler();
        islem.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(TeknikServistenGelmeyenParcaIslemleri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TeknikServistenGelmeyenParcaIslemleri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TeknikServistenGelmeyenParcaIslemleri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TeknikServistenGelmeyenParcaIslemleri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TeknikServistenGelmeyenParcaIslemleri().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
