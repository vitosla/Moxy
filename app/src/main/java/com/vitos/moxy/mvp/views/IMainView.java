package com.vitos.moxy.mvp.views;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.vitos.moxy.mvp.models.User;

import java.util.List;

/**
 * Created by Victor on 28.05.2017.
 */

@StateStrategyType(AddToEndSingleStrategy.class)
public interface IMainView extends MvpView {


}
