package pattern.jikeshijian.auth;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author zhangyong created on 2020/12/13
 **/
public class AuthToken {
    private static MessageDigest messageDigest; // 定义消息摘要对象
    static {
        try {
            // 初始化消息摘要对象和加密算法
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            messageDigest = null;
        }
    }
    private static final long DEFAULT_EXPIRED_TIME_INTERVAL = 60 * 1000;
    private final String token;
    private final long createTime;
    private long expiredTimeInterval = DEFAULT_EXPIRED_TIME_INTERVAL;

    public AuthToken(String token, long createTime) {
        this.token = token;
        this.createTime = createTime;
    }

    public AuthToken(String token, long createTime, long expiredTimeInterval) {
        this.token = token;
        this.createTime = createTime;
        this.expiredTimeInterval = expiredTimeInterval;
    }

    public static AuthToken create(String baseUrl, String appId, String appSecret, long createTime) {
        String strToDigest = concat(baseUrl, appId, appSecret, "" + createTime);
        byte[] digest = messageDigest.digest(strToDigest.getBytes());
        String token = new String(digest);
        return new AuthToken(token, createTime);
    }

    private static String concat(String... strings) {
        StringBuilder sb = new StringBuilder();
        for (String s : strings) {
            if (sb.length() > 0) sb.append("&");
            sb.append(s);
        }
        return sb.toString();
    }

    public String getToken() {
        return token;
    }

    public boolean isExpired() {
        return createTime + expiredTimeInterval > System.currentTimeMillis();
    }

    public boolean match(AuthToken authToken) {
        return token.equals(authToken.getToken());
    }

}
