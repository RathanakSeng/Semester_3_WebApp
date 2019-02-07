import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

public class MyServletRequestAttributeChangeListener implements ServletRequestAttributeListener {
    @Override
    public void attributeAdded(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        System.out.println("New attribute is added: \n" +
                servletRequestAttributeEvent.getName() + " : " + servletRequestAttributeEvent.getValue());
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        System.out.println("An attribute is removed: \n" +
                servletRequestAttributeEvent.getName() + " : " + servletRequestAttributeEvent.getValue());
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        System.out.println("An attribute is replaced: \n" +
                servletRequestAttributeEvent.getName() + " : " + servletRequestAttributeEvent.getValue());
    }
}
