package appscrip.interview.project.Model;

import android.content.Context;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import appscrip.interview.project.Activities.MainActivity;
import appscrip.interview.project.Fragment.FavPlayerFragment;
import appscrip.interview.project.Fragment.FlagColorFragment;
import appscrip.interview.project.Fragment.NameFragment;
import appscrip.interview.project.Presenter.PresenterForHomepage;
import appscrip.interview.project.R;
import appscrip.interview.project.utils.CustomSnackBar;

public class ModelForHomePage  {
    FragmentManager fragmentManager;
    public void callModel(PresenterForHomepage presenterForHomepage, FragmentManager fragmentManager, NameFragment nameFragment, FavPlayerFragment favPlayerFragment, FlagColorFragment flagColorFragment)
    {
        this.fragmentManager=fragmentManager;
        Fragment visibleFragment = getCurrentFragment();
        String tag = visibleFragment.getTag();
        //Execute if Fragment is NameFragment
        if (tag == "namefrag") {
            if (nameFragment.callmethod(favPlayerFragment)) {
                presenterForHomepage.modelForCustomSnackbar("Please provide name.");
            } else {
                FragmentTransaction fragmentTransaction1 = fragmentManager.beginTransaction();
                fragmentTransaction1.replace(R.id.container, favPlayerFragment, "favplayerFrag");
                fragmentTransaction1.addToBackStack("favplayerFrag");
                fragmentTransaction1.commit();
            }
        }

        //Execute if Fragment is Favourite player fragment
        else if (tag == "favplayerFrag") {

            if (favPlayerFragment.callmethod(flagColorFragment)) {
                presenterForHomepage.modelForCustomSnackbar("Please select your answer.");
            }
            else {
                FragmentTransaction fragmentTransaction2 = fragmentManager.beginTransaction();
                fragmentTransaction2.replace(R.id.container, flagColorFragment, "flagColorFrag");
                fragmentTransaction2.addToBackStack("flagColorFrag");
                fragmentTransaction2.commit(); }
        }

        //Execute if Fragment is Flag Colour fragment
        else {
            if (flagColorFragment.callmethod()) {
                presenterForHomepage.modelForCustomSnackbar("Please select your answer.");

            }
        }
    }

    Fragment getCurrentFragment()
    {
        Fragment currentFragment = fragmentManager
                .findFragmentById(R.id.container);
        return currentFragment;
    }

    public interface ModelForCustomSnackbar
    {
       public void  modelForCustomSnackbar(String msg);
    }
}
