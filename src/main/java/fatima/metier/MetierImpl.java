package fatima.metier;
import fatima.dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("metier")
public class MetierImpl implements IMetier {
    //@Autowired //injection automatique
    @Qualifier("d")
    private IDao dao; //c'est le couplage faible

    //Constrecteur (injection au moment de de l'instantiation(création de l'objet)+ recommander car il est rapide et optemise
    public MetierImpl(@Qualifier("d") IDao dao) {
        this.dao=dao;
    }


    @Override
    public double calcul() {
        double t=dao.getData();
        double res=t*12*Math.PI/2*Math.cos(t);
        return res;
    }


    //Le role de setter: pour injecter dans L'attribut dao
    // un objet d'une classe qui implémente l'interface IDao
    public void setDao(IDao dao){
        this.dao=dao;
    }


}
