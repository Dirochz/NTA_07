package Formulario;

public final class mag extends javax.swing.JInternalFrame {
    int resp;
    public mag() {
        initComponents();
        setTitle("Agregar Usuario");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Ropaa = new javax.swing.JButton();
        Tazaa = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Menu Agregar Productos");

        jPanel1.setBackground(new java.awt.Color(34, 194, 194));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Ropaa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ropa.png"))); // NOI18N
        Ropaa.setBorder(null);
        Ropaa.setBorderPainted(false);
        Ropaa.setContentAreaFilled(false);
        Ropaa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Ropaa.setFocusPainted(false);
        Ropaa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RopaaActionPerformed(evt);
            }
        });
        jPanel1.add(Ropaa, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, -1, -1));

        Tazaa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/taza.png"))); // NOI18N
        Tazaa.setBorder(null);
        Tazaa.setBorderPainted(false);
        Tazaa.setContentAreaFilled(false);
        Tazaa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Tazaa.setFocusPainted(false);
        Tazaa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TazaaActionPerformed(evt);
            }
        });
        jPanel1.add(Tazaa, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Ropa");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 470, -1, -1));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Taza");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, -1, -1));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/mag.png"))); // NOI18N
        jPanel1.add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, -1, -1));

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

    private void TazaaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TazaaActionPerformed
        agta u = new agta();
        Productos.Escritorio.add(u);
        u.toFront();
        u.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_TazaaActionPerformed

    private void RopaaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RopaaActionPerformed
        agro u = new agro();
        Productos.Escritorio.add(u);
        u.toFront();
        u.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_RopaaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    private javax.swing.JButton Ropaa;
    private javax.swing.JButton Tazaa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
