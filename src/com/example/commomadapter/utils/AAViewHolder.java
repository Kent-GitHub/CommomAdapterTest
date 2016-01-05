package com.example.commomadapter.utils;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;

public class AAViewHolder<D>  extends ViewHolder{

	private View mConverView;
	
	public AAViewHolder(View view) {
		super(view);
		mConverView=view;
	}
	
	@SuppressWarnings("unchecked")
	public MyView<D>  getView(){
		return (MyView<D>) mConverView;
	}
	
}
