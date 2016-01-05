package com.example.commomadapter.utils;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import android.content.Context;
import android.view.ViewGroup;

@EBean
public class PersonAdapter extends RecyclerViewAdapterBase<Person, PersonItemView> {

    @RootContext
    Context context;

    @Override
    protected PersonItemView onCreateItemView(ViewGroup parent, int viewType) {
        return PersonItemView_.build(context);
    }

    @Override
    public void onBindViewHolder(ViewWrapper<PersonItemView> viewHolder, int position) {
        PersonItemView view = viewHolder.getView();
        Person person = items.get(position);

        view.bind(person);
    }
    
}