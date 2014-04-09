package com.example.weightmate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

public class CalculatorActivity extends ActionBarActivity {
	public final static String EXTRA_BMR = "com.example.weightmate.BMR";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calculator);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.calculator, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_calculator,
					container, false);
			return rootView;
		}
	}
	


	
	public void calculateBMR(View view){
		double BMR = 0;
		double calorieCount = 0; 
		
			
		EditText weightInput = (EditText) findViewById(R.id.weight_edit);
		int weight = Integer.parseInt(weightInput.getText().toString());
		
		EditText heightInputFeet = (EditText) findViewById(R.id.height_feet_edit);
		EditText heightInputInches = (EditText) findViewById(R.id.height_inches_edit);
		int height = (Integer.parseInt(heightInputFeet.getText().toString()) * 12) + Integer.parseInt(heightInputInches.getText().toString());
		
		EditText ageInput = (EditText)findViewById(R.id.age_edit);
		int age = Integer.parseInt(ageInput.getText().toString());
		
		RadioButton male = (RadioButton) findViewById(R.id.male_button);
		RadioButton female = (RadioButton) findViewById(R.id.female_button);
		
		Spinner activity_factor = (Spinner)view.findViewById(R.id.activity_factor); 
		String activity = activity_factor.getSelectedItem().toString(); 
		
			
		if(female.isChecked()){
			BMR = 655 + (4.3*weight) + (4.7*height) - (4.7*age);
			if (activity == "sedentary (little to no exercise)"){
				double activityNum = 0.2;
				calorieCount = BMR + (BMR * activityNum); 
			}
			if (activity == "lightly active (exercise/sports 1&#8211;3 times/week)"){
				double activityNum = 0.3;
				calorieCount = BMR + (BMR * activityNum); 
			}
			if (activity == "moderately active (exercise/sports 3&#8211;5 times/week)"){
				double activityNum = 0.4;
				calorieCount = BMR + (BMR * activityNum); 
			}
			if (activity == "very active (hard exercise/sports 6&#8211;7 times/week)"){
				double activityNum = 0.5;
				calorieCount = BMR + (BMR * activityNum); 
			}
			if (activity == "extra active (very hard exercise/sports or physical job)"){
				double activityNum = 0.6;
				calorieCount = BMR + (BMR * activityNum); 
			}
		
		}
		else if(male.isChecked()){
			BMR = 66 + (6.3*weight) + (12.9*height) - (6.8*age);
			if (activity == "sedentary (little to no exercise)"){
				double activityNum = 0.2;
				calorieCount = BMR + (BMR * activityNum); 
			}
			if (activity == "lightly active (exercise/sports 1&#8211;3 times/week)"){
				double activityNum = 0.3;
				calorieCount = BMR + (BMR * activityNum); 
			}
			if (activity == "moderately active (exercise/sports 3&#8211;5 times/week)"){
				double activityNum = 0.4;
				calorieCount = BMR + (BMR * activityNum); 
			}
			if (activity == "very active (hard exercise/sports 6&#8211;7 times/week)"){
				double activityNum = 0.5;
				calorieCount = BMR + (BMR * activityNum); 
			}
			if (activity == "extra active (very hard exercise/sports or physical job)"){
				double activityNum = 0.6;
				calorieCount = BMR + (BMR * activityNum); 
			}
		}
		
		String toSend = "" + calorieCount;
		
		Intent intent = new Intent(this, CalculatorResultsActivity.class);
		intent.putExtra(EXTRA_BMR, toSend);
		startActivity(intent);
	}

}
