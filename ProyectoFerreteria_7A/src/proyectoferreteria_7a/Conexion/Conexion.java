package proyectoferreteria_7a.Conexion;

// Clases necesaria
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Conexion {
    String CadenaConexion;
    Connection conn=null;
    public Conexion(){
        this.CadenaConexion = "jdbc:sqlite:src//Database//ProyectoFerreteria.s3db";
    }
    public Connection Conectar(){
        try {
            Class.forName("org.sqlite.JDBC");
            this.conn= DriverManager.getConnection(CadenaConexion);
        } catch (Exception e) {
            System.out.println("Problemas al conectarse"+e);
        }
      return this.conn;
    }
    
    public void Desconectar(){
        this.conn=null;
    }
    
   
    public int EjecutarComandoSQL(String Sentencia){
        try {
         PreparedStatement pstm=Conectar().prepareStatement(Sentencia);
         pstm.execute();
         return 1;
        }catch (SQLException e) {
            System.out.println(e);
            return 0;
        }
    
    }
    public ResultSet EjecutarSentenciaSQL(String Sentencia){
     try {
         PreparedStatement pstm=Conectar().prepareStatement(Sentencia);
         pstm.execute();
          ResultSet Resultado=pstm.executeQuery();
           return Resultado;
        }catch (SQLException e) {
            System.out.println(e);
         return null;   
        }
    }
}
