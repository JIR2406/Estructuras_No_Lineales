/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packListaDoble;

import java.util.Scanner;


/**
 *
 * @author SP-DR
 */
public class ListaDobleOrd
{

    private NodoD frente, fin;

    public NodoD getFrente()
    {
        return frente;
    }

    public void setFrente(NodoD frente)
    {
        this.frente = frente;
    }

    public NodoD getFin()
    {
        return fin;
    }

    public void setFin(NodoD fin)
    {
        this.fin = fin;
    }

//////////////////////////////////////////////////
    public boolean empty()
    {
        if (frente == null && fin == null)
        {
            return true;
        }
        return false;
    }

    /*public void insert(NodoD dato)
    {
        if (empty())
        {
            frente = fin = dato;
        } else
        {
            Articulo a = (Articulo) dato.getInfo();
            Articulo b = (Articulo) frente.getInfo();
            Articulo c = (Articulo) fin.getInfo();
            if (a.getCodigo() < b.getCodigo())
            {//SE HACE UNA COMPARACION DE STRINGS QUE RETORNAN UN VALOR COMPARANDO EL 0
                dato.setSig(frente);
                frente.setAnt(dato);
                //elfrente se tiene que inicializar con el dato
                frente = dato;
            } else
            {
                if (a.getCodigo() > c.getCodigo())
                {
                    dato.setAnt(fin);
                    fin.setSig(dato);
                    fin = dato;

                } else
                {

                    NodoD aux = frente;
                    Articulo auxT = (Articulo) aux.getInfo();
                    while (a.getCodigo() > auxT.getCodigo())
                    {
                        aux = aux.getSig();
                        auxT = (Articulo) aux.getInfo();
                    }
                    dato.setSig(aux);
                    dato.setAnt(aux.getAnt());
                    aux.setAnt(dato);
                    dato.getAnt().setSig(dato);

                }
            }
        }
    }*/
    public void insert(NodoD dato)
    {
        if (empty())
        {
            frente = fin = dato;
        } else
        {
            Articulo obIns = (Articulo) dato.getInfo(); //Casteo el tipo de dato
            Articulo obfrente = (Articulo) frente.getInfo(); //Casteo el tipo de dato
            Articulo obfin = (Articulo) fin.getInfo(); //Casteo el tipo de dato
            if (obIns.getCodigo() < obfrente.getCodigo())
            {
                dato.setSig(frente);
                frente.setAnt(dato);
                frente = dato;
            } else
            {
                if (obIns.getCodigo() > obfin.getCodigo())
                {
                    dato.setAnt(fin);
                    fin.setSig(dato);
                    fin = dato;
                } else
                {
                    NodoD aux = frente;
                    Articulo obAux = (Articulo) aux.getInfo(); //Si no se repite en el codigo se estaria comparando siempre con el mismo dato
                    while (obIns.getCodigo() > obAux.getCodigo())
                    {
                        aux = aux.getSig();
                        obAux = (Articulo) aux.getInfo();
                    }
                    //enlaces de cada nodo
                    dato.setSig(aux);
                    dato.setAnt(aux.getAnt());
                    aux.setAnt(dato);
                    dato.getAnt().setSig(dato);
                }
            }
        }
    }

    public NodoD remove(int codigo)
    {
        NodoD aux = buscar(codigo);
        if (aux == null)
        {
            return null;
        }
        if (frente == fin)
        {
            frente = fin = null;
            return aux;
        }
        if (aux == frente)
        {
            frente = frente.getSig();
            frente.setAnt(null);
            return aux;
        }
        if (aux == fin)
        {
            fin = fin.getAnt();
            fin.setSig(null);
            return aux;
        }
        aux.getAnt().setSig(aux.getSig());
        aux.getAnt().setAnt(aux.getAnt());

        return aux;

    }

    public NodoD buscar(int cod)
    {

        NodoD aux = frente;
        if (aux == null)
        {
            return aux;
        }
        Articulo AuxArt = (Articulo) aux.getInfo();
        while (aux != null && AuxArt.getCodigo() != cod)
        {
            aux = aux.getSig();
            if (aux != null)
            {
                AuxArt = (Articulo) aux.getInfo();
            }
        }
        return aux;
        //Null pointe: cuando queremos accesar a un elemento que sea nulo
    }

