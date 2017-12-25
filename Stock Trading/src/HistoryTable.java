
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author len0vo500
 */
public class HistoryTable extends javax.swing.JFrame {

     Connection conn;
    ResultSet rs;
    PreparedStatement pst;
    
    ResultSet rs2;
    PreparedStatement pst2;
    
    public class Company{
        public String C_Ticker;
        public String open;
        public String close;
        public String high;
        public String low;
        public String date;
        
        public Company(String C_Ticker,String open,String close,String high,String low,String date)
        {
            this.C_Ticker=C_Ticker;
            this.open=open;
            this.close=close;
            this.high=high;
            this.low=low;
            this.date=date;
        }
    }
    /**
     * Creates new form HistoryTable
     */
    public HistoryTable() {
        initComponents();
        
         DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
        
        //jLabel1.setText(Username);
        //ArrayList<Company> list=ListCompany();
        
        ArrayList<Company> list =new ArrayList<>();
        conn = javaConnect.ConnecrDb();
        
        String sql = "select * from history_table";
        try{
            
            String sql2 = "select count(C_Ticker) from history_table";
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
            rowData[0]=list.get(i).C_Ticker;
            rowData[1]=list.get(i).open;
            rowData[2]=list.get(i).close;
            rowData[3]=list.get(i).high;
            rowData[4]=list.get(i).low;
            rowData[5]=list.get(i).date;
            model.addRow(rowData);
           
        }
    }
    public HistoryTable(String Username) {
        super("History Tables");
        initComponents();
        jLabel1.setText(Username);
         DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
        
        //jLabel1.setText(Username);
        //ArrayList<Company> list=ListCompany();
        
        ArrayList<Company> list =new ArrayList<>();
        conn = javaConnect.ConnecrDb();
        
        String sql = "select * from history_table";
        try{
            
            String sql2 = "select count(C_Ticker) from history_table";
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
            rowData[0]=list.get(i).C_Ticker;
            rowData[1]=list.get(i).open;
            rowData[2]=list.get(i).close;
            rowData[3]=list.get(i).high;
            rowData[4]=list.get(i).low;
            rowData[5]=list.get(i).date;
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "C_Ticker", "open", "close", "high", "low", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(62, 62, 62)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(48, 48, 48)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(53, 53, 53))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        Home ob=new Home(jLabel1.getText());
        ob.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(HistoryTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HistoryTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HistoryTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HistoryTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HistoryTable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
