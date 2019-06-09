package com.example.manu.homedecor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class CustomAdapter extends BaseAdapter {

    String[] result;
    Context ctx;
    int[] imgId;
    private static LayoutInflater inflater = null;

    public CustomAdapter(String[] result, Context ctx, int[] imgId) {
        this.result = result;
        this.ctx = ctx;
        this.imgId = imgId;

        inflater = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout.row_list,null);

        TextView items_lists = (TextView)view.findViewById(R.id.category_name);
        ImageView image_lists = (ImageView)view.findViewById(R.id.image);

        items_lists.setText(result[position]);
//        Picasso.get().load(imgId[position]).into(image_lists);
        Picasso.with(ctx).load(imgId[position]).into(image_lists);

        return view;
    }
}