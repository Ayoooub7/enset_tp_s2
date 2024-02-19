package dao;

public class DaoImpl implements IDao{
    @Override
    public double getData() {
        System.out.println("version base de donnes");
        double data = 34;
        return data;
    }
}
