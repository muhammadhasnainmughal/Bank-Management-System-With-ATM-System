/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package inventory;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneLightIJTheme;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;



public class Manage_Customer extends javax.swing.JFrame {

    private int appuserPK =0;
    /**
     * Creates new form Manage_Customer
     */
    public Manage_Customer() {
        
        try{
            
            UIManager.setLookAndFeel(new FlatAtomOneLightIJTheme());
            // Apply global font for the UI
            UIManager.put("defaultFont", new FontUIResource(new Font("Segoe UI", Font.PLAIN, 14)));

        }
        catch(UnsupportedLookAndFeelException e){
            
            e.printStackTrace();
        }
        
        setTitle("Customers");
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
        
      
         btndelete.setEnabled(false);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        mobile = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        credit = new javax.swing.JTextField();
        btnsave = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(350, 125));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Email", "Mobile No:", "Credit"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, 1020, 570));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("Name");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 153));
        jLabel3.setText("Mobile Number");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 153));
        jLabel4.setText("Email");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 153));
        jLabel5.setText("Credit");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, -1, -1));
        jPanel1.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 320, -1));
        jPanel1.add(mobile, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 320, -1));
        jPanel1.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, 320, -1));
        jPanel1.add(credit, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 480, 320, -1));

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
        jPanel1.add(btnsave, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 90, 30));

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Update");
        jButton2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 90, 30));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 40));

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
        jPanel1.add(btndelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 90, 30));

        jLabel6.setBackground(new java.awt.Color(0, 102, 102));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Manage Customer");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel6.setOpaque(true);
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1480, 70));

        jLabel1.setBackground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("  ");
        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 76, 1480, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1501, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
          if(evt.getSource() == jButton4 )
       {
           setVisible(false);
           new first_Page().setVisible(true);
       }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        
        try
        { 
            Connection con = Conn.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from customer");
            
            while(rs.next())
            {
                model.addRow(new Object[] {  rs.getInt("id"), rs.getString("name"), rs.getString("mobile_number"), rs.getString("email") , rs.getInt("credit") });
            }
           
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
            System.out.println("Exception: "+e);
        }
        
    }//GEN-LAST:event_formComponentShown

    
    private boolean validatefield() {
        if (name1.equals("") || mobile1.equals("") || email1.equals("") || credit1.equals("") ) {
            return false;
        } 
        else {
            return true;
        }
    }
    
    
    String name1;
    String mobile1;
    String email1;
    String credit1;
    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
         if(evt.getSource() == btnsave)
        {
            
                
            
             name1=name.getText();
             mobile1=mobile.getText();
             email1=email.getText();
            // password1=password.getText();
           // String credit1= (String) credit.toString();
             credit1 = credit.getText();
            if(validatefield()){
            Insert(name1,mobile1,email1, credit1);
            }else{
                JOptionPane.showMessageDialog(null, "Fill all fields");
            }
        }
    }//GEN-LAST:event_btnsaveActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         if(evt.getSource() == jButton2)
        {
            String name1=name.getText();
            String mobile1=mobile.getText();
            String email1=email.getText();
            String credit1=credit.getText();
            update(name1,mobile1,email1, credit1);
            
            setVisible(false);
            new Manage_Customer().setVisible(true);
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    
    String customerID;
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        Object jTable1MouseClicked;
        // TODO add your handling code here:
        btndelete.setEnabled(true);
        int index = jTable1.getSelectedRow();
        TableModel model = jTable1.getModel();
        
        customerID=model.getValueAt(index,0).toString();
        String name1 = model.getValueAt(index,1).toString();
        name.setText(name1);
        String mobile1= model.getValueAt(index,3).toString();
        mobile.setText(mobile1);
        String email1= model.getValueAt(index,2).toString();
        email.setText(email1);
        String credit1= model.getValueAt(index,4).toString();
        credit.setText(credit1);
        String id =  model.getValueAt(index, 0).toString();
        appuserPK = Integer.parseInt(id);
        //user_id.setText(id);
        
       
        jButton2.setEnabled(true);
        btnsave.setEnabled(false);
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        // TODO add your handling code here:
         try{
                Connection con = Conn.getCon();
                PreparedStatement ps= con.prepareStatement("delete from customer where id=?");
                ps.setString(1, customerID);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null,"Deleted SuccessFully");
                setVisible(false);
                new Manage_Customer().setVisible(true);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
    }//GEN-LAST:event_btndeleteActionPerformed

    public void update(String name1, String mobile1, String email1, String credit1) {
         
        Connection con = Conn.getCon();
        PreparedStatement st;
        try {
            System.out.println("try update check");
            //int u_id = Integer.parseInt(id);
            int credit = Integer.parseInt(credit1);
            System.out.println("appuserPK : "+appuserPK);
           st = con.prepareStatement("update customer  set  name= ('"+name1+"'),mobile_number= ('"+mobile1+"'), email= ('"+email1+"') ,credit = ('"+credit+"')  where id = ('"+appuserPK+"')");
           
           st.executeUpdate();
           
           //st.executeQuery();
           JOptionPane.showMessageDialog(null,"Updated");
                
           
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("EXception " + ex);
        }
    }

    public void Insert(String name, String mobile, String email, String credit) {

       try {
            Connection con = Conn.getCon();
            PreparedStatement st;
            
            
            int credit1 = Integer.parseInt(credit);
            Random rand = new Random();
            
             int c_id = rand.nextInt(1000); 
            st = con.prepareStatement("insert into customer (id,name,mobile_number,email,credit) values (?,?,?,?,?)");
            st.setInt(1, c_id);
            st.setString(2, name);
            st.setString(3, mobile);
            st.setString(4, email);
            st.setInt(5, credit1);
            
            st.executeUpdate();
            JOptionPane.showMessageDialog(null,"User Updated");
            setVisible(false);
            new Manage_Customer().setVisible(true);
            

           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("EXception " + ex);
        }
    }

    
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
            java.util.logging.Logger.getLogger(Manage_Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Manage_Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Manage_Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Manage_Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Manage_Customer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnsave;
    private javax.swing.JTextField credit;
    private javax.swing.JTextField email;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField mobile;
    private javax.swing.JTextField name;
    // End of variables declaration//GEN-END:variables
}
