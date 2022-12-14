/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.poly.it17326.group3.view;

import com.poly.it17326.group3.domainmodels.ChucVu;
import com.poly.it17326.group3.domainmodels.NhanVien;
import com.poly.it17326.group3.service.ViewChucVuService;
import com.poly.it17326.group3.service.ViewNhanVienService;
import com.poly.it17326.group3.service.impl.ViewChucVuServiceImpl;
import com.poly.it17326.group3.service.impl.ViewNhanVienServiceImpl;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author user
 */
public class NhanVienJPanel extends javax.swing.JPanel {

    private DefaultTableModel defaultTableModel;
    private ViewNhanVienService viewNhanVienService = new ViewNhanVienServiceImpl();
    private ViewChucVuService viewChucVuService = new ViewChucVuServiceImpl();
    private StringBuilder sb;
    private SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

    /**
     * Creates new form NhanVienPanel
     */
    public NhanVienJPanel() {
        initComponents();
        LoadTable((ArrayList<NhanVien>) viewNhanVienService.getNhanVien());
        loadCbo();
    }

    private String doiNgay(Date d) {
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("dd-MM-yyyy");
        String ngaySinh = format.format(d);
        return ngaySinh;
    }

    public String zenMaNV(List<NhanVien> listNV) {
        String ma = "NVI";
        return ma + String.valueOf(listNV.size() + 1);
    }

