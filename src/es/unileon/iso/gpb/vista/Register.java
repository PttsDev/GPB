
package es.unileon.iso.gpb.vista;
import javax.swing.JFrame;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
/**
 *
 * @author diego
 */
public class Register extends JFrame {

    private JFrame parent;
    
    /**
     * Constructor which creates the Register frame
     * setting its parent to null.
     */
    public Register() {
        init();
        this.parent = null;
        
    }
    
    /**
     * Constructor of the Register frame
     * Setting a reference of its parent.
     * @param parent Parent JFrame
     */
    public Register(JFrame parent) {
        init();
        this.parent = parent;
    }

    /**
     * Dispose method
     * Sets its parent visible again if the frame
     * has parent.
     */
    @Override
    public void dispose(){
        if(parent!=null)parent.setVisible(true);
        super.dispose(); 
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        surnameTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        dniTextField = new javax.swing.JTextField();
        nameTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        userTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        passwordTextField = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        confirmPasswordTextField = new javax.swing.JPasswordField();
        OKText = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        typeSelector = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        teacherKeyTextField = new javax.swing.JTextField();
        teacherKeyLabel = new javax.swing.JLabel();
        emailTextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        createAccountButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GPB Register");
        setMinimumSize(new java.awt.Dimension(333, 550));

        jPanel1.setMinimumSize(new java.awt.Dimension(333, 500));
        jPanel1.setPreferredSize(new java.awt.Dimension(333, 500));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("GPB Calendar");
        jLabel1.setAlignmentX(0.5F);

        jLabel2.setText("Name:");

        jLabel3.setText("Surname:");

        surnameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                surnameTextFieldActionPerformed(evt);
            }
        });

        jLabel4.setText("DNI:");

        jLabel5.setText("Username:");

        jLabel6.setText("Password:");

        passwordTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordTextFieldActionPerformed(evt);
            }
        });

        jLabel7.setText("Confirm Password:");

        confirmPasswordTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmPasswordTextFieldActionPerformed(evt);
            }
        });

        OKText.setEditable(false);
        OKText.setForeground(new java.awt.Color(0, 153, 0));

        jButton1.setText("←");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        typeSelector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Student", "Teacher" }));
        typeSelector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeSelectorActionPerformed(evt);
            }
        });

        jLabel8.setText("Account type:");

        teacherKeyLabel.setText("Teacher key:");

        jLabel9.setText("Email:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(userTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(typeSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(teacherKeyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(teacherKeyLabel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                            .addComponent(surnameTextField)
                            .addComponent(dniTextField)
                            .addComponent(nameTextField)
                            .addComponent(passwordTextField)
                            .addComponent(confirmPasswordTextField))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(OKText, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(surnameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dniTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmPasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OKText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(teacherKeyLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(teacherKeyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );

        createAccountButton.setText("Create account");
        createAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createAccountButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(createAccountButton, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(createAccountButton)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void init(){
        initComponents();
        initListeners();
        java.awt.Dimension dim = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        createAccountButton.setEnabled(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        teacherKeyTextField.setVisible(false);
        teacherKeyLabel.setVisible(false);
    }
    /*EVENTS & ACTIONS*/
    
    private void initListeners(){
        
        //Doc listener
        DocumentListener l = new DocumentListener(){
            public void changedUpdate(DocumentEvent e) {
                modified();
            }
            public void removeUpdate(DocumentEvent e) {
                modified();
            }
            public void insertUpdate(DocumentEvent e) {
                modified();
            }

            public void modified() {
                    
                boolean samepw = false;
                
                if(!(passwordTextField.getText().trim().equals("") && 
                        confirmPasswordTextField.getText().trim().equals(""))){
                    samepw = samePw();
                    
                    if(samepw){
                        OKText.setForeground(new java.awt.Color(0,153,0));
                        OKText.setText("\u2714");
                    }else{
                        OKText.setForeground(new java.awt.Color(255,0,0));
                        OKText.setText("\u2718");
                    }
                }
                
                if ( nameTextField.getText().trim().equals("")    || 
                     surnameTextField.getText().trim().equals("") ||      
                     dniTextField.getText().trim().equals("")     ||
                     userTextField.getText().trim().equals("")    ||
                     emailTextField.getText().trim().equals("")   ||
                     passwordTextField.getText().trim().equals("")|| 
                     confirmPasswordTextField.getText().trim().equals("")||
                     (String.valueOf(typeSelector.getSelectedItem()).equals("Teacher") &&
                        !teacherKeyTextField.getText().trim().equals("PROFESOR"))) 
                {
                     createAccountButton.setEnabled(false);
                }
                else { 
                        createAccountButton.setEnabled(samepw);
                }
                
            }
            
            public boolean samePw(){
                
                
             return passwordTextField.getText().trim().equals(confirmPasswordTextField.getText().trim());

            }
        };
                
        nameTextField.getDocument().addDocumentListener(l);
        surnameTextField.getDocument().addDocumentListener(l);
        dniTextField.getDocument().addDocumentListener(l); 
        userTextField.getDocument().addDocumentListener(l);
        emailTextField.getDocument().addDocumentListener(l);
        passwordTextField.getDocument().addDocumentListener(l);
        confirmPasswordTextField.getDocument().addDocumentListener(l);
        teacherKeyTextField.getDocument().addDocumentListener(l);
        
        
        //ComboBox listener
        
        typeSelector.addItemListener(new java.awt.event.ItemListener() {
            
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                if(String.valueOf(typeSelector.getSelectedItem()).equals("Teacher")){
                    createAccountButton.setEnabled(false);
                    teacherKeyTextField.setText("");
                    teacherKeyTextField.setVisible(true);
                    teacherKeyLabel.setVisible(true);
                }
                if(String.valueOf(typeSelector.getSelectedItem()).equals("Student")){
                    teacherKeyTextField.setVisible(false);
                    teacherKeyLabel.setVisible(false);
                }
                    
            }
        });
    }
    
    private void createAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createAccountButtonActionPerformed
        //Register method TODO
        
        //Take data from text fields
        
        //Call controller to create the user
        
        //Message of creation
        
        
        /* Send data to the controller for creating an user with:
        nameTextField.getText().trim()
        surnameTextField.getText().trim()
        dniTextField.getText().trim()
        userTextField.getText().trim()
        emailTextField.getText().trim
        passwordTextField.getText().trim()
        confirmPasswordTextField.getText().trim()
        Tipo: String.valueOf(typeSelector.getSelectedItem())
        */
        this.dispose();
    }//GEN-LAST:event_createAccountButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void confirmPasswordTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmPasswordTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmPasswordTextFieldActionPerformed

    private void passwordTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordTextFieldActionPerformed

    private void surnameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_surnameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_surnameTextFieldActionPerformed

    private void typeSelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeSelectorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_typeSelectorActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField OKText;
    private javax.swing.JPasswordField confirmPasswordTextField;
    private javax.swing.JButton createAccountButton;
    private javax.swing.JTextField dniTextField;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JPasswordField passwordTextField;
    private javax.swing.JTextField surnameTextField;
    private javax.swing.JLabel teacherKeyLabel;
    private javax.swing.JTextField teacherKeyTextField;
    private javax.swing.JComboBox<String> typeSelector;
    private javax.swing.JTextField userTextField;
    // End of variables declaration//GEN-END:variables
}
