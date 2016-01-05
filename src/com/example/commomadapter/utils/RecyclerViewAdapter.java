package com.example.commomadapter.utils;

import java.util.List;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.Toast;

public abstract  class RecyclerViewAdapter<T> extends RecyclerView.Adapter<RecyclerViewHolder>{
	protected List<T> mDatas;
	protected Context mContext;
	protected int mLayoutId;
	public RecyclerViewAdapter(Context context,List<T> datas,int layoutId){
		mDatas=datas;
		mContext=context;
		mLayoutId=layoutId;
	}
	
	@Override
	public int getItemCount() {
		// TODO Auto-generated method stub
		return mDatas.size();
	}
	
	@Override
	public long getItemId(int position) {
		return position;
	}
	
	private int BindViewHolder;
	@Override
	public void onBindViewHolder(RecyclerViewHolder holder, final int position) {
		BindViewHolder++;
		Log.d("onBindViewHolder", "BindViewHolder : "+BindViewHolder);
		if (mOnItemClickListener!=null) {
			holder.itemView.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					mOnItemClickListener.onItemClick(v, position);
				}
			});
			holder.itemView.setOnLongClickListener(new OnLongClickListener() {
				@Override
				public boolean onLongClick(View v) {
					// TODO Auto-generated method stub
					mOnItemClickListener.onItemLongClick(v, position);
					return false;
				}
			});
		}
		setDates(holder, mDatas.get(position));
	}

	@Override
	public RecyclerViewHolder onCreateViewHolder(ViewGroup parent,
			int viewType) {
		// TODO Auto-generated method stub
		RecyclerViewHolder holder=new RecyclerViewHolder(LayoutInflater.from(mContext).inflate(mLayoutId, parent,false));
		return holder;
	}
	/**
	 * @param holder
	 * @param t
	 */
	public  abstract void setDates(RecyclerViewHolder holder,T data);
	
	/**
	 * 
	 * @author Administrator
	 */
	public interface OnItemClickListener{
		void onItemClick(View view,int position);
		void onItemLongClick(View view,int position);
	}
	
	private OnItemClickListener mOnItemClickListener;
	
	public void setOnItemClickListener(OnItemClickListener listener){
		mOnItemClickListener=listener;
	}
	
	public void addData(int position,T data){
		mDatas.add(position,data);
		notifyItemInserted(position);
	}
	
	public void deleteData(int position){
		mDatas.remove(position);
		notifyItemRemoved(position);
	}
	
}
