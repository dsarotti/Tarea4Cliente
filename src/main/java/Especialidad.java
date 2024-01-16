import java.io.Serializable;

/**
 * La clase Especialidad representa una especialidad académica y es serializable para facilitar la transmisión de objetos
 * de este tipo a través de la red u otros medios.
 */
public class Especialidad implements Serializable {
    /**
     * Identificador único de la especialidad.
     */

    private int id;
    /**
     * Nombre de la especialidad.
     */
    private String nombreEspecialidad;

    /**
     * Constructor de la clase Especialidad que inicializa sus atributos.
     *
     * @param id                 Identificador único de la especialidad.
     * @param nombreEspecialidad Nombre de la especialidad.
     */
    public Especialidad(int id, String nombreEspecialidad) {
        this.id = id;
        this.nombreEspecialidad = nombreEspecialidad;
    }

    /**
     * Establece el identificador único de la especialidad.
     *
     * @param id Nuevo identificador único de la especialidad.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el identificador único de la especialidad.
     *
     * @return El identificador único de la especialidad.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el nombre de la especialidad.
     *
     * @param nombreEspecialidad Nuevo nombre de la especialidad.
     */
    public void setNombreEspecialidad(String nombreEspecialidad) {
        this.nombreEspecialidad = nombreEspecialidad;
    }

    /**
     * Obtiene el nombre de la especialidad.
     *
     * @return El nombre de la especialidad.
     */
    public String getNombreEspecialidad() {
        return nombreEspecialidad;
    }
}
