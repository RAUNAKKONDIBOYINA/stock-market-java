
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
public class Transactions extends javax.swing.JFrame {

     Connection conn;
    ResultSet rs;
    PreparedStatement pst;
    
    ResultSet rs2;
    PreparedStatement pst2;
    
    public class Company{
        public String T_id;
        public String C_Ticker;
        public String Buy_Sell;
        public String price_Share;
        public String Total_Share;
        public String Date;
        
        public Company(String T_id,String C_Ticker,String Buy_Sell,String price_Share,String Total_Share,String Date)
        {
            this.T_id=T_id;
            this.C_Ticker=C_Ticker;
            this.Buy_Sell=Buy_Sell;
            this.price_Share=price_Share;
            this.Total_Share=Total_Share;
            this.Date=Date;
        }
    }
    /**
     * Creates new form Transactions
     */
    public Transactions() {
        initComponents();
    }
    
    public Transactions(String Username) {
        super("Transactions");
        initComponents();
        jLabel1.setText(Username);
        
         DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
        
        jLabel1.setText(Username);
        //ArrayList<Company> list=ListCompany();
        
        ArrayList<Company> list =new ArrayList<>();
        conn = javaConnect.ConnecrDb();
        String U=jLabel1.getText();
        String sql = "select T_id,C_Ticker,Buy_Sell,price_Share,Total_Shares,Date from transaction_h where username='"+U+"'";
        try{
            
            String sql2 = "select count(C_Ticker) from transaction_h where username='"+U+"'";
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
            rowData[0]=list.get(i).T_id;
            rowData[1]=list.get(i).C_Ticker;
            rowData[2]=list.get(i).Buy_Sell;
            rowData[3]=list.get(i).price_Share;
            rowData[4]=list.get(i).Total_Share;
            rowData[5]=list.get(i).Date;
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

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "T_id", "C_Ticker", "But_Sell", "Price_Share", "Total_Shares", "Date"
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(43, 43, 43))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(43, 43, 43))
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
            java.util.logging.Logger.getLogger(Transactions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transactions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transactions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transactions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transactions().setVisible(true);
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
