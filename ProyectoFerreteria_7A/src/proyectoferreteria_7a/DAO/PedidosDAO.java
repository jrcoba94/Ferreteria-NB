/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoferreteria_7a.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import proyectoferreteria_7a.BO.PedidosBO;
import proyectoferreteria_7a.Conexion.Conexion;

/**
 *
 * @author Daryl
 */
public class PedidosDAO 
{
    Conexion objConexion = new Conexion();
    //String Filtro;
    //boolean Codigo;
    
    public int Agregar(PedidosBO objPedido)
    {
        int ComandoEjecutado=objConexion.EjecutarComandoSQL("INSERT INTO Pedidos(FechaSolicitud,NumeroProductos,Cantidad)\n" +
        "VALUES ('"+objPedido.getFechaSolicitud()+"','"+objPedido.getNumeroProductos()+ "','" + objPedido.getCantidad()+ "');");
        objConexion.Desconectar();
        return ComandoEjecutado;    
    }
    
    public int Eliminar(PedidosBO objPedido)
    {
        int ComandoEjecutado=objConexion.EjecutarComandoSQL("DELETE FROM Pedidos WHERE IDPedido='"+objPedido.getId_Pedido()+"'");
        objConexion.Desconectar();
        return ComandoEjecutado;
    }
    
    public int Modificar(PedidosBO objPedido)
    {
        int ComandoEjecutado=objConexion.EjecutarComandoSQL("UPDATE Pedidos SET FechaSolicitud='"+objPedido.getFechaSolicitud()+"', NumeroProductos='"+objPedido.getNumeroProductos()+"',Cantidad='"+objPedido.getCantidad()+ "' WHERE IDPedido="+objPedido.getId_Pedido());
        objConexion.Desconectar();    
        return ComandoEjecutado;
    }
    
    public DefaultTableModel Buscar(PedidosBO objPedido){
        DefaultTableModel dtm =new DefaultTableModel(
            new Object [][] {},
            new String [] {
                "ID_Pedido", "Fecha De Solicitud", "Número De Productos", "Cantidad"
            }
        ){ @Override
        public boolean isCellEditable(int row, int column) {
        // Para no editar en el jTable
       return false;
        }};
         
        try{
        Conexion objConexion = new Conexion();
        if (objPedido.getFechaSolicitud().equals(""))
        {
            ResultSet  Resultado = objConexion.EjecutarSentenciaSQL("SELECT * FROM Pedidos"); //+ objUsuario.getCodigo());
            while(Resultado.next()){
            // Recuperar Datos de la GUI
            Object[] Fila={
            Resultado.getString(1) , 
            Resultado.getString(2),
            Resultado.getString(3), 
            Resultado.getString(4),
          //Resultado.getString(5),
          //Resultado.getString(6),
          //Resultado.getString(7),
            
                };            
        // Agregar Datos al JTable
        dtm.addRow(Fila);
        
            }
        }
        else
        {
            ResultSet  Resultado=objConexion.EjecutarSentenciaSQL("SELECT * FROM Pedidos WHERE IDPedido=" + objPedido.getId_Pedido()); //+ " Nombres="+objUsuario.getNombre() + " Apellidos="+objUsuario.getApellidos()+ "Correo="+objUsuario.getCorreo() + "Estado="+objUsuario.getEstado() + "Ciudad="+objUsuario.getCiudad() + "Imagen="+objUsuario.getImagen());
            while(Resultado.next()){
            // Recuperar Datos de la GUI
            Object[] Fila={
            Resultado.getString(1) , 
            Resultado.getString(2),
            Resultado.getString(3), 
            Resultado.getString(4),
          //Resultado.getString(5),
          //Resultado.getString(6),
          //Resultado.getString(7),
            
                };            
            // Agregar Datos al JTable
            dtm.addRow(Fila);        
            }
        }
         return dtm;       
         }catch(SQLException e){
         return null;
         }
    }    
    
    /*
    public DefaultTableModel Buscar2(ProductosBO objUsuario){
        DefaultTableModel dtm =new DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Código", "Nombre", "Apellidos", "Correo", "Estado", "Ciudad", "Foto", "Dirección"
            }
        ){ @Override
        public boolean isCellEditable(int row, int column) {
        // Para no editar en el jTable
       return false;
        }};
         
        try{
        ConexionBD objConexion= new ConexionBD();
        Filtro = "";
        if (objUsuario.getCodigo().equals(""))
        {Codigo = false;}
        else
        {
            Filtro += "Codigo = " + objUsuario.getCodigo();
            Codigo = true;
        }
        if (objUsuario.getNombre().equals(""))
        {}
        else
        {
            Filtro += " and Nombres = '" + objUsuario.getNombre() + "'";
        }
        if (objUsuario.getApellidos().equals(""))
        {}
        else
        {
            Filtro += " and Apellidos = '" + objUsuario.getApellidos()+ "'";
        }
        if (objUsuario.getCorreo().equals(""))
        {}
        else
        {
            Filtro += " and Correo = '" + objUsuario.getCorreo()+ "'";
        }
        if (objUsuario.getEstado().equals("Seleccione una opción"))
        {}
        else
        {
            Filtro += " and Estado = '" + objUsuario.getEstado() + "'";
        }
        if (objUsuario.getCiudad().equals(" "))
        {}
        else
        {
            Filtro += " and Ciudad = '" + objUsuario.getCiudad()+ "'";
        }
        if (objUsuario.getDireccion().equals(""))
        {}
        else
        {
            Filtro += " and Direccion = '" + objUsuario.getDireccion()+ "'";
        }
                
        if (Codigo == false)
        {
            if (Filtro.equals(""))
            {}
            else
            {
            Filtro = Filtro.substring(4);
            }
        }
        
        //JOptionPane.showMessageDialog(null,"SELECT * FROM usuarios where " + cadenaBusqueda);
            
        if (Filtro.equals(""))
        {
            ResultSet  Resultado=objConexion.EjecutarSentenciaSQL("SELECT * FROM USUARIOS"); //+ objUsuario.getCodigo());
            while(Resultado.next()){
            // Recuperar Datos de la GUI
            Object[] Fila=
            {
                Resultado.getString(1) , 
                Resultado.getString(2),
                Resultado.getString(3), 
                Resultado.getString(4),
                Resultado.getString(5),
                Resultado.getString(6),
                Resultado.getString(7),
                Resultado.getString(8),
            };            
            // Agregar Datos al JTable
            dtm.addRow(Fila);                            
            }
        }
        else
        {            
            ResultSet  Resultado=objConexion.EjecutarSentenciaSQL("SELECT * FROM USUARIOS where " + Filtro); //+ objUsuario.getCodigo());
            while(Resultado.next()){
            // Recuperar Datos de la GUI
            Object[] Fila=
            {
                Resultado.getString(1) , 
                Resultado.getString(2),
                Resultado.getString(3), 
                Resultado.getString(4),
                Resultado.getString(5),
                Resultado.getString(6),
                Resultado.getString(7),       
                Resultado.getString(8),
            };            
            // Agregar Datos al JTable
            dtm.addRow(Fila);                            
            }
        }
        return dtm;       
        }catch(SQLException e){
        return null;
        }
    }
*/
}
