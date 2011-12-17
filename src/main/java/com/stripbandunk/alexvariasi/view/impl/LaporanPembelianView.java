/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stripbandunk.alexvariasi.view.impl;

import com.stripbandunk.alexvariasi.entity.transaction.Pembelian;
import com.stripbandunk.alexvariasi.manager.SpringManager;
import com.stripbandunk.alexvariasi.service.PembelianService;
import com.stripbandunk.alexvariasi.view.DialogView;
import com.stripbandunk.alexvariasi.view.FormApp;
import com.stripbandunk.jwidget.JDynamicTable;
import com.stripbandunk.jwidget.model.DynamicTableModel;
import java.awt.Window;
import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JExcelApiExporter;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.jdbc.Work;

/**
 *
 * @author echo
 */
public class LaporanPembelianView extends DialogView {

    private JDynamicTable jDynamicTable;

    private DynamicTableModel<Pembelian> dynamicTableModel;

    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    private Date from;

    private Date to;

    public LaporanPembelianView(FormApp formApp, Date from, Date to) {
        super(formApp);
        initComponents();

        this.from = from;
        this.to = to;

        dynamicTableModel = new DynamicTableModel<>(Pembelian.class);
        jDynamicTable = new JDynamicTable(dynamicTableModel);
        jScrollPane1.setViewportView(jDynamicTable);

        PembelianService penjualanService = SpringManager.getInstance().getBean(PembelianService.class);
        List<Pembelian> list = penjualanService.findAll(from, to);
        for (Pembelian penjualan : list) {
            dynamicTableModel.add(penjualan);
        }

        jLabelJudul.setText("dari tanggal " + dateFormat.format(from) + " sampai " + dateFormat.format(to));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jButtonTutup = new javax.swing.JButton();
        jButtonExcel = new javax.swing.JButton();
        jButtonPdf = new javax.swing.JButton();
        jButtonCetak = new javax.swing.JButton();
        jLabelJudul = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(jLabel1.getFont().deriveFont(jLabel1.getFont().getStyle() | java.awt.Font.BOLD, 24));
        jLabel1.setText("Laporan Pembelian");

        jButtonTutup.setText("Tutup");
        jButtonTutup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTutupActionPerformed(evt);
            }
        });

        jButtonExcel.setText("Simpan (Excel)");
        jButtonExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcelActionPerformed(evt);
            }
        });

        jButtonPdf.setText("Simpan (PDF)");
        jButtonPdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPdfActionPerformed(evt);
            }
        });

        jButtonCetak.setText("Cetak");
        jButtonCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCetakActionPerformed(evt);
            }
        });

        jLabelJudul.setText("Dari Tanggal {} Sampai {}");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 250, Short.MAX_VALUE)
                        .addComponent(jButtonCetak)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonPdf)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonExcel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonTutup))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabelJudul))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelJudul)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonTutup)
                    .addComponent(jButtonExcel)
                    .addComponent(jButtonPdf)
                    .addComponent(jButtonCetak))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonTutupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTutupActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonTutupActionPerformed

    private void jButtonCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCetakActionPerformed
        SessionFactory sessionFactory = SpringManager.getInstance().getBean(SessionFactory.class);
        Session session = sessionFactory.openSession();
        session.doWork(new Work() {

            @Override
            public void execute(Connection connection) throws SQLException {
                try {
                    InputStream inputStream = LaporanPenjualanView.class.getResourceAsStream("/com/stripbandunk/alexvariasi/report/LaporanPembelian.jasper");

                    Map<String, Object> map = new HashMap<>();
                    map.put("FROM", from);
                    map.put("TO", to);
                    map.put(JRParameter.REPORT_CONNECTION, connection);
                    map.put(JRParameter.REPORT_LOCALE, new Locale("in", "ID"));

                    JasperPrint print = JasperFillManager.fillReport(inputStream, map);
                    CetakLaporanView view = new CetakLaporanView(getFormApp(), print);
                    view.display(LaporanPembelianView.this, null);
                } catch (JRException ex) {
                    Logger.getLogger(LaporanPenjualanView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        session.close();
    }//GEN-LAST:event_jButtonCetakActionPerformed

    private void jButtonPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPdfActionPerformed
        SessionFactory sessionFactory = SpringManager.getInstance().getBean(SessionFactory.class);
        Session session = sessionFactory.openSession();
        session.doWork(new Work() {

            @Override
            public void execute(Connection connection) throws SQLException {
                try {
                    InputStream inputStream = LaporanPenjualanView.class.getResourceAsStream("/com/stripbandunk/alexvariasi/report/LaporanPembelian.jasper");

                    Map<String, Object> map = new HashMap<>();
                    map.put("FROM", from);
                    map.put("TO", to);
                    map.put(JRParameter.REPORT_CONNECTION, connection);
                    map.put(JRParameter.REPORT_LOCALE, new Locale("in", "ID"));

                    JasperPrint print = JasperFillManager.fillReport(inputStream, map);
                    if (jFileChooser1.showSaveDialog(LaporanPembelianView.this) == JFileChooser.APPROVE_OPTION) {
                        File file = jFileChooser1.getSelectedFile();
                        if (!file.getName().endsWith(".pdf")) {
                            file = new File(file.getPath() + ".pdf");
                        }
                        JasperExportManager.exportReportToPdfFile(print, file.getPath());
                    }
                } catch (JRException ex) {
                    Logger.getLogger(LaporanPenjualanView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        session.close();
    }//GEN-LAST:event_jButtonPdfActionPerformed

    private void jButtonExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcelActionPerformed
        SessionFactory sessionFactory = SpringManager.getInstance().getBean(SessionFactory.class);
        Session session = sessionFactory.openSession();
        session.doWork(new Work() {

            @Override
            public void execute(Connection connection) throws SQLException {
                try {
                    InputStream inputStream = LaporanPenjualanView.class.getResourceAsStream("/com/stripbandunk/alexvariasi/report/LaporanPembelian.jasper");

                    Map<String, Object> map = new HashMap<>();
                    map.put("FROM", from);
                    map.put("TO", to);
                    map.put(JRParameter.REPORT_CONNECTION, connection);
                    map.put(JRParameter.REPORT_LOCALE, new Locale("in", "ID"));

                    JasperPrint print = JasperFillManager.fillReport(inputStream, map);
                    if (jFileChooser1.showSaveDialog(LaporanPembelianView.this) == JFileChooser.APPROVE_OPTION) {
                        File file = jFileChooser1.getSelectedFile();
                        if (!file.getName().endsWith(".xls")) {
                            file = new File(file.getPath() + ".xls");
                        }
                        JRExporter exporter = new JExcelApiExporter();
                        exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
                        exporter.setParameter(JRExporterParameter.OUTPUT_FILE, file);
                        exporter.exportReport();
                    }
                } catch (JRException ex) {
                    Logger.getLogger(LaporanPenjualanView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        session.close();
    }//GEN-LAST:event_jButtonExcelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCetak;
    private javax.swing.JButton jButtonExcel;
    private javax.swing.JButton jButtonPdf;
    private javax.swing.JButton jButtonTutup;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelJudul;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void display(Window formApp, Object parameter) {
        setLocationRelativeTo(formApp);
        setVisible(true);
    }
}