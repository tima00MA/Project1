package fatima.pres;

import fatima.dao.IDao;
import fatima.metier.IMetier;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.Scanner;

public class Pres2 {
    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Scanner scanner = new Scanner(new File("config.txt"));;

        // 3 lignes pour creer un object
        String daoClassName = scanner.nextLine(); // lire le nom de la classe
        Class cDao=Class.forName(daoClassName); // charge la classe au memoire
        IDao d = (IDao)cDao.newInstance(); // instancier la classe


        //System.out.println(dao.getData());

        String metierClassName = scanner.nextLine();
        Class cMetier=Class.forName(metierClassName);

        IMetier metier =(IMetier) cMetier.getConstructor(IDao.class).newInstance(d);
        //IMetier metier = (IMetier)cMetier.getConstructor().newInstance();
        //Method setDao = cMetier.getMethod("setDao", IDao.class);
        //setDao.invoke(metier,d);
        System.out.println("Result: "+metier.calcul());
    }
}
