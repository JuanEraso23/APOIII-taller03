package umariana.diario;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author 
 * Juan Eraso, 
 * Juan Coronado
 */
public class Diario {
    
    ArrayList<Entrada> misEntradas= new ArrayList<>();
    Scanner lector= new Scanner(System.in);

    public static void main(String[] args) {
        Diario entrada = new Diario();
        entrada.mostrarMenu();
    }
    
    public void mostrarMenu() {
        boolean activo = true;
        
        
            do {
                System.out.println("========= INVENTARIO ===========");
                System.out.println("1. Agregar Entrada");
                System.out.println("2. Mostrar Entrada");
                System.out.println("3. Eliminar Entrada");
                System.out.println("4. Modificar Entrada");
                System.out.println("5. Salir");
                System.out.println("------------------------------------------------");

                int opcion = lector.nextInt();
                switch (opcion) {

                    case 1:
                        agregarEntrada();
                        break;
                        
                    case 2:
                        mostrarEntrada();
                        break;
                        
                    case 3:
                        eliminarEntrada();
                        break;
                        
                    case 4:
                        modificarEntrada();
                        break;
                        
                    case 5:
                        activo = false;
                        System.out.println("Hasta pronto...");
                        break;
                        
                    default:
                        System.out.println("Opción no válida, inténtelo nuevamente");
                }
            } while (activo);
    }
    
    public void agregarEntrada() {
        // Capturar la fecha del sistema
        int nuevoIdEntrada;
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy"); 
        String fecha = formato.format (new Date());
                        
        if(misEntradas.isEmpty()) {
            nuevoIdEntrada=1;
        } else {
            // Obtener el ultimo IdEntrada ingresado y sumarle uno
            int tamanoLista = misEntradas.size(); 
            Entrada ultimaEntrada = misEntradas.get(tamanoLista - 1);
            nuevoIdEntrada = ultimaEntrada.getIdEntrada()+ 1;
        }
                        
        // Solicitar la entrada de la descripción al usuario
        System.out.println("Ingrese la descripción: ");
        lector.nextLine(); //evitar que se salte el ingreso de la descripción
                        
        String descripcion = lector.nextLine();
        // Crear el objeto para insertar los datos obtenidos
        Entrada miEntrada = new Entrada(nuevoIdEntrada, fecha, descripcion);
        // Agregar el objeto a la contenedora variable
        misEntradas.add(miEntrada);
    }
    
    public void mostrarEntrada() {
        for(Entrada e: misEntradas) {  
            System.out.println("Id: "+e.getIdEntrada());
            System.out.println("fecha: "+e.getFecha());
            System.out.println("descripción: "+e.getDescripcion());
            System.out.println("----------------------------------");
        }
    }
    
    public void eliminarEntrada() {
        System.out.println("Digite el Id de la entrada a eliminar");
        int id = lector.nextInt();
        
        Iterator<Entrada> it = misEntradas.iterator();
        while(it.hasNext()) {
            Entrada e =(Entrada) it.next();
            if(e.getIdEntrada()==id) {
                it.remove();                 
            }
        }
        System.out.println("Entrada eliminada con exito!");
    }
    
    public void modificarEntrada() {
        System.out.println("Digite el Id de la Entrada a modificar");
        int id2 = lector.nextInt();
                        
        System.out.println("Ingrese la nueva descripción: ");
        lector.nextLine();
        String nuevaDescripcion = lector.nextLine();
                        
        Iterator<Entrada> it2 = misEntradas.iterator();
        while(it2.hasNext()) {
        Entrada e =(Entrada) it2.next();
            if(e.getIdEntrada()==id2) {
                e.setDescripcion(nuevaDescripcion);
            }
        }
        System.out.println("Entrada modificada con exito!");
    }
}