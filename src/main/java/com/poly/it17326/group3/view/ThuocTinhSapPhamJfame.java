/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.poly.it17326.group3.view;

import com.poly.it17326.group3.domainmodels.DongSp;
import com.poly.it17326.group3.domainmodels.MauSac;
import com.poly.it17326.group3.domainmodels.Nsx;
import com.poly.it17326.group3.domainmodels.SanPham;
import com.poly.it17326.group3.domainmodels.Size;
import com.poly.it17326.group3.repository.SanPhamRepository;
import com.poly.it17326.group3.response.MauSacReponse;
import com.poly.it17326.group3.service.ViewDongSpService;
import com.poly.it17326.group3.service.ViewMauSacService;
import com.poly.it17326.group3.service.ViewNSXService;
import com.poly.it17326.group3.service.ViewSizeService;
import com.poly.it17326.group3.service.impl.ChiTietSpServiceImpl;
import com.poly.it17326.group3.service.impl.DongSpServiceImpl;
import com.poly.it17326.group3.service.impl.MauSacServiceImpl;
import com.poly.it17326.group3.service.impl.NSXSeviceImpl;
import com.poly.it17326.group3.service.impl.SanPhamServiceImpl;
import com.poly.it17326.group3.service.impl.SizeServiceImpl;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author doand
 */
public class ThuocTinhSapPhamJfame extends javax.swing.JFrame {

    private ViewSizeService sizeService = new SizeServiceImpl();
    private SanPhamServiceImpl sanPhamServiceImpl = new SanPhamServiceImpl();
    private SanPhamRepository sanPhamRepository = new SanPhamRepository();
    private ViewDongSpService dongSpService = new DongSpServiceImpl();
    private ViewMauSacService mauSacService = new MauSacServiceImpl();
    private ViewNSXService nSXService = new NSXSeviceImpl();
    private DefaultTableModel defaultTableModel;
    private ChiTietSpServiceImpl chiTietSpServiceImpl = new ChiTietSpServiceImpl();

    private List<Nsx> listNsx = chiTietSpServiceImpl.getNsx();
    private List<MauSac> listMauSac = chiTietSpServiceImpl.getMauSac();
    private List<DongSp> listDongSp = chiTietSpServiceImpl.getDongSp();
    private List<SanPham> listSanPham = chiTietSpServiceImpl.getSanPham();
    private List<Size> listSize = chiTietSpServiceImpl.getSize();

    /**
     * Creates new form ThuocTinhSapPhamJfame
     */
    public Boolean checkNsx() {
        Boolean check = true;
        for (Nsx nsx : listNsx) {
            if (nsx.getTen().equalsIgnoreCase(txtTenDongSp.getText())) {
                check = false;
            }
        }
        return check;
    }

    public Boolean checkMauSac() {
        Boolean check = true;
        for (MauSac mauSac : listMauSac) {
            if (mauSac.getTen().equalsIgnoreCase(txtTenMauSac.getText())) {
                check = false;
            }
        }
        return check;
    }

    public Boolean checkDongSp() {
        Boolean check = true;
        for (DongSp dongSp : listDongSp) {
            if (dongSp.getTen().equalsIgnoreCase(txtTenDongSp.getText())) {
                check = false;
            }
        }
        return check;
    }

    public Boolean checkSanPham() {
        Boolean check = true;
        for (SanPham sanPham : listSanPham) {
            if (sanPham.getTen().equalsIgnoreCase(txtSanPham.getText())) {
                check = false;
            }
        }
        return check;
    }

    public void loaddataSize(List<Size> list) {
        defaultTableModel = (DefaultTableModel) tblSize.getModel();
        defaultTableModel.setRowCount(0);
        for (Size s : list) {
            defaultTableModel.addRow(new Object[]{s.getId(), s.getTen()});
        }
    }

    public void loadDataSp(List<SanPham> list) {
        DefaultTableModel model = (DefaultTableModel) tblSanPham.getModel();
        model.setRowCount(0);
        model.setColumnIdentifiers(new Object[]{"id", "ten"});
        for (SanPham SanPham : list) {
            Object[] row = new Object[]{
                SanPham.getId(), SanPham.getTen()
            };
            model.addRow(row);
        }

    }

