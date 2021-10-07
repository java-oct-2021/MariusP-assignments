
class Bat extends Mammal {

    
    public int Energy;
    
    public Bat() {
        this.Energy = 300;
    }
    
    public void Fly () {
        
        System.out.println("Cheep! Cheep!");
        this.setEnergyLevel(this.getEnergyLevel() - 50);
        DisplayEnergy(this.getEnergyLevel());

    }


    public void EatHumans() {

        System.out.println("Yum! Yum!");
        this.setEnergyLevel(this.getEnergyLevel() + 25);
        DisplayEnergy(this.getEnergyLevel());

    }


    public void AttackTown() {

        System.out.println("Argh!  Run for it!");
        this.setEnergyLevel(this.getEnergyLevel() - 100);
        DisplayEnergy(this.getEnergyLevel());
    }

}