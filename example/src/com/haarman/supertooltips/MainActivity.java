package com.haarman.supertooltips;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;

public class MainActivity extends Activity implements View.OnClickListener, ToolTipView.OnToolTipViewClickedListener
{
	
	private ToolTipView mRedToolTipView;
	private ToolTipView mGreenToolTipView;
	private ToolTipView mBlueToolTipView;
	private ToolTipView mPurpleToolTipView;
	private ToolTipView mOrangeToolTipView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_main);
		
		this.findViewById(R.id.activity_main_redtv).setOnClickListener(MainActivity.this);
		this.findViewById(R.id.activity_main_greentv).setOnClickListener(MainActivity.this);
		this.findViewById(R.id.activity_main_bluetv).setOnClickListener(MainActivity.this);
		this.findViewById(R.id.activity_main_purpletv).setOnClickListener(MainActivity.this);
		this.findViewById(R.id.activity_main_orangetv).setOnClickListener(MainActivity.this);
		
		new Handler().postDelayed(new Runnable()
		{
			@Override
			public void run()
			{
				MainActivity.this.addRedToolTipView();
			}
		}, 500);
		
		new Handler().postDelayed(new Runnable()
		{
			@Override
			public void run()
			{
				MainActivity.this.addGreenToolTipView();
			}
		}, 700);
		
		new Handler().postDelayed(new Runnable()
		{
			@Override
			public void run()
			{
				MainActivity.this.addOrangeToolTipView();
			}
		}, 900);
		
		new Handler().postDelayed(new Runnable()
		{
			@Override
			public void run()
			{
				MainActivity.this.addBlueToolTipView();
			}
		}, 1100);
		
		new Handler().postDelayed(new Runnable()
		{
			@Override
			public void run()
			{
				MainActivity.this.addPurpleToolTipView();
			}
		}, 1300);
		
	}
	
	private void setToolTipView(ToolTipView v, int color)
	{
		switch (color)
		{
			case R.color.holo_red:
				this.mRedToolTipView = v;
				break;
				
			case R.color.holo_green:
				this.mGreenToolTipView = v;
				break;
				
			case R.color.holo_blue:
				this.mBlueToolTipView = v;
				break;
				
			case R.color.holo_purple:
				this.mPurpleToolTipView = v;
				break;
				
			case R.color.holo_orange:
				this.mOrangeToolTipView = v;
				break;
		}
	}
	
	private void addToolTipView(String text, int color, boolean shadow, int animation, int atView)
	{
		ToolTipOptions tto = new ToolTipOptions().withText(text).withColor(this.getResources().getColor(color)).withShadow(shadow).withAnimationType(animation);
		ToolTipView ttv = new ToolTipView(this);
		ttv.setToolTipOptions(tto);
		ttv.showAt(this.findViewById(atView));
		ttv.setOnToolTipViewClickedListener(MainActivity.this);
		
		this.setToolTipView(ttv, color);
	}
	
	private void addToolTipView(View view, int color, boolean shadow, int animation, int atView)
	{
		ToolTipOptions tto = new ToolTipOptions().withContentView(view).withColor(this.getResources().getColor(color)).withShadow(shadow).withAnimationType(animation);
		ToolTipView ttv = new ToolTipView(this);
		ttv.setToolTipOptions(tto);
		ttv.showAt(this.findViewById(atView));
		ttv.setOnToolTipViewClickedListener(MainActivity.this);
		
		this.setToolTipView(ttv, color);
	}
	
	private void addRedToolTipView()
	{
		this.addToolTipView("A beautiful Button", R.color.holo_red, true, ToolTipOptions.ANIMATIONTYPE_FROMMASTERVIEW, R.id.activity_main_redtv);
	}
	
	private void addGreenToolTipView()
	{
		this.addToolTipView("Another beautiful Button!", R.color.holo_green, false, ToolTipOptions.ANIMATIONTYPE_FROMMASTERVIEW, R.id.activity_main_greentv);
	}
	
	private void addBlueToolTipView()
	{
		this.addToolTipView("Moarrrr buttons!", R.color.holo_blue, false, ToolTipOptions.ANIMATIONTYPE_FROMTOP, R.id.activity_main_bluetv);
	}
	
	private void addPurpleToolTipView()
	{
		this.addToolTipView(LayoutInflater.from(this).inflate(R.layout.custom_tooltip, null), R.color.holo_purple, true, ToolTipOptions.ANIMATIONTYPE_FROMMASTERVIEW, R.id.activity_main_purpletv);
	}
	
	private void addOrangeToolTipView()
	{
		this.addToolTipView("Tap me!", R.color.holo_orange, false, ToolTipOptions.ANIMATIONTYPE_FROMMASTERVIEW, R.id.activity_main_orangetv);
	}
	
	@Override
	public void onClick(View view)
	{
		if (view.getId() == R.id.activity_main_redtv)
		{
			if (this.mRedToolTipView == null)
			{
				this.addRedToolTipView();
			}
			else
			{
				this.mRedToolTipView.remove();
				this.mRedToolTipView = null;
			}
		}
		if (view.getId() == R.id.activity_main_greentv)
		{
			if (this.mGreenToolTipView == null)
			{
				this.addGreenToolTipView();
			}
			else
			{
				this.mGreenToolTipView.remove();
				this.mGreenToolTipView = null;
			}
		}
		if (view.getId() == R.id.activity_main_bluetv)
		{
			if (this.mBlueToolTipView == null)
			{
				this.addBlueToolTipView();
			}
			else
			{
				this.mBlueToolTipView.remove();
				this.mBlueToolTipView = null;
			}
		}
		if (view.getId() == R.id.activity_main_purpletv)
		{
			if (this.mPurpleToolTipView == null)
			{
				this.addPurpleToolTipView();
			}
			else
			{
				this.mPurpleToolTipView.remove();
				this.mPurpleToolTipView = null;
			}
		}
		if (view.getId() == R.id.activity_main_orangetv)
		{
			if (this.mOrangeToolTipView == null)
			{
				this.addOrangeToolTipView();
			}
			else
			{
				this.mOrangeToolTipView.remove();
				this.mOrangeToolTipView = null;
			}
		}
	}
	
	@Override
	public void onToolTipViewClicked(ToolTipView toolTipView)
	{
		if (this.mRedToolTipView == toolTipView)
		{
			this.mRedToolTipView = null;
		}
		else if (this.mGreenToolTipView == toolTipView)
		{
			this.mGreenToolTipView = null;
		}
		else if (this.mBlueToolTipView == toolTipView)
		{
			this.mBlueToolTipView = null;
		}
		else if (this.mPurpleToolTipView == toolTipView)
		{
			this.mPurpleToolTipView = null;
		}
		else if (this.mOrangeToolTipView == toolTipView)
		{
			this.mOrangeToolTipView = null;
		}
	}
}
