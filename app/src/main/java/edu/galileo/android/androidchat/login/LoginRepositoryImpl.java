package edu.galileo.android.androidchat.login;

import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import edu.galileo.android.androidchat.domain.FirebaseHelper;
import edu.galileo.android.androidchat.entities.User;
import edu.galileo.android.androidchat.lib.EventBus;
import edu.galileo.android.androidchat.lib.GreenRobotEventBus;
import edu.galileo.android.androidchat.login.events.LoginEvent;

/**
 * Created by kiryu on 1/07/16.
 */
public class LoginRepositoryImpl implements LoginRepository {
    private FirebaseHelper helper;
    //private DatabaseReference dataReference;
    private DatabaseReference myUserReference;

    public LoginRepositoryImpl() {
        this.helper = FirebaseHelper.getInstance();
        //this.dataReference = helper.getDataRefence();
        this.myUserReference = helper.getMyUserReference();
    }
    @Override
    public void signUp(String email, String password) {
        postEvent(LoginEvent.onSignUpSuccess);
    }

    @Override
    public void signIn(String email, String password) {
        try {
            FirebaseAuth auth = FirebaseAuth.getInstance();
            auth.signInWithEmailAndPassword(email, password)
                    .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            myUserReference = helper.getMyUserReference();
                            myUserReference.addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    User currentUser = dataSnapshot.getValue(User.class);

                                    if (currentUser == null) {
                                        String email = helper.getAuthUserEmail();
                                        if (email != null) {
                                            currentUser = new User();
                                            myUserReference.setValue(currentUser);
                                        }
                                    }
                                    helper.changeUserConnectionStatus(User.ONLINE);
                                    postEvent(LoginEvent.onSignInSuccess);
                                }
                                @Override
                                public void onCancelled(DatabaseError databaseError) {
                                    postEvent(LoginEvent.onSignInError, databaseError.getMessage());
                                }
                            });
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            postEvent(LoginEvent.onSignInError, e.getMessage());
                        }
                    });
        } catch (Exception e) {
            postEvent(LoginEvent.onSignInError, e.getMessage());
        }
    }

    @Override
    public void checkSession() {
        postEvent(LoginEvent.onFailedToRecoverSession);
    }

    private void postEvent(int type, String errorMessage){
        LoginEvent loginEvent = new LoginEvent();
        loginEvent.setEventType(type);
        if(errorMessage != null) {
            loginEvent.setErrorMessage(errorMessage);
        }

        EventBus eventBus = GreenRobotEventBus.getInstance();
        eventBus.post(loginEvent);
    }

    private void postEvent(int type){
        postEvent(type, null);
    }
}
