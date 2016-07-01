package edu.galileo.android.androidchat.login;

import edu.galileo.android.androidchat.login.events.LoginEvent;

/**
 * Created by kiryu on 16/06/16.
 */
public interface LoginPresenter {
    void onCreate();
    void onDestroy();
    void checkForAuthenticatedUser();
    void validateLogin(String email, String password);
    void registerNewUser(String email, String password);
    void onEventMainThread(LoginEvent event);
}
