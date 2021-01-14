package es.unileon.iso.gpb.vista;

import es.unileon.iso.gpb.modelo.sets.Subject;
import es.unileon.iso.gpb.modelo.users.User;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Roberto
 */
public class CreateGroup extends javax.swing.JFrame {

    private Subject subject;
    /**
     * Creates new form ChangePassword
     */
    public CreateGroup() {
        this.subject=null;
        init();
    }
    
    public CreateGroup(Subject subject) {
        init();
        this.subject = subject;
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
        createGroupButton = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        name = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        Title.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Title.setText(" Create group");

        backButton.setText("←");
        backButton.setFocusable(false);
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        createGroupButton.setText("Create Group");
        createGroupButton.setFocusable(false);
        createGroupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createGroupButtonActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B1", "B3" }));

        jLabel1.setText("Name:");

        jLabel2.setText("Type:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(createGroupButton))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))))
                .addContainerGap(177, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(backButton))
                    .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(createGroupButton)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void init(){
        initComponents();
        initListeners();
        createGroupButton.setEnabled(false);
        java.awt.Dimension dim = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);  
        
        java.awt.Toolkit t = java.awt.Toolkit.getDefaultToolkit();
        setIconImage(t.getImage(getClass().getResource("./logo.png")));
    }
    
    private void initListeners(){

        name.getDocument().addDocumentListener(new DocumentListener(){
            public void changedUpdate(DocumentEvent e) {
                modified();
            }
            public void removeUpdate(DocumentEvent e) {
                modified();
            }
            public void insertUpdate(DocumentEvent e) {
                modified();
            }
            
            public void modified(){
                
                if(!name.getText().trim().equals(""))
                    createGroupButton.setEnabled(true);
                if(name.getText().trim().equals(""))
                    createGroupButton.setEnabled(false);
            }
        });
    }
    
    
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    private void createGroupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createGroupButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_createGroupButtonActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Title;
    private javax.swing.JButton backButton;
    private javax.swing.JButton createGroupButton;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField name;
    // End of variables declaration//GEN-END:variables
}
