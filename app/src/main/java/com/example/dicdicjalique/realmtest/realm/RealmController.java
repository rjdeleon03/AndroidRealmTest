package com.example.dicdicjalique.realmtest.realm;

import android.app.Application;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.example.dicdicjalique.realmtest.model.Book;

import io.realm.Realm;
import io.realm.RealmResults;

public class RealmController {

    private static RealmController instance;
    private final Realm realm;

    public RealmController(Application application) {
        realm = Realm.getDefaultInstance();
    }

    public static RealmController with(Fragment fragment) {
        if (instance == null) {
            instance = new RealmController(fragment.getActivity().getApplication());
        }
        return instance;
    }

    public static RealmController with(AppCompatActivity activity) {
        if (instance == null) {
            instance = new RealmController(activity.getApplication());
        }
        return instance;
    }

    public static RealmController with(Application application) {
        if (instance == null) {
            instance = new RealmController(application);
        }
        return instance;
    }

    public static RealmController getInstance() {
        return instance;
    }

    public Realm getRealm() {
        return realm;
    }

    // Refresh realm isntance
    public void refresh() {
        realm.refresh();
    }

    // Clear all objects from Book.class
    public void clearAll() {
        realm.beginTransaction();
        realm.deleteAll(); //realm.clear(Book.class)
        realm.commitTransaction();
    }

    // Find all objects in the Book.class
    public RealmResults<Book> getBooks() {
        return realm.where(Book.class).findAll();
    }

    // Query single item with given id
    public Book getBook(String id) {
        return realm.where(Book.class).equalTo("id", id).findFirst();
    }

    // Check if Book.class is empty
    public boolean hasBooks() {
        return !getBooks().isEmpty();
    }

    // Sample query
    public RealmResults<Book> queryedBooks() {
        return realm.where(Book.class)
                .contains("author", "Author 0")
                .or()
                .contains("title", "Realm")
                .findAll();
    }
}
