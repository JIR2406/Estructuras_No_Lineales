/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packListaDoble;

/**
 *
 * @author SP-DR
 */
public class NodoD
{
   private Object info;
   private  NodoD sig,ant;
   
   public NodoD(Object info){
      sig=ant=null;
       this.info = info; 
      
   }

    public Object getInfo()
    {
        return info;
    }

    public void setInfo(Object info)
    {
        this.info = info;
    }

    public NodoD getSig()
    {
        return sig;
    }

    public void setSig(NodoD sig)
    {
        this.sig = sig;
    }

    public NodoD getAnt()
    {
        return ant;
    }

    public void setAnt(NodoD ant)
    {
        this.ant = ant;
    }
   
   
}
