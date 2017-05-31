package com.vitos.moxy.ui.activities;

import android.os.Bundle;
import android.widget.ListView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.vitos.moxy.R;
import com.vitos.moxy.mvp.presenters.MoxyPresenter;
import com.vitos.moxy.mvp.views.IMainView;
import com.vitos.moxy.ui.adapters.UserListAdapter;

public class MainActivity extends MvpAppCompatActivity implements IMainView{


    @InjectPresenter
    MoxyPresenter mMoxyPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set ListView
        ListView listView = (ListView) findViewById(R.id.lview);
        UserListAdapter listAdapter = new UserListAdapter(getMvpDelegate());
        listAdapter.setOnListItemClickListener(this);
        listView.setAdapter(listAdapter);
    }

    @Override
    public void onListItemClick(String id) {
        mMoxyPresenter.showItemDetails(id);
    }
}
