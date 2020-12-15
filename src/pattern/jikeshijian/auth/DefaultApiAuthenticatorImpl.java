package pattern.jikeshijian.auth;

/**
 * @author zhangyong created on 2020/12/13
 **/
public class DefaultApiAuthenticatorImpl implements ApiAuthenticator {

    private final CredentialStorage credentialStorage;

    public DefaultApiAuthenticatorImpl() {
        this.credentialStorage = new MysqlCredentialStorage();
    }

    public DefaultApiAuthenticatorImpl(CredentialStorage credentialStorage) {
        this.credentialStorage = credentialStorage;
    }

    @Override
    public void auth(String url) {
        ApiRequest apiRequest = ApiRequest.buildFromUrl(url);
        auth(apiRequest);
    }

    @Override
    public void auth(ApiRequest apiRequest) {
        String appId = apiRequest.getAppId();
        String token = apiRequest.getToken();
        long timestamp = apiRequest.getTimestamp();
        AuthToken clientAuthToken = new AuthToken(token, timestamp);
        if (clientAuthToken.isExpired()) {
            throw new RuntimeException("Token is expired");
        }
        String appSecret = credentialStorage.getAppSecretByAppId(appId);
        AuthToken serverAuthToken = AuthToken.create(apiRequest.getBaseUrl(), appId, appSecret, timestamp);
        if (!serverAuthToken.match(clientAuthToken)) {
            throw new RuntimeException("Token verification failed.");
        }
    }
}
