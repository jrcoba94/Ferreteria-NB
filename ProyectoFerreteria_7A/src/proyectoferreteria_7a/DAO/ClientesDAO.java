/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoferreteria_7a.DAO;

import proyectoferreteria_7a.BO.ClientesBO;
import proyectoferreteria_7a.Conexion.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SAMSUNG
 */
public class ClientesDAO {
    Conexion conn = new Conexion();
    String sql;
    
    public int addU(ClientesBO obj){
        sql="INSERT INTO Clientes \n" +
       "values(null,'"+obj.getNombres()+"','"+obj.getApellidos()+
       "','"+obj.getDireccion()+"','"+obj.getTelefono()+"','"+obj.getCorreo()+
       "','"+obj.getEdad()+"','"+obj.getSexo()+"','"+obj.getEstado()+"','"+obj.getCiudad()+"');";
        
        int i = conn.EjecutarComandoSQL(sql);
        conn.Desconectar();
        if(i<=0){
            return 0;
        }
        return 1;
    }
    
    //no modificar
    public int deleteU(ClientesBO obj){
        sql="DELETE FROM Clientes WHERE cClave='"+obj.getClave()+"'";
        
        int i = conn.EjecutarComandoSQL(sql);
        conn.Desconectar();
        if(i<=0){
            return 0;
        }
        return 1;
    }
    
    
    public int updateU(ClientesBO obj){
        sql = "UPDATE Clientes "+
                  "SET Nombres='"+obj.getNombres()+"'," +
                  "Apellidos='"+obj.getApellidos()+"'," +
                  "Direccion='"+obj.getDireccion()+"'," +
                  "Telefono='"+obj.getTelefono()+"'," +
                  "Correo='"+obj.getCorreo()+"'," +
                  "Edad='"+obj.getEdad()+"'," +
                  "Sexo='"+obj.getSexo()+"'," +
                  "Estado='"+obj.getEstado()+"'," +
                  "Ciudad='"+obj.getCiudad()+"'" +
                  "WHERE cClave='"+obj.getClave()+"'";

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
                "Código", "Nombres", "Apellidos", "Dirección", "Teléfono", "Correo", "Edad", "Sexo", "Estado", "Ciudad"
            }
    ){
        @Override
        public boolean isCellEditable(int row,int col){
            return false;
        }
    };
         
        try{
         Conexion objConexion= new Conexion();
         ResultSet  rs =objConexion.EjecutarSentenciaSQL("SELECT * FROM Clientes");
         while(rs.next()){
        // Recuperar Datos de la GUI
        Object[] row = new Object[10];
        row[0]=rs.getString("cClave");
        row[1]=rs.getString("Nombres");
        row[2]=rs.getString("Apellidos");
        row[3]=rs.getString("Direccion");
        row[4]=rs.getString("Telefono");
        row[5]=rs.getString("Correo");
        row[6]=rs.getString("Edad");
        row[7]=rs.getString("Sexo");
        row[8]=rs.getString("Estado");
        row[9]=rs.getString("Ciudad");
        
        dtm.addRow(row);
        
        }
         return dtm;       
         }catch(SQLException e){
         return null;
         }
    }
}
