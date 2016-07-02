package com.example.daviddaniel.androidapp;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
/**
 * Created by DavidDaniel on 01/07/2016.
 */
public class ParserActivity {

    public ParserActivity() {
    }

    public String RegistroParse(List<NameValuePair> lst, String url)
    {
        String output=null;
        try {


            DefaultHttpClient httpClient= new DefaultHttpClient();
            HttpPost httpPost= new HttpPost(url);
            httpPost.setEntity(new UrlEncodedFormEntity(lst));
            HttpResponse httpResponse=httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            output= EntityUtils.toString(httpEntity);



        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output;
    }

    public String ListarParse(List<NameValuePair> lst, String url)
    {
        String output=null;
        try {


            DefaultHttpClient httpClient= new DefaultHttpClient();
            HttpPost httpPost= new HttpPost(url);
            httpPost.setEntity(new UrlEncodedFormEntity(lst));
            HttpResponse httpResponse=httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            output= EntityUtils.toString(httpEntity);



        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output;
    }
}
