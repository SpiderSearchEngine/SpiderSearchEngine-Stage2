/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.Desktop;
import java.net.URI;
import javax.swing.Icon;
import javax.swing.JLabel;

/**
 *
 * @author Gerald M, Jairo O
 */
public class Buscador extends javax.swing.JFrame {
    private String _ingresadoPorUsuario;
    /**
     * Creates new form Buscador
     */
    public Buscador() {
        this.setSize(900,600);
        setResizable(false);
        setTitle("SpiderSearch Engine");
        initComponents();
        jPanel1.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelFondo = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        TxtBuscador = new javax.swing.JTextField();
        BotonBuscar = new javax.swing.JButton();
        Fondo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(700, 440));
        getContentPane().setLayout(null);

        PanelFondo.setBackground(new java.awt.Color(255, 255, 255));
        PanelFondo.setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 710, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );

        PanelFondo.add(jPanel1);
        jPanel1.setBounds(0, 100, 710, 340);

        TxtBuscador.setName(""); // NOI18N
        TxtBuscador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtBuscadorActionPerformed(evt);
            }
        });
        PanelFondo.add(TxtBuscador);
        TxtBuscador.setBounds(140, 220, 410, 30);

        BotonBuscar.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 11)); // NOI18N
        BotonBuscar.setText("Buscar");
        BotonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonBuscarActionPerformed(evt);
            }
        });
        PanelFondo.add(BotonBuscar);
        BotonBuscar.setBounds(570, 220, 90, 24);

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/hola.png"))); // NOI18N
        Fondo.setText("jLabel1");
        Fondo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FondoMouseClicked(evt);
            }
        });
        PanelFondo.add(Fondo);
        Fondo.setBounds(0, -430, 710, 1300);

        getContentPane().add(PanelFondo);
        PanelFondo.setBounds(0, -10, 710, 450);

        jMenu1.setText("OPCIONES");

        jMenuItem2.setText("Top Busquedas");
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Busquedas Recientes");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtBuscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtBuscadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtBuscadorActionPerformed
    private javax.swing.JLabel texto = new JLabel();
    private javax.swing.JLabel texto1 = new JLabel();
    private javax.swing.JLabel texto2= new JLabel();
    
    public void obtenertexto(){
        setIngresadoPorUsuario(TxtBuscador.getText());
    }
    
    public String getTexto(){
        return _ingresadoPorUsuario;
    }
    
    private void BotonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonBuscarActionPerformed
        obtenertexto();
        TxtBuscador.setLocation(160, 40);
        BotonBuscar.setLocation(590,43);
        Fondo.setBounds(0,0,700, 100);
        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/ger.png")));
        PanelFondo.setBackground(Color.darkGray);
        
        jPanel1.setBackground(Color.DARK_GRAY);
        
        texto.setForeground(Color.WHITE);
        texto1.setForeground(Color.WHITE);
        texto2.setForeground(Color.WHITE);
        
        texto.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textoMouseClicked(evt);
            }
        });
        
        texto1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textoMouseClicked2(evt);
            }
        });
        
        texto2.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textoMouseClicked3(evt);
            }
        });
        texto.setText("<html><a href=''>Resultado 1</a></html>");
        texto1.setText("<html><a>Resultado 2</a></html>");
        texto2.setText("<html><a>Resultado 3</a></html>");
        texto.setBounds(0,0,75,75);
        texto1.setBounds(0,0,150,150);
        texto2.setBounds(0,0,225,225);
        jPanel1.add(texto);
        jPanel1.add(texto1);
        jPanel1.add(texto2);
        texto.setVisible(true);
        jPanel1.setVisible(true);
    }//GEN-LAST:event_BotonBuscarActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void FondoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FondoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_FondoMouseClicked
    private void textoMouseClicked(java.awt.event.MouseEvent evt){
        try {
            if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
                System.out.println(Desktop.getDesktop());
            if (desktop.isSupported(Desktop.Action.OPEN)) {
            desktop.browse(new URI("smb://gerald-tec/carpeta/re.pdf"));
            }
        }
        } catch (Exception e) {
        e.printStackTrace();
        }
    }
    private void textoMouseClicked2(java.awt.event.MouseEvent evt){
        try {
            if (Desktop.isDesktopSupported()) {
            Desktop desktop2 = Desktop.getDesktop();
            System.out.println(Desktop.getDesktop());
            if (desktop2.isSupported(Desktop.Action.BROWSE)) {
            desktop2.browse(new URI("http://www.ncfireprotectiondistrict.org/pdf/holiday_winter/Holiday_Safety_espaniol.pdf"));
            }
        }
        } catch (Exception e) {
        e.printStackTrace();
        }
    }
    private void textoMouseClicked3(java.awt.event.MouseEvent evt){
        try {
            if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            System.out.println(Desktop.getDesktop());
            if (desktop.isSupported(Desktop.Action.OPEN)) {
            desktop.browse(new URI("file:/home/gerald/Documentos/SearsZemanskyFisicaUniversitaria12va.Ed.Solucionario.pdf"));
            }
        }
        } catch (Exception e) {
        e.printStackTrace();
        }
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
            java.util.logging.Logger.getLogger(Buscador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Buscador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Buscador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Buscador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Buscador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonBuscar;
    private javax.swing.JLabel Fondo;
    private javax.swing.JPanel PanelFondo;
    private javax.swing.JTextField TxtBuscador;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the _ingresadoPorUsuario
     */
    public String getIngresadoPorUsuario() {
        return _ingresadoPorUsuario;
    }

    /**
     * @param _ingresadoPorUsuario the _ingresadoPorUsuario to set
     */
    public void setIngresadoPorUsuario(String _ingresadoPorUsuario) {
        this._ingresadoPorUsuario = _ingresadoPorUsuario;
    }
}
