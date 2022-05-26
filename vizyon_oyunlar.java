/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiyatro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CASPER
 */
public class vizyon_oyunlar extends javax.swing.JFrame {

    /**
     * Creates new form vizyon_oyunlar
     */
    
    
    private void satisurunGuncelle(){
    
     try {
            String baslik[] = new String[]{ "oyunturu", "oyunadi", "salon_no", "tarih", "ucret", "koltuk_sayisi", "Açıklama" };  
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = null;
            Statement st = null;
            ResultSet rs = null;

            con = DriverManager.getConnection("jdbc:mysql://localhost/tiyatro", "root", "");
            
            st = con.createStatement();                
            rs = st.executeQuery("select * from vizyon_oyunlar ORDER BY id DESC");
            rs.last();
           
            int kayitsayisi = rs.getRow();
            rs.beforeFirst();

            Object data[][] = new Object[kayitsayisi][];
            int i = 0;

            while (rs.next()) {

                data[i] = new Object[]{  
                    
                    
                    rs.getString("oyunturu"),  
                    rs.getString("oyunadi"),
                    rs.getString("salon_no"),
                    rs.getString("tarih"),  
                    rs.getString("ucret"),
                    rs.getString("koltuk_sayisi"),
                    rs.getString("aciklama"), 
                };
                i++;
            }
           
            con.close();
            table_satistaki_urunler.setModel(new DefaultTableModel(data, baslik));
            
        } catch (ClassNotFoundException ex) {
           JOptionPane.showMessageDialog(null,"Hata: " + ex.toString());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Veritabanına bağlantı sağlanamadı! " + ex.toString());
        }
    }
    
