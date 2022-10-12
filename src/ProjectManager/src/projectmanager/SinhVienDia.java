/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package ProjectManager.src.projectmanager;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.Data;

import ProjectManager.src.model.SinhVien;
import ProjectManager.src.model.SinhVienDAO;


public class SinhVienDia extends javax.swing.JDialog {

    SimpleDateFormat date_format = new SimpleDateFormat("yyyy/MM/dd");
    DefaultTableModel tblModel;
    List<SinhVien> list = new ArrayList<>();
    String strhinhanh = null;
    private int index = -1;
    private static final String P_EMAIL = "^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$";
    private static final String regex = "^0[987654321]{1}\\d{8}$";
    SinhVienDAO dao = new SinhVienDAO();

    /**
     * Creates new form SinhVienDia
     */
    public SinhVienDia(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
    }

    public void initQueQuan() {
        String[] country = new String[]{"Chosse", "Hà Nội", "Hải Phòng", "Hải Dương", "Hưng Yên", "Hà Nam", "Nam Định", "Thái Bình", "Ninh Bình", "Hà Giang", "Cao Bằng", "Lào Cai", "Bắc Kạn", "Lạng Sơn", "Tuyên Quang", "Yên Bái", "Thái Nguyên", "Phú Thọ", "Vĩnh Phúc", "Bắc Giang", "Bắc Ninh", "Quảng Ninh", "Điện Biên", "Lai Châu", "Sơn La", "Hòa Bình", "Thanh Hoá", "Nghệ An", "Hà Tĩnh", "Quảng Bình", "Quảng Trị", "Thừa Thiên - Huế", "Đà Nẵng", "Quảng Nam", "Quảng Ngãi", "Bình Định", "Phú Yên", "Khánh Hòa", "Kon Tum", "Gia Lai", "Đắc Lắc", "Đắk Nông", "TP Hồ Chí Minh", "Lâm Đồng", "Ninh Thuận", "Bình Phước", "Tây Ninh", "Bình Dương", "Đồng Nai", "Bình Thuận", "Bà Rịa - Vũng Tàu", "Long An", "Đồng Tháp", "An Giang", "Tiền Giang", "Vĩnh Long", "Bến Tre", "Kiên Giang", "Cần Thơ", "Hậu Giang", "Trà Vinh", "Sóc Trăng", "Bạc Liêu", "Cà Mau"};
        DefaultComboBoxModel<String> boxModel = new DefaultComboBoxModel<>(country);
        cbxCountry.setModel(boxModel);
    }

    public void initTable() {
        tblModel = (DefaultTableModel) tblQLSV.getModel();
        String[] cols = new String[]{"Mã SV", "Họ tên", "Email", "SĐT", "CMND-CCCD", "Giới tính", "Ngày sinh", "Quê quán", "Địa chỉ", "Hình ảnh"};
        tblModel.setColumnIdentifiers(cols);
    }

    public void fillTable() {
        tblModel.setRowCount(0);
        for (SinhVien sv : dao.getAllStudent()) {
            Object[] row = new Object[]{sv.getMaSV(), sv.getTenSV(), sv.getEmail(), sv.getSDT(), sv.getCCCD(), sv.isGioiTinh(), date_format.format(sv.getNgaySinh()), sv.getQueQuan(), sv.getDiaChi()};
            tblModel.addRow(row);
        }
    }

    public SinhVien readFrom() throws ParseException {
        return new SinhVien(txtMaSV.getText(), txtName.getText(), txtEmail.getText(), txtSDT.getText(), txtCCCD.getText(), rdoNam.isSelected(), date_format.parse(txtNgaySinh.getText()), ((String) cbxCountry.getSelectedItem()), txtaddress.getText());
    }

    public void reset() {
        txtMaSV.setText("");
        txtName.setText("");
        txtEmail.setText("");
        txtSDT.setText("");
        txtCCCD.setText("");
        rdoNam.isSelected();
        txtNgaySinh.setText("");
        cbxCountry.setSelectedIndex(0);
        txtaddress.setText("");
    }

