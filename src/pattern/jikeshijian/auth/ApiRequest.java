package pattern.jikeshijian.auth;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangyong created on 2020/12/13
 **/
public class ApiRequest {

    private final String baseUrl;
    private final String appId;
    private final long timestamp;
    private final String token;

    public ApiRequest(String baseUrl, String appId, long timestamp, String token) {
        this.baseUrl = baseUrl;
        this.appId = appId;
        this.timestamp = timestamp;
        this.token = token;
    }

    public static ApiRequest buildFromUrl(String url) {
        String[] us = url.split("\\?");
        String baseUrl = us[0];
        Map<String, String> params = new HashMap<>();
        for (String s : us[1].split("&")) {
            String[] kv = s.split("=");
            params.put(kv[0],kv[1]);
        }
        String appId = params.get("appId");
        long timestamp = Long.parseLong(params.get("timestamp"));
        String token = params.get("token");
        return new ApiRequest(baseUrl, appId, timestamp, token);
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getAppId() {
        return appId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getToken() {
        return token;
    }
}
