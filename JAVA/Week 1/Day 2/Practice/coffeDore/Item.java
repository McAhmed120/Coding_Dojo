public class Item{
  // MEMBER VARIABLES
    private String name;
    private double price;
    private int index;

    public Item(String name, double price){
    this.name = name;
    this.price = price;
    this.index= 0;
    }
  // GETTERS & SETTERS
    public String getName(){
        return this.name;
    }

    public void setName(String newValue){
        this.name = newValue;
    }
    public int getIndex(){
        return this.index;
    }

    public void setIndex(int newValue){
        this.index = newValue;
    }

    public double getPrice(){
        return this.price;
    }

    public void setPrice(double newValue){
        this.price = newValue;
    }

}