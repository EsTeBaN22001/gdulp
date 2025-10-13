package Views.Inscripcion;

import Modelo.Alumno;
import Modelo.Inscripcion;
import Modelo.Materia;
import Persistencia.alumnoData;
import Persistencia.inscripcionData;
import Persistencia.materiaData;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class InscripcionViews extends javax.swing.JInternalFrame{

    private DefaultTableModel modelo = new DefaultTableModel(
      new String[]{"Id", "Nombre", "Año", "Estado"}, 0
    );

    public InscripcionViews(){

        initComponents();
        setSize(450, 430);
        jTableMaterias.setModel(modelo);

        // constructor Del Combo box Para solo mostrar el nombre y apellido d:/
        jComboAlumno.setRenderer(new javax.swing.DefaultListCellRenderer(){
            @Override
            public java.awt.Component getListCellRendererComponent(javax.swing.JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus){
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if( value instanceof Alumno alumno ){
                    setText(alumno.getNombreCompleto());
                }
                return this;
            }
        });
        // constructor Del Combo box Materia Para solo mostrar el nombre y año d:/
        jComboMateria.setRenderer(new javax.swing.DefaultListCellRenderer(){
            @Override
            public java.awt.Component getListCellRendererComponent(
              javax.swing.JList<?> list, Object value, int index,
              boolean isSelected, boolean cellHasFocus){

                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                if( value instanceof Materia materia ){
                    setText(materia.getNombre() + " (" + materia.getAño() + " año)");
                }

                return this;
            }
        });

        //Carga los combox
        cargarCombo();
        cargarCombo2();

        //DESACTIVA LOS BOTONES
        jButtonInscribirse.setEnabled(false);
        jButtonDardeBaja.setEnabled(true);
        cargarCombo();
        cargarCombo2();

        // Actualiza tabla al cambiar alumno o boton
        jComboAlumno.addItemListener(new java.awt.event.ItemListener(){
            public void itemStateChanged(java.awt.event.ItemEvent evt){
                if( evt.getStateChange() == java.awt.event.ItemEvent.SELECTED ){
                    actualizarTabla();
                    cargarCombo2();
                }
            }
        });

        // Actualizar / Activar o desactivar cuando toque unos de los dos radios
        jRadioButtonInscriptas.addActionListener(e -> {
            jButtonInscribirse.setEnabled(false);
            jButtonDardeBaja.setEnabled(true);
            actualizarTabla();
            cargarCombo2();
        });
        jRadioButtonNoInscriptas.addActionListener(e -> {
            jButtonInscribirse.setEnabled(true);
            jButtonDardeBaja.setEnabled(false);
            actualizarTabla();
            cargarCombo2();
        });

        // Actualiza la tabla
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
        jLabel3 = new javax.swing.JLabel();
        jComboMateria = new javax.swing.JComboBox<>();
        jButtonInscribirse = new javax.swing.JButton();
        jButtonDardeBaja = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("InscripcionViews");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel1.setText("Elija un Alumno:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 26, -1, -1));

        jComboAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboAlumnoActionPerformed(evt);
            }
        });
        getContentPane().add(jComboAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 27, 201, -1));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel2.setText("Ver:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 65, -1, -1));

        GrupoVerMaterias.add(jRadioButtonInscriptas);
        jRadioButtonInscriptas.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jRadioButtonInscriptas.setSelected(true);
        jRadioButtonInscriptas.setText("Inscriptas");
        jRadioButtonInscriptas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonInscriptasActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButtonInscriptas, new org.netbeans.lib.awtextra.AbsoluteConstraints(97, 66, -1, -1));

        GrupoVerMaterias.add(jRadioButtonNoInscriptas);
        jRadioButtonNoInscriptas.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jRadioButtonNoInscriptas.setText("No Inscriptas");
        jRadioButtonNoInscriptas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonNoInscriptasActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButtonNoInscriptas, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 66, -1, -1));

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 104, 392, 170));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel3.setText("Elija Una Materia:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 286, -1, -1));

        jComboMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboMateriaActionPerformed(evt);
            }
        });
        getContentPane().add(jComboMateria, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 287, 225, -1));

        jButtonInscribirse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/guardar.png"))); // NOI18N
        jButtonInscribirse.setText("Inscribirse");
        jButtonInscribirse.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jButtonInscribirse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInscribirseActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonInscribirse, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 331, -1, -1));

        jButtonDardeBaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nuevo.png"))); // NOI18N
        jButtonDardeBaja.setText("Dar de Baja");
        jButtonDardeBaja.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jButtonDardeBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDardeBajaActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonDardeBaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 331, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, 50, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboAlumnoActionPerformed
    }//GEN-LAST:event_jComboAlumnoActionPerformed
    private void jRadioButtonInscriptasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonInscriptasActionPerformed
    }//GEN-LAST:event_jRadioButtonInscriptasActionPerformed
    private void jRadioButtonNoInscriptasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonNoInscriptasActionPerformed
    }//GEN-LAST:event_jRadioButtonNoInscriptasActionPerformed

    // BOTONES
    private void jButtonInscribirseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInscribirseActionPerformed

        Alumno alumnoSeleccionado = (Alumno) jComboAlumno.getSelectedItem();
        Materia materiaSeleccionada = (Materia) jComboMateria.getSelectedItem();

        if( alumnoSeleccionado == null || materiaSeleccionada == null ){
            javax.swing.JOptionPane.showMessageDialog(this,
              "Debe seleccionar un alumno y una materia", "Error",
              javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }

        Inscripcion nuevaInscripcion = new Inscripcion();
        nuevaInscripcion.setAlumno(alumnoSeleccionado);
        nuevaInscripcion.setMateria(materiaSeleccionada);
        nuevaInscripcion.setNota(0);

        Inscripcion resultado = inscripcionData.guardarInscripcion(nuevaInscripcion);

        if( resultado != null ){
            javax.swing.JOptionPane.showMessageDialog(this,
              "Alumno inscrito exitosamente en " + materiaSeleccionada.getNombre(),
              "Exito",
              javax.swing.JOptionPane.INFORMATION_MESSAGE);
            actualizarTabla();
            cargarCombo2();

        } else{
            javax.swing.JOptionPane.showMessageDialog(this,
              "Error al inscribir al alumno", "Error",
              javax.swing.JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButtonInscribirseActionPerformed
    private void jButtonDardeBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDardeBajaActionPerformed

        Alumno alumnoSeleccionado = (Alumno) jComboAlumno.getSelectedItem();
        Materia materiaSeleccionada = (Materia) jComboMateria.getSelectedItem();

        if( alumnoSeleccionado == null || materiaSeleccionada == null ){
            javax.swing.JOptionPane.showMessageDialog(this,
              "Debe seleccionar un alumno y una materia", "Error",
              javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirmar = javax.swing.JOptionPane.showConfirmDialog(this,
          "Seguro de dar de baja a " + alumnoSeleccionado.getNombreCompleto()
          + " de la materia " + materiaSeleccionada.getNombre() + "?",
          "Confirmar baja",
          javax.swing.JOptionPane.YES_NO_OPTION);

        if( confirmar != javax.swing.JOptionPane.YES_OPTION ){
            return;
        }

        ArrayList<Inscripcion> inscripciones = inscripcionData.obtenerInscripcionesPorAlumno(alumnoSeleccionado.getId());
        Inscripcion inscripcionAEliminar = null;

        for( Inscripcion i : inscripciones ){
            if( i.getMateria().getId() == materiaSeleccionada.getId() ){
                inscripcionAEliminar = i;
                break;
            }
        }

        if( inscripcionAEliminar != null ){
            boolean eliminado = inscripcionData.eliminarInscripcion(inscripcionAEliminar.getId());

            if( eliminado ){
                javax.swing.JOptionPane.showMessageDialog(this,
                  "Alumno dado de baja exitosamente de " + materiaSeleccionada.getNombre(),
                  "Exito",
                  javax.swing.JOptionPane.INFORMATION_MESSAGE);
                actualizarTabla();
                cargarCombo2();
            } else{
                javax.swing.JOptionPane.showMessageDialog(this,
                  "Error al dar de baja al alumno", "Error",
                  javax.swing.JOptionPane.ERROR_MESSAGE);
            }

        } else{
            javax.swing.JOptionPane.showMessageDialog(this,
              "No se encontro la inscripcion", "Error",
              javax.swing.JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButtonDardeBajaActionPerformed

    private void jComboMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboMateriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboMateriaActionPerformed

    private void actualizarTabla(){

        DefaultTableModel modelo = (DefaultTableModel) jTableMaterias.getModel();
        modelo.setRowCount(0);

        Alumno alumnoSeleccionado = (Alumno) jComboAlumno.getSelectedItem();
        if( alumnoSeleccionado == null ){
            return;
        }

        materiaData md = new materiaData();
        ArrayList<Materia> materias = md.obtenerMaterias();

        ArrayList<Inscripcion> inscripciones = inscripcionData.obtenerInscripcionesPorAlumno(alumnoSeleccionado.getId());
        ArrayList<Integer> idsInscriptas = new ArrayList<>();
        for( Inscripcion i : inscripciones ){
            idsInscriptas.add(i.getMateria().getId());
        }

        // MOSTRADORES PARA LA TABLA SI ELIGIO INCRIPTO O NO
        if( jRadioButtonInscriptas.isSelected() ){
            for( Materia m : materias ){
                if( idsInscriptas.contains(m.getId()) ){
                    modelo.addRow(new Object[]{
                        m.getId(),
                        m.getNombre(),
                        m.getAño(),
                        m.getEstado() ? "Activa" : "Inactiva"
                    });
                }
            }
        }
        if( jRadioButtonNoInscriptas.isSelected() ){
            for( Materia m : materias ){
                if( !idsInscriptas.contains(m.getId()) ){
                    modelo.addRow(new Object[]{
                        m.getId(),
                        m.getNombre(),
                        m.getAño(),
                        m.getEstado() ? "Activa" : "Inactiva"
                    });
                }
            }
        }
    }

    private void cargarCombo(){
        jComboAlumno.removeAllItems();
        for( Alumno alumno : alumnoData.obtenerTodos() ){
            jComboAlumno.addItem(alumno);
        }
    }

    private void cargarCombo2(){
        jComboMateria.removeAllItems();

        Alumno alumnoSeleccionado = (Alumno) jComboAlumno.getSelectedItem();
        if( alumnoSeleccionado == null ){
            return;
        }

        materiaData md = new materiaData();
        ArrayList<Materia> materias = md.obtenerMaterias();

        ArrayList<Inscripcion> inscripciones = inscripcionData.obtenerInscripcionesPorAlumno(alumnoSeleccionado.getId());

        ArrayList<Integer> idsInscriptas = new ArrayList<>();
        for( Inscripcion i : inscripciones ){
            idsInscriptas.add(i.getMateria().getId());
        }

        // CARGAR COMBO SEGÚN RADIOBUTTON SELECCIONADO
        if( jRadioButtonInscriptas.isSelected() ){
            for( Materia m : materias ){
                if( idsInscriptas.contains(m.getId()) ){
                    jComboMateria.addItem(m);
                }
            }
        } else if( jRadioButtonNoInscriptas.isSelected() ){
            for( Materia m : materias ){
                if( !idsInscriptas.contains(m.getId()) ){
                    jComboMateria.addItem(m);
                }
            }
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GrupoVerMaterias;
    private javax.swing.JButton jButtonDardeBaja;
    private javax.swing.JButton jButtonInscribirse;
    private javax.swing.JComboBox<Alumno> jComboAlumno;
    private javax.swing.JComboBox<Materia> jComboMateria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
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
