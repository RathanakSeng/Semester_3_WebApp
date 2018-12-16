import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.sql.rowset.WebRowSet;

import com.sun.rowset.WebRowSetImpl;

public class WebRowSetExample {
    public static void main(String[] args) throws Exception {
        Connection conn = getMySqlConnection();
        System.out.println("Got Connection.");
        Statement st = conn.createStatement();

        String query = "select * from student";

        WebRowSet webRS = new WebRowSetImpl();
        webRS.setCommand(query);
        webRS.execute(conn);

        // convert xml to a String object
        StringWriter sw = new StringWriter();
        webRS.writeXml(sw);
        System.out.println(sw.toString());

        st.close();
        conn.close();
    }

    public static Connection getMySqlConnection() throws Exception {
        String url = "jdbc:mysql://localhost/java_database";
        String username = "root";
        String password = "n@k123seng";

        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }
}

/** Link to download '''* com.sun.rowset.WebRowSetImpl *'''
 * http://www.java2s.com/Code/Jar/c/Downloadcomsunrowsetjar.htm
 * */

/**
 * A WebRowSet (javax.sql.WebRowSet) object is a disconnected rowset that caches its data in memory in the same manner as a CachedRowSet object.
 * It Support XML file which mean it can write itself as an XML document and can also read that XML document to convert itself back to a WebRowSet object.
 * Due to its XML support, WebRowSet is an ideal object format for web services.
 *
 * The Data that return in form of XML file are : Properties, Metadata, and Data
 * */