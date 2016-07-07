package com.srba.szfdc.main.presenter;

import com.srba.szfdc.R;
import com.srba.szfdc.main.view.MainView;

/**
 * Description :
 * Author : zengwj
 */
public class MainPresenterImpl implements MainPresenter {

    private MainView mMainView;

    public MainPresenterImpl(MainView mainView) {
        this.mMainView = mainView;
    }

    @Override
    public void switchNavigation(int id) {
        switch (id) {
            case R.id.id_iconfont_chat:
            case R.id.id_chats_tv:
                mMainView.switch2HomePage();
                break;
            case R.id.id_iconfont_friend:
            case R.id.id_contacts_tv:
                mMainView.switch2Message();
                break;
            case R.id.id_iconfont_faxian:
            case R.id.id_discover_tv:
                mMainView.switch2Showings();
                break;
            case R.id.id_iconfont_me:
            case R.id.id_about_me_tv:
                mMainView.switch2About();
                break;
        }
    }
}
