package com.example.p;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    // step 4 make a textview object
    TextView tv;

//    https://jsonplaceholder.typicode.com/posts/1;

//    Step 1:- Make a String type url where we hav eto paste out url
    String url = "https://jsonplaceholder.typicode.com/posts/1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tv);

        // Step 2:- Make a queue (RequestQueue)
        // if you didn't get in suggestion then press Alt+Enter

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        // Step 3:- Make a json object Request

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    tv.setText(response.getString("body"));
                    Log.d("Main","EveryThing is okk");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(MainActivity.this, "Turn on net", Toast.LENGTH_SHORT).show();
                Log.d("Main","EveryThing is not okk");

            }
        });

        requestQueue.add(jsonObjectRequest);
    }
}