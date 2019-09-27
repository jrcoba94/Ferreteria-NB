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
public class ProductosBO 
{
    public String Id_Producto;
    public String Cantidad;
    public String Precio;
    public String Categoria;
    public String Producto;
    public String Estatus;
    public String FechaPedido;
    public String Imagen;

    public String getProducto() {
        return Producto;
    }

    public void setProducto(String Producto) {
        this.Producto = Producto;
    }
    
    public ProductosBO()
    {
        
    }
    

    public String getId_Producto() 
    {
        return Id_Producto;
    }

    public void setId_Producto(String Id_Producto) 
    {
        this.Id_Producto = Id_Producto;
    }

    public String getCantidad() 
    {
        return Cantidad;
    }

    public void setCantidad(String Cantidad) 
    {
        this.Cantidad = Cantidad;
    }

    public String getPrecio() 
    {
        return Precio;
    }

    public void setPrecio(String Precio) 
    {
        this.Precio = Precio;
    }

    public String getCategoria() 
    {
        return Categoria;
    }

    public void setCategoria(String Categoria) 
    {
        this.Categoria = Categoria;
    }

    public String getEstatus() 
    {
        return Estatus;
    }

    public void setEstatus(String Estatus) 
    {
        this.Estatus = Estatus;
    }

    public String getFechaPedido() 
    {
        return FechaPedido;
    }

    public void setFechaPedido(String FechaPedido) 
    {
        this.FechaPedido = FechaPedido;
    }
    
    public String getImagen()
    {
        return Imagen;
    }
    
    public void setImagen(String Imagen)
    {
        this.Imagen = Imagen;
    }
}
