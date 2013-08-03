package com.example.ulttictactoe;
import android.util.Log;
import android.view.*;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class MainActivity extends Activity {

	MyAdapter ma;
	int turn=1;
	int wongame=0;
	GridView gridview;
	String[] grid=new String[9];
	int[] shown= new int[9];
	String[] Letters=new String[81];
	int shownwon=0;
	int showndraw=0;
	int gamedraw=0;
	int posi=90;
	Button ngbtn;
	int quadrant;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);	
		for(int i=0;i<81;i++)
		{
			Letters[i]="*";
		}
		for(int i=0;i<9;i++)
		{
			grid[i]="*";
		}
		for(int i=0; i<9; i++)
		{
			shown[i]=0;
		}
		ma = new MyAdapter(this,Letters);
		gridview=(GridView)findViewById(R.id.maingrid);
		gridview.setAdapter(ma);
		ngbtn = (Button) findViewById(R.id.ngbutton);
		Toast.makeText(this, "x starts First! * indicates Empty Space!", Toast.LENGTH_LONG).show();
		gridview.setOnItemClickListener(new OnItemClickListener()
		{
			public void onItemClick(AdapterView<?> parent, View v, int position, long id)
			{
				if(gamedraw==0)
				{
					if(wongame==0)
						respondtoclick(position);
					else if(wongame==1)
					{
						if(turn==2)
						{
							Toast.makeText(MainActivity.this, "The Game Has Already Been Won By X!", Toast.LENGTH_LONG).show();
						}
						else if(turn==1)
						{
							Toast.makeText(MainActivity.this, "The Game Has Already Been Won By O!", Toast.LENGTH_LONG).show();
						}
					}
				}
				else if(gamedraw==1)
					Toast.makeText(MainActivity.this, "The Game Has Been Drawn!", Toast.LENGTH_LONG).show(); 
			}
		
		});
		ngbtn.setOnClickListener(new Button.OnClickListener()
		{
			public void onClick(View v)
			{
				for(int i=0;i<81;i++)
				{
					Letters[i]="*";
				}
				ma.setLetters(Letters);
				gridview.setAdapter(ma);
				gamedraw=0;
				wongame=0;
				turn=1;
				for(int i=0;i<9;i++)
				{
					grid[i]="*";
				}
				for(int i=0; i<9; i++)
				{
					shown[i]=0;
				}
				shownwon=0;
				showndraw=0;
				posi=90;
			}
		});
		
	}
	
	public void respondtoclick(int position)
	{
		Log.i("--------","Position: "+position + "Text: " + ma.getItem(position));
		int gameswon=0;
		int pos=0;
		for(int i=0;i<9;i++)
		{
			if(grid[i].equals("*")==false)
			{
				gameswon++;
			}
		}
		int[] wongridspos= new int[gameswon];
		for(int i=0;i<3;i++)
		{
			if(grid[i].equals("*")==false)
			{
				wongridspos[pos]=i*3;
				pos++;
			}
		}
		for(int i=3;i<6;i++)
		{
			if(grid[i].equals("*")==false)
			{
				wongridspos[pos]=(i+24)+(2*(i-3));
				pos++;
			}
		}
		for(int i=6;i<9;i++)
		{
			if(grid[i].equals("*")==false)
			{
				wongridspos[pos]=(i+48)+(2*(i-6));
				pos++;
			}
		}
		
		int flag=0;
		int temp=0;
		for(int i=0;i<wongridspos.length;i++)
		{
			for(int k=0;k<3;k++,wongridspos[i]+=1)
			{
				temp=wongridspos[i];
				for(int j=0;j<3;j++,temp+=9)
				{
					if(position==temp)
						flag=1;
				}
			}
		}
		if(flag==1)
		{
			Toast.makeText(MainActivity.this,"That Grid Has Been Won!", Toast.LENGTH_SHORT).show();
			flag=0;
		}
		else
		{
			int fl=0;
			for(int i=0;i<=54;i+=27)
			{
				for(int j=0;j<=6;j+=3)
				{
					if(posi==(i+j))
						quadrant=0;
				}
			}
			for(int i=1;i<=55;i+=27)
			{
				for(int j=0;j<=6;j+=3)
				{
					if(posi==(i+j))
						quadrant=1;
				}
			}
			for(int i=2;i<=56;i+=27)
			{
				for(int j=0;j<=6;j+=3)
				{
					if(posi==(i+j))
						quadrant=2;
				}
			}
			for(int i=9;i<=63;i+=27)
			{
				for(int j=0;j<=6;j+=3)
				{
					if(posi==(i+j))
						quadrant=3;
				}
			}
			for(int i=10;i<=64;i+=27)
			{
				for(int j=0;j<=6;j+=3)
				{
					if(posi==(i+j))
						quadrant=4;
				}
			}
			for(int i=11;i<=65;i+=27)
			{
				for(int j=0;j<=6;j+=3)
				{
					if(posi==(i+j))
						quadrant=5;
				}
			}
			for(int i=18;i<=72;i+=27)
			{
				for(int j=0;j<=6;j+=3)
				{
					if(posi==(i+j))
						quadrant=6;
				}
			}
			for(int i=19;i<=73;i+=27)
			{
				for(int j=0;j<=6;j+=3)
				{
					if(posi==(i+j))
						quadrant=7;
				}
			}
			for(int i=20;i<=74;i+=27)
			{
				for(int j=0;j<=6;j+=3)
				{
					if(posi==(i+j))
						quadrant=8;
				}
			}
			if(posi!=90)
			{
			if(grid[quadrant].equals("*")==true)
			{
			
			if(quadrant==0)
			{
				for(int i=0;i<3;i++)
				{
					for(int j=0;j<3;j++)
					{
						if(position==(i*9)+j)
						{
							fl=1;
						}
					}
				}
			}
			else if(quadrant==1)
			{
				for(int i=0;i<3;i++)
				{
					for(int j=0;j<3;j++)
					{
						if(position==((i*9)+j+3))
						{
							fl=1;
						}
					}
				}
			}
			else if(quadrant==2)
			{
				for(int i=0;i<3;i++)
				{
					for(int j=0;j<3;j++)
					{
						if(position==((i*9)+j+6))
						{
							fl=1;
						}
					}
				}
			}
			else if(quadrant==3)
			{
				for(int i=27;i<=46;i+=9)
				{
					for(int j=0;j<3;j++)
					{
						if(position==(i+j))
						{
							fl=1;
						}
					}
				}
			}
			else if(quadrant==4)
			{
				for(int i=30;i<=48;i+=9)
				{
					for(int j=0;j<3;j++)
					{
						if(position==(i+j))
						{
							fl=1;
						}
					}
				}
			}
			else if(quadrant==5)
			{
				for(int i=33;i<=51;i+=9)
				{
					for(int j=0;j<3;j++)
					{
						if(position==(i+j))
						{
							fl=1;
						}
					}
				}
			}
			else if(quadrant==6)
			{
				for(int i=54;i<=72;i+=9)
				{
					for(int j=0;j<3;j++)
					{
						if(position==(i+j))
						{
							fl=1;
						}
					}
				}
			}
			else if(quadrant==7)
			{
				for(int i=57;i<=75;i+=9)
				{
					for(int j=0;j<3;j++)
					{
						if(position==(i+j))
						{
							fl=1;
						}
					}
				}
			}
			else if(quadrant==8)
			{
				for(int i=60;i<=78;i+=9)
				{
					for(int j=0;j<3;j++)
					{
						if(position==(i+j))
						{
							fl=1;
						}
					}
				}
			}
			
			}
			
			else
			{
				fl=1;
			}
			}
			
			Log.i("-----------", "posi:" + posi + " fl: " + fl + " quad: " + quadrant);
			if(posi==90||fl==1)
			{
				if(ma.getItem(position).equals("*"))
				{
					fl=0;
					if(turn==1)
					{
						Letters[position]="x";
						ma.setLetters(Letters);
						turn=2;
						gridview.setAdapter(ma);
					}
					else if(turn==2)
					{	
						Letters[position]="o";
						ma.setLetters(Letters);
						turn=1;
						gridview.setAdapter(ma);
					}
					posi=position;
					checkifwon();
				}
				else if(fl==0)
				{
					Toast.makeText(MainActivity.this, "That Spot Is Taken!", Toast.LENGTH_LONG).show();
					fl=0;
				}
			}
			else if(fl==0)
			{
				Toast.makeText(MainActivity.this, "You Are Not Allowed To Move There!", Toast.LENGTH_LONG).show();
			}
		}
	}
	
	public void checkifwon()
	{
		int total=0;
		Log.i("-------","Checking if Won!");
		for (int m=0;m<=6;m=m+3)
		{
		for(int i=0; i<3; i++)
		{
			total=0;
			for(int j=0;j<3;j++)
			{
				if(turn==2)
				{
					if(ma.getItem((i*9+j)+m).equals("x"))
					{
						Log.i("--------","Total:" + total);
						total++;
						if(total>=3)
						{
							Log.i("----------","Won!");
							if(m==0)
								won(0);
							else if(m==3)
								won(1);
							else if(m==6)
								won(2);
							break;
						}
					}
				}
				else if(turn==1)
				{
					if(ma.getItem((i*9+j)+m).equals("o"))
					{
						total++;
						if(total>=3)
						{
							Log.i("----------","Won!");
							if(m==0)
								won(0);
							else if(m==3)
								won(1);
							else if(m==6)
								won(2);
							break;
						}
					}
				}
			}
		}
		for(int j=0;j<3;j++)
		{
			total=0;
			for(int i=0; i<3; i++)
			{
				if(turn==2)
				{
					if(ma.getItem((i*9+j)+m).equals("x"))
					{
						total++;
						if(total>=3)
						{
							Log.i("----------","Won!");
							if(m==0)
								won(0);
							else if(m==3)
								won(1);
							else if(m==6)
								won(2);
							break;
						}
					}
				}
				else if(turn==1)
				{
					if(ma.getItem((i*9+j)+m).equals("o"))
					{
						total++;
						if(total>=3)
						{
							Log.i("----------","Won!");
							if(m==0)
								won(0);
							else if(m==3)
								won(1);
							else if(m==6)
								won(2);
							break;
						}
					}
				}
			}
		}
		total=0;
		for(int i=0; i<3; i++)
		{
			for(int j=0; j<3; j++)
			{
				if(turn==2)
				{
					if((i==j)&& ma.getItem((i*9+j)+m).equals("x"))
					{
						total++;
					}
			
				}
				else if(turn==1)
				{
					if((i==j)&& ma.getItem((i*9+j)+m).equals("o"))
					{
						total++;
					}
				}
			}
		}
		if(total>=3)
		{
			Log.i("----------","Won!");
			if(m==0)
				won(0);
			else if(m==3)
				won(1);
			else if(m==6)
				won(2);
			break;
		}
		total=0;
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(turn==2)
				{
					if((i+j==2)&& (ma.getItem((i*9+j)+m).equals("x")))
					{
						total++;
					}
				}
				else if(turn==1)
				{
					if((i+j==2)&& (ma.getItem((i*9+j)+m).equals("o")))
					{
						total++;
					}
				}
			}
		}
		if(total>=3)
		{
			Log.i("----------","Won in backwards diag!");
			if(m==0)
				won(0);
			else if(m==3)
				won(1);
			else if(m==6)
				won(2);
			break;
		}
		int flag=0;
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(ma.getItem((i*9+j)+m).equals("*"))
				{		
					flag=1;
					break;
				}
			}
		}
		if(flag==0)
		{
			if(m==0)
				draw(0);
			else if(m==3)
				draw(1);
			else if(m==6)
				draw(2);
		}
		else
			flag=0;
		}
		
		for (int m=27;m<=33;m=m+3)
		{
		for(int i=0; i<3; i++)
		{
			total=0;
			for(int j=0;j<3;j++)
			{
				if(turn==2)
				{
					if(ma.getItem((i*9+j)+m).equals("x"))
					{
						Log.i("--------","Total:" + total);
						total++;
						if(total>=3)
						{
							Log.i("----------","Won!");
							if(m==27)
								won(3);
							else if(m==30)
								won(4);
							else if(m==33)
								won(5);
							break;
						}
					}
				}
				else if(turn==1)
				{
					if(ma.getItem((i*9+j)+m).equals("o"))
					{
						total++;
						if(total>=3)
						{
							Log.i("----------","Won!");
							if(m==27)
								won(3);
							else if(m==30)
								won(4);
							else if(m==33)
								won(5);
							break;
						}
					}
				}
			}
		}
		for(int j=0;j<3;j++)
		{
			total=0;
			for(int i=0; i<3; i++)
			{
				if(turn==2)
				{
					if(ma.getItem((i*9+j)+m).equals("x"))
					{
						total++;
						if(total>=3)
						{
							Log.i("----------","Won!");
							if(m==27)
								won(3);
							else if(m==30)
								won(4);
							else if(m==33)
								won(5);
							break;
						}
					}
				}
				else if(turn==1)
				{
					if(ma.getItem((i*9+j)+m).equals("o"))
					{
						total++;
						if(total>=3)
						{
							Log.i("----------","Won!");
							if(m==27)
								won(3);
							else if(m==30)
								won(4);
							else if(m==33)
								won(5);
							break;
						}
					}
				}
			}
		}
		total=0;
		for(int i=0; i<3; i++)
		{
			for(int j=0; j<3; j++)
			{
				if(turn==2)
				{
					if((i==j)&& ma.getItem((i*9+j)+m).equals("x"))
					{
						total++;
					}
			
				}
				else if(turn==1)
				{
					if((i==j)&& ma.getItem((i*9+j)+m).equals("o"))
					{
						total++;
					}
				}
			}
		}
		if(total>=3)
		{
			Log.i("----------","Won!");
			if(m==27)
				won(3);
			else if(m==30)
				won(4);
			else if(m==33)
				won(5);
			break;
		}
		total=0;
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(turn==2)
				{
					if((i+j==2)&& (ma.getItem((i*9+j)+m).equals("x")))
					{
						total++;
					}
				}
				else if(turn==1)
				{
					if((i+j==2)&& (ma.getItem((i*9+j)+m).equals("o")))
					{
						total++;
					}
				}
			}
		}
		if(total>=3)
		{
			Log.i("----------","Won in backwards diag!");
			if(m==27)
				won(3);
			else if(m==30)
				won(4);
			else if(m==33)
				won(5);
			break;
		}
		int flag=0;
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(ma.getItem((i*9+j)+m).equals("*"))
				{		
					flag=1;
					break;
				}
			}
		}
		if(flag==0)
		{
			if(m==27)
				draw(3);
			else if(m==30)
				draw(4);
			else if(m==33)
				draw(5);
		}
		else
			flag=0;
		}
		
		for (int m=54;m<=60;m=m+3)
		{
		for(int i=0; i<3; i++)
		{
			total=0;
			for(int j=0;j<3;j++)
			{
				if(turn==2)
				{
					if(ma.getItem((i*9+j)+m).equals("x"))
					{
						Log.i("--------","Total:" + total);
						total++;
						if(total>=3)
						{
							Log.i("----------","Won!");
							if(m==54)
								won(6);
							else if(m==57)
								won(7);
							else if(m==60)
								won(8);
							break;
						}
					}
				}
				else if(turn==1)
				{
					if(ma.getItem((i*9+j)+m).equals("o"))
					{
						total++;
						if(total>=3)
						{
							Log.i("----------","Won!");
							if(m==54)
								won(6);
							else if(m==57)
								won(7);
							else if(m==60)
								won(8);
							break;
						}
					}
				}
			}
		}
		for(int j=0;j<3;j++)
		{
			total=0;
			for(int i=0; i<3; i++)
			{
				if(turn==2)
				{
					if(ma.getItem((i*9+j)+m).equals("x"))
					{
						total++;
						if(total>=3)
						{
							Log.i("----------","Won!");
							if(m==54)
								won(6);
							else if(m==57)
								won(7);
							else if(m==60)
								won(8);
							break;
						}
					}
				}
				else if(turn==1)
				{
					if(ma.getItem((i*9+j)+m).equals("o"))
					{
						total++;
						if(total>=3)
						{
							Log.i("----------","Won!");
							if(m==54)
								won(6);
							else if(m==57)
								won(7);
							else if(m==60)
								won(8);
							break;
						}
					}
				}
			}
		}
		total=0;
		for(int i=0; i<3; i++)
		{
			for(int j=0; j<3; j++)
			{
				if(turn==2)
				{
					if((i==j)&& ma.getItem((i*9+j)+m).equals("x"))
					{
						total++;
					}
			
				}
				else if(turn==1)
				{
					if((i==j)&& ma.getItem((i*9+j)+m).equals("o"))
					{
						total++;
					}
				}
			}
		}
		if(total>=3)
		{
			Log.i("----------","Won!");
			if(m==54)
				won(6);
			else if(m==57)
				won(7);
			else if(m==60)
				won(8);
			break;
		}
		total=0;
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(turn==2)
				{
					if((i+j==2)&& (ma.getItem((i*9+j)+m).equals("x")))
					{
						total++;
					}
				}
				else if(turn==1)
				{
					if((i+j==2)&& (ma.getItem((i*9+j)+m).equals("o")))
					{
						total++;
					}
				}
			}
		}
		if(total>=3)
		{
			Log.i("----------","Won in backwards diag!");
			if(m==54)
				won(6);
			else if(m==57)
				won(7);
			else if(m==60)
				won(8);
			break;
		}
		int flag=0;
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(ma.getItem((i*9+j)+m).equals("*"))
				{		
					flag=1;
					break;
				}
			}
		}
		if(flag==0)
		{
			if(m==54)
				draw(6);
			else if(m==57)
				draw(7);
			else if(m==60)
				draw(8);
		}
		else
			flag=0;
		}
	}
	
	public void won(int number)
	{
		if(turn==2)
		{
			if(shown[number]==0)
			{
				Toast.makeText(MainActivity.this, "X Has Won Grid Number " + (number+1), Toast.LENGTH_LONG).show();
				grid[number]="x";
				shown[number]=1;
				checkifwongame();
			}
		}
		else if(turn==1)
		{
			if(shown[number]==0)
			{
				Toast.makeText(MainActivity.this, "O Has Won Grid Number " + (number+1), Toast.LENGTH_LONG).show();
				grid[number]="o";
				shown[number]=1;
				checkifwongame();
			}
		}
		checkifwongame();
	}
	
	public void draw(int number)
	{
		if(shown[number]==0)
		{
			Toast.makeText(MainActivity.this, "Grid " + (number+1) + " Has Been Drawn!", Toast.LENGTH_LONG).show();
			grid[number]="d";
			shown[number]=1;
			checkifwongame();
		}
	}
	
	public void checkifwongame()
	{
		int total=0;
		Log.i("----","Grid: "+ grid[0]+grid[1]+grid[2]+grid[3]+grid[4]+grid[5]+grid[6]+grid[7]+grid[8]);
		for(int i=0;i<3;i++)
		{
			total=0;
			for(int j=0;j<3;j++)
			{
				if(turn==2)
				{
					if(grid[i*3+j]=="x")
					total++;
				}
				else if(turn==1)
				{
					if(grid[i*3+j]=="o")
						total++;
				}
			}
			if(total>=3)
			{
				wongame=1;
			}
		}
		
		for(int j=0;j<3;j++)
		{
			total=0;
			for(int i=0;i<3;i++)
			{
				if(turn==2)
				{
					if(grid[i*3+j]=="x")
					total++;
				}
				else if(turn==1)
				{
					if(grid[i*3+j]=="o")
						total++;
				}
			}
			if(total>=3)
			{
				wongame=1;
			}
		}
		
		total=0;
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(turn==2)
				{
					if(i==j && grid[i*3+j]=="x")
						total++;
				}
				if(turn==1)
				{
					if(i==j && grid[i*3+j]=="o")
						total++;
				}
			}
		}
		if(total>=3)
		{
			wongame=1;
		}
		
		total=0;
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(turn==2)
				{
					if(i+j==2 && grid[i*3+j]=="x")
						total++;
				}
				if(turn==1)
				{
					if(i+j==2 && grid[i*3+j]=="o")
						total++;
				}
			}
		}
		if(total>=3)
		{
			wongame=1;
		}
		
		if(wongame==1&&shownwon==0)
		{
			if(turn==2)
				Toast.makeText(MainActivity.this, "X Has Won The Game!", Toast.LENGTH_LONG).show();
			else if(turn==1)
				Toast.makeText(MainActivity.this, "O Has Won The Game!", Toast.LENGTH_LONG).show();
			shownwon=1;
		}
		int flag=0;
		for(int i=0;i<9;i++)
		{
			if(grid[i].equals("*"))
			{
				flag=1;
			}
		}
		if((flag==0)&&(wongame==0)&&showndraw==0)
		{
			gamedraw=1;
			Toast.makeText(MainActivity.this, "The Match Has Been Drawn!", Toast.LENGTH_LONG).show();
			showndraw=1;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
