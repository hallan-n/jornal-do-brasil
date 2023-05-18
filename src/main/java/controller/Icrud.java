package controller;
import java.util.List;


public interface Icrud {
    public boolean create(Object object);
    public List<Object> read();
    public boolean update(Object object);
    public boolean delete(int id); 
}
    
