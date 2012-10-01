package org.newsweb;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import org.springframework.web.client.RestTemplate;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;

public class newsweb extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        String url = "http://hknewsweb.herokuapp.com/api/apple/sections";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
        SectionModel []  sections = restTemplate.getForObject(url, SectionModel[].class);
        setContentView(R.layout.main);
        TextView tv = (TextView) findViewById(R.id.text);
        tv.setText(sections[0].getLink());
    }
}
