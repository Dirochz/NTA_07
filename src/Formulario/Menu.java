package Formulario;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import nta_07.Conexion;

public final class Menu extends javax.swing.JFrame {
    int resp=1, Bus=0,respc=0;
    String nom,user,Nombre,Appa,Apma;
    public Menu() {
        initComponents();
        setTitle("Menu");
        user = Login.nick;
        checar();
        this.setLocationRelativeTo(null);
        setIconImage(getIconImage());
    }
    
    void checar(){
        try{       
            Connection cn = Conexion.conectar();
            String query;
            query = "select Nom from producto Where Can='"+Bus+"'";
            PreparedStatement pst = cn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){         
                nom = rs.getString("Nom");
                JOptionPane.showMessageDialog(null, "El Producto: "+nom+"\nYa no hay en el Inventario");
            }             
        }catch(SQLException e){            
            System.out.println("Error en verificar el producto: " + e);
        }
    }
    
    @Override 
    public Image getIconImage(){ 
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("img/logo.png"));
        return retValue;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        Us = new javax.swing.JMenu();
        mu = new javax.swing.JMenuItem();
        au = new javax.swing.JMenuItem();
        Pro = new javax.swing.JMenu();
        mp = new javax.swing.JMenuItem();
        ap = new javax.swing.JMenuItem();
        at = new javax.swing.JMenuItem();
        Re = new javax.swing.JMenu();
        mr = new javax.swing.JMenuItem();
        tic = new javax.swing.JMenu();
        gt = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        escritorio.setBackground(new java.awt.Color(0, 153, 153));
        escritorio.setToolTipText("");

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1261, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 613, Short.MAX_VALUE)
        );

        Us.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Usuario.png"))); // NOI18N
        Us.setText("Usuario");
        Us.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Us.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N

        mu.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        mu.setText("Menu Usuario");
        mu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                muActionPerformed(evt);
            }
        });
        Us.add(mu);

        au.setText("Agregar Usuario");
        au.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        au.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                auActionPerformed(evt);
            }
        });
        Us.add(au);

        jMenuBar1.add(Us);

        Pro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/inventario.png"))); // NOI18N
        Pro.setText("Productos");
        Pro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Pro.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N

        mp.setText("Menu Productos");
        mp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mpActionPerformed(evt);
            }
        });
        Pro.add(mp);

        ap.setText("Agregar Ropa");
        ap.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apActionPerformed(evt);
            }
        });
        Pro.add(ap);

        at.setText("Agregar Tazas");
        at.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atActionPerformed(evt);
            }
        });
        Pro.add(at);

        jMenuBar1.add(Pro);

        Re.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Reportes.png"))); // NOI18N
        Re.setText("Reportes");
        Re.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Re.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N

        mr.setText("Reportes");
        mr.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mrActionPerformed(evt);
            }
        });
        Re.add(mr);

        jMenuBar1.add(Re);

        tic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Ticket.png"))); // NOI18N
        tic.setText("Ticket");
        tic.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tic.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N

        gt.setText("Generar Ticket");
        gt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        gt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gtActionPerformed(evt);
            }
        });
        tic.add(gt);

        jMenuBar1.add(tic);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void muActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_muActionPerformed
        Usuario u = new Usuario();
        escritorio.add(u);
        u.setVisible(true);
    }//GEN-LAST:event_muActionPerformed

    private void auActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_auActionPerformed
        Agus u = new Agus();
        escritorio.add(u);
        u.setVisible(true);
    }//GEN-LAST:event_auActionPerformed

    private void mpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mpActionPerformed
        Productos u = new Productos();
        escritorio.add(u);
        u.setVisible(true);
    }//GEN-LAST:event_mpActionPerformed

    private void apActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apActionPerformed
        agro u = new agro();
        escritorio.add(u);
        u.setVisible(true);
    }//GEN-LAST:event_apActionPerformed

    private void mrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mrActionPerformed
        Reporte u = new Reporte();
        escritorio.add(u);
        u.setVisible(true);
    }//GEN-LAST:event_mrActionPerformed

    private void gtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gtActionPerformed
        Ticket u = new Ticket();
        escritorio.add(u);
        u.setVisible(true);
    }//GEN-LAST:event_gtActionPerformed

    private void atActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atActionPerformed
        agta u = new agta();
        escritorio.add(u);
        u.setVisible(true);
    }//GEN-LAST:event_atActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Pro;
    private javax.swing.JMenu Re;
    private javax.swing.JMenu Us;
    private javax.swing.JMenuItem ap;
    private javax.swing.JMenuItem at;
    private javax.swing.JMenuItem au;
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenuItem gt;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem mp;
    private javax.swing.JMenuItem mr;
    private javax.swing.JMenuItem mu;
    private javax.swing.JMenu tic;
    // End of variables declaration//GEN-END:variables

    private Usuario Usuario() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
