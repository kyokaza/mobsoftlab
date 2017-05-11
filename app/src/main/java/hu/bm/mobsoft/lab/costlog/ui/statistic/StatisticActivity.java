package hu.bm.mobsoft.lab.costlog.ui.statistic;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import hu.bm.mobsoft.lab.costlog.MobSoftApplication;
import hu.bm.mobsoft.lab.costlog.R;
import hu.bm.mobsoft.lab.costlog.model.Item;

public class StatisticActivity extends AppCompatActivity implements StatisticScreen{
    @Inject
    StatisticPresenter statisticPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobSoftApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        statisticPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        statisticPresenter.detachScreen();
    }

//    @Override
//    public void showStatistic() {
//        Toast.makeText(this, "Showing statistic of current month.", Toast.LENGTH_SHORT).show();
//    }

    @Override
    public void showStatistic(List<Item> items) {
        //TODO leszámolni a statisztika alapján az egyes értékeket. itt kell plotolni majd.
        Toast.makeText(this, "Items are fetched successfully, and logged.", Toast.LENGTH_SHORT).show();
        for (Item i : items) {
            Log.d("listItems" , i.toString());
        }
    }

    @Override
    public void showErrorMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
