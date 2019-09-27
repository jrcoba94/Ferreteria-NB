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
public class FacturasBO 
{
    public String Id_Folio;
    public String Fecha;
    
    public FacturasBO()
    {
        
    }
    
    public String getId_Folio() 
    {
        return Id_Folio;
    }

    public void setId_Folio(String Id_Folio) 
    {
        this.Id_Folio = Id_Folio;
    }

    public String getFecha() 
    {
        return Fecha;
    }

    public void setFecha(String Fecha) 
    {
        this.Fecha = Fecha;
    }
}
