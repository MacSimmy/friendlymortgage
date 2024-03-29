/*
 * StaffDetails.java
 *
 * Created on 26 March 2009, 20:48
 */

package uk.co.exahertz.friendlysociety.gui;

import uk.co.exahertz.friendlysociety.core.*;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import java.util.GregorianCalendar;

/**
 *
 * @author  kal8
 */
public class StaffDetails extends javax.swing.JFrame {

    private Core core;
    private StaffMember staff;
    
    /** Creates new form StaffDetails */
    public StaffDetails(final Core core, final StaffMember staff) {
        if(core == null) throw new IllegalArgumentException("The core " +
                "instance must not be null.");
        if(staff == null) throw new IllegalArgumentException("The staff " +
                "member instance must not be null.");
        this.core = core;
        this.staff = staff;
        if(!core.getLoggedInAs().getIsManager()) {
            dispose();
            return;
        }
        setIconImage(Toolkit.getDefaultToolkit().getImage(
        LoginScreen.class.getResource("images/friendlyicon.jpg")));
        initComponents();
        setResizable(false);
        jComboTitle.setSelectedItem(staff.getTitle());
        jTextForenames.setText(staff.getForenames());
        jTextSurname.setText(staff.getSurname());
        GregorianCalendar dob = staff.getDateOfBirth();
        jTextDOB.setText(dob.get(GregorianCalendar.DAY_OF_MONTH) + "/" +
                dob.get(GregorianCalendar.MONTH) + "/" +
                dob.get(GregorianCalendar.YEAR));
        if(staff.getIsFemale()) {
            jComboGender.setSelectedItem("Female");
        } else {
            jComboGender.setSelectedItem("Male");
        }
        jTextTelephone.setText(staff.getTelephoneNumber());
        jTextFax.setText(staff.getFaxNumber());
        jTextEmail.setText(staff.getEmailAddress());
        jCheckBoxManager.setSelected(staff.getIsManager());
        jCheckBoxStillWith.setSelected(staff.getIsStillWithCompany());
        jTextStaffPropertyName.setText(
                staff.getAddressObject().getPropertyName());
        jTextStaffStreetName.setText(
                staff.getAddressObject().getStreetName());
        jTextStaffTownName.setText(staff.getAddressObject().getTown());
        jTextStaffPostCode.setText(
                staff.getAddressObject().getPostCode());
        jTextStaffCountry.setText(staff.getAddressObject().getCountry());
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabelIcon = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTextStaffPropertyName = new javax.swing.JTextField();
        jTextStaffStreetName = new javax.swing.JTextField();
        jTextStaffTownName = new javax.swing.JTextField();
        jTextStaffPostCode = new javax.swing.JTextField();
        jTextStaffCountry = new javax.swing.JTextField();
        jButtonSubmit = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabelTitle = new javax.swing.JLabel();
        jLabelForenames = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextForenames = new javax.swing.JTextField();
        jTextSurname = new javax.swing.JTextField();
        jTextDOB = new javax.swing.JTextField();
        jComboGender = new javax.swing.JComboBox();
        jTextTelephone = new javax.swing.JTextField();
        jTextFax = new javax.swing.JTextField();
        jTextEmail = new javax.swing.JTextField();
        jCheckBoxManager = new javax.swing.JCheckBox();
        jCheckBoxStillWith = new javax.swing.JCheckBox();
        jComboTitle = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("uk/co/exahertz/friendlysociety/gui/Bundle"); // NOI18N
        setTitle(bundle.getString("StaffDetails.title")); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18));
        jLabel1.setText(bundle.getString("StaffDetails.jLabel1.text")); // NOI18N

        jLabelIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uk/co/exahertz/friendlysociety/gui/images/friendlysocietywatermarkmini.jpg"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18));
        jLabel8.setText(bundle.getString("StaffDetails.jLabel8.text")); // NOI18N

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel10.setText(bundle.getString("StaffDetails.jLabel10.text")); // NOI18N

        jLabel12.setText(bundle.getString("StaffDetails.jLabel12.text")); // NOI18N

        jLabel13.setText(bundle.getString("StaffDetails.jLabel13.text")); // NOI18N

        jLabel14.setText(bundle.getString("StaffDetails.jLabel14.text")); // NOI18N

        jLabel15.setText(bundle.getString("StaffDetails.jLabel15.text")); // NOI18N

        jLabel16.setText(bundle.getString("StaffDetails.jLabel16.text")); // NOI18N

        jTextStaffPropertyName.setText(bundle.getString("StaffDetails.jTextStaffPropertyName.text")); // NOI18N

        jTextStaffStreetName.setText(bundle.getString("StaffDetails.jTextStaffStreetName.text")); // NOI18N

        jTextStaffTownName.setText(bundle.getString("StaffDetails.jTextStaffTownName.text")); // NOI18N

        jTextStaffPostCode.setText(bundle.getString("StaffDetails.jTextStaffPostCode.text")); // NOI18N

        jTextStaffCountry.setText(bundle.getString("StaffDetails.jTextStaffCountry.text")); // NOI18N

        jButtonSubmit.setBackground(new java.awt.Color(255, 255, 255));
        jButtonSubmit.setText(bundle.getString("StaffDetails.jButtonSubmit.text")); // NOI18N
        jButtonSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSubmitActionPerformed(evt);
            }
        });

        jButtonCancel.setBackground(new java.awt.Color(255, 255, 255));
        jButtonCancel.setText(bundle.getString("StaffDetails.jButtonCancel.text")); // NOI18N
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextStaffCountry)
                                .addComponent(jTextStaffPostCode)
                                .addComponent(jTextStaffTownName)
                                .addComponent(jTextStaffStreetName)
                                .addComponent(jTextStaffPropertyName, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jButtonSubmit)
                                .addGap(17, 17, 17)
                                .addComponent(jButtonCancel)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTextStaffPropertyName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTextStaffStreetName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(jTextStaffTownName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jTextStaffPostCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jTextStaffCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancel)
                    .addComponent(jButtonSubmit))
                .addGap(30, 30, 30))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel11.setText(bundle.getString("StaffDetails.jLabel11.text")); // NOI18N

        jLabelTitle.setText(bundle.getString("StaffDetails.jLabelTitle.text")); // NOI18N

        jLabelForenames.setText(bundle.getString("StaffDetails.jLabelForenames.text")); // NOI18N

        jLabel2.setText(bundle.getString("StaffDetails.jLabel2.text")); // NOI18N

        jLabel3.setText(bundle.getString("StaffDetails.jLabel3.text")); // NOI18N

        jLabel4.setText(bundle.getString("StaffDetails.jLabel4.text")); // NOI18N

        jLabel5.setText(bundle.getString("StaffDetails.jLabel5.text")); // NOI18N

        jLabel6.setText(bundle.getString("StaffDetails.jLabel6.text")); // NOI18N

        jLabel7.setText(bundle.getString("StaffDetails.jLabel7.text")); // NOI18N

        jTextForenames.setText(bundle.getString("StaffDetails.jTextForenames.text")); // NOI18N

        jTextSurname.setText(bundle.getString("StaffDetails.jTextSurname.text")); // NOI18N

        jTextDOB.setText(bundle.getString("StaffDetails.jTextDOB.text")); // NOI18N

        jComboGender.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));

        jTextTelephone.setText(bundle.getString("StaffDetails.jTextTelephone.text")); // NOI18N

        jTextFax.setText(bundle.getString("StaffDetails.jTextFax.text")); // NOI18N

        jTextEmail.setText(bundle.getString("StaffDetails.jTextEmail.text")); // NOI18N

        jCheckBoxManager.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBoxManager.setText(bundle.getString("StaffDetails.jCheckBoxManager.text")); // NOI18N
        jCheckBoxManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxManagerActionPerformed(evt);
            }
        });

        jCheckBoxStillWith.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBoxStillWith.setText(bundle.getString("StaffDetails.jCheckBoxStillWith.text")); // NOI18N

        jComboTitle.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mr", "Mrs", "Miss", "Ms", "Dr" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelTitle)
                                    .addComponent(jLabelForenames)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel7))
                                .addGap(22, 22, 22)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextForenames, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                                            .addComponent(jTextSurname, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                                            .addComponent(jTextDOB, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                                            .addComponent(jTextTelephone, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                                            .addComponent(jTextFax, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                                            .addComponent(jTextEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addComponent(jComboTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jComboGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jCheckBoxManager)
                                .addGap(18, 18, 18)
                                .addComponent(jCheckBoxStillWith)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel11)
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTitle)
                    .addComponent(jComboTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelForenames)
                    .addComponent(jTextForenames, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextDOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jComboGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextTelephone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel7))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxManager)
                    .addComponent(jCheckBoxStillWith))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(233, 233, 233)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel1))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel8)))
                        .addGap(11, 11, 11)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelIcon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setBounds(250, 250, 831, 444);
    }// </editor-fold>//GEN-END:initComponents

