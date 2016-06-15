package edu.galileo.android.androidchat.login;

/**
 * Created by kiryu on 16/06/16.
 */
public interface LoginInteractor {
    void checkSession();
    void doSignUp(String email, String  password);
    void doSignIn(String email, String  password);
}