    private void LoadTable(ArrayList<NhanVien> listNhanVien) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        defaultTableModel = (DefaultTableModel) tbNhanVien.getModel();
        defaultTableModel.setColumnIdentifiers(new String[]{"STT", "Mã nhân viên", "CCCD", "Tên nhân viên", "Chức vụ", "Giới tính", "Email", "Ngày sinh", "SĐT", "Địa chỉ", "Trạng thái"});
        defaultTableModel.setRowCount(0);
        for (NhanVien nhanVien : listNhanVien) {
            defaultTableModel.addRow(new Object[]{nhanVien.getId(), nhanVien.getMaNV(), nhanVien.getCccd(), nhanVien.getTenNhanVien(), nhanVien.getChucVu().getTenChucVu(),
                nhanVien.htGioiTinh(), nhanVien.getEmail(), doiNgay(nhanVien.getNgaySinh()), nhanVien.getSDT(), nhanVien.getDiaChi(), nhanVien.htDeleted()});
        }
    }

    private void loadCbo() {
        DefaultComboBoxModel defaultComboBoxModel;
        defaultComboBoxModel = (DefaultComboBoxModel) cboChucVu.getModel();
        defaultComboBoxModel.removeAllElements();
        for (ChucVu chucVu : viewChucVuService.getChucVu()) {
            defaultComboBoxModel.addElement(chucVu.getTenChucVu());
        }
    }

    private void sendMail() {
//        final String username = "tranviethung271003@gmail.com";
//        final String password = "ibxcgycsagvxcabs";
        final String username = "tranviethung271003@gmail.com";
        final String password = "ibxcgycsagvxcabs";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("tranviethung271003@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(txtEmail.getText())
            );
            message.setSubject("Mat khau dang nhap");
            message.setText("Mat khau cua ban la: 1\n Luu y: Ban can doi mat khau som de dam bao an toan cho tai khoan !");
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(this, "Gửi mail thành công");

    }

    public void loadTextFile(int row) {
//        txtSTT.setText(tbNhanVien.getValueAt(row, 0).toString());
        txtMaNV.setText(tbNhanVien.getValueAt(row, 1).toString());
        txtCccd.setText(tbNhanVien.getValueAt(row, 2).toString());
        txtTenNhanVien.setText(tbNhanVien.getValueAt(row, 3).toString());
        cboChucVu.setSelectedItem(tbNhanVien.getValueAt(row, 4).toString());
        if (tbNhanVien.getValueAt(row, 5).toString().equalsIgnoreCase("Nam")) {
            rbnNam.setSelected(true);
        } else {
            rbnNu.setSelected(true);
        }
        txtEmail.setText(tbNhanVien.getValueAt(row, 6).toString());
        try {
            Date ngayS = new SimpleDateFormat("dd-MM-yyyy").parse(tbNhanVien.getValueAt(row, 7).toString());
            txtNgaySinh.setDate(ngayS);
        } catch (Exception e) {
        }
        txtSDT.setText(tbNhanVien.getValueAt(row, 8).toString());
        txtDiaChi.setText(tbNhanVien.getValueAt(row, 9).toString());
//        txtMatKhau.setText(tbNhanVien.getValueAt(row, 9).toString());
        if (tbNhanVien.getValueAt(row, 10).toString().equalsIgnoreCase("Nghỉ làm")) {
            chekNghi.setSelected(true);
        } else {
            chekNghi.setSelected(false);
        }
    }

    private StringBuilder validator() {
        sb = new StringBuilder();
        if (txtCccd.getText().isEmpty()) {
            sb.append("Chưa nhập cccd").append("\n");
        } else {
            String checkCmt = "\\d{9}";
            String checkCC = "\\d{12}";
            if (!txtCccd.getText().matches(checkCC) && !txtCccd.getText().matches(checkCmt)) {
                sb.append("Mã cccd sai hoặc không đúng định dạng").append("\n");
            } else {
                for (NhanVien nhanVien : viewNhanVienService.getNhanVien()) {
                    if (nhanVien.getCccd().equals(txtCccd.getText())) {
                        sb.append("Mã cccd đã được sử dụng").append("\n");
                    }
                }
            }
        }
        if (txtTenNhanVien.getText().isEmpty()) {
            sb.append("Chưa nhập họ tên").append("\n");
        }
        if (txtEmail.getText().isEmpty()) {
            sb.append("Chưa nhập Email").append("\n");
        } else {
            for (NhanVien nhanVien : viewNhanVienService.getNhanVien()) {
                if (nhanVien.getEmail().equals(txtEmail.getText())) {
                    sb.append("Email đã được sử dụng").append("\n");
                } else {
                    String checkEmail = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
                    if (!txtEmail.getText().matches(checkEmail)) {
                        sb.append("Email sai định dạng").append("\n");
                    }
                }
            }
        }

        try {
            Date ngaySinh = this.txtNgaySinh.getDate();
            if (ngaySinh == null) {
                sb.append("Chưa nhập ngày sinh ").append("\n");
            }
        } catch (Exception e) {
        }
        try {
            LocalDate localDate = LocalDate.now();
            int year = localDate.getYear();
            int namSinh = this.txtNgaySinh.getDate().getYear() + 1900;
            System.out.println(namSinh);
            if (year - namSinh < 15) {
                sb.append("Nhân viên không trong độ tuổi lao động").append("\n");
            }
        } catch (Exception e) {
        }
        if (txtSDT.getText().isEmpty()) {
            sb.append("Chưa nhập số điện thoại").append("\n");
        } else {
            for (NhanVien nhanVien : viewNhanVienService.getNhanVien()) {
                if (nhanVien.getSDT().equals(txtSDT.getText())) {
                    sb.append("SĐT đã được sử dụng").append("\n");
                }
            }
        }
        String checkSDT = "0\\d{9,10}";
        String checkSDT2 = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";
        if (!txtSDT.getText().matches(checkSDT) || !txtSDT.getText().matches(checkSDT2)) {
            sb.append("SĐT sai định dạng").append("\n");
        }
        if (txtDiaChi.getText().isEmpty()) {
            sb.append("Chưa nhập địa chỉ").append("\n");
        }
        return sb;
    }

    private StringBuilder validatorSua() {
        sb = new StringBuilder();
        if (txtTenNhanVien.getText().isEmpty()) {
            sb.append("Chưa nhập họ tên").append("\n");
        }
        if (txtEmail.getText().isEmpty()) {
            sb.append("Chưa nhập Email").append("\n");
        } else {
            String checkEmail = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
            if (!txtEmail.getText().matches(checkEmail)) {
                sb.append("Email sai định dạng").append("\n");
            }

        }
        try {
            Date ngaySinh = this.txtNgaySinh.getDate();
            if (ngaySinh == null) {
                sb.append("Chưa nhập ngày sinh ").append("\n");
            }
        } catch (Exception e) {
        }
        if (txtSDT.getText().isEmpty()) {
            sb.append("Chưa nhập số điện thoại").append("\n");
        } else {
            for (NhanVien nhanVien : viewNhanVienService.getNhanVien()) {
                if (nhanVien.getSDT().equals(txtSDT.getText())) {
                    sb.append("SĐT đã được sử dụng").append("\n");
                }
            }
        }
        String checkSDT = "0\\d{9,10}";
        String checkSDT2 = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";
        if (!txtSDT.getText().matches(checkSDT) || !txtSDT.getText().matches(checkSDT2)) {
            sb.append("SĐT sai định dạng").append("\n");
        }
        if (txtDiaChi.getText().isEmpty()) {
            sb.append("Chưa nhập địa chỉ").append("\n");
        }
        return sb;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbNhanVien = new javax.swing.JTable();
        btnDau = new javax.swing.JButton();
        btnCuoi = new javax.swing.JButton();
        btnLui = new javax.swing.JButton();
        btntien = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtTim = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTenNhanVien = new javax.swing.JTextField();
        rbnNam = new javax.swing.JRadioButton();
        rbnNu = new javax.swing.JRadioButton();
        cboChucVu = new javax.swing.JComboBox<>();
        txtSDT = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        chekNghi = new javax.swing.JCheckBox();
        jlbTrangThai = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        btnNew = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnXuatFile = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtCccd = new javax.swing.JTextField();
        txtNgaySinh = new com.toedter.calendar.JDateChooser();

        jFormattedTextField1.setText("jFormattedTextField1");

        setBackground(new java.awt.Color(0, 153, 51));
        setPreferredSize(new java.awt.Dimension(1274, 464));

        jPanel1.setBackground(new java.awt.Color(0, 153, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quản Lý Nhân Viên");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 153, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tbNhanVien.setModel(new javax.swing.table.DefaultTableModel(
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
        tbNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbNhanVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbNhanVien);

        btnDau.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDau.setText("|<<");
        btnDau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDauActionPerformed(evt);
            }
        });

        btnCuoi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCuoi.setText(">>|");
        btnCuoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCuoiActionPerformed(evt);
            }
        });

        btnLui.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLui.setText("<<");
        btnLui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuiActionPerformed(evt);
            }
        });

        btntien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btntien.setText(">>");
        btntien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntienActionPerformed(evt);
            }
        });

        jLabel11.setText("Tìm Kiếm :");

        txtTim.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnDau, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(btnLui, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 746, Short.MAX_VALUE)
                        .addComponent(btntien, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(btnCuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDau, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLui, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btntien, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 153, 51));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setText("Tên nhân viên :");

        jLabel4.setText("Chức vụ :");

        jLabel5.setText("Giới tính :");

        jLabel6.setText("Ngày Sinh");

        buttonGroup1.add(rbnNam);
        rbnNam.setText("Nam");

        buttonGroup1.add(rbnNu);
        rbnNu.setText("Nữ");

        cboChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setText("SĐT:");

        jLabel8.setText("Địa chỉ :");

        chekNghi.setText("Nghỉ");
        chekNghi.setEnabled(false);
        chekNghi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chekNghiActionPerformed(evt);
            }
        });

        jlbTrangThai.setText("Trạng thái :");

        jLabel12.setText("Email :");

        jLabel13.setText("Mã nhân viên :");

        txtMaNV.setEditable(false);

        jPanel4.setBackground(new java.awt.Color(255, 153, 51));

        btnNew.setText("Làm mới bản ghi");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXuatFile.setText("Xuất file");
        btnXuatFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatFileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNew, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnThem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                    .addComponent(btnSua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXuatFile, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnXuatFile, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel9.setText("CCCD :");

        txtNgaySinh.setDateFormatString("dd-MM-yyyy");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel13)
                    .addComponent(jLabel9))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtTenNhanVien, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCccd, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(rbnNam, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(rbnNu, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtMaNV, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel12))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jlbTrangThai)
                        .addGap(18, 18, 18)
                        .addComponent(chekNghi))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDiaChi)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(129, 129, 129)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(jLabel6))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(58, 58, 58)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel9)
                                                    .addComponent(txtCccd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(114, 114, 114)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(txtTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel3))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(cboChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel4))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(rbnNam, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(rbnNu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel5)))))
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel13)
                                        .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addGap(10, 10, 10)
                                            .addComponent(jLabel12)))
                                    .addGap(20, 20, 20)
                                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jlbTrangThai)
                                        .addComponent(chekNghi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(20, 20, 20))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        // TODO add your handling code here:
