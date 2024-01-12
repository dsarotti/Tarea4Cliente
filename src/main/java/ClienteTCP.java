import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClienteTCP {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Socket socket = null;
        PrintWriter salida = null;
        ObjectInputStream in = null;

        try {
            socket = new Socket("localhost", 12345);
            salida = new PrintWriter(socket.getOutputStream(), true);
            in = new ObjectInputStream(socket.getInputStream());

            // Obtener el identificador asignado por el servidor
            int clienteId = in.readInt();
            System.out.println("SOY EL CLIENTE: " + clienteId);

            while (true) {
                System.out.print("Introduce identificador a consultar (* para salir): ");
                String input = scanner.nextLine();

                if (input.equals("*")) {
                    break;
                }

                try {
                    int idProfesor = Integer.parseInt(input);
                    salida.println(idProfesor);

                    // Recibir y mostrar datos del profesor
                    Object obj = in.readObject();
                    if (obj instanceof Profesor) {
                        Profesor profesor = (Profesor) obj;
                        mostrarDatosProfesor(profesor);
                    } else {
                        System.out.println("Profesor no encontrado");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Por favor, introduce un identificador válido.");
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                try {
                    // Cerrar recursos
                    salida.close();
                    in.close();
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void mostrarDatosProfesor(Profesor profesor) {
        System.out.println("Nombre: " + profesor.getNombre() +
                ", Especialidad: " + profesor.getEspecialidad().getId() + " - " + profesor.getEspecialidad().getNombreEspecialidad());

        System.out.println("Asignaturas:");
        for (Asignatura asignatura : profesor.getAsignaturas()) {
            System.out.println(" - " + asignatura.getId() + " - " + asignatura.getNombreAsignatura());
        }
    }
}
