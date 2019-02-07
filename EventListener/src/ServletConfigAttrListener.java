import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class ServletConfigAttrListener implements ServletContextAttributeListener {
    @Override
    public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("New attribute is added: \n" +
                servletContextAttributeEvent.getName() + " : " + servletContextAttributeEvent.getValue());
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("An attribute is removed: \n" +
                servletContextAttributeEvent.getName() + " : " + servletContextAttributeEvent.getValue());
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("An attribute is replaced: \n" +
                servletContextAttributeEvent.getName() + " : " + servletContextAttributeEvent.getValue());
    }
}
