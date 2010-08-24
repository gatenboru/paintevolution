/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PanelDibujo.java
 *
 * Created on 23/07/2010, 12:22:44 AM
 */

package GUI;

import Auxiliar.Constantes;
import Auxiliar.FiltroArchivo;
import Figuras.Circulo;
import Figuras.Figura;
import Figuras.Linea;
import Figuras.Ovalo;
import Figuras.Rectangulo;
import Figuras.RectanguloConCurvasRedondas;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Stroke;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.Stack;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author fires
 */
public class PanelDibujo extends javax.swing.JPanel implements Serializable, Printable{
    // Constantes
    private final static int CIRCULO = 1, RECTANGULO = 2, OVALO = 3,
            RECTANGULO_CON_CURVAS_REDONDAS = 4, PINCEL = 5, LINEA = 6, LAPIZ = 7,
            ARRASTRAR = 10, NULO = 0;
    
    private int coordenadasInicioX, coordenadasFinX;
    private int coordenadasInicioY, coordenadasFinY;
    private int modoDibujar;
    private int lineaX1, lineaX2, lineaY1, lineaY2;
    private Color colorFondoPantallaDibujo;
    private Color colorBorde;
    private Color colorRelleno;
    private float tamanioBorde;
    private File nombreArchivo;

    private boolean conRelleno = false;

    // La imagen que se mostrará
    private BufferedImage imagen;

    // Escala por defecto de la imagen
    private double escala = 1.0;

    private Cursor cursorActual;
    
    /**
     * Lista de figuras a dibujar.
     */
    private LinkedList<Figura> listaFiguras = new LinkedList<Figura>();

    /**
     * Si actualmente se está arrastrando o no el rectángulo.
     */
    private Figura figuraArrastrandose = null;

     /**
     * x en la que estaba anteriormente el ratón.
     */
    private int xAnteriorRaton;

    /**
     * y en la que estaba anteriormente el ratón
     */
    private int yAnteriorRaton;

    private Stack desHacerPila, reHacerPila;

    // La ubicacion donde se colocará la imagen, si es null, se colocará en el centro
    private Point2D ubicacionDeImagen;

