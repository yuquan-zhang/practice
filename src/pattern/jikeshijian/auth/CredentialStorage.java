package pattern.jikeshijian.auth;

/**
 * @author zhangyong created on 2020/12/13
 **/
public interface CredentialStorage {

    String getAppSecretByAppId(String appId);
}
