package com.jingzhun.utils.https;

import java.security.cert.X509Certificate;
import java.security.cert.CertificateException;
import javax.net.ssl.X509TrustManager;


/**
 * Created by Administrator on 2019/3/11 0011.
 */
public class MyX509TrustManager implements X509TrustManager {
    public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
    }

    public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
    }

    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }

}
