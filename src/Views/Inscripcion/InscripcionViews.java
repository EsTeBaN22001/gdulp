
package Views.Inscripcion;

import Modelo.Alumno;
import Persistencia.alumnoData;

public class InscripcionViews extends javax.swing.JInternalFrame {
    
    public InscripcionViews() {
        
        initComponents();
        setSize(450, 400);
        
        
        // constructor Del Combo box Para solo mostrar el nombre y apellido d:/
        jComboAlumno.setRenderer(new javax.swing.DefaultListCellRenderer() {
            @Override
            public java.awt.Component getListCellRendererComponent(javax.swing.JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Alumno alumno) {
                    setText(alumno.getNombreCompleto());
                }
                return this;
            }
        });
        // constructor Del Combo box Para solo mostrar el nombre y apellido d:/
        
        
        cargarCombo();
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GrupoVerMaterias = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jComboAlumno = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jRadioButtonInscriptas = new javax.swing.JRadioButton();
        jRadioButtonNoInscriptas = new javax.swing.JRadioButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("InscripcionViews");

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel1.setText("Elija un Alumno:");

        jComboAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboAlumnoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel2.setText("Ver:");

        jRadioButtonInscriptas.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jRadioButtonInscriptas.setText("Inscriptas");
        jRadioButtonInscriptas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonInscriptasActionPerformed(evt);
            }
        });

        jRadioButtonNoInscriptas.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jRadioButtonNoInscriptas.setText("No Inscriptas");
        jRadioButtonNoInscriptas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonNoInscriptasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButtonInscriptas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButtonNoInscriptas))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jComboAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jRadioButtonInscriptas)
                    .addComponent(jRadioButtonNoInscriptas))
                .addContainerGap(272, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboAlumnoActionPerformed
    }//GEN-LAST:event_jComboAlumnoActionPerformed

    private void jRadioButtonInscriptasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonInscriptasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonInscriptasActionPerformed

    private void jRadioButtonNoInscriptasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonNoInscriptasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonNoInscriptasActionPerformed
    
    
    
    
    
    
    
    
    
    
    private void cargarCombo(){
            jComboAlumno.removeAllItems();
            for (Alumno alumno : alumnoData.obtenerTodos()) {
                jComboAlumno.addItem(alumno);
            }
    }
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GrupoVerMaterias;
    private javax.swing.JComboBox<Alumno> jComboAlumno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JRadioButton jRadioButtonInscriptas;
    private javax.swing.JRadioButton jRadioButtonNoInscriptas;
    // End of variables declaration//GEN-END:variables
}

    
