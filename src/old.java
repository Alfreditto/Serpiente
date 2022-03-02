public class old {

    public static void main(String[] args) throws InterruptedException {
        int randm, ataque;
        System.out.println("Una nueva vida para Sneaky");
        Snake s1 = new Snake("Sneaky");
        while (s1.isViva()){
            System.out.println(s1);
            randm = (int) (Math.random()*10);
            ataque = (int) (Math.random()*10);
            if (ataque == 0){
                s1.ataque();
            } else {
                if (s1.getEdad() < 10) {
                    if (randm < 8) {
                        s1.sumarAnillas();
                    } else {
                        s1.mudarPiel();
                    }
                } else {
                    if (randm < 9) {
                        s1.quitarAnillas();
                    } else {
                        s1.mudarPiel();
                    }
                }
                s1.envejecer();
            }

        Thread.sleep(1000);
    }
}
}
