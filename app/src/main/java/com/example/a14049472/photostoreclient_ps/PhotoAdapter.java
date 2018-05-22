package com.example.a14049472.photostoreclient_ps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class PhotoAdapter extends ArrayAdapter<Photo> {
    private ArrayList<Photo> alPhoto;
    private Context context;

    private TextView tvTitle;
    private TextView tvDescription;
    private TextView tvCreatedBy;
    private TextView tvImage;

    public PhotoAdapter(Context context, int resource, ArrayList<Photo> objects) {
        super(context, resource, objects);
        alPhoto = objects;
        this.context = context;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.photo_row, parent, false);

        tvTitle = (TextView) rowView.findViewById(R.id.tvName);
        tvDescription = (TextView) rowView.findViewById(R.id.tvDescription);
        tvCreatedBy=(TextView)rowView.findViewById(R.id.tvCreatedBy);
        tvImage=(TextView)rowView.findViewById(R.id.tvImage);
        Photo currPhoto = alPhoto.get(position);
        tvTitle.setText(currPhoto.getTitle());
        tvDescription.setText(currPhoto.getDescription());
        tvCreatedBy.setText(currPhoto.getCreated_by());
        tvImage.setText(currPhoto.getImage());
        return rowView;

    }

}
