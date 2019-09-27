/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoferreteria_7a.BO;

/**
 *
 * @author Daryl
 */
public class PedidosBO 
{
    public String Id_Pedido;
    public String FechaSolicitud;
    public String NumeroProductos;
    public String Cantidad;
    
    public PedidosBO()
    {
        
    }
    
    public String getId_Pedido() 
    {
        return Id_Pedido;
    }

    public void setId_Pedido(String Id_Pedido) 
    {
        this.Id_Pedido = Id_Pedido;
    }

    public String getFechaSolicitud() 
    {
        return FechaSolicitud;
    }

    public void setFechaSolicitud(String FechaSolicitud) 
    {
        this.FechaSolicitud = FechaSolicitud;
    }

    public String getNumeroProductos() 
    {
        return NumeroProductos;
    }

    public void setNumeroProductos(String NumeroProductos) 
    {
        this.NumeroProductos = NumeroProductos;
    }

    public String getCantidad() 
    {
        return Cantidad;
    }

    public void setCantidad(String Cantidad) 
    {
        this.Cantidad = Cantidad;
    }
}
