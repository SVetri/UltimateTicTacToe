package com.example.ulttictactoe;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {

	private Context context;
	private String[] Letters = new String[81];
	public MyAdapter(Context context,String[] letters)
	{
		this.context=context;
		this.Letters=letters;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 81;
	}

	@Override
	public String getItem(int position) {
		// TODO Auto-generated method stub
		return Letters[position];
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void setLetters(String[] letters)
	{
		this.Letters=letters;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) 
	{
		ImageView imageview;
		if (convertView == null) 
		{ 
            imageview = new ImageView(context);
            imageview.setLayoutParams(new GridView.LayoutParams(75,75));
            imageview.setPadding(15, 15, 15, 15);
            imageview.setScaleType(ImageView.ScaleType.CENTER_CROP);
		}
		else imageview=(ImageView) convertView;
		
		if(Letters[position].equals("*"))
		{
			imageview.setImageResource(R.drawable.ic_blankblack);
		}
		else if(Letters[position].equals("x"))
		{
			imageview.setImageResource(R.drawable.ic_xblack);
		}
		else if(Letters[position].equals("o"))
		{
			imageview.setImageResource(R.drawable.ic_oblack);
		}
		return imageview;
	}

}