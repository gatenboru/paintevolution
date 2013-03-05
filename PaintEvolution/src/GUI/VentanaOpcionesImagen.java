/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author proyectosbeta
 */
/**
 * Clase Ventana donde sale opciones de la imagen.
 * Puede ser dinamica o estatica.
 */
public class VentanaOpcionesImagen extends VentanaComun {
    // Objetos de clase.
    private VentanaLoginBaseDatos ventanaLoginBaseDatos;
    private static String rutaImagenTemporal;
    
    /**
     * Creates new form VentanaOpcionesImagen
     */
    public VentanaOpcionesImagen(String rutaImagenTemporal) {
        /*
         * Se guarda la ruta de la imagen temporal para luego usar,
         * al crear un Texto con registros de la base de datos.
         */
        VentanaOpcionesImagen.rutaImagenTemporal = rutaImagenTemporal;
        
        initComponents();
        inicializarObjetos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupOpcionesImagen = new javax.swing.ButtonGroup();
        jPanelOpcionesImagen = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jRadioButtonImagenEstatica = new javax.swing.JRadioButton();
        jRadioButtonImagenDinamica = new javax.swing.JRadioButton();
        jButtonGenerar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Opciones de imagen");

        jLabel2.setText("Opciones de imagen");

        jRadioButtonImagenEstatica.setText("Imagen estática");
        jRadioButtonImagenEstatica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonImagenEstaticaActionPerformed(evt);
            }
        });

        jRadioButtonImagenDinamica.setText("Imagen dinámica");

        jButtonGenerar.setText("Generar");
        jButtonGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGenerarActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelOpcionesImagenLayout = new javax.swing.GroupLayout(jPanelOpcionesImagen);
        jPanelOpcionesImagen.setLayout(jPanelOpcionesImagenLayout);
        jPanelOpcionesImagenLayout.setHorizontalGroup(
            jPanelOpcionesImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOpcionesImagenLayout.createSequentialGroup()
                .addGroup(jPanelOpcionesImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelOpcionesImagenLayout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jLabel2))
                    .addGroup(jPanelOpcionesImagenLayout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addGroup(jPanelOpcionesImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButtonImagenDinamica)
                            .addComponent(jRadioButtonImagenEstatica)))
                    .addGroup(jPanelOpcionesImagenLayout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(jButtonGenerar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonCancelar)))
                .addContainerGap(129, Short.MAX_VALUE))
        );
        jPanelOpcionesImagenLayout.setVerticalGroup(
            jPanelOpcionesImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOpcionesImagenLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButtonImagenEstatica)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonImagenDinamica)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelOpcionesImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonGenerar)
                    .addComponent(jButtonCancelar))
                .addContainerGap(129, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelOpcionesImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelOpcionesImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButtonImagenEstaticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonImagenEstaticaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonImagenEstaticaActionPerformed

    private void jButtonGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGenerarActionPerformed
        // Objeto String.
        String mensaje;
        
        if(!jRadioButtonImagenEstatica.isSelected() && !jRadioButtonImagenDinamica.isSelected()){
            mensaje = "Debe seleccionar una opción!!!";
            JOptionPane.showMessageDialog(this, mensaje, "Aviso", JOptionPane.WARNING_MESSAGE);
        }else if(jRadioButtonImagenEstatica.isSelected()){
             mensaje = "Imagen Estática!!!";
            JOptionPane.showMessageDialog(this, mensaje, "Aviso", JOptionPane.WARNING_MESSAGE);
        }else if(jRadioButtonImagenDinamica.isSelected()){
             ventanaLoginBaseDatos = new VentanaLoginBaseDatos(rutaImagenTemporal);
             ventanaLoginBaseDatos.setLocationRelativeTo(this);
	     ventanaLoginBaseDatos.mostraLoginBaseDatos();
             
            // Se cierra la VentanaOpcionesImagen.
            this.dispose();   
        }
    }//GEN-LAST:event_jButtonGenerarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // Se cierra la VentanaOpcionesImagen.
        this.dispose();                    
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    /**
     * Donde despliega las opciones de imagen.
     *
     * @since 1.6
     */
    public void mostrarOpcionesImagen(){
        // Hace visbile la VentanaOpcionesImagen.
        this.setVisible(true);
    }
     
    /**
     * Metodo que inicializa los objetos.
     */
    private void inicializarObjetos(){
        /* 
         * Se agrega las dos opciones (jRadioButtonImagenEstatica y jRadioButtonImagenDinamica)
         * al buttonGroupOpcionesImagen.
         */
        buttonGroupOpcionesImagen.add(jRadioButtonImagenEstatica);
        buttonGroupOpcionesImagen.add(jRadioButtonImagenDinamica);
        
        // Colocamos el nuevo tipo de layout que queremos que tenga nuestro JDialog.
        this.setLayout(new FlowLayout());
        
        // Agregamos el jPanelOpcionesImagen con un layout al centro.
        this.add(jPanelOpcionesImagen, BorderLayout.CENTER);
        
        // Hacemos que el JDialog tenga el tamaño de todos sus elementos.
        this.pack();
    }
    
    /**
    * Donde se ejecuta la Ventana OpcionesImagen.
    *
    * @param args La linea de argumentos del comando
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
            java.util.logging.Logger.getLogger(VentanaOpcionesImagen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaOpcionesImagen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaOpcionesImagen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaOpcionesImagen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VentanaOpcionesImagen(rutaImagenTemporal).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupOpcionesImagen;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonGenerar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanelOpcionesImagen;
    private javax.swing.JRadioButton jRadioButtonImagenDinamica;
    private javax.swing.JRadioButton jRadioButtonImagenEstatica;
    // End of variables declaration//GEN-END:variables
}
