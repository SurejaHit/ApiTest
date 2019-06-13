
package com.surejahit.apitest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.android.volley.RequestQueue;
import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {
    String str,url;
    TextView txt;
    Button btn;
    JsonObjectRequest jsonObjectRequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = (TextView) findViewById(R.id.txtBox);
        btn = (Button) findViewById(R.id.subbtn);

        url = "https://reqres.in/api/users";
        final RequestQueue requestQueue = Volley.newRequestQueue(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                JSONObject jsonObject = new JSONObject();

                try {


                    jsonObject.put("name","Hit");
                    jsonObject.put("job", "Programmer");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                jsonObjectRequest = new JsonObjectRequest(
                        Request.Method.POST, url,jsonObject, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                            str = response.toString();

                        txt.setText(str);
                            }
                },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        }
                );
                requestQueue.add(jsonObjectRequest);

            }
        });


    }

}
