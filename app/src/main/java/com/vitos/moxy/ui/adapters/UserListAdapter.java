package com.vitos.moxy.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.arellomobile.mvp.MvpDelegate;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.PresenterType;
import com.vitos.moxy.R;
import com.vitos.moxy.mvp.models.User;
import com.vitos.moxy.mvp.presenters.UserListPresenter;
import com.vitos.moxy.mvp.views.IUserListView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Victor on 28.05.2017.
 */

public class UserListAdapter extends MvpBaseAdapter implements IUserListView{

    @Inject Context mAppContext;

    @InjectPresenter(type = PresenterType.WEAK, tag = UserListPresenter.TAG )
    UserListPresenter mUserListPresenter;

    List<User> mUsers;

    public UserListAdapter(MvpDelegate<?> parentDelegate, String childId) {
        super(parentDelegate, childId);
        mUsers = new ArrayList<>();
        mUserListPresenter.loadUsersData();
    }

    @Override
    public int getCount() {
        return mUsers.size();
    }

    @Override
    public User getItem(int position) {
        return mUsers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) mAppContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.mName.setText(getItem(position).getId());

        return convertView;
    }

    @Override
    public void onLoadUsersData(List<User> users) {
        mUsers = users;

    }

    static class ViewHolder{

        ImageView mImage;
        TextView mName;
        TextView mDate;
        TextView mCompatibility;

        public ViewHolder(View view) {
            mImage = (ImageView) view.findViewById(R.id.iv_image);
            mName = (TextView) view.findViewById(R.id.tv_item_name);
            mDate = (TextView) view.findViewById(R.id.tv_item_date);
            mCompatibility = (TextView) view.findViewById(R.id.tv_item_compatibility);
        }
    }

}
