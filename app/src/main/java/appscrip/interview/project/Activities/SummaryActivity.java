package appscrip.interview.project.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import appscrip.interview.project.R;
import appscrip.interview.project.utils.ModelForHistory;
import butterknife.BindView;
import butterknife.ButterKnife;

public class SummaryActivity extends AppCompatActivity {
    @BindView(R.id.txt_name)
    TextView txt_name;
    @BindView(R.id.tv_bestplayer)
    TextView tv_bestplayer;
    @BindView(R.id.tv_flagcolor)
    TextView tv_flagcolor;
    @BindView(R.id.bt_finish)
    Button bt_finish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        ButterKnife.bind(this);
        Bundle bundle=getIntent().getExtras();
        txt_name.setText(bundle.getString("name"));
        tv_bestplayer.setText(bundle.getString("favplayer"));
        StringBuilder result = new StringBuilder();
        Log.d("ghdtjhdt",String.valueOf(bundle.getStringArrayList("flagcolors").size()));
        for(String string : bundle.getStringArrayList("flagcolors")) {
            result.append(string);
            result.append(",");
        }
        String Flagcolors = result.length() > 0 ? result.substring(0, result.length() - 1): "";
        tv_flagcolor.setText(Flagcolors);

        ModelForHistory modelForHistory=new ModelForHistory();
        modelForHistory.setName(txt_name.getText().toString());
        modelForHistory.setFavplayer(tv_bestplayer.getText().toString());
        modelForHistory.setFlagcolor(tv_flagcolor.getText().toString());
        Date currentTime = Calendar.getInstance().getTime();
        SimpleDateFormat dateStampFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm a");
        modelForHistory.setDate(dateStampFormat.format(currentTime));

        SharedPreferences sharedPreferences=getSharedPreferences("appscrip",Context.MODE_PRIVATE);
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

        //List<ModelForHistory>  modelForHistoryList=new ArrayList<>();
       // modelForHistoryList.add
        editor.putString("history",gson.toJson(modelForHistoryList));
        editor.apply();

        bt_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SummaryActivity.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
      /*  StringBuilder stringBuilder=new StringBuilder();
        for(int i=0;i<bundle.getStringArrayList("flagcolors").size();i++)
        {

        } */
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_history,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.history)
        {
            Intent intent=new Intent(SummaryActivity.this,HistoryActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
