package com.example.commomadapter;

import java.util.ArrayList;
import java.util.List;

import com.example.commomadapter.utils.RecyclerViewAdapter;
import com.example.commomadapter.utils.RecyclerViewHolder;
import com.example.commomadaptertest.R;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class FeatureActivity extends Activity{
	private RadioGroup mRadioGroup;
	private RecyclerView mRecyclerView;
	private List<String> mDatas;
	private RecyclerViewAdapter<String> mAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.feature_layout);
		init();
		animotorControl();
	}
	
	private void init() {
		mRadioGroup =(RadioGroup) findViewById(R.id.radioGroup);
		mRecyclerView=(RecyclerView) findViewById(R.id.fea_rcyView);
		mDatas=new ArrayList<String>();
		for (int i = 'A'; i < 'Z'; i++) {
			mDatas.add(""+(char)i);
		}
		mAdapter=new RecyclerViewAdapter<String>(this, mDatas, R.layout.list_item_layout) {
			
			@Override
			public void setDates(RecyclerViewHolder holder, String data) {
				// TODO Auto-generated method stub
				TextView tv= holder.getView(R.id.item_tv);
				tv.setText(data);
			}
			
		};
		LinearLayoutManager linearLayoutManager= new LinearLayoutManager(this);
		mRecyclerView.setLayoutManager(linearLayoutManager);
		mRecyclerView.setAdapter(mAdapter);
	}
	
	private void animotorControl() {
		mRadioGroup=(RadioGroup) findViewById(R.id.radioGroup);
		ItemAnimator animator1=new DefaultItemAnimator();
		mRecyclerView.setItemAnimator(animator1);
		mRadioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				switch (checkedId) {
				case R.id.radio1:
					ItemAnimator animator1=new DefaultItemAnimator();
					mRecyclerView.setItemAnimator(animator1);
					break;
				
				case R.id.radio3:
					mRecyclerView.setItemAnimator(null);
					break;
				}
			}
		});
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		int id=item.getItemId();
		switch (id) {
		case R.id.action_listview:
			LinearLayoutManager linearLayoutManager= new LinearLayoutManager(this);
			mRecyclerView.setLayoutManager(linearLayoutManager);
			break;
		case R.id.action_gridview:
			GridLayoutManager gridLayoutManager= new GridLayoutManager(this, 3);
			mRecyclerView.setLayoutManager(gridLayoutManager);
			break;	
		case R.id.action_add:
			//在第二个位置添加数据
			mAdapter.addData(1, "Inserted");
			break;	
		case R.id.action_delete:
			//在第三个位置删除数据
			mAdapter.deleteData(2);
			break;	
		}
		return super.onOptionsItemSelected(item);
	}
}