    public void despliegueA()
    {
        NodoD aux = frente;
        if (!empty())
        {
            while (aux != null)
            {
                Articulo obB = (Articulo) aux.getInfo();
                System.out.println("Categoria: " + obB.getCat());
                System.out.println("Codigo: " + obB.getCodigo());
                System.out.println("Descripcion: " + obB.getDesc());
                System.out.println("Precio: " + obB.getPrecio());
                System.out.println("Cantidad: " + obB.getCant());
                aux = aux.getSig();
            }
        }
    }

    public void despliegueD()
    {
        if (!empty())
        {
            NodoD aux = fin;
            while (aux != null)
            {
                Articulo obB = (Articulo) aux.getInfo();
                System.out.println("Categoria: " + obB.getCat());
                System.out.println("Codigo: " + obB.getCodigo());
                System.out.println("Descripcion: " + obB.getDesc());
                System.out.println("Precio: " + obB.getPrecio());
                System.out.println("Cantidad: " + obB.getCant());
                aux = aux.getAnt();
            }
        }
    }

    public void despliegueCat2(char cat)
    {
        NodoD aux = frente;
        if (!empty())
        {
            while (aux != null)
            {
                Articulo obB = (Articulo) aux.getInfo();
                if (cat == obB.getCat())
                {
                    System.out.println("Categoria: " + obB.getCat());
                    System.out.println("Codigo: " + obB.getCodigo());
                    System.out.println("Descripcion: " + obB.getDesc());
                    System.out.println("Precio: " + obB.getPrecio());
                    System.out.println("Cantidad: " + obB.getCant());
                }
                aux = aux.getSig();
            }
        }
    }

    public NodoD modPrecio(int cod, float precio)
    {
        NodoD aux = buscar(cod);
        Articulo obB = (Articulo) aux.getInfo();
        if (aux == null)
        {
            return null;
        }
        if (frente == fin)
        {
            frente = fin = null;
            return aux;
        }

        System.out.println("Ingrese el nuevo precio");
        obB.setPrecio(precio);
        System.out.println("Precio actualizado a :" + obB.getPrecio());
        return aux;
    }

    public void despliegueListaNew()
    {
        if (!empty())
        {
            NodoD aux = frente;
            while (aux != null)
            {
                Articulo obB = (Articulo) aux.getInfo();
                System.out.println("Categoria: " + obB.getCat());
                System.out.println("Codigo: " + obB.getCodigo());
                System.out.println("Descripcion: " + obB.getDesc());
                System.out.println("Precio: " + obB.getPrecio());
                System.out.println("Cantidad: " + obB.getCant());
                aux = aux.getSig();
            }
        }
        System.out.println("Articulos no agregados");
    }

    public void desplegarRecursividadDes(NodoD aux)
    {
        if (aux != null)
        {
            Articulo art = (Articulo) aux.getInfo();
            System.out.println("Codigo: " + art.getCodigo());
            System.out.println("Categoria: " + art.getCat());
            System.out.println("Descripcion: " + art.getDesc());
            System.out.println("Precio: " + art.getPrecio());
            System.out.println("Cantidad: " + art.getCant());
            desplegarRecursividadDes(aux.getAnt());
        }
    }

    public void desplegarRecursividadAs(NodoD aux)
    {
        //suponiendo que se da el frente :/
        if (aux != null)
        {
            desplegarRecursividadAs(aux.getAnt());
            Articulo art = (Articulo) aux.getInfo();
            System.out.println("Codigo: " + art.getCodigo());
            System.out.println("Categoria: " + art.getCat());
            System.out.println("Descripcion: " + art.getDesc());
            System.out.println("Precio: " + art.getPrecio());
            System.out.println("Cantidad: " + art.getCant());
        }
    }

    public void buscarCodigo(int code, NodoD aux)
    {
        if (aux != null)
        {
            
            Articulo art = (Articulo) aux.getInfo();
            if (code == art.getCodigo())
            {
                System.out.println("Se encontro el Articulo:");
                System.out.println("");
                System.out.println("Codigo: " + art.getCodigo());
                System.out.println("Categoria: " + art.getCat());
                System.out.println("Descripcion: " + art.getDesc());
                System.out.println("Precio: " + art.getPrecio());
                System.out.println("Cantidad: " + art.getCant());

            }
            else{
               buscarCodigo(code,aux.getAnt());
            }
        }

    }

}
