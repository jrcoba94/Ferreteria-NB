/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoferreteria_7a.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import proyectoferreteria_7a.BO.Empleados;
import proyectoferreteria_7a.BO.UsuariosBO;
import proyectoferreteria_7a.Conexion.Conexion;
import proyectoferreteria_7a.GUI.Usuarios;

/**
 *
 * @author Azael
 */
public class LoginDAO {
 
    Conexion con = new Conexion();
   Connection cn = con.Conectar();
   Conexion cc= new Conexion();
//    public Conexion conn()
//    {
//        ConfigConexion oConfigConexion=new ConfigConexion();       
//        return oConfigConexion.conn();
//    }
    public List<Empleados> buscar(Object obj)
    {
        List<Empleados> oListaEmpleado=new ArrayList<Empleados>();
        try
            {
            String cadenawhere="";
            boolean edo=false;
            Empleados data=(Empleados)obj;
            Statement stml=con.Conectar().createStatement();
            
            if(data.getUsuario()!=null){
               cadenawhere=cadenawhere +" Usuario= '"+ data.getUsuario()+ "' and";
               edo=true;
            }
            if(data.getContrasenia()!=null){
                cadenawhere=cadenawhere +" Contrasenia= '"+ data.getContrasenia()+ "' and";
                edo=true;
            }
            if(edo==true){
                cadenawhere="where"+ cadenawhere.substring(0,cadenawhere.length()-3);
            }
            
                //-----
            ResultSet res=stml.executeQuery("Select * from Login "+ cadenawhere);
            con.Desconectar();
            while(res.next())
            {
                Empleados oEmpleado=new Empleados();
                oEmpleado.setIdEmpleado(Integer.parseInt(res.getString("IdEmpleado").toString()));
                oEmpleado.setUsuario(res.getString("Usuario").toString());
                oEmpleado.setContrasenia(res.getString("Contrasenia").toString());
                oListaEmpleado.add(oEmpleado);
                
                
//                Empleado oEmpleado=new Empleado();
//                oEmpleado.setIdEmpleado(Integer.parseInt(res.getString("IdEmpleado").toString()));
//                oEmpleado.setNombre(res.getString("Nombre").toString());
//                oEmpleado.setUsuario(res.getString("usuario").toString());
//                oEmpleado.setContrasenia(res.getString("Contrasenia").toString());
//                oEmpleado.setDireccion(res.getString("Direccion").toString());
//                oEmpleado.setPuesto(res.getString("Puesto").toString());
//                oListaEmpleado.add(oEmpleado);
            }

        }
        catch(SQLException ex)
        {
            con.Desconectar();
            System.out.println(ex);
        }
        return oListaEmpleado;
    }
    //public class LoguinCtrl {
     public List<Empleados> buscarEmpleado(Object obj) throws ParseException{
	LoginDAO oEmpleadoQueryHlp=new LoginDAO();
	List<Empleados> oEmpleadoList=new ArrayList<Empleados>();
         for(Empleados p:oEmpleadoQueryHlp.buscar(obj))
         {			
            Empleados oEmpleado=new Empleados();
            oEmpleado.setIdEmpleado(p.getIdEmpleado());
//            oEmpleado.setNombres(p.getNombres());
//            oEmpleado.setApellidos(p.getApellidos());
//            oEmpleado.setFechaNacimiento(p.getFechaNacimiento());
//            oEmpleado.setEdad(p.getEdad());
//            oEmpleado.setDireccion(p.getDireccion());
//            oEmpleado.setTelefono(p.getTelefono());
//            oEmpleado.setCorreo(p.getCorreo());
//            oEmpleado.setEstado(p.getEstado());
//            oEmpleado.setCiudad(p.getCiudad());
//            oEmpleado.setNacionalidad(p.getNacionalidad());
//            oEmpleado.setPuesto(p.getPuesto());
//            oEmpleado.setImagen(p.getImagen());
            oEmpleado.setUsuario(p.getUsuario());
            oEmpleado.setContrasenia(p.getContrasenia());	
            oEmpleadoList.add(oEmpleado);
            
            
//            Empleado oEmpleado=new Empleado();
//            oEmpleado.setIdEmpleado(p.getIdEmpleado());
//            oEmpleado.setNombre(p.getNombre());
//            oEmpleado.setUsuario(p.getUsuario());
//            oEmpleado.setContrasenia(p.getContrasenia());	
//            oEmpleado.setDireccion(p.getDireccion());
//            oEmpleado.setPuesto(p.getPuesto());
//            oEmpleadoList.add(oEmpleado);
         }
	return oEmpleadoList;
       }
    }
