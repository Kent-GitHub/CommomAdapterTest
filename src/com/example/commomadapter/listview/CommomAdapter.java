package com.example.commomadapter.listview;

import java.util.List;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class CommomAdapter<T> extends BaseAdapter {
	protected Context mContext;
	protected List<T> mDatas;
	protected LayoutInflater mInflater;
	protected int mLayoutId;

	public CommomAdapter(Context context, List<T> datas, int layoutResource) {
		mContext = context;
		mInflater = LayoutInflater.from(mContext);
		mDatas = datas;
		mLayoutId = layoutResource;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mDatas.size();
	}

	@Override
	public T getItem(int arg0) {
		// TODO Auto-generated method stub
		return mDatas.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int position, View converView, ViewGroup parent) {
		CommomViewHolder holder = CommomViewHolder.getViewHolder(mContext,
				converView, parent, mLayoutId, position);
		setDatas(holder, getItem(position));
		return holder.getConverView();
	}

	public abstract void setDatas(CommomViewHolder holder, T t);

}
