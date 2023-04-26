package Formulario;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import nta_07.Conexion;

public final class Reporte extends javax.swing.JInternalFrame {
    int resp;
    public Reporte() {
        initComponents();
        masV();
    }
    
    void masV(){
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("SELECT d.ID_Pro PRODUCTO, P.Nom NOMBRE, SUM(d.Cant) CANTIDAD, P.Dis IMAGEN FROM d_pedido D INNER JOIN producto P ON D.ID_Pro=P.ID GROUP BY D.ID_Pro");
            ResultSet rs = pst.executeQuery();
               
            if(rs.next()){
                //Datos consultados
                txt_nombre.setText(rs.getString("NOMBRE"));
                CVend.setText((rs.getString("CANTIDAD")));
                //leer Binario
                Blob blob = rs.getBlob(4);
                //pasar el binario a imagen
                byte[] data = blob.getBytes(1, (int) blob.length());
                //lee la imagen
                BufferedImage img = null;
                rs.next();
                //Datos consultados 2
                txt_nombre2.setText(rs.getString("NOMBRE"));
                CVend1.setText((rs.getString("CANTIDAD")));
                //leer Binario 2
                Blob blob2 = rs.getBlob(4);
                //pasar el binario a imagen 2
                byte[] data2 = blob2.getBytes(1, (int) blob2.length());
                //lee la imagen 2
                BufferedImage img2 = null;  
                rs.next();
                //Datos consultados 3
                txt_nombre3.setText(rs.getString("NOMBRE"));
                CVend2.setText((rs.getString("CANTIDAD")));
                //leer Binario 3
                Blob blob3 = rs.getBlob(4);
                //pasar el binario a imagen 3
                byte[] data3 = blob3.getBytes(1, (int) blob3.length());
                //lee la imagen 2
                BufferedImage img3 = null;  
                try {
                    img = ImageIO.read(new ByteArrayInputStream(data));
                    img2 = ImageIO.read(new ByteArrayInputStream(data2));
                    img3 = ImageIO.read(new ByteArrayInputStream(data3));
                } catch (IOException e) {
                }
                   
                ImageIcon icono = new ImageIcon(img);
                ImageIcon icono2= new ImageIcon(img2);
                ImageIcon icono3= new ImageIcon(img3);
                Icon imagen1 = new ImageIcon(icono.getImage().getScaledInstance(154,172, java.awt.Image.SCALE_SMOOTH));
                Icon imagen2 = new ImageIcon(icono2.getImage().getScaledInstance(164,173, java.awt.Image.SCALE_SMOOTH));
                Icon imagen3 = new ImageIcon(icono3.getImage().getScaledInstance(154,172, java.awt.Image.SCALE_SMOOTH));
                foto1.setIcon(imagen1);
                foto2.setIcon(imagen2);
                foto3.setIcon(imagen3);
               
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "¡Error al cargar!");
            System.out.println("Error al cargar foto: " + e);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        foto3 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        CVend2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        CVend1 = new javax.swing.JLabel();
        foto2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        CVend = new javax.swing.JLabel();
        foto1 = new javax.swing.JLabel();
        prodmasv1 = new javax.swing.JLabel();
        prodmasv = new javax.swing.JLabel();
        txt_nombre3 = new javax.swing.JLabel();
        txt_nombre2 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();
        ventas = new javax.swing.JButton();
        producto = new javax.swing.JButton();
        usuario3 = new javax.swing.JButton();
        usuario = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Reporte");

        jPanel1.setBackground(new java.awt.Color(34, 194, 194));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        foto3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        foto3.setToolTipText("");
        foto3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(foto3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 360, 154, 172));

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Cantidad vendidos: ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 540, -1, -1));

        CVend2.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        CVend2.setForeground(new java.awt.Color(255, 255, 255));
        CVend2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CVend2.setText("??");
        jPanel1.add(CVend2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 540, 50, 20));

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Cantidad vendidos: ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, -1, -1));

        CVend1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        CVend1.setForeground(new java.awt.Color(255, 255, 255));
        CVend1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CVend1.setText("??");
        jPanel1.add(CVend1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, 50, 20));

        foto2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        foto2.setToolTipText("");
        foto2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(foto2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 164, 173));

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Cantidad vendidos: ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, -1, 20));

        CVend.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        CVend.setForeground(new java.awt.Color(255, 255, 255));
        CVend.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CVend.setText("??");
        jPanel1.add(CVend, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 240, 50, 20));

        foto1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        foto1.setToolTipText("");
        foto1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(foto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, 154, 172));

        prodmasv1.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        prodmasv1.setForeground(new java.awt.Color(255, 255, 255));
        prodmasv1.setText("más Vendidos");
        jPanel1.add(prodmasv1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, 30));

        prodmasv.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        prodmasv.setForeground(new java.awt.Color(255, 255, 255));
        prodmasv.setText("Productos ");
        jPanel1.add(prodmasv, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, -1, 30));

        txt_nombre3.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        txt_nombre3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(txt_nombre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 320, 150, 40));

        txt_nombre2.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        txt_nombre2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(txt_nombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 160, 40));

        txt_nombre.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        txt_nombre.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 150, 40));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reporte.png"))); // NOI18N
        jPanel1.add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        ventas.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        ventas.setText("Reporte Ventas");
        ventas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ventas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ventasActionPerformed(evt);
            }
        });
        jPanel1.add(ventas, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 290, 210, -1));

        producto.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        producto.setText("Reporte Productos");
        producto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productoActionPerformed(evt);
            }
        });
        jPanel1.add(producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 290, -1, -1));

        usuario3.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        usuario3.setText("Reporte Detalle de Ventas");
        usuario3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        usuario3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuario3ActionPerformed(evt);
            }
        });
        jPanel1.add(usuario3, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 170, -1, -1));

        usuario.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        usuario.setText("Reporte Usuario");
        usuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioActionPerformed(evt);
            }
        });
        jPanel1.add(usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 290, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1250, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioActionPerformed
        Document documento = new Document();
        
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reporte_Usuario.pdf"));
            
            Paragraph header = new Paragraph();
            header.setAlignment(Paragraph.ALIGN_CENTER);
            header.add("Nico Tazas");
            header.setFont(FontFactory.getFont("Arial",30,Font.BOLD, BaseColor.DARK_GRAY));
            
            Paragraph linea = new Paragraph();
            linea.setAlignment(Paragraph.ALIGN_CENTER);
            linea.add("///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
            
            Paragraph Titulo = new Paragraph();
            Titulo.setAlignment(Paragraph.ALIGN_CENTER);
            Titulo.add("Reporte de Usuarios \n\n");
            Titulo.setFont(FontFactory.getFont("Arial",30,Font.BOLD, BaseColor.DARK_GRAY));
            
            documento.open();
            documento.add(linea);
            documento.add(header);
            documento.add(linea);
            documento.add(Titulo);
            
            PdfPTable tabla = new PdfPTable(7);
            tabla.addCell("ID");
            tabla.addCell("Nombre");
            tabla.addCell("Apellido Paterno");
            tabla.addCell("Apellido Materno");
            tabla.addCell("Cor");
            tabla.addCell("Nick");
            tabla.addCell("Contraseña");
            
            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement("select * from usuario");    
                ResultSet rs = pst.executeQuery();
                if(rs.next()){                               
                    do {                        
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                        tabla.addCell(rs.getString(6));
                        tabla.addCell(rs.getString(7));
                    } while (rs.next());
                    documento.add(tabla);                    
                }          
            } catch (DocumentException | SQLException e) {
            }
            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte de Usuario se ha Creado.");
        } catch (DocumentException | HeadlessException | FileNotFoundException e) {
        }
    }//GEN-LAST:event_usuarioActionPerformed

    private void ventasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ventasActionPerformed
        Document documento = new Document();     
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reporte_Pedido.pdf"));
            
            Paragraph header = new Paragraph();
            header.setAlignment(Paragraph.ALIGN_CENTER);
            header.add("Nico Tazas");
            header.setFont(FontFactory.getFont("Arial",30,Font.BOLD, BaseColor.DARK_GRAY));
            
            Paragraph linea = new Paragraph();
            linea.setAlignment(Paragraph.ALIGN_CENTER);
            linea.add("----------------------------------------------------------------------------------------------------------------------------------");
            
            Paragraph Titulo = new Paragraph();
            Titulo.setAlignment(Paragraph.ALIGN_CENTER);
            Titulo.add("Reporte de Ventas \n\n");
            Titulo.setFont(FontFactory.getFont("Tahoma",30,Font.BOLD, BaseColor.DARK_GRAY));
           
            documento.open();
            documento.add(header);
            documento.add(linea);
            documento.add(Titulo);
            
            PdfPTable tabla = new PdfPTable(7);
            tabla.addCell("Folio");
            tabla.addCell("ID_Usuario");
            tabla.addCell("Cliente");
            tabla.addCell("Cantidad");
            tabla.addCell("Total"); 
            tabla.addCell("Cambio");
            tabla.addCell("Fecha"); 
            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement("select * from pedido");    
                ResultSet rs = pst.executeQuery();                
                if(rs.next()){                               
                    do {                        
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                        tabla.addCell(rs.getString(6));
                        tabla.addCell(rs.getString(7));
                    } while (rs.next());
                    documento.add(tabla);                    
                }                
            } catch (DocumentException | SQLException e) {
            }
            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte creado.");
        } catch (DocumentException | HeadlessException | FileNotFoundException e) {
        }
    }//GEN-LAST:event_ventasActionPerformed

    private void productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productoActionPerformed
        Document documento = new Document();
        
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reporte_Producto.pdf"));
            
            Paragraph header = new Paragraph();
            header.setAlignment(Paragraph.ALIGN_CENTER);
            header.add("Nico Tazas");
            header.setFont(FontFactory.getFont("Arial",30,Font.BOLD, BaseColor.DARK_GRAY));
            
            Paragraph linea = new Paragraph();
            linea.setAlignment(Paragraph.ALIGN_CENTER);
            linea.add("///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
            
            Paragraph Titulo = new Paragraph();
            Titulo.setAlignment(Paragraph.ALIGN_CENTER);
            Titulo.add("Reporte de Productos \n\n");
            Titulo.setFont(FontFactory.getFont("Arial",30,Font.BOLD, BaseColor.DARK_GRAY));
            
            documento.open();
            documento.add(linea);
            documento.add(header);
            documento.add(linea);
            documento.add(Titulo);
            
            PdfPTable tabla = new PdfPTable(7);
            tabla.addCell("ID");
            tabla.addCell("Nom");
            tabla.addCell("Tipo");
            tabla.addCell("Talla");
            tabla.addCell("Can");
            tabla.addCell("Pre");
            tabla.addCell("Des");
            
            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement("select * from producto");    
                ResultSet rs = pst.executeQuery();
                if(rs.next()){                               
                    do {                        
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                        tabla.addCell(rs.getString(6));
                        tabla.addCell(rs.getString(7));
                    } while (rs.next());
                    documento.add(tabla);                    
                }          
            } catch (DocumentException | SQLException e) {
            }
            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte de Productos se ha Creado.");
        } catch (DocumentException | HeadlessException | FileNotFoundException e) {
        }
    }//GEN-LAST:event_productoActionPerformed

    private void usuario3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuario3ActionPerformed
        Document documento = new Document();     
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reporte_DetallesVentas.pdf"));
            
            Paragraph header = new Paragraph();
            header.setAlignment(Paragraph.ALIGN_CENTER);
            header.add("Nico Tazas");
            header.setFont(FontFactory.getFont("Arial",30,Font.BOLD, BaseColor.DARK_GRAY));
            
            Paragraph linea = new Paragraph();
            linea.setAlignment(Paragraph.ALIGN_CENTER);
            linea.add("----------------------------------------------------------------------------------------------------------------------------------");
            
            Paragraph Titulo = new Paragraph();
            Titulo.setAlignment(Paragraph.ALIGN_CENTER);
            Titulo.add("Reporte Detalles de Ventas \n\n");
            Titulo.setFont(FontFactory.getFont("Tahoma",30,Font.BOLD, BaseColor.DARK_GRAY));
            
            documento.open();
            documento.add(header);
            documento.add(linea);
            documento.add(Titulo);
            
            PdfPTable tabla = new PdfPTable(5);
            tabla.addCell("ID");
            tabla.addCell("Folio");
            tabla.addCell("ID_Producto");
            tabla.addCell("Cantidad");
            tabla.addCell("Precio");            
            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement("select * from d_pedido");    
                ResultSet rs = pst.executeQuery();                
                if(rs.next()){                               
                    do {                        
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                    } while (rs.next());
                    documento.add(tabla);                    
                }                
            } catch (DocumentException | SQLException e) {
            }
            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte creado.");
        } catch (DocumentException | HeadlessException | FileNotFoundException e) {
        }
    }//GEN-LAST:event_usuario3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CVend;
    private javax.swing.JLabel CVend1;
    private javax.swing.JLabel CVend2;
    private javax.swing.JLabel Fondo;
    private javax.swing.JLabel foto1;
    private javax.swing.JLabel foto2;
    private javax.swing.JLabel foto3;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel prodmasv;
    private javax.swing.JLabel prodmasv1;
    private javax.swing.JButton producto;
    private javax.swing.JLabel txt_nombre;
    private javax.swing.JLabel txt_nombre2;
    private javax.swing.JLabel txt_nombre3;
    private javax.swing.JButton usuario;
    private javax.swing.JButton usuario3;
    private javax.swing.JButton ventas;
    // End of variables declaration//GEN-END:variables
}