    private void UrunListeGuncelle(){
    
     try {
             String baslik[] = new String[]{"id","oyunturu", "oyunadi", "salon_no", "tarih", "ucret", "koltuk_sayisi", "Açıklama" };  
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = null;
            Statement st = null;
            ResultSet rs = null;

            con = DriverManager.getConnection("jdbc:mysql://localhost/tiyatro", "root", "");
            
            st = con.createStatement();                
            rs = st.executeQuery("select * from oyunlar");
            rs.last();
           
            int kayitsayisi = rs.getRow();
            rs.beforeFirst();

            Object data[][] = new Object[kayitsayisi][];
            int i = 0;

            while (rs.next()) {

                data[i] = new Object[]{  
                 rs.getInt("id"),
                    rs.getString("oyunturu"),  
                    rs.getString("oyunadi"),
                    rs.getString("salon_no"),
                    rs.getString("tarih"),  
                    rs.getString("ucret"),
                    rs.getString("koltuk_sayisi"),
                    rs.getString("aciklama"),
                       
                };
                i++;
            }
           
            con.close();
            table_urunler.setModel(new DefaultTableModel(data, baslik));
            
        } catch (ClassNotFoundException ex) {
           JOptionPane.showMessageDialog(null,"Hata: " + ex.toString());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Veritabanına bağlantı sağlanamadı! " + ex.toString());
        }
    }
    
    
    public vizyon_oyunlar() 
    {
        super("Satış Ekranı");
        initComponents();
        
        String baslik[] = new String[]{"id", "oyunturu", "oyunadi", "salon_no", "tarih", "ucret", "koltuk_sayisi", "Açıklama" };
        String baslik1[] = new String[]{"id", "oyunturu", "oyunadi", "salon_no", "tarih", "ucret", "koltuk_sayisi", "Açıklama" }; 

        try {
            
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = null;
            Statement st,st1 = null;
            ResultSet rs,rs1 = null;

            con = DriverManager.getConnection("jdbc:mysql://localhost/tiyatro", "root", "");
            
            st = con.createStatement();  
            st1 = con.createStatement();
            rs = st.executeQuery("select * from oyunlar ORDER BY id DESC");
            rs1 = st1.executeQuery("select * from vizyon_oyunlar ORDER BY id DESC");
            rs.last();
            rs1.last();
            
            int kayitsayisi = rs.getRow();
            rs.beforeFirst();

            Object data[][] = new Object[kayitsayisi][];
            int i = 0;

            while (rs.next()) {

                data[i] = new Object[]{  
                    
                    rs.getString("oyunturu"),  
                    rs.getString("oyunadi"),
                    rs.getString("salon_no"),
                    rs.getString("tarih"),  
                    rs.getString("ucret"),
                    rs.getString("koltuk_sayisi"),
                    rs.getString("aciklama"), 
                };
                i++;
            }
            //
            table_urunler.setModel(new DefaultTableModel(data, baslik));
            
            //
            int kayitsayisi1 = rs1.getRow();
            rs1.beforeFirst();

            Object data1[][] = new Object[kayitsayisi1][];
            int j = 0;

            while (rs1.next()) {

                data1[j] = new Object[]{  
                    
                    rs1.getString("id"),
                    rs1.getString("oyunturu"),  
                    rs1.getString("oyunadi"),
                    rs1.getString("salon_no"),
                    rs1.getString("tarih"),  
                    rs1.getString("ucret"),
                    rs1.getString("koltuk_sayisi"),
                    rs1.getString("aciklama"), 
                };
                j++;
            }
           
            //con.close();
            table_satistaki_urunler.setModel(new DefaultTableModel(data1, baslik1));
            
        } catch (ClassNotFoundException ex) {
           JOptionPane.showMessageDialog(null,"Hata: " + ex.toString());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Veritabanına bağlantı sağlanamadı! " + ex.toString());
        }
        
        UrunListeGuncelle();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_ksayisi = new javax.swing.JTextField();
        lbl_fiyat2 = new javax.swing.JLabel();
        txt_aciklama = new javax.swing.JTextField();
        txt_salon_no = new javax.swing.JTextField();
        lbl_fiyat1 = new javax.swing.JLabel();
        lbl_adi = new javax.swing.JLabel();
        lbl_kategori = new javax.swing.JLabel();
        txt_adi = new javax.swing.JTextField();
        txt_guncelle = new javax.swing.JButton();
        lbl_renk = new javax.swing.JLabel();
        txt_oyunturu = new javax.swing.JTextField();
        lbl_fiyat = new javax.swing.JLabel();
        txt_tarih = new javax.swing.JTextField();
        txt_ucret = new javax.swing.JTextField();
        lbl_renk1 = new javax.swing.JLabel();
        lbl_filtrele = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_urunler = new javax.swing.JTable();
        txt_ara = new javax.swing.JTextField();
        btn_ara = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btn_cikis = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_satistaki_urunler = new javax.swing.JTable();
        lbl_satislar = new javax.swing.JLabel();
        lbl_stok = new javax.swing.JLabel();
        lbl_satis_filtrele = new javax.swing.JLabel();
        btn_satis_ara = new javax.swing.JButton();
        txt_satis_ara = new javax.swing.JTextField();
        javax.swing.JLabel resim = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(825, 670));
        getContentPane().setLayout(null);
        getContentPane().add(txt_ksayisi);
        txt_ksayisi.setBounds(340, 260, 170, 30);

        lbl_fiyat2.setText("Açıklama");
        getContentPane().add(lbl_fiyat2);
        lbl_fiyat2.setBounds(530, 270, 120, 14);
        getContentPane().add(txt_aciklama);
        txt_aciklama.setBounds(580, 260, 170, 30);
        getContentPane().add(txt_salon_no);
        txt_salon_no.setBounds(90, 340, 170, 30);

        lbl_fiyat1.setText("Koltuk Sayisi");
        getContentPane().add(lbl_fiyat1);
        lbl_fiyat1.setBounds(270, 270, 100, 14);

        lbl_adi.setText("Oyun Adı");
        getContentPane().add(lbl_adi);
        lbl_adi.setBounds(280, 320, 90, 14);

        lbl_kategori.setText("Kategori");
        getContentPane().add(lbl_kategori);
        lbl_kategori.setBounds(530, 310, 70, 14);
        getContentPane().add(txt_adi);
        txt_adi.setBounds(340, 310, 170, 30);

