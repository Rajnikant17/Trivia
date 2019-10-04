package appscrip.interview.project.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import appscrip.interview.project.Fragment.FavPlayerFragment;
import appscrip.interview.project.Fragment.FlagColorFragment;
import appscrip.interview.project.Fragment.NameFragment;
import appscrip.interview.project.Presenter.PresenterForHomepage;
import appscrip.interview.project.R;
import appscrip.interview.project.utils.CustomSnackBar;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements PresenterForHomepage.CallCustomSnackbar {
    @BindView(R.id.bt_next)
    Button bt_next;
    @BindView(R.id.parentlayout)
    RelativeLayout parentlayout;
    FragmentManager fragmentManager;
    NameFragment nameFragment;
    FavPlayerFragment favPlayerFragment;
    FlagColorFragment flagColorFragment;
    Boolean checkEmptyData=false;
    public static MainActivity mainActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mainActivity=MainActivity.this;
        fragmentManager=getSupportFragmentManager();
        nameFragment=new NameFragment();
        favPlayerFragment = new FavPlayerFragment();
        flagColorFragment = new FlagColorFragment();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container,nameFragment,"namefrag");
        fragmentTransaction.addToBackStack("namefrag");
        fragmentTransaction.commit();
        PresenterForHomepage presenterForHomepage=new PresenterForHomepage();
        bt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                presenterForHomepage.callPresenter(fragmentManager,MainActivity.this,nameFragment,favPlayerFragment,flagColorFragment);
            }
        });
    }
    Fragment getCurrentFragment()
    {
        Fragment currentFragment = getSupportFragmentManager()
                .findFragmentById(R.id.container);
        return currentFragment;
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
          Intent intent=new Intent(MainActivity.this,HistoryActivity.class);
          startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if(fragmentManager.getBackStackEntryCount()==1)
        {
          finishAffinity();
        }
        else {
            super.onBackPressed();
        }
    }

    @Override
    public void callCustomSnackbar(String msg) {
        CustomSnackBar customSnackBar=new CustomSnackBar();
         customSnackBar.customSnackbar(parentlayout,msg, MainActivity.this);

    }
}
