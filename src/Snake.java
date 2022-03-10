/**
 * The type Snake.
 */
public class Snake {
    private String nombre;
    private int edad;
    private char[] anillas = new char[30];
    private int numAnillas;
    private boolean viva;

    /**
     * Instantiates a new Snake.
     */
    public Snake() {
    }

    /**
     * Instantiates a new Snake.
     *
     * @param nombre the nombre
     */
    public Snake(String nombre) {
        this.nombre = nombre;
        this.edad = 0;
        this.numAnillas = 1;
        anillas[0] = obtenerColor();
        this.viva = true;
    }

    /**
     * Gets num anillas.
     *
     * @return the num anillas
     */
    public int getNumAnillas() {
        return numAnillas;
    }

    /**
     * Sets num anillas.
     *
     * @param numAnillas the num anillas
     */
    public void setNumAnillas(int numAnillas) {
        this.numAnillas = numAnillas;
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
     * Gets edad.
     *
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Sets edad.
     *
     * @param edad the edad
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Get anillas char [ ].
     *
     * @return the char [ ]
     */
    public char[] getAnillas() {
        return anillas;
    }

    /**
     * Sets anillas.
     *
     * @param anillas the anillas
     */
    public void setAnillas(char[] anillas) {
        this.anillas = anillas;
    }

    /**
     * Is viva boolean.
     *
     * @return the boolean
     */
    public boolean isViva() {
        return viva;
    }

    /**
     * Sets viva.
     *
     * @param viva the viva
     */
    public void setViva(boolean viva) {
        this.viva = viva;
    }

    /**
     * Contador anillas.
     */
    public void contadorAnillas() {
        int j = 0;
        for (char anilla : this.anillas) {
            if (anilla == 'r' || anilla == 'v' || anilla == 'a') {
                setNumAnillas(getNumAnillas() + 1);
            }
        }
    }

    /**
     * Sumar anillas.
     */
    public void sumarAnillas() {
        this.anillas[this.numAnillas] = obtenerColor();
        numAnillas++;
        System.out.println(nombre + " ha crecido!");
    }

    /**
     * Quitar anillas.
     */
    public void quitarAnillas() {
        if (numAnillas > 0) { //Faltaba este if.
            this.anillas[this.numAnillas - 1] = '\u0000';
            numAnillas--;
        }
        System.out.println(nombre + " ha perdido una anilla!");
        if (numAnillas == 0) {
            setViva(false);
            System.out.println(nombre + " ha muerto! :c");
        }
    }

    /**
     * Mudar piel.
     */
    public void mudarPiel() {
        for (int i = 0; i < numAnillas; i++) {
            anillas[i] = obtenerColor();
        }
        System.out.println(nombre + " ha mudado la piel!");
    }

    /**
     * Envejecer.
     */
    public void envejecer() {
        edad++;
    }

    /**
     * Obtener color char.
     *
     * @return the char
     */
    public char obtenerColor() {
        int aux = (int) (Math.random() * 3) + 1;
        char aux2 = 0;
        switch (aux) {
            case 1:
                aux2 = 'r';
                break;
            case 2:
                aux2 = 'v';
                break;
            case 3:
                aux2 = 'a';
                break;
        }
        return aux2;
    }

    /**
     * Ataque.
     */
    public void ataque() {
        setViva(false);
        System.out.println("Una malvada mangosta a matado a " + nombre);
    }

    /**
     * Pasar tiempo.
     */
    public void pasarTiempo() {
        //En el método pasarTiempo el while no hay que ponerlo, era lo que fallaba.
        int randm;
        randm = (int) (Math.random() * 10);
        if (this.getEdad() < 10) {
            if (randm < 8) {
                this.sumarAnillas();
            } else {
                this.mudarPiel();
            }
        } else {
            if (randm < 9) {
                this.quitarAnillas();
            } else {
                this.mudarPiel();
            }
        }
        this.envejecer();
    }

    @Override
    public String toString() {
        String resultado = "";
        resultado += nombre;
        resultado += " " + edad + " ";
        for (int i = 0; i < numAnillas; i++) {
            if (anillas[i] != '\u0000') {
                resultado += anillas[i];
            }
        }
        return resultado;
    }
}