        txt_guncelle.setText("Bilet Satışı");
        txt_guncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_guncelleActionPerformed(evt);
            }
        });
        getContentPane().add(txt_guncelle);
        txt_guncelle.setBounds(330, 350, 420, 23);

        lbl_renk.setText("Tarih");
        getContentPane().add(lbl_renk);
        lbl_renk.setBounds(50, 270, 110, 14);

        txt_oyunturu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_oyunturuActionPerformed(evt);
            }
        });
        getContentPane().add(txt_oyunturu);
        txt_oyunturu.setBounds(580, 300, 170, 30);

        lbl_fiyat.setText("Ucret");
        getContentPane().add(lbl_fiyat);
        lbl_fiyat.setBounds(50, 310, 70, 14);
        getContentPane().add(txt_tarih);
        txt_tarih.setBounds(90, 260, 170, 30);
        getContentPane().add(txt_ucret);
        txt_ucret.setBounds(90, 300, 170, 30);

        lbl_renk1.setText("Salon No");
        getContentPane().add(lbl_renk1);
        lbl_renk1.setBounds(50, 350, 80, 14);

        lbl_filtrele.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_filtrele.setText("Filtrele");
        getContentPane().add(lbl_filtrele);
        lbl_filtrele.setBounds(300, 30, 37, 17);

        table_urunler.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table_urunler.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_urunlerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_urunler);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 60, 800, 190);
        getContentPane().add(txt_ara);
        txt_ara.setBounds(340, 20, 170, 30);

        btn_ara.setText("Ara");
        btn_ara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_araActionPerformed(evt);
            }
        });
        getContentPane().add(btn_ara);
        btn_ara.setBounds(520, 20, 50, 30);

        jButton1.setText("Geri Dön");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(673, 10, 90, 23);

        btn_cikis.setText("X");
        btn_cikis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cikisActionPerformed(evt);
            }
        });
        getContentPane().add(btn_cikis);
        btn_cikis.setBounds(770, 10, 40, 23);

        table_satistaki_urunler.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table_satistaki_urunler.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_satistaki_urunlerMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_satistaki_urunler);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(0, 440, 810, 207);

        lbl_satislar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_satislar.setText("Bilet Satışı Yapılan Oyunlar");
        getContentPane().add(lbl_satislar);
        lbl_satislar.setBounds(10, 410, 220, 22);

        lbl_stok.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_stok.setText("Vizyondaki Oyunlar");
        getContentPane().add(lbl_stok);
        lbl_stok.setBounds(10, 30, 170, 20);

        lbl_satis_filtrele.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_satis_filtrele.setText("Filtrele");
        getContentPane().add(lbl_satis_filtrele);
        lbl_satis_filtrele.setBounds(270, 400, 37, 17);

        btn_satis_ara.setText("Ara");
        btn_satis_ara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_satis_araActionPerformed(evt);
            }
        });
        getContentPane().add(btn_satis_ara);
        btn_satis_ara.setBounds(480, 400, 49, 23);
        getContentPane().add(txt_satis_ara);
        txt_satis_ara.setBounds(310, 400, 170, 20);

        resim.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        resim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tiyatro/TiyatroPerdesi70.jpg"))); // NOI18N
        getContentPane().add(resim);
        resim.setBounds(0, 0, 820, 650);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_guncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_guncelleActionPerformed

        try {
            
            int row = table_urunler.getSelectedRow();            
            int secim_yap=Integer.parseInt((table_urunler.getValueAt(row, 0)).toString());
             
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = null;
            Statement st = null;
            ResultSet rs = null;

            con = DriverManager.getConnection("jdbc:mysql://localhost/tiyatro", "root", "");
            st = con.createStatement();
            
            rs = st.executeQuery("select * from oyunlar where id='"+secim_yap+"'");
            rs.next();
            
            int eski_adet=Integer.parseInt(rs.getString("koltuk_sayisi"));            
            int satilan_adet = Integer.parseInt(txt_ksayisi.getText());
            int kalan = eski_adet - satilan_adet;
            
            String sorgu1 = "UPDATE oyunlar SET oyunturu='"+txt_oyunturu.getText()+"'"
            +",oyunadi='"+txt_adi.getText()+"'"
            +",salon_no='"+txt_salon_no.getText()+"'"
            +",tarih='"+txt_tarih.getText()+"'"
            +",ucret='"+txt_ucret.getText()+"'"
            +",koltuk_sayisi='"+kalan+"'"
            +",aciklama='"+txt_aciklama.getText()+"' where id='"+secim_yap+"'";
            
            
            int fiyat = Integer.parseInt(txt_ucret.getText());
            int Toplam_fiyat =fiyat;
            
            String sorgu = "INSERT INTO vizyon_oyunlar (oyunturu,oyunadi,salon_no,tarih,ucret,koltuk_sayisi,aciklama)" 
                        + " VALUES ('"+txt_oyunturu.getText()+"', '"+txt_adi.getText()+"', '"+txt_salon_no.getText()+"'"
                        +", '"+txt_tarih.getText()+"', '"+Toplam_fiyat+"', '"+txt_ksayisi.getText()+"'"
                        +", '"+txt_aciklama.getText()+"')";
            
            
            
            st.executeUpdate(sorgu);
            st.executeUpdate(sorgu1);

            JOptionPane.showMessageDialog(null, txt_adi.getText() + " adlı oyun bileti satılmışır.");

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Hata: " + ex.toString());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Veritabanına bağlantı sağlanamadı! " + ex.toString());
        }
        
        satisurunGuncelle();
        UrunListeGuncelle();

    }//GEN-LAST:event_txt_guncelleActionPerformed

    private void table_urunlerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_urunlerMouseClicked

        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        PreparedStatement st1 =null;

        try {

            int row = table_urunler.getSelectedRow();            
            int secim_yap=Integer.parseInt((table_urunler.getValueAt(row, 0)).toString());
    
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/tiyatro", "root", "");

            String sorgu = "select * from oyunlar where id='"+secim_yap+"'";
            
            st = con.createStatement();
            rs = st.executeQuery(sorgu);
      
               
            if(rs.last()){

                txt_oyunturu.setText(rs.getString("oyunturu"));
                txt_adi.setText(rs.getString("oyunadi"));
                txt_salon_no.setText(rs.getString("salon_no"));
                txt_tarih.setText(rs.getString("tarih"));
                txt_ucret.setText(rs.getString("ucret"));
                txt_ksayisi.setText(rs.getString("koltuk_sayisi"));
                txt_aciklama.setText(rs.getString("aciklama"));
            }

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Hata: " + ex.toString());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Veritabanına bağlantı sağlanamadı! " + ex.toString());
        }
    }//GEN-LAST:event_table_urunlerMouseClicked

    private void btn_araActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_araActionPerformed

        String ara =txt_ara.getText();
        String baslik[] = new String[]{"oyunturu", "oyunadi", "salon_no", "tarih", "ucret", "koltuk_sayisi", "Açıklama" };

        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = null;
            Statement st = null;
            ResultSet rs = null;

            con = DriverManager.getConnection("jdbc:mysql://localhost/tiyatro", "root", "");

            String sorgu ="select * from oyunlar where oyunadi like '%"+txt_ara.getText()+"%' or"
            +" oyunturu like '%"+txt_ara.getText()+"%' or"
            +" salon_no like '%"+txt_ara.getText()+"%' or"
            +" tarih like '%"+txt_ara.getText()+"%' ";

            st = con.createStatement();
            rs = st.executeQuery(sorgu);

            rs.last();

            int say = rs.getRow();
            rs.beforeFirst();

            String sayi = null;
            sayi = String.valueOf(rs.getRow());

            if(say < 1){
                JOptionPane.showMessageDialog(null, "Aradığınız Oyun Bulunamadı!");
            }
            else{
                Object data[][] = new Object[say][];
                int i = 0;

                while (rs.next()) {

                    data[i] = new Object[]{

                        rs.getString("oyunturu"),
                        rs.getString("oyunadi"),
                        rs.getString("salon_no"),
                        rs.getString("tarih"),
                        rs.getString("ucret"),
                        rs.getString("koltuk_sayisi"),
                        rs.getString("aciklama"),
                    };
                    i++;
                }
                table_urunler.setModel(new DefaultTableModel(data, baslik));
            }

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Hata: " + ex.toString());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Veritabanına bağlantı sağlanamadı! " + ex.toString());
        }

    }//GEN-LAST:event_btn_araActionPerformed

    private void btn_cikisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cikisActionPerformed
        
        dispose();

    }//GEN-LAST:event_btn_cikisActionPerformed

    private void table_satistaki_urunlerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_satistaki_urunlerMouseClicked

        
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        PreparedStatement st1 =null;

        try {

            int row = table_satistaki_urunler.getSelectedRow();            
            int secim_yap=Integer.parseInt((table_satistaki_urunler.getValueAt(row, 0)).toString());

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/tiyatro", "root", "");

            String sorgu = "select * from vizyon_oyunlar where id='"+secim_yap+"'";
            //st = con.createStatement();
            st = con.createStatement();
            rs = st.executeQuery(sorgu);
   
            if(rs.last()){

                txt_oyunturu.setText(rs.getString("oyunturu"));
                txt_adi.setText(rs.getString("oyunadi"));
                txt_salon_no.setText(rs.getString("salon_no"));
                txt_tarih.setText(rs.getString("tarih"));
                txt_ucret.setText(rs.getString("ucret"));
                txt_ksayisi.setText(rs.getString("koltuk_sayisi"));
                txt_aciklama.setText(rs.getString("aciklama"));
            }

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Hata: " + ex.toString());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Veritabanına bağlantı sağlanamadı! " + ex.toString());
        }
        
        
    }//GEN-LAST:event_table_satistaki_urunlerMouseClicked

    private void btn_satis_araActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_satis_araActionPerformed
        
        
        String baslik[] = new String[]{"oyunturu", "oyunadi", "salon_no", "tarih", "ucret", "koltuk_sayisi", "Açıklama" };

        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = null;
            Statement st = null;
            ResultSet rs = null;

            con = DriverManager.getConnection("jdbc:mysql://localhost/tiyatro", "root", "");

            String sorgu ="select * from vizyon_oyunlar where oyunadi like '%"+txt_satis_ara.getText()+"%' or"
            +" oyunturu like '%"+txt_satis_ara.getText()+"%' or"
            +" salon_no like '%"+txt_satis_ara.getText()+"%' or"
            +" tarih like '%"+txt_satis_ara.getText()+"%' or"
            +" koltuk_sayisi like '%"+txt_satis_ara.getText()+"%' ";

            st = con.createStatement();
            rs = st.executeQuery(sorgu);

            rs.last();

            int say = rs.getRow();
            rs.beforeFirst();

            String sayi = null;
            sayi = String.valueOf(rs.getRow());

            if(say < 1){
                JOptionPane.showMessageDialog(null, "Aradığınız Oyun Bulunamadı!");
            }
            else{
                Object data[][] = new Object[say][];
                int i = 0;

                while (rs.next()) {

                    data[i] = new Object[]{

                        rs.getString("oyunturu"),
                        rs.getString("oyunadi"),
                        rs.getString("salon_no"),
                        rs.getString("tarih"),
                        rs.getString("ucret"),
                        rs.getString("koltuk_sayisi"),
                        rs.getString("aciklama"),
                    };
                    i++;
                }
                table_satistaki_urunler.setModel(new DefaultTableModel(data, baslik));
            }

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Hata: " + ex.toString());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Veritabanına bağlantı sağlanamadı! " + ex.toString());
        }
        
    }//GEN-LAST:event_btn_satis_araActionPerformed

    private void txt_oyunturuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_oyunturuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_oyunturuActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        raporlar goster = new raporlar();
        
        goster.setVisible(true); 
        this.setVisible(false);
// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(vizyon_oyunlar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vizyon_oyunlar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vizyon_oyunlar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vizyon_oyunlar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vizyon_oyunlar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ara;
    private javax.swing.JButton btn_cikis;
    private javax.swing.JButton btn_satis_ara;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_adi;
    private javax.swing.JLabel lbl_filtrele;
    private javax.swing.JLabel lbl_fiyat;
    private javax.swing.JLabel lbl_fiyat1;
    private javax.swing.JLabel lbl_fiyat2;
    private javax.swing.JLabel lbl_kategori;
    private javax.swing.JLabel lbl_renk;
    private javax.swing.JLabel lbl_renk1;
    private javax.swing.JLabel lbl_satis_filtrele;
    private javax.swing.JLabel lbl_satislar;
    private javax.swing.JLabel lbl_stok;
    private javax.swing.JTable table_satistaki_urunler;
    private javax.swing.JTable table_urunler;
    private javax.swing.JTextField txt_aciklama;
    private javax.swing.JTextField txt_adi;
    private javax.swing.JTextField txt_ara;
    private javax.swing.JButton txt_guncelle;
    private javax.swing.JTextField txt_ksayisi;
    private javax.swing.JTextField txt_oyunturu;
    private javax.swing.JTextField txt_salon_no;
    private javax.swing.JTextField txt_satis_ara;
    private javax.swing.JTextField txt_tarih;
    private javax.swing.JTextField txt_ucret;
    // End of variables declaration//GEN-END:variables
}