    public boolean validateform() {
        if (txtMaSV.getText().equals("")) {
            txtMaSV.setBackground(Color.YELLOW);
            JOptionPane.showMessageDialog(this, "Chưa nhập mã nhân viên");
            return false;
        } else {
            txtMaSV.setBackground(Color.WHITE);
        }
        if (txtName.getText().equals("")) {
            txtName.setBackground(Color.YELLOW);
            JOptionPane.showMessageDialog(this, "Chưa nhập họ tên");
            return false;
        } else {
            txtName.setBackground(Color.WHITE);
        }
        if (txtEmail.getText().equals("")) {
            txtEmail.setBackground(Color.YELLOW);
            JOptionPane.showMessageDialog(this, "Chưa nhập Email");
            return false;
        } else {
            txtEmail.setBackground(Color.WHITE);
        }
        Matcher matcher = Pattern.compile(P_EMAIL).matcher(txtEmail.getText());
        // Toán tử ! đảo ngược lại kết quả true thành false
        if (!matcher.matches()) {
            JOptionPane.showMessageDialog(this, "Email sai định dạng");
            return false;
        }
        if (txtSDT.getText().equals("")) {
            txtSDT.setBackground(Color.YELLOW);
            JOptionPane.showMessageDialog(this, "Chưa nhập số điện thoại");
            return false;
        } else {
            txtSDT.setBackground(Color.WHITE);
        }
        Matcher matche = Pattern.compile(regex).matcher(txtSDT.getText());
        // Toán tử ! đảo ngược lại kết quả true thành false
        if (!matche.matches()) {
            JOptionPane.showMessageDialog(this, "SDT sai định dạng");
            return false;
        }
        if (txtCCCD.getText().equals("")) {
            txtCCCD.setBackground(Color.YELLOW);
            JOptionPane.showMessageDialog(this, "Chưa nhập số CCCD");
            return false;
        } else {
            txtCCCD.setBackground(Color.WHITE);
        }

        if (txtNgaySinh.getText().equals("")) {
            txtNgaySinh.setBackground(Color.YELLOW);
            JOptionPane.showMessageDialog(this, "Chưa nhập ngày sinh");
            return false;
        } else {
            txtNgaySinh.setBackground(Color.WHITE);
        }
        try {
            date_format.parse(txtNgaySinh.getText());
            txtNgaySinh.setBackground(Color.WHITE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Chưa đúng định dạng (yyyy/MM/dd)", "Error", JOptionPane.WARNING_MESSAGE);
            txtNgaySinh.setBackground(Color.YELLOW);
            return false;
        }

        if (cbxCountry.getSelectedIndex() == 0) {
            cbxCountry.setBackground(Color.YELLOW);
            JOptionPane.showMessageDialog(this, "Chưa chọn quê quán");
            return false;
        } else {
            cbxCountry.setBackground(Color.WHITE);
        }

        if (txtaddress.getText().equals("")) {
            txtaddress.setBackground(Color.YELLOW);
            JOptionPane.showMessageDialog(this, "Chưa nhập địa chỉ");
            return false;
        } else {
            txtaddress.setBackground(Color.WHITE);
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btgSex = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblQLSV = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtMaSV = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        txtCCCD = new javax.swing.JTextField();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtaddress = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        cbxCountry = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        txtNgaySinh = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("QUẢN LÝ SINH VIÊN");

        tblQLSV.setModel(new javax.swing.table.DefaultTableModel(
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
        tblQLSV.setColumnSelectionAllowed(true);
        tblQLSV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblQLSVMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblQLSV);
        tblQLSV.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("Mã SV:");

        jLabel4.setText("Họ tên:");

        jLabel5.setText("Email:");

        jLabel6.setText("Số ĐT:");

        jLabel7.setText("CMND-CCCD:");

        jLabel8.setText("Giới tính:");

        jLabel9.setText("Địa chỉ");

        btgSex.add(rdoNam);
        rdoNam.setSelected(true);
        rdoNam.setText("Nam");

        btgSex.add(rdoNu);
        rdoNu.setText("Nữ ");

        txtaddress.setColumns(20);
        txtaddress.setRows(5);
        jScrollPane1.setViewportView(txtaddress);

        jLabel10.setText("Quê quán");

        cbxCountry.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel12.setText("Ngày sinh");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(64, 64, 64)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbxCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel12))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(rdoNam)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdoNu)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtSDT, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCCCD, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtName)
                            .addComponent(txtEmail))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(rdoNam)
                    .addComponent(rdoNu))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cbxCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(256, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        initTable();
        initQueQuan();
        fillTable();
    }//GEN-LAST:event_formWindowOpened

    public SinhVien getModel() throws ParseException {
        SinhVien sv = new SinhVien();
        sv.setMaSV(txtMaSV.getText());
        sv.setTenSV(txtName.getText());
        sv.setEmail(txtEmail.getText());
        sv.setSDT(txtSDT.getText());
        sv.setCCCD(txtCCCD.getText());
        boolean gt = false;
        if (rdoNam.isSelected()) {
            gt = true;
        }
        sv.setGioiTinh(gt);
        sv.setNgaySinh(date_format.parse(txtNgaySinh.getText()));
        sv.setQueQuan((String) cbxCountry.getSelectedItem());
        sv.setDiaChi(txtaddress.getText());
        return sv;
    }

    public void setModel(SinhVien sv) {
        txtMaSV.setText(sv.getMaSV());
        txtName.setText(sv.getTenSV());
        txtEmail.setText(sv.getEmail());
        txtSDT.setText(sv.getSDT());
        txtCCCD.setText(sv.getCCCD());
        if (sv.isGioiTinh()) {
            rdoNam.isSelected();
        } else {
            rdoNu.isSelected();
        }
        txtNgaySinh.setText(date_format.format(sv.getNgaySinh()));
        cbxCountry.setSelectedItem(sv.getQueQuan());
        txtaddress.setText(sv.getDiaChi());
    }
    private void tblQLSVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblQLSVMouseClicked
        int id = tblQLSV.rowAtPoint(evt.getPoint());
        String masv = tblQLSV.getValueAt(id, 0).toString();
        SinhVien sv = dao.getStudentByID(masv);
        setModel(sv);
    }//GEN-LAST:event_tblQLSVMouseClicked

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
            java.util.logging.Logger.getLogger(SinhVienDia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SinhVienDia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SinhVienDia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SinhVienDia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SinhVienDia dialog = new SinhVienDia(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btgSex;
    private javax.swing.JComboBox<String> cbxCountry;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable tblQLSV;
    private javax.swing.JTextField txtCCCD;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMaSV;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextArea txtaddress;
    // End of variables declaration//GEN-END:variables

}
