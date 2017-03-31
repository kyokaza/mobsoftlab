package hu.bm.mobsoft.lab.costlog.ui.modifieitem;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import javax.inject.Inject;

import hu.bm.mobsoft.lab.costlog.MobSoftApplication;
import hu.bm.mobsoft.lab.costlog.R;

public class ModifieItemActivity extends AppCompatActivity implements ModifieItemScreen {
    @Inject
    ModifieItemPresenter modifieItemPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobSoftApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        modifieItemPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        modifieItemPresenter.detachScreen();
    }

    @Override
    public void showItemModificationDialog() {
        Toast.makeText(this, "Show the modification dialog.", Toast.LENGTH_SHORT).show();
    }
}
