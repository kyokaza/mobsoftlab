package hu.bm.mobsoft.lab.costlog.ui.statistic;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import javax.inject.Inject;

import hu.bm.mobsoft.lab.costlog.MobSoftApplication;
import hu.bm.mobsoft.lab.costlog.R;

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

    @Override
    public void showStatistic() {
        Toast.makeText(this, "Showing statistic of current month.", Toast.LENGTH_SHORT).show();
    }
}
