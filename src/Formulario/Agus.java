package Formulario;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.YES_NO_CANCEL_OPTION;
import nta_07.Conexion;

public final class Agus extends javax.swing.JInternalFrame {
    int resp;
    public Agus() {
        initComponents();
        setTitle("Agregar Usuario");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Apellidopa = new javax.swing.JLabel();
        txt_appa = new javax.swing.JTextField();
        ApellidoMA = new javax.swing.JLabel();
        txt_apma = new javax.swing.JTextField();
        correo = new javax.swing.JLabel();
        txt_cor = new javax.swing.JTextField();
        nickname = new javax.swing.JLabel();
        txt_nick = new javax.swing.JTextField();
        Contraseña = new javax.swing.JLabel();
        txt_con = new javax.swing.JPasswordField();
        bo_ag = new javax.swing.JButton();
        nombre = new javax.swing.JLabel();
        txt_nom = new javax.swing.JTextField();
        Fondo = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Agregar Usuario");

        jPanel1.setBackground(new java.awt.Color(34, 194, 194));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Apellidopa.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        Apellidopa.setText("Apellido Paterno:");
        jPanel1.add(Apellidopa, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        txt_appa.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        txt_appa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_appaActionPerformed(evt);
            }
        });
        jPanel1.add(txt_appa, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 190, 40));

        ApellidoMA.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        ApellidoMA.setText("Apellido Materno:");
        jPanel1.add(ApellidoMA, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        txt_apma.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        txt_apma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_apmaActionPerformed(evt);
            }
        });
        jPanel1.add(txt_apma, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 190, 40));

        correo.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        correo.setText("Correo:");
        jPanel1.add(correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        txt_cor.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        txt_cor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_corActionPerformed(evt);
            }
        });
        jPanel1.add(txt_cor, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, 350, 40));

        nickname.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        nickname.setText("Nickname:");
        jPanel1.add(nickname, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, -1));

        txt_nick.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        txt_nick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nickActionPerformed(evt);
            }
        });
        jPanel1.add(txt_nick, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 190, 40));

        Contraseña.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        Contraseña.setText("Contraseña:");
        jPanel1.add(Contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, -1, -1));

        txt_con.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        jPanel1.add(txt_con, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 410, 180, 40));

        bo_ag.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        bo_ag.setForeground(new java.awt.Color(0, 0, 0));
        bo_ag.setText("Agregar");
        bo_ag.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bo_ag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bo_agActionPerformed(evt);
            }
        });
        jPanel1.add(bo_ag, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 490, -1, -1));

        nombre.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        nombre.setText("Nombre:");
        jPanel1.add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        txt_nom.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        txt_nom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nomActionPerformed(evt);
            }
        });
        jPanel1.add(txt_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 190, 40));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agus.png"))); // NOI18N
        jPanel1.add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bo_agActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bo_agActionPerformed
        String nom = txt_nom.getText().trim();
        String appa = txt_appa.getText().trim();
        String apma = txt_apma.getText().trim();
        String cor = txt_cor.getText().trim();
        String con = txt_con.getText().trim();
        String nic = txt_nick.getText().trim();
        try{
            if(!nom.equals("") && !appa.equals("") && !apma.equals("") && !cor.equals("") && !con.equals("") && !nic.equals("")){
                resp = JOptionPane.showConfirmDialog(null,"¿Quieres Agregar Otro Usuario?","Usuario",YES_NO_CANCEL_OPTION,INFORMATION_MESSAGE,null);
                if(resp==0){
                    Connection cn = Conexion.conectar();
                    PreparedStatement pst = cn.prepareStatement("insert into usuario values(?,?,?,?,?,?,?)");
                    pst.setString(1, "0");
                    pst.setString(2, nom);
                    pst.setString(3, appa);
                    pst.setString(4, apma);
                    pst.setString(5, cor);
                    pst.setString(6, nic);
                    pst.setString(7, con);
                    pst.executeUpdate();
                    
                    txt_nom.setText("");
                    txt_appa.setText("");
                    txt_apma.setText("");
                    txt_cor.setText("");
                    txt_nick.setText("");
                    txt_con.setText("");
                }
                else if(resp==1){
                    Connection cn = Conexion.conectar();
                    PreparedStatement pst = cn.prepareStatement("insert into usuario values(?,?,?,?,?,?,?)");
                    pst.setString(1, "0");
                    pst.setString(2, nom);
                    pst.setString(3, appa);
                    pst.setString(4, apma);
                    pst.setString(5, cor);
                    pst.setString(6, nic);
                    pst.setString(7, con);
                    pst.executeUpdate();
                    this.setVisible(false);
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"Debes llenar todos los campos");
            }
        }catch (HeadlessException | SQLException e){      
        }
    }//GEN-LAST:event_bo_agActionPerformed

    private void txt_nomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nomActionPerformed

    private void txt_appaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_appaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_appaActionPerformed

    private void txt_apmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_apmaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_apmaActionPerformed

    private void txt_corActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_corActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_corActionPerformed

    private void txt_nickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nickActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nickActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ApellidoMA;
    private javax.swing.JLabel Apellidopa;
    private javax.swing.JLabel Contraseña;
    private javax.swing.JLabel Fondo;
    private javax.swing.JButton bo_ag;
    private javax.swing.JLabel correo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nickname;
    private javax.swing.JLabel nombre;
    private javax.swing.JTextField txt_apma;
    private javax.swing.JTextField txt_appa;
    private javax.swing.JPasswordField txt_con;
    private javax.swing.JTextField txt_cor;
    private javax.swing.JTextField txt_nick;
    private javax.swing.JTextField txt_nom;
    // End of variables declaration//GEN-END:variables
}
