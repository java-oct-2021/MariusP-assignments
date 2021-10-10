
public abstract class Phone {
    private String versionNumber;
    private int batteryPercentage;
    private String carrier;
    private String ringTone;
    public Phone(String versionNumber, int batteryPercentage, String carrier, String ringTone){
        this.versionNumber = versionNumber;
        this.batteryPercentage = batteryPercentage;
        this.carrier = carrier;
        this.ringTone = ringTone;
    }
    
    public String getversionNumber () {
        return this.versionNumber;
    }
       
    public void setversionNumber(String versionNumber) {
        this.versionNumber = versionNumber;
    }

    public int getbatteryPercentage () {
        return this.batteryPercentage;
    }

    public void setbatteryPercentage (int batteryPercentage) {
        this.batteryPercentage = batteryPercentage;
    }


    public String getcarrier () {
        return this.carrier;
    }

    public void setcarrier (String carrier) {
        this.carrier = carrier;
    }


    public String getringTone () {
        return this.ringTone;
    }


    public void setringTone (String ringTone) {
        this.ringTone = ringTone;
    }
    

    public abstract void displayInfo() ;
        
}

