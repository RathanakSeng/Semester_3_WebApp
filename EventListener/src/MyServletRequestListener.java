import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MyServletRequestListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        System.out.println("\n\n\n***************************************************\n");
        System.out.println("A request is created: " + servletRequestEvent.getServletRequest());
        System.out.println("\n***************************************************\n\n\n");
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        // destroy when it create a response obj
        System.out.println("\n\n\n***************************************************\n");
        System.out.println("A response is created: " + servletRequestEvent.getServletRequest());
        System.out.println("\n***************************************************\n\n\n");
    }
}
