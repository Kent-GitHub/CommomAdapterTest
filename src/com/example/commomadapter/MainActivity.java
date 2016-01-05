package com.example.commomadapter;

import com.example.commomadaptertest.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;


public class MainActivity extends Activity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

	private void init() {
		findViewById(R.id.btn_feature).setOnClickListener(this);
		findViewById(R.id.btn_recycler_view).setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		Intent i=null;
		switch (arg0.getId()) {
		case R.id.btn_feature:
			i=new Intent(MainActivity.this,FeatureActivity.class);
			break;

		case R.id.btn_recycler_view:
			i=new Intent(MainActivity.this,RecyclerViewActivity_.class);
			break;
		}
		if (i!=null) {
			startActivity(i);
		}
	}


}
