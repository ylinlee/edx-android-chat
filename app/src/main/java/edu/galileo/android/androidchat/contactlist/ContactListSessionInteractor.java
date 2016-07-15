package edu.galileo.android.androidchat.contactlist;

/**
 * Created by Usuario on 15/07/2016.
 */
public interface ContactListSessionInteractor {
    void signOff();
    String getCurrentUserEmail();
    void changeConnectionStatus(boolean online);
}
