package adapter;

public class ConnectCharger {

    private Charger charger;

    public Charger getCharger() {
        return charger;
    }

    public void setCharger(Charger charger) {
        this.charger = charger;
    }

    public String connectCharger () {
        return charger.putCharge();
    }
}
