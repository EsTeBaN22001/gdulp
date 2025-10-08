package Views.Alumno;

//import Controllers.Producto;
//import Models.ProductosModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GestionAlumnos extends javax.swing.JInternalFrame{

    private int filaSeleccionadaParaEdicion = -1;

    private DefaultTableModel modelo = new DefaultTableModel(
      new String[]{"Código", "Descripción", "Precio", "Categoria", "Stock"}, 0
    );

    public GestionAlumnos(){
        initComponents();
        this.setSize(600, 550);

        cargarComboBox();
        cargarComboBoxInput();

        guardarButton.setEnabled(false);

        jTable1.setModel(modelo);
        actualizarTabla();

//        ProductosModel productosModel = ProductosModel.getInstance();
        // Función para que al hacer click sobre un producto se cargue la información del productos en el formulario de edición
        jTable1.getSelectionModel().addListSelectionListener(new javax.swing.event.ListSelectionListener(){
            @Override
            public void valueChanged(javax.swing.event.ListSelectionEvent e){
                if( !e.getValueIsAdjusting() ){
                    int filaSeleccionada = jTable1.getSelectedRow();
                    filaSeleccionadaParaEdicion = filaSeleccionada;

                    if( filaSeleccionada >= 0 ){
                        // Obtener los valores del producto desde la tabla
                        int codigo = (int) jTable1.getValueAt(filaSeleccionada, 0);
                        String descripcion = (String) jTable1.getValueAt(filaSeleccionada, 1);
                        double precio = (double) jTable1.getValueAt(filaSeleccionada, 2);
                        String categoria = (String) jTable1.getValueAt(filaSeleccionada, 3);
                        int stock = (int) jTable1.getValueAt(filaSeleccionada, 4);

                        // Asignar los valores de la tabla en los inputs
                        codigoInput.setText(String.valueOf(codigo));
                        descripcionInput.setText(descripcion);
                        precioInput.setText(String.valueOf(precio));
                        categoriaInput.setSelectedItem(categoria); // o el combo que uses para categoría
                        stockInput.setValue(stock);
                    }
                }
            }
        });
    }

    // Funciones Utils
    private void actualizarTabla(){
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0);

