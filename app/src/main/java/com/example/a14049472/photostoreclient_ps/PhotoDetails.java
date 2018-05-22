package com.example.a14049472.photostoreclient_ps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class PhotoDetails extends AppCompatActivity {

    ListView lvPhoto;
    ArrayList<Photo> alPhoto = new ArrayList<Photo>();
    ArrayAdapter<Photo> aaPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_details);


    }

    protected void oResume() {
        super.onResume();
        lvPhoto = (ListView) findViewById(R.id.lvPhoto);
        aaPhoto = new ArrayAdapter<Photo>(this, R.layout.photo_row, alPhoto);
        //aa= new CategoryAdapter(this,R.layout.row,alCategory);
        lvPhoto.setAdapter(aaPhoto);

    }
    private HttpRequest.OnHttpResponseListener mHttpResponseListener =
            new HttpRequest.OnHttpResponseListener() {
                @Override
                public void onResponse(String response){

                    // process response here
                    try {
                        JSONArray jsonArray = new JSONArray(response);

                        for (int i=0; i<jsonArray.length(); i++){
                            JSONObject jsonObj = jsonArray.getJSONObject(i);

                            int photoId = jsonObj.getInt("photo_id");
                            String title = jsonObj.getString("title");
                            String description = jsonObj.getString("description");
                            String image = jsonObj.getString("image");
                            String created_id = jsonObj.getString("created_id");
                            String created_by = jsonObj.getString("created_by");



                            Photo result=new Photo(photoId,title,description,image,created_id,created_by);
                            alPhoto.add(result);
                        }
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }

                    aaPhoto.notifyDataSetChanged();
                }
            };
}
