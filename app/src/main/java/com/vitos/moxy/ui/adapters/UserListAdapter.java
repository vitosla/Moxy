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
import com.squareup.picasso.Picasso;
import com.vitos.moxy.MoxyApp;
import com.vitos.moxy.R;
import com.vitos.moxy.mvp.models.User;
import com.vitos.moxy.mvp.presenters.UserListPresenter;
import com.vitos.moxy.mvp.views.IUserListView;
import com.vitos.moxy.tools.CircleTransform;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Victor on 28.05.2017.
 */

public class UserListAdapter extends MvpBaseAdapter implements IUserListView{

    public static final int REPOSITORY_VIEW_TYPE = 0;
    private static final int PROGRESS_VIEW_TYPE = 1;

    Context mAppContext;

    @InjectPresenter(type = PresenterType.WEAK, tag = UserListPresenter.TAG )
    UserListPresenter mUserListPresenter;

    List<User> mUsers;

    public UserListAdapter(MvpDelegate<?> parentDelegate, OnScrollToBottomListener scrollToBottomListener) {
        super(parentDelegate, String.valueOf(0));
        mAppContext = MoxyApp.getAppComponent().getContext();
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
    public int getItemViewType(int position) {
        return position == mUsers.size() ? PROGRESS_VIEW_TYPE : REPOSITORY_VIEW_TYPE;
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

        Picasso.with(mAppContext)
                .load(getItem(position).getThumb())
                .centerCrop()
                .transform(new CircleTransform())
                .error(R.drawable.detect)
                .fit()
                .into(viewHolder.mImage);

        viewHolder.mId.setText(getItem(position).getId());
        viewHolder.mProvider.setText(getItem(position).getProvider());
        viewHolder.mEmail.setText(getItem(position).getEmail());

        return convertView;
    }

    @Override
    public void onLoadUsersData(List<User> users) {
        mUsers = users;
        notifyDataSetInvalidated();
    }

    public class ViewHolder{

        ImageView mImage;
        TextView mId;
        TextView mProvider;
        TextView mEmail;

        public ViewHolder(View view) {
            mImage = (ImageView) view.findViewById(R.id.iv_image);
            mId = (TextView) view.findViewById(R.id.tv_id);
            mProvider = (TextView) view.findViewById(R.id.tv_provider);
            mEmail = (TextView) view.findViewById(R.id.tv_email);
        }

//        MvpDelegate getMvpDelegate() {
//            if (mRepository == null) {
//                return null;
//            }
//
//            if (mMvpDelegate == null) {
//                mMvpDelegate = new MvpDelegate<>(this);
//                mMvpDelegate.setParentDelegate(UserListAdapter.this.getMvpDelegate(), String.valueOf(mRepository.getId()));
//
//            }
//            return mMvpDelegate;
//        }
    }

    public interface OnScrollToBottomListener {
        void onScrollToBottom();
    }

}
