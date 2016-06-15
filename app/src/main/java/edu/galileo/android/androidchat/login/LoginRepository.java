package edu.galileo.android.androidchat.login;

/**
 * Created by kiryu on 16/06/16.
 */
public interface LoginRepository {
    void signUp(String email, String password);
    void signIn(String email, String password);
    void checkSession();
}
