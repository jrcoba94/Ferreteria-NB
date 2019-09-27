/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoferreteria_7a.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import proyectoferreteria_7a.BO.FacturasBO;
import proyectoferreteria_7a.Conexion.Conexion;

/**
 *
 * @author Daryl
 */
public class FacturasDAO 
{
    Conexion objConexion = new Conexion();
    String Filtro;
    boolean Codigo;
    
    public int Agregar(FacturasBO objFactura){
        int ComandoEjecutado=objConexion.EjecutarComandoSQL("INSERT INTO FACTURAS(IDFolio,Fecha)\n" +
        "VALUES ('"+objFactura.getId_Folio()+"','"+objFactura.getFecha()+"');");
        objConexion.Desconectar();
        return ComandoEjecutado;    
    }
    
    public int Eliminar(FacturasBO objFactura){
        int ComandoEjecutado=objConexion.EjecutarComandoSQL("DELETE FROM FACTURAS WHERE Codigo='"+objFactura.getId_Folio()+"'");
        objConexion.Desconectar();
        return ComandoEjecutado;
    }
    
    public int Modificar(FacturasBO objFactura){
        int ComandoEjecutado=objConexion.EjecutarComandoSQL("UPDATE FACTURAS SET IDFolio='"+objFactura.getId_Folio()+"', Fecha='"+objFactura.getFecha()+ "' WHERE Codigo="+objFactura.getId_Folio());
        objConexion.Desconectar();    
        return ComandoEjecutado;
    }
    
    public DefaultTableModel Buscar(FacturasBO objFactura){
        DefaultTableModel dtm =new DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Código", "Nombre", "Apellidos", "Correo", "Estado", "Ciudad", "Foto"
            }
        ){ @Override
        public boolean isCellEditable(int row, int column) {
        // Para no editar en el jTable
       return false;
        }};
         
        try{
        Conexion objConexion= new Conexion();
        if (objFactura.getId_Folio().equals(""))
        {
            ResultSet  Resultado=objConexion.EjecutarSentenciaSQL("SELECT * FROM FACTURAS"); //+ objUsuario.getCodigo());
            while(Resultado.next()){
            // Recuperar Datos de la GUI
            Object[] Fila={
            Resultado.getString(1) , 
            Resultado.getString(2),
            //Resultado.getString(3), 
            //Resultado.getString(4),
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
            ResultSet  Resultado=objConexion.EjecutarSentenciaSQL("SELECT * FROM Usuarios where IDFacturas =" + objFactura.getId_Folio()); //+ " Nombres="+objUsuario.getNombre() + " Apellidos="+objUsuario.getApellidos()+ "Correo="+objUsuario.getCorreo() + "Estado="+objUsuario.getEstado() + "Ciudad="+objUsuario.getCiudad() + "Imagen="+objUsuario.getImagen());
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
    public DefaultTableModel Buscar2(FacturasBO objUsuario){
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
        if (objFactura.getCodigo().equals(""))
        {Codigo = false;}
        else
        {
            Filtro += "Codigo = " + objUsuario.getCodigo();
            Codigo = true;
        }
        if (objFactura.getNombre().equals(""))
        {}
        else
        {
            Filtro += " and Nombres = '" + objFactura.getNombre() + "'";
        }
        if (objFactura.getApellidos().equals(""))
        {}
        else
        {
            Filtro += " and Apellidos = '" + objUsuario.getApellidos()+ "'";
        }
        if (objFactura.getCorreo().equals(""))
        {}
        else
        {
            Filtro += " and Correo = '" + objUsuario.getCorreo()+ "'";
        }
        if (objFactura.getEstado().equals("Seleccione una opción"))
        {}
        else
        {
            Filtro += " and Estado = '" + objUsuario.getEstado() + "'";
        }
        if (objFactura.getCiudad().equals(" "))
        {}
        else
        {
            Filtro += " and Ciudad = '" + objUsuario.getCiudad()+ "'";
        }
        if (objFactura.getDireccion().equals(""))
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
