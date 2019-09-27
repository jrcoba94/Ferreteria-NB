/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoferreteria_7a.GUI;

import proyectoferreteria_7a.BO.PedidosBO;
import proyectoferreteria_7a.DAO.PedidosDAO;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daryl
 */
public class Pedidos extends javax.swing.JFrame 
{
    
    DefaultTableModel dtm = new DefaultTableModel(
    new Object [][] 
    {
        //{null, null, null, null }
    },
    new String [] {
        "ID_Pedido", "Fecha De Solicitud", "Número De Productos", "Cantidad"
    }
);
    
    PedidosBO ObjPedidosBO = new PedidosBO();
    PedidosDAO ObjPedidosDAO = new PedidosDAO();

    /**
     * Creates new form Pedidos
     */
    public Pedidos() {
        initComponents();
        this.setTitle("Gestión De Pedidos");
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JlblPedido = new javax.swing.JLabel();
        JlblFechaSolicitud = new javax.swing.JLabel();
        JlblNumeroProductos = new javax.swing.JLabel();
        JtxtPedido = new javax.swing.JTextField();
        JlblCantidad = new javax.swing.JLabel();
        JtxtCantidad = new javax.swing.JTextField();
        JtxtFechaSolicitud = new javax.swing.JTextField();
        JtxtNumProductos = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTablePedidos = new javax.swing.JTable();
        jbtnBuscar = new javax.swing.JButton();
        jbtnAgregar = new javax.swing.JButton();
        jbtnModificar = new javax.swing.JButton();
        JbtnLimpiar = new javax.swing.JButton();
        jbtnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JlblPedido.setText("ID Pedido :");

        JlblFechaSolicitud.setText("Fecha De Solicitud :");

        JlblNumeroProductos.setText("Número De Productos :");

        JtxtPedido.setEnabled(false);
        JtxtPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtxtPedidoActionPerformed(evt);
            }
        });

        JlblCantidad.setText("Cantidad :");

        JTablePedidos.setModel(dtm);
        JTablePedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTablePedidosMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JTablePedidosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(JTablePedidos);

        jbtnBuscar.setText("Buscar");
        jbtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBuscarActionPerformed(evt);
            }
        });

        jbtnAgregar.setText("Agregar");
        jbtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAgregarActionPerformed(evt);
            }
        });

        jbtnModificar.setText("Modificar");
        jbtnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnModificarActionPerformed(evt);
            }
        });

        JbtnLimpiar.setText("Limpiar");
        JbtnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbtnLimpiarActionPerformed(evt);
            }
        });

        jbtnEliminar.setText("Eliminar");
        jbtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbtnAgregar)
                                .addGap(18, 18, 18)
                                .addComponent(jbtnModificar)
                                .addGap(18, 18, 18)
                                .addComponent(jbtnEliminar)
                                .addGap(18, 18, 18)
                                .addComponent(jbtnBuscar)
                                .addGap(18, 18, 18)
                                .addComponent(JbtnLimpiar))
                            .addComponent(JlblFechaSolicitud)
                            .addComponent(JlblCantidad)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JlblPedido)
                                    .addComponent(JlblNumeroProductos))
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(JtxtPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JtxtNumProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JtxtFechaSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JtxtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JlblPedido)
                    .addComponent(JtxtPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JlblFechaSolicitud)
                    .addComponent(JtxtFechaSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JlblNumeroProductos)
                    .addComponent(JtxtNumProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JlblCantidad)
                    .addComponent(JtxtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnAgregar)
                    .addComponent(jbtnModificar)
                    .addComponent(jbtnEliminar)
                    .addComponent(jbtnBuscar)
                    .addComponent(JbtnLimpiar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JtxtPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtxtPedidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JtxtPedidoActionPerformed

    private void JTablePedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTablePedidosMouseClicked
        // TODO add your handling code here:

        int row = JTablePedidos.getSelectedRow();
        System.out.println("--"+row);
        JTable target = (JTable)evt.getSource();
        JtxtPedido.setText(target.getValueAt(target.getSelectedRow(), 0).toString());
        JtxtFechaSolicitud.setText(target.getValueAt(target.getSelectedRow(), 1).toString());
        JtxtNumProductos.setText(target.getValueAt(target.getSelectedRow(), 2).toString());
        JtxtCantidad.setText(target.getValueAt(target.getSelectedRow(), 3).toString());
        //JcmxCategoria.setSelectedItem(target.getValueAt(target.getSelectedRow(), 4).toString());
        //JcmxCiudad.setSelectedItem(target.getValueAt(target.getSelectedRow(), 5).toString());
        //RutaArchivo = JTablePedidos.getValueAt(JTablePedidos.getSelectedRow(), 5).toString();

        /*
        if (JTablePedidos.getValueAt(JTablePedidos.getSelectedRow(), 5).toString().equals(""))
        {
            JlblImagen.setIcon(null);
        }
        else
        {
            Imagen= new ImageIcon(((new ImageIcon((JTablePedidos.getValueAt(JTablePedidos.getSelectedRow(), 6).toString()))).getImage()).getScaledInstance(JlblImagen.getWidth(),JlblImagen.getHeight(), java.awt.Image.SCALE_SMOOTH));
            JlblImagen.setIcon(Imagen);
        }
        */
        jbtnEliminar.setEnabled(true);
        jbtnModificar.setEnabled(true);
        jbtnAgregar.setEnabled(false);
        jbtnBuscar.setEnabled(true);
    }//GEN-LAST:event_JTablePedidosMouseClicked

    private void JTablePedidosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTablePedidosMousePressed
        // TODO add your handling code here:
        /*
        jbtnAgregar.setEnabled(true);
        jbtnEliminar.setEnabled(true);
        jbtnModificar.setEnabled(true);
        jbtnAgregar.setEnabled(false);
        jtxtCodigo.setText(jTableUsuarios.getValueAt(jTableUsuarios.getSelectedRow(), 0).toString());
        jtxtNombre.setText(jTableUsuarios.getValueAt(jTableUsuarios.getSelectedRow(), 1).toString());
        jtxtApellidos.setText(jTableUsuarios.getValueAt(jTableUsuarios.getSelectedRow(), 2).toString());
        jtxtCorreo.setText(jTableUsuarios.getValueAt(jTableUsuarios.getSelectedRow(), 3).toString());
        JcmxEstado.setSelectedItem(jTableUsuarios.getValueAt(jTableUsuarios.getSelectedRow(), 4).toString());
        JcmxCiudad.setSelectedItem(jTableUsuarios.getValueAt(jTableUsuarios.getSelectedRow(), 5).toString());
        Ruta = jTableUsuarios.getValueAt(jTableUsuarios.getSelectedRow(), 6).toString();

        /*RutaArchivo=(tblUsuarios.getValueAt(tblUsuarios.getSelectedRow(), 6).toString());
        if (jTableUsuarios.getValueAt(jTableUsuarios.getSelectedRow(), 6).toString().equals(""))
        {
            jlblImagen.setIcon(null);
        }
        else
        {
            Imagen= new ImageIcon(((new ImageIcon((jTableUsuarios.getValueAt(jTableUsuarios.getSelectedRow(), 6).toString()))).getImage()).getScaledInstance(jlblImagen.getWidth(),jlblImagen.getHeight(), java.awt.Image.SCALE_SMOOTH));
            jlblImagen.setIcon(Imagen);
        }
        */
    }//GEN-LAST:event_JTablePedidosMousePressed

    private void jbtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBuscarActionPerformed
        // TODO add your handling code here:

        ActualizarTabla();
    }//GEN-LAST:event_jbtnBuscarActionPerformed

    private void jbtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAgregarActionPerformed
        // TODO add your handling code here:

        /*Instrucción del botón Agregar para la base de datos
        UsuariosDAO ObjUsuariosDAO = new UsuariosDAO();
        ObjUsuariosDAO.Agregar(RecolectarDatos());

        Object[] fila = { ObjUsuariosBO.getCodigo(), ObjUsuariosBO.getNombres(), ObjUsuariosBO.getApellidos(), ObjUsuariosBO.getCorreo(), ObjUsuariosBO.getEstado(), ObjUsuariosBO.getCiudad()};//JcmxEstado.getSelectedItem(), JcmxCiudad.getSelectedItem() };
        dtm.addRow(fila);
        */
        
        if(ObjPedidosDAO.Agregar(RecolectarDatos())==1)
        {
            JOptionPane.showMessageDialog(null,"Información Agregada");
        }
        ActualizarTabla();
    }//GEN-LAST:event_jbtnAgregarActionPerformed

    private void jbtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnModificarActionPerformed
        // TODO add your handling code here:
        if(ObjPedidosDAO.Modificar(RecolectarDatos())==1)
        {
            JOptionPane.showMessageDialog(null,"Información modificada");
        }
        ActualizarTabla();
    }//GEN-LAST:event_jbtnModificarActionPerformed

    private void JbtnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbtnLimpiarActionPerformed
        // TODO add your handling code here:
        Limpiar();
        jbtnEliminar.setEnabled(false);
        jbtnModificar.setEnabled(false);
        jbtnAgregar.setEnabled(true);
        jbtnBuscar.setEnabled(true);
        //JcmxCiudad.removeAllItems();
        //JcmxCiudad.addItem(" ");
        //JcmxCategoria.setSelectedItem("Seleccione una opción");
    }//GEN-LAST:event_JbtnLimpiarActionPerformed

    private void jbtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEliminarActionPerformed
        // TODO add your handling code here:
        if(ObjPedidosDAO.Eliminar(RecolectarDatos())==1)
        {
            JOptionPane.showMessageDialog(null,"Información eliminada");
        }
        ActualizarTabla();
    }//GEN-LAST:event_jbtnEliminarActionPerformed

    public void ActualizarTabla()
    {
        JTablePedidos.setModel(ObjPedidosDAO.Buscar(RecolectarDatos()));
    }
    
    
    public PedidosBO RecolectarDatos()
    {
        ObjPedidosBO.setId_Pedido(JtxtPedido.getText());
        ObjPedidosBO.setFechaSolicitud(JtxtFechaSolicitud.getText());
        ObjPedidosBO.setNumeroProductos(JtxtNumProductos.getText());
        ObjPedidosBO.setCantidad(JtxtCantidad.getText());
        
        return ObjPedidosBO;
    }
    
    public void Limpiar()
    {
        JtxtPedido.setText("");
        JtxtFechaSolicitud.setText("");
        JtxtNumProductos.setText("");
        JtxtCantidad.setText("");
        
        jbtnEliminar.setEnabled(false);
        jbtnModificar.setEnabled(false);
        jbtnAgregar.setEnabled(true);
        jbtnBuscar.setEnabled(true);
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
            java.util.logging.Logger.getLogger(Pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pedidos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTablePedidos;
    private javax.swing.JButton JbtnLimpiar;
    private javax.swing.JLabel JlblCantidad;
    private javax.swing.JLabel JlblFechaSolicitud;
    private javax.swing.JLabel JlblNumeroProductos;
    private javax.swing.JLabel JlblPedido;
    private javax.swing.JTextField JtxtCantidad;
    private javax.swing.JTextField JtxtFechaSolicitud;
    private javax.swing.JTextField JtxtNumProductos;
    private javax.swing.JTextField JtxtPedido;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnAgregar;
    private javax.swing.JButton jbtnBuscar;
    private javax.swing.JButton jbtnEliminar;
    private javax.swing.JButton jbtnModificar;
    // End of variables declaration//GEN-END:variables
}