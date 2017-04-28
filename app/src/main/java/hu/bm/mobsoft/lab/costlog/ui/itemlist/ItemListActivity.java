package hu.bm.mobsoft.lab.costlog.ui.itemlist;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import hu.bm.mobsoft.lab.costlog.MobSoftApplication;
import hu.bm.mobsoft.lab.costlog.R;
import hu.bm.mobsoft.lab.costlog.model.Item;

public class ItemListActivity extends AppCompatActivity implements  ItemListScreen {
    @Inject
    ItemListPresenter itemListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobSoftApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        itemListPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        itemListPresenter.detachScreen();
    }

    @Override
    public void showList() {
        Toast.makeText(this, "Show list of the items.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErrorMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void listItems(List<Item> items) {
        Toast.makeText(this, "Items are fetched successfully, and logged.", Toast.LENGTH_SHORT).show();
        for (Item i : items) {
            Log.d("listItems" , i.toString());
        }
    }
}
