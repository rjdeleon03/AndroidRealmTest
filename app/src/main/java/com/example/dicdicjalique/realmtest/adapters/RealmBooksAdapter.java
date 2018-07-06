package com.example.dicdicjalique.realmtest.adapters;

import android.content.Context;

import com.example.dicdicjalique.realmtest.model.Book;

import io.realm.RealmResults;

public class RealmBooksAdapter extends RealmModelAdapter<Book> {

    public RealmBooksAdapter(Context context, RealmResults<Book> realmResults, boolean automaticUpdate) {
        super(context, realmResults, automaticUpdate);
    }
}
