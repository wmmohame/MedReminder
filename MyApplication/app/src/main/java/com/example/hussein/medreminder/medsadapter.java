package com.example.hussein.medreminder;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.axu1.MedReminder.R;

import java.util.ArrayList;

public class medsadapter extends BaseAdapter{

    private Context context;
    private int layout;
    private ArrayList<meds> medList;


    public medsadapter(Context context, int layout, ArrayList<meds> medList) {
        this.context = context;
        this.layout = layout;
        this.medList = medList;
    }

    @Override
    public int getCount() {
        return medList.size();
    }

    @Override
    public Object getItem(int position) {
        return medList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder{
        ImageView imageView;
        TextView txtname;
        TimePicker time;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        View row = view;
        ViewHolder holder = new ViewHolder();

        if(row == null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);

            holder.txtname = (TextView) row.findViewById(R.id.txtName);
            holder.imageView = (ImageView) row.findViewById(R.id.imgmed);

            row.setTag(holder);

        }
        else{
            holder = (ViewHolder) row.getTag();
        }

        meds meds = medList.get(position);

        holder.txtname.setText(meds.getName());
        //holder.time.setCurrentHour(Integer.parseInt(meds.getTime()));
        // holder.time.setCurrentMinute(Integer.parseInt(meds.getTime()));

        byte[] medImage = meds.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(medImage, 0, medImage.length);
        holder.imageView.setImageBitmap(bitmap);

        return row;
    }
}