//        txtSTT.setText(null);
        txtMaNV.setText(null);
        txtCccd.setText(null);
        txtNgaySinh.setCalendar(null);
        txtTenNhanVien.setText(null);
        cboChucVu.setSelectedItem(0);
        txtDiaChi.setText(null);
        txtEmail.setText(null);
        txtSDT.setText(null);
        rbnNam.setSelected(true);
        rbnNu.setSelected(false);
        chekNghi.setSelected(false);
        chekNghi.setEnabled(false);
        txtCccd.setEnabled(true);
//        txtMatKhau.setText(null);
    }//GEN-LAST:event_btnNewActionPerformed

    private void tbNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbNhanVienMouseClicked
        // TODO add your handling code here:
        int row = tbNhanVien.getSelectedRow();
//        txtSTT.setText(tbNhanVien.getValueAt(row, 0).toString());
        txtMaNV.setText(tbNhanVien.getValueAt(row, 1).toString());
        txtCccd.setText(tbNhanVien.getValueAt(row, 2).toString());
        txtTenNhanVien.setText(tbNhanVien.getValueAt(row, 3).toString());
        cboChucVu.setSelectedItem(tbNhanVien.getValueAt(row, 4).toString());
        if (tbNhanVien.getValueAt(row, 5).toString().equalsIgnoreCase("Nam")) {
            rbnNam.setSelected(true);
        } else {
            rbnNu.setSelected(true);
        }
        txtEmail.setText(tbNhanVien.getValueAt(row, 6).toString());
        try {
            Date ngayS = new SimpleDateFormat("dd-MM-yyyy").parse(tbNhanVien.getValueAt(row, 7).toString());
            txtNgaySinh.setDate(ngayS);
        } catch (Exception e) {
        }
        txtSDT.setText(tbNhanVien.getValueAt(row, 8).toString());
        txtDiaChi.setText(tbNhanVien.getValueAt(row, 9).toString());
