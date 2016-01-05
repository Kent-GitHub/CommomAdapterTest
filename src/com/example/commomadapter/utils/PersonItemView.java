package com.example.commomadapter.utils;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import com.example.commomadaptertest.R;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

@EViewGroup(R.layout.person_item)
public class PersonItemView extends LinearLayout {

    @ViewById
    TextView firstNameView;

    @ViewById
    TextView lastNameView;

    public PersonItemView(Context context) {
        super(context);
    }

    public void bind(Person person) {
        firstNameView.setText(person.firstName);
        lastNameView.setText(person.lastName);
    }
}