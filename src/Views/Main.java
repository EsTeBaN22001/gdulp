package Views;

import Views.Alumno.FormularioAlumno;
import Views.Inscripcion.CargaNotas;
import Views.Inscripcion.InscripcionViews;
import Views.Inscripcion.ListarInscripciones;
import Views.Materia.FormularioMateria;

public class Main extends javax.swing.JFrame{

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Main.class.getName());

    public Main(){
        initComponents();
        setSize(830, 800);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jImgFondo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jAgregarAlumno = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jAgregarMateria = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jInscripcion = new javax.swing.JMenuItem();
        jCargaNotas = new javax.swing.JMenuItem();
        jListarInscripciones = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jImgFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Fondo.jpg"))); // NOI18N

        jDesktopPane1.setLayer(jImgFondo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jImgFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jImgFondo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jMenu1.setText("Alumno");

        jAgregarAlumno.setText("Formulario Alumno");
        jAgregarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAgregarAlumnoActionPerformed(evt);
            }
        });
        jMenu1.add(jAgregarAlumno);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Materia");

        jAgregarMateria.setText("Formulario Materia");
        jAgregarMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAgregarMateriaActionPerformed(evt);
            }
        });
        jMenu2.add(jAgregarMateria);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Inscripcion");

        jInscripcion.setText("Inscripcion");
        jInscripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jInscripcionActionPerformed(evt);
            }
        });
        jMenu3.add(jInscripcion);

        jCargaNotas.setText("CargaNotas");
        jCargaNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCargaNotasActionPerformed(evt);
            }
        });
        jMenu3.add(jCargaNotas);

        jListarInscripciones.setText("Listar Inscripciones");
        jListarInscripciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jListarInscripcionesActionPerformed(evt);
            }
        });
        jMenu3.add(jListarInscripciones);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jAgregarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAgregarAlumnoActionPerformed

        FormularioAlumno agregarAlumno = new FormularioAlumno();
        jDesktopPane1.add(agregarAlumno);
        int x = (jDesktopPane1.getWidth() - agregarAlumno.getWidth()) / 2;
        int y = (jDesktopPane1.getHeight() - agregarAlumno.getHeight()) / 2;
        agregarAlumno.setLocation(x, y);
        agregarAlumno.setVisible(true);

    }//GEN-LAST:event_jAgregarAlumnoActionPerformed

    private void jAgregarMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAgregarMateriaActionPerformed

        FormularioMateria agregarMateria = new FormularioMateria();
        jDesktopPane1.add(agregarMateria);
        int x = (jDesktopPane1.getWidth() - agregarMateria.getWidth()) / 2;
        int y = (jDesktopPane1.getHeight() - agregarMateria.getHeight()) / 2;
        agregarMateria.setLocation(x, y);
        agregarMateria.setVisible(true);

    }//GEN-LAST:event_jAgregarMateriaActionPerformed

    private void jInscripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jInscripcionActionPerformed
        InscripcionViews inscripcion = new InscripcionViews();
        jDesktopPane1.add(inscripcion);
        int x = (jDesktopPane1.getWidth() - inscripcion.getWidth()) / 2;
        int y = (jDesktopPane1.getHeight() - inscripcion.getHeight()) / 2;
        inscripcion.setLocation(x, y);
        inscripcion.setVisible(true);
    }//GEN-LAST:event_jInscripcionActionPerformed

    private void jCargaNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCargaNotasActionPerformed
        CargaNotas cargaNotas = new CargaNotas();
        jDesktopPane1.add(cargaNotas);
        int x = (jDesktopPane1.getWidth() - cargaNotas.getWidth()) / 2;
        int y = (jDesktopPane1.getHeight() - cargaNotas.getHeight()) / 2;
        cargaNotas.setLocation(x, y);
        cargaNotas.setVisible(true);
    }//GEN-LAST:event_jCargaNotasActionPerformed

    private void jListarInscripcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jListarInscripcionesActionPerformed
        ListarInscripciones listarInscripciones = new ListarInscripciones();
        jDesktopPane1.add(listarInscripciones);
        int x = (jDesktopPane1.getWidth() - listarInscripciones.getWidth()) / 2;
        int y = (jDesktopPane1.getHeight() - listarInscripciones.getHeight()) / 2;
        listarInscripciones.setLocation(x, y);
        listarInscripciones.setVisible(true);
    }//GEN-LAST:event_jListarInscripcionesActionPerformed

    public static void main(String args[]){
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try{
            for( javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels() ){
                if( "Nimbus".equals(info.getName()) ){
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch( ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex ){
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(() -> new Main().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jAgregarAlumno;
    private javax.swing.JMenuItem jAgregarMateria;
    private javax.swing.JMenuItem jCargaNotas;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jImgFondo;
    private javax.swing.JMenuItem jInscripcion;
    private javax.swing.JMenuItem jListarInscripciones;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}

/*
             /\_/\           ___
            = o_o =_______    \ \
             __^      __(  \.__) )
         (@)<_____>__(_____)____/
 */