    public void loadDataDongSp(List<DongSp> list) {
        defaultTableModel = (DefaultTableModel) tblDongSp.getModel();
        defaultTableModel.setColumnIdentifiers(new String[]{"ID", "Tên"});
        defaultTableModel.setRowCount(0);
        for (DongSp dongSp : list) {
            defaultTableModel.addRow(new Object[]{dongSp.getId(), dongSp.getTen()});
        }
    }

    public void loadDataMau(List<MauSac> list) {
        defaultTableModel = (DefaultTableModel) tblMauSac.getModel();
        defaultTableModel.setColumnIdentifiers(new String[]{"ID", "Tên"});
        defaultTableModel.setRowCount(0);
        for (MauSac mauSac : list) {
            defaultTableModel.addRow(new Object[]{mauSac.getId(), mauSac.getTen()});
        }
    }

    public void loaddataNSx(List<Nsx> list) {
        defaultTableModel = (DefaultTableModel) tblNsx.getModel();
        defaultTableModel.setRowCount(0);
        for (Nsx s : list) {
            defaultTableModel.addRow(new Object[]{s.getId(), s.getTen()});
        }
    }

    public Boolean checkSize() {
        Boolean check = true;
        for (Size size : listSize) {
            if (size.getTen().equalsIgnoreCase(txtTenSize.getText())) {
                check = false;
            }
        }
        return check;
    }

    public ThuocTinhSapPhamJfame() {
        initComponents();
        loaddataSize(sizeService.getAll());
        loadDataSp(sanPhamRepository.getAll());
        loadDataDongSp(dongSpService.getAll());
        loadDataMau(mauSacService.getAll());
//        loadDataSp1(AnhRepository.getAll());
        loaddataNSx(nSXService.getNSX());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblSize = new javax.swing.JTable();
        btnThemSize = new javax.swing.JButton();
        btnSuaSize = new javax.swing.JButton();
        btnXoa1 = new javax.swing.JButton();
        txtTenSize = new javax.swing.JTextField();
        txtIdSize = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        txtIdSp = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txtSanPham = new javax.swing.JTextField();
        btnThemSanPham = new javax.swing.JButton();
        btnSuaSanPham = new javax.swing.JButton();
        btnXoaSanPham = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        txtIdDongSp = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtTenDongSp = new javax.swing.JTextField();
        btnThemDongSp = new javax.swing.JButton();
        btnSuaDongSp = new javax.swing.JButton();
        btnXoaDongSp = new javax.swing.JButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        tblDongSp = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        txtIdMauSAc = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        txtTenMauSac = new javax.swing.JTextField();
        btnThemMauSac = new javax.swing.JButton();
        btnSuaMauSac = new javax.swing.JButton();
        btnXoaMauSac = new javax.swing.JButton();
        jScrollPane12 = new javax.swing.JScrollPane();
        tblMauSac = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        tblNsx = new javax.swing.JTable();
        btnXoaNsx = new javax.swing.JButton();
        btnSuaNsx = new javax.swing.JButton();
        btnThemNsx = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        txtTenNsx = new javax.swing.JTextField();
        txtIdNsx = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        tblSize.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        tblSize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSizeMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblSize);

