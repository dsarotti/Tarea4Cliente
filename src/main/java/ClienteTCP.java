import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

/**
 * La clase ClienteTCP implementa un cliente que se conecta a un servidor TCP para consultar información sobre profesores.
 */
public class ClienteTCP {

    /**
     * El método principal que inicia la ejecución del cliente.
     *
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Socket socket = null;
        PrintWriter salida = null;
        ObjectInputStream in = null;


        System.out.println("PROGRAMA CLIENTE INICIADO...");
        try {
            // Establecer conexión con el servidor
            socket = new Socket("localhost", 12345);
            salida = new PrintWriter(socket.getOutputStream(), true);
            in = new ObjectInputStream(socket.getInputStream());

            // Obtener el identificador asignado por el servidor
            int clienteId = in.readInt();
            System.out.println("SOY EL CLIENTE: " + clienteId);
            System.out.println("============================================================");

            // Ciclo principal para realizar consultas al servidor
            while (true) {
                System.out.print("Introduce identificador a consultar (* para salir): ");
                String input = scanner.nextLine();


                try {
                    // Enviar identificador al servidor
                    int idProfesor = Integer.parseInt(input);
                    salida.println(idProfesor);

                    // Recibir y mostrar datos del profesor
                    Object obj = in.readObject();
                    if (obj instanceof Profesor) {
                        Profesor profesor = (Profesor) obj;
                        mostrarDatosProfesor(profesor);
                    } else {
                        System.out.println("No se ha recibido un profesor.");
                    }
                } catch (NumberFormatException e) {
                    if (input.equals("*")) {
                        salida.println(input);
                        break;
                    }
                    System.out.println("Por favor, introduce un identificador válido.");
                } catch (SocketException e ){
                    System.err.println("El servidor ha dejado de responder. Cerrando el cliente.");
                    break;
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Conexión rechazada por el servidor.");
        } finally {
            // Cerrar recursos al finalizar
            if (socket != null && !socket.isClosed()) {
                try {
                    salida.close();
                    in.close();
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Método auxiliar para mostrar los datos de un profesor en la consola.
     *
     * @param profesor El objeto Profesor cuyos datos se mostrarán.
     */
    private static void mostrarDatosProfesor(Profesor profesor) {
        System.out.println(("Nombre: " + profesor.getNombre() + ", Especialidad: " + profesor.getEspecialidad().getId() + " - " + profesor.getEspecialidad().getNombreEspecialidad()).indent(4).stripTrailing());

        if (profesor.getAsignaturas().length > 0) {
            for (Asignatura asignatura : profesor.getAsignaturas()) {
                System.out.println(("Asignatura: " + asignatura.getId() + " - " + asignatura.getNombreAsignatura()).indent(8).stripTrailing());
            }
        }
        System.out.println("============================================================");

    }
}
