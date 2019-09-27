/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoferreteria_7a.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import proyectoferreteria_7a.BO.ProductosBO;
import proyectoferreteria_7a.Conexion.Conexion;
/**
 *
 * @author Daryl
 */
public class ProductosDAO 
{
    Conexion objConexion = new Conexion();
    String Filtro;
    boolean Codigo;
    
    public int Agregar(ProductosBO objProducto){
        int ComandoEjecutado=objConexion.EjecutarComandoSQL("INSERT INTO Productos(Cantidad,Precio,Categoria,Producto,Estatus,Imagen)\n" +
        "VALUES ('"+objProducto.getCantidad()+"','"+objProducto.getPrecio()+ "','" + objProducto.getCategoria() + "', '" + objProducto.getProducto()+ "', '" + objProducto.getEstatus()+ "','" + objProducto.getImagen() +"');");
        objConexion.Desconectar();
        return ComandoEjecutado;    
    }
    
    public int Eliminar(ProductosBO objProducto){
        int ComandoEjecutado=objConexion.EjecutarComandoSQL("DELETE FROM Productos WHERE IDProducto='"+objProducto.getId_Producto()+"'");
        objConexion.Desconectar();
        return ComandoEjecutado;
    }
    
    public int Modificar(ProductosBO objProducto){
        int ComandoEjecutado=objConexion.EjecutarComandoSQL("UPDATE Productos SET Cantidad='"+objProducto.getCantidad()+"', Precio='"+objProducto.getPrecio()+"',Categoria='"+objProducto.getCategoria()+  "',Producto='" + objProducto.getProducto()+ "',Estatus='" + objProducto.getEstatus()+ "',Imagen='" + objProducto.getImagen() + "' WHERE IDProducto="+objProducto.getId_Producto());
        objConexion.Desconectar();    
        return ComandoEjecutado;
    }
    
    public DefaultTableModel Buscar(ProductosBO objProducto){
        DefaultTableModel dtm =new DefaultTableModel(
            new Object [][] {},
            new String [] {
                "ID_Producto", "Cantidad", "Precio", "Estatus", "Categoría", "Imagen", "Productos"
            }
        ){ @Override
        public boolean isCellEditable(int row, int column) {
        // Para no editar en el jTable
       return false;
        }};
         
        try{
        Conexion objConexion= new Conexion();
        if (objProducto.getId_Producto().equals(""))
        {
            ResultSet  Resultado=objConexion.EjecutarSentenciaSQL("SELECT * FROM Productos"); //+ objUsuario.getCodigo());
            while(Resultado.next()){
            // Recuperar Datos de la GUI
            Object[] Fila={
            Resultado.getString(1), 
            Resultado.getString(2),
            Resultado.getString(3), 
            Resultado.getString(4),
            Resultado.getString(5),
            Resultado.getString(6),
            Resultado.getString(7),
            
                };            
        // Agregar Datos al JTable
        dtm.addRow(Fila);
        
            }
        }
        else
        {
            ResultSet  Resultado=objConexion.EjecutarSentenciaSQL("SELECT * FROM Productos where IDProducto =" + objProducto.getId_Producto()); //+ " Nombres="+objUsuario.getNombre() + " Apellidos="+objUsuario.getApellidos()+ "Correo="+objUsuario.getCorreo() + "Estado="+objUsuario.getEstado() + "Ciudad="+objUsuario.getCiudad() + "Imagen="+objUsuario.getImagen());
            while(Resultado.next()){
            // Recuperar Datos de la GUI
            Object[] Fila={
            Resultado.getString(1) , 
            Resultado.getString(2),
            Resultado.getString(3), 
            Resultado.getString(4),
            Resultado.getString(5),
            Resultado.getString(6),
            Resultado.getString(7),
            
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