//        for(Producto p : ProductosModel.getInstance().getProductos()){
//            modelo.addRow(new Object[]{
//                p.getCodigo(),
//                p.getDescripcion(),
//                p.getPrecio(),
//                p.getCategoria(),
//                p.getStock()
//            });
//        }
    }

    public void cargarComboBox(){
        jComboBox1.removeAllItems();
        jComboBox1.addItem("Comestible");
        jComboBox1.addItem("Limpieza");
        jComboBox1.addItem("Perfumería");
    }

    public void cargarComboBoxInput(){
        jComboBox1.removeAllItems();
        jComboBox1.addItem("Comestible");
        jComboBox1.addItem("Limpieza");
        jComboBox1.addItem("Perfumería");
    }

    public void limpiarInputs(){
        codigoInput.setText(String.valueOf(""));
        descripcionInput.setText("");
        precioInput.setText(String.valueOf(""));
        categoriaInput.setSelectedItem(0); // o el combo que uses para categoría
        stockInput.setValue(0);
    }

    private boolean validarInputs(){
        try{
            // 1. Validar código (entero)
            String textoCodigo = codigoInput.getText().trim();
            if( textoCodigo.isEmpty() ){
                JOptionPane.showMessageDialog(this, "El campo 'Código' no puede estar vacío.", "Error de validación", JOptionPane.WARNING_MESSAGE);
                codigoInput.requestFocus();
                return false;
            }
            int codigo = Integer.parseInt(textoCodigo); // Si falla, salta al catch

            // 2. Validar descripción
            String descripcion = descripcionInput.getText().trim();
            if( descripcion.isEmpty() ){
                JOptionPane.showMessageDialog(this, "El campo 'Descripción' no puede estar vacío.", "Error de validación", JOptionPane.WARNING_MESSAGE);
                descripcionInput.requestFocus();
                return false;
            }

            // 3. Validar precio (decimal)
            String textoPrecio = precioInput.getText().trim();
            if( textoPrecio.isEmpty() ){
                JOptionPane.showMessageDialog(this, "El campo 'Precio' no puede estar vacío.", "Error de validación", JOptionPane.WARNING_MESSAGE);
                precioInput.requestFocus();
                return false;
            }
            double precio = Double.parseDouble(textoPrecio);

            // 4. Validar categoría (combo)
            String categoria = (String) jComboBox1.getSelectedItem();
            if( categoria == null || categoria.trim().isEmpty() ){
                JOptionPane.showMessageDialog(this, "Debe seleccionar una categoría.", "Error de validación", JOptionPane.WARNING_MESSAGE);
                jComboBox1.requestFocus();
                return false;
            }

            // 5. Validar stock (opcional: rango mínimo)
            int stock = (Integer) stockInput.getValue();
            if( stock < 0 ){
                JOptionPane.showMessageDialog(this, "El stock no puede ser negativo.", "Error de validación", JOptionPane.WARNING_MESSAGE);
                stockInput.requestFocus();
                return false;
            }

            // ✅ ¡Todos los campos son válidos!
            return true;

        } catch( NumberFormatException e ){
            JOptionPane.showMessageDialog(this, "Revise los campos numéricos (Código y Precio). Deben ser números válidos.", "Error de formato", JOptionPane.ERROR_MESSAGE);
            return false;
        } catch( Exception e ){
            JOptionPane.showMessageDialog(this, "Error inesperado al validar los campos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        codigoInput = new javax.swing.JTextField();
        descripcionInput = new javax.swing.JTextField();
        precioInput = new javax.swing.JTextField();
        categoriaInput = new javax.swing.JComboBox<>();
        stockInput = new javax.swing.JSpinner();
        nuevoButton = new javax.swing.JButton();
        guardarButton = new javax.swing.JButton();
        actualizarButton = new javax.swing.JButton();
        eliminarButton = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Gestión de alumnos");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setText("Filtrar por categoría:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Comestible", "Limpieza", "Perfumería" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Descripción", "Precio", "Categoria", "Stock"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setText("Código:");

        jLabel4.setText("Descripción:");

        jLabel5.setText("Precio:");

        jLabel6.setText("Categoría:");

        jLabel7.setText("Stock:");

        codigoInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoInputActionPerformed(evt);
            }
        });

        precioInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precioInputActionPerformed(evt);
            }
        });

        categoriaInput.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Comestible", "Limpieza", "Perfumería" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(stockInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(codigoInput)
                    .addComponent(descripcionInput)
                    .addComponent(precioInput)
                    .addComponent(categoriaInput, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(codigoInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(descripcionInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(precioInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(categoriaInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(stockInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        nuevoButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nuevo.png"))); // NOI18N
        nuevoButton.setText("Nuevo");
        nuevoButton.setAutoscrolls(true);
        nuevoButton.setMargin(new java.awt.Insets(2, 10, 3, 14));
        nuevoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoButtonActionPerformed(evt);
            }
        });

        guardarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/guardar.png"))); // NOI18N
        guardarButton.setText("Guardar");
        guardarButton.setMargin(new java.awt.Insets(2, 10, 3, 14));
        guardarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarButtonActionPerformed(evt);
            }
        });

        actualizarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/actualizar.png"))); // NOI18N
        actualizarButton.setText("Actualizar");
        actualizarButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        actualizarButton.setIconTextGap(2);
        actualizarButton.setMargin(new java.awt.Insets(2, 8, 3, 5));
        actualizarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarButtonActionPerformed(evt);
            }
        });

        eliminarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/borrar.png"))); // NOI18N
        eliminarButton.setText("Eliminar");
        eliminarButton.setMargin(new java.awt.Insets(2, 10, 3, 14));
        eliminarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nuevoButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(16, 16, 16)
                        .addComponent(guardarButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(actualizarButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(eliminarButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(86, 86, 86)))
                .addGap(19, 19, 19))
            .addGroup(layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nuevoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(actualizarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(eliminarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(guardarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void codigoInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoInputActionPerformed

    private void precioInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precioInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_precioInputActionPerformed

    private void nuevoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoButtonActionPerformed
        // TODO add your handling code here:
        guardarButton.setEnabled(true);

        limpiarInputs();

    }//GEN-LAST:event_nuevoButtonActionPerformed

    private void actualizarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarButtonActionPerformed
        // TODO add your handling code here:
        if( !validarInputs() ){
            return;
        }

        int codigo = Integer.parseInt(codigoInput.getText().trim());
        String descripcion = descripcionInput.getText().trim();
        double precio = Double.parseDouble(precioInput.getText().trim());
        String categoria = (String) categoriaInput.getSelectedItem();
        int stock = (Integer) stockInput.getValue();

//        Producto productoNuevo = new Producto(codigo, descripcion, precio, categoria, stock);
//        if(filaSeleccionadaParaEdicion >= 0){
//            // ✏️ MODO EDICIÓN: Actualizar producto existente
//
//            // Buscar el producto antiguo por código
//            Producto productoAntiguo = null;
//            for(Producto p : ProductosModel.getInstance().getProductos()){
//                if(p.getCodigo() == codigo){
//                    productoAntiguo = p;
//                    break;
//                }
//            }
//
//            if(productoAntiguo != null){
//                ProductosModel.getInstance().getProductos().remove(productoAntiguo); // Eliminar antiguo
//            }
//
//            ProductosModel.getInstance().getProductos().add(productoNuevo); // Agregar actualizado
//
//            JOptionPane.showMessageDialog(this, "Producto actualizado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
//
//        } else{
//            // ➕ MODO NUEVO: Agregar producto
//            ProductosModel.getInstance().getProductos().add(productoNuevo);
//            JOptionPane.showMessageDialog(this, "Producto agregado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
//        }
        // Actualizar tabla y limpiar
        actualizarTabla();
        limpiarInputs();
        guardarButton.setEnabled(false);
        filaSeleccionadaParaEdicion = -1; // Resetear modo edición
    }//GEN-LAST:event_actualizarButtonActionPerformed

    private void eliminarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarButtonActionPerformed
        // TODO add your handling code here:
        int fila = jTable1.getSelectedRow();
        if( fila == -1 ){
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un producto de la tabla para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int codigo = (Integer) jTable1.getValueAt(fila, 0);

        // Buscar el producto en el TreeSet
//        Producto productoAEliminar = null;
//        for(Producto p : ProductosModel.getInstance().getProductos()){
//            if(p.getCodigo() == codigo){
//                productoAEliminar = p;
//                break;
//            }
//        }
//        if(productoAEliminar == null){
//            JOptionPane.showMessageDialog(this, "Producto no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
//            return;
//        }
//
//        // Confirmar eliminación
//        int confirmacion = JOptionPane.showConfirmDialog(
//          this,
//          "¿Está seguro de que desea eliminar el producto:\n" + productoAEliminar.getDescripcion() + "?",
//          "Confirmar eliminación",
//          JOptionPane.YES_NO_OPTION,
//          JOptionPane.WARNING_MESSAGE
//        );
//
//        if(confirmacion == JOptionPane.YES_OPTION){
//            ProductosModel.getInstance().getProductos().remove(productoAEliminar);
//            actualizarTabla();
//            limpiarInputs();
//            JOptionPane.showMessageDialog(this, "Producto eliminado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
//        }
    }//GEN-LAST:event_eliminarButtonActionPerformed

    private void guardarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarButtonActionPerformed
        // TODO add your handling code here:

//        if( ! validarInputs()){
//            return;
//        }
//
//        // Obtener los valores del producto desde la tabla
//        int codigo = Integer.parseInt(codigoInput.getText());
//        String descripcion = (String) descripcionInput.getText();
//        double precio = Double.parseDouble(precioInput.getText());
//        String categoria = (String) categoriaInput.getSelectedItem().toString();
//        int stock = Integer.parseInt(stockInput.getValue().toString());
//
//        ProductosModel.getInstance().getProductos().add(new Producto(codigo, descripcion, precio, categoria, stock));
//
//        actualizarTabla();
//
//        limpiarInputs();
//
//        guardarButton.setEnabled(false);
    }//GEN-LAST:event_guardarButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizarButton;
    private javax.swing.JComboBox<String> categoriaInput;
    private javax.swing.JTextField codigoInput;
    private javax.swing.JTextField descripcionInput;
    private javax.swing.JButton eliminarButton;
    private javax.swing.JButton guardarButton;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton nuevoButton;
    private javax.swing.JTextField precioInput;
    private javax.swing.JSpinner stockInput;
    // End of variables declaration//GEN-END:variables
}
