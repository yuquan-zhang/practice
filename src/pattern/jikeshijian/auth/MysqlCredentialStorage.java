package pattern.jikeshijian.auth;

/**
 * @author zhangyong created on 2020/12/13
 **/
public class MysqlCredentialStorage implements CredentialStorage {

    @Override
    public String getAppSecretByAppId(String appId) {
        // select app_secret from credential_storage where app_id = appId;
        return null;
    }
}
