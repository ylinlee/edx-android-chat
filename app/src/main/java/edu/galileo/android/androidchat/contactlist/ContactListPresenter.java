package edu.galileo.android.androidchat.contactlist;

import edu.galileo.android.androidchat.contactlist.events.ContactListEvent;

/**
 * Created by Usuario on 15/07/2016.
 */
public interface ContactListPresenter {
    void onPause();
    void onResume();
    void onCreate();
    void onDestroy();

    void signOff();
    String getCurrentUserEmail();
    void removeContact(String email);
    void onEventMainThread(ContactListEvent event);
}
