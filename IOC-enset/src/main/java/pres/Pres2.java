package pres;

import dao.IDao;
import ext.DaoImpl2;
import metier.IMetier;
import metier.MetierImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Pres2 {

    public static void main(String[] args) throws Exception {

        //DaoImpl2 dao = new DaoImpl2();
        Scanner scanner;
        try {
            scanner = new Scanner(new File("config.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        String daoClassName = scanner.nextLine();

        //instentistion dynamique
        Class cDao = Class.forName(daoClassName);
        IDao dao =(IDao) cDao.getConstructor().newInstance(); // => new DaoImpl() methode dynamique


        //MetierImpl metier = new MetierImpl();

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
