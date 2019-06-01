package tiendaUI;

import Excepciones.Excepcion_Definida;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import tienda.dto.Producto;
import tienda.jdbc.CarroDaoJDBC;
import tienda.jdbc.TiendaDaoJDBC;
import utilities.IO;

/**
 *
 * @author finfanterodal
 */
public class ClienteTienda extends javax.swing.JFrame {

    //
    CarroDaoJDBC carro = new CarroDaoJDBC();
    TiendaDaoJDBC tienda = new TiendaDaoJDBC();

    /**
     * Creates new form Menu
     */
    public ClienteTienda() {
        initComponents();
        cargarTablaCatalogo();
        cargarTablaCarro();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        añadirB = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        carroTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        catalogoTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        eliminarB = new javax.swing.JButton();
        confirmarB = new javax.swing.JButton();
        refresh = new javax.swing.JButton();
        quitarB = new javax.swing.JButton();
        añadirUB = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 74, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 276, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        añadirB.setText("Añadir");
        añadirB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añadirBActionPerformed(evt);
            }
        });

        carroTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Precio", "nº Unidades", "Tipo"
            }
        ));
        jScrollPane1.setViewportView(carroTable);

        catalogoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Precio", "nº Unidades", "Tipo"
            }
        ));
        jScrollPane2.setViewportView(catalogoTable);

        jLabel1.setText("Catálogo:");

        jLabel2.setText("Carro:");

        eliminarB.setText("Eliminar");
        eliminarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarBActionPerformed(evt);
            }
        });

        confirmarB.setText("Confirmar");
        confirmarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarBActionPerformed(evt);
            }
        });

        refresh.setText("Refresh");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });

        quitarB.setText("Quitar Unidades");
        quitarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitarBActionPerformed(evt);
            }
        });

        añadirUB.setText("Añadir Unidades");
        añadirUB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añadirUBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(añadirB)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(eliminarB)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(añadirUB)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(quitarB)
                                .addGap(31, 31, 31)
                                .addComponent(refresh)
                                .addGap(31, 31, 31))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(7, 7, 7)))
                        .addComponent(confirmarB))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(añadirB)
                    .addComponent(eliminarB)
                    .addComponent(confirmarB)
                    .addComponent(refresh)
                    .addComponent(quitarB)
                    .addComponent(añadirUB))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Este método añada una cantidad de producto dad por el usuario al carro
     * dadas las siguientes condiciones: 
     * 1. Si el producto ya existiese en el
     * carro no se podrían añadir unidades desde aquí. 
     * 2. Si el producto no
     * existe y aparte son todas las unidades del producto que hay en el
     * catálogo, se inserta este en el carro y se borra del catálogo. 
     * 3.Si las
     * unidades que se quieren añadir son menores de las que hay en el catálogo,
     * se inserta el producto en el carro y se modifica el producto en el
     * catálogo restándole dichas unidades.
     */
    private void añadirBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadirBActionPerformed

        int fila = catalogoTable.getSelectedRow();
        int rows = 0;
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "No hay ninguna fila seleccionada");
        } else {
            try {
                int numUnidades = IO.introducirInt(IO.VENTANA, "Introduce la cantidad que deseas:");
                Producto product1 = new Producto(String.valueOf(catalogoTable.getValueAt(fila, 0)), Double.parseDouble(catalogoTable.getValueAt(fila, 1).toString()), Integer.parseInt(catalogoTable.getValueAt(fila, 2).toString()), String.valueOf(catalogoTable.getValueAt(fila, 3)));
                Producto product2;
                Producto productoaux = carro.buscarProducto(product1.getNome());
                if (productoaux == null) {
                    excepcionAñadirUnidades(product1, numUnidades);
                    if (numUnidades == product1.getNumUnid()) {
                        tienda.deleteProducto(product1.getNome());
                        rows = carro.insertProducto(product1, numUnidades);
                    } else if (numUnidades != product1.getNumUnid()) {
                        product2 = new Producto(catalogoTable.getValueAt(fila, 0).toString(), Double.parseDouble(catalogoTable.getValueAt(fila, 1).toString()), Integer.parseInt(catalogoTable.getValueAt(fila, 2).toString()) - numUnidades, catalogoTable.getValueAt(fila, 3).toString());
                        tienda.updateProducto(product2);
                        rows = carro.insertProducto(product1, numUnidades);
                    }
                } else {
                    IO.devolver(IO.VENTANA, "El producto ya se encuentra en su carro, si desea añadir unidades utilice el botón de su derecha.");
                }

            } catch (Excepcion_Definida e) {
                IO.devolver(IO.VENTANA, e.getMessage());
            } catch (NumberFormatException e) {
                IO.devolver(IO.VENTANA, "No has introducido ningún valor");
            }
            IO.devolver(IO.VENTANA, "Registros insertados correctamente: " + rows);
            cargarTablaCatalogo();
            cargarTablaCarro();
        }

    }//GEN-LAST:event_añadirBActionPerformed
    
    
       /**
     * Este método elimina un producto seleccionado del carro cumpliendo las siguientes condiciones:
     * 1. Si del producto al que se desean eliminar todabía quedan unidades en la tienda(catálogo), modifica este sumándole las unidades del producto eliminado del caroo.
     * 2. Si el producto resulta que ya no queda en la tienda, inserta directamente el producto al que le queremos eliminar del carro en la tienda.
     */
    private void eliminarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarBActionPerformed

        int fila = carroTable.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "No hay ninguna fila seleccionada");
        } else {
            Producto product1 = new Producto(String.valueOf(carroTable.getValueAt(fila, 0)), Double.parseDouble(carroTable.getValueAt(fila, 1).toString()), Integer.parseInt(carroTable.getValueAt(fila, 2).toString()), String.valueOf(carroTable.getValueAt(fila, 3)));
            Producto productoaux = tienda.buscarProducto(product1.getNome());
            Producto product2;
            if (productoaux != null) {
                product2 = new Producto(carroTable.getValueAt(fila, 0).toString(), Double.parseDouble(carroTable.getValueAt(fila, 1).toString()), productoaux.getNumUnid() + product1.getNumUnid(), carroTable.getValueAt(fila, 3).toString());
                tienda.updateProducto(product2);
            } else {
                product2 = new Producto(carroTable.getValueAt(fila, 0).toString(), Double.parseDouble(carroTable.getValueAt(fila, 1).toString()), product1.getNumUnid(), carroTable.getValueAt(fila, 3).toString());
                tienda.insertProducto(product2);
            }
            int rows = carro.deleteProducto(product1.getNome());
            IO.devolver(IO.VENTANA, "Registros borrados correctamente: " + rows);
            cargarTablaCatalogo();
            cargarTablaCarro();
        }

    }//GEN-LAST:event_eliminarBActionPerformed

    private void confirmarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarBActionPerformed


    }//GEN-LAST:event_confirmarBActionPerformed

    /**
     * Carga los datos desde la base de datos a las dos tablas.
     */
    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        cargarTablaCatalogo();
        cargarTablaCarro();
    }//GEN-LAST:event_refreshActionPerformed

    /**
     * Este método quita unidades del producto seleccionado del carro cumpliendo las siguientes condiciones:
     * 1. Si del producto al que se desean quitar unidades todabía quedan unidades en la tienda(catálogo), modifica este sumándole las unidades del producto del caroo.
     * 2. Si el producto resulta que ya no queda en la tienda, inserta directamente el producto al que le queremos quitae unidades del carro en la tienda, con el número de unidades especificado.
     * 3. Cuando el número de unidades a quitar es igual al que hay del producto en el carro lo elimina, y si es menor simplemente lo actualiza.
     */
    private void quitarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitarBActionPerformed

        try {
            int numUnidades = IO.introducirInt(IO.VENTANA, "Introduce la cantidad que deseas quitar:");
            int fila = carroTable.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "No hay ninguna fila seleccionada");
            } else {
                Producto product1 = new Producto(String.valueOf(carroTable.getValueAt(fila, 0)), Double.parseDouble(carroTable.getValueAt(fila, 1).toString()), Integer.parseInt(carroTable.getValueAt(fila, 2).toString()), String.valueOf(carroTable.getValueAt(fila, 3)));
                Producto productoaux = tienda.buscarProducto(product1.getNome());
                int rows = 0;
                excepcionAñadirUnidades(product1, numUnidades);
                if (productoaux != null) {
                    productoaux.setNumUnid(productoaux.getNumUnid() + numUnidades);
                    tienda.updateProducto(productoaux);
                } else {
                    productoaux=product1;
                    productoaux.setNumUnid(numUnidades);
                    tienda.insertProducto(productoaux);
                }
                if (product1.getNumUnid() != numUnidades) {
                    product1.setNumUnid(product1.getNumUnid()-numUnidades);
                    rows = carro.updateProducto(product1);
                } else {
                    rows = carro.deleteProducto(product1.getNome());
                }

                IO.devolver(IO.VENTANA, "Registros borrados correctamente: " + rows);
            }
        } catch (Excepcion_Definida e) {
            IO.devolver(IO.VENTANA, e.getMessage());
        } catch (NumberFormatException e) {
            IO.devolver(IO.VENTANA, "No has introducido ningún valor");
        }
        cargarTablaCatalogo();
        cargarTablaCarro();


    }//GEN-LAST:event_quitarBActionPerformed

    /**
     * Este método añade unidades del producto seleccionado de la
     * tienda(catalogo) al carro cumpliendo las siguientes condiciones:
     * 1. Si del producto del que se quieren añadir unidades no existe en el carro,
     * deberemos utilizar otr botón. 
     * 2. Si el producto existe y el número de
     * unidades es menor del que hay en la tienda(catálogo) nos actualiza el
     * producto del carro y también el de la tienda con el correspondiente nuevo
     * valor. 
     * %3. Si el producto existe y el número de unidades a añadir es igual
     * al de la tienda, elimina este último y actualiza el carro con el nuevo
     * valor.
     */
    private void añadirUBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadirUBActionPerformed
        int fila = catalogoTable.getSelectedRow();
        int rows = 0;
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "No hay ninguna fila seleccionada");
        } else {
            try {
                int numUnidades = IO.introducirInt(IO.VENTANA, "Introduce la cantidad que deseas:");
                Producto product1 = new Producto(String.valueOf(catalogoTable.getValueAt(fila, 0)), Double.parseDouble(catalogoTable.getValueAt(fila, 1).toString()), Integer.parseInt(catalogoTable.getValueAt(fila, 2).toString()), String.valueOf(catalogoTable.getValueAt(fila, 3)));
                Producto productoaux = carro.buscarProducto(product1.getNome());
                if (productoaux != null) {
                    excepcionAñadirUnidades(product1, numUnidades);
                    if (numUnidades == product1.getNumUnid()) {
                        productoaux.setNumUnid(productoaux.getNumUnid() + numUnidades);
                        tienda.deleteProducto(product1.getNome());
                        rows = carro.updateProducto(productoaux);
                    } else if (numUnidades != product1.getNumUnid()) {
                        productoaux.setNumUnid(productoaux.getNumUnid() + numUnidades);
                        product1.setNumUnid(product1.getNumUnid() - numUnidades);
                        tienda.updateProducto(product1);
                        rows = carro.updateProducto(productoaux);
                    }
                } else {
                    IO.devolver(IO.VENTANA, "El producto ya se encuentra en su carro, si desea añadir unidades utilice el botón de su derecha.");
                }

            } catch (Excepcion_Definida e) {
                IO.devolver(IO.VENTANA, e.getMessage());
            } catch (NumberFormatException e) {
                IO.devolver(IO.VENTANA, "No has introducido ningún valor");
            }
            IO.devolver(IO.VENTANA, "Registros insertados correctamente: " + rows);
            cargarTablaCatalogo();
            cargarTablaCarro();
        }
    }//GEN-LAST:event_añadirUBActionPerformed

    /**
     * Recojo los datos del ArrayList actualizado y los añado a la tabla de la
     * interfaz.
     */
    public void cargarTablaCatalogo() {

        //Cargamos la tabla de la interfaz con los datos de la base que están almacenados en un Array
        DefaultTableModel model = (DefaultTableModel) catalogoTable.getModel();
        ArrayList<Producto> product = tienda.refreshArrayProductoTienda();
        model.setRowCount(0);
        for (int j = 0; j < product.size(); j++) {
            Object[] row = {product.get(j).getNome(), product.get(j).getPrecio(), product.get(j).getNumUnid(), product.get(j).getTipo()};
            model.addRow(row);
        }

    }

    /**
     * Recojo los datos del ArrayList actualizado y los añado a la tabla de la
     * interfaz.
     */
    public void cargarTablaCarro() {

        //Cargamos la tabla de la interfaz con los datos de la base que están almacenados en un Array
        DefaultTableModel mode2 = (DefaultTableModel) carroTable.getModel();
        ArrayList<Producto> product = carro.refreshArrayProductoCarro();
        mode2.setRowCount(0);
        for (int j = 0; j < product.size(); j++) {
            Object[] row = {product.get(j).getNome(), product.get(j).getPrecio(), product.get(j).getNumUnid(), product.get(j).getTipo()};
            mode2.addRow(row);
        }

    }

    //Trata que el número de unidades no pueda ser negativo y que elnúmero de unidades que queramos añadir al carro no pueda ser mayor de las unidades que hay en el catalogo.
    /**
     *
     * @param product
     * @param numUnid
     * @throws Excepcion_Definida
     */
    public void excepcionAñadirUnidades(Producto product, int numUnid) throws Excepcion_Definida {
        if (product.getNumUnid() < numUnid & numUnid > 0) {
            throw new Excepcion_Definida("Esa cantidad es mayor de la que hay en la tienda.");
        } else if (numUnid < 0) {
            throw new Excepcion_Definida("Esa cantidad no puede ser negativa.");
        }
    }

    //Trata que el número de unidades que queremos quitar no sea mayor del que hay y que este no sea un número negativo.
    /**
     *
     * @param product
     * @param numUnid
     * @throws Excepcion_Definida
     */
    public void excepcionQuitarUnidades(Producto product, int numUnid) throws Excepcion_Definida {
        if (product.getNumUnid() < numUnid) {
            throw new Excepcion_Definida("Esa cantidad es mayor de la que hay en el carro.");
        } else if (numUnid < 0) {
            throw new Excepcion_Definida("Esa cantidad no puede ser negativa.");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClienteTienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteTienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteTienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteTienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClienteTienda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton añadirB;
    private javax.swing.JButton añadirUB;
    private javax.swing.JTable carroTable;
    private javax.swing.JTable catalogoTable;
    private javax.swing.JButton confirmarB;
    private javax.swing.JButton eliminarB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton quitarB;
    private javax.swing.JButton refresh;
    // End of variables declaration//GEN-END:variables
}
