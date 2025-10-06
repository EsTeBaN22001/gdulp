package Views;

import Views.Alumno.FormularioAlumno;
import Views.Materia.FormularioMateria;

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
        jMenu2 = new javax.swing.JMenu();
        jAgregarMateria = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 775, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 633, Short.MAX_VALUE)
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
        
        FormularioAlumno agregarAlumno=new FormularioAlumno();
        jDesktopPane1.add(agregarAlumno);
        int x=(jDesktopPane1.getWidth()-agregarAlumno.getWidth())/2;
        int y=(jDesktopPane1.getHeight()-agregarAlumno.getHeight())/2;
        agregarAlumno.setLocation(x, y);
        agregarAlumno.setVisible(true);
        
    }//GEN-LAST:event_jAgregarAlumnoActionPerformed

    private void jAgregarMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAgregarMateriaActionPerformed
        
        FormularioMateria agregarMateria=new FormularioMateria();
        jDesktopPane1.add(agregarMateria);
        int x=(jDesktopPane1.getWidth()-agregarMateria.getWidth())/2;
        int y=(jDesktopPane1.getHeight()-agregarMateria.getHeight())/2;
        agregarMateria.setLocation(x, y);
        agregarMateria.setVisible(true);
        
    }//GEN-LAST:event_jAgregarMateriaActionPerformed

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
    private javax.swing.JMenuItem jAgregarMateria;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}

/*
             /\_/\           ___
            = o_o =_______    \ \
             __^      __(  \.__) )
         (@)<_____>__(_____)____/
*/
