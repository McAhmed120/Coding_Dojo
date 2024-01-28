public class Mammal {
    private int energy=100 ;

    public  Mammal(){}
    public  Mammal(int energy){
        this.energy=energy;
    }

    public void displayEnergy(){
        System.out.println("the Energy of this mammal is : "+this.energy);
    }
    public int getEnergy(){
        return this.energy ;

    }
    public void setEnergy(int energy){
        this.energy=energy;
    }

}