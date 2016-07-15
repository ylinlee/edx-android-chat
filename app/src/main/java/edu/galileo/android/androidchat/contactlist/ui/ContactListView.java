package edu.galileo.android.androidchat.contactlist.ui;

import edu.galileo.android.androidchat.entities.User;

/**
 * Created by Usuario on 15/07/2016.
 */
public interface ContactListView {
    void onContactAdded(User user);
    void onContactChanged(User user);
    void onContactRemoved(User user);
}
