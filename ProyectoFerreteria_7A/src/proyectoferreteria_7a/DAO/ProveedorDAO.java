/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoferreteria_7a.DAO;

import proyectoferreteria_7a.BO.ProveedorBO;
import proyectoferreteria_7a.Conexion.Conexion;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SAMSUNG
 */
public class ProveedorDAO {
    Conexion conn = new Conexion();
    String sql;
    
    public int addU(ProveedorBO obj){
        sql="INSERT INTO Proveedor \n" +"values(null,'"+
                obj.getNombres()+"','"+
                obj.getApellidos()+"','"+
                obj.getFechaN()+"','"+
                obj.getEdad()+"','"+
                obj.getDireccion()+"','"+
                obj.getTelefono()+"','"+
                obj.getCorreo()+"','"+
                obj.getRFC()+"','"+
                obj.getSexo()+"','"+
                obj.getEstado()+"','"+
                obj.getCiudad()+"','"+
                obj.getFoto()+"');";
        
        int i = conn.EjecutarComandoSQL(sql);
        conn.Desconectar();
        if(i<=0){
            return 0;
        }
        return 1;
    }
    
    public int deleteU(ProveedorBO obj){
        sql="DELETE FROM Proveedor WHERE idVendedor='"+obj.getClave()+"'";
        
        int i = conn.EjecutarComandoSQL(sql);
        conn.Desconectar();
        if(i<=0){
            return 0;
        }
        return 1;
    }
    
    
    public int updateU(ProveedorBO obj){
        sql = "UPDATE Proveedor "+
                "SET nombreVendedor='"+obj.getNombres()+"'," +
                "Apellidos='"+obj.getApellidos()+"'," +
                "FechaN='"+obj.getFechaN()+"','"+
                "Edad='"+obj.getEdad()+"','"+
                "Direccion='"+obj.getDireccion()+"'," +
                "Telefono='"+obj.getTelefono()+"'," +
                "Correo='"+obj.getCorreo()+"'," +
                "RFC='"+obj.getRFC()+"','"+
                "Sexo='"+obj.getSexo()+"'," +
                "Estado='"+obj.getEstado()+"'," +
                "Ciudad='"+obj.getCiudad()+"'," +
                "Foto='"+obj.getFoto()+"'" +
                "WHERE idVendedor='"+obj.getClave()+"'";

            int i = conn.EjecutarComandoSQL(sql);
            if (i <= 0)
            {
                return 0;
            }
            return 1;
    }
    
    public DefaultTableModel Buscar(){
        DefaultTableModel dtm = new DefaultTableModel(
            new Object[][]{
                
            },
            new String[]{
                "Código", "Nombres", "Apellidos", "Fecha Nacimiento", "Edad", "Dirección", "Teléfono", "Correo", "RFC", "Sexo", "Estado", "Ciudad", "Foto"
            }
    ){
        @Override
        public boolean isCellEditable(int row,int col){
            return false;
        }
    };
         
        try{
         Conexion objConexion= new Conexion();
         ResultSet  rs =objConexion.EjecutarSentenciaSQL("SELECT * FROM Proveedor");
         while(rs.next()){
        Object[] row = new Object[13];
        row[0]=rs.getString("idVendedor");
        row[1]=rs.getString("nombreVendedor");
        row[2]=rs.getString("Apellidos");
        row[3]=rs.getString("FechaN");
        row[4]=rs.getString("Edad");
        row[5]=rs.getString("Direccion");
        row[6]=rs.getString("Telefono");
        row[7]=rs.getString("Correo");
        row[8]=rs.getString("RFC");
        row[9]=rs.getString("Sexo");
        row[10]=rs.getString("Estado");
        row[11]=rs.getString("Ciudad");
        row[12]=rs.getString("Foto");
        
        dtm.addRow(row);
        
        }
         return dtm;       
         }catch(SQLException e){
         return null;
         }
    }
}
