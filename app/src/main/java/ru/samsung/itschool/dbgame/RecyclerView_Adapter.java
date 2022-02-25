package ru.samsung.itschool.dbgame;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerView_Adapter extends RecyclerView.Adapter<RecyclerView_Adapter.ResultsViewHolder>{
    ArrayList<Result> results;
    Context context;

    RecyclerView_Adapter(Context context, ArrayList<Result> results){
        //Log.d("Biggg", results.toString());
        this.results = results;
        this.context = context;
    }

    @Override
    public RecyclerView_Adapter.ResultsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        ResultsViewHolder viewHolder = new ResultsViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView_Adapter.ResultsViewHolder holder, int position) {
        Result r = results.get(position);
        holder.bind(r.name, String.valueOf(r.score));
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    class ResultsViewHolder extends RecyclerView.ViewHolder {
        TextView nameText;
        TextView scoreText;

        public ResultsViewHolder(@NonNull View itemView) {
            super(itemView);
            nameText = itemView.findViewById(R.id.nameText);
            scoreText = itemView.findViewById(R.id.scoreText);
        }
        void bind(String name, String score){
            nameText.setText(name);
            scoreText.setText(score);
        }


    }
}
