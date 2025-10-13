package Views.Inscripcion;

import Modelo.Alumno;
import Modelo.Inscripcion;
import Modelo.Materia;
import Persistencia.alumnoData;
import Persistencia.inscripcionData;
import Persistencia.materiaData;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class ListarInscripciones extends javax.swing.JInternalFrame{

    private DefaultTableModel modelo = new DefaultTableModel(
      new String[]{"Id", "Nombre", "Apellido", "Nota"}, 0
    );

    public ListarInscripciones(){

        initComponents();
        setSize(500, 550);
        cargarCombo();
        jTableMaterias.setModel(modelo);

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

        jComboMateria.addActionListener(e -> {
            actualizarTabla();
        });

        actualizarTabla();

    }

    private void cargarCombo(){
        jComboMateria.removeAllItems();
        for( Materia materia : materiaData.obtenerMaterias() ){
            jComboMateria.addItem(materia);
        }
    }

    private void actualizarTabla(){
        DefaultTableModel modelo = (DefaultTableModel) jTableMaterias.getModel();
        modelo.setRowCount(0);

        Materia materiaSeleccionada = (Materia) jComboMateria.getSelectedItem();
        if( materiaSeleccionada == null ){
            return;
        }

        ArrayList<Inscripcion> inscripciones = inscripcionData.obtenerInscripcionesPorMateria(materiaSeleccionada.getId());

        // Recorrer las inscripciones y agregar a la tabla
        for( Inscripcion inscripcion : inscripciones ){
            int idAlumno = inscripcion.getAlumno().getId();

            Alumno alumno = alumnoData.obtenerAlumnoPorId(idAlumno);

            if( alumno != null ){
                Object[] fila = {
                    inscripcion.getId(),
                    alumno.getNombre(),
                    alumno.getApellido(),
                    inscripcion.getNota()
                };

                modelo.addRow(fila);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jComboMateria = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableMaterias = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable1);

        setClosable(true);
        setIconifiable(true);
        setTitle("Listar Inscripciones");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel3.setText("Elija Una Materia:");

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
        jScrollPane3.setViewportView(jTableMaterias);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(246, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Materia> jComboMateria;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableMaterias;
    // End of variables declaration//GEN-END:variables
}


/*
             /\_/\           ___
            = o_o =_______    \ \
             __^      __(  \.__) )
         (@)<_____>__(_____)____/
 */