//        txtMatKhau.setText(tbNhanVien.getValueAt(row, 9).toString());
        if (tbNhanVien.getValueAt(row, 10).toString().equalsIgnoreCase("Nghỉ làm")) {
            chekNghi.setSelected(true);
        } else {
            chekNghi.setSelected(false);
        }
        txtCccd.setEnabled(false);
        chekNghi.setEnabled(true);
    }//GEN-LAST:event_tbNhanVienMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        if (validator().length() > 0) {
            JOptionPane.showMessageDialog(this, sb.toString());
            return;
        }
        List<NhanVien> listNV = viewNhanVienService.getNhanVien();
        NhanVien nhanVien = new NhanVien();
        String i = "1";
        nhanVien.autoPass(i);
        nhanVien.setMaNV(zenMaNV(listNV));
        nhanVien.setCccd(txtCccd.getText());
        nhanVien.setTenNhanVien(txtTenNhanVien.getText());
        ChucVu chucVu = viewChucVuService.getChucVu().get(cboChucVu.getSelectedIndex());
        nhanVien.setChucVu(chucVu);
        Boolean gioiTinh = false;
        if (rbnNam.isSelected()) {
            gioiTinh = true;
        }
        nhanVien.setGioiTinh(gioiTinh);
        nhanVien.setEmail(txtEmail.getText());
        try {
            String ngayS = doiNgay(txtNgaySinh.getDate());
            Date ngaySinh = format.parse(ngayS);
            nhanVien.setNgaySinh(ngaySinh);
        } catch (Exception e) {
            e.printStackTrace();
        }
        nhanVien.setSDT(txtSDT.getText());
        nhanVien.setDiaChi(txtDiaChi.getText());
