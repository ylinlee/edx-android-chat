package edu.galileo.android.androidchat.login;

import android.util.Log;

import edu.galileo.android.androidchat.domain.FirebaseHelper;

/**
 * Created by kiryu on 1/07/16.
 */
public class LoginRepositoryImpl implements LoginRepository {
    private FirebaseHelper helper;

    public LoginRepositoryImpl() {
        this.helper = FirebaseHelper.getInstance();
    }
    @Override
    public void signUp(String email, String password) {
        Log.e("LoginRepositoryImpl", "signup");
    }

    @Override
    public void signIn(String email, String password) {
        Log.e("LoginRepositoryImpl", "signin");
    }

    @Override
    public void checkSession() {
        Log.e("LoginRepositoryImpl", "check session");
    }
}
