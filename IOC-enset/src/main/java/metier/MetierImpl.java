package metier;
import dao.IDao;
public class MetierImpl implements IMetier {

    private IDao dao; //Couplage faible
    @Override
    public double calcule() {
        double d=dao.getData();
        double  res = d*11.4;
        return res;
    }

    //le setter cest pour permettre  d'injecter dans la variable dao
    //un objet d'une classe qui implemente l'interface IDao

    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
