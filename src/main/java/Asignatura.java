import java.io.Serializable;

/**
 * La clase Asignatura representa una asignatura académica y es serializable para facilitar la transmisión de objetos
 * de este tipo a través de la red u otros medios.
 */
public class Asignatura implements Serializable {

    /**
     * Identificador único de la asignatura.
     */
    private int id;
    /**
     * Nombre de la asignatura.
     */
    private String nombreAsignatura;

    /**
     * Constructor de la clase Asignatura que inicializa sus atributos.
     *
     * @param id               Identificador único de la asignatura.
     * @param nombreAsignatura Nombre de la asignatura.
     */
    public Asignatura(int id, String nombreAsignatura) {
        this.id = id;
        this.nombreAsignatura = nombreAsignatura;
    }

    /**
     * Obtiene el identificador único de la asignatura.
     *
     * @return El identificador único de la asignatura.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador único de la asignatura.
     *
     * @param id Nuevo identificador único de la asignatura.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre de la asignatura.
     *
     * @return El nombre de la asignatura.
     */
    public String getNombreAsignatura() {
        return nombreAsignatura;
    }

    /**
     * Establece el nombre de la asignatura.
     *
     * @param nombreAsignatura Nuevo nombre de la asignatura.
     */
    public void setNombreAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }
}