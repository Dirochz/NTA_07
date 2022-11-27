package Formulario;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import javax.swing.table.DefaultTableModel;
import nta_07.Conexion;

public final class Productos extends javax.swing.JInternalFrame {
    int fila=0,id, resp,i,ca;
    double pr;
    String Bus;
    ImageIcon foto;
    InputStream is;
    DefaultTableModel modelo; 
    public Productos() {
        initComponents();
        setTitle("Productos");
        table();
    }
    
    void buscar(){
        modelo.setRowCount(0);
        Bus = txt_bu.getText().trim();
        try{
            Connection cn = Conexion.conectar();
            String query;
            if(Bus.equals("")){
                query = "select * from producto";
            }
            else{
                query = "select * from producto Where Nom='"+Bus+"' or Tipo='"+Bus+"' or Talla='"+Bus+"' or Can='"+Bus+"' or Pre='"+Bus+"' or Des='"+Bus+"'";
            }
            PreparedStatement pst = cn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            Object[] imgan = new Object[8];
            while(rs.next()){
                imgan[0] = rs.getInt("ID");
                imgan[1] = rs.getString("Nom");
                imgan[2] = rs.getString("Tipo");
                imgan[3] = rs.getString("Talla");
                imgan[4] = rs.getInt("Can");
                imgan[5] = rs.getDouble("Pre");
                imgan[6] = rs.getString("Des");
                modelo.addRow(imgan);
            }
            u.setModel(modelo);
        }catch(SQLException e){
            System.out.println("Error en conexión local al textear el buscar" + e);
        }
        txt_bu.setText("");
    }
    
