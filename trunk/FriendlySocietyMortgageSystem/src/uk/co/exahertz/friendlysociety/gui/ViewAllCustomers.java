/*
 * ViewAllCustomers.java
 *
 * Created on 18 March 2009, 13:19
 */
package uk.co.exahertz.friendlysociety.gui;

import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import uk.co.exahertz.friendlysociety.core.*;

/**
 *
 * @author  Guillaume Pasquet
 */
public class ViewAllCustomers extends javax.swing.JFrame {

    private Core core;
    private DefaultTableModel myModel;

    /** Creates new form ViewAllCustomers */
    public ViewAllCustomers(final Core core) {
        initComponents();

        if (core == null) {
            throw new IllegalArgumentException("The core instance cannot be null.");
        }
        this.core = core;
        setIconImage(Toolkit.getDefaultToolkit().getImage(
        LoginScreen.class.getResource("friendlyicon.jpg")));
        myModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };

        table.setModel(myModel);
        initModel();
        fillModel();
        core.addForm(this);
    }
    
    @Override
    public void dispose() {
        core.removeForm(this);
        super.dispose();
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
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        mainScrollPane = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("View All Customers");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18));
        jLabel6.setText("View All Customers");

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uk/co/exahertz/friendlysociety/gui/friendlysocietywatermarkmini.jpg"))); // NOI18N

        table.setModel(model);
        table.getTableHeader().setReorderingAllowed(false);
        mainScrollPane.setViewportView(table);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Back");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Customer Options");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(452, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(22, 22, 22))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(138, 138, 138))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mainScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(37, 37, 37))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(mainScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
        );

        setBounds(300, 250, 678, 504);
    }// </editor-fold>//GEN-END:initComponents

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    int[] selectedRows = table.getSelectedRows();
    if ( selectedRows.length == 1){//work just if one row is selected
        int selectedRow = selectedRows[0];
        String customerID = myModel.getValueAt(selectedRow, 4).toString();
        
        Customer customer = core.getCustomerByID(Integer.parseInt(customerID));
        
        CustomerOption customerOption = new CustomerOption(core, customer);
        customerOption.setVisible(true);
        dispose();
    }
}//GEN-LAST:event_jButton1ActionPerformed

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    dispose();
}//GEN-LAST:event_jButton2ActionPerformed

    private void fillModel() {
        Collection<Customer> customersCollection = core.getCustomersByName("", "");
        Customer[] customers = customersCollection.toArray(new Customer[0]);
        setRowsInModel(customers);
    }

    private void initModel() {
        myModel.addColumn("Forenames");
        myModel.addColumn("Surname");
        myModel.addColumn("D.O.B");
        myModel.addColumn("National Insurance Number");
        myModel.addColumn("Customer ID");
        myModel.addColumn("Address");

        TableColumn column = null;
        for (int i = 0; i < 5; i++) {
            column = table.getColumnModel().getColumn(i);
            if (i == 0) {//forenames

                column.setPreferredWidth(80);
                column.setMinWidth(80);
                column.setMaxWidth(200);
            } else if (i == 1) {//surname

                column.setPreferredWidth(60);
                column.setMinWidth(60);
                column.setMaxWidth(200);
            } else if (i == 2) {//DOB

                column.setPreferredWidth(80);
                column.setMinWidth(80);
                column.setMaxWidth(200);
            } else if (i == 3) {//NIN

                column.setPreferredWidth(175);
                column.setMinWidth(175);
                column.setMaxWidth(325);
            } else if (i == 4) {//ID

                column.setPreferredWidth(100);
                column.setMinWidth(100);
                column.setMaxWidth(300);
            } else if (i == 5) {//address

                column.setPreferredWidth(250);
                column.setMinWidth(200);
                column.setMaxWidth(300);
            } else {
                column.setPreferredWidth(25);
                column.setMaxWidth(40);
            }
        }

    }

    private void emptyModel() {
        while (myModel.getRowCount() != 0) {
            myModel.removeRow(0);
        }
    }

    private void setRowsInModel(Customer[] customers) {

        emptyModel();


        //setting rows:
        for (int i = 0; i < customers.length; i++) {
            Object[] data = new Object[6];
            data[0] = customers[i].getForenames();
            data[1] = customers[i].getSurname();
            data[2] = customers[i].getDateOfBirth().getTime().toString().substring(0, 10);
            data[3] = customers[i].getNationalInsuranceNumber();
            data[4] = customers[i].getID();
            data[5] = customers[i].getAddressObject().toString();

            myModel.addRow(data);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    Core core = new Core(new uk.co.exahertz.friendlysociety.database.MySQL());
                    new ViewAllCustomers(core).setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ViewAllCustomers.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ViewAllCustomers.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JScrollPane mainScrollPane;
    private javax.swing.table.DefaultTableModel model;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
