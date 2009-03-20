/*
 * SearchCustomer.java
 *
 * Created on 03 March 2009, 14:58
 */
package uk.co.exahertz.friendlysociety.gui;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import uk.co.exahertz.friendlysociety.core.*;

;

/**
 *
 * @author  gp79
 */
public class SearchCustomer extends javax.swing.JFrame {

    private Core core;
    private DefaultTableModel myModel;

    /** Creates new form SearchCustomer */
    public SearchCustomer(Core core) {
        initComponents();

        if (core == null) {
            throw new IllegalArgumentException("The core instance cannot be null.");
        }
        this.core = core;

        
        myModel = new DefaultTableModel() {
            public boolean isCellEditable(int row, int col) { return false; }
        };

        initModel();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        model = new javax.swing.table.DefaultTableModel();
        mainPanel = new javax.swing.JPanel();
        searchResultPane = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        searchByNamePane = new javax.swing.JPanel();
        surnameLabel = new javax.swing.JLabel();
        surnameTextField = new javax.swing.JTextField();
        nameLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        searchByAddressPane = new javax.swing.JPanel();
        propertyNameTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        streetNameTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        postCodeTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        townTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        countryTextField = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        editCustomerButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(model);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                mouseReleasedHandler(evt);
            }
        });
        searchResultPane.setViewportView(jTable1);

        searchByNamePane.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        surnameLabel.setText("Surname:");

        surnameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                surnameTextFieldActionPerformed(evt);
            }
        });

        nameLabel.setText("Forenames:");

        nameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextFieldActionPerformed(evt);
            }
        });

        jButton1.setText("Search>>");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout searchByNamePaneLayout = new javax.swing.GroupLayout(searchByNamePane);
        searchByNamePane.setLayout(searchByNamePaneLayout);
        searchByNamePaneLayout.setHorizontalGroup(
            searchByNamePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchByNamePaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(surnameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(surnameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(490, Short.MAX_VALUE))
        );
        searchByNamePaneLayout.setVerticalGroup(
            searchByNamePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchByNamePaneLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addGroup(searchByNamePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(surnameLabel)
                    .addComponent(surnameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Search by name", searchByNamePane);

        propertyNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                propertyNameTextFieldActionPerformed(evt);
            }
        });

        jLabel1.setText("Property name:");

        jLabel2.setText("Street name:");

        streetNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                streetNameTextFieldActionPerformed(evt);
            }
        });

        jLabel3.setText("Postcode:");

        jLabel4.setText("Town:");

        townTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                townTextFieldActionPerformed(evt);
            }
        });

        jLabel5.setText("Country:");

        jButton2.setText("Search >>");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout searchByAddressPaneLayout = new javax.swing.GroupLayout(searchByAddressPane);
        searchByAddressPane.setLayout(searchByAddressPaneLayout);
        searchByAddressPaneLayout.setHorizontalGroup(
            searchByAddressPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchByAddressPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchByAddressPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(searchByAddressPaneLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(streetNameTextField))
                    .addGroup(searchByAddressPaneLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(propertyNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(searchByAddressPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(6, 6, 6)
                .addGroup(searchByAddressPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchByAddressPaneLayout.createSequentialGroup()
                        .addComponent(townTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(4, 4, 4)
                        .addComponent(countryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2))
                    .addComponent(postCodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(301, Short.MAX_VALUE))
        );
        searchByAddressPaneLayout.setVerticalGroup(
            searchByAddressPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchByAddressPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchByAddressPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(propertyNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(postCodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(searchByAddressPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(streetNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(townTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(countryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Search by address", searchByAddressPane);

        jToolBar1.setRollover(true);

        editCustomerButton.setText("See/Edit Customer Details >>");
        editCustomerButton.setFocusable(false);
        editCustomerButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        editCustomerButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        editCustomerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clickOnEditCustomerButtonHandler(evt);
            }
        });
        jToolBar1.add(editCustomerButton);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(searchResultPane, javax.swing.GroupLayout.DEFAULT_SIZE, 859, Short.MAX_VALUE)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 859, Short.MAX_VALUE)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 859, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchResultPane, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void surnameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_surnameTextFieldActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_surnameTextFieldActionPerformed

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    String surname = surnameTextField.getText();
    String forenames = nameTextField.getText();
    performSearchByName(surname, forenames);
//performSearchBySurname(surname);
}//GEN-LAST:event_jButton1ActionPerformed

private void nameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextFieldActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_nameTextFieldActionPerformed

private void propertyNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_propertyNameTextFieldActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_propertyNameTextFieldActionPerformed

private void streetNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_streetNameTextFieldActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_streetNameTextFieldActionPerformed

private void townTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_townTextFieldActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_townTextFieldActionPerformed

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed


    performSearchByAdress(countryTextField.getText(), townTextField.getText(),
            postCodeTextField.getText(), streetNameTextField.getText(),
            propertyNameTextField.getText());
}//GEN-LAST:event_jButton2ActionPerformed

private void mouseReleasedHandler(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mouseReleasedHandler
    editCustomerButton.setEnabled(true);
}//GEN-LAST:event_mouseReleasedHandler

private void clickOnEditCustomerButtonHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clickOnEditCustomerButtonHandler
    int[] selectedRows = jTable1.getSelectedRows();
    if ( selectedRows.length == 1){//work just if one row is selected
        int selectedRow = selectedRows[0];
        String customerID = model.getValueAt(selectedRow, 4).toString();
        
        Customer customer = core.getCustomerByID(Integer.parseInt(customerID));
        
        CustomerDetails customerDetails = new CustomerDetails(core, customer);
        customerDetails.setVisible(true);
    }
    editCustomerButton.setEnabled(false);
}//GEN-LAST:event_clickOnEditCustomerButtonHandler

    private void performSearchByName(final String surname, final String forenames) {

        Collection<Customer> customersCollection = core.getCustomersByName(surname, forenames);
        Customer[] customers = customersCollection.toArray(new Customer[0]);

        setRowsInModel(customers);


    }

    private void performSearchByAdress(final String country, final String town,
            final String postcode, final String streetName,
            final String propertyName) {
     
        Collection<Customer> customersCollection = core.getCustomersByAddress(country, town, postcode, streetName, propertyName);
        //Collection<Customer> customersCollection = core.getCustomersByName("", "");
        Customer[] customers = customersCollection.toArray(new Customer[0]);

        setRowsInModel(customers);
        
    }

    private void initModel() {
        model.addColumn("forenames");
        model.addColumn("surname");
        model.addColumn("Date of Birth");
        model.addColumn("Nationale Insurance Number");
        model.addColumn("Customer ID");
        model.addColumn("Address");
        
        TableColumn column = null;
        for (int i = 0; i < 5; i++) {
            column = jTable1.getColumnModel().getColumn(i);
            if (i == 0) {//forenames
                column.setPreferredWidth(80);
                column.setMinWidth(80);
                column.setMaxWidth(200);
            } 
            else if ( i == 1){//surname
                column.setPreferredWidth(60);
                column.setMinWidth(60);
                column.setMaxWidth(200);
            }
            else if ( i == 2){//DOB
                column.setPreferredWidth(80);
                column.setMinWidth(80);
                column.setMaxWidth(200);
            }
            else if ( i == 3){//NIN
                column.setPreferredWidth(175);
                column.setMinWidth(175);
                column.setMaxWidth(325);
            }
            else if ( i == 4){//ID
                column.setPreferredWidth(100);
                column.setMinWidth(100);
                column.setMaxWidth(300);
            }
            else if ( i == 5){//address
                column.setPreferredWidth(250);
                column.setMinWidth(200);
                column.setMaxWidth(300);
            }
            else {
                column.setPreferredWidth(25);
                column.setMaxWidth(40);
            }
        }

    }

    private void emptyModel() {
        while (model.getRowCount() != 0) {
            model.removeRow(0);
        }
    }
    
    private void setRowsInModel(Customer[] customers){
        
        emptyModel();
        editCustomerButton.setEnabled(false);
        
        //setting rows:
        for (int i = 0; i < customers.length; i++) {
            Object[] data = new Object[6];
            data[0] = customers[i].getForenames();
            data[1] = customers[i].getSurname();
            data[2] = customers[i].getDateOfBirth().getTime().toString().substring(0, 10);
            data[3] = customers[i].getNationalInsuranceNumber();
            data[4] = customers[i].getID();
            data[5] = customers[i].getAddressObject().toString();

            model.addRow(data);
        }
    }
    
   

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    new SearchCustomer(new Core(new uk.co.exahertz.friendlysociety.database.MySQL())).setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(SearchCustomer.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(SearchCustomer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField countryTextField;
    private javax.swing.JButton editCustomerButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.table.DefaultTableModel model;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JTextField postCodeTextField;
    private javax.swing.JTextField propertyNameTextField;
    private javax.swing.JPanel searchByAddressPane;
    private javax.swing.JPanel searchByNamePane;
    private javax.swing.JScrollPane searchResultPane;
    private javax.swing.JTextField streetNameTextField;
    private javax.swing.JLabel surnameLabel;
    private javax.swing.JTextField surnameTextField;
    private javax.swing.JTextField townTextField;
    // End of variables declaration//GEN-END:variables
}
