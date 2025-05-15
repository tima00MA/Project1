package fatima.pres;

import fatima.dao.DaoImpl;
import fatima.dao.IDao;
import fatima.ext.DaoImplV2;
import fatima.metier.MetierImpl;

public class Pres1 {
    public static void main(String[] args){
        DaoImplV2 d=new DaoImplV2();
        MetierImpl metier=new MetierImpl(d); // l'injection via le constrecteur
        // metier.setDao(d);// Injection des dépendances via le setter
        System.out.println("Result: "+metier.calcul());
    }
}