    /** Creates new form PanelDibujo */
    public PanelDibujo() {
        initComponents();
        modoDibujar = 0;
        tamanioBorde = 1.0f;
        nombreArchivo = null;
        desHacerPila = new Stack();
	reHacerPila = new Stack();
        colorFondoPantallaDibujo    = Color.WHITE;          // De color blanco
        colorBorde                  = Color.BLACK;          // De color negro
        colorRelleno                = Color.WHITE;          // De color blanco
        setBackground(colorFondoPantallaDibujo);
        repaint();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 810, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 471, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        setCoordenadasInicioX(evt.getX());
        setLineaX1(evt.getX());
        setLineaX2(evt.getX());
        setCoordenadasInicioY(evt.getY());
        setLineaY1(evt.getY());
        setLineaY2(evt.getY());
        GUI_Principal.jLabelCoordenadasPuntero.setText("x: " + evt.getX() + "   y: " + evt.getY());
    }//GEN-LAST:event_formMousePressed

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        if(modoDibujar == LINEA){
            Linea linea = new Linea(getCoordenadasInicioX(), getCoordenadasInicioY(),
                    getCoordenadasFinX(), getCoordenadasFinY(), getColorBorde(), 
                    (int)getTamanioBorde());    
            agregarFigura(linea);
            desHacerPila.push(linea);
        }else if (modoDibujar == CIRCULO){
            double radio = Math.sqrt(Math.pow(getCoordenadasFinX() - getCoordenadasInicioX(),2) +
                        Math.pow(getCoordenadasFinY() - getCoordenadasInicioY(),2));
            Circulo circulo =  new Circulo(getCoordenadasInicioX(), 
                    getCoordenadasInicioY(), (int)radio, getColorBorde(),
                    getColorRelleno(), (int)getTamanioBorde());
            agregarFigura(circulo);
            desHacerPila.push(circulo);
        }else if(modoDibujar == RECTANGULO){
            Rectangulo rectangulo = new Rectangulo(Math.min(getCoordenadasInicioX(), getCoordenadasFinX()),
                        Math.min(getCoordenadasInicioY(), getCoordenadasFinY()),
                        Math.abs(getCoordenadasInicioX() - getCoordenadasFinX()),
                        Math.abs(getCoordenadasInicioY() - getCoordenadasFinY()),
                        getColorBorde(), getColorRelleno(), (int)getTamanioBorde());
            agregarFigura(rectangulo);

            desHacerPila.push(rectangulo);
        }else if(modoDibujar == OVALO){
            Ovalo ovalo = new Ovalo(Math.min(getCoordenadasInicioX(), getCoordenadasFinX()),
                        Math.min(getCoordenadasInicioY(), getCoordenadasFinY()),
                        Math.abs(getCoordenadasInicioX() - getCoordenadasFinX()),
                        Math.abs(getCoordenadasInicioY() - getCoordenadasFinY()),
                        getColorBorde(), getColorRelleno(), (int)getTamanioBorde());
            agregarFigura(ovalo);
            desHacerPila.push(ovalo);
        }else if(modoDibujar == RECTANGULO_CON_CURVAS_REDONDAS){
            RectanguloConCurvasRedondas rectanguloConCurvasRedondas = new RectanguloConCurvasRedondas(
                    Math.min(getCoordenadasInicioX(), getCoordenadasFinX()),
                    Math.min(getCoordenadasInicioY(), getCoordenadasFinY()),
                    Math.abs(getCoordenadasInicioX() - getCoordenadasFinX()),
                    Math.abs(getCoordenadasInicioY() - getCoordenadasFinY()),
                    getColorBorde(), getColorRelleno(), (int)getTamanioBorde());
            agregarFigura(rectanguloConCurvasRedondas);
            desHacerPila.push(rectanguloConCurvasRedondas);
        }
        //crearImagen();
        GUI_Principal.jLabelCoordenadasPuntero.setText("x: " + evt.getX() + "   y: " + evt.getY());
        repaint();
    }//GEN-LAST:event_formMouseReleased

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        setCoordenadasFinX(evt.getX());
        setCoordenadasFinY(evt.getY());
        
         if (modoDibujar == LAPIZ) {
            setLineaX1(getLineaX2());
            setLineaY1(getLineaY2());
            setLineaX2(getCoordenadasFinX());
            setLineaY2(getCoordenadasFinY());

            setTamanioBorde((int)1);
            Linea linea = new Linea(getLineaX1(), getLineaY1(), getLineaX2(),
                    getLineaY2(), getColorBorde(), (int)getTamanioBorde());
            agregarFigura(linea);
            desHacerPila.push(linea);
        }else if (modoDibujar == PINCEL) {
            setLineaX1(getLineaX2());
            setLineaY1(getLineaY2());
            setLineaX2(getCoordenadasFinX());
            setLineaY2(getCoordenadasFinY());

            Linea linea = new Linea(getLineaX1(), getLineaY1(), getLineaX2(),
                    getLineaY2(), getColorBorde(), (int)getTamanioBorde());
            agregarFigura(linea);
            desHacerPila.push(linea);
        }
        /**
         * Método al que se llama cuando se arrastra el ratón.
         * Se comprueba con el atributo arrastrando si está empezando el arrastre o
         * ya se esta en medio del mismo.
         * Si se comienza el arrastre, se guardan las coordenadas del ratón que
         * vienen en el evento MouseEvent y se cambia el valor del atributo arrastrando.
         * Si se está en medio de un arrastre, se calcula la nueva posición del
         * rectángulo y se llama al método repaint() para que se pinte.
         *
         * @param e Evento del ratón
        */
        if(modoDibujar == ARRASTRAR){
            // Si comienza el arrastre
            if (figuraArrastrandose == null){
                // Se guardan las posiciones del ratón
                xAnteriorRaton = evt.getX();
                yAnteriorRaton = evt.getY();

                // y se marca que ha comenzado el arrastre.
                figuraArrastrandose = dameFigura(evt);
            }else{
                // Si ya había empezado el arrastre, se calculan las nuevas
                // coordenadas del rectángulo
                figuraArrastrandose.setPosicion((int)figuraArrastrandose.getInicio().getX()
                        + (evt.getX() - xAnteriorRaton), (int)figuraArrastrandose.getInicio().getY()
                        + (evt.getY() - yAnteriorRaton));

                // Se guarda la posición del ratón para el siguiente cálculo
                xAnteriorRaton = evt.getX();
                yAnteriorRaton = evt.getY();

                // y se manda repintar el Canvas
                repaint();
            }
        }
        GUI_Principal.jLabelCoordenadasPuntero.setText("x: " + evt.getX() + "   y: " + evt.getY());
        repaint();
    }//GEN-LAST:event_formMouseDragged

    /**
     * El ratón se mueve sin arrastrar. Se marca fin de arrastre.
     *
     * @param e MouseEvent
     */
    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        figuraArrastrandose = null;
        GUI_Principal.jLabelCoordenadasPuntero.setText("x: " + evt.getX() + "   y: " + evt.getY());
    }//GEN-LAST:event_formMouseMoved

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        GUI_Principal.jLabelCoordenadasPuntero.setText("");
    }//GEN-LAST:event_formMouseExited

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        setCursor(getCursorActual());
    }//GEN-LAST:event_formMouseEntered

    ////////////////////////////////////////////////////////////////////////////
    // Metodos SETTERS y GETTERS
    ////////////////////////////////////////////////////////////////////////////
    /*----------------------------------------------------------------------------*/
    public int getCoordenadasFinX() {
        return coordenadasFinX;
    }

    /*----------------------------------------------------------------------------*/
    public void setCoordenadasFinX(int coordenadasFinX) {
        this.coordenadasFinX = coordenadasFinX;
    }

    /*----------------------------------------------------------------------------*/
    public int getCoordenadasFinY() {
        return coordenadasFinY;
    }

    /*----------------------------------------------------------------------------*/
    public void setCoordenadasFinY(int coordenadasFinY) {
        this.coordenadasFinY = coordenadasFinY;
    }

    /*----------------------------------------------------------------------------*/
    public int getCoordenadasInicioX() {
        return coordenadasInicioX;
    }

    /*----------------------------------------------------------------------------*/
    public void setCoordenadasInicioX(int coordenadasInicioX) {
        this.coordenadasInicioX = coordenadasInicioX;
    }

    /*----------------------------------------------------------------------------*/
    public int getCoordenadasInicioY() {
        return coordenadasInicioY;
    }

    /*----------------------------------------------------------------------------*/
    public void setCoordenadasInicioY(int coordenadasInicioY) {
        this.coordenadasInicioY = coordenadasInicioY;
    }

    /*----------------------------------------------------------------------------*/
    public int getDrawMode() {
        return modoDibujar;
    }

    /*----------------------------------------------------------------------------*/
    public void setDrawMode(int drawMode) {
        this.modoDibujar = drawMode;
    }

    /*----------------------------------------------------------------------------*/
    public Color getColorBorde() {
        return colorBorde;
    }

    /*----------------------------------------------------------------------------*/
    public void setColorBorde(Color colorBorde) {
        this.colorBorde = colorBorde;
    }

    /*----------------------------------------------------------------------------*/
    public Color getColorFondoPantallaDibujo() {
        return colorFondoPantallaDibujo;
    }

    /*----------------------------------------------------------------------------*/
    public void setColorFondoPantallaDibujo(Color colorFondoPantallaDibujo) {
        this.colorFondoPantallaDibujo = colorFondoPantallaDibujo;
    }

    /*----------------------------------------------------------------------------*/
    public Color getColorRelleno() {
        return colorRelleno;
    }

    /*----------------------------------------------------------------------------*/
    public void setColorRelleno(Color colorRelleno) {
        this.colorRelleno = colorRelleno;
    }

    /*----------------------------------------------------------------------------*/
    public float getTamanioBorde() {
        return tamanioBorde;
    }

    /*----------------------------------------------------------------------------*/
    public void setTamanioBorde(float tamanioBorde) {
        if(tamanioBorde >= Constantes.MINIMO_GROSOR_BORDE
                &&  tamanioBorde <= Constantes.MAXIMO_GROSOR_BORDE){
           this.tamanioBorde = tamanioBorde;
        }
    }

    /*----------------------------------------------------------------------------*/
    // Retorna la escala actual de la imagen
    public double getEscala(){
        return escala;
    }

    /*----------------------------------------------------------------------------*/
    // Asigna la escala actual de la imagen
    public void setEscala(double escala){
        if(imagen != null){
            //double anteriorEscala = this.escala;

            this.escala = escala;
           // this.firePropertyChange("escala", anteriorEscala, escala);
            repaint();
        }
    }

    /*----------------------------------------------------------------------------*/
    public Cursor getCursorActual() {
        return cursorActual;
    }

    /*----------------------------------------------------------------------------*/
    public void setCursorActual(Cursor cursorActual) {
        this.cursorActual = cursorActual;
    }

    /*----------------------------------------------------------------------------*/
    // Retorna la ubicacion actual de la imagen dentro del panel
    public Point2D getUbicacionDeImagen(){
        return ubicacionDeImagen;
    }

    /*----------------------------------------------------------------------------*/
    // Asigna la ubicacion de la imagen dentro del panel
    public void setUbicacionDeImagen(Point2D imageLocation){
        this.ubicacionDeImagen = imageLocation;
        repaint();              // Vuelve a dibujar la imagen en la ubicacion especificada
    }

    /*----------------------------------------------------------------------------*/
    public int getLineaX1() {
        return lineaX1;
    }

    /*----------------------------------------------------------------------------*/
    public void setLineaX1(int lineaX1) {
        this.lineaX1 = lineaX1;
    }

    /*----------------------------------------------------------------------------*/
    public int getLineaX2() {
        return lineaX2;
    }

    /*----------------------------------------------------------------------------*/
    public void setLineaX2(int lineaX2) {
        this.lineaX2 = lineaX2;
    }

    /*----------------------------------------------------------------------------*/
    public int getLineaY1() {
        return lineaY1;
    }

    /*----------------------------------------------------------------------------*/
    public void setLineaY1(int lineaY1) {
        this.lineaY1 = lineaY1;
    }

    /*----------------------------------------------------------------------------*/
    public int getLineaY2() {
        return lineaY2;
    }

    /*----------------------------------------------------------------------------*/
    public void setLineaY2(int lineaY2) {
        this.lineaY2 = lineaY2;
    }

    /*----------------------------------------------------------------------------*/
    public boolean isConRelleno() {
        return conRelleno;
    }

    /*----------------------------------------------------------------------------*/
    public void setConRelleno(boolean conRelleno) {
        this.conRelleno = conRelleno;
    }

    /*----------------------------------------------------------------------------*/
    public int getModoDibujar() {
        return modoDibujar;
    }

    /*----------------------------------------------------------------------------*/
    public void setModoDibujar(int modoDibujar) {
        this.modoDibujar = modoDibujar;
    }

    /*----------------------------------------------------------------------------*/
    // Retorna la imagen actual
    public BufferedImage getImagen(){
        return imagen;
    }

    /*----------------------------------------------------------------------------*/
    // Establece la imagen actual
    public void setImagen(Image imagen){
        //Image old = this.getImagenActual();                   // Imagen anterior
        this.imagen = (BufferedImage) imagen;                   // Imagen actual
        setUbicacionDeImagen(null);                             // Se centra la imagen en el medio del panel
        redimensionar();                                        // Se escala la imagen para que quepe en el panel
        repaint();                                              // Se dibuja la nueva imagen
        //firePropertyChange("imagenActual", old, this.imagenActual);    // Se dispara un evento de cambio de propiedad
    }

    /*----------------------------------------------------------------------------*/
    // Asigna la imagen actual mediante un archivo
    public void setImagen(File file) throws IOException{
        setImagen(ImageIO.read(file));
    }
    
    
    // Metodos varios
    /**
     * Añada una figura a la lista de figuras a dibujar
     *
     * @param figura Una nueva figura a dibujar
     */
    public void agregarFigura(Figura figura){
        listaFiguras.add(figura);
    }

    /**
     * Quita la figura en la lista de figuras a dibujar.
     *
     * @param figura figura a quitar de la lista.
     */
    public void eliminarFigura(Figura figura){
        listaFiguras.remove(figura);
    }


    /**
     * Para ver si el ratón está dentro del rectángulo.
     * Si está dentro, puede comenzar el arrastre.
     *
     * @param e El evento de ratón
     *
     * @return true si el ratón está dentro del rectángulo
     */
    private Figura dameFigura(MouseEvent e){
        for (Figura figura : listaFiguras){
            if (figura.estaDentro(e.getX(), e.getY())){
                return figura;
            }
        }
        return null;
    }

    /*----------------------------------------------------------------------------*/
    // Redimensiona la imagen para que quepe dentro del panel, si la imagen es mas pequeña
    // que el panel, la deja en su escala por defecto
    public void redimensionar(){
        if(imagen.getHeight(this) > tamañoVisor().getHeight()){
            double visor = tamañoVisor().getHeight();
            double imagen = this.imagen.getHeight(this);
            double escala = visor/imagen;// calculo de escala
            setEscala(escala);
        }else{
            setEscala(1.0);
        }
    }

    /*----------------------------------------------------------------------------*/
    // Retorna el tamaño del visor de imagenes
    private Dimension tamañoVisor(){
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int largo = d.width - 10;
        int ancho = d.height - 188;
        d.setSize(largo, ancho);
        return d;
    }

    /**
     * Dibuja
     *
     * @param g Graphics con el que dibujar.
     */
    @Override
    public void paint(Graphics g){
        super.paintComponent(g);

        setBackground(getColorFondoPantallaDibujo());
        if (getImagen() != null){
            Point2D center = new Point2D.Double(getWidth() / 2, getHeight() / 2);
            if (getUbicacionDeImagen() != null){
                center = getUbicacionDeImagen();
            }
            Point2D loc = new Point2D.Double();
            double width = imagen.getWidth(null) * getEscala();
            double height = imagen.getHeight(null) * getEscala();
            loc.setLocation(center.getX() - width / 2, center.getY() - height / 2);
            setColorFondoPantallaDibujo(getColorFondoPantallaDibujo());
            g.drawImage(getImagen(), (int) loc.getX(), (int) loc.getY(),(int) width, (int) height, null);
        }

        
        dibujarFiguras(g);
        setBackground(getColorFondoPantallaDibujo());
        g.setColor(getColorBorde());
        Graphics2D g2;
        
        if (modoDibujar == LINEA) {
            Line2D line2D = new Line2D.Float(getCoordenadasInicioX(),
                    getCoordenadasInicioY(), getCoordenadasFinX(), getCoordenadasFinY());
            g2 = (Graphics2D)g;
            Stroke bordeFigura = new BasicStroke(getTamanioBorde(),  BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);
            g2.setColor(getColorBorde());
            g2.setStroke(bordeFigura);
            g2.draw(line2D);
      	}

      	if (modoDibujar == OVALO){
            if(conRelleno){
                g.fillOval(Math.min(getCoordenadasInicioX(), getCoordenadasFinX()),
                        Math.min(getCoordenadasInicioY(), getCoordenadasFinY()),
                        Math.abs(getCoordenadasInicioX() - getCoordenadasFinX()),
                        Math.abs(getCoordenadasInicioY() - getCoordenadasFinY()));
            }
            Ellipse2D e2;
            Stroke bordeFigura;

            e2 = new Ellipse2D.Float(Math.min(getCoordenadasInicioX(), getCoordenadasFinX()),
                    Math.min(getCoordenadasInicioY(), getCoordenadasFinY()),
                    Math.abs(getCoordenadasInicioX() - getCoordenadasFinX()),
                    Math.abs(getCoordenadasInicioY() - getCoordenadasFinY()));
            g2 = (Graphics2D)g;
            bordeFigura = new BasicStroke(getTamanioBorde(),  BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);
            g2.setColor(getColorBorde());
            g2.setStroke(bordeFigura);
            g2.draw(e2);
        }

        if (modoDibujar == CIRCULO){
            double radio = Math.sqrt(Math.pow(getCoordenadasFinX() - getCoordenadasInicioX(),2) +
                        Math.pow(getCoordenadasFinY() - getCoordenadasInicioY(),2));
            if(conRelleno){
                 g.fillOval(getCoordenadasInicioX() - (int)radio, getCoordenadasInicioY() - (int)radio,
                    (int)radio * 2 , (int)radio * 2);
                }
                Ellipse2D e2;
                Stroke bordeFigura;

                e2 = new Ellipse2D.Float(getCoordenadasInicioX() - (int)radio, getCoordenadasInicioY() - (int)radio,
                    (int)radio * 2 , (int)radio * 2);
                g2 = (Graphics2D)g;
                bordeFigura = new BasicStroke(getTamanioBorde(),  BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);
                g2.setColor(getColorBorde());
                g2.setStroke(bordeFigura);
                g2.draw(e2);
        }

        if (modoDibujar == RECTANGULO_CON_CURVAS_REDONDAS){
            if(conRelleno){
                g.fillRoundRect(Math.min(getCoordenadasInicioX(), getCoordenadasFinX()),
                        Math.min(getCoordenadasInicioY(), getCoordenadasFinY()),
                        Math.abs(getCoordenadasInicioX() - getCoordenadasFinX()),
                        Math.abs(getCoordenadasInicioY() - getCoordenadasFinY()), 25, 25);
            }
            RoundRectangle2D rr2;
            Stroke bordeFigura;
            rr2 = new RoundRectangle2D.Float(Math.min(getCoordenadasInicioX(), getCoordenadasFinX()),
                        Math.min(getCoordenadasInicioY(), getCoordenadasFinY()),
                        Math.abs(getCoordenadasInicioX() - getCoordenadasFinX()),
                        Math.abs(getCoordenadasInicioY() - getCoordenadasFinY()), 25, 25);
            g2 = (Graphics2D)g;
            bordeFigura = new BasicStroke(getTamanioBorde(), BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);
            g2.setColor(getColorBorde());
            g2.setStroke(bordeFigura);
            g2.draw(rr2);
      	}


      	if (modoDibujar == RECTANGULO){
            if(conRelleno){
                 g.fillRect(Math.min(getCoordenadasInicioX(), getCoordenadasFinX()),
                        Math.min(getCoordenadasInicioY(), getCoordenadasFinY()),
                        Math.abs(getCoordenadasInicioX() - getCoordenadasFinX()),
                        Math.abs(getCoordenadasInicioY() - getCoordenadasFinY()));
            }
            Rectangle2D r2;
            Stroke bordeFigura;
            r2 = new Rectangle2D.Float(Math.min(getCoordenadasInicioX(), getCoordenadasFinX()),
                        Math.min(getCoordenadasInicioY(), getCoordenadasFinY()),
                        Math.abs(getCoordenadasInicioX() - getCoordenadasFinX()),
                        Math.abs(getCoordenadasInicioY() - getCoordenadasFinY()));
            g2 = (Graphics2D)g;
            bordeFigura = new BasicStroke(getTamanioBorde(), BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);
            g2.setColor(getColorBorde());
            g2.setStroke(bordeFigura);
            g2.draw(r2);
      	}
    }

    /*----------------------------------------------------------------------------*/
    public void deshacer(){
        if(desHacerPila.isEmpty()){
            JOptionPane.showMessageDialog(null, "Ya no se puede deshacer",
                    Constantes.TITULO_PROGRAMA,
                    JOptionPane.INFORMATION_MESSAGE);
        }else{
            Figura objeto = (Figura) desHacerPila.pop();
        }          
        repaint();
    }

    /*----------------------------------------------------------------------------*/
    public void rehacer(){
        if(reHacerPila.isEmpty()){
            JOptionPane.showMessageDialog(null,"No hay algo que rehacer",
                    Constantes.TITULO_PROGRAMA,
                    JOptionPane.INFORMATION_MESSAGE);
        }else{
            //desHacerPila.push();
        }
        repaint();
    }

    /*----------------------------------------------------------------------------*/
    // Metodo que borra todos los elementos de la pantalla
    public void borrarTodo(){
        listaFiguras.clear();
        desHacerPila.clear();
        reHacerPila.clear();
        imagen = null;
        setModoDibujar(0);
        repaint();
    }

    /*----------------------------------------------------------------------------*/
    public void guardarImagen(){
        if(nombreArchivo != null){
            crearImagen();

            try{
                JOptionPane.showMessageDialog(null,"Archivo guardado",
                        Constantes.TITULO_PROGRAMA,
                        JOptionPane.INFORMATION_MESSAGE);
            }catch(Exception e){
                System.out.println(e.getMessage());
            }

            try{
                File file = new File(nombreArchivo.toString() + ".png");
                ImageIO.write(imagen, "png", file);
            }catch (IOException e) {
                 System.out.println(e.getMessage());
            }
	}
	else{
            guardarComoImagen();
	}
	//repaint();
    }

    /*----------------------------------------------------------------------------*/
    public void guardarComoImagen(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setFileSelectionMode(0);
        fileChooser.setFileFilter(new FiltroArchivo());
        int resultado = fileChooser.showSaveDialog(null);

        if(resultado == JFileChooser.CANCEL_OPTION)
            return;
        nombreArchivo = fileChooser.getSelectedFile();

        if(nombreArchivo == null || nombreArchivo.getName().equals(""))
            JOptionPane.showMessageDialog(null,"Nombre de archivo inválido",
                    Constantes.TITULO_PROGRAMA,
                    JOptionPane.ERROR_MESSAGE);
        else{
            crearImagen();   
             

            try{
                JOptionPane.showMessageDialog(null,"Archivo Guardado",Constantes.TITULO_PROGRAMA,
                        JOptionPane.INFORMATION_MESSAGE);

            }catch(Exception e){
                System.out.println(e.getMessage());
            }

             try {
                File file = new File(nombreArchivo.toString() + ".png");
                ImageIO.write(imagen, "png", file);
            }catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
	//repaint();
    }


    /*----------------------------------------------------------------------------*/
    public void abrirImagen(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setMultiSelectionEnabled(true);
        fileChooser.setFileFilter(new FiltroArchivo());

        int result = fileChooser.showOpenDialog(null);
        if(result == JFileChooser.CANCEL_OPTION)
            return;

        nombreArchivo = fileChooser.getSelectedFile();

        if(nombreArchivo != null){
            try{

                BufferedImage image = ImageIO.read(nombreArchivo);
                imagen = ImageIO.read(nombreArchivo);
                setImagen(nombreArchivo);

                Graphics g = image.getGraphics();
                setColorFondoPantallaDibujo(Color.WHITE);
                g.drawImage(image, 0, 0, this);
            }catch(Exception exp){
                JOptionPane.showMessageDialog(null,"No se puede abrir el archivo",
                        Constantes.TITULO_PROGRAMA,
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }else{
            nombreArchivo = null;
	}
        repaint();
    }

    /*----------------------------------------------------------------------------*/
    // Metodo que crea la imagen
    public void crearImagen() {
        // Variables
        int largo = Constantes.MAXIMO_LARGO_PANTALLA_DIBUJO;
        int ancho = Constantes.MAXIMO_ANCHO_PANTALLA_DIBUJO;

        // Objetos
        imagen = new BufferedImage(largo, ancho, BufferedImage.TYPE_INT_RGB);

        Graphics g = imagen.createGraphics();
        g.setColor(getColorFondoPantallaDibujo());
        g.fillRect(0, 0, largo, ancho);
        dibujarFiguras(g);
        g.dispose();
    }

    /*----------------------------------------------------------------------------*/
    // Metodo para acerca la Imagen Actual
    public void acercar(){
        setEscala(getEscala() * 1.09);
    }

    /*----------------------------------------------------------------------------*/
    // Metodo para alejar la Imagen Actual
    public void alejar(){
        setEscala(getEscala() * 0.9174311926605505);
    }

    /*----------------------------------------------------------------------------*/
    // Dibuja todas las figuras de la lista
    public void dibujarFiguras(Graphics g){
        for (Figura figura : listaFiguras){
            figura.dibujar(g);
        }
    }

    /*----------------------------------------------------------------------------*/
    // Este es el metodo que se encarga de la impresion
    @Override
    public int print(Graphics g, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if( pageIndex >= 1 ) {
            return( Printable.NO_SUCH_PAGE );
        }
        Graphics2D g2 = (Graphics2D)g;
        g2.translate( pageFormat.getImageableX(), pageFormat.getImageableY() );
        paint( g2 );
        return( Printable.PAGE_EXISTS );
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
