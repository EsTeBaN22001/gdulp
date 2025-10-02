package Views;

import Views.Alumno.AgregarAlumno;
import Views.Alumno.BorrarAlumno;
import Views.Alumno.BuscarAlumno;

public class Index extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Index.class.getName());
    
    public Index() {
        initComponents();
        setSize(775, 655);
        
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jAgregarAlumno = new javax.swing.JMenuItem();
        jBuscarAlumno = new javax.swing.JMenuItem();
        jBorrarAlumno = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 775, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 632, Short.MAX_VALUE)
        );

        jMenu1.setText("Alumno");

        jAgregarAlumno.setText("Agregar Alumno");
        jAgregarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAgregarAlumnoActionPerformed(evt);
            }
        });
        jMenu1.add(jAgregarAlumno);

        jBuscarAlumno.setText("Buscar Alumno");
        jBuscarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBuscarAlumnoActionPerformed(evt);
            }
        });
        jMenu1.add(jBuscarAlumno);

        jBorrarAlumno.setText("Borrar Alumno");
        jBorrarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBorrarAlumnoActionPerformed(evt);
            }
        });
        jMenu1.add(jBorrarAlumno);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Materia");

        jMenuItem2.setText("jMenuItem2");
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jAgregarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAgregarAlumnoActionPerformed
        
        AgregarAlumno agregarAlumno=new AgregarAlumno();
        jDesktopPane1.add(agregarAlumno);
        int x=(jDesktopPane1.getWidth()-agregarAlumno.getWidth())/2;
        int y=(jDesktopPane1.getHeight()-agregarAlumno.getHeight())/2;
        agregarAlumno.setLocation(x, y);
        agregarAlumno.setVisible(true);
        
    }//GEN-LAST:event_jAgregarAlumnoActionPerformed

    private void jBuscarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBuscarAlumnoActionPerformed
        
        BuscarAlumno buscarAlumno=new BuscarAlumno();
        jDesktopPane1.add(buscarAlumno);
        int x=(jDesktopPane1.getWidth()-buscarAlumno.getWidth())/2;
        int y=(jDesktopPane1.getHeight()-buscarAlumno.getHeight())/2;
        buscarAlumno.setLocation(x, y);
        buscarAlumno.setVisible(true);
        
    }//GEN-LAST:event_jBuscarAlumnoActionPerformed

    private void jBorrarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBorrarAlumnoActionPerformed
        
        BorrarAlumno borrarAlumno=new BorrarAlumno();
        jDesktopPane1.add(borrarAlumno);
        int x=(jDesktopPane1.getWidth()-borrarAlumno.getWidth())/2;
        int y=(jDesktopPane1.getHeight()-borrarAlumno.getHeight())/2;
        borrarAlumno.setLocation(x, y);
        borrarAlumno.setVisible(true);
        
    }//GEN-LAST:event_jBorrarAlumnoActionPerformed

    public static void main(String args[]) {
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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(() -> new Index().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jAgregarAlumno;
    private javax.swing.JMenuItem jBorrarAlumno;
    private javax.swing.JMenuItem jBuscarAlumno;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    // End of variables declaration//GEN-END:variables
}
