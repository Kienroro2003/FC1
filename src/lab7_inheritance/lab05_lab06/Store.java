package lab7_inheritance.lab05_lab06;

public class Store {
    public final double SALESJAXJATE = 0.06;
    protected String name;

    public Store(){}
    public Store( String newName )
    {
        setName( newName );
    }
    public String getName( )
    {
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Store{" +
                "name='" + name + '\'' +
                '}';
    }
}

