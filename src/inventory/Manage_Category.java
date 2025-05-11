/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package inventory;

import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneLightIJTheme;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.plaf.FontUIResource;

/**
 *
 * @author HAMMAD
 */
public class Manage_Category extends javax.swing.JFrame {

    
    /**
     * Creates new form Manage_Category
     */
    int category_id;
    public Manage_Category() {
        
        try{
            
            UIManager.setLookAndFeel(new FlatAtomOneLightIJTheme());
            // Apply global font for the UI
            UIManager.put("defaultFont", new FontUIResource(new Font("Segoe UI", Font.PLAIN, 14)));

        }
        catch(UnsupportedLookAndFeelException e){
            
            e.printStackTrace();
        }
        
        setTitle("Categories");
        setUndecorated(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
         initComponents();
            setExtendedState(JFrame.MAXIMIZED_BOTH);
            setLocationRelativeTo(null);
        
        // Rounded corners for various components
        UIManager.put("Button.arc", 20); // Buttons
        UIManager.put("TextField.arc", 15); // Text fields
        UIManager.put("PasswordField.arc", 15); // Password fields
        UIManager.put("Spinner.arc", 10); // Spinners
        UIManager.put("ProgressBar.arc", 10); // Progress bars
        UIManager.put("TabbedPane.tabInsets", new Insets(10, 20, 10, 20)); // Tab padding
        UIManager.put("TextArea.arc", 10); // Rounded corners for text area
        UIManager.put("TextComponent.arc", 10); // Text components

        // Color palette for modern feel
        UIManager.put("Component.focusColor", new Color(100, 149, 237)); // Focus color
        UIManager.put("Component.focusWidth", 2); // Focus border width
        UIManager.put("Button.background", new Color(240, 240, 255)); // Button background
        UIManager.put("Button.hoverBackground", new Color(220, 230, 255)); // Button hover
        UIManager.put("Button.focusedBackground", new Color(190, 210, 255)); // Button focused
        UIManager.put("Button.foreground", Color.BLACK); // Button text
        UIManager.put("Button.disabledText", new Color(150, 150, 150)); // Disabled button text
        UIManager.put("Panel.background", new Color(245, 245, 250)); // Panel background
        UIManager.put("TabbedPane.underlineColor", new Color(100, 149, 237)); // Underline for active tab
        UIManager.put("TabbedPane.contentAreaColor", new Color(245, 245, 245)); // Tab pane background
        UIManager.put("TabbedPane.tabAreaBackground", new Color(240, 240, 240)); // Tab area background
        UIManager.put("TabbedPane.hoverColor", new Color(190, 210, 240)); // Hover color for tabs
        UIManager.put("ScrollBar.thumb", new Color(180, 180, 180)); // Scrollbar thumb color
        UIManager.put("ScrollBar.hoverThumb", new Color(160, 160, 160)); // Scrollbar hover
        UIManager.put("ScrollBar.thumbArc", 10); // Rounded scrollbar thumb
        UIManager.put("ScrollBar.thumbInsets", new Insets(2, 2, 2, 2)); // Spacing inside scrollbar thumb
        UIManager.put("ScrollBar.track", new Color(230, 230, 230)); // Track color

        // Shadowing and borders
        UIManager.put("Button.shadowWidth", 3); // Button shadow width
        UIManager.put("PopupMenu.border", BorderFactory.createLineBorder(new Color(200, 200, 200))); // Popup menu border
        UIManager.put("Menu.shadowColor", new Color(200, 200, 200, 100)); // Menu shadow
        UIManager.put("TextField.borderWidth", 2); // TextField border width
        UIManager.put("Separator.foreground", new Color(200, 200, 200)); // Divider lines
        UIManager.put("Separator.background", new Color(245, 245, 245)); // Divider background

        // Text highlights and selection
        UIManager.put("TextField.selectionBackground", new Color(180, 220, 250)); // Text selection background
        UIManager.put("TextField.selectionForeground", Color.BLACK); // Text selection foreground
        UIManager.put("TextArea.background", new Color(245, 245, 250)); // TextArea background
        UIManager.put("TextArea.selectionBackground", new Color(180, 220, 250)); // TextArea selection
        UIManager.put("TextPane.background", new Color(250, 250, 255)); // TextPane background

        // Tooltips and dialogs
        UIManager.put("ToolTip.background", new Color(250, 250, 200)); // Tooltip background
        UIManager.put("ToolTip.border", BorderFactory.createLineBorder(new Color(200, 200, 150))); // Tooltip border
        UIManager.put("OptionPane.messageFont", new Font("SansSerif", Font.PLAIN, 14)); // Dialog font
        UIManager.put("OptionPane.background", new Color(240, 240, 255)); // Dialog background
        UIManager.put("OptionPane.messageForeground", Color.BLACK); // Dialog text color

        // Fonts for consistency
        Font defaultFont = new Font("Segoe UI", Font.PLAIN, 14);
        UIManager.put("defaultFont", defaultFont); // Apply font across all components
        UIManager.put("Menu.font", defaultFont); // Menu font
        UIManager.put("Button.font", defaultFont); // Button font
        UIManager.put("TabbedPane.font", new Font("Segoe UI Semibold", Font.PLAIN, 13)); // Tabs font
        UIManager.put("Label.font", defaultFont); // Labels
        UIManager.put("CheckBox.font", defaultFont); // Checkboxes

        // Menu hover and selection
        UIManager.put("Menu.hoverBackground", new Color(230, 240, 255)); // Menu hover
        UIManager.put("Menu.selectionBackground", new Color(100, 149, 237)); // Selected menu background
        UIManager.put("Menu.selectionForeground", Color.BLACK); // Selected menu text
        UIManager.put("MenuItem.selectionBackground", new Color(220, 220, 250)); // Selected menu item background
        UIManager.put("MenuItem.selectionForeground", Color.BLACK); // Selected menu item text
        UIManager.put("MenuItem.selectionType", "underline"); // Menu highlight style

        // ProgressBar styling
        UIManager.put("ProgressBar.foreground", new Color(100, 180, 255)); // Progress bar foreground
        UIManager.put("ProgressBar.background", new Color(220, 230, 240)); // Progress bar background
        UIManager.put("ProgressBar.selectionForeground", Color.BLACK); // Progress text foreground
        UIManager.put("ProgressBar.selectionBackground", Color.WHITE); // Progress text background
       // btndelete.setEnabled(false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnsave = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        categorytable = new javax.swing.JTable();
        btndelete = new javax.swing.JButton();
        Button = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(350, 125));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel1ComponentShown(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnsave.setBackground(new java.awt.Color(153, 153, 153));
        btnsave.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnsave.setForeground(new java.awt.Color(255, 255, 255));
        btnsave.setText("Save");
        btnsave.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        btnsave.setContentAreaFilled(false);
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });
        jPanel1.add(btnsave, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 80, 30));

        btnupdate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnupdate.setForeground(new java.awt.Color(255, 255, 255));
        btnupdate.setText("Update");
        btnupdate.setAutoscrolls(true);
        btnupdate.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        btnupdate.setContentAreaFilled(false);
        btnupdate.setDoubleBuffered(true);
        btnupdate.setFocusCycleRoot(true);
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });
        jPanel1.add(btnupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 80, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("Name");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, -1, -1));
        jPanel1.add(txtname, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 320, -1));

        categorytable.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        categorytable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        categorytable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                categorytableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(categorytable);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, 1060, 600));

        btndelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btndelete.setForeground(new java.awt.Color(255, 255, 255));
        btndelete.setText("Delete");
        btndelete.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        btndelete.setContentAreaFilled(false);
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btndelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 80, 30));

        Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
        Button.setBorder(null);
        Button.setContentAreaFilled(false);
        Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonActionPerformed(evt);
            }
        });
        jPanel1.add(Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 40));

        jLabel3.setBackground(new java.awt.Color(0, 102, 102));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Manage Category ");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel3.setOpaque(true);
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1480, 70));

        jLabel1.setBackground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("  ");
        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 76, 1480, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1479, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 761, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        // TODO add your handling code here:
        String name=txtname.getText();
        if(name.equals("")){
            JOptionPane.showMessageDialog(null,"Please Enter Category Name");
        }
        else{
            try{
                Connection con = Conn.getCon();
                PreparedStatement ps= con.prepareStatement("Update category set category_name=? where c_id=?");
                ps.setString(1, name);
                ps.setInt(2, category_id);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null,"updated SuccessFully");
                setVisible(false);
                new Manage_Category().setVisible(true);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
        }
    }//GEN-LAST:event_btnupdateActionPerformed

    private void jPanel1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel1ComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1ComponentShown

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        DefaultTableModel model = (DefaultTableModel) categorytable.getModel();
        
        try{
            
           Connection con = Conn.getCon();
           Statement st=con.createStatement();
           ResultSet rs= st.executeQuery("Select * from category");
           while(rs.next()){
               model.addRow(new Object[]{rs.getString("c_id"), rs.getString("category_name")});
               
           }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null , e);
        }
        //btnupdate.setEnabled(false);
    }//GEN-LAST:event_formComponentShown

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        String name=txtname.getText();
        if(name.equals("")){
            JOptionPane.showMessageDialog(null,"Please Enter Category Name");
        }
        else{
            try{
                Connection con = Conn.getCon();
                PreparedStatement ps= con.prepareStatement("insert into category (category_name) values(?)");
                ps.setString(1, name);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null,"Added SuccessFully");
                setVisible(false);
                new Manage_Category().setVisible(true);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnsaveActionPerformed

    
    String id;
    private void categorytableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_categorytableMouseClicked
        // TODO add your handling code here:
         btndelete.setEnabled(true);
         int index= categorytable.getSelectedRow();
         TableModel model= categorytable.getModel();
          id= model.getValueAt(index,0).toString();
         category_id=Integer.parseInt(id);
         
         String name=model.getValueAt(index,1).toString();
         txtname.setText(name);
         btnsave.setEnabled(false);
         btnupdate.setEnabled(true);
         
    }//GEN-LAST:event_categorytableMouseClicked

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        // TODO add your handling code here:
        try{
                Connection con = Conn.getCon();
                PreparedStatement ps= con.prepareStatement("delete from category where c_id=?");
                ps.setString(1, id);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null,"Deleted SuccessFully");
                setVisible(false);
                new Manage_Category().setVisible(true);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
        
    }//GEN-LAST:event_btndeleteActionPerformed

    private void ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonActionPerformed

setBackground(null);
        this.hide();
        setVisible(false);
        new first_Page().setVisible(true);
    }//GEN-LAST:event_ButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Manage_Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Manage_Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Manage_Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Manage_Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Manage_Category().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnsave;
    private javax.swing.JButton btnupdate;
    private javax.swing.JTable categorytable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtname;
    // End of variables declaration//GEN-END:variables
}
