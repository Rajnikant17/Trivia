package appscrip.interview.project.Presenter;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import appscrip.interview.project.Model.ModelForSummaryActivity;

public class PresenterForSummaryActivity {

    public void callPresenter(AppCompatActivity appCompatActivity, Bundle bundle, String txt_name, String tv_bestplayer, String tv_flagcolor)
    {
        ModelForSummaryActivity modelForSummaryActivity=new ModelForSummaryActivity();
        modelForSummaryActivity.callModel(appCompatActivity,bundle,txt_name,tv_bestplayer,tv_flagcolor);
    }
}
