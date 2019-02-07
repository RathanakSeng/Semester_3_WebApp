import java.util.ArrayList;
import java.util.Optional;

public interface DAO<T> {

    Optional<T> findByName (String param);

    ArrayList<T> findAll ();

    Boolean save (T t);

    Integer update (T t, String[] params);

    Integer delete (T t);
}
