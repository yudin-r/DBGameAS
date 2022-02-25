package ru.samsung.itschool.dbgame;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListView_Adapter extends BaseAdapter {
    ArrayList<Result> results;
    Context context;

    ListView_Adapter(Context context, ArrayList<Result> results){
        this.context = context;
        this.results = results;
    }

    @Override
    public int getCount() {
        return results.size();
    }

    @Override
    public Object getItem(int position) {
        return results.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, null);
        TextView textView = view.findViewById(R.id.nameText);
        textView.setText(results.get(position).name);
        TextView textView_ = view.findViewById(R.id.scoreText);
        if (results.get(position).score > 500){
            textView_.setTextColor(Color.GREEN);
        }else{
            textView_.setTextColor(Color.RED);
        }
        textView_.setText(results.get(position).score+"");
        return view;
    }
}
