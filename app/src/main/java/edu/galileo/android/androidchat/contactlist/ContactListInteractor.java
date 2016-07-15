package edu.galileo.android.androidchat.contactlist;

/**
 * Created by Usuario on 15/07/2016.
 */
public interface ContactListInteractor {
    void subscribe();
    void unsubscribe();
    void destroyListener();
    void removeContactList(String email);
}
