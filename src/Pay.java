public class Pay extends Person {
    private double hourlyPay;
    private String instrument;


    public Pay() {
        super();
        this.hourlyPay = 0.0;
        this.instrument = "";
    }


    public Pay(String name, double hourlyPay, String instrument) {
        super(name);
        this.hourlyPay = hourlyPay;
        this.instrument = instrument;
    }


    public double getHourlyPay() {
        return hourlyPay;
    }

    public String getInstrument() {
        return instrument;
    }


    public void setHourlyPay(double hourlyPay) {
        this.hourlyPay = hourlyPay;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }


    @Override
    public String toString() {
        return "Name: " + getName() + " | Hourly Pay: $" +
                String.format("%.2f", hourlyPay) + " | Instrument: " + instrument;
    }
}