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
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.BorderFactory;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author HAMMAD
 */
public class Manage_Product extends javax.swing.JFrame {

    private int product_id = 0;
    private int total_quantity = 0;

    /**
     * Creates new form Manage_Product
     */
    public Manage_Product() {
        
        try{
            
            UIManager.setLookAndFeel(new FlatAtomOneLightIJTheme());
            // Apply global font for the UI
            UIManager.put("defaultFont", new FontUIResource(new Font("Segoe UI", Font.PLAIN, 14)));

        }
        catch(UnsupportedLookAndFeelException e){
            
            e.printStackTrace();
        }
        
        setTitle("Products");
        //setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("blogg.png")));
        //setSize(1200, 1200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
         initComponents();
        
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

    private void getAllCategory() {
        try {
            Connection con = Conn.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select * from category");
            boxcategory.removeAllItems();
            while (rs.next()) {
                boxcategory.addItem(rs.getString("c_id") + "-" + rs.getString("category_name"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private boolean validatefield(String s) {
        if (s.equals("edit") && !txtname.getText().equals("") && !txtprice.getText().equals("") && !txtdescription.getText().equals("")) {
            return false;
        } else if (s.equals("new") && !txtname.getText().equals("") && !txtprice.getText().equals("") && !txtdescription.getText().equals("") && !txtquantity.getText().equals("")) {
            return false;
        } else {
            return true;
        }
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
        jLabel3 = new javax.swing.JLabel();
        labelquantity = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        txtquantity = new javax.swing.JTextField();
        txtprice = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        producttable = new javax.swing.JTable();
        boxcategory = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtdescription = new javax.swing.JTextField();
        btnsave = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        btnreset = new javax.swing.JButton();
        btnclose = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(350, 125));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("Name");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 153));
        jLabel3.setText("Price");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, -1, -1));

        labelquantity.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelquantity.setForeground(new java.awt.Color(0, 153, 153));
        labelquantity.setText("Quantity");
        jPanel1.add(labelquantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, -1, -1));

        jLabel5.setText("jLabel2");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(545, 153, -1, 0));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 153));
        jLabel6.setText("Cateory");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 490, -1, -1));
        jPanel1.add(txtname, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 301, -1));
        jPanel1.add(txtquantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 301, -1));
        jPanel1.add(txtprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 301, -1));

        producttable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Quantity", "Price", "Description", "C_ID", "Category Name"
            }
        ));
        producttable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                producttableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(producttable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, 1050, 550));

        boxcategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(boxcategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 520, 301, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 153));
        jLabel7.setText("Description");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 400, -1, -1));
        jPanel1.add(txtdescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 430, 301, -1));

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
        btnupdate.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        btnupdate.setContentAreaFilled(false);
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });
        jPanel1.add(btnupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 80, 30));

        btnreset.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnreset.setForeground(new java.awt.Color(255, 255, 255));
        btnreset.setText("Reset");
        btnreset.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        btnreset.setContentAreaFilled(false);
        btnreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresetActionPerformed(evt);
            }
        });
        jPanel1.add(btnreset, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 80, 30));

        btnclose.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnclose.setForeground(new java.awt.Color(255, 255, 255));
        btnclose.setText("Close");
        btnclose.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        btnclose.setContentAreaFilled(false);
        btnclose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncloseActionPerformed(evt);
            }
        });
        jPanel1.add(btnclose, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, 80, 30));

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
        jPanel1.add(btndelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, 80, 30));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel8.setBackground(new java.awt.Color(0, 102, 102));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Manage Product");
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel8.setOpaque(true);
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1480, 70));

        jLabel1.setBackground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("  ");
        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 76, 1480, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1473, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        // TODO add your handling code here:
        String name = txtname.getText();
        String quantity = txtquantity.getText();
        String price = txtprice.getText();
        String description = txtdescription.getText();
        String category = (String) boxcategory.getSelectedItem();
        String category_id[] = category.split("-", 0);
        if (validatefield("edit")) {
            JOptionPane.showMessageDialog(null, "Fill all fields");
        } else {
            try {
                if(!quantity.equals("")){
                    total_quantity+= Integer.parseInt(quantity);
                }
                Connection con = Conn.getCon();
                PreparedStatement ps = con.prepareStatement("update product set product_name=?, quantity=?, price=?, Des=?, c_id=? where p_id=?");
                ps.setString(1, name);
                ps.setInt(2, total_quantity);
                ps.setString(3, price);
                ps.setString(4, description);
                ps.setString(5, category_id[0]);
                ps.setInt(6, product_id );

                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Updated SuccessFully");
                setVisible(false);
                new Manage_Product().setVisible(true);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_btnupdateActionPerformed

    private void btncloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncloseActionPerformed

        setVisible(false);
        new first_Page().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btncloseActionPerformed

    private void btnresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresetActionPerformed
        setVisible(false);
        new Manage_Product().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnresetActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        getAllCategory();

        DefaultTableModel model = (DefaultTableModel) producttable.getModel();

        try {

            Connection con = Conn.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select * from product p inner join category c using(c_id)");
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("p_id"), rs.getString("product_name"), rs.getString("quantity"), rs.getString("price"), rs.getString("Des"), rs.getString("c_id"), rs.getString(7)});

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        btnupdate.setEnabled(false);
    }//GEN-LAST:event_formComponentShown

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        // TODO add your handling code here:
        String name = txtname.getText();
        String quantity = txtquantity.getText();
        String price = txtprice.getText();
        String description = txtdescription.getText();
        String category = (String) boxcategory.getSelectedItem();
        String category_id[] = category.split("-", 0);
        if (validatefield("new")) {
            JOptionPane.showMessageDialog(null, "Fill all fields");
        } else {
            try {
                Connection con = Conn.getCon();
                PreparedStatement ps = con.prepareStatement("insert into product (product_name , quantity , price, Des, c_id) values(? , ? , ? , ? , ? )");
                ps.setString(1, name);
                ps.setString(2, quantity);
                ps.setString(3, price);
                ps.setString(4, description);
                ps.setString(5, category_id[0]);

                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Added SuccessFully");
                setVisible(false);
                new Manage_Product().setVisible(true);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_btnsaveActionPerformed

    private void producttableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_producttableMouseClicked
        
        btndelete.setEnabled(true);
        int index = producttable.getSelectedRow();
        TableModel model = producttable.getModel();
        String id = model.getValueAt(index, 0).toString();
        product_id = Integer.parseInt(id);

        String name = model.getValueAt(index, 1).toString();
        txtname.setText(name);

        String quantity = model.getValueAt(index, 2).toString();
        total_quantity = 0;
        labelquantity.setText("ADD MORE QUANTITY");
        total_quantity = Integer.parseInt(quantity);

        String price = model.getValueAt(index, 3).toString();
        txtprice.setText(price);

        String Dec = model.getValueAt(index, 4).toString();
        txtdescription.setText(Dec);

        boxcategory.removeAllItems();
        String category_id = model.getValueAt(index, 5).toString();
        String category_name = model.getValueAt(index, 6).toString();
        boxcategory.addItem(category_id + "-" + category_name);
        try {
            Connection con = Conn.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select * from category");
            boxcategory.removeAllItems();
            while (rs.next()) {
                if (Integer.parseInt(category_id) != rs.getInt(1)) {
                    boxcategory.addItem(rs.getString("c_id") + "-" + rs.getString("category_name"));

                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        //btnsave.setEnabled(false);
        btnupdate.setEnabled(true);

    }//GEN-LAST:event_producttableMouseClicked

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        // TODO add your handling code here:
        try{
                Connection con = Conn.getCon();
                PreparedStatement ps= con.prepareStatement("delete from product where p_id=?");
                ps.setInt(1, product_id);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null,"Deleted SuccessFully");
                setVisible(false);
                new Manage_Product().setVisible(true);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
    }//GEN-LAST:event_btndeleteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.hide();
        setVisible(false);
        first_Page fp = new first_Page();
        fp.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Manage_Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Manage_Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Manage_Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Manage_Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Manage_Product().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxcategory;
    private javax.swing.JButton btnclose;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnreset;
    private javax.swing.JButton btnsave;
    private javax.swing.JButton btnupdate;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelquantity;
    private javax.swing.JTable producttable;
    private javax.swing.JTextField txtdescription;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtprice;
    private javax.swing.JTextField txtquantity;
    // End of variables declaration//GEN-END:variables
}
