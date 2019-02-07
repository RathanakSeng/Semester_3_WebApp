import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextServletListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("\n\n\n***************************************************\n");
        System.out.println("Servlet context is created: " + servletContextEvent);
        System.out.println("\n***************************************************\n\n\n");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("\n\n\n***************************************************\n");
        System.out.println("Servlet context is destroyed: " + servletContextEvent);
        System.out.println("\n***************************************************\n\n\n");
    }
}
