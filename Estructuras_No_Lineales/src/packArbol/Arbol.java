
package packArbol;

import packListaDoble.Articulo;
import packListaDoble.ListaDobleOrd;
import packListaDoble.NodoD;

/**
 *
 * @author SP-DR
 */
public class Arbol
{

    private Almacen raiz;

    public Almacen getRaiz()
    {
        return raiz;
    }

    public void setRaiz(Almacen raiz)
    {
        this.raiz = raiz;
    }

    public boolean empty()
    {
        if (raiz == null)
        {
            return true;
        }

        return false;
    }

    public boolean insert(Almacen nodo)
    {//recibimos el nodo que vamos a insertar
        if (empty())
        {
            raiz = nodo;
        } else
        {
            Almacen tem = raiz;
            boolean comp = true;
            do
            {
                if (nodo.getCodAlm() < tem.getCodAlm())
                {
                    if (tem.gethIzqui() == null)
                    {
                        tem.sethIzqui(nodo);
                    } else
                    {
                        tem = tem.gethIzqui();
                    }
                } else if (nodo.getCodAlm() != tem.getCodAlm())
                {
                    if (tem.gethDer() == null)
                    {
                        tem.sethDer(nodo);
                    } else
                    {
                        tem = tem.gethDer();
                    }
                } else
                {
                    return false;
                }
            } while (tem.gethIzqui() != nodo && tem.gethDer() != nodo);
        }
        return true;
    }

  public Almacen remove(int codE) {
        
        Almacen aux = raiz;
        Almacen padre = null;
        while (aux != null && aux.getCodAlm() != codE) {
            padre = aux;
            if (codE < aux.getCodAlm()) {
                aux = aux.gethIzqui();
            } else {
                aux = aux.gethDer();
            }
        }
        if (aux == null) {
            return null;
        } else {
            //eliminacion de hoja 
            if (aux.gethIzqui() == null && aux.gethDer() == null) {
                if (aux == raiz) {
                    raiz = null;
                } else if (aux == padre.gethIzqui()) {
                    padre.sethIzqui(null);
                } else {
                    padre.sethDer(null);
                }
                return aux;
            }
            //Un hijo
            if (aux.gethIzqui() == null || aux.gethDer() == null) {
                if (aux == raiz) {
                    if (aux.gethIzqui() == null) {
                        raiz = aux.gethDer();
                    } else {
                        raiz = aux.gethIzqui();
                    }
                } else if (aux == padre.gethIzqui()) {
                    if (aux.gethIzqui() == null) {
                        padre.sethIzqui(aux.gethDer());
                    } else {
                        padre.sethIzqui(aux.gethIzqui());
                    }
                } else if (aux.gethIzqui()== null) {
                    padre.sethDer(aux.gethDer());
                } else {
                    padre.sethDer(aux.gethIzqui());
                }
                return aux;
            }

            }
                    //con dos hijos
            if (aux == raiz) {
                
            } else if (aux.gethIzqui().gethDer() == null) {
                
                if (padre.gethIzqui()== aux) {
                    padre.sethIzqui(aux.gethIzqui());
                } else {
                    padre.sethDer(aux.gethIzqui());
                    aux.gethIzqui().sethDer(aux.gethDer());
                }
              
            }else
            {
                Almacen aux2=aux.gethIzqui();
                Almacen padre2=null;
                while(aux2.gethDer()!=null){
                    padre2=aux2;
                    aux2=aux2.gethDer();
                }
                padre2.sethDer(aux2.gethIzqui());
                aux2.sethIzqui(aux.gethIzqui());
                aux2.sethDer(aux.gethDer());
                if(padre.gethDer()==aux){
                   padre.sethIzqui(aux2);
                }else{
                    padre.sethDer(aux2);  
                }
        
        }
        return aux;
  }
   


    /* public boolean remove(int d)
    {
        if (!empty())
        {
            Almacen auxiliar = raiz;
            Almacen padre = raiz;
            boolean hijoizq = true;
            while (auxiliar.getCodAlm() != d)
            {
                padre = auxiliar;
                if (d < auxiliar.getCodAlm())
                {
                    hijoizq = true;
                    auxiliar = auxiliar.gethIzqui();
                } else
                {
                    hijoizq = false;
                    auxiliar = auxiliar.gethDer();
                }
                if (auxiliar == null)
                {
                    return false;
                }
            }//si es hoja 
            if (auxiliar.gethIzqui() == null && auxiliar.gethDer() == null)
            {
                if (auxiliar == raiz)
                {
                    raiz = null;
                } else if (hijoizq)
                {
                    padre.sethIzqui(null);
                } else
                {
                    padre.sethDer(null);
                }
            } else if (auxiliar.gethDer() == null)
            {
                if (auxiliar == raiz)
                {
                    raiz = auxiliar.gethIzqui();
                } else if (hijoizq)
                {
                    padre.sethIzqui(auxiliar.gethIzqui());
                } else
                {
                    padre.sethDer(auxiliar.gethIzqui());
                }
            } else if (auxiliar.gethIzqui() == null)
            {
                if (auxiliar == raiz)
                {
                    raiz = auxiliar.gethDer();
                } else if (hijoizq)
                {
                    padre.sethIzqui(auxiliar.gethDer());
                } else
                {
                    padre.sethDer(auxiliar.gethDer());
                }// es la raiz
            } else
            {
                Almacen reemplazo = ObtenerReemplazo(auxiliar);
                if (auxiliar == raiz)
                {
                    raiz = reemplazo;
                } else if (hijoizq)
                {
                    padre.sethIzqui(reemplazo);
                } else
                {
                    padre.sethDer(reemplazo);
                }
                reemplazo.sethDer(auxiliar.gethIzqui());
            }
            return true;
        } else
        {
            return false;
        }
    }

    public Almacen ObtenerReemplazo(Almacen nodoreemplazo)
    {
        Almacen reemplazarpadre = nodoreemplazo;
        Almacen reemplazo = nodoreemplazo;
        Almacen auxiliar = nodoreemplazo.gethDer();
        while (auxiliar != null)
        {
            reemplazarpadre = reemplazo;
            reemplazo = auxiliar;
            auxiliar = auxiliar.gethIzqui();
        }
        if (reemplazo != nodoreemplazo.gethDer())
        {
            reemplazarpadre.sethIzqui(reemplazo.gethDer());
            reemplazo.sethDer(nodoreemplazo.gethDer());
        }
        System.out.println("El Nodo Reemplazo es:" + reemplazo);
        return reemplazo;
    }*/