private void jCheckBoxManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxManagerActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jCheckBoxManagerActionPerformed

private void jButtonSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSubmitActionPerformed
    Address address;
    try {
        address = new Address(staff.getAddressObject().getAddressID(),
                jTextStaffPropertyName.getText(),
                jTextStaffStreetName.getText(), jTextStaffTownName.getText(),
                jTextStaffCountry.getText(), jTextStaffPostCode.getText());
    } catch(IllegalArgumentException e) {
        JOptionPane.showMessageDialog(null, "Exception: " + e.toString(),
                "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    String[] dob = jTextDOB.getText().split("/");
    if(dob.length != 3) {
        JOptionPane.showMessageDialog(null, "The member of staff could not " +
                "be added to the database as the Date Of Birth is not in " +
                "the correct format. The correct format is DD/MM/YYYY.",
                "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    GregorianCalendar dobObject;
    try {
        dobObject = new GregorianCalendar(Integer.parseInt(dob[2]),
                Integer.parseInt(dob[1]), Integer.parseInt(dob[0]));
    } catch(NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "The member of staff could not " +
                "be added to the database as the Date Of Birth is not in " +
                "the correct format. The correct format is DD/MM/YYYY.",
                "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    boolean isFemale;
    if(jComboGender.getSelectedItem().equals("Female")) {
        isFemale = true;
    } else {
        isFemale = false;
    }
    
    boolean isManager = jCheckBoxManager.isSelected();
    boolean stillWithCompany = jCheckBoxStillWith.isSelected();
    if(jTextForenames.getText().length() < 2) {
        JOptionPane.showMessageDialog(null, "The member of staff could not " +
                "be added to the database as the forenames must be at least " +
                "2 characters.",
                "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    try {
        if(core.modifyStaffMember(new StaffMember(staff.getID(),
                (String)jComboTitle.getSelectedItem(),
                jTextForenames.getText(), jTextSurname.getText(), dobObject,
                isFemale, address, jTextTelephone.getText(), jTextFax.getText(),
                jTextEmail.getText(), isManager, staff.getUsername(),
                "a",
                stillWithCompany)))
        {
            JOptionPane.showMessageDialog(null, "The member of staff was " +
                "successfully modified.",
                "Success", JOptionPane.PLAIN_MESSAGE);
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "The member of staff failed " +
                    "to be changed in the database", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    } catch(IllegalArgumentException e) {
        JOptionPane.showMessageDialog(null, "Exception: " + e.toString(),
                "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
}//GEN-LAST:event_jButtonSubmitActionPerformed

private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
    dispose();
}//GEN-LAST:event_jButtonCancelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonSubmit;
    private javax.swing.JCheckBox jCheckBoxManager;
    private javax.swing.JCheckBox jCheckBoxStillWith;
    private javax.swing.JComboBox jComboGender;
    private javax.swing.JComboBox jComboTitle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelForenames;
    private javax.swing.JLabel jLabelIcon;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextDOB;
    private javax.swing.JTextField jTextEmail;
    private javax.swing.JTextField jTextFax;
    private javax.swing.JTextField jTextForenames;
    private javax.swing.JTextField jTextStaffCountry;
    private javax.swing.JTextField jTextStaffPostCode;
    private javax.swing.JTextField jTextStaffPropertyName;
    private javax.swing.JTextField jTextStaffStreetName;
    private javax.swing.JTextField jTextStaffTownName;
    private javax.swing.JTextField jTextSurname;
    private javax.swing.JTextField jTextTelephone;
    // End of variables declaration//GEN-END:variables

}
