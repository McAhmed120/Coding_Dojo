import java.util.ArrayList;
public class Order{
    private String name;
    private boolean ready;
    private ArrayList<Item> items;
    public Order(){
    this.name = "Guest";
    this.ready = ready;
    this.items=new ArrayList<Item>();
    }
    public Order(String name){
    this.name = name;
    this.ready = ready;
    this.items=new ArrayList<Item>();
    }
    // --------------------------
    public void addItem (Item newItem){
        this.items.add(newItem);
    }
    public String getStatusMessage (){
        if(this.ready==true){
            return "Your order is ready.";
        }else{
            return "Thank you for waiting. Your order will be ready soon.";
        }
    }
    public double getOrderTotal() {
        // You do not need to code here, this is an example method
        double total = 0;
        for (int i = 0; i < this.items.size(); i++){
            total+=this.items.get(i).getPrice();
        }
        return total;
    }
    public void display() {
        // You do not need to code here, this is an example method
        System.out.printf("\n Thank You: "+this.name+" \nHere are  your Order Details: \n");
        for (int i = 0; i < this.items.size(); i++){
            System.out.printf(this.items.get(i).getName()+" - $"+this.items.get(i).getPrice()+"\n\n");
        }
        System.out.printf("Total: $"+getOrderTotal()+" \n");
    }

    // -----------------------------
    public String getName(){
        return this.name;
    }

    public void setName(String newValue){
        this.name = newValue;
    }

    public boolean getReady(){
        return this.ready;
    }

    public void setReady(boolean newValue){
        this.ready = newValue;
    }
}