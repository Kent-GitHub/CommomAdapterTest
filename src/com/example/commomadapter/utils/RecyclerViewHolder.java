package com.example.commomadapter.utils;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;

public class RecyclerViewHolder extends ViewHolder{
	private SparseArray<View> mViews;
	private View mConverView;
	
	public RecyclerViewHolder(View view) {
		super(view);
		mViews=new SparseArray<View>();
		mConverView=view;
	}
	
	/**
	 * 由id获得对应控件
	 * @param viewId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T extends View> T getView(int viewId){
		if (mViews==null) {
			return null;
		}
		View view= mViews.get(viewId);
		if (view==null) {
			view=mConverView.findViewById(viewId);
			mViews.put(viewId, view);
		}
		return (T)view;
	}
	
}
