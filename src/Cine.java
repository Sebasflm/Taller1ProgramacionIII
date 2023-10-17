import java.util.LinkedList;
import java.util.Queue;

public class Cine {
    //En el diseño del Formulario existe un label actualice a su Nombre y Apellido
    //No borre ninguna sección del codigo proporcionado,
    // Si borra tendrá la nota minima 1.0
    //Se necesita completar las clases Cine y Formulario
    //Con los algoritmos y métodos necesarios de la estructura FIFO
    //Enunciado: Cada sala de cine tiene una capacidad de 25 espacios, solo se
    //pueden comprar como máximo 4 entradas por cliente a una pelicula.
    //Desplegar cada una de las compras en el textArea.
    //Se necesita consultar cuántos espacios quedan disponibles por cada una
    //de las peliculas.
    //Rubrica de calificación:
    //Completar la clase Cine 4 Puntos.
    //Agregar elemento a la Cola y mostrar en el textArea 2 Puntos.
    //Programar los botones para conocer la cantidad de espacios disponibles 4 Puntos.
    //Suba su programa a la plataforma hasta que finalice la hora.

    //Declare la referencia Cola para almacenar asistentes
    private Queue<Asistente> cola;
    private int entradasPelicula1=25;
    private int entradasPelicula2=25;
    public Cine(){
    //inicialice el objeto
        cola = new LinkedList<Asistente>();
    }

    public boolean esVacia(){
        // cambie el método para que funcione correctamente
     if(cola.isEmpty()){
         return true;
     }else {
         return false;
     }
    }

    public int tamanio(){
        //actualice la sentencia para que devuelva el tamaño de elementos en la cola
        return cola.size();
    }

    public void encolar(Asistente asistente, int pelicula){
        //complete el método
        if(pelicula==0){
            entradasPelicula1-=asistente.getCantidad();
        }else {
            entradasPelicula2-=asistente.getCantidad();
        }
        cola.add(asistente);
    }

    public Object desencolar() throws Exception{
        //actualice el método para eliminar el elemento del inicio.
        if (cola.isEmpty()) {
            throw new Exception("No hay asistentes");
        }else {
            return cola.poll();
        }
    }

    //cree un método para listar los elementos en una textArea.

    @Override
    public String toString() {
    StringBuilder sb= new StringBuilder();
    for (Asistente as: cola){
        sb.append(as.toString()+"\n");
    }
        return sb.toString();
    }


    //cree un método para conocer la cantidad de entradas disponibles
    public int numeroEntradasDisponibles(String pelicula){
        if (pelicula.equals("XMEN")){
            return entradasPelicula1;
        }else if (pelicula.equals("MARIO")){
            return entradasPelicula2;
        }else{
            return 0;
        }
    }

}
