
class Gorilla extends Mammal {

    

    public void ThrowSomething() {
        System.out.println("The Gorilla has thrown something.");
        this.setEnergyLevel(this.getEnergyLevel() - 5);
        DisplayEnergy(this.getEnergyLevel());
    
    }
    
    public void EatBananas() {
        System.out.println("The Gorilla is now satisfied from eating bananas!");
        this.setEnergyLevel(this.getEnergyLevel() + 10);
        DisplayEnergy(this.getEnergyLevel());
    }


    public void climb() {
        System.out.println("The Gorilla is climbing a tree!");
        this.setEnergyLevel(this.getEnergyLevel() - 10);
        DisplayEnergy(this.getEnergyLevel());
    }


}
