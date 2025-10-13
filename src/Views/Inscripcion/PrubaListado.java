
package Views.Inscripcion;

import Modelo.Alumno;
import Modelo.Inscripcion;
import Modelo.Materia;
import Persistencia.alumnoData;
import Persistencia.inscripcionData;
import Persistencia.materiaData;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class PrubaListado extends javax.swing.JInternalFrame {
    
    private DefaultTableModel modelo = new DefaultTableModel(
      new String[]{"Id", "Nombre", "Año", "Estado"}, 0
    );
    
    public PrubaListado() {
        
        initComponents();
        setSize(450, 400);
        jTableMaterias.setModel(modelo);
        
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
        
        
        
        
        // Actualiza tabla al cambiar alumno o boton
        jComboAlumno.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
                    actualizarTabla();
                }
            }
        });
        jRadioButtonInscriptas.addActionListener(e -> actualizarTabla());
        jRadioButtonNoInscriptas.addActionListener(e -> actualizarTabla());
        // Actualiza tabla al cambiar alumno o boton
        
        
        actualizarTabla();
        
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMaterias = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
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

        GrupoVerMaterias.add(jRadioButtonInscriptas);
        jRadioButtonInscriptas.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jRadioButtonInscriptas.setSelected(true);
        jRadioButtonInscriptas.setText("Inscriptas");
        jRadioButtonInscriptas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonInscriptasActionPerformed(evt);
            }
        });

        GrupoVerMaterias.add(jRadioButtonNoInscriptas);
        jRadioButtonNoInscriptas.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jRadioButtonNoInscriptas.setText("No Inscriptas");
        jRadioButtonNoInscriptas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonNoInscriptasActionPerformed(evt);
            }
        });

        jTableMaterias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableMaterias);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                .addComponent(jComboAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(23, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboAlumnoActionPerformed
    }//GEN-LAST:event_jComboAlumnoActionPerformed
    private void jRadioButtonInscriptasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonInscriptasActionPerformed
    }//GEN-LAST:event_jRadioButtonInscriptasActionPerformed
    private void jRadioButtonNoInscriptasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonNoInscriptasActionPerformed
    }//GEN-LAST:event_jRadioButtonNoInscriptasActionPerformed
    

    
    
    private void actualizarTabla() {
    
        DefaultTableModel modelo = (DefaultTableModel) jTableMaterias.getModel();
        modelo.setRowCount(0);

        Alumno alumnoSeleccionado = (Alumno) jComboAlumno.getSelectedItem();
        if (alumnoSeleccionado == null) return;
        
        materiaData md = new materiaData();
        ArrayList<Materia> materias = md.obtenerMaterias();
        
        
        ArrayList<Inscripcion> inscripciones = inscripcionData.obtenerInscripcionesPorAlumno(alumnoSeleccionado.getId());
        ArrayList<Integer> idsInscriptas = new ArrayList<>();
        for (Inscripcion i : inscripciones) {
            idsInscriptas.add(i.getMateria().getId());
        }
        
        // MOSTRADORES PARA LA TABLA SI ELIGIO INCRIPTO O NO
        if (jRadioButtonInscriptas.isSelected()) {
            for (Materia m : materias) {
                if (idsInscriptas.contains(m.getId())) {
                    modelo.addRow(new Object[]{
                        m.getId(),
                        m.getNombre(),
                        m.getAño(),
                        m.getEstado() ? "Activa" : "Inactiva"
                    });
                }
            }
        }
        if (jRadioButtonNoInscriptas.isSelected()) {
            for (Materia m : materias) {
                if (!idsInscriptas.contains(m.getId())) {
                    modelo.addRow(new Object[]{
                        m.getId(),
                        m.getNombre(),
                        m.getAño(),
                        m.getEstado() ? "Activa" : "Inactiva"
                    });
                }
            }
        }
        // MOSTRADORES PARA LA TABLA SI ELIGIO INCRIPTO O NO
    }
    
    
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableMaterias;
    // End of variables declaration//GEN-END:variables
}

/*
             /\_/\           ___
            = o_o =_______    \ \
             __^      __(  \.__) )
         (@)<_____>__(_____)____/
*/


    
