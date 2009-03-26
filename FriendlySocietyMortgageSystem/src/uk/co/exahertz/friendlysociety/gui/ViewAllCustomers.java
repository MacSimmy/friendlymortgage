/*
 * ViewAllCustomers.java
 *
 * Created on 18 March 2009, 13:19
 */
package uk.co.exahertz.friendlysociety.gui;

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

        myModel = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };


        table.setModel(myModel);

        initModel();
        
        fillModel();




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
        mainScrollPane = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        table.setModel(model);
        table.getTableHeader().setReorderingAllowed(false);
        mainScrollPane.setViewportView(table);

        jToolBar1.setRollover(true);

        jButton1.setText("View Customer details");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jButton2.setText("Cancel");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
            .addComponent(mainScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE))
        );

        pack();
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
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JScrollPane mainScrollPane;
    private javax.swing.table.DefaultTableModel model;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
