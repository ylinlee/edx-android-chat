package edu.galileo.android.androidchat.login;

/**
 * Created by kiryu on 16/06/16.
 */
public interface LoginPresenter {
    void onDestroy();
    void checkForAuthenticatedUser();
    void validateLogin(String email, String password);
    void registerNewUser(String email, String password);
}
