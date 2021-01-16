
package es.unileon.iso.gpb.vista;

import static es.unileon.iso.gpb.controller.Controller.listLectures;
import es.unileon.iso.gpb.modelo.activities.Lecture;
import es.unileon.iso.gpb.modelo.activities.Meeting;
import es.unileon.iso.gpb.modelo.activities.PersonalActivity;
import es.unileon.iso.gpb.modelo.activities.Tutorship;
import es.unileon.iso.gpb.modelo.users.User;
import java.time.DayOfWeek;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author diego
 */
public class Calendar extends javax.swing.JFrame {

    private JFrame parent;
    private User user;
    private String userType;
    private LocalDate sActual;
    private LocalDate eActual;
    
    /**
     * Constructor which creates the GeneralCalendar
     * Frame setting its parent to null.
     */
    public Calendar() {
        this.user = null;
        this.userType = "Disconnected";
        init();
    }
    
    /**
     * Constructor of the GeneralCalendar frame
     * Setting a reference of its parent.
     * @param parent Parent JFrame
     */
    public Calendar(JFrame parent) {
        this.user=null;
        this.userType = "Disconnected";
        init();
        this.parent = parent;
    }
    
     /**
     * Constructor of the GeneralCalendar frame
     * Setting a reference of its parent.
     * @param parent Parent JFrame
     * @param user User who did login
     */
    public Calendar(JFrame parent, User user, String userType) {
        this.user = user;
        this.userType = userType;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        calendarioTable = new javax.swing.JTable();
        previusButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        weekLabel = new javax.swing.JLabel();
        calendarOptions = new javax.swing.JComboBox<>();
        manageAccountsButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        AccountMenu = new javax.swing.JMenu();
        myAccountMenu = new javax.swing.JMenuItem();
        HelpMenu = new javax.swing.JMenuItem();
        LogOutMenu = new javax.swing.JMenuItem();
        EditMenu = new javax.swing.JMenu();
        CreateActivityMenu = new javax.swing.JMenuItem();
        EditActivityMenu = new javax.swing.JMenuItem();
        RemoveActivityMenu = new javax.swing.JMenuItem();
        manageGroupsButton = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        SelectGroupMenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("GPB Calendar Logged as: "+this.user.getUserName()+ " ("+this.userType+")");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(835, 600));
        setResizable(false);

