package network.urls;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author zhangyong created on 2020/5/12
 **/
public class ParseURL {

    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://example.com:80/docs/books/tutorial/index.html?name=networking#DOWNLOADING");

        System.out.println("protocol = " + url.getProtocol());
        System.out.println("authority = " + url.getAuthority());
        System.out.println("host = " + url.getHost());
        System.out.println("port = " + url.getPort());
        System.out.println("file = " + url.getFile());
        System.out.println("path = " + url.getPath());
        System.out.println("query = " + url.getQuery());
        System.out.println("ref = " + url.getRef());
    }
}
