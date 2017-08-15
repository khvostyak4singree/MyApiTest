import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.io.IOException;


public class HillelApiTest {
    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpPost httppost = new HttpPost("http://soft.it-hillel.com.ua:3000/api/users");
            String body = "{\"name\": \"Michael\", \"phone\": \"777588551\",\"role\": \"Student\"}";
            HttpEntity json = new ByteArrayEntity(body.getBytes("UTF-8"));
            httppost.addHeader("Content-Type", "application/json");
            httppost.setEntity(json);
            HttpResponse respons = httpclient.execute(httppost);
            String result = EntityUtils.toString(respons.getEntity());
            System.out.println(result);
        } finally {
            httpclient.close();
        }
    }
    public HttpClient MyClient(){
        HttpClient httpClient = HttpClients.createDefault();
        return  httpClient;
    }

    public void executeDeleteRequest()throws IOException{
            HttpDelete httpDelete = new HttpDelete("http://soft.it-hillel.com.ua:3000/api/users/64");
            httpDelete.setHeader("Content-Type", "application/json");
        HttpResponse respons = MyClient().execute(httpDelete);
    }
}



