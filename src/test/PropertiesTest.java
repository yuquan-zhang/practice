/*
package test;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class PropertiesTest {
    private final Logger log = LoggerFactory.logger(getClass());
    public static void main(String[] args) throws Exception {
        FileReader reader=new FileReader("info.properties");

        Properties p=new Properties();
        p.load(reader);

        System.out.println(p.getProperty("user"));
        System.out.println(p.getProperty("password"));
        p = System.getProperties();
        Set set = p.entrySet();

        Iterator itr = set.iterator();
        while (itr.hasNext()) {
            Map.Entry entry = (Map.Entry) itr.next();
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
        p=new Properties();
        p.setProperty("name","Sonoo Jaiswal");
        p.setProperty("email","sonoojaiswal@javatpoint.com");

        p.store(new FileWriter("info.properties"),"Javatpoint Properties Example");
    }
}
*/