    void table(){
        modelo = (DefaultTableModel)u.getModel();
        u.setModel(modelo);
        Object[] usu = new Object[7];
        try{
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select ID,Nom,Tipo,Talla,Can,Pre,Des from producto");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                usu[0] = rs.getInt("ID");
                usu[1] = rs.getString("Nom");
                usu[2] = rs.getString("Tipo");
                usu[3] = rs.getString("Talla");
                usu[4] = rs.getInt("Can");
                usu[5] = rs.getDouble("Pre");
                usu[6] = rs.getString("Des");
                modelo.addRow(usu);
            }
            u.setModel(modelo);
        }catch(SQLException e){
            System.out.println("Aqui en tabla");
            System.out.println(""+e);
        }
    }
    
    void Mod(){
        fila = u.getSelectedRow();
        id = Integer.parseInt(this.u.getValueAt(fila, 0).toString());
        String nom = u.getValueAt(fila, 1).toString();
        String ti = u.getValueAt(fila, 2).toString();
        String ta = u.getValueAt(fila, 3).toString();
        ca = Integer.parseInt(this.u.getValueAt(fila,4).toString());
        pr = (double) this.u.getValueAt(fila,5);
        String des = u.getValueAt(fila, 6).toString();
        try{
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("UPDATE producto SET Nom='"+nom+"', Tipo='"+ti+"', Talla='"+ta+"', Can='"+ca+
                    "', Pre='"+pr+"', Des='"+des+"' Where ID = '"+id+"'");
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se ha Modificado Exitosamente");
        }catch(SQLException e){
            System.out.println("Aqui en tabla de Modificar Usuario = "+id+" Fila: "+fila);
            System.out.println(""+e);
        }
    }
    
    void Elus(){
        fila = u.getSelectedRow();
        id = Integer.parseInt(this.u.getValueAt(fila, 0).toString());
        if(fila>-1){
               
            try{
                resp = JOptionPane.showConfirmDialog(null,"¿Seguro que quiere eliminar este Producto? "+id+"","Eliminar Producto",YES_NO_OPTION,INFORMATION_MESSAGE,null);
                if(resp==0){
                    Connection cn = Conexion.conectar();
                    PreparedStatement pst = cn.prepareStatement("delete from producto where ID='"+id+"'");             
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Se ha Eliminado Exitosamente");
                }
            }catch(SQLException e){  
                System.out.println("Aqui en tabla al intentar eliminar producto = "+id+" Fila: "+fila);
                System.out.println(""+e);
            }  
        }
    }
    
    void dbox(){
        try {
            ArrayList<String> nombres = new ArrayList<>();         
            Connection cn = Conexion.conectar(); 
            PreparedStatement pst;
            pst = cn.prepareStatement("select Tipo from producto"); 
            nombres.add("Seleccionar");
            nombres.add("Todos");          
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                nombres.add(rs.getString("Tipo"));
            }
            String[] usuarios = nombres.toArray(new String[0]);
            co_bu.setModel(new javax.swing.DefaultComboBoxModel<>(usuarios));
        }catch (SQLException e){    
            System.out.println("Error en conexión local en colocar el combo box: " + e);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        bo_ag1 = new javax.swing.JButton();
        txt_bu = new javax.swing.JTextField();
        co_bu = new javax.swing.JComboBox<>();
        lb_img = new javax.swing.JLabel();
        Actualizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        u = new javax.swing.JTable();
        ce_mod = new javax.swing.JCheckBox();
        ce_el = new javax.swing.JCheckBox();
        pdf = new javax.swing.JButton();
        bo_El = new javax.swing.JButton();
        bo_ag = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        Escritorio = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Productos");

        jPanel1.setBackground(new java.awt.Color(34, 194, 194));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bo_ag1.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        bo_ag1.setForeground(new java.awt.Color(0, 0, 0));
        bo_ag1.setText("Buscar");
        bo_ag1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bo_ag1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bo_ag1ActionPerformed(evt);
            }
        });
        jPanel1.add(bo_ag1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 240, 100, 30));

        txt_bu.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        txt_bu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_buKeyTyped(evt);
            }
        });
        jPanel1.add(txt_bu, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 190, 40));

        co_bu.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        co_bu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Taza", "Ropa" }));
        co_bu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        co_bu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                co_buActionPerformed(evt);
            }
        });
        jPanel1.add(co_bu, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 160, 30));
        jPanel1.add(lb_img, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, 330, 230));

        Actualizar.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        Actualizar.setForeground(new java.awt.Color(0, 0, 0));
        Actualizar.setText("Actualizar");
        Actualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(Actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 450, -1, -1));

        u.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        u.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nom", "Tipo", "Talla", "Cantidad", "Precio", "Descripcion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        u.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        u.setName(""); // NOI18N
        u.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                uMouseClicked(evt);
            }
        });
        u.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                uKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(u);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 590, 290));

        ce_mod.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        ce_mod.setForeground(new java.awt.Color(255, 255, 255));
        ce_mod.setText("Modo Editar");
        ce_mod.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ce_mod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ce_modActionPerformed(evt);
            }
        });
        jPanel1.add(ce_mod, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        ce_el.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        ce_el.setForeground(new java.awt.Color(255, 255, 255));
        ce_el.setText("Modo Eliminar");
        ce_el.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ce_el.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ce_elActionPerformed(evt);
            }
        });
        jPanel1.add(ce_el, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        pdf.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        pdf.setForeground(new java.awt.Color(0, 0, 0));
        pdf.setText("PDF");
        pdf.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pdfActionPerformed(evt);
            }
        });
        jPanel1.add(pdf, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 510, -1, -1));

        bo_El.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        bo_El.setForeground(new java.awt.Color(0, 0, 0));
        bo_El.setText("Eliminar");
        bo_El.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bo_El.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bo_ElActionPerformed(evt);
            }
        });
        jPanel1.add(bo_El, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 390, -1, -1));

        bo_ag.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        bo_ag.setForeground(new java.awt.Color(0, 0, 0));
        bo_ag.setText("Agregar");
        bo_ag.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bo_ag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bo_agActionPerformed(evt);
            }
        });
        jPanel1.add(bo_ag, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 330, -1, -1));

        jButton1.setBorder(null);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 480, -1, -1));

        javax.swing.GroupLayout EscritorioLayout = new javax.swing.GroupLayout(Escritorio);
        Escritorio.setLayout(EscritorioLayout);
        EscritorioLayout.setHorizontalGroup(
            EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );
        EscritorioLayout.setVerticalGroup(
            EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
        );

        jPanel1.add(Escritorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 0, 480, 580));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Productos.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, -1));

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

    private void uKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_uKeyReleased
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(i==1){
                Mod();
            }
            else if(i==3){
                Elus();
            }
        }
    }//GEN-LAST:event_uKeyReleased

    private void ce_modActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ce_modActionPerformed
        if(ce_el.isSelected()){
            JOptionPane.showMessageDialog(null,"Solo debe estar un modo Activado");
            ce_mod.setSelected(false);
        }
        else{
            i=1;
            System.out.println("La i es: "+i);
        }
    }//GEN-LAST:event_ce_modActionPerformed

    private void ce_elActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ce_elActionPerformed
        if(ce_mod.isSelected()){
            JOptionPane.showMessageDialog(null,"Solo debe estar un modo Activado");
            ce_el.setSelected(false);
        }
        else{
            i=3;
            System.out.println("La i es: "+i);
        }
    }//GEN-LAST:event_ce_elActionPerformed

    private void bo_ElActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bo_ElActionPerformed
        fila = u.getSelectedRow();
        if(fila>-1){
            id = Integer.parseInt(this.u.getValueAt(fila, 0).toString());
            try{
                resp = JOptionPane.showConfirmDialog(null,"¿Seguro que quiere eliminar este Producto? "+id+"","Eliminar Producto",YES_NO_OPTION,INFORMATION_MESSAGE,null);
                if(resp==0){
                    Connection cn = Conexion.conectar();
                    PreparedStatement pst = cn.prepareStatement("delete from producto where ID='"+id+"'");             
                    pst.executeUpdate();
                    modelo.removeRow(fila);
                    JOptionPane.showMessageDialog(null, "Se ha eliminado exitosamente");
                }
            }catch(SQLException e){  
                System.out.println("Aqui en tabla al intentar Eliminar Producto = "+id+" Fila: "+fila);
                System.out.println(""+e);
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"Seleccione un Producto");
            System.out.println("La Fila es: "+fila);
            System.out.println("Id = "+id);
        }
    }//GEN-LAST:event_bo_ElActionPerformed

    private void bo_agActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bo_agActionPerformed
        mag ag = new mag();
        Escritorio.add(ag);
        ag.setVisible(true);
    }//GEN-LAST:event_bo_agActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed

    private void pdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pdfActionPerformed
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
        } catch (IOException ex) {
            Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_pdfActionPerformed

    private void ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarActionPerformed
        modelo.setRowCount(0);
        modelo = (DefaultTableModel)u.getModel();
        u.setModel(modelo);
        Object[] usu = new Object[7];
        try{
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select ID,Nom,Tipo,Talla,Can,Pre,Des from producto");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                usu[0] = rs.getInt("ID");
                usu[1] = rs.getString("Nom");
                usu[2] = rs.getString("Tipo");
                usu[3] = rs.getString("Talla");
                usu[4] = rs.getInt("Can");
                usu[5] = rs.getDouble("Pre");
                usu[6] = rs.getString("Des");
                modelo.addRow(usu);
            }
            u.setModel(modelo);
        }catch(SQLException e){
            System.out.println("Aqui en tabla");
            System.out.println(""+e);
        }
    }//GEN-LAST:event_ActualizarActionPerformed

    private void co_buActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_co_buActionPerformed
        modelo.setRowCount(0);
        String con = co_bu.getSelectedItem().toString();
        try{
            Connection cn = Conexion.conectar();
            String query;
            if(con.equals("Todos")){
                query = "select * from producto";
            }
            else{
                query = "select * from producto Where Tipo='"+con+"'";
            }
            PreparedStatement pst = cn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            Object[] imgan = new Object[7];
            while(rs.next()){
                imgan[0] = rs.getInt("ID");
                imgan[1] = rs.getString("Nom");
                imgan[2] = rs.getString("Tipo");
                imgan[3] = rs.getString("Talla");
                imgan[4] = rs.getInt("Can");
                imgan[5] = rs.getDouble("Pre");
                imgan[6] = rs.getString("Des");
                modelo.addRow(imgan);
            }
            u.setModel(modelo);
        }catch(SQLException e){
            System.out.println("Error en buscar con el combo box: " + e);
        }
    }//GEN-LAST:event_co_buActionPerformed

    private void uMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uMouseClicked
        int filaa = u.getSelectedRow();
        int id_f = Integer.parseInt(this.u.getValueAt(filaa,0).toString());
        try{
            Connection cn = Conexion.conectar();
            java.sql.PreparedStatement pst = cn.prepareStatement("SELECT Dis from producto where ID='"+id_f+"'");             
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                is = rs.getBinaryStream("Dis");
                BufferedImage bi = ImageIO.read(is);
                foto = new ImageIcon (bi);
                Image img = foto.getImage();
                Image newimg = img.getScaledInstance(330,230, java.awt.Image.SCALE_SMOOTH);
                ImageIcon newicon = new ImageIcon (newimg);
                lb_img.setIcon(newicon);
            }
        }catch(SQLException | IOException e){
        }
    }//GEN-LAST:event_uMouseClicked

    private void bo_ag1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bo_ag1ActionPerformed
        buscar();
    }//GEN-LAST:event_bo_ag1ActionPerformed

    private void txt_buKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buKeyTyped

    }//GEN-LAST:event_txt_buKeyTyped

    private void txt_buKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buKeyReleased
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            buscar();
        }
    }//GEN-LAST:event_txt_buKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Actualizar;
    public static javax.swing.JDesktopPane Escritorio;
    private javax.swing.JButton bo_El;
    private javax.swing.JButton bo_ag;
    private javax.swing.JButton bo_ag1;
    private javax.swing.JCheckBox ce_el;
    private javax.swing.JCheckBox ce_mod;
    private javax.swing.JComboBox<String> co_bu;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_img;
    private javax.swing.JButton pdf;
    private javax.swing.JTextField txt_bu;
    private javax.swing.JTable u;
    // End of variables declaration//GEN-END:variables
}
