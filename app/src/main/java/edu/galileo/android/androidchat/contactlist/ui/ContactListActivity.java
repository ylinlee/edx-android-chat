package edu.galileo.android.androidchat.contactlist.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.galileo.android.androidchat.R;
import edu.galileo.android.androidchat.contactlist.ContactListPresenter;
import edu.galileo.android.androidchat.contactlist.ui.adapter.ContactListAdapter;
import edu.galileo.android.androidchat.contactlist.ui.adapter.OnItemClickListener;
import edu.galileo.android.androidchat.entities.User;
import edu.galileo.android.androidchat.lib.GlideImageLoader;
import edu.galileo.android.androidchat.lib.ImageLoader;

public class ContactListActivity extends AppCompatActivity implements ContactListView, OnItemClickListener {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.recycleViewContatcts)
    RecyclerView recycleViewContatcts;
    @Bind(R.id.fab)
    FloatingActionButton fab;

    private ContactListAdapter adapter;
    private ContactListPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contat_list);
        ButterKnife.bind(this);

        setupAdapter();
        setupRecyclerView();
        //presenter.onCreate();
        setupToolBar();
    }

    private void setupRecyclerView() {
        recycleViewContatcts.setLayoutManager(new LinearLayoutManager(this));
        recycleViewContatcts.setAdapter(adapter);
    }

    private void setupAdapter() {
        ImageLoader loader = new GlideImageLoader(this.getApplicationContext());
        User user = new User();
        user.setOnline(false);
        user.setEmail("android@chat.es");
        adapter = new ContactListAdapter(Arrays.asList(new User[]{user}), loader, this);
        //adapter = new ContactListAdapter(new ArrayList<User>(), loader, this);
    }

    private void setupToolBar() {
        //toolbar.setTitle(presenter.getCurrentUserEmail());
        setSupportActionBar(toolbar);
    }
/*
    @Override
    public void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onResume() {
        presenter.onResume();
        super.onResume();
    }

    @Override
    protected void onPause() {
        presenter.onPause();
        super.onPause();
    }
*/
    @OnClick(R.id.fab)
    public void addContact() {

    }

    @Override
    public void onContactAdded(User user) {

    }

    @Override
    public void onContactChanged(User user) {

    }

    @Override
    public void onContactRemoved(User user) {

    }

    @Override
    public void onItemClick(User user) {

    }

    @Override
    public void onItemLongClick(User user) {

    }
}
