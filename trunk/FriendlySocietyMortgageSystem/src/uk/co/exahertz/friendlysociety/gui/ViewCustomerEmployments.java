/*
 * ViewCustomerCreditChecks.java
 *
 * Created on 02 April 2009, 10:55
 */

package uk.co.exahertz.friendlysociety.gui;

import java.awt.Toolkit;
import java.util.Collection;
import javax.swing.table.DefaultTableModel;
import uk.co.exahertz.friendlysociety.core.Core;
import uk.co.exahertz.friendlysociety.core.Customer;
import uk.co.exahertz.friendlysociety.core.Employment;

/**
 *
 * @author  gp79
 */
public class ViewCustomerEmployments extends javax.swing.JFrame {

    private Core core;
    private DefaultTableModel myModel;
    private Employment[] employments;
    private Customer customer;
    
    
    /** Creates new form ViewCustomerCreditChecks */
    public ViewCustomerEmployments(Core core, Collection<Employment> employments, Customer customer) {
        initComponents();
        
        if (core == null) {
          throw new IllegalArgumentException("The core instance " +
            "cannot be null.");
        }
        if ( employments == null){
            throw new IllegalArgumentException("The employments instance " +
            "cannot be null.");
        }
        if ( customer == null){
            throw new IllegalArgumentException("The customer instance " +
            "cannot be null.");
        }
        this.core = core;
        this.employments = employments.toArray(new Employment[0]);
        this.customer = customer;
        
        setIconImage(Toolkit.getDefaultToolkit().getImage(
        CustomerOption.class.getResource("friendlyicon.jpg")));
        setResizable(false);    //disables maximize button

        myModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int col) { return false; }
        };
        
        
        jTable1.setModel(myModel);

        initModel();
        setRowsInModel();
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("View Employment Details");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Close");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(398, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    // click on view employments details:
    int sr = jTable1.getSelectedRow();
    if (sr >= 0){
        EmploymentDetails empl = new EmploymentDetails(core, customer, employments[sr]);
        empl.setVisible(true);
    }
}//GEN-LAST:event_jButton1ActionPerformed

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    dispose();
}//GEN-LAST:event_jButton2ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new ViewCustomerCreditChecks().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    private void initModel() {
        myModel.addColumn("ID");
        myModel.addColumn("EmployerName");
        myModel.addColumn("Address");
        
        
    }
    
    
    private void emptyModel() {
        while (myModel.getRowCount() != 0) {
            myModel.removeRow(0);
        }
    }
    
    private void setRowsInModel(){
        
        emptyModel();
        
        //setting rows:
        for (int i = 0; i < employments.length; i++) {
            Object[] data = new Object[3];
            data[0] = employments[i].getEmploymentID();
            data[1] = employments[i].getEmployerName();
            data[2] = employments[i].getEmployerAddressObject().toString();
            myModel.addRow(data);
        }
        
    }

}
