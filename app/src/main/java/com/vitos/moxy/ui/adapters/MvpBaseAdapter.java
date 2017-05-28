package com.vitos.moxy.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.BaseAdapter;

import com.arellomobile.mvp.MvpDelegate;

/**
 * Created by Victor on 28.05.2017.
 */

public abstract class MvpBaseAdapter extends BaseAdapter{
    private MvpDelegate<? extends MvpBaseAdapter> mMvpDelegate;
    private MvpDelegate<?> mParentDelegate;
    private String mChildId;

    public MvpBaseAdapter(MvpDelegate<?> parentDelegate, String childId) {
        mParentDelegate = parentDelegate;
        mChildId = childId;

        getMvpDelegate().onCreate();
    }

    public MvpDelegate getMvpDelegate() {
        if (mMvpDelegate == null) {
            mMvpDelegate = new MvpDelegate<>(this);
            mMvpDelegate.setParentDelegate(mParentDelegate, mChildId);

        }
        return mMvpDelegate;
    }
}
