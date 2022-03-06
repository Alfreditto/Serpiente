public class Nido {
    private String nombre;
    private Snake[] serpientes = new Snake[20];
    private int numSerpientes;

    public Nido(String nombre) {
        this.nombre = nombre;
        this.numSerpientes = 1;
        serpientes[0] = new Snake("serpiente " + numSerpientes);
    }

    public void nacimiento() {
        int randm = (int) (Math.random() * 3);
        for (int i = 0; i <= randm && numSerpientes < serpientes.length; i++) {
            this.serpientes[numSerpientes] = new Snake("serpiente " + numSerpientes);
            numSerpientes++;
        }
    }

    public void limpiarNido() {
        for (int i = 0; i < numSerpientes; i++) {
            if (!this.serpientes[i].isViva()) {
                quitarSerpiente(i);
            }
        }
    }

    public void quitarSerpiente(int pos) {
        for (int i = pos; i < numSerpientes - 1; i++) {
            this.serpientes[i] = this.serpientes[i + 1];
        }
        this.serpientes[numSerpientes - 1] = null;
        numSerpientes--;
    }

    public int getNumSerpientes() {
        return numSerpientes;
    }

    public void setNumSerpientes(int numSerpientes) {
        this.numSerpientes = numSerpientes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Snake[] getSerpientes() {
        return serpientes;
    }

    public void setSerpientes(Snake[] serpientes) {
        this.serpientes = serpientes;
    }

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
