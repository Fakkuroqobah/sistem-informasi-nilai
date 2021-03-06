import Backend.Db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Agung Maulana
 */

public class Mahasiswa extends javax.swing.JInternalFrame {
    
    private final DefaultTableModel model;
    
    public Mahasiswa() {
        initComponents();
        super.setTitle("Data Mahasiswa");
        
        String judul[] = {"NIM", "Nama Mahasiswa", "Jenis Kelamin", "Kelas"};
        model = new DefaultTableModel(judul, 0);
        jTable1.setModel(model);
        
        tampil();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        nim = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        nama = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        lk = new javax.swing.JRadioButton();
        pr = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        kelas = new javax.swing.JComboBox<>();
        tambah = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        ubah = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        filter = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        search = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setToolTipText("");

        jLabel2.setText("NIM");

        nim.setToolTipText("Masukan NIM");

        jLabel3.setText("Nama");

        nama.setToolTipText("Masukan Nama Mahasiswa");

        jLabel4.setText("Jenis Kelamin");

        buttonGroup1.add(lk);
        lk.setText("Laki - laki");

        buttonGroup1.add(pr);
        pr.setText("Perempuan");

        jLabel5.setText("Kelas");

        kelas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Pilih --" }));

        tambah.setText("Simpan");
        tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahActionPerformed(evt);
            }
        });

        hapus.setText("Hapus");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });

        ubah.setText("Ubah");
        ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahActionPerformed(evt);
            }
        });

        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nim)
                            .addComponent(nama)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lk)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pr))
                            .addComponent(kelas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(ubah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tambah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(hapus, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                                    .addComponent(reset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lk)
                    .addComponent(pr)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(kelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tambah)
                    .addComponent(reset))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ubah)
                    .addComponent(hapus))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Data Mahasiswa");

        jLabel6.setText("Filter Berdasarkan Kelas");

        filter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Pilih --" }));
        filter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        search.setToolTipText("Cari Mahasiswa");
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });

        jLabel7.setText("Cari Mahasiswa");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 637, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filter, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(6, 6, 6))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(filter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel1)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tampil() {
        kelas.removeAllItems();
        kelas.addItem("-- Pilih --");
        
        int row = jTable1.getRowCount();
        for(int a = 0; a < row; a++){
            model.removeRow(0);
        }
        
        try {
            // List mahasiswa
            ResultSet rsMhs = Db.runQuery("SELECT * FROM view_nama_kelas");
            while(rsMhs.next()){
                String data[] = {
                    rsMhs.getString("nim"), 
                    rsMhs.getString("nama_mhs"), 
                    rsMhs.getString("jk"), 
                    rsMhs.getString("nama_kelas")
                };
                model.addRow(data);
            }
            
            // List kelas
            ResultSet rsKelas = Db.runQuery("SELECT * FROM kelas");
            ResultSet rsCount = Db.runQuery("SELECT COUNT(id_kelas) AS total FROM kelas");
            
            rsCount.next();
            
            while(rsKelas.next()){
                kelas.addItem(rsKelas.getString(2) + " (" + rsKelas.getString(3) + ")");
                if(filter.getItemCount() <= Integer.parseInt(rsCount.getString("total"))) {
                    filter.addItem(rsKelas.getString("nama_kelas"));
                }
            }
            
            hapus.setEnabled(false);
            ubah.setEnabled(false);
        } catch (SQLException ex) {
            Logger.getLogger(Mahasiswa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void reset() {
        nim.setText("");
        nama.setText("");        
        buttonGroup1.clearSelection();
        kelas.setSelectedIndex(0);
    }
    
    private void alertWarning(String text) {
        JOptionPane.showMessageDialog(this, text, "Validasi", JOptionPane.WARNING_MESSAGE);
    }
    
    private boolean validationForm() {
        if(nim.getText().isEmpty()) {
            alertWarning("NIM tidak boleh kosong");
            return true;
        }else if(nim.getText().length() > 10) {
            alertWarning("Panjang NIM tidak boleh lebih dari 10 karakter");
            return true;
        }
        
        if(nama.getText().isEmpty()) {
            alertWarning("Nama tidak boleh kosong");
            return true;
        }else if(nama.getText().length() > 50) {
            alertWarning("Panjang Nama tidak boleh lebih dari 50 karakter");
            return true;
        }
        
        if(buttonGroup1.getSelection() == null) {
            alertWarning("Pilih salah satu jenis kelamin");
            return true;
        }
        
        if(kelas.getSelectedItem() == "-- Pilih --") {
            alertWarning("Pilih salah satu kelas");
            return true;
        }
        
        return false;
    }
    
    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
        if(!validationForm()) {
            String jk;
            if (lk.isSelected()) jk = "Laki-Laki";
            else jk = "Perempuan";

            try {
                String[] part = kelas.getSelectedItem().toString().split(" ");
                ResultSet rs = Db.runQuery("SELECT * FROM kelas WHERE nama_kelas = '" + part[0] + "'");

                if(rs.next()) {
                    if(Integer.parseInt(rs.getString("kuota")) > 0) {
                        Db.runUpdate("CALL proc_insert_mahasiswa('"+ nim.getText() +"', "
                            + "'"+ nama.getText() +"', "
                            + "'"+ jk +"', "
                            + "'"+ rs.getString("id_kelas") +"')");

                        tampil();
                        reset();

                        JOptionPane.showMessageDialog(this, "Data Berhasil Ditambah");
                    }else{
                        JOptionPane.showMessageDialog(this, "Kuota kelas ini sudah habis");
                    }
                }else{
                    JOptionPane.showMessageDialog(this, "Kelas tidak ditemukan", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Mahasiswa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_tambahActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int a = jTable1.getSelectedRow();
        if (a > -1){
            nim.setText(model.getValueAt(a, 0).toString());
            nama.setText(model.getValueAt(a, 1).toString());
            if ("Laki-laki".equals(model.getValueAt(a, 2).toString())) {
                lk.setSelected(true);
            }else {
                pr.setSelected(true);
            }
            
            String modelKelas = model.getValueAt(a, 3).toString();
            for(int i = 0; i <= kelas.getComponentCount(); i++) {
                String[] part = kelas.getItemAt(i).split(" ");
                if(part[0].equals(modelKelas)) {
                    kelas.setSelectedIndex(i);
                    break;
                }
            }
            
            hapus.setEnabled(true);
            ubah.setEnabled(true);
            tambah.setEnabled(false);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void filterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterActionPerformed
        int row = jTable1.getRowCount();
        for(int a = 0; a < row; a++){
            model.removeRow(0);
        }
        
        if(filter.getSelectedItem() != "-- Pilih --"){
            try {
                ResultSet rsKelas = Db.runQuery("SELECT * FROM kelas WHERE nama_kelas = '" + filter.getSelectedItem() + "'");
                
                if(rsKelas.next()) {
                    ResultSet rsMhs = Db.runQuery("SELECT * FROM view_nama_kelas WHERE id_kelas = '" + rsKelas.getString("id_kelas") + "'");
                
                    while(rsMhs.next()){
                        String data[] = {
                            rsMhs.getString("nim"), 
                            rsMhs.getString("nama_mhs"), 
                            rsMhs.getString("jk"), 
                            rsMhs.getString("nama_kelas")
                        };
                        model.addRow(data);
                    }
                }else{
                    JOptionPane.showMessageDialog(this, "Kelas tidak ditemukan", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Mahasiswa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            tampil();
        }
    }//GEN-LAST:event_filterActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        int a = JOptionPane.showConfirmDialog(this, "Yakin");
        
        if(a == 0){
            try {
               Db.runUpdate("DELETE FROM mahasiswa WHERE nim = " + nim.getText());
               tampil();
               tambah.setEnabled(true);
               reset();
            } catch (SQLException ex) {
               Logger.getLogger(Mahasiswa.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }        
    }//GEN-LAST:event_hapusActionPerformed

    private void ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahActionPerformed
        if(!validationForm()) {
            try {
                String jk;
                if (lk.isSelected()) jk = "Laki-Laki";
                else jk = "Perempuan";
                
                String[] part = kelas.getSelectedItem().toString().split(" ");
                ResultSet rs = Db.runQuery("SELECT * FROM kelas WHERE nama_kelas = '" + part[0] + "'");
                
                if(rs.next()) {
                    if(Integer.parseInt(rs.getString("kuota")) > 0) {
                        Db.runUpdate("UPDATE mahasiswa SET " +
                            "nim = " + nim.getText() + "," +
                            "nama_mhs = '"  + nama.getText() + "'," +
                            "jk = '"  + jk + "'," +
                            "id_kelas = '"  + rs.getString("id_kelas") + "' WHERE nim = " + nim.getText());

                        tampil();
                        tambah.setEnabled(true);
                        reset();

                        JOptionPane.showMessageDialog(this, "Data Berhasil Di update");
                    }else{
                        JOptionPane.showMessageDialog(this, "Kuota kelas ini sudah habis");
                    }
                }else{
                    JOptionPane.showMessageDialog(this, "Kelas tidak ditemukan", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Mahasiswa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_ubahActionPerformed
    
    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
        int row = jTable1.getRowCount();
        for(int a = 0; a < row; a++){
            model.removeRow(0);
        }
        
        try {
            ResultSet rs = Db.runQuery("SELECT * FROM mahasiswa JOIN kelas USING(id_kelas) WHERE "
                    + "nama_mhs LIKE '%"+ search.getText() +"%'"
                    + "OR nim LIKE '%"+ search.getText() +"%'");

            while(rs.next()){
                String data[] = {
                    rs.getString("nim"), 
                    rs.getString("nama_mhs"), 
                    rs.getString("jk"), 
                    rs.getString("nama_kelas")
                };
                model.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Mahasiswa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchKeyReleased

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        nim.setText("");
        nama.setText("");
        buttonGroup1.clearSelection();
        kelas.setSelectedIndex(0);
        
        hapus.setEnabled(false);
        ubah.setEnabled(false);
        tambah.setEnabled(true);
    }//GEN-LAST:event_resetActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mahasiswa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> filter;
    private javax.swing.JButton hapus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> kelas;
    private javax.swing.JRadioButton lk;
    private javax.swing.JTextField nama;
    private javax.swing.JTextField nim;
    private javax.swing.JRadioButton pr;
    private javax.swing.JButton reset;
    private javax.swing.JTextField search;
    private javax.swing.JButton tambah;
    private javax.swing.JButton ubah;
    // End of variables declaration//GEN-END:variables

}