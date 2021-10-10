public class IPhone extends Phone implements Ringable {
    
    public IPhone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }

    @Override
    public String ring() {
        String statement = "iPhone " + this.getversionNumber() + " says " + this.getringTone();
        return statement;
    }

    @Override
    public String unlock() {
        String statement = "Unlocking via facial recognition.";
        return statement;
    }


    @Override
    public void displayInfo() {
        System.out.println("iPhone " + this.getversionNumber() + " from " + this.getcarrier());
    }


}

