package fatima.pres;

import fatima.metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PresSpringAnnotation {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("fatima");
        IMetier metier = applicationContext.getBean(IMetier.class);
        System.out.println("Res="+metier.calcul());


    }
}
