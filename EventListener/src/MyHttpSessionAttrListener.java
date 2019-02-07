import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class MyHttpSessionAttrListener implements HttpSessionAttributeListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("New attribute is added: \n" +
                httpSessionBindingEvent.getName() + " : " + httpSessionBindingEvent.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("An attribute is removed: \n" +
                httpSessionBindingEvent.getName() + " : " + httpSessionBindingEvent.getValue());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("An attribute is replaced: \n" +
                httpSessionBindingEvent.getName() + " : " + httpSessionBindingEvent.getValue());
    }
}
