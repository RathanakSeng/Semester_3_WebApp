package adapter;

public class IphoneCharger implements Charger {
    @Override
    public String putCharge() {
        return "Iphone charger connected...";
    }
}
