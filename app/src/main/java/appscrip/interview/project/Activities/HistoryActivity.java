package appscrip.interview.project.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import appscrip.interview.project.Adapter.AdapterHistory;
import appscrip.interview.project.R;
import appscrip.interview.project.utils.ModelForHistory;
import butterknife.BindView;
import butterknife.ButterKnife;

public class HistoryActivity extends AppCompatActivity {
    @BindView(R.id.image_for_null_list)
    ImageView imageView;
    @BindView(R.id.rv_history)
    RecyclerView rv_history;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        ButterKnife.bind(this);
        SharedPreferences sharedPreferences=getSharedPreferences("appscrip",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        Type type=new TypeToken<List<ModelForHistory>>(){}.getType();
        Gson gson=new Gson();
        List<ModelForHistory> modelForHistoryList = gson.fromJson(sharedPreferences.getString("history", null), type);
        if(modelForHistoryList==null)
        {
            imageView.setVisibility(View.VISIBLE);
        }
        else
        {
            imageView.setVisibility(View.GONE);
            LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
            AdapterHistory adapterHistory=new AdapterHistory(this,modelForHistoryList);
            rv_history.setLayoutManager(linearLayoutManager);
            rv_history.setAdapter(adapterHistory);
        }

    }
}
