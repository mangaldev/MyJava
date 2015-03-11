import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.codec.binary.Base64;




public class HttpBasicAuth {
  public static void main(String[] args) throws Exception {
    /*
     *  fix for
     *    Exception in thread "main" javax.net.ssl.SSLHandshakeException:
     *       sun.security.validator.ValidatorException:
     *           PKIX path building failed: sun.security.provider.certpath.SunCertPathBuilderException:
     *               unable to find valid certification path to requested target
     */
    TrustManager[] trustAllCerts = new TrustManager[] {
       new X509TrustManager() {
          public java.security.cert.X509Certificate[] getAcceptedIssuers() {
            return null;
          }

          public void checkClientTrusted(X509Certificate[] certs, String authType) {  }

          public void checkServerTrusted(X509Certificate[] certs, String authType) {  }

       }
    };

    SSLContext sc = SSLContext.getInstance("SSL");
    sc.init(null, trustAllCerts, new java.security.SecureRandom());
    HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

    // Create all-trusting host name verifier
    HostnameVerifier allHostsValid = new HostnameVerifier() {
        public boolean verify(String hostname, SSLSession session) {
          return true;
        }
    };
    // Install the all-trusting host verifier
    HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
    /*
     * end of the fix
     */

    URL url = new URL("https://cmls-sl0.ver.sda.t-online.de/vod/dtag_programs_delivery.xml.gz");
    String credentials = "gracenote:cnsK9El3L8rk";
    Base64 base = new Base64();
    String encoding = base.encodeAsString(credentials.getBytes());
    byte[] encodedBytes = Base64.encodeBase64(credentials.getBytes());
    URLConnection connection = url.openConnection();
    connection.setRequestProperty("Authorization", String.format("Basic %s", new String(encodedBytes)));
    
        
    File file = new File("/relay/abc.zip");
    InputStream in = (InputStream) connection.getInputStream();
    OutputStream out = new BufferedOutputStream(new FileOutputStream(file));
    for (int b; (b = in.read()) != -1;) {
        out.write(b);
    }
    out.close();
    in.close();
  }
}