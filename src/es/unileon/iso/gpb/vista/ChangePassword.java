package es.unileon.iso.gpb.vista;

import static es.unileon.iso.gpb.controller.Controller.changePassword;
import es.unileon.iso.gpb.modelo.users.User;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Roberto
 */
public class ChangePassword extends javax.swing.JFrame {

    private User user;
    /**
     * Creates new form ChangePassword
     */
    public ChangePassword() {
        this.user=null;
        init();
    }
    
    public ChangePassword(User user) {
        init();
        this.user = user;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Title = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        changePasswordButton = new javax.swing.JButton();
        currentPasswordField = new javax.swing.JPasswordField();
        newPasswordField = new javax.swing.JPasswordField();
        confirmNewPasswordField = new javax.swing.JPasswordField();
        OKText = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        Title.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Title.setText("Change password");

        backButton.setText("←");
        backButton.setFocusable(false);
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Current Password:");

        jLabel2.setText("New password:");

        jLabel3.setText("Confirm new password:");

        changePasswordButton.setText("Change password");
        changePasswordButton.setFocusable(false);
        changePasswordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePasswordButtonActionPerformed(evt);
            }
        });

        OKText.setEditable(false);
        OKText.setForeground(new java.awt.Color(0, 153, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84)
                        .addComponent(Title))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(changePasswordButton)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(confirmNewPasswordField, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                    .addComponent(newPasswordField)
                                    .addComponent(currentPasswordField))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(OKText, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(153, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(backButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(currentPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(newPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(confirmNewPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OKText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(changePasswordButton)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void init(){
        initComponents();
        initListeners();
        changePasswordButton.setEnabled(false);
        java.awt.Dimension dim = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);  
        
        java.awt.Toolkit t = java.awt.Toolkit.getDefaultToolkit();
        setIconImage(t.getImage(getClass().getResource("./logo.png")));
    }
    
    private void initListeners(){
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
                
                if(!(newPasswordField.getText().trim().equals("") && 
                        confirmNewPasswordField.getText().trim().equals(""))){
                    samepw = samePw();
                    
                    if(samepw){
                        OKText.setForeground(new java.awt.Color(0,153,0));
                        OKText.setText("\u2714");
                    }else{
                        OKText.setForeground(new java.awt.Color(255,0,0));
                        OKText.setText("\u2718");
                        
                    }
                }
                
                if ( newPasswordField.getText().trim().equals("")|| 
                     confirmNewPasswordField.getText().trim().equals("")||
                      currentPasswordField.getText().trim().equals("")  ) 
                {
                     changePasswordButton.setEnabled(false);
                }
                else { 
                        changePasswordButton.setEnabled(samepw);
                }
                
            }
            
            public boolean samePw(){
                
                
             return newPasswordField.getText().trim().equals(confirmNewPasswordField.getText().trim());

            }
        };
        
        currentPasswordField.getDocument().addDocumentListener(l);       
        newPasswordField.getDocument().addDocumentListener(l);
        confirmNewPasswordField.getDocument().addDocumentListener(l);
    }
    
    
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    private void changePasswordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePasswordButtonActionPerformed
        
        if( currentPasswordField.getText().trim().length() <5 || currentPasswordField.getText().trim().length()>25 ||
           newPasswordField.getText().trim().length()<5 || newPasswordField.getText().trim().length()>25){
            javax.swing.JOptionPane.showMessageDialog(this, "Wrong input!", "Wrong input!", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        
        boolean ret = changePassword(this.user.getUserName(), currentPasswordField.getText().trim(), newPasswordField.getText().trim());
        if(!ret){javax.swing.JOptionPane.showMessageDialog(this, "Wrong password!", "Wrong password!", javax.swing.JOptionPane.ERROR_MESSAGE);}
        else{javax.swing.JOptionPane.showMessageDialog(this, "Password Changed Successfully", "Password Changed!", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                this.dispose();}
    }//GEN-LAST:event_changePasswordButtonActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField OKText;
    private javax.swing.JLabel Title;
    private javax.swing.JButton backButton;
    private javax.swing.JButton changePasswordButton;
    private javax.swing.JPasswordField confirmNewPasswordField;
    private javax.swing.JPasswordField currentPasswordField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField newPasswordField;
    // End of variables declaration//GEN-END:variables
}
