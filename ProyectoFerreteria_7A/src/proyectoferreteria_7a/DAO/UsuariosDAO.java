/*
 *  Agregar, modificar, eliminar, buscar
 */
// Gestionar la base de datos 
package proyectoferreteria_7a.DAO;
import proyectoferreteria_7a.BO.UsuariosBO;
import proyectoferreteria_7a.Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import proyectoferreteria_7a.GUI.Ventas;


public class UsuariosDAO {
   Conexion objConexion= new Conexion();
   DefaultTableModel ModeloTabla;
   Conexion con = new Conexion();
   Connection cn = con.Conectar();
   Conexion cc= new Conexion();
   String info[][] = {};
   Conexion conectar = new Conexion();
   String [] columnas={"Codigo","Nombres","Apellidos","FechaNacimiento","Edad", "Direccion", "Telefono", "Correo", "Estado", "Ciudad", "Nacionalidad", "Puesto", "Imagen"};
    public UsuariosDAO(){
    
    }
    public int Agregar(UsuariosBO objUsuario){
   int ComandoEjecutado=objConexion.EjecutarComandoSQL("INSERT INTO USUARIOS(Nombres,Apellidos,FechaNacimiento,Edad,Direccion,Telefono,Correo,Estado,Ciudad,Nacionalidad,Puesto,Imagen)\n" +
"VALUES ('"+objUsuario.getNombres()+"','"+objUsuario.getApellidos()+"','"+objUsuario.getFechaNacimiento()+"','"+objUsuario.getEdad()+"','"+objUsuario.getDireccion()+"','"+objUsuario.getTelefono()+"','"+objUsuario.getCorreo()+"','"+objUsuario.getEstado()+"','"+objUsuario.getCiudad()+"','"+objUsuario.getNacionalidad()+"','"+objUsuario.getPuesto()+"','"+objUsuario.getImagen()+"');");
    objConexion.Desconectar();
    return ComandoEjecutado;
    
    }
    public int Eliminar(UsuariosBO objUsuario){
    int ComandoEjecutado=objConexion.EjecutarComandoSQL("DELETE FROM USUARIOS WHERE Codigo='"+objUsuario.getCodigo()+"'");
    objConexion.Desconectar();
    return ComandoEjecutado;
    }
    public void Buscar(String valor, String filtro, JTable tablacontactos){
            String [] columnas={"Codigo","Nombres","Apellidos","FechaNacimiento","Edad", "Direccion", "Telefono", "Correo", "Estado", "Ciudad", "Nacionalidad", "Puesto", "Imagen"};
            String [] registros=new String[13];
            ModeloTabla=new DefaultTableModel(null,columnas);
            
          
            
            String SSQL;
            Connection conect = null;
            if(filtro.equals("Código"))
                {
                   SSQL= "SELECT Codigo, Nombres, Apellidos, FechaNacimiento, Edad, Direccion, Telefono, Correo, Estado, Ciudad, Nacionalidad, Puesto, Imagen "
                   + "FROM USUARIOS WHERE Codigo LIKE '%"+valor+"%'";
                }
            else if(filtro.equals("Nombres"))
                {
                  SSQL= "SELECT Codigo, Nombres, Apellidos, FechaNacimiento, Edad, Direccion, Telefono, Correo, Estado, Ciudad, Nacionalidad, Puesto, Imagen "
                   + "FROM USUARIOS WHERE Nombres LIKE '%"+valor+"%'";
                }
            else if(filtro.equals("Apellidos")){
                   SSQL= "SELECT Codigo, Nombres, Apellidos, FechaNacimiento, Edad, Direccion, Telefono, Correo, Estado, Ciudad, Nacionalidad, Puesto, Imagen "
                   + "FROM USUARIOS WHERE Apellidos LIKE '%"+valor+"%'";
                }
            else if(filtro.equals("FechaNacimiento")){
                   SSQL= "SELECT Codigo, Nombres, Apellidos, FechaNacimiento, Edad, Direccion, Telefono, Correo, Estado, Ciudad, Nacionalidad, Puesto, Imagen "
                   + "FROM USUARIOS WHERE FechaNacimiento LIKE '%"+valor+"%'";
                }
            else if(filtro.equals("Edad")){
                  SSQL= "SELECT Codigo, Nombres, Apellidos, FechaNacimiento, Edad, Direccion, Telefono, Correo, Estado, Ciudad, Nacionalidad, Puesto, Imagen "
                   + "FROM USUARIOS WHERE Edad LIKE '%"+valor+"%'";
                }
            else if(filtro.equals("Direccion")){
                   SSQL= "SELECT Codigo, Nombres, Apellidos, FechaNacimiento, Edad, Direccion, Telefono, Correo, Estado, Ciudad, Nacionalidad, Puesto, Imagen "
                   + "FROM USUARIOS WHERE Direccion LIKE '%"+valor+"%'";
                }
             else if(filtro.equals("Telefono")){
                   SSQL= "SELECT Codigo, Nombres, Apellidos, FechaNacimiento, Edad, Direccion, Telefono, Correo, Estado, Ciudad, Nacionalidad, Puesto, Imagen "
                   + "FROM USUARIOS WHERE Telefono LIKE '%"+valor+"%'";
                }
              else if(filtro.equals("Correo")){
                   SSQL= "SELECT Codigo, Nombres, Apellidos, FechaNacimiento, Edad, Direccion, Telefono, Correo, Estado, Ciudad, Nacionalidad, Puesto, Imagen "
                   + "FROM USUARIOS WHERE Correo LIKE '%"+valor+"%'";
                }
               else if(filtro.equals("Estado")){
                   SSQL= "SELECT Codigo, Nombres, Apellidos, FechaNacimiento, Edad, Direccion, Telefono, Correo, Estado, Ciudad, Nacionalidad, Puesto, Imagen "
                   + "FROM USUARIOS WHERE Estado LIKE '%"+valor+"%'";
                }
                else if(filtro.equals("Ciudad")){
                   SSQL= "SELECT Codigo, Nombres, Apellidos, FechaNacimiento, Edad, Direccion, Telefono, Correo, Estado, Ciudad, Nacionalidad, Puesto, Imagen "
                   + "FROM USUARIOS WHERE Ciudad LIKE '%"+valor+"%'";
                }
                 else if(filtro.equals("Nacionalidad")){
                   SSQL= "SELECT Codigo, Nombres, Apellidos, FechaNacimiento, Edad, Direccion, Telefono, Correo, Estado, Ciudad, Nacionalidad, Puesto, Imagen "
                   + "FROM USUARIOS WHERE Nacionalidad LIKE '%"+valor+"%'";
                }
                  else if(filtro.equals("Puesto")){
                   SSQL= "SELECT Codigo, Nombres, Apellidos, FechaNacimiento, Edad, Direccion, Telefono, Correo, Estado, Ciudad, Nacionalidad, Puesto, Imagen "
                   + "FROM USUARIOS WHERE Puesto LIKE '%"+valor+"%'";
                }
                else 
                {
                  SSQL= "SELECT Codigo, Nombres, Apellidos, FechaNacimiento, Edad, Direccion, Telefono, Correo, Estado, Ciudad, Nacionalidad, Puesto, Imagen "
                   + "FROM USUARIOS WHERE Imagen LIKE '%"+valor+"%'";
                  
                  
              }
                
                try {
                    //conect = metodospool.dataSource.getConnection();
                    conect = cc.Conectar();
                    PreparedStatement st = conect.prepareStatement(SSQL);
                    ResultSet rs = st.executeQuery();
                        while (rs.next()){
                    registros[0]=rs.getString("Codigo");
                    registros[1]=rs.getString("Nombres");
                    registros[2]=rs.getString("Apellidos");
                    registros[3]=rs.getString("FechaNacimiento");
                    registros[4]=rs.getString("Edad");
                    registros[5]=rs.getString("Direccion");
                    registros[6]=rs.getString("Telefono");
                    registros[7]=rs.getString("Correo");
                    registros[8]=rs.getString("Estado");
                    registros[9]=rs.getString("Ciudad");
                    registros[10]=rs.getString("Nacionalidad");
                    registros[11]=rs.getString("Puesto");
                    registros[12]=rs.getString("Imagen");
                    ModeloTabla.addRow(registros);
                  }
                  tablacontactos.setModel(ModeloTabla);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Error durante el procedimiento", JOptionPane.ERROR_MESSAGE);
                }
                finally
                {
                if(conect!=null){
                  try {
                    conect.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error de desconexión", JOptionPane.ERROR_MESSAGE);
                 }
                  
            }
                
        }
                
    }
    
