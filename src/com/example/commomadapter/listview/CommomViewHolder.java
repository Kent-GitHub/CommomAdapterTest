package com.example.commomadapter.listview;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CommomViewHolder {
	private SparseArray<View> mViews;
	private int mPosition;
	private View mConverView;
	private Context mContext;
	
	private CommomViewHolder(Context context,ViewGroup parent,int layoutId,int position){
		mPosition=position;
		mViews=new SparseArray<View>();
		mContext=context;
		mConverView=LayoutInflater.from(mContext).inflate(layoutId, parent,false);
		mConverView.setTag(this);
	}
	
	public static  CommomViewHolder getViewHolder(Context context,View converView,ViewGroup parent,int layoutId,int position){
		CommomViewHolder holder;
		if (converView==null) {
			holder=new CommomViewHolder(context, parent, layoutId, position);
		}else {
			holder=(CommomViewHolder) converView.getTag();
			holder.mPosition=position;
		}
		return holder;
	}
	
	@SuppressWarnings("unchecked")
	public <T extends View> T getView(int viewId){
		View view= mViews.get(viewId);
		if (view==null) {
			view=mConverView.findViewById(viewId);
			mViews.put(viewId, view);
		}
		return (T)view;
	}
	
	public View getConverView() {
		return mConverView;
	}
}
