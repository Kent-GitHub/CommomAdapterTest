package com.example.commomadapter.utils;

import java.util.List;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;

public abstract class AAViewAdapterV1<D> extends RecyclerView.Adapter<AAViewHolder<D>>{
	protected List<D> mDatas;
	protected Context mContext;
	protected MyView<D> mView;
	public AAViewAdapterV1(Context context,MyView<D> viewGroup,List<D> datas){
		mDatas=datas;
		mContext=context;
		mView=viewGroup;
	}
	
	@Override
	public int getItemCount() {
		return mDatas.size();
	}
	
//	public  abstract void setDates(RecyclerViewHolder holder,T data);

	@Override
	public void onBindViewHolder(AAViewHolder<D> holder, final int position) {
		mView=holder.getView();
		mView.bind(mDatas.get(position));
		
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
	}
	
	@Override
	public AAViewHolder<D> onCreateViewHolder(ViewGroup parent, int viewType) {
		// TODO Auto-generated method stub
		return new AAViewHolder<D>(onCreateItemView(parent, viewType));
	}
	
	protected abstract View onCreateItemView(ViewGroup parent, int viewType);
	
	/**
	 * About Listener
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
	
}
