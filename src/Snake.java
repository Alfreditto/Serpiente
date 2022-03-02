public class Snake {
    private String nombre;
    private int edad;
    private char[] anillas = new char[30];
    private int numAnillas;
    private boolean viva;

    public Snake() {
    }

    public Snake(String nombre) {
        this.nombre = nombre;
        this.edad = 0;
        this.numAnillas = 1;
        anillas[0] = obtenerColor();
        this.viva = true;
    }

    public int getNumAnillas() {
        return numAnillas;
    }

    public void setNumAnillas(int numAnillas) {
        this.numAnillas = numAnillas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char[] getAnillas() {
        return anillas;
    }

    public void setAnillas(char[] anillas) {
        this.anillas = anillas;
    }

    public boolean isViva() {
        return viva;
    }

    public void setViva(boolean viva) {
        this.viva = viva;
    }

    public void contadorAnillas() {
        int j = 0;
        for (char anilla : this.anillas) {
            if (anilla == 'r' || anilla == 'v' || anilla == 'a') {
                setNumAnillas(getNumAnillas() + 1);
            }
        }
    }

    public void sumarAnillas() {
        this.anillas[this.numAnillas] = obtenerColor();
        numAnillas++;
        System.out.println(nombre + " ha crecido!");
    }

    public void quitarAnillas() {
        this.anillas[this.numAnillas - 1] = '\u0000';
        numAnillas--;
        System.out.println(nombre + " ha perdido una anilla!");
        if (numAnillas <= 0) {
            setViva(false);
            System.out.println(nombre + " ha muerto! :c");
        }
    }

    public void mudarPiel() {
        for (int i = 0; i < numAnillas; i++) {
            anillas[i] = obtenerColor();
        }
        System.out.println(nombre + " ha mudado la piel!");
    }

    public void envejecer() {
        edad++;
    }

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

    public void ataque() {
        setViva(false);
        System.out.println("Una malvada mangosta a matado a " + nombre);
    }
    public void pasarTiempo(){
        int randm;
        while (this.viva) {
            System.out.println(toString());
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
    }
    @Override
    public String toString() {
        String resultado = new String();
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
