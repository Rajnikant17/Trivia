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
import appscrip.interview.project.R;
import appscrip.interview.project.utils.CustomSnackBar;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.bt_next)
    Button bt_next;
    @BindView(R.id.parentlayout)
    RelativeLayout parentlayout;
    FragmentManager fragmentManager;
    NameFragment nameFragment;
    FavPlayerFragment favPlayerFragment;
    FlagColorFragment flagColorFragment;
    Boolean checkEmptyData=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        fragmentManager=getSupportFragmentManager();
        nameFragment=new NameFragment();
        favPlayerFragment = new FavPlayerFragment();
        flagColorFragment = new FlagColorFragment();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container,nameFragment,"namefrag");
        fragmentTransaction.addToBackStack("namefrag");
        fragmentTransaction.commit();

        bt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment visibleFragment = getCurrentFragment();
                String tag = visibleFragment.getTag();
                //Execute if Fragment is NameFragment
                if (tag == "namefrag") {
                    if (nameFragment.callmethod(favPlayerFragment)) {
                        CustomSnackBar customSnackBar=new CustomSnackBar();
                         customSnackBar.customSnackbar(parentlayout,"Please provide name.",MainActivity.this);
                    } else {
                        FragmentTransaction fragmentTransaction1 = fragmentManager.beginTransaction();
                       // favPlayerFragment = new FavPlayerFragment();
                        fragmentTransaction1.replace(R.id.container, favPlayerFragment, "favplayerFrag");
                        fragmentTransaction1.addToBackStack("favplayerFrag");
                        fragmentTransaction1.commit();
                    }
                }

                //Execute if Fragment is Favourite player fragment
                else if (tag == "favplayerFrag") {

                    if (favPlayerFragment.callmethod(flagColorFragment)) {
                        CustomSnackBar customSnackBar=new CustomSnackBar();
                        customSnackBar.customSnackbar(parentlayout,"Please select your answer.",MainActivity.this);
                    }
                    else {
                        FragmentTransaction fragmentTransaction2 = fragmentManager.beginTransaction();
                       // flagColorFragment = new FlagColorFragment();
                        fragmentTransaction2.replace(R.id.container, flagColorFragment, "flagColorFrag");
                        fragmentTransaction2.addToBackStack("flagColorFrag");
                        fragmentTransaction2.commit(); }
                }

                //Execute if Fragment is Flag Colour fragment
                else {
                    if (flagColorFragment.callmethod()) {
                        CustomSnackBar customSnackBar=new CustomSnackBar();
                        customSnackBar.customSnackbar(parentlayout,"Please select your answer.",MainActivity.this);
                    }
                }
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
}
