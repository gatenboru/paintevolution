/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import baseDatos.ConexionMysql;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author proyectosbeta
 */
/**
 * Clase Ventana donde sale el login a la base de datos.
 * Puede ser dinamica o estatica.
 */
public class VentanaLoginBaseDatos extends VentanaComun {
    // Objetos de clase.
    private static String rutaImagenTemporal;
    
    /**
     * Creates new form VentanaLoginBaseDatos
     */
    VentanaBaseDatos2 ventanaBaseDatos;
    public VentanaLoginBaseDatos(String rutaImagenTemporal) {
        /*
         * Se guarda la ruta de la imagen temporal para luego usar,
         * al crear un Texto con registros de la base de datos.
         */
        VentanaLoginBaseDatos.rutaImagenTemporal = rutaImagenTemporal;
        
        initComponents();
        inicializarObjetos();
    }
    
     /**
     * Metodo que inicializa los objetos.
     */
    private void inicializarObjetos(){
        // Colocamos el nuevo tipo de layout que queremos que tenga nuestro JDialog.
        this.setLayout(new FlowLayout());
        
        // Agregamos el jPanelLoginBaseDatos con un layout al centro.
        this.add(jPanelLoginBaseDatos, BorderLayout.CENTER);
        
        // Hacemos que el JDialog tenga el tamaño de todos sus elementos.
        this.pack();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelLoginBaseDatos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelUsuario = new javax.swing.JLabel();
        jLabelContrasenhia = new javax.swing.JLabel();
        jFormattedTextFieldUsuarioLogin = new javax.swing.JFormattedTextField();
        jPasswordFieldContrasenhiaLogin = new javax.swing.JPasswordField();
        jButtonLogin = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jTextFieldBaseDatos = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Login a Base de Datos");
        setPreferredSize(new java.awt.Dimension(450, 350));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Conectarse a la base de datos");

        jLabelUsuario.setText("Usuario:");

        jLabelContrasenhia.setText("Contraseña:");

        jFormattedTextFieldUsuarioLogin.setToolTipText("Introduzca el usuario para la base de datos");

        jPasswordFieldContrasenhiaLogin.setToolTipText("Introduzca la contraseña de acceso");

        jButtonLogin.setText("Conectar");
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jTextFieldBaseDatos.setToolTipText("Introduzca el nombre de la base de datos si lo conoce");
        jTextFieldBaseDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldBaseDatosActionPerformed(evt);
            }
        });

        jLabel2.setText("Base de Datos");

        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("Si no conoce el nombre de la Base de Datos deje este campo en blanco.");

        javax.swing.GroupLayout jPanelLoginBaseDatosLayout = new javax.swing.GroupLayout(jPanelLoginBaseDatos);
        jPanelLoginBaseDatos.setLayout(jPanelLoginBaseDatosLayout);
        jPanelLoginBaseDatosLayout.setHorizontalGroup(
            jPanelLoginBaseDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLoginBaseDatosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonCancelar)
                .addGap(99, 99, 99))
            .addGroup(jPanelLoginBaseDatosLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(jPanelLoginBaseDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanelLoginBaseDatosLayout.createSequentialGroup()
                        .addGroup(jPanelLoginBaseDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelContrasenhia)
                            .addComponent(jLabelUsuario)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelLoginBaseDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFormattedTextFieldUsuarioLogin)
                            .addComponent(jPasswordFieldContrasenhiaLogin)
                            .addComponent(jTextFieldBaseDatos)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelLoginBaseDatosLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1)))
                .addContainerGap())
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
        );
        jPanelLoginBaseDatosLayout.setVerticalGroup(
            jPanelLoginBaseDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLoginBaseDatosLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addGroup(jPanelLoginBaseDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelUsuario)
                    .addComponent(jFormattedTextFieldUsuarioLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelLoginBaseDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelContrasenhia)
                    .addComponent(jPasswordFieldContrasenhiaLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelLoginBaseDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldBaseDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanelLoginBaseDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonLogin)
                    .addComponent(jButtonCancelar))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelLoginBaseDatos);
        jPanelLoginBaseDatos.setBounds(0, 0, 397, 287);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // Se cierra la VentanaLoginBaseDatos.
        this.dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jTextFieldBaseDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBaseDatosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldBaseDatosActionPerformed

    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed
        String user=jFormattedTextFieldUsuarioLogin.getText();
        String pwd=jPasswordFieldContrasenhiaLogin.getText();
        String BD= jTextFieldBaseDatos.getText();
        ConexionMysql conexion = null;
        if(!user.equals("")&&!pwd.equals("")){
            try {
                conexion= new ConexionMysql(user,pwd,BD);
                ventanaBaseDatos = new VentanaBaseDatos2(conexion, rutaImagenTemporal);
                ventanaBaseDatos.setLocationRelativeTo(this);
                ventanaBaseDatos.setVisible(true);
                
                // Se cierra VentanaLoginBaseDatos.
                this.dispose();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this,"El servidor local ha dicho: "+ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                try {
                    conexion.terminarConexion();
                } catch (SQLException ex1) {}
                //System.out.println(ex.getMessage());
                //Logger.getLogger(VentanaLoginBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }else{
            JOptionPane.showMessageDialog(this, "Por favor introduzca "
                + "el usuario y la contraseña.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonLoginActionPerformed

    /**
     * Donde despliega el login de la base de datos.
     *
     * @since 1.6
     */
    public void mostraLoginBaseDatos(){
        // Hace visbile la VentanaLoginBaseDatos.
        this.setVisible(true);
    }
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
            java.util.logging.Logger.getLogger(VentanaLoginBaseDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaLoginBaseDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaLoginBaseDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaLoginBaseDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                VentanaLoginBaseDatos dialog = new VentanaLoginBaseDatos(rutaImagenTemporal);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JFormattedTextField jFormattedTextFieldUsuarioLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelContrasenhia;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JPanel jPanelLoginBaseDatos;
    private javax.swing.JPasswordField jPasswordFieldContrasenhiaLogin;
    private javax.swing.JTextField jTextFieldBaseDatos;
    // End of variables declaration//GEN-END:variables
}