        btnThemSize.setText("Thêm");
        btnThemSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSizeActionPerformed(evt);
            }
        });

        btnSuaSize.setText("Sửa");
        btnSuaSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaSizeActionPerformed(evt);
            }
        });

        btnXoa1.setText("Xóa");
        btnXoa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoa1ActionPerformed(evt);
            }
        });

        jLabel11.setText("ID");

        jLabel10.setText("Tên");

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(124, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(47, 47, 47)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(37, 37, 37)
                            .addComponent(btnThemSize)
                            .addGap(63, 63, 63)
                            .addComponent(btnSuaSize)
                            .addGap(79, 79, 79)
                            .addComponent(btnXoa1))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(52, 52, 52)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel11)
                                .addComponent(jLabel10))
                            .addGap(36, 36, 36)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtTenSize, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtIdSize, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(48, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(404, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(100, 100, 100)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(txtIdSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(21, 21, 21)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(txtTenSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnThemSize)
                        .addComponent(btnSuaSize)
                        .addComponent(btnXoa1))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(101, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Size", jPanel1);

        jLabel26.setText("ID");

        jLabel25.setText("Tên");

        btnThemSanPham.setText("Thêm");
        btnThemSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSanPhamActionPerformed(evt);
            }
        });

        btnSuaSanPham.setText("Sửa");
        btnSuaSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaSanPhamActionPerformed(evt);
            }
        });

        btnXoaSanPham.setText("Xóa");
        btnXoaSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaSanPhamActionPerformed(evt);
            }
        });

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
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
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(tblSanPham);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 507, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(47, 47, 47)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(37, 37, 37)
                            .addComponent(btnThemSanPham)
                            .addGap(63, 63, 63)
                            .addComponent(btnSuaSanPham)
                            .addGap(79, 79, 79)
                            .addComponent(btnXoaSanPham))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(52, 52, 52)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel26)
                                .addComponent(jLabel25))
                            .addGap(36, 36, 36)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtIdSp, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(48, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(100, 100, 100)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel26)
                        .addComponent(txtIdSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(21, 21, 21)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel25)
                        .addComponent(txtSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnThemSanPham)
                        .addComponent(btnSuaSanPham)
                        .addComponent(btnXoaSanPham))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(101, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("SanPham", jPanel2);

        jLabel29.setText("ID");

        jLabel28.setText("Tên");

        btnThemDongSp.setText("Thêm");
        btnThemDongSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemDongSpActionPerformed(evt);
            }
        });

        btnSuaDongSp.setText("Sửa");
        btnSuaDongSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaDongSpActionPerformed(evt);
            }
        });

        btnXoaDongSp.setText("Xóa");
        btnXoaDongSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaDongSpActionPerformed(evt);
            }
        });

        tblDongSp.setModel(new javax.swing.table.DefaultTableModel(
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
        tblDongSp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDongSpMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(tblDongSp);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 507, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(47, 47, 47)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(37, 37, 37)
                            .addComponent(btnThemDongSp)
                            .addGap(63, 63, 63)
                            .addComponent(btnSuaDongSp)
                            .addGap(79, 79, 79)
                            .addComponent(btnXoaDongSp))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(52, 52, 52)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel29)
                                .addComponent(jLabel28))
                            .addGap(36, 36, 36)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtTenDongSp, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtIdDongSp, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(48, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(100, 100, 100)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel29)
                        .addComponent(txtIdDongSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(21, 21, 21)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel28)
                        .addComponent(txtTenDongSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnThemDongSp)
                        .addComponent(btnSuaDongSp)
                        .addComponent(btnXoaDongSp))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(101, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("DongSP", jPanel3);

        jLabel32.setText("ID");

        jLabel31.setText("Tên");

        btnThemMauSac.setText("Thêm");
        btnThemMauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMauSacActionPerformed(evt);
            }
        });

        btnSuaMauSac.setText("Sửa");
        btnSuaMauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaMauSacActionPerformed(evt);
            }
        });

        btnXoaMauSac.setText("Xóa");
        btnXoaMauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaMauSacActionPerformed(evt);
            }
        });

        tblMauSac.setModel(new javax.swing.table.DefaultTableModel(
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
        tblMauSac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMauSacMouseClicked(evt);
            }
        });
        jScrollPane12.setViewportView(tblMauSac);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 507, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(47, 47, 47)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(37, 37, 37)
                            .addComponent(btnThemMauSac)
                            .addGap(63, 63, 63)
                            .addComponent(btnSuaMauSac)
                            .addGap(79, 79, 79)
                            .addComponent(btnXoaMauSac))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(52, 52, 52)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel32)
                                .addComponent(jLabel31))
                            .addGap(36, 36, 36)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtTenMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtIdMauSAc, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(48, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(100, 100, 100)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel32)
                        .addComponent(txtIdMauSAc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(21, 21, 21)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel31)
                        .addComponent(txtTenMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnThemMauSac)
                        .addComponent(btnSuaMauSac)
                        .addComponent(btnXoaMauSac))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(101, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("MauSac", jPanel4);

        tblNsx.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        tblNsx.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNsxMouseClicked(evt);
            }
        });
        jScrollPane14.setViewportView(tblNsx);

        btnXoaNsx.setText("Xóa");
        btnXoaNsx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaNsxActionPerformed(evt);
            }
        });

        btnSuaNsx.setText("Sửa");
        btnSuaNsx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaNsxActionPerformed(evt);
            }
        });

        btnThemNsx.setText("Thêm");
        btnThemNsx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemNsxActionPerformed(evt);
            }
        });

        jLabel37.setText("Tên");

        jLabel38.setText("ID");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 507, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(47, 47, 47)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGap(37, 37, 37)
                            .addComponent(btnThemNsx)
                            .addGap(63, 63, 63)
                            .addComponent(btnSuaNsx)
                            .addGap(79, 79, 79)
                            .addComponent(btnXoaNsx))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGap(52, 52, 52)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel38)
                                .addComponent(jLabel37))
                            .addGap(36, 36, 36)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtTenNsx, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtIdNsx, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(48, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(100, 100, 100)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel38)
                        .addComponent(txtIdNsx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(21, 21, 21)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel37)
                        .addComponent(txtTenNsx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnThemNsx)
                        .addComponent(btnSuaNsx)
                        .addComponent(btnXoaNsx))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(101, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("NSX", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblSizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSizeMouseClicked
        // TODO add your handling code here:
        int row = tblSize.getSelectedRow();
        txtIdSize.setText(tblSize.getValueAt(row, 0).toString());
        txtTenSize.setText(tblSize.getValueAt(row, 1).toString());
    }//GEN-LAST:event_tblSizeMouseClicked

    private void btnThemSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSizeActionPerformed
        // TODO add your handling code here:
        try {

            Size size = new Size();
            size.setTen(txtTenSize.getText());
            if (txtTenSize.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "dien size");
                return;
            }
            if (!checkSize()) {
                JOptionPane.showMessageDialog(this, "size da ton tai");
                return;
            }
            if (sizeService.save(size)) {
                JOptionPane.showMessageDialog(this, "Sửa thành công");
                loaddataSize(sizeService.getAll());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_btnThemSizeActionPerformed

    private void btnSuaSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaSizeActionPerformed
        // TODO add your handling code here:

        try {

            int index = tblSize.getSelectedRow();
            Size size = sizeService.getAll().get(index);
            size.setTen(txtTenSize.getText());
            if (!checkSize()) {
                JOptionPane.showMessageDialog(this, "size da ton tai");
                return;
            }
            if (sizeService.update(size)) {
                JOptionPane.showMessageDialog(this, "Sửa thành công");
                loaddataSize(sizeService.getAll());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSuaSizeActionPerformed

    private void btnXoa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoa1ActionPerformed
        // TODO add your handling code here:
        int index = tblSize.getSelectedRow();
        Size chatLieu = sizeService.getAll().get(index);
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Xóa thất bại");
        } else if (sizeService.delete(chatLieu)) {
            JOptionPane.showMessageDialog(this, "Xóa thành công");
            loaddataSize(sizeService.getAll());
        } else {
            JOptionPane.showMessageDialog(this, "Xóa thất bại");
        }
    }//GEN-LAST:event_btnXoa1ActionPerformed

    private void btnThemSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSanPhamActionPerformed
        // TODO add your handling code here:

        try {

            int index = tblSanPham.getSelectedRow();
            SanPham sp = new SanPham();
            sp.setTen(txtTenSize.getText());
            
            if (txtSanPham.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "da ton tai san pham nay");
                return;
            }
            if (!checkSanPham()) {
                JOptionPane.showMessageDialog(this, "da ton tai san pham nay");
                return;
            }
            if (sanPhamRepository.add(sp) == true) {
                JOptionPane.showMessageDialog(this, "Sửa Thành công");
                loadDataSp(sanPhamServiceImpl.getAll());
                return;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_btnThemSanPhamActionPerformed

    private void btnSuaSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaSanPhamActionPerformed
        // TODO add your handling code here:

        try {

            int index = tblSanPham.getSelectedRow();
            SanPham sp = sanPhamServiceImpl.getAll().get(index);
            sp.setTen(txtSanPham.getText());
            if (!checkSanPham()) {
                JOptionPane.showMessageDialog(this, "da ton tai size nay");
                return;
            }
            if (sanPhamRepository.update(sp) == true) {
                JOptionPane.showMessageDialog(this, "Sửa Thành công");
                loadDataSp(sanPhamServiceImpl.getAll());
                return;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSuaSanPhamActionPerformed

    private void btnXoaSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaSanPhamActionPerformed
        // TODO add your handling code here:
        int index = tblSanPham.getSelectedRow();
        SanPham SanPham = sanPhamServiceImpl.getAll().get(index);
        if (sanPhamServiceImpl.Delete(SanPham)) {
            JOptionPane.showMessageDialog(this, "Xóa Thành công");
            loadDataSp(sanPhamServiceImpl.getAll());
        }
    }//GEN-LAST:event_btnXoaSanPhamActionPerformed

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        // TODO add your handling code here:
        int index = tblSanPham.getSelectedRow();
        txtIdSp.setText(tblSanPham.getValueAt(index, 0).toString());
        txtSanPham.setText((String) tblSanPham.getValueAt(index, 1));
    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void btnThemDongSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemDongSpActionPerformed
        // TODO add your handling code here
        try {
            DongSp dongSp = new DongSp();
            dongSp.setTen(txtTenDongSp.getText());
            if (txtTenDongSp.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, " dien dongsp");
                return;
            }
            if (!checkDongSp()) {
                JOptionPane.showMessageDialog(this, "da ton tai");
                return;
            }
            if (dongSpService.add(dongSp)) {
                JOptionPane.showMessageDialog(this, "Them thành công");
                loadDataDongSp(dongSpService.getAll());
            }

        } catch (Exception e) {
        }


    }//GEN-LAST:event_btnThemDongSpActionPerformed

    private void btnSuaDongSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaDongSpActionPerformed
        // TODO add your handling code here:

        try {
            int index = tblDongSp.getSelectedRow();
            DongSp dongSp = dongSpService.getAll().get(index);
            dongSp.setTen(txtTenDongSp.getText());
            if (txtTenDongSp.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, " dien dongsp");
                return;
            } 
            if (!checkDongSp()) {
                JOptionPane.showMessageDialog(this, "da ton tai");
                return;
            }
            if (dongSpService.add(dongSp)) {
                JOptionPane.showMessageDialog(this, "Them thành công");
                loadDataDongSp(dongSpService.getAll());
            }

        } catch (Exception e) {
        }

    }//GEN-LAST:event_btnSuaDongSpActionPerformed

    private void btnXoaDongSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaDongSpActionPerformed
        // TODO add your handling code here:
        int index = tblDongSp.getSelectedRow();
        DongSp dongSp = dongSpService.getAll().get(index);
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Xóa thất bại");
        } else if (dongSpService.delete(dongSp)) {
            JOptionPane.showMessageDialog(this, "Xóa thành công");
            loadDataDongSp(dongSpService.getAll());
        } else {
            JOptionPane.showMessageDialog(this, "Xóa thất bại");
        }
    }//GEN-LAST:event_btnXoaDongSpActionPerformed

    private void tblDongSpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDongSpMouseClicked
        // TODO add your handling code here:
        int row = tblDongSp.getSelectedRow();
        txtIdDongSp.setText(tblDongSp.getValueAt(row, 0).toString());
        txtTenDongSp.setText(tblDongSp.getValueAt(row, 1).toString());
    }//GEN-LAST:event_tblDongSpMouseClicked

    private void btnThemMauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMauSacActionPerformed
        // TODO add your handling code here:
        try {

            MauSac mauSac = new MauSac();
            mauSac.setTen(txtTenMauSac.getText());
             if (txtTenMauSac.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, " dien mau sac");
                return;
            }
            
            if (!checkMauSac()) {
                JOptionPane.showMessageDialog(this, "da ton tai");
                return;
            }
            if (mauSacService.add(mauSac)) {
                JOptionPane.showMessageDialog(this, "them thành công");
                loadDataMau(mauSacService.getAll());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_btnThemMauSacActionPerformed

    private void btnSuaMauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaMauSacActionPerformed
        // TODO add your handling code here:

        try {

            int index = tblMauSac.getSelectedRow();
            MauSac mauSac = mauSacService.getAll().get(index);
            mauSac.setTen(txtTenMauSac.getText());
            if (!checkMauSac()) {
                JOptionPane.showMessageDialog(this, "da ton tai");
                return;
            }
            if (mauSacService.add(mauSac)) {
                JOptionPane.showMessageDialog(this, "them thành công");
                loadDataMau(mauSacService.getAll());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSuaMauSacActionPerformed

    private void btnXoaMauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaMauSacActionPerformed
        // TODO add your handling code here:
        int index = tblMauSac.getSelectedRow();
        MauSac chatLieu = mauSacService.getAll().get(index);
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Xóa thất bại");
        } else if (mauSacService.delete(chatLieu)) {
            JOptionPane.showMessageDialog(this, "Xóa thành công");
            loadDataMau(mauSacService.getAll());
        } else {
            JOptionPane.showMessageDialog(this, "Xóa thất bại");
        }
    }//GEN-LAST:event_btnXoaMauSacActionPerformed

    private void tblMauSacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMauSacMouseClicked
        // TODO add your handling code here:
        int row = tblMauSac.getSelectedRow();
        txtIdMauSAc.setText(tblMauSac.getValueAt(row, 0).toString());
        txtTenMauSac.setText(tblMauSac.getValueAt(row, 1).toString());
    }//GEN-LAST:event_tblMauSacMouseClicked

    private void tblNsxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNsxMouseClicked
        // TODO add your handling code here:
        int row = tblNsx.getSelectedRow();
        txtIdNsx.setText(tblNsx.getValueAt(row, 0).toString());
        txtTenNsx.setText(tblNsx.getValueAt(row, 1).toString());
    }//GEN-LAST:event_tblNsxMouseClicked

    private void btnXoaNsxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaNsxActionPerformed
        // TODO add your handling code here:
        int index = tblNsx.getSelectedRow();
        Nsx chatLieu = nSXService.getNSX().get(index);
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Xóa thất bại");
        } else if (nSXService.delete(chatLieu)) {
            JOptionPane.showMessageDialog(this, "Xóa thành công");
            loaddataNSx(nSXService.getNSX());
        } else {
            JOptionPane.showMessageDialog(this, "Xóa thất bại");
        }
    }//GEN-LAST:event_btnXoaNsxActionPerformed

    private void btnSuaNsxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaNsxActionPerformed
        // TODO add your handling code here:

        try {
            int index = tblNsx.getSelectedRow();
            Nsx nsx = nSXService.getNSX().get(index);
            nsx.setTen(txtTenNsx.getText());
            if (!checkNsx()) {
                JOptionPane.showMessageDialog(this, "da ton tai");
                return;
            }
            if (nSXService.update(nsx)) {
                JOptionPane.showMessageDialog(this, "Sửa thành công");
                loaddataNSx(nSXService.getNSX());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSuaNsxActionPerformed

    private void btnThemNsxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemNsxActionPerformed
        // TODO add your handling code here:

        try {
            Nsx nsx = new Nsx();
            nsx.setTen(txtTenNsx.getText());
            if(txtTenNsx.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "dien nsx");
                return;
            }
            if (!checkNsx()) {
                JOptionPane.showMessageDialog(this, "da ton tai");
                return;
            }
            if (nSXService.save(nsx)) {
                JOptionPane.showMessageDialog(this, "them thành công");
                loaddataNSx(nSXService.getNSX());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_btnThemNsxActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:

        this.dispose();
    }//GEN-LAST:event_formWindowClosed

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
            java.util.logging.Logger.getLogger(ThuocTinhSapPhamJfame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThuocTinhSapPhamJfame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThuocTinhSapPhamJfame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThuocTinhSapPhamJfame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThuocTinhSapPhamJfame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSuaDongSp;
    private javax.swing.JButton btnSuaMauSac;
    private javax.swing.JButton btnSuaNsx;
    private javax.swing.JButton btnSuaSanPham;
    private javax.swing.JButton btnSuaSize;
    private javax.swing.JButton btnThemDongSp;
    private javax.swing.JButton btnThemMauSac;
    private javax.swing.JButton btnThemNsx;
    private javax.swing.JButton btnThemSanPham;
    private javax.swing.JButton btnThemSize;
    private javax.swing.JButton btnXoa1;
    private javax.swing.JButton btnXoaDongSp;
    private javax.swing.JButton btnXoaMauSac;
    private javax.swing.JButton btnXoaNsx;
    private javax.swing.JButton btnXoaSanPham;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblDongSp;
    private javax.swing.JTable tblMauSac;
    private javax.swing.JTable tblNsx;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTable tblSize;
    private javax.swing.JTextField txtIdDongSp;
    private javax.swing.JTextField txtIdMauSAc;
    private javax.swing.JTextField txtIdNsx;
    private javax.swing.JTextField txtIdSize;
    private javax.swing.JTextField txtIdSp;
    private javax.swing.JTextField txtSanPham;
    private javax.swing.JTextField txtTenDongSp;
    private javax.swing.JTextField txtTenMauSac;
    private javax.swing.JTextField txtTenNsx;
    private javax.swing.JTextField txtTenSize;
    // End of variables declaration//GEN-END:variables
}
