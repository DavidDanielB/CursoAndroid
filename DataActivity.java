package com.example.daviddaniel.androidapp;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by DavidDaniel on 01/07/2016.
 */
public class DataActivity {

    ParserActivity loginparse;
    String url = "http://192.168.1.33:8080/Servicioweb/Servicio";

    public void getdata(String ap, String am, String nm,String dn,String ci,String di, String te,String em ) {

        List<NameValuePair> lst = new ArrayList<NameValuePair>();
        lst.add(new BasicNameValuePair("ap", ap));
        lst.add(new BasicNameValuePair("am", am));
        lst.add(new BasicNameValuePair("nm", nm));
        lst.add(new BasicNameValuePair("dn", dn));
        lst.add(new BasicNameValuePair("ci", ci));
        lst.add(new BasicNameValuePair("di", di));
        lst.add(new BasicNameValuePair("te", te));
        lst.add(new BasicNameValuePair("em", em));
        loginparse = new ParserActivity();
        loginparse.RegistroParse(lst, url);
    }
}
