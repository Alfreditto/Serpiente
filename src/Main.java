public class Main {
    public static void main(String[] args) throws InterruptedException {
        Nido n1 = new Nido("Nidito");
        Snake prueba = new Snake("Prueba");
        System.out.println(prueba);
        int seg = 0, atq, numcom, posicioncom;
        while (seg < 300) {
            System.out.println(n1);
            if (seg % 5 == 0) {
                n1.nacimiento();
            }
            for (int i = 0; i < n1.getNumSerpientes(); i++) {
                n1.getSerpientes()[i].pasarTiempo();
            }
            if (seg % 10 == 0) {
                atq = (int) (Math.random() * 10);
                if (atq < 2) {
                    numcom = (int) (Math.random() * 5);
                    for (int i = 0; i < numcom; i++) {
                        posicioncom = (int) (Math.random()* n1.getNumSerpientes());
                        n1.getSerpientes()[posicioncom].setViva(false);
                        System.out.println("Una mangosta se ha comido a la serpiente");
                    }
                }
            }
            n1.limpiarNido();
            Thread.sleep(1000);
            seg++;
        }
    }
}