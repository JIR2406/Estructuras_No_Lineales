
package packArbol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import packListaDoble.Articulo;
import packListaDoble.ListaDobleOrd;
import packListaDoble.NodoD;

public class prbArbol
{

    public static void main(String[] args)
    {
        Arbol obA = new Arbol();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        

        int op = 0, cod;
        String ubica, nom;
        do
        {
            System.out.println("Menu:");
            System.out.println("1.- Ingresar Almacen");//listo
            System.out.println("2.- Dar de baja Almacen");//listo
            System.out.println("3.- Desplegar Lista de Almacenes");//listo
            System.out.println("4.- Consultar Almacen y sus articulos");//listo
            System.out.println("5.- Desplegar Almacenes de costo mayor a..");//listo
            System.out.println("6.- Ingresar Articulos de Area");//listo
            System.out.println("7.- Contar almacenes con ubicacion en pasillo numero");//Listo
            System.out.println("8.-Contar Todos los Almacenes");//Listoooo
            System.out.println("0.- Salida");//a
            System.out.println("Ingresa Opcion");
            op = sc.nextInt();
            //op=Integer.parseInt(br.readLine());
            switch (op)
            {
                case 1:
                {
                    System.out.println("Ingresa codigo");
                    cod = sc.nextInt();
                    System.out.println("Ingresa nombre");
                    sc.nextLine();
                    nom = sc.nextLine();
                    System.out.println("Ingresa ubicacion");
                    ubica = sc.nextLine();//Se ingresa el la ubicacio #-### ej 9-2002
                    Almacen obAl = new Almacen(cod, nom, ubica);
                    obA.insert(obAl);
                    System.out.println("Dato agregado con exito :D");
                    break;
                }
                case 2:
                {
                    if (!obA.empty())
                    {
                    System.out.println("Ingresar codigo del almacen");
                    cod= sc.nextInt();
                    Almacen aux=obA.remove(cod);
                    if(aux!=null)
                    System.out.println("Almacen Eliminado" + aux.getCodAlm() + "" + aux.getNomAlm()
                        + "\nCosto Total:" + aux.getCostoTotal() + "\nUbicacion:" + aux.getUbica());
                    else
                    System.out.println("Almacen no encontrado");
                    }else
                    System.out.println("Arbol vacio");

                    break;
                }
                case 3:
                {
                    int op2 = 0;
                    do
                    {
                        System.out.println("MENU DESPLIEGUE");
                        System.out.println("1.-Por Preorden");
                        System.out.println("2.-Por Inorden");
                        System.out.println("3.-Por Postorden");
                        System.out.println("0.-Salir");
                        System.out.println("Selecciona una opcion");
                        op2 = sc.nextInt();
                        switch (op2)
                        {
                            case 1:
                                obA.preorden(obA.getRaiz());
                                break;
                            case 2:
                                obA.inorden(obA.getRaiz());
                                break;
                            case 3:
                                obA.postorden(obA.getRaiz());
                                break;
                            default:
                                System.out.println("Opcion invalida");
                        }

                    } while (op2 != 0);
                    System.out.println("Saliendo del submenu");
                    break;
                }
                case 4:
                {
                    System.out.println("Ingresar codigo del Almacen");
                    cod= sc.nextInt();
                    obA.desplegarLista(cod);
                    break;
                }
                case 5:
                {
                    System.out.println("Ingresar costo a comparacion almacenes");
                    float costo=sc.nextFloat();
                    Almacen aux=obA.getRaiz();
                    obA.mayorA(costo,aux);
                    break;
                }
                case 6:
                {
                    System.out.println("Ingresar codigo del Almacen");
                    int codAlm=sc.nextInt();
                    Almacen aux=obA.getRaiz();
                    if(aux==null){
                        System.out.println("Almacen inexistente");
                    }else{
                        Almacen verificar=obA.buscar(aux, codAlm);
                        if(verificar!=null){
                        int salir;
                        //decirle que si el codigo es 000 se salga del while
                            System.out.println("Codigo de salida 000");
                        System.out.println("Ingresar Codigo del articulo");
                        int codigo= sc.nextInt();
                        while(codigo!=000){
                        System.out.println("Ingresar Categoria del articulo");
                        sc.nextLine();
                        char cat= sc.next().charAt(0);
                        System.out.println("Ingresar descripcion del articulo");
                        sc.nextLine();
                        String desc= sc.next();
                        System.out.println("Ingresar cantidad del articulo");
                        float cant= sc.nextFloat();
                        System.out.println("Ingresar precio del articulo");
                        float precio=sc.nextFloat();
                        float costoTotal=precio*cant;
                        System.out.println("Total="+(precio*cant));
                        Articulo art= new Articulo(codigo, cat, desc, cant, precio);
                        NodoD obN = new NodoD(art);
                        obA.insertarArt(obN, codAlm, costoTotal);
                        System.out.println("Articulo agregado al almacen");}
                         System.out.println("Ingresar Codigo del articulo");
                         codigo= sc.nextInt();

                        }else
                            System.out.println("No se encontro almacen");
                        }
                    break;
                }
                case 7:
                {
                    System.out.println("Ingresar num de pasillo a desplegar");
                   int pasillo=sc.nextInt();
                   if(!obA.empty())
                   System.out.println("Pasillo"+obA.pasillo(obA.getRaiz(), pasillo, 0));
                   else
                   System.out.println("No existe arbol");
                break;
                }
                case 8:{
                    Almacen nodo=obA.getRaiz();
                    System.out.println("Se encontraron= "+obA.preordenContar(0, nodo)+" Almacenes");
                    break;
                }
                default:
                {
                    System.out.println("Opcion invalida");
                }
            }
        } while (op != 0);

    }

}