        logOutButton.setText("Log out");
        logOutButton.setFocusable(false);
        logOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutButtonActionPerformed(evt);
            }
        });

        nameLabel.setText("Disconnected");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(logOutButton)
                .addGap(0, 49, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(logOutButton))
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
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        calendarioTable.setMinimumSize(new java.awt.Dimension(600, 384));
        jScrollPane1.setViewportView(calendarioTable);

        previusButton.setText("Previous");
        previusButton.setFocusable(false);
        previusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previusButtonActionPerformed(evt);
            }
        });

        nextButton.setText("Next");
        nextButton.setFocusable(false);
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        weekLabel.setText("Day x to x (modificar)");

        calendarOptions.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "General Calendar", "Personal Calendar" }));
        calendarOptions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calendarOptionsActionPerformed(evt);
            }
        });

        manageAccountsButton.setText("Manage Accounts");
        manageAccountsButton.setFocusable(false);
        manageAccountsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageAccountsButtonActionPerformed(evt);
            }
        });

        AccountMenu.setText("Account");

        myAccountMenu.setText("My Account");
        myAccountMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myAccountMenuActionPerformed(evt);
            }
        });
        AccountMenu.add(myAccountMenu);

        HelpMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        HelpMenu.setText("Help");
        HelpMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HelpMenuActionPerformed(evt);
            }
        });
        AccountMenu.add(HelpMenu);

        LogOutMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_DOWN_MASK));
        LogOutMenu.setText("Log out");
        LogOutMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOutMenuActionPerformed(evt);
            }
        });
        AccountMenu.add(LogOutMenu);

        jMenuBar1.add(AccountMenu);

        EditMenu.setText("Edit");

        CreateActivityMenu.setText("Create Activity");
        CreateActivityMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateActivityMenuActionPerformed(evt);
            }
        });
        EditMenu.add(CreateActivityMenu);

        EditActivityMenu.setText("Edit Activity");
        EditActivityMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditActivityMenuActionPerformed(evt);
            }
        });
        EditMenu.add(EditActivityMenu);

        RemoveActivityMenu.setText("Remove Activity");
        RemoveActivityMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveActivityMenuActionPerformed(evt);
            }
        });
        EditMenu.add(RemoveActivityMenu);

        manageGroupsButton.setText("Manage Groups");
        manageGroupsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageGroupsButtonActionPerformed(evt);
            }
        });
        EditMenu.add(manageGroupsButton);

        jMenuItem1.setText("Select Subjects");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        EditMenu.add(jMenuItem1);

        SelectGroupMenu.setText("Select Groups");
        SelectGroupMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectGroupMenuActionPerformed(evt);
            }
        });
        EditMenu.add(SelectGroupMenu);

        jMenuBar1.add(EditMenu);

        setJMenuBar(jMenuBar1);

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
                        .addComponent(calendarOptions, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(weekLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(manageAccountsButton))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(previusButton)
                            .addComponent(nextButton)
                            .addComponent(calendarOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addComponent(weekLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 10, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(139, 139, 139)
                        .addComponent(manageAccountsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
        calendarioTable.setRowHeight(70);
        java.awt.Toolkit t = java.awt.Toolkit.getDefaultToolkit();
        setIconImage(t.getImage(getClass().getResource("./logo.png")));
        
        //If account type teacher
        if(userType.equals("Teacher")){
            SelectGroupMenu.setEnabled(false);
            SelectGroupMenu.setVisible(false);
            String[] ops = {"General Calendar", "Tutories and Meetings"};
            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>( ops );
            calendarOptions.setModel(model);
        }
        //If account type Student
        if(userType.equals("Student")){
            manageAccountsButton.setEnabled(false);
            manageAccountsButton.setVisible(false);
            manageGroupsButton.setEnabled(false);
            manageGroupsButton.setVisible(false);
        }
        //start week label
        LocalDate today = LocalDate.now( ZoneId.of( "Europe/Madrid" ) );
        LocalDate wMonday = today.with( TemporalAdjusters.previous( DayOfWeek.MONDAY ) );
        LocalDate wSunday = today.with( TemporalAdjusters.next( DayOfWeek.SUNDAY ) );
        this.sActual=wMonday;
        this.eActual=wSunday;
        weekLabel.setText("From: "+sActual+" To: "+eActual);
        
        //Username
        if(user!=null)
            nameLabel.setText(user.getUserName());
        
        setActivities();

    }
    /*EVENTS & ACTIONS*/
        
    /**
     * Method that inits event listeners
     */
    private void initListeners(){
        Calendar frame = this;
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
        
            calendarOptions.addItemListener(new java.awt.event.ItemListener() {
            
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                
                for(int i = 1; i<8; i++){
                    for(int j = 0; j<24; j++){
                        DefaultTableModel model = (DefaultTableModel)calendarioTable.getModel();
                        model.setValueAt("", j, i);
                    }
                }
                setActivities();
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

    private void LogOutMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutMenuActionPerformed
        this.logOutButtonActionPerformed(null);
    }//GEN-LAST:event_LogOutMenuActionPerformed

    private void CreateActivityMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateActivityMenuActionPerformed
        new CreateActivity(this.user, this.userType).setVisible(true);
    }//GEN-LAST:event_CreateActivityMenuActionPerformed

    private void previusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previusButtonActionPerformed
        this.sActual = sActual.minusDays(7);
        this.eActual = eActual.minusDays(7);
        weekLabel.setText("From: "+sActual+" To: "+eActual);
        setActivities();
    }//GEN-LAST:event_previusButtonActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        this.sActual = sActual.plusDays(7);
        this.eActual = eActual.plusDays(7);
        weekLabel.setText("From: "+sActual+" To: "+eActual);
        setActivities();
    }//GEN-LAST:event_nextButtonActionPerformed

    private void HelpMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HelpMenuActionPerformed
        new Help().setVisible(true);
    }//GEN-LAST:event_HelpMenuActionPerformed

    private void manageAccountsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageAccountsButtonActionPerformed
        new ManageAccounts(this.user).setVisible(true);
    }//GEN-LAST:event_manageAccountsButtonActionPerformed

    private void myAccountMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myAccountMenuActionPerformed
        new MyAccount(this.user, this.user).setVisible(true);
    }//GEN-LAST:event_myAccountMenuActionPerformed

    private void manageGroupsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageGroupsButtonActionPerformed
       new ManageGroups(this.user).setVisible(true);
    }//GEN-LAST:event_manageGroupsButtonActionPerformed

    private void EditActivityMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditActivityMenuActionPerformed
        new EditActivity(this.user, this.userType).setVisible(true);
    }//GEN-LAST:event_EditActivityMenuActionPerformed

    private void RemoveActivityMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveActivityMenuActionPerformed
        new RemoveActivity(this.user, this.userType).setVisible(true);
    }//GEN-LAST:event_RemoveActivityMenuActionPerformed

    private void SelectGroupMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectGroupMenuActionPerformed
        new SelectGroups(this.user).setVisible(true);
    }//GEN-LAST:event_SelectGroupMenuActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new SelectSubjects(this.user).setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void calendarOptionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calendarOptionsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_calendarOptionsActionPerformed

    private void setActivities(){
        
        String type = String.valueOf(calendarOptions.getSelectedItem());
        
        
        if(type.equals("General Calendar")){

           ArrayList<Lecture> lectures = listLectures(this.user.getID(), sActual, eActual);
            
            for(Lecture l : lectures){
            
                
                int sHour = l.getStartTime().getHour();
                int eHour = l.getEndTime().getHour();
                int day = (l.getDate().getDayOfWeek().getValue());
            
                DefaultTableModel model = (DefaultTableModel)calendarioTable.getModel();
                for(int i = sHour; i<= eHour; i++){
                    model.setValueAt("Name: "+l.getName()+" Comments: "+l.getComments(), i, day);
                }
            }
            

        }else{
            /*
            if(userType.equals("Student")){
                
                
                //LEER PERSONAL CALENDAR PARA STUDENT this.user.getID()
                //AKA PERSONAL ACTIVITIES Y TUTORSHIPS
                

            
            ArrayList<PersonalActivity> pers=listLectures(this.user.getID());
            ArrayList<Tutorship> tutor= listLectures(this.user.getID());
                
            for(PersonalActivity p : pers){
            
                
                int sHour = p.getStartTime().getHour();
                int eHour = p.getEndTime().getHour();
                int day = p.getDate().getDayOfWeek().getValue()-1;
            
                DefaultTableModel model = (DefaultTableModel)calendarioTable.getModel();
                for(int i = sHour; i<= eHour; i++){
                    model.setValueAt("Name: "+p.getName()+" Comments: "+p.getComments(), i, day);
                }
            }
            
            for(Tutorship t : tutor){                
                int sHour = t.getStartTime().getHour();
                int eHour = t.getEndTime().getHour();
                int day = (t.getDate().getDayOfWeek().getValue())-1;
            
                DefaultTableModel model = (DefaultTableModel)calendarioTable.getModel();
                for(int i = sHour; i<= eHour; i++){
                    model.setValueAt("Name: "+t.getName()+" Comments: "+t.getComments(), i, day);
                }
            }
            

                
            }else{
                
                //LEER PERSONAL CALENDAR PARA TEACHER this.user.getID()
                //AKA TUTORSHIPS Y MEETINGS
                

            
            ArrayList<Meeting> meet = listLectures(this.user.getID());
            ArrayList<Tutorship> tutor= listLectures(this.user.getID());
                
            for(Meeting m : meet){
            
                
                int sHour =  m.getStartTime().getHour();
                int eHour =  m.getEndTime().getHour();
                int day =  (m.getDate().getDayOfWeek().getValue())-1;
            
                DefaultTableModel model = (DefaultTableModel)calendarioTable.getModel();
                for(int i = sHour; i<= eHour; i++){
                    model.setValueAt("Name: "+ m.getName()+" Comments: "+ m.getComments(), i, day);
                }
            }
            
            for(Tutorship t : tutor){                
                int sHour = t.getStartTime().getHour();
                int eHour = t.getEndTime().getHour();
                int day = (t.getDate().getDayOfWeek().getValue())-1;
            
                DefaultTableModel model = (DefaultTableModel)calendarioTable.getModel();
                for(int i = sHour; i<= eHour; i++){
                    model.setValueAt("Name: "+t.getName()+" Comments: "+t.getComments(), i, day);
                }
            }
            
   
            }
            */
            
        }
        
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu AccountMenu;
    private javax.swing.JMenuItem CreateActivityMenu;
    private javax.swing.JMenuItem EditActivityMenu;
    private javax.swing.JMenu EditMenu;
    private javax.swing.JMenuItem HelpMenu;
    private javax.swing.JMenuItem LogOutMenu;
    private javax.swing.JMenuItem RemoveActivityMenu;
    private javax.swing.JMenuItem SelectGroupMenu;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> calendarOptions;
    private javax.swing.JTable calendarioTable;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logOutButton;
    private javax.swing.JButton manageAccountsButton;
    private javax.swing.JMenuItem manageGroupsButton;
    private javax.swing.JMenuItem myAccountMenu;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton nextButton;
    private javax.swing.JButton previusButton;
    private javax.swing.JLabel weekLabel;
    // End of variables declaration//GEN-END:variables
}
