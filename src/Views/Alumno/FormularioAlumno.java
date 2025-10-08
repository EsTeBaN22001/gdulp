package Views.Alumno;

import Modelo.Alumno;
import Persistencia.alumnoData;
import java.awt.Component;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FormularioAlumno extends javax.swing.JInternalFrame{

    private int filaSeleccionadaParaEdicion = -1;

    private DefaultTableModel modelo = new DefaultTableModel(
      new String[]{"Id", "DNI", "Nombre", "Apellido", "Fecha", "Estado"}, 0
    );

    public FormularioAlumno(){
        initComponents();
        setSize(600, 700);
        cargarCombo();
        cargarCombo2();
        jTable1.setModel(modelo);
        actualizarTabla();

        // Función para que al hacer click sobre un alumno se cargue la información en el formulario de edición
        jTable1.getSelectionModel().addListSelectionListener(new javax.swing.event.ListSelectionListener(){
            @Override
            public void valueChanged(javax.swing.event.ListSelectionEvent e){
                // Deshabilitar el botón de guardar
                jButtonGuardar.setEnabled(false);
                if( !e.getValueIsAdjusting() ){
                    int filaSeleccionada = jTable1.getSelectedRow();
                    filaSeleccionadaParaEdicion = filaSeleccionada;

                    if( filaSeleccionada >= 0 ){
                        // Obtener los valores del producto desde la tabla
                        String dni = (String) jTable1.getValueAt(filaSeleccionada, 1);
                        String nombre = (String) jTable1.getValueAt(filaSeleccionada, 2);
                        String apellido = (String) jTable1.getValueAt(filaSeleccionada, 3);
                        Date fecha = (Date) jTable1.getValueAt(filaSeleccionada, 4);
                        String estado = (String) jTable1.getValueAt(filaSeleccionada, 5);
                        System.out.println(fecha);
//
//                        // Asignar los valores de la tabla en los inputs
                        jTextFieldDNI.setText(String.valueOf(dni));
                        jTextFieldNombre.setText(String.valueOf(nombre));
                        jTextFieldApellido.setText(String.valueOf(apellido));
                        jDateChooser.setDate(fecha);
                        jComboBox2.setSelectedItem(estado);
                    }
                }
            }
        });

    }

    private void limpiarInputs(){
        jTextFieldDNI.setText(null);
        jTextFieldNombre.setText(null);
        jTextFieldApellido.setText(null);
        jDateChooser.setDate(null);
        jButtonGuardar.setEnabled(true);
    }

    private boolean validarFormularioAlumno(int idAlumno){
        String dni = jTextFieldDNI.getText().trim();
        String nombre = jTextFieldNombre.getText().trim();
        String apellido = jTextFieldApellido.getText().trim();
        Date fecha = jDateChooser.getDate();

        // Validar DNI
        if( dni.isEmpty() ){
            mostrarError("El DNI es obligatorio", jTextFieldDNI);
            return false;
        }
        if( !dni.matches("\\d{7,8}") ){
            mostrarError("El DNI debe contener entre 7 y 8 dígitos", jTextFieldDNI);
            return false;
        }

        if( alumnoData.existeDNI(dni, idAlumno) ){
            mostrarError("Ya existe un alumno con este DNI", jTextFieldDNI);
            return false;
        }

        // Validar Nombre
        if( nombre.isEmpty() ){
            mostrarError("El Nombre es obligatorio", jTextFieldNombre);
            return false;
        }
        if( !nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+") ){
            mostrarError("El Nombre solo debe contener letras", jTextFieldNombre);
            return false;
        }

        // Validar Apellido
        if( apellido.isEmpty() ){
            mostrarError("El Apellido es obligatorio", jTextFieldApellido);
            return false;
        }
        if( !apellido.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+") ){
            mostrarError("El Apellido solo debe contener letras", jTextFieldApellido);
            return false;
        }

        // Validar Fecha de Nacimiento
        if( fecha == null ){
            mostrarError("La Fecha de Nacimiento es obligatoria", jDateChooser);
            return false;
        }
        if( fecha.after(new Date()) ){
            mostrarError("La Fecha de Nacimiento no puede ser futura", jDateChooser);
            return false;
        }

        // Validar edad mínima (opcional: al menos 5 años)
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, -5);
        if( fecha.after(cal.getTime()) ){
            mostrarError("El alumno debe tener al menos 5 años", jDateChooser);
            return false;
        }

        return true;
    }

    private void cargarCombo(){
        jComboBoxBuscar.removeAllItems();
        jComboBoxBuscar.addItem("ID");
        jComboBoxBuscar.addItem("DNI");
        jComboBoxBuscar.addItem("Nombre");
        jComboBoxBuscar.addItem("Apellido");
        jComboBoxBuscar.addItem("Estado");

    }

    private void cargarCombo2(){
        jComboBox2.removeAllItems();
        jComboBox2.addItem("Activo");
        jComboBox2.addItem("Inactivo");
    }

    private void actualizarTabla(){
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0);

        for( Alumno p : alumnoData.obtenerTodos() ){
            modelo.addRow(new Object[]{
                p.getId(),
                p.getDni(),
                p.getNombre(),
                p.getApellido(),
                p.getFechaNacimiento(),
                p.getEstado() ? "Activo" : "Inactivo"
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButtonGuardar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldDNI = new javax.swing.JTextField();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldApellido = new javax.swing.JTextField();
        jDateChooser = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jComboBoxBuscar = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jButtonBuscar = new javax.swing.JButton();
        jTextFieldBuscardorPor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jTextField1.setText("jTextField1");

        jTextField5.setText("jTextField2");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Formulario Alumno");
        setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel1.setText("Formulario Alumno");

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setToolTipText("Agregar Alumno");

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nuevo.png"))); // NOI18N
        jButton4.setText("Limpiar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButtonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/guardar.png"))); // NOI18N
        jButtonGuardar.setText("Guardar");
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/borrar.png"))); // NOI18N
        jButton2.setText("Borrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/actualizar.png"))); // NOI18N
        jButton3.setText("Actualizar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("DNI");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Nombre");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setText("Apellido");

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setText("Fecha");

        jTextFieldNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel10.setText("Estado");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel10))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDateChooser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldApellido, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldDNI, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonGuardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton2, jButton3, jButton4, jButtonGuardar});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jTextFieldApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButtonGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jComboBoxBuscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxBuscarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Buscar Por:");

        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        jTextFieldBuscardorPor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldBuscardorPorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldBuscardorPor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonBuscar)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldBuscardorPor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBuscar))
                .addGap(68, 68, 68))
        );

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Agregar Alumno");

        jTable1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "DNI", "Nombre", "Apellido", "Fecha", "Estado"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(37, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxBuscarActionPerformed

    }//GEN-LAST:event_jComboBoxBuscarActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed

        String BuscarPor = (String) jComboBoxBuscar.getSelectedItem();
        String Texto = jTextFieldBuscardorPor.getText();

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
                jTextFieldBuscardorPor.setText("");
                return;
            }
        }

        alumnoData aData = new alumnoData();
        Alumno alumno = aData.buscarAlumnoPor(BuscarPor, Texto);

        if( alumno == null ){
            JOptionPane.showMessageDialog(this,
              "No se encontró ningún alumno con " + BuscarPor + ": " + Texto,
              "Alumno no encontrado",
              JOptionPane.INFORMATION_MESSAGE);
        } else{

            String mensaje = "ALUMNO ENCONTRADO\n\n"
              + "ID: " + alumno.getId() + "\n"
              + "DNI: " + alumno.getDni() + "\n"
              + "Apellido: " + alumno.getApellido() + "\n"
              + "Nombre: " + alumno.getNombre() + "\n"
              + "Fecha Nacimiento: " + alumno.getFechaNacimiento() + "\n"
              + "Estado: " + (alumno.getEstado() ? "Activo" : "Inactivo");

            JOptionPane.showMessageDialog(this,
              mensaje,
              "Datos del Alumno",
              JOptionPane.INFORMATION_MESSAGE);
        }

        jTextFieldBuscardorPor.setText("");

    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jTextFieldBuscardorPorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBuscardorPorActionPerformed
    }//GEN-LAST:event_jTextFieldBuscardorPorActionPerformed

    private void jTextFieldNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreActionPerformed

    }//GEN-LAST:event_jTextFieldNombreActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        limpiarInputs();
        jButtonGuardar.setEnabled(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed

        if( !validarFormularioAlumno(0) ){
            return;
        }

        String DNI = jTextFieldDNI.getText().trim();
        String Nombre = jTextFieldNombre.getText().trim();
        String Apellido = jTextFieldApellido.getText().trim();
        Date fecha = jDateChooser.getDate();

        String valorCombo = (String) jComboBox2.getSelectedItem();
        boolean estado = valorCombo == "Activo" ? true : false;

        Alumno alumno = new Alumno(DNI, Apellido, Nombre, fecha, estado);

        Alumno resultado = alumnoData.guardarAlumno(alumno);
        if( resultado != null ){
            JOptionPane.showMessageDialog(this,
              "Alumno guardado exitosamente\n\n"
              + "ID: " + resultado.getId() + "\n"
              + "Nombre: " + resultado.getNombre() + " " + resultado.getApellido() + "\n"
              + "DNI: " + resultado.getDni(),
              "Guardado exitoso",
              JOptionPane.INFORMATION_MESSAGE);
            limpiarInputs();
        } else{
            JOptionPane.showMessageDialog(this,
              "Error al guardar el alumno\n\n"
              + "Por favor verifique los datos e intente nuevamente",
              "Error al guardar",
              JOptionPane.ERROR_MESSAGE);
        }
        limpiarInputs();
        actualizarTabla();
        filaSeleccionadaParaEdicion = -1;
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        // TODO add your handling code here:
        int fila = jTable1.getSelectedRow();
        if( fila == -1 ){
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un producto de la tabla para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int id = (Integer) jTable1.getValueAt(fila, 0);

        //Buscar el producto en el TreeSet
        Alumno alumnoAEliminar = null;
        for( Alumno a : alumnoData.obtenerTodos() ){
            if( a.getId() == id ){
                alumnoAEliminar = a;
                break;
            }
        }
        if( alumnoAEliminar == null ){
            JOptionPane.showMessageDialog(this, "Producto no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Confirmar eliminación
        int confirmacion = JOptionPane.showConfirmDialog(
          this,
          "¿Está seguro de que desea eliminar el producto:\n" + alumnoAEliminar.getNombre() + " " + alumnoAEliminar.getApellido() + "?",
          "Confirmar eliminación",
          JOptionPane.YES_NO_OPTION,
          JOptionPane.WARNING_MESSAGE
        );

        if( confirmacion == JOptionPane.YES_OPTION ){
            alumnoData.eliminarAlumno(id);
            actualizarTabla();
            limpiarInputs();
            JOptionPane.showMessageDialog(this, "Producto eliminado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            jButtonGuardar.setEnabled(true);
            filaSeleccionadaParaEdicion = -1;
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

        int fila = jTable1.getSelectedRow();
        if( fila == -1 ){
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un producto de la tabla para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int id = (Integer) jTable1.getValueAt(fila, 0);

        if( !validarFormularioAlumno(id) ){
            return;
        }

        String DNI = jTextFieldDNI.getText().trim();
        String Nombre = jTextFieldNombre.getText().trim();
        String Apellido = jTextFieldApellido.getText().trim();
        Date fecha = jDateChooser.getDate();

        String valorCombo = (String) jComboBox2.getSelectedItem();
        boolean estado = valorCombo == "Activo" ? true : false;

        Alumno alumno = new Alumno(DNI, Apellido, Nombre, fecha, estado);
        alumno.setId(id);

        if( filaSeleccionadaParaEdicion >= 0 ){

            // Buscar el producto antiguo por código
            Alumno alumnoAActualizar = null;
            for( Alumno a : alumnoData.obtenerTodos() ){
                if( a.getId() == id ){
                    alumnoAActualizar = a;
                    break;
                }
            }
            if( alumnoAActualizar == null ){
                JOptionPane.showMessageDialog(this, "Alumno no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            boolean resultado = alumnoData.actualizarAlumno(alumno);

            if( !resultado ){
                return;
            }

            JOptionPane.showMessageDialog(this, "Alumno actualizado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            jButtonGuardar.setEnabled(true);
            filaSeleccionadaParaEdicion = -1;
            actualizarTabla();
            limpiarInputs();
            jButtonGuardar.setEnabled(true);
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void mostrarError(String mensaje, Component componente){
        JOptionPane.showMessageDialog(this, mensaje, "Error de validación", JOptionPane.ERROR_MESSAGE);
        componente.requestFocus();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBoxBuscar;
    private com.toedter.calendar.JDateChooser jDateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextFieldApellido;
    private javax.swing.JTextField jTextFieldBuscardorPor;
    private javax.swing.JTextField jTextFieldDNI;
    private javax.swing.JTextField jTextFieldNombre;
    // End of variables declaration//GEN-END:variables
}

/*
             /\_/\           ___
            = o_o =_______    \ \
             __^      __(  \.__) )
         (@)<_____>__(_____)____/
 */
