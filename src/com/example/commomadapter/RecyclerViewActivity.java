package com.example.commomadapter;

import java.util.ArrayList;
import java.util.List;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ItemClick;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.commomadapter.bean.Bean;
import com.example.commomadapter.utils.DividerItemDecoration;
import com.example.commomadapter.utils.RecyclerViewAdapter;
import com.example.commomadapter.utils.RecyclerViewAdapter.OnItemClickListener;
import com.example.commomadapter.utils.RecyclerViewHolder;
import com.example.commomadaptertest.R;
@EActivity
public class RecyclerViewActivity extends Activity implements OnClickListener{
	private RecyclerView mRecyclerView;
	private List<String> mDatas1;
	private List<Bean> mDatas2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.recyclerview_layout);
		init();
		initDatas();
	}
	
//	@ItemClick(R.id.recyclerview)
//	void onItemClick(int position){
//		Toast.makeText(getApplicationContext(), "Item Click : "+position , Toast.LENGTH_SHORT).show();
//	}
	
	private void init() {
		mRecyclerView=(RecyclerView) findViewById(R.id.recyclerview);
		findViewById(R.id.data1).setOnClickListener(this);
		findViewById(R.id.data2).setOnClickListener(this);
		//����RecyclerView ���ֹ���
		LinearLayoutManager manager=new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
		mRecyclerView.setLayoutManager(manager);
		//����RecyclerView��Item�ָ��ߣ�
		mRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
	}
	private void initDatas(){
		mDatas1=new ArrayList<String>();
		for (int i = 0; i < 101; i++) {
			mDatas1.add("Item : " +i);
		}
		mDatas2=new ArrayList<Bean>();
		for (int i = 0; i < 51; i++) {
			Bean bean=new Bean(R.drawable.ic_launcher, "���ű���"+i, "��������~~~~~~~~~~~~~~~~~~~"+i);
			mDatas2.add(bean);
		}
	}
	
	@Override
	public  void onClick(View arg0) {
		switch (arg0.getId()) {
		case R.id.data1:
			RecyclerViewAdapter<String> adapter1=new RecyclerViewAdapter<String>(getApplicationContext(), mDatas1, R.layout.list_item_layout) {

				@Override
				public void setDates(RecyclerViewHolder holder, String data) {
					// TODO Auto-generated method stub
					TextView tv= holder.getView(R.id.item_tv);
					tv.setText(data);
				}
			};
			
			mRecyclerView.setAdapter(adapter1);
			
//			adapter1.setOnItemClickListener(new OnItemClickListener() {
//
//				@Override
//				public void onItemClick(View view, int position) {
//					Toast.makeText(getApplicationContext(), "Item Click : "+position , Toast.LENGTH_SHORT).show();
//				}
//
//				@Override
//				public void onItemLongClick(View view, int position) {
//					// TODO Auto-generated method stub
//					Toast.makeText(getApplicationContext(), "Item Long Click : "+position, Toast.LENGTH_SHORT).show();
//				}
//			});
			break;
			
		case R.id.data2:
			RecyclerViewAdapter<Bean> adapter2=new RecyclerViewAdapter<Bean>(getApplicationContext(), mDatas2, R.layout.bean_layout) {

				@Override
				public void setDates(RecyclerViewHolder holder, Bean bean) {
					// TODO Auto-generated method stub
					ImageView iv= holder.getView(R.id.bean_iv);
					iv.setImageResource(bean.iconId);
					TextView title= holder.getView(R.id.bean_title);
					title.setText(bean.newsTitle);
					TextView content= holder.getView(R.id.bean_content);
					content.setText(bean.newsContent);
				}
			};
			
			mRecyclerView.setAdapter(adapter2);
			adapter2.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(View view, int position) {
					Toast.makeText(getApplicationContext(), "Item Click : "+position , Toast.LENGTH_SHORT).show();
				}

				@Override
				public void onItemLongClick(View view, int position) {
					// TODO Auto-generated method stub
					Toast.makeText(getApplicationContext(), "Item Long Click : "+position, Toast.LENGTH_SHORT).show();
				}
			});
			break;
		}
	}
	
	
}
