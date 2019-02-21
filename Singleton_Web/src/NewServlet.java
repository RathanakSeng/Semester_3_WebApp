import adapter.AllChargerAdapter;
import adapter.ConnectCharger;
import adapter.IphoneCharger;
import com.IceCream;
import com.IceCreamProvider;

import javax.servlet.http.HttpSession;
import java.io.IOException;

public class NewServlet extends javax.servlet.http.HttpServlet {

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        /* Adapter */
        ConnectCharger cc = new ConnectCharger();

        cc.setCharger(new AllChargerAdapter(AllChargerAdapter.CREATE_MICROSOFT_CHARGER));

        response.getWriter().println(cc.connectCharger());

    }
}
