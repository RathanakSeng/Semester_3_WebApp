package adapter;

public class AllChargerAdapter implements Charger {

    public static final int CREATE_SAMSUNG_CHARGER = 1;
    public static final int CREATE_MICROSOFT_CHARGER = 2;

    SamsungCharger sch = null;
    MicrosoftCharger mch = null;

    public AllChargerAdapter (Integer type) {

        switch (type) {
            case CREATE_MICROSOFT_CHARGER : {
                mch = new MicrosoftCharger();
                break;
            }
            case CREATE_SAMSUNG_CHARGER : {
                sch = new SamsungCharger();
                break;
            }
        }

    }

    @Override
    public String putCharge() {

        if (sch != null) {
            return sch.putSamsungCharger();
        }
        return mch.putMicrosoftCharger();
    }
}
