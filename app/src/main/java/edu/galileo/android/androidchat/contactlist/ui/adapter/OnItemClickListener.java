package edu.galileo.android.androidchat.contactlist.ui.adapter;

import edu.galileo.android.androidchat.entities.User;

/**
 * Created by Usuario on 15/07/2016.
 */
public interface OnItemClickListener {
    void onItemClick(User user);
    void onItemLongClick(User user);
}
