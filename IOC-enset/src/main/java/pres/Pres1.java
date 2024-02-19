package pres;

import dao.DaoImpl;
import ext.DaoImpl2;
import metier.MetierImpl;



public class Pres1 {
    public static void main(String[] args) {
        MetierImpl metier = new MetierImpl();
        //je modifie ici pour changer la version
        DaoImpl2 dao = new DaoImpl2();
        //utilisation du new = instanciation statique(ca suppose que vous connaisew la class)
        //si vous fait new vous appellez une class

        metier.setDao(dao);
        System.out.println("RES="+metier.calcule());
    }
}