    public int Modificar(UsuariosBO objUsuario){
    int ComandoEjecutado=objConexion.EjecutarComandoSQL("UPDATE USUARIOS SET Nombres='"+objUsuario.getNombres()+"', Apellidos='"+objUsuario.getApellidos()+"',FechaNacimiento='"+objUsuario.getFechaNacimiento()+"',Edad='"+objUsuario.getEdad()+"',Direccion='"+objUsuario.getDireccion()+"',Telefono='"+objUsuario.getTelefono()+"',Correo='"+objUsuario.getCorreo()+"',Estado='"+objUsuario.getEstado()+"',Ciudad='"+objUsuario.getCiudad()+"',Nacionalidad='"+objUsuario.getNacionalidad()+"',Puesto='"+objUsuario.getPuesto()+"',Imagen='"+objUsuario.getImagen()+"' WHERE Codigo="+objUsuario.getCodigo());
    objConexion.Desconectar();    
    return ComandoEjecutado;
    }
    public DefaultTableModel Buscar(UsuariosBO objUsuario){
        DefaultTableModel dtm =new DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Código", "Nombres", "Apellidos", "FechaNacimiento", "Edad", "Direccion", "Telefono", "Correo", "Estado", "Ciudad", "Nacionalidad", "Puesto", "Imagen"
            }
        ){ @Override
    public boolean isCellEditable(int row, int column) {
     // Para no editar en el jTable
       return false;
    }};
         
        try{
         Conexion objConexion= new Conexion();
         ResultSet  Resultado=objConexion.EjecutarSentenciaSQL("SELECT * FROM USUARIOS");
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
          Resultado.getString(8),
          Resultado.getString(9),
          Resultado.getString(10),
          Resultado.getString(11),
          Resultado.getString(12),
          Resultado.getString(13)
        };
        // Agregar Datos al JTable
        dtm.addRow(Fila);
        
        }
         return dtm;       
         }catch(SQLException e){
         return null;
         }
        
        
    }
    public void CargarClientes() {

        ModeloTabla = new DefaultTableModel(info, columnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
      //le asigna el modelo al jtable
        Ventas.SeleccionarCliente.setModel(ModeloTabla);

        //ejecuta una consulta a la BD
        ejecutarConsultaTodaTabla();

    }//cierra metodo cargarTodosClientes
    
    
    Connection conexion = null;
    Statement sentencia = null;
    ResultSet resultado = null;
    PreparedStatement ps = null;
    public void ejecutarConsultaTodaTabla() {

        try {
            conexion = conectar.Conectar();

            sentencia = conexion.createStatement();
            String consultaSQL = "SELECT * FROM USUARIOS ORDER BY Nombres ASC";
            resultado = sentencia.executeQuery(consultaSQL);


            //mientras haya datos en la BD ejecutar eso...
            while (resultado.next()) {


                int codigo = resultado.getInt("Codigo");
                String nombres = resultado.getString("Nombres");
                String apellidos = resultado.getString("Apellidos");
                String fecha = resultado.getString("FechaNacimiento");
                String edad = resultado.getString("Edad");
                String direccion = resultado.getString("Direccion");
                String telefono = resultado.getString("Telefono");
                String correo = resultado.getString("Correo");
                String estado = resultado.getString("Estado");
                String ciudad = resultado.getString("Ciudad");
                String nacionalidad = resultado.getString("Nacionalidad");
                String puesto = resultado.getString("Puesto");
                String imagen = resultado.getString("Imagen");



                //crea un vector donde los está la informacion (se crea una fila)
                Object[] info = {codigo, nombres, apellidos, fecha, edad, direccion, telefono, correo, estado, ciudad, nacionalidad, puesto, imagen};

                //al modelo de la tabla le agrega una fila
                //con los datos que están en info
                ModeloTabla.addRow(info);

            }//cierra while (porque no hay mas datos en la BD)


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error SQL:\n" + e);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
            conexion = null;
        } finally {
            conectar.Desconectar();
        }

    }//cierra metodo ejecutarConsulta
}
