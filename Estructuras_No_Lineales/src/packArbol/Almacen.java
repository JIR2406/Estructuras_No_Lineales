
package packArbol;

import packListaDoble.ListaDobleOrd;

/**
 *
 * @author SP-DR
 */
public class Almacen
{
 
    private int codAlm;
    private String nomAlm;
    private float costoTotal; //La suma de todos los nodos
    private ListaDobleOrd ListaArt;
    private String ubica;
    //cada nodo se enlaza con sus dos hijos, sono las dos referencias
    private Almacen hIzqui, hDer;

    public Almacen(int codAlm, String nomAlm, String ubica)
    {
        this.codAlm = codAlm;
        this.nomAlm = nomAlm;
        this.ubica = ubica;
        this.costoTotal = costoTotal;
        ListaArt=new ListaDobleOrd();
    }

    public ListaDobleOrd getListaArt()
    {
        return ListaArt;
    }

    public void setListaArt(ListaDobleOrd ListaArt)
    {
        this.ListaArt = ListaArt;
    }

    public Almacen gethIzqui()
    {
        return hIzqui;
    }

    public void sethIzqui(Almacen hIzqui)
    {
        this.hIzqui = hIzqui;
    }

    public Almacen gethDer()
    {
        return hDer;
    }

    public void sethDer(Almacen hDer)
    {
        this.hDer = hDer;
    }

    
    public int getCodAlm()
    {
        return codAlm;
    }

    public void setCodAlm(int codAlm)
    {
        this.codAlm = codAlm;
    }

    public String getNomAlm()
    {
        return nomAlm;
    }

    public void setNomAlm(String nomAlm)
    {
        this.nomAlm = nomAlm;
    }

    public float getCostoTotal()
    {
        return costoTotal;
    }

    public void setCostoTotal(float costoTotal)
    {
        this.costoTotal = costoTotal;
    }

    public String getUbica()
    {
        return ubica;
    }

    public void setUbica(String ubica)
    {
        this.ubica = ubica;
    }

  
    
    
}
