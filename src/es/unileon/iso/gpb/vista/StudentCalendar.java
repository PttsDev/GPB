
package es.unileon.iso.gpb.vista;

import es.unileon.iso.gpb.modelo.users.User;
import java.time.DayOfWeek;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;

/**
 *
 * @author diego
 */
public class StudentCalendar extends javax.swing.JFrame {

    private JFrame parent;
    private User user;
    
    /**
     * Constructor which creates the GeneralCalendar
     * Frame setting its parent to null.
     */
    public StudentCalendar() {
        this.user = null;
        init();
    }
    
    /**
     * Constructor of the GeneralCalendar frame
     * Setting a reference of its parent.
     * @param parent Parent JFrame
     */
    public StudentCalendar(JFrame parent) {
        this.user=null;
        init();
        this.parent = parent;
    }
    
     /**
     * Constructor of the GeneralCalendar frame
     * Setting a reference of its parent.
     * @param parent Parent JFrame
     * @param user User who did login
     */
    public StudentCalendar(JFrame parent, User user) {
        this.user = user;
        
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        logOutButton = new javax.swing.JButton();
        nameLabel = new javax.swing.JLabel();
        subjectComboBox = new javax.swing.JComboBox<>();
        g1RadioButton = new javax.swing.JRadioButton();
        g2RadioButton = new javax.swing.JRadioButton();
        g3RadioButton = new javax.swing.JRadioButton();
        g4RadioButton = new javax.swing.JRadioButton();
        createButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        remveButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        calendarioTable = new javax.swing.JTable();
        previusButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        weekLabel = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(821, 541));

        logOutButton.setText("Log out");
        logOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutButtonActionPerformed(evt);
            }
        });

        nameLabel.setText("Disconnected");

        subjectComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        buttonGroup1.add(g1RadioButton);
        g1RadioButton.setText("G1");
        g1RadioButton.setEnabled(false);
        g1RadioButton.setHideActionText(true);
        g1RadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                g1RadioButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(g2RadioButton);
        g2RadioButton.setText("G2");
        g2RadioButton.setEnabled(false);

        buttonGroup1.add(g3RadioButton);
        g3RadioButton.setText("G3");
        g3RadioButton.setEnabled(false);

        buttonGroup1.add(g4RadioButton);
        g4RadioButton.setText("G4");
        g4RadioButton.setEnabled(false);

        createButton.setText("Create");
        createButton.setEnabled(false);

        editButton.setText("Edit");
        editButton.setEnabled(false);

        remveButton.setText("Remove");
        remveButton.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(remveButton)
                    .addComponent(editButton)
                    .addComponent(createButton)
                    .addComponent(g4RadioButton)
                    .addComponent(g3RadioButton)
                    .addComponent(g2RadioButton)
                    .addComponent(g1RadioButton)
                    .addComponent(subjectComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(nameLabel)
                        .addGap(18, 18, 18)
                        .addComponent(logOutButton))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logOutButton)
                    .addComponent(nameLabel))
                .addGap(82, 82, 82)
                .addComponent(createButton)
                .addGap(18, 18, 18)
                .addComponent(editButton)
                .addGap(18, 18, 18)
                .addComponent(remveButton)
                .addGap(50, 50, 50)
                .addComponent(subjectComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(g1RadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(g2RadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(g3RadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(g4RadioButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setColumnHeaderView(null);

        calendarioTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"00:00", null, null, null, null, null, null, null},
                {"01:00", null, null, null, null, null, null, null},
                {"02:00", null, null, null, null, null, null, null},
                {"03:00", null, null, null, null, null, null, null},
                {"04:00", null, null, null, null, null, null, null},
                {"05:00", null, null, null, null, null, null, null},
                {"06:00", null, null, null, null, null, null, null},
                {"07:00", null, null, null, null, null, null, null},
                {"08:00", null, null, null, null, null, null, null},
                {"09:00", null, null, null, null, null, null, null},
                {"10:00", null, null, null, null, null, null, null},
                {"11:00", null, null, null, null, null, null, null},
                {"12:00", null, null, null, null, null, null, null},
                {"13:00", null, null, null, null, null, null, null},
                {"14:00", null, null, null, null, null, null, null},
                {"15:00", null, null, null, null, null, null, null},
                {"16:00", null, null, null, null, null, null, null},
                {"17:00", null, null, null, null, null, null, null},
                {"18:00", null, null, null, null, null, null, null},
                {"19:00", null, null, null, null, null, null, null},
                {"20:00", null, null, null, null, null, null, null},
                {"21:00", null, null, null, null, null, null, null},
                {"22:00", null, null, null, null, null, null, null},
                {"23:00", null, null, null, null, null, null, null}
            },
            new String [] {
                "Hours", "Monday", "Tueday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        calendarioTable.setMinimumSize(new java.awt.Dimension(600, 384));
        jScrollPane1.setViewportView(calendarioTable);

        previusButton.setText("Previus");

        nextButton.setText("Next");

        weekLabel.setText("Day x to x (modificar)");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "General Calendar", "Personal Calendar" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(previusButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nextButton)
                        .addGap(33, 33, 33)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(weekLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(previusButton)
                            .addComponent(nextButton)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addComponent(weekLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 26, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void init(){
        this.parent = null;
        
        initComponents();
        initListeners();
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        java.awt.Dimension dim = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);  
        
        //start week label
        LocalDate today = LocalDate.now( ZoneId.of( "Europe/Madrid" ) );
        LocalDate wMonday = today.with( TemporalAdjusters.previous( DayOfWeek.MONDAY ) );
        LocalDate wSunday = today.with( TemporalAdjusters.next( DayOfWeek.SUNDAY ) );
        weekLabel.setText("From: "+wMonday.toString()+" To: "+wSunday);
        
        //Username
        if(user!=null)
            nameLabel.setText(user.getUserName());
        

    }
    /*EVENTS & ACTIONS*/
        
    /**
     * Method that inits event listeners
     */
    private void initListeners(){
        StudentCalendar frame = this;
        this.addWindowListener( new java.awt.event.WindowAdapter(){
            
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt){
                
                String[] ops = {"Log out", "Close", "Cancel"};
                
                int o = JOptionPane.showOptionDialog(null, "Do you want to exit?", "Exit?", 
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, 
                        null, ops, ops[0]);
                
                switch(o){
                    case 0:
                        frame.dispose();
                        break;
                    case 1:
                        System.exit(0);
                    case 2: 
                        break;
                }
                
            }
    
        });
        
        
        
    }
    
    private void logOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutButtonActionPerformed
        
        String[] ops = {"Yes", "No"};
        
        int o = JOptionPane.showOptionDialog(null, "Do you want to log out?", "Log out?", 
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, 
                        null, ops, ops[0]);
        switch(o){
            case 0:
                this.dispose();
                break;
            case 1:
                break;
        }
    }//GEN-LAST:event_logOutButtonActionPerformed

    private void g1RadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_g1RadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_g1RadioButtonActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTable calendarioTable;
    private javax.swing.JButton createButton;
    private javax.swing.JButton editButton;
    private javax.swing.JRadioButton g1RadioButton;
    private javax.swing.JRadioButton g2RadioButton;
    private javax.swing.JRadioButton g3RadioButton;
    private javax.swing.JRadioButton g4RadioButton;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logOutButton;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton nextButton;
    private javax.swing.JButton previusButton;
    private javax.swing.JButton remveButton;
    private javax.swing.JComboBox<String> subjectComboBox;
    private javax.swing.JLabel weekLabel;
    // End of variables declaration//GEN-END:variables
}
