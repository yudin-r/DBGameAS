package ru.samsung.itschool.dbgame;

import java.util.ArrayList;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HoFActivity extends Activity {

	private DBManager dbManager;
	RecyclerView recyclerView;
	RecyclerView_Adapter recyclerViewAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ho_f);
		dbManager = DBManager.getInstance(this);

		recyclerView = this.findViewById(R.id.results_list);
		ArrayList<Result> results = dbManager.getAllResults();
		ArrayList resStrings = new ArrayList();
		for (int i = 0; i < results.size(); i++) {
			resStrings.add(results.get(i).name + ": " + results.get(i).score + "\n");
		}
		recyclerViewAdapter = new RecyclerView_Adapter(getApplicationContext(), results);
		recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
		recyclerView.setAdapter(recyclerViewAdapter);
	}
}
