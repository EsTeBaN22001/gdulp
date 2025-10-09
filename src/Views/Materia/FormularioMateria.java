package Views.Materia;

import Modelo.Materia;
import Persistencia.materiaData;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FormularioMateria extends javax.swing.JInternalFrame{

    private int filaSeleccionadaParaEdicion = -1;
    private DefaultTableModel modelo = new DefaultTableModel(
      new String[]{"Id", "Nombre", "Año", "Estado"}, 0
    );

    public FormularioMateria(){
        initComponents();
        setSize(720, 610);
        cargarComboEstado();
        jTable1.setModel(modelo);
        cargarCombo();
        actualizarTabla();

        jTable1.getSelectionModel().addListSelectionListener(new javax.swing.event.ListSelectionListener(){
            @Override
            public void valueChanged(javax.swing.event.ListSelectionEvent e){
                jButton2.setEnabled(false);
                if( !e.getValueIsAdjusting() ){
                    int filaSeleccionada = jTable1.getSelectedRow();
                    filaSeleccionadaParaEdicion = filaSeleccionada;

                    if( filaSeleccionada >= 0 ){
                        try{
                            // Obtener los valores como Object y convertir de forma segura
                            Object idObj = jTable1.getValueAt(filaSeleccionada, 0);
                            Object nombreObj = jTable1.getValueAt(filaSeleccionada, 1);
                            Object añoObj = jTable1.getValueAt(filaSeleccionada, 2);
                            Object estadoObj = jTable1.getValueAt(filaSeleccionada, 3);

                            // Nombre
                            if( nombreObj != null ){
                                jTextField3.setText(nombreObj.toString());
                            } else{
                                jTextField3.setText("");
                            }

                            // Año
                            if( añoObj != null ){
                                jTextField4.setText(añoObj.toString());
                            } else{
                                jTextField4.setText("");
                            }

                            // Estado
                            if( estadoObj != null ){
                                jComboBox1.setSelectedItem(estadoObj.toString());
                            }

                        } catch( Exception ex ){
                            // Opcional: muestra error en consola para depurar
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Error al cargar los datos de la fila seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        });
    }

    private void cargarComboEstado(){
        jComboBox1.removeAllItems();
        jComboBox1.addItem("Activo");
        jComboBox1.addItem("Inactivo");
        jComboBox1.setSelectedIndex(0); // Selecciona "Activo" por defecto
    }

    private void cargarCombo(){
        comboEstado.removeAllItems();
        comboEstado.addItem("ID");
        comboEstado.addItem("Nombre");
        comboEstado.addItem("Año");
        comboEstado.addItem("Estado");

    }

    private void limpiarInputs(){
        jTextField3.setText(null);
        jTextField4.setText(null);
        jButton2.setEnabled(true);
    }

    private boolean validarFormularioMateria(int idMateria){
        String nombres = jTextField3.getText().trim();
        String año = jTextField4.getText().trim();

        if( !nombres.matches("[\\p{L} ]+") ){
            mostrarError("El Nombre solo debe contener letras y espacios", jTextField3);
            return false;
        }

        if( año.isEmpty() ){
            mostrarError("El Año es obligatorio", jTextField4);
            return false;
        }
        try{
            int añoInt = Integer.parseInt(año);
            if( añoInt >= 2025 ){
                mostrarError("El año debe ser menor a 2025", jTextField4);
                return false;
            }
        } catch( NumberFormatException e ){
            mostrarError("El año debe ser un número válido", jTextField4);
            return false;
        }

        return true;
    }

    private void mostrarError(String mensaje, Component componente){
        JOptionPane.showMessageDialog(this, mensaje, "Error de validación", JOptionPane.ERROR_MESSAGE);
        componente.requestFocus();
    }

    private void actualizarTabla(){
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0);

        for( Materia p : materiaData.obtenerMaterias() ){
            modelo.addRow(new Object[]{
                p.getId(),
                p.getNombre(),
                p.getAño(),
                p.getEstado() == true ? "Activo" : "Inactivo"
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        comboEstado = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Icono = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Formulario Materia");
        setToolTipText("");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel2.setText("Buscar Materia");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/actualizar.png"))); // NOI18N
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Buscar Por: ");

        comboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboEstadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(17, 17, 17))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(85, 85, 85))
        );

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel1.setText("Formulario Materia");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel4.setText("Cargar Materia");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Nombre");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Año");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Estado");

        jTextField3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jTextField4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/guardar.png"))); // NOI18N
        jButton2.setText("Guardar");
        jButton2.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/borrar.png"))); // NOI18N
        jButton3.setText("Borrar");
        jButton3.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/actualizar.png"))); // NOI18N
        jButton4.setText("Actualizar");
        jButton4.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nuevo.png"))); // NOI18N
        jButton5.setText("Limpiar");
        jButton5.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(68, 68, 68)
                        .addComponent(jComboBox1, 0, 284, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addGap(59, 59, 59)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                            .addComponent(jTextField4))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton2, jButton3, jButton4, jButton5});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton2, jButton3, jButton4, jButton5});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jComboBox1, jTextField3, jTextField4});

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
        jScrollPane1.setViewportView(jTable1);

        Icono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Formulario.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Icono)
                        .addGap(322, 322, 322)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Icono)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboEstadoActionPerformed
        //      // TODO add your handling code here:
    }//GEN-LAST:event_comboEstadoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String BuscarPor = (String) comboEstado.getSelectedItem();
        String Texto = jTextField1.getText();

        if( Texto.isEmpty() ){
            JOptionPane.showMessageDialog(this,
              "Por favor ingrese un valor para buscar",
              "Campo vacío",
              JOptionPane.WARNING_MESSAGE);
            return;
        }

        if( BuscarPor.equals("ID") ){
            try{
                Integer.parseInt(Texto);
            } catch( NumberFormatException e ){
                JOptionPane.showMessageDialog(this,
                  "El ID debe ser un número",
                  "Error de formato",
                  JOptionPane.ERROR_MESSAGE);
                jTextField1.setText("");
                return;
            }
        }

        Materia materia = materiaData.buscarMateriaPor(BuscarPor, Texto);

        if( materia == null ){
            JOptionPane.showMessageDialog(this,
              "No se encontró ningún alumno con " + BuscarPor + ": " + Texto,
              "Materia no encontrada",
              JOptionPane.INFORMATION_MESSAGE);
        } else{

            String mensaje = "MATERIA ENCONTRADA\n\n"
              + "ID: " + materia.getId() + "\n"
              + "Nombre: " + materia.getNombre() + "\n"
              + "Año: " + materia.getAño() + "\n"
              + "Estado: " + (materia.getEstado() ? "Activo" : "Inactivo");

            JOptionPane.showMessageDialog(this,
              mensaje,
              "Datos de la materia",
              JOptionPane.INFORMATION_MESSAGE);
        }

        jTextField1.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        limpiarInputs();
        jButton2.setEnabled(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if( !validarFormularioMateria(0) ){
            return;
        }
        String nombres = jTextField3.getText().trim();
        String años = jTextField4.getText().trim();

        if( nombres.isEmpty() || años.isEmpty() ){
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try{
            int año = Integer.parseInt(años);

            String valorCombo = (String) jComboBox1.getSelectedItem();
            boolean estado = valorCombo == "Activo" ? true : false;

            Materia materia = new Materia(nombres, año, estado);

            Materia resultado = materiaData.guardarMateria(materia);
            if( resultado != null ){
                JOptionPane.showMessageDialog(this,
                  "Materia guardada exitosamente\n\n"
                  + "ID: " + resultado.getId() + "\n"
                  + "Nombre: " + resultado.getNombre() + "\n"
                  + "Año: " + resultado.getAño(),
                  "Guardado exitoso",
                  JOptionPane.INFORMATION_MESSAGE);
            } else{
                JOptionPane.showMessageDialog(this,
                  "Error al guardar la materia.\nVerifique los datos e intente nuevamente.",
                  "Error al guardar",
                  JOptionPane.ERROR_MESSAGE);
            }

            limpiarInputs();
            actualizarTabla();
            filaSeleccionadaParaEdicion = -1;

        } catch( NumberFormatException e ){
            JOptionPane.showMessageDialog(this,
              "Los campos ID, Año e ID Inscripto deben contener solo números.",
              "Entrada inválida",
              JOptionPane.WARNING_MESSAGE);
        }
        limpiarInputs();
        actualizarTabla();
        filaSeleccionadaParaEdicion = -1;

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int fila = jTable1.getSelectedRow();
        if( fila == -1 ){
            JOptionPane.showMessageDialog(this, "Por favor, seleccione una Materia de la tabla para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int id = (Integer) jTable1.getValueAt(fila, 0);

        //Buscar el producto en el TreeSet
        Materia materiaAEliminar = null;
        for( Materia a : materiaData.obtenerMaterias() ){
            if( a.getId() == id ){
                materiaAEliminar = a;
                break;
            }
        }
        if( materiaAEliminar == null ){
            JOptionPane.showMessageDialog(this, "Materia no encontrada.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Confirmar eliminación
        int confirmacion = JOptionPane.showConfirmDialog(
          this,
          "¿Está seguro de que desea eliminar la Materia:\n" + materiaAEliminar.getNombre() + "?",
          "Confirmar eliminación",
          JOptionPane.YES_NO_OPTION,
          JOptionPane.WARNING_MESSAGE
        );

        if( confirmacion == JOptionPane.YES_OPTION ){
            materiaData.eliminarMateria(id);
            actualizarTabla();
            limpiarInputs();
            JOptionPane.showMessageDialog(this, "Materia Eliminada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            jButton2.setEnabled(true);
            filaSeleccionadaParaEdicion = -1;
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int fila = jTable1.getSelectedRow();
        if( fila == -1 ){
            JOptionPane.showMessageDialog(this, "Por favor, seleccione una Materia de la tabla para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int id = (Integer) jTable1.getValueAt(fila, 0);

        if( !validarFormularioMateria(id) ){
            return;
        }

        String nombres = jTextField3.getText().trim();
        String años = jTextField4.getText().trim();

        String valorCombo = (String) jComboBox1.getSelectedItem();
        boolean estado = valorCombo == "Activo" ? true : false;

        int año = Integer.parseInt(años);

        Materia materia = new Materia(id, nombres, año, estado);

        if( filaSeleccionadaParaEdicion >= 0 ){

            // Buscar el producto antiguo por código
            Materia materiaAActualizar = null;
            for( Materia a : materiaData.obtenerMaterias() ){
                if( a.getId() == id ){
                    materiaAActualizar = a;
                    break;
                }
            }
            if( materiaAActualizar == null ){
                JOptionPane.showMessageDialog(this, "Materia no encontrada.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            boolean resultado = materiaData.actualizarMateria(materia);

            if( !resultado ){
                return;
            }

            JOptionPane.showMessageDialog(this, "Materia actualizado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            jButton2.setEnabled(true);
            filaSeleccionadaParaEdicion = -1;
            actualizarTabla();
            limpiarInputs();
            jButton2.setEnabled(true);
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Icono;
    private javax.swing.JComboBox<String> comboEstado;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}

/*
             /\_/\           ___
            = o_o =_______    \ \
             __^      __(  \.__) )
         (@)<_____>__(_____)____/
 */
