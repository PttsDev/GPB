
package es.unileon.iso.gpb.vista;

import static es.unileon.iso.gpb.controller.Controller.getTipo;
import static es.unileon.iso.gpb.controller.Controller.loginUser;
import es.unileon.iso.gpb.modelo.users.User;
import javax.swing.JFrame;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


/**
 *
 * @author diego
 */
public class LogIn extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public LogIn() {
        init();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        singInButton = new javax.swing.JButton();
        passwordField = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        singUpButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        userTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GPB Login");
        setMinimumSize(new java.awt.Dimension(333, 282));
        setResizable(false);

        singInButton.setText("Sing in");
        singInButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        singInButton.setFocusable(false);
        singInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                singInButtonActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("User:");

        jLabel2.setText("Password:");

        singUpButton.setText("Sing up");
        singUpButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        singUpButton.setFocusable(false);
        singUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                singUpButtonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("GPB Calendar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(userTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                    .addComponent(singUpButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(passwordField)
                    .addComponent(singInButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(jLabel3))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(userTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(singInButton)
                        .addGap(18, 18, 18)))
                .addComponent(singUpButton))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void init(){
        initComponents();
        initListeners();
        java.awt.Toolkit t = java.awt.Toolkit.getDefaultToolkit();
        setIconImage(t.getImage(getClass().getResource("./logo.png")));
        java.awt.Dimension dim = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        singInButton.setEnabled(false);
    }
    
    private void singInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_singInButtonActionPerformed
        //Check fields TODO
        
        /*
        * Send to controller to check
        * userTextField.getText().trim();
        * passwordField.getText().trim();
        */
        /*
        * Receive user from controler
        */
        if( userTextField.getText().trim().length()>25    ||
           passwordField.getText().trim().length()<5      ||
           userTextField.getText().trim().length()<5      ||
           passwordField.getText().trim().length()<5 ){
            javax.swing.JOptionPane.showMessageDialog(new JFrame(), "Wrong input", "Bad login", javax.swing.JOptionPane.ERROR_MESSAGE);
        }else{
        
            User user = loginUser(userTextField.getText().trim(), passwordField.getText().trim());
        
            if(user==null){
            
                javax.swing.JOptionPane.showMessageDialog(new JFrame(), "Account not found", "Bad login", javax.swing.JOptionPane.ERROR_MESSAGE);
            
            }else{
            
                String type = getTipo(user.getID());
                this.setVisible(false);
                new Calendar(this, user, type).setVisible(true);
            
            }  
        }

    }//GEN-LAST:event_singInButtonActionPerformed

    private void singUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_singUpButtonActionPerformed
        this.setVisible(false);
        new Register(this).setVisible(true);
    }//GEN-LAST:event_singUpButtonActionPerformed

    
    
    /*EVENTS*/
    
    public void initListeners(){
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
                    
                
                if ( userTextField.getText().trim().equals("")    || 
                     passwordField.getText().trim().equals("")     ) 
                {
                     singInButton.setEnabled(false);
                }
                else { 
                       singInButton.setEnabled(true);
                }
                
            }
            
        };
            
       userTextField.getDocument().addDocumentListener(l);
       passwordField.getDocument().addDocumentListener(l);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JButton singInButton;
    private javax.swing.JButton singUpButton;
    private javax.swing.JTextField userTextField;
    // End of variables declaration//GEN-END:variables
}
