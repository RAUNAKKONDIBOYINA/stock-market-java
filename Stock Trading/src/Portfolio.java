
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
 * @author dell
 */
public class Portfolio extends javax.swing.JFrame {

    public class port{
        public String C_Ticker;
        public String Shares_Bought;
        public String Profit_Loss;
        public String Price_Share;
        public String C_Name;
        
        
        public port(String C_Ticker,String Shares_Bought,String Profit_Loss,String Price_Share,String C_Name)
        {
            this.C_Ticker=C_Ticker;
            this.Shares_Bought=Shares_Bought;
            this.Profit_Loss=Profit_Loss;
            this.Price_Share=Price_Share;
            this.C_Name=C_Name;
           
        }
    }
    
    Connection conn;
    ResultSet rs;
    PreparedStatement pst;
    /**
     * Creates new form Portfolio
     */
    public Portfolio() {
        initComponents();
        conn = javaConnect.ConnecrDb();
    }
     public Portfolio(String g) {
        initComponents();
        conn = javaConnect.ConnecrDb();
        jLabel1.setText(g);
        
        DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
        //ArrayList<Company> list=ListCompany();
        
        ArrayList<port> list =new ArrayList<>();
        conn = javaConnect.ConnecrDb();
        String Buy_Sell="B";
        String f=jLabel1.getText();
        
       /* String sql = "select portfolio1.Total_Shares,portfolio1.Profit_Loss,tt.C_Name,tt.C_Ticker,transaction_h.price_Share from\n" +
"(select company.C_Name,transaction_h.C_Ticker from transaction_h,company where\n" +
"transaction_h.C_Ticker= company.C_Ticker and transaction_h.Buy_Sell='B' and transaction_h.username='"+Username+"') as tt,\n" +
"portfolio1,transaction_h where transaction_h.username='"+Username+"' and transaction_h.Buy_Sell='B' and tt.C_Ticker=transaction_h.C_ticker";*/
       String sql="select tt.C_Ticker,tt.Total_Shares,tt.Profit_Loss,tt.Price_Share,company.C_Name from(select transaction_h.C_Ticker,portfolio1.Total_Shares,Profit_Loss,Price_Share from portfolio1 inner join transaction_h on portfolio1.C_Ticker=transaction_h.C_Ticker and portfolio1.username=transaction_h.username and transaction_h.username='"+f+"' and transaction_h.Buy_Sell='B' and portfolio1.Total_Shares is not null) as tt,company where tt.C_Ticker=company.C_Ticker";
        try{
            
             String sql7="Select open from company where  ";
             
            String sql2 = "select count(Username) from portfolio1 where Username='"+f+"' and Total_Shares is not null";
            pst = conn.prepareStatement(sql2);
            rs = pst.executeQuery();
            String a = null;
            if(rs.next()){
                a=rs.getString(1);
            }
            jTextField1.setText(a);
            int d=Integer.parseInt(a);
            rs.close();
            pst.close();
            
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
               
                port [] c = new port[d];
               for(int i=0;i<c.length; i++){
                   c[i] = new port(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
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
        
        Object rowData[]=new Object[5];
        for(int i=0;i<list.size();i++)
        {
            rowData[0]=list.get(i).C_Ticker;
            rowData[1]=list.get(i).Shares_Bought;
            rowData[2]=list.get(i).Profit_Loss;
            rowData[3]=list.get(i).Price_Share;
            rowData[4]=list.get(i).C_Name;
            
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Sell");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "C_Ticker", "Shares_Bought", "Profit/Los", "Price_Share", "C_Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
        }

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Number Of Portfolios");

        jButton2.setText("Back");
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
                .addGap(233, 233, 233)
                .addComponent(jLabel2)
                .addGap(36, 36, 36)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(56, 56, 56))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(41, 41, 41))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69))))
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(84, 84, 84)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jButton2)
                .addGap(46, 46, 46))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        setVisible(false);
        Home ob=new Home(jLabel1.getText());
        ob.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        SellStock ob=new SellStock(jLabel1.getText());
        ob.setVisible(true);
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        
        //here
        /*String Table_click = null;
        try{
            int row = jTable1.getSelectedRow();
            Table_click = (jTable1.getModel().getValueAt(row, 1).toString());
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        setVisible(false);
        SellStock ob = new SellStock(jLabel1.getText(), Table_click);
        ob.setVisible(true);
        }*/
    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(Portfolio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Portfolio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Portfolio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Portfolio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Portfolio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
