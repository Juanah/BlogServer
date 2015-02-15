package de.juanah.lenasblogwebservice.DTO.Communication;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import java.io.UnsupportedEncodingException;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by jonas on 15.02.15.
 */
public class WCFHelper {

    public String Request(String command)
    {
        HttpClient httpClient = new DefaultHttpClient();

        String url = ServiceConstants.BaseAddress;

        try {
            command = java.net.URLEncoder.encode(command,"UTF8");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
            return null;
        }
        url += command;
        HttpGet httpGet = null;
        try {
             httpGet = new HttpGet(url);

        }catch (Exception e)
        {
            Log.e("ERRORWCF",e.getMessage());
        }

        HttpResponse response;

        try {
            response = httpClient.execute(httpGet);

            HttpEntity entity = response.getEntity();

            //Read the server response and attempt to parse it as JSON
            InputStream content = entity.getContent();
            //Aus einem mir nicht ersichtlichen Grund frist der gson builder nur strings
            StringBuilder inputStringBuilder = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(content, "UTF-8"));
            String line = bufferedReader.readLine();
            while(line != null){
                inputStringBuilder.append(line);inputStringBuilder.append('\n');
                line = bufferedReader.readLine();
            }
            String jsonString = inputStringBuilder.toString();

            return jsonString;


        }catch (Exception e)
        {
            Log.e("WCF", "Error Request failed");
        }

        return null;
    }

}
