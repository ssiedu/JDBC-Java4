
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pro
 */
public class DataViewer extends java.awt.Frame {

    /**
     * Creates new form DataViewer
     */
    public DataViewer() {
        initComponents();
        setSize(500,500);
        try{
            Connection con=Util.connect();
            DatabaseMetaData dbmd=con.getMetaData();
            ResultSet rs=dbmd.getTables(null, null, null, null);
            while(rs.next()){
            String name=rs.getString("TABLE_NAME");
            ch.add(name);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ch = new java.awt.Choice();
        label1 = new java.awt.Label();
        textArea1 = new java.awt.TextArea();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });
        setLayout(null);

        ch.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chItemStateChanged(evt);
            }
        });
        add(ch);
        ch.setBounds(180, 80, 180, 20);

        label1.setText("Select Table");
        add(label1);
        label1.setBounds(80, 80, 70, 20);
        add(textArea1);
        textArea1.setBounds(30, 120, 440, 280);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Exit the Application
     */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm

    private void chItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chItemStateChanged
        String tname=ch.getSelectedItem();
        String sql="select * from "+tname;
        try{
        Connection con=Util.connect();
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery(sql);
        ResultSetMetaData rsmd=rs.getMetaData();
        int n=rsmd.getColumnCount();
        String res="";
        while(rs.next()){
            for(int i=1; i<=n; i++){
                res=res+rs.getString(i)+"\t";
            }
            res=res+"\n";
        }
        textArea1.setText(res);
        }catch(Exception e){
            e.printStackTrace();
        }

        
        
    }//GEN-LAST:event_chItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataViewer().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Choice ch;
    private java.awt.Label label1;
    private java.awt.TextArea textArea1;
    // End of variables declaration//GEN-END:variables
}
