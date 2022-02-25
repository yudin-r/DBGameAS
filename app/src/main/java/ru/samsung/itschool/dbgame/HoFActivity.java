package ru.samsung.itschool.dbgame;

import java.util.ArrayList;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class HoFActivity extends Activity {

	private DBManager dbManager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ho_f);
		dbManager = DBManager.getInstance(this);

		ListView results_list = findViewById(R.id.list_results);
		ArrayList<Result> results = dbManager.getAllResults();
		ArrayList resString = new ArrayList();
		String resStr = "";
		for (int i = 0; i < results.size(); i++) {
			resString.add(results.get(i).toString());
		}
		results_list.setAdapter(new ResultsAdapter(this,  results));
	}
}
