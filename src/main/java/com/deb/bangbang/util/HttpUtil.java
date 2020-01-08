package com.deb.bangbang.util;

import com.deb.bangbang.constant.Constant;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class HttpUtil {
    private static OkHttpClient client = new OkHttpClient();

    /**
     * 获取交换的access code
     * @param code
     * @param state
     * @return
     * @throws IOException
     */
    public static String getWeChatCode(String code, String state) throws IOException {
        final String authorize_url = "https://api.weixin.qq.com/sns/oauth2/access_token?" +
                "&appid=" + Constant.APP_ID +
                "&secret=" + Constant.APP_SECRET +
                "&code="+ code +
                "&grant_type=authorization_code";
        Request request = new Request.Builder()
                .url(authorize_url)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    /**
     * 获取微信个人信息
     * @param openId
     * @param accessToken
     * @return
     * @throws IOException
     */
    public static String getWeChatOpenId(String openId, String accessToken) throws IOException {
        final String url =  "https://api.weixin.qq.com/sns/userinfo" +
                "?access_token="+ accessToken +
                "&openid=" + openId +
                "&lang=zh_CN";
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }
}
