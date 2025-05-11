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


public class Manage_Order extends javax.swing.JFrame {

    /**
     * Creates new form Manage_Order
     */
    public Manage_Order() {
        
        try{
            
            UIManager.setLookAndFeel(new FlatAtomOneLightIJTheme());
            // Apply global font for the UI
            UIManager.put("defaultFont", new FontUIResource(new Font("Segoe UI", Font.PLAIN, 14)));

        }
        catch(UnsupportedLookAndFeelException e){
            
            e.printStackTrace();
        }
        
        setTitle("Orders");
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
        jButton1.setEnabled(false);
        remove.setEnabled(false);
        reset.setEnabled(false);
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
        jScrollPane2 = new javax.swing.JScrollPane();
        ptable = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        cartTable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        cname = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        pname = new javax.swing.JTextField();
        quantity = new javax.swing.JTextField();
        price = new javax.swing.JTextField();
        desc = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        remove = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        bill = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        select_customer = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        mobile_no = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        address = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        balance = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        balance1 = new javax.swing.JTextField();
        address1 = new javax.swing.JTextField();
        pay = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        remaining = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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
                "ID", "Name", "Mobile No:", "Address", "Credit"
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
        jTable1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jTable1ComponentShown(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, 580, 180));

        ptable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Quantity", "Price", "Description"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ptable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ptableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(ptable);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 90, 420, 600));

        cartTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product_ID", "Name", "Quantity", "Unit Price", "Sub_Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        cartTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cartTableMouseClicked(evt);
            }
        });
        cartTable.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                cartTableComponentShown(evt);
            }
        });
        cartTable.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cartTablePropertyChange(evt);
            }
        });
        jScrollPane3.setViewportView(cartTable);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 1050, 270));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Name");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        cname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cnameActionPerformed(evt);
            }
        });
        jPanel1.add(cname, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 300, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Product Name");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Quantity");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 290, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Price per Unit");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 290, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Description");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, -1, 20));

        pname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pnameActionPerformed(evt);
            }
        });
        jPanel1.add(pname, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 200, -1));
        jPanel1.add(quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 320, 210, -1));
        jPanel1.add(price, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 320, 210, -1));

        desc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descActionPerformed(evt);
            }
        });
        jPanel1.add(desc, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 320, 210, -1));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Add To Cart");
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 320, 190, 30));

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setText("Confirm");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 660, 90, 30));

        remove.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        remove.setText("Remove");
        remove.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        remove.setContentAreaFilled(false);
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });
        jPanel1.add(remove, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 660, 90, 30));

        reset.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        reset.setText("Reset");
        reset.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        reset.setContentAreaFilled(false);
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        jPanel1.add(reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 660, 90, 30));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel12.setText("Total Amount Rs:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 650, -1, 40));

        bill.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        bill.setText("0");
        jPanel1.add(bill, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 650, 130, 40));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
        jButton6.setBorderPainted(false);
        jButton6.setContentAreaFilled(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 40, 40));

        select_customer.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        select_customer.setText("Select");
        select_customer.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        select_customer.setContentAreaFilled(false);
        select_customer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                select_customerActionPerformed(evt);
            }
        });
        jPanel1.add(select_customer, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 240, 130, 30));

        jLabel6.setBackground(new java.awt.Color(0, 102, 102));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel6.setOpaque(true);
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 1050, 80));

        jLabel7.setBackground(new java.awt.Color(0, 102, 102));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Invoice");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel7.setOpaque(true);
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1480, 70));

        mobile_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mobile_noActionPerformed(evt);
            }
        });
        jPanel1.add(mobile_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 300, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("Mobile No.");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("Address:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressActionPerformed(evt);
            }
        });
        jPanel1.add(address, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 300, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("Balance:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 228, -1, -1));

        balance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                balanceActionPerformed(evt);
            }
        });
        jPanel1.add(balance, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 247, 300, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setText("Address:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setText("Balance:");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 228, -1, -1));

        balance1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                balance1ActionPerformed(evt);
            }
        });
        jPanel1.add(balance1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 247, 300, -1));

        address1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                address1ActionPerformed(evt);
            }
        });
        jPanel1.add(address1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 300, -1));

        pay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payActionPerformed(evt);
            }
        });
        jPanel1.add(pay, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 670, 140, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setText("Pay:");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 650, -1, -1));

        remaining.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remainingActionPerformed(evt);
            }
        });
        jPanel1.add(remaining, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 670, 140, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setText("Remaining:");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 650, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 734, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pnameActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
         if(evt.getSource() == jButton6 )
       {
           setVisible(false);
           new first_Page().setVisible(true);
       }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTable1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTable1ComponentShown
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_jTable1ComponentShown

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
         DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        DefaultTableModel model2 = (DefaultTableModel) ptable.getModel();
        
        try {
            
            Connection con = Conn.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from customer");
            
            while(rs.next() )
            {
                model.addRow(new Object[]{rs.getString("id"),rs.getString("name"),rs.getString("mobile_number"),rs.getString("email"),rs.getString("credit")});
           
            }
            
        
        
        } 
        catch (SQLException ex) {
         
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("EXception " + ex);
        }
        
        
                
       // jButton2.setEnabled(false);
        try {
            
            Connection con = Conn.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from product");
            
            while(rs.next() )
            {
               model2.addRow(new Object[]{rs.getString("p_id"),rs.getString("product_name"),rs.getString("quantity"),rs.getString("price"),rs.getString("Des"),});
           
            }
            
        
        
        } 
        catch (SQLException ex) {
         
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("EXception " + ex);
        }
        
        
        
            
             
        
        
        
     
        
    }//GEN-LAST:event_formComponentShown

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
         Object jTable1MouseClicked;
        // TODO add your handling code here:
        int index = jTable1.getSelectedRow();
        TableModel model = jTable1.getModel();
        
        String name1 = model.getValueAt(index,1).toString();
        cname.setText(name1);
      
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void ptableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ptableMouseClicked
        // TODO add your handling code here:
        quantity.setText("");
       int index = ptable.getSelectedRow();
        TableModel model = ptable.getModel();
        String id = model.getValueAt(index, 0).toString();
        int product_id = Integer.parseInt(id);

        String name = model.getValueAt(index, 1).toString();
        pname.setText(name);

        
        String price1 = model.getValueAt(index, 3).toString();
        price.setText(price1);

        String Dec = model.getValueAt(index, 4).toString();
        desc.setText(Dec);

       
                                          

        
        
        
    }//GEN-LAST:event_ptableMouseClicked

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) cartTable.getModel();
        model.setRowCount(0);
        b=0;
        bill.setText("");
    }//GEN-LAST:event_resetActionPerformed

     
    
    
    int price1;
    int product_id;
    int b;
    int order_id;
    int subtotal;
       
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        
        int index = ptable.getSelectedRow();
        
        String q= quantity.getText();
        if(index!=-1 && !q.equals("")){
        TableModel model2 = ptable.getModel();
        product_id = Integer.parseInt(model2.getValueAt(index, 0).toString());
        
        Object jTable1MouseClicked;
        DefaultTableModel model3 = (DefaultTableModel) cartTable.getModel();
         
         // displaying value on cart table
        try{
            Connection con = Conn.getCon();
            Statement st = con.createStatement();
           
            ResultSet rs = st.executeQuery("select * from product where p_id= ('"+product_id+"')");

            int quan =Integer.parseInt(q);
            
            
            int id1;
            id1 = 0;
            
             while(rs.next()  )
            {
                if(quan>Integer.parseInt(rs.getString("quantity"))){
                JOptionPane.showMessageDialog(null,"Enter Quantity is Invalid");
                }
                else{
                id1=rs.getInt("p_id");
              
                if(id1==product_id){ 
                   subtotal= Integer.parseInt(rs.getString("price"));
                   subtotal= subtotal*quan;
                   model3.addRow(new Object[]{rs.getString("p_id"),rs.getString("product_name"),quantity.getText(),rs.getString("price"),subtotal});
              
                    b=b +subtotal;// to print updated bill  in the text field of Total amount right after the button is pressed Add to Cart 
                    bill.setText(String.valueOf(b));

                }
                else{
                    id1 = Integer.parseInt(rs.getString("p_id"));
                    System.out.println("id "+id1);
                }
                System.out.println("in while");
                remove.setEnabled(true);
                reset.setEnabled(true);
              
            }
            }
             

          
       }
        
      
         catch(Exception e)
         {
             System.out.println("ex: "+e);
         }
 

    }//GEN-LAST:event_jButton1ActionPerformed
    else{
            JOptionPane.showMessageDialog(null , "Select any product OR enter quantity");
        }
        
        
    }
    
    
    
    private void cartTableComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_cartTableComponentShown
  
    }//GEN-LAST:event_cartTableComponentShown

    private void cartTablePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cartTablePropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_cartTablePropertyChange

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
        
    if(cartTable.getRowCount()==0){
        JOptionPane.showMessageDialog(null , "*Add some product to confirm*");
    }
    else{
        // inserting data into orders table
        TableModel model1 = jTable1.getModel();
        
        String c_id = model1.getValueAt(index1,0).toString();

         try
        {
          Connection con = Conn.getCon();
            PreparedStatement st;
            
            
            int customer = Integer.parseInt(c_id);
           int totalcost = Integer.parseInt (bill.getText());
            st = con.prepareStatement("insert into orders values (?,?,?)");
            
            st.setInt(3, order_id);
            st.setInt(1, totalcost);
            st.setInt(2, customer);
            
            st.executeUpdate();
            JOptionPane.showMessageDialog(null,"Orders data save Generated");
                       
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null , e);
        }
       // end of inserting into orders database
        
        
        
        /// inserting data in orderdetails table
        DefaultTableModel model = (DefaultTableModel) cartTable.getModel();
        
        int row_count= model.getRowCount();
        int row_index=0;
        
        
        
        while(row_count!=0){
            int prodID= Integer.parseInt(model.getValueAt(row_index,0).toString());
            int unit_price= Integer.parseInt(model.getValueAt(row_index,3).toString());
            int q= Integer.parseInt(quantity.getText());
         
        
        try
        {
          Connection con = Conn.getCon();
          PreparedStatement ps;
          
            
        
            ps = con.prepareStatement("insert into orderdetails values (?,?,?,?,?)");
            ps.setInt(1, order_id);
            ps.setInt(2, prodID);
            ps.setInt(3, q);
            ps.setInt(4, unit_price );
            ps.setInt(5, subtotal); 
            ps.executeUpdate();
            
            Connection c1=Conn.getCon();
            PreparedStatement ps1=c1.prepareStatement("update product set quantity=quantity-? where p_id=?");
            ps1.setInt(1,q );
            ps1.setInt(2,prodID);
            ps1.executeUpdate();
  
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null , e);
        }
        row_count--;
        row_index++;
        
        }
        JOptionPane.showMessageDialog(null,"order details Updated");
    }    
 
        
    }//GEN-LAST:event_jButton2ActionPerformed

    
    
    
    
    int index1;
    private void select_customerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_select_customerActionPerformed
             index1 = jTable1.getSelectedRow();
    if(index1!=-1){
         DefaultTableModel model1 = (DefaultTableModel) cartTable.getModel();
        model1.setRowCount(0);
         
//        TableModel model1 = jTable1.getModel();
//        
//        String c_id = model1.getValueAt(index1,0).toString();
//         
       Random rand =  new Random();
        
       order_id = rand.nextInt(1000000);   

            JOptionPane.showMessageDialog(null , order_id);
         jButton1.setEnabled(true);

    }//GEN-LAST:event_select_customerActionPerformed
    else{
        JOptionPane.showMessageDialog(null , "Select any Customer");
    }
 }
    
    private void cnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cnameActionPerformed

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
        // TODO add your handling code here:
        
        int index= cartTable.getSelectedRow();
        if(index!=-1){
             b-=Integer.parseInt(cartTable.getValueAt(index,4).toString());
            DefaultTableModel model1 = (DefaultTableModel) cartTable.getModel();
            model1.removeRow(index);
            bill.setText(""+b);
        }
        else{
            JOptionPane.showMessageDialog(null,"Select any Product from Cart");
        }
        
    }//GEN-LAST:event_removeActionPerformed

    private void cartTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartTableMouseClicked
        // TODO add your handling code here:
        remove.setVisible(true);
        
    }//GEN-LAST:event_cartTableMouseClicked

    private void descActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_descActionPerformed

    private void mobile_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mobile_noActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mobile_noActionPerformed

    private void addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressActionPerformed

    private void balanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_balanceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_balanceActionPerformed

    private void balance1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_balance1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_balance1ActionPerformed

    private void address1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_address1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_address1ActionPerformed

    private void payActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_payActionPerformed

    private void remainingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remainingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_remainingActionPerformed
    
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
            java.util.logging.Logger.getLogger(Manage_Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Manage_Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Manage_Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Manage_Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Manage_Order().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address;
    private javax.swing.JTextField address1;
    private javax.swing.JTextField balance;
    private javax.swing.JTextField balance1;
    private javax.swing.JLabel bill;
    private javax.swing.JTable cartTable;
    private javax.swing.JTextField cname;
    private javax.swing.JTextField desc;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField mobile_no;
    private javax.swing.JTextField pay;
    private javax.swing.JTextField pname;
    private javax.swing.JTextField price;
    private javax.swing.JTable ptable;
    private javax.swing.JTextField quantity;
    private javax.swing.JTextField remaining;
    private javax.swing.JButton remove;
    private javax.swing.JButton reset;
    private javax.swing.JButton select_customer;
    // End of variables declaration//GEN-END:variables

    private int getValueOf(String text) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
