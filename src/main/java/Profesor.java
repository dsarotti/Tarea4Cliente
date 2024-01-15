import java.io.Serializable;

/**
 * La clase Profesor representa a un docente y es serializable para facilitar la transmisión de objetos
 * de este tipo a través de la red u otros medios.
 */
public class Profesor implements Serializable {
    /**
     * Identificador único del profesor.
     */
    private int idprofesor;
    /**
     * Nombre del profesor.
     */
    private String nombre;
    /**
     * Lista de asignaturas asociadas al profesor.
     */
    private Asignatura[] asignaturas;
    /**
     * Especialidad del profesor.
     */
    private Especialidad especialidad;

    /**
     * Constructor de la clase Profesor que inicializa sus atributos.
     *
     * @param idprofesor   Identificador único del profesor.
     * @param nombre       Nombre del profesor.
     * @param asignaturas  Lista de asignaturas asociadas al profesor.
     * @param especialidad Especialidad del profesor.
     */
    public Profesor(int idprofesor, String nombre, Asignatura[] asignaturas, Especialidad especialidad) {
        this.idprofesor = idprofesor;
        this.nombre = nombre;
        this.asignaturas = asignaturas;
        this.especialidad = especialidad;
    }

    /**
     * Establece el identificador único del profesor.
     *
     * @param idprofesor Nuevo identificador único del profesor.
     */
    public void setIdprofesor(int idprofesor) {
        this.idprofesor = idprofesor;
    }

    /**
     * Obtiene el identificador único del profesor.
     *
     * @return El identificador único del profesor.
     */
    public int getIdprofesor() {
        return idprofesor;
    }

    /**
     * Establece el nombre del profesor.
     *
     * @param nombre Nuevo nombre del profesor.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el nombre del profesor.
     *
     * @return El nombre del profesor.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece la lista de asignaturas asociadas al profesor.
     *
     * @param asignaturas Nueva lista de asignaturas asociadas al profesor.
     */
    public void setAsignaturas(Asignatura[] asignaturas) {
        this.asignaturas = asignaturas;
    }

    /**
     * Obtiene la lista de asignaturas asociadas al profesor.
     *
     * @return La lista de asignaturas asociadas al profesor.
     */
    public Asignatura[] getAsignaturas() {
        return asignaturas;
    }

    /**
     * Establece la especialidad del profesor.
     *
     * @param especialidad Nueva especialidad del profesor.
     */
    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    /**
     * Obtiene la especialidad del profesor.
     *
     * @return La especialidad del profesor.
     */
    public Especialidad getEspecialidad() {
        return especialidad;
    }
}
