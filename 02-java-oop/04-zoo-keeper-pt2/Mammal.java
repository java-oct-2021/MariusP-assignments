
class Mammal {

    private int Energy;
    
    public Mammal() {
        this.Energy = 300;
    }

    public int getEnergyLevel() {
        return this.Energy;
    }


    public void setEnergyLevel(int Energy) {
        this.Energy = Energy;
    }

    public void DisplayEnergy(int Energy){
        System.out.println("The energy level is currently at: " + Energy);
       

    }



}