package hu.bm.mobsoft.lab.costlog.ui.loing;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import javax.inject.Inject;

import hu.bm.mobsoft.lab.costlog.MobSoftApplication;
import hu.bm.mobsoft.lab.costlog.R;
import hu.bm.mobsoft.lab.costlog.ui.itemlist.ItemListActivity;

public class LoginActivity extends AppCompatActivity implements LoginScreen {
    @Inject
    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobSoftApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        loginPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        loginPresenter.detachScreen();
    }

//    @Override
//    public void showLoginFields() {
//        Toast.makeText(this, "Showing login screen", Toast.LENGTH_SHORT).show();
//    }

    @Override
    public void showMessage(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccess() {
        //TODO továbbnavigálás intenttel.
        Intent intent = new Intent(this, ItemListActivity.class);
        startActivity(intent);
        finish();

    }
}
