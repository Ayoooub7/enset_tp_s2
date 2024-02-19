package pres;

import dao.IDao;
import metier.IMetier;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Pres22 {

    public static void main(String[] args) throws Exception {

        //DaoImpl2 dao = new DaoImpl2();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Donner la class de la couche DAO:");

        String daoClassName = scanner.nextLine();

         //instentistion dynamique
        Class cDao = Class.forName(daoClassName);
        IDao dao =(IDao) cDao.getConstructor().newInstance(); // => new DaoImpl() methode dynamique


        //MetierImpl metier = new MetierImpl();
        System.out.println("Donner la class de la couche Metier:");
        String metierClassname=scanner.nextLine();
        Class cMetier=Class.forName(metierClassname);
        IMetier metier = (IMetier) cMetier.getConstructor().newInstance();

        //metier.setDao(dao); //statiques
        /* injection des dependences  */

        Method setDao=cMetier.getDeclaredMethod("setDao",IDao.class);
        //invoke = execute moi cette methode
        setDao.invoke(metier,dao); //injection des dependances dynamique


        System.out.println("RES"+metier.calcule());

    }
}
