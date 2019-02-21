public class KIT {

    private static KIT instance = null;

    private String name = "KIT";;
    private String fullName = "Kirirom Institute of  Technology";;

    private KIT () {}

    public static KIT getInstance() {
        if (instance == null) instance = new KIT();
        return instance;
    }

    public String getName() {
        return name;
    }

    public String getFullName() {
        return fullName;
    }
}
