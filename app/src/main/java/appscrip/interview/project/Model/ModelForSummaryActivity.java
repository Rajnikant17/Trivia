package appscrip.interview.project.Model;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import appscrip.interview.project.utils.ModelForHistory;

public class ModelForSummaryActivity {

    public void callModel(AppCompatActivity appCompatActivity, Bundle bundle, String txt_name, String tv_bestplayer, String tv_flagcolor)
    {


        ModelForHistory modelForHistory=new ModelForHistory();
        modelForHistory.setName(txt_name);
        modelForHistory.setFavplayer(tv_bestplayer);
        modelForHistory.setFlagcolor(tv_flagcolor);
        Date currentTime = Calendar.getInstance().getTime();
        SimpleDateFormat dateStampFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm a");
        modelForHistory.setDate(dateStampFormat.format(currentTime));

        SharedPreferences sharedPreferences=appCompatActivity.getSharedPreferences("appscrip", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        Type type=new TypeToken<List<ModelForHistory>>(){}.getType();
        Gson gson=new Gson();
        List<ModelForHistory> modelForHistoryList = gson.fromJson(sharedPreferences.getString("history", null), type);
        if(modelForHistoryList==null)
        {
            modelForHistoryList =new ArrayList<>();
            modelForHistoryList.add(modelForHistory);
        }

        else
        {
            modelForHistoryList.add(modelForHistory);
        }

        editor.putString("history",gson.toJson(modelForHistoryList));
        editor.apply();

    }
}
