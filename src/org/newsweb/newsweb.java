package org.newsweb;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import org.springframework.web.client.RestTemplate;
import org.springframework.http.converter.StringHttpMessageConverter;

public class newsweb extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        String url = "http://hknewsweb.herokuapp.com/api/apple/sections";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        String result = restTemplate.getForObject(url, String.class);
        setContentView(R.layout.main);
        TextView tv = (TextView) findViewById(R.id.text);
        tv.setText(result);
    }
}
