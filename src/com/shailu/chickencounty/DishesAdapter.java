package com.shailu.chickencounty;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class DishesAdapter extends ArrayAdapter<Dish> {

	private ArrayList<Dish> list;

	public DishesAdapter(Context context, int resource, ArrayList<Dish> objects) {
		super(context, resource, objects);
		this.list = objects;

	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		View v = convertView;
		if (v == null) {
			LayoutInflater inflater = (LayoutInflater) getContext()
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = inflater.inflate(R.layout.list_view_item, null);
		}

		Dish d = list.get(position);

		if (d != null) {
			Log.i("CC",
					"View is not null so setting properties as " + d.getName()
							+ " " + d.getPrice());
			TextView dishName = (TextView) v.findViewById(R.id.Dish_Name);
			TextView price = (TextView) v.findViewById(R.id.price);
			// Spinner sp = (Spinner) v.findViewById(R.id.quanity);
			List<String> myQuantitySpinner = new ArrayList<String>();
			myQuantitySpinner.add("half");
			myQuantitySpinner.add("full");
			if (dishName != null)
				dishName.setText(d.getName());
			if (price != null)
				price.setText(d.getPrice() + "");
			// if(sp!=null)
			// {
			// ArrayAdapter<String> spinnerArrayAdapter = new
			// ArrayAdapter<String>(getContext(),
			// android.R.layout.simple_spinner_item, myQuantitySpinner);
			// spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			// // The drop down vieww
			// sp.setAdapter(spinnerArrayAdapter);
			// }
		}
		Log.i("CC", "returning view " + v);
		v.setVisibility(View.VISIBLE);
		return v;
	}
}
