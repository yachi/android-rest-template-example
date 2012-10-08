package org.newsweb;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ViewById;

@EActivity
public class newsweb extends Activity
{
    @ViewById(R.id.text)
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        String url = "http://hknewsweb.herokuapp.com/api/apple/sections";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
        SectionModel []  sections = restTemplate.getForObject(url, SectionModel[].class);
        setContentView(R.layout.main);
        tv.setText(sections[0].getLink());
    }
}