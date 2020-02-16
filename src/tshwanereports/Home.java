/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tshwanereports;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import static java.lang.Thread.sleep;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import net.proteanit.sql.DbUtils;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRPdfExporterParameter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 * @author Molorane
 */

public class Home extends javax.swing.JFrame {
    
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    private static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private static final Dimension appSize = new Dimension(1116,682);
    private static final int appPosX = screenSize.width/2- appSize.width/2;
    private static final int appPosY = screenSize.width/2- appSize.width/2;
    private static Rectangle appBounds = new Rectangle(appPosX,appPosY,appSize.width,appSize.height);

    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
        
        setIconImage(ImageHelper.loadImage("catalog.png").getImage());
        setBounds(appBounds);
        
        conn = javaconnect.getConnection();
        
        Fillcourse();
        Fillcampus();
    }
    
    private void Fillcourse()
    {
        course.addItem("default");
        course.removeAllItems();
        choose_course.removeAllItems();
        try
        {
            String sql="SELECT DISTINCT(course) FROM info order by course";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next())
            {
                String dn = rs.getString("course");
                course.addItem(dn);
                choose_course.addItem(dn);
            }
            
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
    }
    
    private void Fillcampus()
    {
        campus.addItem("default");
        campus.removeAllItems();
        
        try
        {
            String sql="SELECT DISTINCT(branch_name) FROM branches order by branch_name";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next())
            {
                String dn = rs.getString("branch_name");
                campus.addItem(dn);
            }
            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
    }
    
    public String getTime()
    {
         Calendar currentdate = Calendar.getInstance();
         SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
         String datenow = format.format(currentdate.getTime());
         String time = currentdate.get(Calendar.HOUR)+":"+currentdate.get(Calendar.MINUTE);

        return datenow+"-"+time;
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
        stid = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        st = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        course = new javax.swing.JComboBox();
        jButton4 = new javax.swing.JButton();
        course_printing_status = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        campus = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        campus_printing_status = new javax.swing.JLabel();
        choose_course = new javax.swing.JComboBox();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        stid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                stidKeyReleased(evt);
            }
        });

        jButton1.setText("Print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        st.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(st);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 879, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(stid, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Print One Student", jPanel1);

        jButton4.setText("Print");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        course_printing_status.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        course_printing_status.setForeground(new java.awt.Color(255, 0, 0));
        course_printing_status.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(course, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 234, Short.MAX_VALUE))
                    .addComponent(course_printing_status, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(course)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addGap(154, 154, 154)
                .addComponent(course_printing_status, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(281, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Print By Course", jPanel2);

        jButton2.setText("Print");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        campus_printing_status.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        campus_printing_status.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        choose_course.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "default" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campus_printing_status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(campus, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(choose_course, 0, 263, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(219, 219, 219))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(choose_course, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(136, 136, 136)
                .addComponent(campus_printing_status, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(321, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Print By Campus", jPanel4);

        jMenu1.setText("Options");

        jMenuItem1.setText("Refresh");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Close");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try
        {
            String query = "SELECT r.stid,i.surname,i.first_name,i.other_names,i.dob,i.course,b.branch_name,r.exam_no,r.modules,m.module_name,r.result,rr.remark FROM modules m,info i,results r,branches b,result_remarks rr WHERE r.modules=m.module_code AND i.campus_code=b.branch_code AND i.stid=r.stid AND rr.result=r.remark AND i.stid='" + stid.getText() + "'";
            JasperDesign jd = JRXmlLoader.load("C:\\tshwane\\reports.jrxml");
            JRDesignQuery newQuery = new JRDesignQuery();
            newQuery.setText(query);

            jd.setQuery(newQuery);
            JasperReport jr = JasperCompileManager.compileReport(jd);

            JasperPrint jp = JasperFillManager.fillReport(jr, null,conn);

            String file = stid.getText()+".pdf";

            OutputStream output = new FileOutputStream(new File("C:\\Users\\Molorane\\Music\\"+file));
                JasperExportManager.exportReportToPdfStream(jp, output);

                JasperViewer jv = new JasperViewer(jp,false);
                jv.setTitle("Student Report");
                jv.setVisible(true);

                output.close();
            }
            catch(JRException | IOException e)
            {
                JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
            }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void stidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stidKeyReleased
        // TODO add your handling code here:
        try
        {
            String query1="SELECT r.stid,i.surname,i.first_name,i.other_names,i.dob,i.course,b.branch_name,r.exam_no,r.modules,m.module_name,r.result,rr.remark FROM modules m,info i,results r,branches b,result_remarks rr WHERE r.modules=m.module_code AND i.campus_code=b.branch_code AND i.stid=r.stid AND rr.result=r.remark AND i.stid='" + stid.getText() + "'";
            pst=conn.prepareStatement(query1);
            rs=pst.executeQuery();
            //setting data from the database to the table
            st.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
    }//GEN-LAST:event_stidKeyReleased

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        Fillcampus();
        Fillcourse();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        try
        {
            String selected_course = course.getSelectedItem().toString();
            //course_printing_status.setText("Printing please wait....!");
            if(!selected_course.equals(""))
            {
                    String sql="SELECT DISTINCT(r.stid) FROM results r,info i WHERE i.stid=r.stid AND i.course='"+selected_course+"' ORDER BY i.course,i.campus_code";
                    pst = conn.prepareStatement(sql);
                    rs = pst.executeQuery();

                    ArrayList<JasperPrint> jprintlist = new ArrayList<JasperPrint>();
                    
                    while(rs.next())
                    {
                        String stid = rs.getString("stid");
                        String query = "SELECT r.stid,i.surname,i.first_name,i.other_names,i.dob,i.course,b.branch_name,r.exam_no,r.modules,m.module_name,r.result,rr.remark FROM modules m,info i,results r,branches b,result_remarks rr WHERE r.modules=m.module_code AND i.campus_code=b.branch_code AND i.stid=r.stid AND rr.result=r.remark AND r.stid='"+stid+"'";
                        JasperDesign jd=JRXmlLoader.load("C:\\tshwane\\reports.jrxml");
                        JRDesignQuery newQuery=new JRDesignQuery();
                        newQuery.setText(query);

                        jd.setQuery(newQuery);
                        JasperReport jr = JasperCompileManager.compileReport(jd);
                        JasperPrint jp = JasperFillManager.fillReport(jr, null,conn);

                        jprintlist.add(jp);

                        //JasperViewer jv = new JasperViewer(jp,false);
                        //jv.setTitle("Student Report");
                        //jv.setVisible(true);
                    }

                    String file = "ReportsAccordingCourse";

                    JRExporter exporter = new JRPdfExporter();
                    exporter.setParameter(JRPdfExporterParameter.JASPER_PRINT_LIST, jprintlist);

                    OutputStream output = new FileOutputStream(new File("C:\\Users\\Molorane\\Music\\"+file+".pdf"));

                    exporter.setParameter(JRPdfExporterParameter.OUTPUT_STREAM, output);
                    exporter.exportReport();

                    output.close();
                    
                    new Home.Warning(1500, "Done printing, Open music folder!", 3, "blue", "").start();
                }
            else
            {
                JOptionPane.showMessageDialog(null,"Course Can not be null.");
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e.getLocalizedMessage());
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
          try
        {
            String selected_campus = campus.getSelectedItem().toString();
            
            if(!selected_campus.equals(""))
            {
                String code = "";    
                if(selected_campus.equals("PRETORIA CAMPUS"))
                {
                        code = "03";
                }
                else if(selected_campus.equals("JOBURG CAMPUS"))
                {
                    code = "1";
                }
                else
                {
                    code = "07";
                }
                String sql="SELECT DISTINCT(r.stid) FROM results r,info i WHERE i.stid=r.stid AND i.campus_code='"+code+"' AND i.course='"+choose_course.getSelectedItem().toString()+"' ORDER BY i.course";
                pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();

                ArrayList<JasperPrint> jprintlist = new ArrayList<JasperPrint>();

                while(rs.next())
                {
                    String stid = rs.getString("stid");
                    String query = "SELECT r.stid,i.surname,i.first_name,i.other_names,i.dob,i.course,b.branch_name,r.exam_no,r.modules,m.module_name,r.result,rr.remark FROM modules m,info i,results r,branches b,result_remarks rr WHERE r.modules=m.module_code AND i.campus_code=b.branch_code AND i.stid=r.stid AND rr.result=r.remark AND r.stid='"+stid+"'";
                    
                    JasperDesign jd = JRXmlLoader.load("C:\\tshwane\\reports_joburg.jrxml");
                    
                    if(choose_course.getSelectedItem().toString().equals("JOBURG CAMPUS"))
                        jd = JRXmlLoader.load("C:\\tshwane\\reports_joburg.jrxml");
                    else if(choose_course.getSelectedItem().toString().equals("PRETORIA CAMPUS"))
                        jd = JRXmlLoader.load("C:\\tshwane\\reports_pretoria.jrxml");
                    
                    JRDesignQuery newQuery = new JRDesignQuery();
                    newQuery.setText(query);

                    jd.setQuery(newQuery);
                    JasperReport jr = JasperCompileManager.compileReport(jd);
                    JasperPrint jp = JasperFillManager.fillReport(jr, null,conn);

                    jprintlist.add(jp);

                    //JasperViewer jv = new JasperViewer(jp,false);
                    //jv.setTitle("Student Report");
                    //jv.setVisible(true);
                }

                String file = "ReportsAccordingCampus";

                JRExporter exporter = new JRPdfExporter();
                exporter.setParameter(JRPdfExporterParameter.JASPER_PRINT_LIST, jprintlist);

                OutputStream output = new FileOutputStream(new File("C:\\Users\\Molorane\\Music\\"+file+".pdf"));

                exporter.setParameter(JRPdfExporterParameter.OUTPUT_STREAM, output);
                exporter.exportReport();

                output.close();
                
                new Home.campus(1500, "Done printing, Open music folder!", 3, "blue", "").start();
            }
        else
        {
            JOptionPane.showMessageDialog(null,"Campus Can not be null.");
        }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e.getLocalizedMessage());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        // TODO add your handling code here:
        if(jTabbedPane1.getSelectedIndex() == 1)
        {
            new Home.Warning(1000, "You are about to print results for a course", 4, "red", "").start();
        }
        if(jTabbedPane1.getSelectedIndex() == 2)
        {
            new Home.campus(1000, "You are about to print results for a campus", 4, "red", "").start();
        }
    }//GEN-LAST:event_jTabbedPane1MouseClicked

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
                UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox campus;
    private javax.swing.JLabel campus_printing_status;
    private javax.swing.JComboBox choose_course;
    private javax.swing.JComboBox course;
    private javax.swing.JLabel course_printing_status;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable st;
    private javax.swing.JTextField stid;
    // End of variables declaration//GEN-END:variables

class Warning extends java.lang.Thread 
{
        
        int millis;
        int loops;
        String message;
        String action = null;
        String username;
        
        public Warning ( int millis, String message, int loops, String action, String username ) {
            this.millis = millis;
            this.message = message;
            this.action = action;
            this.loops = loops;
            this.username = username;
        }
        
        public void run () {
            
            for ( int i = 1; i <= loops; ++i ) {
                
                SwingUtilities.invokeLater(
                    new Runnable () {
                        public void run () {
                            course_printing_status.setText( message );
                            if(action.equals("blue"))
                                course_printing_status.setForeground(Color.blue);
                            else
                                course_printing_status.setForeground(Color.red);
                        }
                    }
                );
                
                try {
                    sleep( this.millis );
                } catch ( InterruptedException err ) {}
                
                SwingUtilities.invokeLater(
                    new Runnable () {
                        public void run () {
                            course_printing_status.setText( null );
                        }
                    }
                );
                try {
                    sleep( this.millis );
                } catch ( InterruptedException err ) {}
                
            }
            
        }
    }
class campus extends java.lang.Thread 
{
        
        int millis;
        int loops;
        String message;
        String action = null;
        String username;
        
        public campus ( int millis, String message, int loops, String action, String username ) {
            this.millis = millis;
            this.message = message;
            this.action = action;
            this.loops = loops;
            this.username = username;
        }
        
        public void run () {
            
            for ( int i = 1; i <= loops; ++i ) {
                
                SwingUtilities.invokeLater(
                    new Runnable () {
                        public void run () {
                            campus_printing_status.setText( message );
                            if(action.equals("blue"))
                                campus_printing_status.setForeground(Color.blue);
                            else
                                campus_printing_status.setForeground(Color.red);
                        }
                    }
                );
                
                try {
                    sleep( this.millis );
                } catch ( InterruptedException err ) {}
                
                SwingUtilities.invokeLater(
                    new Runnable () {
                        public void run () {
                            campus_printing_status.setText( null );
                        }
                    }
                );
                try {
                    sleep( this.millis );
                } catch ( InterruptedException err ) {}
                
            }
            
        }
    }
}
