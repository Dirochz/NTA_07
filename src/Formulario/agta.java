package Formulario;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.YES_NO_CANCEL_OPTION;
import javax.swing.filechooser.FileNameExtensionFilter;
import nta_07.Conexion;

public final class agta extends javax.swing.JInternalFrame {
    int resp,canti;
    Double pree;
    public agta() {
        initComponents();
        setTitle("Agregar Tazas");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cant = new javax.swing.JSpinner();
        txt_nom = new javax.swing.JTextField();
        pre = new javax.swing.JSpinner();
        Precio = new javax.swing.JLabel();
        Cantidad = new javax.swing.JLabel();
        Nombre = new javax.swing.JLabel();
        img = new javax.swing.JLabel();
        Precio1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Txt_de = new javax.swing.JTextArea();
        txt_ag = new javax.swing.JTextField();
        bo_ing = new javax.swing.JButton();
        bo_ag1 = new javax.swing.JButton();
        Fondo = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Agregar Tazas");

        jPanel1.setBackground(new java.awt.Color(34, 194, 194));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cant.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        cant.setModel(new javax.swing.SpinnerNumberModel());
        jPanel1.add(cant, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 140, 30));

        txt_nom.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        jPanel1.add(txt_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 150, 40));

        pre.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        pre.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 0.05d));
        jPanel1.add(pre, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, 140, 30));

        Precio.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        Precio.setForeground(new java.awt.Color(255, 255, 255));
        Precio.setText("Precio:");
        jPanel1.add(Precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        Cantidad.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        Cantidad.setForeground(new java.awt.Color(255, 255, 255));
        Cantidad.setText("Cantidad:");
        jPanel1.add(Cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        Nombre.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        Nombre.setForeground(new java.awt.Color(255, 255, 255));
        Nombre.setText("Nombre:");
        jPanel1.add(Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        img.setBorder(null);
        jPanel1.add(img, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 190, 190));

        Precio1.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        Precio1.setForeground(new java.awt.Color(255, 255, 255));
        Precio1.setText("Descripcion:");
        jPanel1.add(Precio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));

        Txt_de.setColumns(20);
        Txt_de.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        Txt_de.setRows(5);
        jScrollPane1.setViewportView(Txt_de);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 420, 100));

        txt_ag.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        jPanel1.add(txt_ag, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, 180, 40));

        bo_ing.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        bo_ing.setForeground(new java.awt.Color(0, 0, 0));
        bo_ing.setText("Ingresar");
        bo_ing.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bo_ing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bo_ingActionPerformed(evt);
            }
        });
        jPanel1.add(bo_ing, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 260, -1, -1));

        bo_ag1.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        bo_ag1.setForeground(new java.awt.Color(0, 0, 0));
        bo_ag1.setText("Agregar");
        bo_ag1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bo_ag1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bo_ag1ActionPerformed(evt);
            }
        });
        jPanel1.add(bo_ag1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 480, -1, -1));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agta.png"))); // NOI18N
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

    private void bo_ingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bo_ingActionPerformed
        File archivo;
        JFileChooser flcAbrirArchivo = new JFileChooser();
        flcAbrirArchivo.setFileFilter(new FileNameExtensionFilter("Archivo de imagen","jpg","jpeg","png"));
        int respuesta=flcAbrirArchivo.showOpenDialog(this);

        if(respuesta == JFileChooser.APPROVE_OPTION){
            archivo = flcAbrirArchivo.getSelectedFile();
            txt_ag.setText(archivo.getAbsolutePath());
            Image foto = Toolkit.getDefaultToolkit().getImage(txt_ag.getText());
            foto = foto.getScaledInstance(190,190, 1);
            img.setIcon(new ImageIcon(foto));
        }
    }//GEN-LAST:event_bo_ingActionPerformed

    private void bo_ag1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bo_ag1ActionPerformed
        FileInputStream archivoFoto;
        String nom = txt_nom.getText().trim();
        String pr = pre.getValue().toString();
        String ca = cant.getValue().toString();
        String n = txt_ag.getText().trim();
        String d = Txt_de.getText().trim();
        String tipo = "Taza";
        String talla = "N/A";
        try{
            if(!nom.equals("") && !pr.equals("0") && !ca.equals("0")&& !n.equals("")){
                resp = JOptionPane.showConfirmDialog(null,"¿Quieres agregar otro Producto?","Producto",YES_NO_CANCEL_OPTION,INFORMATION_MESSAGE,null);
                pree = (double) pre.getValue();
                canti = (int) cant.getValue();

                if(resp==0){
                    Connection cn = Conexion.conectar();
                    PreparedStatement pst = cn.prepareStatement("insert into producto values(?,?,?,?,?,?,?,?)");
                    archivoFoto = new FileInputStream(txt_ag.getText());
                    pst.setInt(1, 0);
                    pst.setString(2, nom);
                    pst.setString(3, tipo);
                    pst.setString(4, talla);
                    pst.setInt(5, canti);
                    pst.setDouble(6, pree);
                    pst.setString(7, d);
                    pst.setBinaryStream(8, archivoFoto);
                    pst.executeUpdate();

                    ImageIcon wall = new ImageIcon("src\\img\\Menu.png");
                    Icon icono = new ImageIcon (wall.getImage().getScaledInstance(img.getWidth(), img.getHeight(),Image.SCALE_DEFAULT));
                    img.setIcon(icono);
                    txt_nom.setText("");
                    pre.setValue(0);
                    cant.setValue(0);
                    Txt_de.setText("");
                    txt_ag.setText("");
                }
                else if(resp==1){
                    Connection cn = Conexion.conectar();
                    PreparedStatement pst = cn.prepareStatement("insert into producto values(?,?,?,?,?,?,?,?)");
                    archivoFoto = new FileInputStream(txt_ag.getText());
                    pst.setInt(1, 0);
                    pst.setString(2, nom);
                    pst.setString(3, tipo);
                    pst.setString(4, talla);
                    pst.setInt(5, canti);
                    pst.setDouble(6, pree);
                    pst.setString(7, d);
                    pst.setBinaryStream(8, archivoFoto);
                    pst.executeUpdate();
                    this.setVisible(false);
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"Debes llenar todos los campos");
            }
        }catch(HeadlessException | FileNotFoundException | SQLException e){
            System.out.println("Error en el try " + e);
        }
    }//GEN-LAST:event_bo_ag1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cantidad;
    private javax.swing.JLabel Fondo;
    private javax.swing.JLabel Nombre;
    private javax.swing.JLabel Precio;
    private javax.swing.JLabel Precio1;
    private javax.swing.JTextArea Txt_de;
    private javax.swing.JButton bo_ag1;
    private javax.swing.JButton bo_ing;
    private javax.swing.JSpinner cant;
    private javax.swing.JLabel img;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner pre;
    private javax.swing.JTextField txt_ag;
    private javax.swing.JTextField txt_nom;
    // End of variables declaration//GEN-END:variables
}
