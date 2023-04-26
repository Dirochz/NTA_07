package Formulario;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import nta_07.Conexion;

public final class Login extends javax.swing.JFrame {
    public static String nick = "";
    String pass = "";
    public static int id_us = 0;
    public Login() {
        initComponents();
        setTitle("Login");
        this.setLocationRelativeTo(null);
        setIconImage(getIconImage());
    }
    
    @Override 
    public Image getIconImage(){ 
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("img/logo.png"));
        return retValue;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Login = new javax.swing.JLabel();
        Usuario = new javax.swing.JLabel();
        txt_us = new javax.swing.JTextField();
        Contraseña = new javax.swing.JLabel();
        txt_con = new javax.swing.JPasswordField();
        Ingresar = new javax.swing.JButton();
        diseño = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(34, 194, 194));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Login.setFont(new java.awt.Font("Comic Sans MS", 0, 48)); // NOI18N
        Login.setForeground(new java.awt.Color(255, 255, 255));
        Login.setText("Iniciar Sesión");
        jPanel1.add(Login, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        Usuario.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        Usuario.setForeground(new java.awt.Color(255, 255, 255));
        Usuario.setText("Usuario:");
        jPanel1.add(Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, -1, -1));

        txt_us.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        jPanel1.add(txt_us, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 158, 40));

        Contraseña.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        Contraseña.setForeground(new java.awt.Color(255, 255, 255));
        Contraseña.setText("Contraseña:");
        jPanel1.add(Contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, -1, -1));

        txt_con.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        txt_con.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_conActionPerformed(evt);
            }
        });
        txt_con.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_conKeyReleased(evt);
            }
        });
        jPanel1.add(txt_con, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, 158, 40));

        Ingresar.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        Ingresar.setForeground(new java.awt.Color(0, 0, 0));
        Ingresar.setText("Ingresar");
        Ingresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IngresarActionPerformed(evt);
            }
        });
        Ingresar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                IngresarKeyReleased(evt);
            }
        });
        jPanel1.add(Ingresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 450, 110, 40));

        diseño.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/diseño.png"))); // NOI18N
        jPanel1.add(diseño, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_conKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_conKeyReleased
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            nick = txt_us.getText().trim();
            pass = txt_con.getText().trim();
            if(!nick.equals("") || !pass.equals("")){
                try{
                    Connection cn = Conexion.conectar();             
                    PreparedStatement pst = cn.prepareStatement("Select ID from usuario where Nick ='"+nick+"'and Cont ='"+pass+"'");
                    ResultSet rs = pst.executeQuery();
                    if(rs.next()){
                        id_us = rs.getInt("ID");
                        dispose();
                        new Menu().setVisible(true);
                    }
                else{
                    JOptionPane.showMessageDialog(null,"Datos Incorrectos\nIntentelo de nuevo");
                    txt_us.setText("");
                    txt_con.setText("");
                }
                }catch (SQLException e){
                    System.out.println("Error a" + e);
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"Debes llenar todos los campos");
            }
        }
    }//GEN-LAST:event_txt_conKeyReleased

    private void IngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IngresarActionPerformed
      nick = txt_us.getText().trim();
        pass = txt_con.getText().trim();
        if(!nick.equals("") || !pass.equals("")){
            try{
                Connection c = Conexion.conectar();
                PreparedStatement pst = c.prepareStatement("select ID from usuario where Nick ='"+nick+"'and Cont ='"+pass+"'");
                ResultSet rs = pst.executeQuery();
                if(rs.next()){
                    dispose();
                    new Menu().setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Datos Incorrectos\nIntentelo de nuevo");
                    txt_us.setText("");
                    txt_con.setText("");
                }
            }catch (SQLException e){
                System.out.println("Error");
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"Debes llenar todos los campos");
        }  
    }//GEN-LAST:event_IngresarActionPerformed

    private void IngresarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_IngresarKeyReleased
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            nick = txt_us.getText().trim();
            pass = txt_con.getText().trim();
            if(!nick.equals("") || !pass.equals("")){
                try{
                    Connection cn = Conexion.conectar();             
                    PreparedStatement pst = cn.prepareStatement("Select ID from usuario where Nick ='"+nick+"'and Cont ='"+pass+"'");
                    ResultSet rs = pst.executeQuery();
                    if(rs.next()){
                        id_us = rs.getInt("ID");
                        dispose();
                        new Menu().setVisible(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Datos Incorrectos\nIntentelo de nuevo");
                        txt_us.setText("");
                        txt_con.setText("");
                    }
                }catch (SQLException e){
                    System.out.println("Error b" + e);
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"Debes llenar todos los campos");
            }
        }
    }//GEN-LAST:event_IngresarKeyReleased

    private void txt_conActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_conActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_conActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Contraseña;
    private javax.swing.JButton Ingresar;
    private javax.swing.JLabel Login;
    private javax.swing.JLabel Usuario;
    private javax.swing.JLabel diseño;
    private static javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txt_con;
    private javax.swing.JTextField txt_us;
    // End of variables declaration//GEN-END:variables
}
