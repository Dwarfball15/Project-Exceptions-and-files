public class Pay extends Person {
    private double hourlyPay;
    private String instrument;

    /*
    subclass of Person (pay record)

    adds hourly pay and instrument attributes

     */
    public Pay() {
        super();
        this.hourlyPay = 0.0;
        this.instrument = "";
    }

    //default constructor
    public Pay(String name, double hourlyPay, String instrument) {
        super(name);
        this.hourlyPay = hourlyPay;
        this.instrument = instrument;
    }

    //Overloaded constructor
    public double getHourlyPay() {
        return hourlyPay;
    }

    //return instrument as a String
    public String getInstrument() {
        return instrument;
    }

    //setter for hourly pay
    public void setHourlyPay(double hourlyPay) {
        this.hourlyPay = hourlyPay;
    }

    //setter for instrument
    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }


    @Override
    public String toString() {
        return "Name: " + getName() + " | Hourly Pay: $" +
                String.format("%.2f", hourlyPay) + " | Instrument: " + instrument;
    }
}