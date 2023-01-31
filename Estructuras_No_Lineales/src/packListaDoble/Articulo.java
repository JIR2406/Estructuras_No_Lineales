
package packListaDoble;

/**
 *
 * @author SP-DR
 */
public class Articulo
{
    private int codigo;
    private char cat;
    private String desc;
    private float cant;
    private float precio;
   
    public Articulo(int codigo, char cat, String desc, float cant, float precio)
    {
        this.codigo = codigo;
        this.cat = cat;
        this.desc = desc;
        this.cant = cant;
        this.precio = precio;
    }

    public int getCodigo()
    {
        return codigo;
    }

    public void setCodigo(int codigo)
    {
        this.codigo = codigo;
    }

    public char getCat()
    {
        return cat;
    }

    public void setCat(char cat)
    {
        this.cat = cat;
    }

    public String getDesc()
    {
        return desc;
    }

    public void setDesc(String desc)
    {
        this.desc = desc;
    }

    public float getCant()
    {
        return cant;
    }

    public void setCant(float cant)
    {
        this.cant = cant;
    }

    public float getPrecio()
    {
        return precio;
    }

    public void setPrecio(float precio)
    {
        this.precio = precio;
    }
    
}
