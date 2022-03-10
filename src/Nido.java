/**
 * The type Nido.
 */
public class Nido {
    private String nombre;
    private Snake[] serpientes = new Snake[20];
    private int numSerpientes;

    /**
     * Instantiates a new Nido.
     *
     * @param nombre the nombre
     */
    public Nido(String nombre) {
        this.nombre = nombre;
        this.numSerpientes = 1;
        serpientes[0] = new Snake("serpiente " + numSerpientes);
    }

    /**
     * Nacimiento.
     */
    public void nacimiento() {
        int randm = (int) (Math.random() * 3);
        for (int i = 0; i <= randm && numSerpientes < serpientes.length; i++) {
            this.serpientes[numSerpientes] = new Snake("serpiente " + numSerpientes);
            numSerpientes++;
        }
    }

    /**
     * Limpiar nido.
     */
    public void limpiarNido() {
        for (int i = 0; i < numSerpientes; i++) {
            if (!this.serpientes[i].isViva()) {
                quitarSerpiente(i);
            }
        }
    }

    /**
     * Quitar serpiente.
     *
     * @param pos the pos
     */
    public void quitarSerpiente(int pos) {
        for (int i = pos; i < numSerpientes - 1; i++) {
            this.serpientes[i] = this.serpientes[i + 1];
        }
        this.serpientes[numSerpientes - 1] = null;
        numSerpientes--;
    }

    /**
     * Gets num serpientes.
     *
     * @return the num serpientes
     */
    public int getNumSerpientes() {
        return numSerpientes;
    }

    /**
     * Sets num serpientes.
     *
     * @param numSerpientes the num serpientes
     */
    public void setNumSerpientes(int numSerpientes) {
        this.numSerpientes = numSerpientes;
    }

    /**
     * Gets nombre.
     *
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Sets nombre.
     *
     * @param nombre the nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Get serpientes snake [ ].
     *
     * @return the snake [ ]
     */
    public Snake[] getSerpientes() {
        return serpientes;
    }

    /**
     * Sets serpientes.
     *
     * @param serpientes the serpientes
     */
    public void setSerpientes(Snake[] serpientes) {
        this.serpientes = serpientes;
    }

    /**
     * Obtener num serpientes.
     */
    public void obtenerNumSerpientes() {
        for (int i = 0; i < numSerpientes; i++) {
            if (serpientes[i].isViva()) {
                numSerpientes++;
            }
        }
    }

    @Override
    public String toString() {
        String resultado = new String();
        for (int i = 0; i < numSerpientes; i++) {
            resultado += serpientes[i].toString() + " ";
            resultado += "\n";
        }
        return resultado;
    }
}