    public void inorden(Almacen nodo)
    {
        if (nodo != null)
        {
            inorden(nodo.gethIzqui());
            System.out.println("Almacen " + nodo.getCodAlm() + ":" + nodo.getNomAlm()
                    + "\nCosto Total:" + nodo.getCostoTotal() + "\nUbicacion: " + nodo.getUbica());
            System.out.println("");
            inorden(nodo.gethDer());
        }
    }

    public void preorden(Almacen nodo)
    {
        if (nodo != null)
        {
            System.out.println("Almacen " + nodo.getCodAlm() + ":" + nodo.getNomAlm()
                    + "\nCosto Total:" + nodo.getCostoTotal() + "\nUbicacion: " + nodo.getUbica());
            System.out.println("");
            preorden(nodo.gethIzqui());
            preorden(nodo.gethDer());
        }

    }

    public void postorden(Almacen nodo)
    {
        if (nodo != null)
        {
            postorden(nodo.gethIzqui());
            postorden(nodo.gethDer());
            System.out.println("Almacen " + nodo.getCodAlm() + ":" + nodo.getNomAlm()
                    + "\nCosto Total:" + nodo.getCostoTotal() + "\nUbicacion: " + nodo.getUbica());
            System.out.println("");
        }
    }

    public void mayorA(float precio, Almacen nodo)
    {
        if (nodo != null)
        {
            mayorA(precio, nodo.gethIzqui());
            if (nodo.getCostoTotal() > precio)
            {
                System.out.println("Almacen" + nodo.getCodAlm() + "" + nodo.getNomAlm()
                        + "\nCosto Total:" + nodo.getCostoTotal() + "\nUbicacion:" + nodo.getUbica());
            }
            mayorA(precio, nodo.gethDer());
        }
    }

    public void contarAlmacen()
    {//tarea :c
        if (!empty())
        {

        }
    }

    public Almacen buscar(Almacen aux, int cod)
    {
        if (aux == null)
        {
            return null;
        }
        if (aux.getCodAlm() == cod)
        {
            return aux;
        }
        if (aux.getCodAlm() > cod)
        {
            return buscar(aux.gethIzqui(), cod);
        } else
        {
            return buscar(aux.gethDer(), cod);
        }
    }

    public void insertarArt(NodoD obN, int codAlm, float costoTotal)
    {
        if (!empty())
        {
            Almacen main = buscar(raiz, codAlm);
            ListaDobleOrd aux = main.getListaArt();
            float total = main.getCostoTotal();
            if (total == 0.0)
            {
                total = costoTotal;
            } else
            {
                total = main.getCostoTotal() + costoTotal;
            }
            if (aux == null)
            {
                ListaDobleOrd lista = new ListaDobleOrd();

                main.setCostoTotal(total);
                lista.insert(obN);
                main.setListaArt(lista);
            } else
            {
                main.setCostoTotal(total);
                aux.insert(obN);
                main.setListaArt(aux);
            }

        }
    }

    public void desplegarLista(int cod)
    {
        Almacen auxAlm = buscar(raiz, cod);
        ListaDobleOrd lista = auxAlm.getListaArt();
        lista.despliegueA();
    }

    public int preordenContar(int c,Almacen nodo){
        if(nodo!=null){
            
          c++;  
         c=preordenContar(c, nodo.gethIzqui());
         c=preordenContar(c,nodo.gethDer());
        }
        return c;
    }
    public int pasillo(Almacen nodo, int pasillo, int c)
    {

        if (nodo != null)
        {
            int pasNodo = Character.getNumericValue(nodo.getUbica().charAt(0));
            if ( pasNodo == pasillo )
            {
                c++;
            }
            c=pasillo(nodo.gethIzqui(), pasillo, c);
            c=pasillo(nodo.gethDer(), pasillo, c);
        }
        return c;
    }

}