//        nhanVien.setMatKhau(txtMatKhau.getText());
        nhanVien.setTrangThai(chekNghi.isSelected());
        if (viewNhanVienService.them(nhanVien)) {
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            LoadTable((ArrayList<NhanVien>) viewNhanVienService.getNhanVien());
            sendMail();
        } else {
            JOptionPane.showMessageDialog(this, "Thêm thất bại");
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXuatFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatFileActionPerformed
        // TODO add your handling code here:
        String CurentDirectoryFilePath = "C:\\Users\\user\\Documents\\DA1_XuatNhanVien";
        JFileChooser execlExportChooser = new JFileChooser(CurentDirectoryFilePath);
        FileNameExtensionFilter excelFNEF = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlsm");
        execlExportChooser.setFileFilter(excelFNEF);
        execlExportChooser.setDialogTitle("Save excel... ");

        int excelChooser = execlExportChooser.showSaveDialog(null);
        if (excelChooser == JFileChooser.APPROVE_OPTION) {
            XSSFWorkbook exceSSFWorkbookExprort = new XSSFWorkbook();
            XSSFSheet excelSheet = exceSSFWorkbookExprort.createSheet("Danh Sach");
            for (int i = 0; i < defaultTableModel.getRowCount(); i++) {
                XSSFRow excelRow = excelSheet.createRow(i);
                for (int j = 0; j < defaultTableModel.getColumnCount(); j++) {
                    XSSFCell excelCell = excelRow.createCell(j);
                    excelCell.setCellValue(defaultTableModel.getValueAt(i, j).toString());
                }
            }
            FileOutputStream excelFIS;
            BufferedOutputStream excelBOU;
            try {
                excelFIS = new FileOutputStream(execlExportChooser.getSelectedFile() + ".xlsx");
                excelBOU = new BufferedOutputStream(excelFIS);
                exceSSFWorkbookExprort.write(excelBOU);
                excelBOU.close();
                exceSSFWorkbookExprort.close();
                JOptionPane.showMessageDialog(this, "Xuất danh sách thành công");
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_btnXuatFileActionPerformed

    private void chekNghiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chekNghiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chekNghiActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        int index = tbNhanVien.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Chưa chọn dòng");
        }
        if (validatorSua().length() > 0) {
            JOptionPane.showMessageDialog(this, sb.toString());
            return;
        } else {
            NhanVien nhanVien = viewNhanVienService.getNhanVien().get(index);
            nhanVien.setMaNV(txtMaNV.getText());
//            nhanVien.setCccd(txtCccd.getText());
            nhanVien.setTenNhanVien(txtTenNhanVien.getText());
            ChucVu chucVu = viewChucVuService.getChucVu().get(cboChucVu.getSelectedIndex());
            nhanVien.setChucVu(chucVu);
            Boolean gioiTinh = false;
            if (rbnNam.isSelected()) {
                gioiTinh = true;
            }
            nhanVien.setGioiTinh(gioiTinh);
            nhanVien.setEmail(txtEmail.getText());
            try {
                String ngayS = doiNgay(txtNgaySinh.getDate());
                Date ngaySinh = format.parse(ngayS);
                nhanVien.setNgaySinh(ngaySinh);
            } catch (Exception e) {
                e.printStackTrace();
            }
            nhanVien.setSDT(txtSDT.getText());
            nhanVien.setDiaChi(txtDiaChi.getText());
//      nhanVien.setMatKhau(txtMatKhau.getText());
            nhanVien.setTrangThai(chekNghi.isSelected());
            if (viewNhanVienService.sua(nhanVien)) {
                JOptionPane.showMessageDialog(this, "Sửa thành công");
                LoadTable((ArrayList<NhanVien>) viewNhanVienService.getNhanVien());
            } else {
                JOptionPane.showMessageDialog(this, "Sửa thất bại");
            }
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnDauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDauActionPerformed
        // TODO add your handling code here:
        int row = 0;
        tbNhanVien.setRowSelectionInterval(row, row);
        loadTextFile(row);
    }//GEN-LAST:event_btnDauActionPerformed

    private void btnCuoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCuoiActionPerformed
        // TODO add your handling code here:
        int row = viewNhanVienService.getNhanVien().size() - 1;
        tbNhanVien.setRowSelectionInterval(row, row);
        loadTextFile(row);
    }//GEN-LAST:event_btnCuoiActionPerformed

    private void btntienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntienActionPerformed
        // TODO add your handling code here:
        int row = tbNhanVien.getSelectedRow();
        if (row == tbNhanVien.getRowCount() - 1) {
            btntienActionPerformed(evt);
        } else {
            row++;
        }
        tbNhanVien.setRowSelectionInterval(row, row);
        loadTextFile(row);
    }//GEN-LAST:event_btntienActionPerformed

    private void btnLuiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuiActionPerformed
        // TODO add your handling code here:
        int row = tbNhanVien.getSelectedRow();
        if (row == 0) {
            btntienActionPerformed(evt);
        } else {
            row--;
        }
        tbNhanVien.setRowSelectionInterval(row, row);
        loadTextFile(row);
    }//GEN-LAST:event_btnLuiActionPerformed

    private void txtTimKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKeyReleased
        // TODO add your handling code here:
        ArrayList<NhanVien> lst = new ArrayList<>();
        for (NhanVien nv : viewNhanVienService.getNhanVien()) {
            if (nv.getTenNhanVien().contains(txtTim.getText()) || nv.getMaNV().contains(txtTim.getText()) || nv.getCccd().contains(txtTim.getText())) {
                lst.add(nv);
            }
        }
        LoadTable(lst);
    }//GEN-LAST:event_txtTimKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCuoi;
    private javax.swing.JButton btnDau;
    private javax.swing.JButton btnLui;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXuatFile;
    private javax.swing.JButton btntien;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboChucVu;
    private javax.swing.JCheckBox chekNghi;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlbTrangThai;
    private javax.swing.JRadioButton rbnNam;
    private javax.swing.JRadioButton rbnNu;
    private javax.swing.JTable tbNhanVien;
    private javax.swing.JTextField txtCccd;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMaNV;
    private com.toedter.calendar.JDateChooser txtNgaySinh;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenNhanVien;
    private javax.swing.JTextField txtTim;
    // End of variables declaration//GEN-END:variables

}
