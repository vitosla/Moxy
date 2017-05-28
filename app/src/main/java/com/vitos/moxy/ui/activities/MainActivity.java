package com.vitos.moxy.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.vitos.moxy.R;
import com.vitos.moxy.mvp.models.User;
import com.vitos.moxy.mvp.presenters.MoxyPresenter;
import com.vitos.moxy.mvp.views.IMainView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IMainView{

    @InjectPresenter
    MoxyPresenter mMoxyPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}
