package umariana.diario;

/**
 *
 * @author 
 * Juan Eraso, 
 * Juan Coronado
 */
public class Entrada {
    
    //Atributos
    private int idEntrada;
    private String fecha;
    private String descripcion;
    
    //Constructores
    public Entrada() {
    }
    
    public Entrada(int idEntrada, String fecha, String descripcion) {
        this.idEntrada = idEntrada;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }
    
    
    //Getters & Setters
    public int getIdEntrada() {
        return idEntrada;
    }

    public String getFecha() {
        return fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setIdEntrada(int idEntrada) {
        this.idEntrada = idEntrada;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}