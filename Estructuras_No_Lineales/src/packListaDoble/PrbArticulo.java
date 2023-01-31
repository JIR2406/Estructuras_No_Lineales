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
public class PrbArticulo
{

    public static void main(String[] args)
    {
        int op;
        Scanner sc = new Scanner(System.in);
        ListaDobleOrd lista = new ListaDobleOrd();
        ListaDobleOrd copia = new ListaDobleOrd();
        do
        {
            System.out.println("1. Insertar artículo.");
            System.out.println("2. Eliminar artículo por código.");
            System.out.println("3. Desplegar lista del artículo.");
            System.out.println("4. Desplegar artículos por categoría específica.");
            System.out.println("5. Modificar precio unitario de artículos");
            System.out.println("6 Copiar (sin eliminar"
                    + "losarticulos de cierta categoria a otra lista");
            System.out.println("7 Desplegar Nueva lista");
            System.out.println("8 Desplegar  lista recursividad ascendente");
            System.out.println("9 Desplegar  lista recursividad descendente");
            System.out.println("10 Buscar Articulo por codigo");
            System.out.println("0. Salir");
            System.out.print("Ingrese opción:\t");
            op = sc.nextInt();
            switch (op)
            {
                case 1:
                {
                    System.out.println("Codigo:");
                    int cod = sc.nextInt();
                    System.out.println("Categoria:");
                    char cat = sc.next().charAt(0);
                    System.out.println("Descripcion:");
                    sc.nextLine();
                    String desc = sc.nextLine();
                    System.out.println("Cantidad:");
                    float cant = sc.nextFloat();
                    System.out.println("Precio:");
                    float precio = sc.nextFloat();
                    System.out.println("Importe Total: $" + (precio * cant));
                    Articulo obA = new Articulo(cod, cat, desc, cant, precio);
                    NodoD obN = new NodoD(obA);
                    lista.insert(obN);

                    break;
                }
                case 2:
                {
                    if (lista.empty())
                    {
                        System.out.println("No existen valores,favor de ingresar");
                    } else
                    {
                        System.out.println("Ingrese codigo del producto a eliminar");
                        int cod = sc.nextInt();
                        NodoD result = lista.remove(cod);
                        if (result == null)
                        {
                            System.out.println("El codigo no existe \n intentelo nuevamente");
                        } else
                        {
                            System.out.println("Articulo Eliminado");
                        }
                    }
                    break;
                }
                case 3:
                {
                    if (lista.empty())
                    {
                        System.out.println("No existen valores,favor de ingresar");
                    } else
                    {
                        int op2;
                        NodoD auxFin = lista.getFin();
                        NodoD auxFren = lista.getFrente();
                        if (lista.empty())
                        {
                            System.out.println("No existe");
                        } else
                        {

                            do
                            {
                                System.out.println("1.-Ascendente");
                                System.out.println("2.-Descendente");
                                System.out.println("0.-Salir");
                                op2 = sc.nextInt();
                                switch (op2)
                                {
                                    case 1:
                                        lista.despliegueA();
                                        break;
                                    case 2:
                                        lista.despliegueD();
                                        break;
                                    case 0:
                                        break;

                                    default:
                                        System.out.println("No existe opcion");
                                }
                            } while (op2 != 0);
                        }
                    }
                    break;
                }
                case 4:
                {
                    System.out.println("Insertar la categoria a buscar");
                    char bus = sc.next().charAt(0);
                    lista.despliegueCat2(bus);
                    break;
                }
                case 5:
                {
                    if (lista.empty())
                    {
                        System.out.println("Lista de articulos vacia");
                    } else
                    {
                        System.out.println("Ingrese codigo del producto a modificar");
                        int cod = sc.nextInt();
                        System.out.println("Ingrese el precio a Actualizar");
                        int precio=sc.nextByte();
                        NodoD result = lista.modPrecio(cod,precio);
                        if (result == null)
                        {
                            System.out.println("El codigo no existe \n intentelo nuevamente");
                        } else
                        {
                            System.out.println("Articulo Modificado");
                        }
                    }
                    break;
                }
               case 6:
                {
                   System.out.println("Insertar la categoria a copiar");
                    char bus = sc.next().charAt(0);
                    copy(lista, copia, bus);
                    
                   
                    break;
                }
               case 7:
               {
                copia.despliegueA();
                   break;
               }
               case 8:
               {
                   NodoD nd = lista.getFin();
                   lista.desplegarRecursividadAs(nd);
                   break;
               }
               case 9:
               {
                   NodoD nd = lista.getFin();
                   lista.desplegarRecursividadDes(nd);
                   break;
               }
               case 10:
               {
                   System.out.println("Ingresar codigo de articulo a buscar:");
                   int code= sc.nextInt();
                   NodoD nd= lista.getFin();
                   lista.buscarCodigo(code, nd);
                   break;
               }
                case 0:
                    break;
                default:
                    break;
            }
        } while (op != 0);
    }
    
        public static ListaDobleOrd copy(ListaDobleOrd lista, ListaDobleOrd copia, char categoria)
     {
        try
        {

            NodoD aux = lista.getFrente();
            Articulo auxA = (Articulo) aux.getInfo();
             while (aux != lista.getFin().getSig()){
               if (auxA.getCat() == categoria)
                {
                    copia.insert(aux);

                }
                aux = aux.getSig();
                auxA = (Articulo) aux.getInfo();
                System.out.println("Articulo Agregado");   
             }

        } catch (Exception e)
        {
        }

        return copia;
    }
}
