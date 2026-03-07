import java.util.ArrayList;
import java.util.List;

public class Category extends CatalogComponent{
    private List<CatalogComponent> list = new ArrayList<>();

    public Category(String name) {
        super(name);
    }

    public void add(CatalogComponent component){
        list.add(component);
    }

    public void remove(CatalogComponent component){
        list.remove(component);
    }
    @Override
    public void print() {
        System.out.println("Category: " + name);
        for(CatalogComponent component : list){
            component.print();
        }
    }
}
