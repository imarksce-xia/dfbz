package com.xgb.service;

import com.alibaba.fastjson.JSONObject;
import com.xgb.dao.LoginDao;
import com.xgb.entity.User;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @author iMarksce
 * @date 2020/9/27
 * @Description
 */
public class LoginService {
    private LoginDao loginDao = new LoginDao();

    /**
     * 功能描述
     *
     * @param username, password
     * @return com.xgb.entity.User
     * @author iMarksce
     * @date 2020/9/27
     */
    public User checkLogin(String username, String password) {
        return loginDao.checkLogin(username, password);
    }

    /**
     * 功能描述
     *
     * @param user
     * @return void
     * @author iMarksce
     * @date 2020/9/27
     */
    public void updatePassword(User user) {
        loginDao.updatePassword(user);
    }

    /**
     * 功能描述
     *
     * @param url
     * @return com.alibaba.fastjson.JSONObject
     * @author iMarksce
     * @date 2020/9/27
     */
    public JSONObject getJsonObjectForWx(String url) {
        try {
            // 创建一个http Client请求
            CloseableHttpClient client = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(url);
            HttpResponse response = client.execute(httpGet);
            // 获取响应数据(json)
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String result = EntityUtils.toString(entity, Charset.forName("UTF8"));
                return JSONObject.parseObject(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User findByWxOpenid(String wxOpenid) {
        return loginDao.findByWxOpenid(wxOpenid);
    }
}
