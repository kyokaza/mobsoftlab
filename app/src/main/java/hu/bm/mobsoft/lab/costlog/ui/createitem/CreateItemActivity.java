package hu.bm.mobsoft.lab.costlog.ui.createitem;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import javax.inject.Inject;

import hu.bm.mobsoft.lab.costlog.MobSoftApplication;
import hu.bm.mobsoft.lab.costlog.R;

public class CreateItemActivity  extends AppCompatActivity implements CreateItemScreen{
    @Inject
    CreateItemPresenter createItemPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobSoftApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        createItemPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        createItemPresenter.detachScreen();
    }

    @Override
    public void showItemCreationDialog() {
        Toast.makeText(this, "Show the dialog of item adition.", Toast.LENGTH_SHORT).show();
    }
}
