public class Bat extends Mammal{
    public Bat(int energy){
        super(energy);
    }
    public Bat(){
        super(300);
    }
    public void fly(){
        setEnergy(getEnergy()-50) ;
        System.out.println("the bat is airbone");
    }
    public void eatHumans(){
        setEnergy(getEnergy()+25);
        System.out.println("the bat's statisfaction");
    }
    public void attackTown(){
        setEnergy(getEnergy()-100);
         System.out.println("the bat's attack");
    } 
}