package pattern.jikeshijian.auth;

/**
 * @author zhangyong created on 2020/12/13
 **/
public interface ApiAuthenticator {
    void auth(String url);
    void auth(ApiRequest apiRequest);
}
