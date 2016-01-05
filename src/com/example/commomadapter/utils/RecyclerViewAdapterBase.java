package com.example.commomadapter.utils;

import java.util.ArrayList;
import java.util.List;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public  abstract  class RecyclerViewAdapterBase<T, V extends View>  extends RecyclerView.Adapter<ViewWrapper<V>>{
	protected List<T> items = new ArrayList<T>();
	@Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public final ViewWrapper<V> onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewWrapper<V>(onCreateItemView(parent, viewType));
    }

    protected abstract V onCreateItemView(ViewGroup parent, int viewType);
 // additional methods to manipulate the items

//	@Override
//	public void onBindViewHolder(ViewWrapper<V> arg0, int arg1) {
//		// TODO Auto-generated method stub
//		
//	}


}
