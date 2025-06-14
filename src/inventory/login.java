/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package inventory;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneLightIJTheme;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.plaf.FontUIResource;

public class login extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    public login() {
        
        try{
            
            UIManager.setLookAndFeel(new FlatAtomOneLightIJTheme());
            // Apply global font for the UI
            UIManager.put("defaultFont", new FontUIResource(new Font("Segoe UI", Font.PLAIN, 14)));

        }
        catch(UnsupportedLookAndFeelException e){
            
            e.printStackTrace();
        }
        
        setTitle("Login");
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
        jTextField1.setBackground(new java.awt.Color(0, 0, 0, 1));
        jPasswordField1.setBackground( new java.awt.Color(0,0,0,1));
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
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(500, 200));

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel2.setText("Developed By: Kelash Heerani");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 730, -1, -1));

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 280, 280, 30));

        jLabel4.setBackground(new java.awt.Color(51, 51, 51));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, -1, 52));

        jPasswordField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPasswordField1.setForeground(new java.awt.Color(255, 255, 255));
        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 340, 280, 30));

        jButton2.setBackground(new java.awt.Color(153, 153, 153));
        jButton2.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Close");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 440, 120, 30));

        jButton1.setBackground(new java.awt.Color(153, 153, 153));
        jButton1.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Login");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jButton1.setContentAreaFilled(false);
        jButton1.setDoubleBuffered(true);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 390, 120, 30));

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Login");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 210, -1, -1));

        jLabel6.setBackground(new java.awt.Color(0, 102, 102));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel6.setOpaque(true);
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 190, 300, 300));

        jLabel5.setFont(new java.awt.Font("Script MT Bold", 1, 36)); // NOI18N
        jLabel5.setText("Welcome To Inventory Managemnt System ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1528, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         Connection con = Conn.getCon();
  
        if(evt.getSource() == jButton1)
        {
            String username = jTextField1.getText();
            String pass = jPasswordField1.getText();
            
            try {
            String query = "SELECT * FROM employees WHERE email = ? AND password = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, username);
            pst.setString(2, pass);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                setVisible(false);
                new first_Page().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password!");
            }

            rs.close();
            pst.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error connecting to database.");
        }
             
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseExited

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
                
                    
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
