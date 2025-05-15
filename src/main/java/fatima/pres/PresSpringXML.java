package fatima.pres;

import fatima.metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PresSpringXML {
    public static void main(String[] args) {
        ApplicationContext sprigContext = new ClassPathXmlApplicationContext("config.xml");

        IMetier metier = (IMetier) sprigContext.getBean("metier");
        System.out.println("RES="+metier.calcul());
    }
}
