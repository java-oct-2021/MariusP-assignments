
public class Galaxy extends Phone implements Ringable {

    public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }


    @Override
    public String ring() {
        String statement = "Galaxy " + this.getversionNumber() + " says " + this.getringTone();
        return statement;
        
    }

    @Override
    public String unlock() {
        String statement = "Unlocking via finger print.";
        return statement;
    }


    @Override
    public void displayInfo() {
        System.out.println("Galaxy " + this.getversionNumber() + " from " + this.getcarrier());
    }


}

