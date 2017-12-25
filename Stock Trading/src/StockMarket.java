
import static java.nio.file.Files.delete;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dell
 */
public class StockMarket extends javax.swing.JFrame {

    Connection conn;
    ResultSet rs;
    PreparedStatement pst;
    
    ResultSet rs2;
    PreparedStatement pst2;
    
    //String b2=null;
    int b2=0;
    /**
     * Creates new form StockMarket
     */
    public class Company{
        public String C_Name;
        public String C_Ticker;
        public String Total_Shares;
        public String Open;
        public String Close;
        public String Type;
        
        public Company(String C_Name,String C_Ticker,String Total_Shares,String Open,String Close,String Type)
        {
            this.C_Name=C_Name;
            this.C_Ticker=C_Ticker;
            this.Total_Shares=Total_Shares;
            this.Open=Open;
            this.Close=Close;
            this.Type=Type;
        }
    }
    
    /*public ArrayList ListCompany(){
        
        ArrayList<Company> list =new ArrayList<Company>();
        conn = javaConnect.ConnecrDb();
        
        String sql = "select * from company";
        try{
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                
               Company c=new Company(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
            list.add(c);
               
            }
             rs.close();
             pst.close();
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }   
        
        return list;
        
    }
    */
    
    public StockMarket() {
        super("Stock Market");
        initComponents();
        DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
        //ArrayList<Company> list=ListCompany();
        
        ArrayList<Company> list =new ArrayList<>();
        conn = javaConnect.ConnecrDb();
        
        String sql = "select * from company";
        try{
            
             
             
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()){
                
               Company c1=new Company(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
               rs.next();
               Company c2=new Company(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
               rs.next();
               Company c3=new Company(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
               rs.next();
               Company c4=new Company(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
               rs.next();
               Company c5=new Company(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
               list.add(c1);
               list.add(c2);
               list.add(c3);
               list.add(c4);
               list.add(c5);
               
               
              
            
            }
             rs.close();
             pst.close();
            
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }   
        
        Object rowData[]=new Object[6];
        for(int i=0;i</*list.size()*/5;i++)
        {
            rowData[0]=list.get(i).C_Name;
            rowData[1]=list.get(i).C_Ticker;
            rowData[2]=list.get(i).Total_Shares;
            rowData[3]=list.get(i).Open;
            rowData[4]=list.get(i).Close;
            rowData[5]=list.get(i).Type;
            model.addRow(rowData);
        }
        
        
        
    }
    
   public StockMarket(String Username)
    {
       super("Stock Market");
        initComponents();
        DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
        
        jLabel1.setText(Username);
        //ArrayList<Company> list=ListCompany();
        
        ArrayList<Company> list =new ArrayList<>();
        conn = javaConnect.ConnecrDb();
        
        String sql = "select * from company";
        try{
            
            String sql2 = "select count(C_Ticker) from Company";
            pst = conn.prepareStatement(sql2);
            rs = pst.executeQuery();
            String a = null;
            if(rs.next()){
                a=rs.getString(1);
            }
            int d=Integer.parseInt(a);
            rs.close();
            pst.close();
            
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                
               /*Company c1=new Company(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
               rs.next();
               Company c2=new Company(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
               rs.next();
               Company c3=new Company(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
               rs.next();
               Company c4=new Company(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
               rs.next();
               Company c5=new Company(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
               list.add(c1);
               list.add(c2);
               list.add(c3);
               list.add(c4); 
               list.add(c5); 
               */
                Company [] c = new Company[d];
               for(int i=0;i<c.length; i++){
                   c[i] = new Company(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
                   rs.next();
               }
               for(int i=0; i<c.length;i++){
                   list.add(c[i]);
               }
            }
            
            
             rs.close();
             pst.close();
            
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }   
        
        Object rowData[]=new Object[6];
        for(int i=0;i<list.size();i++)
        {
            rowData[0]=list.get(i).C_Name;
            rowData[1]=list.get(i).C_Ticker;
            rowData[2]=list.get(i).Total_Shares;
            rowData[3]=list.get(i).Open;
            rowData[4]=list.get(i).Close;
            rowData[5]=list.get(i).Type;
            model.addRow(rowData);
           
        }
        
        
        
    }
   
   public StockMarket(String Username,String bl)
    {
       super("Stock Market");
        initComponents();
        DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
        
        jLabel1.setText(Username);
        b2=Integer.parseInt(bl);
        
        //ArrayList<Company> list=ListCompany();
        
        ArrayList<Company> list =new ArrayList<>();
        conn = javaConnect.ConnecrDb();
        
        String sql = "select * from company";
        try{
            
            String sql2 = "select count(C_Ticker) from Company";
            pst = conn.prepareStatement(sql2);
            rs = pst.executeQuery();
            String a = null;
            if(rs.next()){
                a=rs.getString(1);
            }
            int d=Integer.parseInt(a);
            rs.close();
            pst.close();
            
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                
               /*Company c1=new Company(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
               rs.next();
               Company c2=new Company(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
               rs.next();
               Company c3=new Company(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
               rs.next();
               Company c4=new Company(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
               rs.next();
               Company c5=new Company(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
               list.add(c1);
               list.add(c2);
               list.add(c3);
               list.add(c4); 
               list.add(c5); 
               */
                Company [] c = new Company[d];
               for(int i=0;i<c.length; i++){
                   c[i] = new Company(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
                   rs.next();
               }
               for(int i=0; i<c.length;i++){
                   list.add(c[i]);
               }
            }
            
            
             rs.close();
             pst.close();
            
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }   
        
        Object rowData[]=new Object[6];
        for(int i=0;i<list.size();i++)
        {
            rowData[0]=list.get(i).C_Name;
            rowData[1]=list.get(i).C_Ticker;
            rowData[2]=list.get(i).Total_Shares;
            rowData[3]=list.get(i).Open;
            rowData[4]=list.get(i).Close;
            rowData[5]=list.get(i).Type;
            model.addRow(rowData);
           
        }
        
        
        
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane7 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "C_name", "C_Ticker", "Total Shares", "Open", "Close", "Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
        }

        jButton5.setText("Back");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Click to Buy Stocks");

        jButton1.setText("Search By Type");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "            ", "Software", "Automobile", "Mining", "Banking" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2", "4", "5", " " }));

        jButton2.setText("Sort");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(98, 448, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addGap(159, 159, 159))
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox2, 0, 91, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        if(b2==1)
        {
            setVisible(false);
            AdminHome ob=new AdminHome(jLabel1.getText());
            ob.setVisible(true);
        }
        else if(b2==0)
        {
            setVisible(false);
            Home ob=new Home(jLabel1.getText());
            ob.setVisible(true);
        }
       
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        if(b2!=1)
        {
        String Table_click = null;
        try{
            int row = jTable1.getSelectedRow();
            Table_click = (jTable1.getModel().getValueAt(row, 1).toString());
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        setVisible(false);
        BuyStocks buy = new BuyStocks(jLabel1.getText(), Table_click);
        buy.setVisible(true);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Admin Cannot Buy Stocks");
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        ArrayList<Company> list = new ArrayList<>();
        DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
        
        int rows = jTable1.getRowCount();
        
        model.setRowCount(0);
        
        /*for(int j=1;j<=rows;j++)
        {
            model.removeRow(j);
        }   */    
        
        conn = javaConnect.ConnecrDb();
        String Combo=(String) jComboBox1.getSelectedItem();
        String sql = "select * from company where Type='"+Combo+"'";
        try{
            
            String sql2 = "select count(C_Ticker) from (select * from company where Type='"+Combo+"')  as tt1";
            pst = conn.prepareStatement(sql2);
            rs = pst.executeQuery();
            String a = null;
            if(rs.next()){
                a=rs.getString(1);
            }
            int d=Integer.parseInt(a);
            rs.close();
            pst.close();
            
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){               
        
                Company [] c = new Company[d];
               for(int i=0;i<c.length; i++){
                   c[i] = new Company(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
                   rs.next();
               }
               for(int i=0; i<c.length;i++){
                   list.add(c[i]);
               }
            }
            
            
             rs.close();
             pst.close();
            
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }   
        
        Object rowData[]=new Object[6];
        for(int i=0;i<list.size();i++)
        {
            rowData[0]=list.get(i).C_Name;
            rowData[1]=list.get(i).C_Ticker;
            rowData[2]=list.get(i).Total_Shares;
            rowData[3]=list.get(i).Open;
            rowData[4]=list.get(i).Close;
            rowData[5]=list.get(i).Type;
            model.addRow(rowData);
           
        }
        
        
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        ArrayList<Company> list = new ArrayList<>();
        DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
        
        int rows = jTable1.getRowCount();
        
        model.setRowCount(0);
        
        /*for(int j=1;j<=rows;j++)
        {
            model.removeRow(j);
        }   */    
        
        conn = javaConnect.ConnecrDb();
        String Combo=(String) jComboBox2.getSelectedItem();
        
        int b=Integer.parseInt(Combo);
        String sql=null;
        //String sql = "select * from company order by '"+Combo+"'";
        switch(b)
        {
            case 4:
                 sql="select * from company order by Open";
                 break;
            case 5:
                 sql="select * from company order by Close";
                 break;
            case 2:
                 sql="select * from company order by C_Ticker";
                 break;
        }
        try{
            
            String sql2 = "select count(C_Ticker) from  company";
            pst = conn.prepareStatement(sql2);
            rs = pst.executeQuery();
            String a = null;
            if(rs.next()){
                a=rs.getString(1);
            }
            int d=Integer.parseInt(a);
            rs.close();
            pst.close();
            
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){               
        
                Company [] c = new Company[d];
               for(int i=0;i<c.length; i++){
                   c[i] = new Company(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
                   rs.next();
               }
               for(int i=0; i<c.length;i++){
                   list.add(c[i]);
               }
            }
            
            
             rs.close();
             pst.close();
            
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }   
        
        Object rowData[]=new Object[6];
        for(int i=0;i<list.size();i++)
        {
            rowData[0]=list.get(i).C_Name;
            rowData[1]=list.get(i).C_Ticker;
            rowData[2]=list.get(i).Total_Shares;
            rowData[3]=list.get(i).Open;
            rowData[4]=list.get(i).Close;
            rowData[5]=list.get(i).Type;
            model.addRow(rowData);
           
        }
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StockMarket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StockMarket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StockMarket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StockMarket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StockMarket().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
