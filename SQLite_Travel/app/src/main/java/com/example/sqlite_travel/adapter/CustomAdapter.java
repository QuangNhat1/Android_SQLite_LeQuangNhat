package com.example.sqlite_travel.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.sqlite_travel.Model_travel.Travel;
import com.example.sqlite_travel.R;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Travel> {
    private Context context;
    private int resource;
    private List<Travel> listTravel;

    public CustomAdapter(@NonNull Context context, int resource, @NonNull List<Travel> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.listTravel=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_list_travel,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.tvId=(TextView)convertView.findViewById(R.id.tv_id);
            viewHolder.tvName=(TextView)convertView.findViewById(R.id.tv_name);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Travel travel = listTravel.get(position);
        viewHolder.tvId.setText(String.valueOf(travel.getmId()));
        viewHolder.tvName.setText(travel.getmName());




        return convertView;

    }
    public class ViewHolder{
        private TextView tvId;
        private TextView tvName;
    }
}
