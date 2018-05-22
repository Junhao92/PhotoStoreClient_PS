package com.example.a14049472.photostoreclient_ps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CategoryAdapter extends ArrayAdapter<Category> {


    private ArrayList<Category> alCategory;
    private Context context;

    private TextView tvName;
    private TextView tvDescription;

    public CategoryAdapter(Context context, int resource, ArrayList<Category> objects) {
        super(context, resource, objects);
        alCategory = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row, parent, false);

        tvName = (TextView) rowView.findViewById(R.id.tvName);
        tvDescription = (TextView) rowView.findViewById(R.id.tvDescription);
        Category currCat = alCategory.get(position);
        tvName.setText(currCat.getName());
        tvDescription.setText(currCat.getDescription());
        return rowView;

    }




}
