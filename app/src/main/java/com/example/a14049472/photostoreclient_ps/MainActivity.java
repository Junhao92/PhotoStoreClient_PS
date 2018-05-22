package com.example.a14049472.photostoreclient_ps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<Category> alCategory = new ArrayList<Category>();
    ArrayAdapter<Category>aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }
    protected  void oResume(){
        super.onResume();
        lv=(ListView)findViewById(R.id.lv);
        aa= new ArrayAdapter<Category>(this,R.layout.row,alCategory);
        //aa= new CategoryAdapter(this,R.layout.row,alCategory);
        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(MainActivity.this,PhotoDetails.class);
                //intent.putExtra("Category",selectedCategory);
                startActivity(intent);


            }
        });



        String url="https://codemusically.000webhostapp.com/C302_P06_PhotoStoreWS/getCategories.php";
        HttpRequest request = new HttpRequest(url);

        request.setOnHttpResponseListener(mHttpResponseListener);
        request.setMethod("GET");
        request.execute();

    }
    // Code for step 2 start
    private HttpRequest.OnHttpResponseListener mHttpResponseListener =
            new HttpRequest.OnHttpResponseListener() {
                @Override
                public void onResponse(String response){

                    // process response here
                    try {
                        JSONArray jsonArray = new JSONArray(response);

                        for (int i=0; i<jsonArray.length(); i++){
                            JSONObject jsonObj = jsonArray.getJSONObject(i);

                            int categoryId = jsonObj.getInt("category_id");
                            String categoryName = jsonObj.getString("name");
                            String description = jsonObj.getString("description");



                            Category result=new Category(categoryId,categoryName,description);
                            alCategory.add(result);
                        }
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }

                   aa.notifyDataSetChanged();
                }
            };
    // Code for step 2 end
}
