package com.vitos.moxy.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.vitos.moxy.R;
import com.vitos.moxy.mvp.models.User;
import com.vitos.moxy.mvp.presenters.MoxyPresenter;
import com.vitos.moxy.mvp.views.IMainView;
import com.vitos.moxy.ui.adapters.UserListAdapter;

import java.util.List;

public class MainActivity extends MvpAppCompatActivity implements IMainView, UserListAdapter.OnScrollToBottomListener{

    @InjectPresenter
    MoxyPresenter mMoxyPresenter;

    @InjectPresenter
    MoxyPresenter mUserListPresenter;

    private ListView mListView;
    private UserListAdapter mListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
   //     mMoxyPresenter.empty();
        mListView = (ListView) findViewById(R.id.lview);
        mListAdapter = new UserListAdapter(getMvpDelegate(), this);
        mListView.setAdapter(mListAdapter);
    }

    @Override
    public void onScrollToBottom() {

    }

    @Override
    public void onMoxyItemClick() {
        int uu=0;
        uu++;
    }
}
