/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package projectmanager;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
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
import model.SinhVien;
import model.SinhVienDAO;

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
        try {
            Scanner sc = new Scanner(new FileReader("Gia.txt"));
            //Ho tro them dong vao Table tren giao dien
            DefaultTableModel model = (DefaultTableModel) tblQLSV.getModel();
            while (sc.hasNext()) {
                model.addRow(new Object[]{
                    sc.next(), //Ma
                    sc.next().replace('_', ' '), //Ten
                    sc.next().replace('_', ' '),
                    sc.next(),
                    Boolean.parseBoolean(sc.next()),
                    sc.next(),
                    sc.next().replace('_', '/'),
                    sc.next().replace('_', ' '),
                    sc.next().replace('_', ' ')
                });
            }
            sc.close();
            //PrintStream pw = new PrintStream("aaa.txt");
            //pw.println("Con chim o tro canh tre, con ca...");
        } catch (Exception e) {

        }
        setLocationRelativeTo(null);
    }

    public void initQueQuan() {
        String[] country = new String[]{"Chosse", "H?? N???i", "H???i Ph??ng", "H???i D????ng", "H??ng Y??n", "H?? Nam",
            "Nam ?????nh", "Th??i B??nh", "Ninh B??nh", "H?? Giang", "Cao B???ng", "L??o Cai", "B???c K???n", "L???ng S??n",
            "Tuy??n Quang", "Y??n B??i", "Th??i Nguy??n", "Ph?? Th???", "V??nh Ph??c", "B???c Giang", "B???c Ninh",
            "Qu???ng Ninh", "??i???n Bi??n", "Lai Ch??u", "S??n La", "H??a B??nh", "Thanh Ho??", "Ngh??? An", "H?? T??nh",
            "Qu???ng B??nh", "Qu???ng Tr???", "Th???a Thi??n - Hu???", "???? N???ng", "Qu???ng Nam", "Qu???ng Ng??i", "B??nh ?????nh",
            "Ph?? Y??n", "Kh??nh H??a", "Kon Tum", "Gia Lai", "?????c L???c", "?????k N??ng", "TP H??? Ch?? Minh", "L??m ?????ng",
            "Ninh Thu???n", "B??nh Ph?????c", "T??y Ninh", "B??nh D????ng", "?????ng Nai", "B??nh Thu???n", "B?? R???a - V??ng T??u",
            "Long An", "?????ng Th??p", "An Giang", "Ti???n Giang", "V??nh Long", "B???n Tre", "Ki??n Giang", "C???n Th??",
            "H???u Giang", "Tr?? Vinh", "S??c Tr??ng", "B???c Li??u", "C?? Mau"};
        DefaultComboBoxModel<String> boxModel = new DefaultComboBoxModel<>(country);
        cbxCountry.setModel(boxModel);
    }

    public void initTable() {
        tblModel = (DefaultTableModel) tblQLSV.getModel();
        String[] cols = new String[]{"M?? SV", "H??? t??n", "Email", "S??T", "CMND-CCCD", "Gi???i t??nh", "Ng??y sinh", "Qu?? qu??n", "?????a ch???"};
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
            JOptionPane.showMessageDialog(this, "Ch??a nh???p m?? nh??n vi??n");
            return false;
        } else {
            txtMaSV.setBackground(Color.WHITE);
        }
        if (txtName.getText().equals("")) {
            txtName.setBackground(Color.YELLOW);
            JOptionPane.showMessageDialog(this, "Ch??a nh???p h??? t??n");
            return false;
        } else {
            txtName.setBackground(Color.WHITE);
        }
        if (txtEmail.getText().equals("")) {
            txtEmail.setBackground(Color.YELLOW);
            JOptionPane.showMessageDialog(this, "Ch??a nh???p Email");
            return false;
        } else {
            txtEmail.setBackground(Color.WHITE);
        }
        Matcher matcher = Pattern.compile(P_EMAIL).matcher(txtEmail.getText());
        // To??n t??? ! ?????o ng?????c l???i k???t qu??? true th??nh false
        if (!matcher.matches()) {
            JOptionPane.showMessageDialog(this, "Email sai ?????nh d???ng");
            return false;
        }
        if (txtSDT.getText().equals("")) {
            txtSDT.setBackground(Color.YELLOW);
            JOptionPane.showMessageDialog(this, "Ch??a nh???p s??? ??i???n tho???i");
            return false;
        } else {
            txtSDT.setBackground(Color.WHITE);
        }
        Matcher matche = Pattern.compile(regex).matcher(txtSDT.getText());
        // To??n t??? ! ?????o ng?????c l???i k???t qu??? true th??nh false
        if (!matche.matches()) {
            JOptionPane.showMessageDialog(this, "SDT sai ?????nh d???ng");
            return false;
        }
        if (txtCCCD.getText().equals("")) {
            txtCCCD.setBackground(Color.YELLOW);
            JOptionPane.showMessageDialog(this, "Ch??a nh???p s??? CCCD");
            return false;
        } else {
            txtCCCD.setBackground(Color.WHITE);
        }

        if (txtNgaySinh.getText().equals("")) {
            txtNgaySinh.setBackground(Color.YELLOW);
            JOptionPane.showMessageDialog(this, "Ch??a nh???p ng??y sinh");
            return false;
        } else {
            txtNgaySinh.setBackground(Color.WHITE);
        }
        try {
            date_format.parse(txtNgaySinh.getText());
            txtNgaySinh.setBackground(Color.WHITE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Ch??a ????ng ?????nh d???ng (yyyy/MM/dd)", "Error", JOptionPane.WARNING_MESSAGE);
            txtNgaySinh.setBackground(Color.YELLOW);
            return false;
        }

        if (cbxCountry.getSelectedIndex() == 0) {
            cbxCountry.setBackground(Color.YELLOW);
            JOptionPane.showMessageDialog(this, "Ch??a ch???n qu?? qu??n");
            return false;
        } else {
            cbxCountry.setBackground(Color.WHITE);
        }

        if (txtaddress.getText().equals("")) {
            txtaddress.setBackground(Color.YELLOW);
            JOptionPane.showMessageDialog(this, "Ch??a nh???p ?????a ch???");
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
        btnUpdate = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        Save = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("QU???N L?? SINH VI??N");

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

        jLabel3.setText("M?? SV:");

        jLabel4.setText("H??? t??n:");

        jLabel5.setText("Email:");

        jLabel6.setText("S??? ??T:");

        jLabel7.setText("CMND-CCCD:");

        jLabel8.setText("Gi???i t??nh:");

        jLabel9.setText("?????a ch???");

        btgSex.add(rdoNam);
        rdoNam.setSelected(true);
        rdoNam.setText("Nam");

        btgSex.add(rdoNu);
        rdoNu.setText("N??? ");

        txtaddress.setColumns(20);
        txtaddress.setRows(5);
        jScrollPane1.setViewportView(txtaddress);

        jLabel10.setText("Qu?? qu??n");

        cbxCountry.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel12.setText("Ng??y sinh");

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
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)))
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
                            .addComponent(txtSDT, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCCCD, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtName)
                            .addComponent(txtEmail)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(rdoNam)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdoNu)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtMaSV, javax.swing.GroupLayout.Alignment.LEADING))))
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

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        jButton2.setText("Exit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        Save.setText("Save");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(127, 127, 127))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnNew)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Save))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnDelete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnUpdate)))
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(231, 231, 231)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNew)
                    .addComponent(Save))
                .addGap(12, 12, 12)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete)
                    .addComponent(btnUpdate))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(248, 248, 248))
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

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        if (validateform()) {
            JOptionPane.showMessageDialog(this, "Luu th??nh c??ng");
            dao.saveStudent();
            fillTable();

        }
    }//GEN-LAST:event_SaveActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        reset();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (txtMaSV.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "B???n ch??a ch???n m?? sinh vi??n c???n x??a");
        } else {
            if (dao.delStudentByID(txtMaSV.getText()) > 0) {
                JOptionPane.showMessageDialog(this, "X??a th??nh c??ng");
            } else {
                JOptionPane.showMessageDialog(this, "Kh??ng t??m th???y sinh vi??n");
            }
        }

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if (validateform()) {
            try {
                SinhVien sv = getModel();
                if (dao.updateStudentByID(sv) > 0) {
                    JOptionPane.showMessageDialog(this, "C???p nh???t th??nh c??ng");
                    fillTable();
                }
            } catch (ParseException ex) {
                Logger.getLogger(SinhVienDia.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(SinhVienDia.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SinhVienDia.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SinhVienDia.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SinhVienDia.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JButton Save;
    private javax.swing.ButtonGroup btgSex;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbxCountry;
    private javax.swing.JButton jButton2;
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
