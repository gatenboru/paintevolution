package GUI;

import Auxiliar.Constantes;
import Auxiliar.Texto;
import java.awt.Color;
import java.awt.GraphicsEnvironment;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;

/**
 *@(#)VentanaTexto.java
 *
 * @author fires
 * @version 1.00
 * @since 1.6
 */
/**
 * Clase VentanaTexto donde se crean objetos Texto.
 * @since 1.6
 */
public class VentanaTexto extends javax.swing.JDialog {
    ////////////////////////////////////////////////////////////////////////////
    // Variables de clase
    ////////////////////////////////////////////////////////////////////////////
    /**
     * Obtenemos la referencia al entorno de ventanas
     * @since 1.6
     */
    private GraphicsEnvironment gEnv;

    /**
     * Objeto Texto
     * @since 1.6
     */
    private Texto texto;

    /**
     * Si se va a dibujar el Texto o no
     * @since 1.6
     */
    private boolean dibujaTexto;

    /**
     * Una ventana que contiene una paleta de colores
     * @since 1.6
     */
    private VentanaColor ventanaColor;

    
    ////////////////////////////////////////////////////////////////////////////
    // Constructores
    ////////////////////////////////////////////////////////////////////////////
    /**
     * Construye una Ventana de Texto.
     * @since 1.6
     */
    public VentanaTexto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e){}
        gEnv = GraphicsEnvironment.getLocalGraphicsEnvironment();
        initComponents();
        texto = null;
        ventanaColor = null;
        dibujaTexto = false;
        this.setTitle("" + Constantes.INCREMENTO_CANTIDAD_DE_ESPACIO_TITULO +
                "Introduzca un texto");         // titulo de la ventana
        this.setResizable(false);               // No redimensiona la ventana
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelTextPanel = new javax.swing.JPanel();
        jLabelIntroduzcaTexto = new javax.swing.JLabel();
        jTextFieldTexto = new javax.swing.JTextField();
        jLabelTipolFuente = new javax.swing.JLabel();
        jLabelTamañoTexto = new javax.swing.JLabel();
        jSpinnerTamañoTexto = new javax.swing.JSpinner(new SpinnerNumberModel(Constantes.VALOR_PREDETERMINADO_SPINNER_NUMBER_MODEL, Constantes.VALOR_MINIMO_SPINNER_NUMBER_MODEL, Constantes.VALOR_MAXIMO_SPINNER_NUMBER_MODEL, Constantes.INCREMENTO_SPINNER_NUMBER_MODEL));
        jComboBoxTipoFuentes = new javax.swing.JComboBox();
        jButtonColor = new javax.swing.JButton();
        jLabelEstilo = new javax.swing.JLabel();
        jComboBoxTipoEstilo = new javax.swing.JComboBox();
        jButtonAceptar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabelIntroduzcaTexto.setText("Introduzca un texto:");

        jTextFieldTexto.setToolTipText("texto");

        javax.swing.GroupLayout jPanelTextPanelLayout = new javax.swing.GroupLayout(jPanelTextPanel);
        jPanelTextPanel.setLayout(jPanelTextPanelLayout);
        jPanelTextPanelLayout.setHorizontalGroup(
            jPanelTextPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTextPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelIntroduzcaTexto)
                .addGap(18, 18, 18)
                .addComponent(jTextFieldTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelTextPanelLayout.setVerticalGroup(
            jPanelTextPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTextPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTextPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelIntroduzcaTexto, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(jTextFieldTexto)))
        );

        jLabelTipolFuente.setText("Fuentes:");
        jLabelTipolFuente.setToolTipText("Tipo de Fuentes");

        jLabelTamañoTexto.setText("Tamaño:");

        jSpinnerTamañoTexto.setToolTipText("Tamaño");

        jComboBoxTipoFuentes.setMaximumRowCount(5);
        jComboBoxTipoFuentes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Serif", "SansSerif", "Monospaced", "Dialog", "DialogInput" }));
        jComboBoxTipoFuentes.setSelectedItem(Constantes.TIPO_FUENTE_LETRA_PREDETERMINADO);
        jComboBoxTipoFuentes.setToolTipText("Tipos de Fuente");
        jComboBoxTipoFuentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTipoFuentesActionPerformed(evt);
            }
        });

        jButtonColor.setText("Color");
        jButtonColor.setToolTipText("Color");
        jButtonColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonColorActionPerformed(evt);
            }
        });

        jLabelEstilo.setText("Estilo:");

        jComboBoxTipoEstilo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Normal", "Negrita", "Cursiva", "Negrita Cursiva" }));
        jComboBoxTipoEstilo.setToolTipText("Tipo de Estilos");

        jButtonAceptar.setText("Aceptar");
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelTextPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabelTipolFuente, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxTipoFuentes, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabelTamañoTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jSpinnerTamañoTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jButtonColor))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabelEstilo)
                        .addGap(41, 41, 41)
                        .addComponent(jComboBoxTipoEstilo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jButtonAceptar)
                        .addGap(27, 27, 27)
                        .addComponent(jButtonCancelar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelTextPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTipolFuente, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jComboBoxTipoFuentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTamañoTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinnerTamañoTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jButtonColor)))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabelEstilo, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jComboBoxTipoEstilo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonAceptar)
                    .addComponent(jButtonCancelar))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxTipoFuentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTipoFuentesActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jComboBoxTipoFuentesActionPerformed

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
        if(!jTextFieldTexto.getText().equals("")){
            int numeroEntero = Integer.parseInt(jSpinnerTamañoTexto.getValue().toString());
            Color colorTexto;
            if(ventanaColor != null){
                colorTexto = ventanaColor.getJColorChooserColores().getColor();
            }else{
                colorTexto = Color.BLACK; // color negro predeterminado
            }
            texto = new Texto(jTextFieldTexto.getText(), seleccionarTipoFuente(jComboBoxTipoFuentes.getSelectedIndex()),
                jComboBoxTipoEstilo.getSelectedIndex(), numeroEntero, colorTexto);
            this.setVisible(false);
            setDibujaTexto(true);
        }else {
            String mensaje = "Introduzca un texto!!!";
            JOptionPane.showMessageDialog(this, mensaje, "" + Constantes.INCREMENTO_CANTIDAD_DE_ESPACIO_TITULO +
                    Constantes.TITULO_PROGRAMA,JOptionPane.PLAIN_MESSAGE);
            jTextFieldTexto.requestFocus();
            setDibujaTexto(false);
        }
        repaint();
}//GEN-LAST:event_jButtonAceptarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        setVisible(false);
        setDibujaTexto(false);

        dispose();
        //repaint();
        
}//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonColorActionPerformed
        mostrarVentanaColor();
        // Centrar el ventana Color
        ventanaColor.setLocationRelativeTo(this);

        texto.setColor(ventanaColor.getJColorChooserColores().getColor());
        ventanaColor.setTitle("Color del texto");
    }//GEN-LAST:event_jButtonColorActionPerformed


    ////////////////////////////////////////////////////////////////////////////
    // Setters y Getters
    ////////////////////////////////////////////////////////////////////////////
    /**
     * Devuelve el texto introducido en la Ventana Texto.
     *
     * @return El texto introducido en la Ventana Texto
     * @since 1.6
     */
    public Texto getTexto() {
        return texto;
    }

    /**
     * Establece el texto introducido en la Ventana Texto.
     *
     * @param texto El texto introducido en la Ventana Texto
     * @since 1.6
     */
    public void setTexto(Texto texto) {
        this.texto = texto;
    }

    /**
     * Retorna si se puede o no dibujar el texto.
     *
     * @return Si se puede o no dibujar el texto
     * @since 1.6
     */
    public boolean isDibujaTexto() {
        return dibujaTexto;
    }

    /**
     * Establece true si se puede dibujar el texto; en caso contario, false.
     *
     * @param dibujaTexto True si se puede dibujar el texto; en caso contario, false
     * @since 1.6
     */
    public void setDibujaTexto(boolean dibujaTexto) {
        this.dibujaTexto = dibujaTexto;
    }

    /**
     * Muestra la ventana Color.
     * @since 1.6
     */
    public void mostrarVentanaColor() {
        if (ventanaColor == null) {
            ventanaColor = new VentanaColor(null, rootPaneCheckingEnabled);
            ventanaColor.setLocationRelativeTo(this);
        }
        ventanaColor.setVisible(true);
    }

    /**
     * Retorna la fuente dependiendo de lo que se selecciono en el combobox, dependiendo
     * las opciones establecidas.
     *
     * @param indice El numero de opciones para elegir
     * @return La fuente dependiendo de lo que se selecciono en el combobox
     * @since 1.6
     */
    public String seleccionarTipoFuente(int indice){
        // Como valor predeterminado
        String tipoFuente = "Dialog";

        switch(indice){
            case 1:
                tipoFuente = "Serif";
                break;
            case 2:
                tipoFuente = "SansSerif";
                break;
            case 3:
                tipoFuente = "Monospaced";
                break;
            case 4:
                tipoFuente = "Dialog";
                break;
            case 5:
                tipoFuente = "DialogInput";
                break;
        }
        return tipoFuente;
    }

   /**
    * Donde se ejecuta el programa.
    *
    * @param args La linea de argumentos del comando
    * @since 1.6
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                VentanaTexto dialog = new VentanaTexto(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonColor;
    private javax.swing.JComboBox jComboBoxTipoEstilo;
    private javax.swing.JComboBox jComboBoxTipoFuentes;
    private javax.swing.JLabel jLabelEstilo;
    private javax.swing.JLabel jLabelIntroduzcaTexto;
    private javax.swing.JLabel jLabelTamañoTexto;
    private javax.swing.JLabel jLabelTipolFuente;
    private javax.swing.JPanel jPanelTextPanel;
    private javax.swing.JSpinner jSpinnerTamañoTexto;
    private javax.swing.JTextField jTextFieldTexto;
    // End of variables declaration//GEN-END:variables

}