package org.newsweb;

import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ViewById;

@EActivity(R.layout.main)
public class newsweb extends Activity
{
    @ViewById(R.id.text)
    TextView tv;

    @AfterViews
    void setText() {
        String url = "http://hknewsweb.herokuapp.com/api/apple/sections";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
        SectionModel []  sections = restTemplate.getForObject(url, SectionModel[].class);
        tv.setText(sections[0].getLink());
    }
}
