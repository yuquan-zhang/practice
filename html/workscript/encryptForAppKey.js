function genAppKey(appId, appSecret) {
    let s = "";
    let len1 = appId.length, len2 = appSecret.length;
    let len = Math.max(len1, len2);
    for (let i = 0; i < len; i++) {
        if (len2 !== 0) s += appSecret[i % len2];
        if (len1 !== 0) s += appId[i % len1];
    }
    return s.toUpperCase();
}