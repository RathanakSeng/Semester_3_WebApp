import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MySessionListener implements HttpSessionListener {
    static Integer num = 0;
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        // Create whenever the new user logIn
        System.out.println("\n\n\n***************************************************\n");
        System.out.println("A session is created: " + httpSessionEvent.getSession().getId());
        num++;
        System.out.println("Active user: " + num);
        System.out.println("\n***************************************************\n\n\n");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("\n\n\n***************************************************\n");
        System.out.println("A session is destroyed: " + httpSessionEvent.getSession().getId());
        num--;
        System.out.println("Active user: " + num);
        System.out.println("\n***************************************************\n\n\n");
    }
}
