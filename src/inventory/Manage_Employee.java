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

/**
 *
 * @author Usman
 */
public class Manage_Employee extends javax.swing.JFrame {
    
    private int appuserPK = 0;
    int user;
    /**
     * Creates new form Manage_User
     */
    public Manage_Employee() {
        
       try{
            
            UIManager.setLookAndFeel(new FlatAtomOneLightIJTheme());
            // Apply global font for the UI
            UIManager.put("defaultFont", new FontUIResource(new Font("Segoe UI", Font.PLAIN, 14)));

        }
        catch(UnsupportedLookAndFeelException e){
            
            e.printStackTrace();
        }
        
        setTitle("Employees");
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
    }
    
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        mobile = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        address = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        user_id = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        password = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFocusTraversalPolicyProvider(true);
        setLocationByPlatform(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "EmployeeID", "Name", "Email", "Password", "Address", "Mobile Number"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 160, 1040, 540));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("Name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));

        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });
        getContentPane().add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 320, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 153));
        jLabel3.setText("Mobile Number");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, -1, -1));
        getContentPane().add(mobile, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 320, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 153));
        jLabel4.setText("Email");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, -1, -1));
        getContentPane().add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 320, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 153));
        jLabel5.setText("Address");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 490, -1, -1));

        address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressActionPerformed(evt);
            }
        });
        getContentPane().add(address, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 520, 320, -1));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Save");
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 90, 30));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 50));

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
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 90, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 153));
        jLabel7.setText("Employee ID");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        user_id.setEditable(false);
        user_id.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        user_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                user_idActionPerformed(evt);
            }
        });
        getContentPane().add(user_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 90, -1));

        jLabel6.setBackground(new java.awt.Color(0, 102, 102));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Manage Employees");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel6.setOpaque(true);
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1480, 70));

        jLabel1.setBackground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("  ");
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 76, 1480, 40));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 153));
        jLabel8.setText("Password");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, -1, -1));
        getContentPane().add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, 320, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        
        jButton2.setEnabled(false);
        try {
            
            Connection con = Conn.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from employees ");
            
            while(rs.next())
            {
                model.addRow(new Object[]{rs.getString("user_id"),rs.getString("name"),rs.getString("email"),rs.getString("password"),rs.getString("address"),rs.getString("mobile")});
            }
            
        
        
        } 
        catch (SQLException ex) {
         
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("EXception " + ex);
        }
            
            
            
        
    }//GEN-LAST:event_formComponentShown

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
          if(evt.getSource() == jButton1)
        {
            if(name.getText() != "" && email.getText() != "" && password.getText() != "")
            {
            String name1=name.getText();
            String mobile1=mobile.getText();
            String email1=email.getText();
            String password1=password.getText();
            String address1=address.getText();
            
            
            Insert(name1,mobile1,email1,password1,address1);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Please Enter Customer Details.");
            }
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        Object jTable1MouseClicked;
        // TODO add your handling code here:
        int index = jTable1.getSelectedRow();
        TableModel model = jTable1.getModel();
        
        String name1 = model.getValueAt(index,1).toString();
        name.setText(name1);
        String mobile1= model.getValueAt(index,5).toString();
        mobile.setText(mobile1);
        String email1= model.getValueAt(index,2).toString();
        email.setText(email1);
        String address1= model.getValueAt(index,4).toString();
        address.setText(address1);
        String password1= model.getValueAt(index,3).toString();
        password.setText(password1);
        String id =  model.getValueAt(index, 0).toString();
        appuserPK = Integer.parseInt(id);
        user_id.setText(id);
        
    //    password.setEditable(false);
    //    password.setBackground(Color.DARK_GRAY);
        
    jButton2.setEnabled(true);
        jButton1.setEnabled(false);
            
    }//GEN-LAST:event_jTable1MouseClicked

    public void update2(String name1)
    { 
          System.out.println("update2 check");
        Connection con = Conn.getCon();
        PreparedStatement st;
        try {
            System.out.println("try update2 check");
            //int u_id = Integer.parseInt(id);
            System.out.println("appuserPK : "+appuserPK);
           // st.con.prepareStatement("update users set name = '?'");
           st = con.prepareStatement("update users  set  name=('"+name1+"') where user_id = ('"+appuserPK+"')  ");
            System.out.println("before name");
            
           st.executeUpdate();
           
              
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("EXception " + ex);
        }
        
    }
    
     public void update(String name1, String mobile1,String password1, String email1, String address1) {
        Connection con = Conn.getCon();
        PreparedStatement st;
        try {
            
        st = con.prepareStatement("update employees  set  name=('"+name1+"') , email=('"+email1+"') , address= ('"+address1+"') ,password=('"+password1+"') , mobile = ('"+mobile1+"')   where user_id = ('"+appuserPK+"')  ");
        
           st.executeUpdate();
           JOptionPane.showMessageDialog(null,"Employee Updated Successfully");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
          if(evt.getSource() == jButton2)
        {
            String name1=name.getText();
            String mobile1=mobile.getText();
            String email1=email.getText();
            String password1=password.getText();
            String address1=address.getText();
              String user_id1 = user_id.getText();
              int id = 0;
              id=Integer.parseInt(user_id1 );
              
             System.out.println("button2: "+id);
            update(name1,mobile1,password1,email1, address1);
     
            setVisible(false);
            new Manage_Employee().setVisible(true);
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void user_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_user_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_user_idActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.hide();
        setVisible(false);
        first_Page fp = new first_Page();
        fp.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    
    public void Insert(String name, String mobile, String email, String pass, String address) {

        try {
            Connection con = Conn.getCon();
            PreparedStatement st;

//            Random rand = new Random();
//             user = rand.nextInt(1000);
            st = con.prepareStatement("insert into employees (name,email,address,password,mobile) values (?,?,?,?,?)");
            //st.setInt(1, user);
            st.setString(1, name);
            st.setString(5, mobile);
            st.setString(2, email);
            st.setString(4, pass);
            st.setString(3, address);

            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Employee Added Successfully");
            setVisible(false);
            new Manage_Employee().setVisible(true);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("EXception " + ex);
        }
    }

    
    public static void main(String args[]) {
     
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Manage_Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Manage_Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Manage_Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Manage_Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Manage_Employee().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address;
    private javax.swing.JTextField email;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField mobile;
    private javax.swing.JTextField name;
    private javax.swing.JTextField password;
    private javax.swing.JTextField user_id;
    // End of variables declaration//GEN-END:variables
}
