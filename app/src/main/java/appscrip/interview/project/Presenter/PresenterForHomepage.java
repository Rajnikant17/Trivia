package appscrip.interview.project.Presenter;

import android.content.Context;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import appscrip.interview.project.Activities.MainActivity;
import appscrip.interview.project.Fragment.FavPlayerFragment;
import appscrip.interview.project.Fragment.FlagColorFragment;
import appscrip.interview.project.Fragment.NameFragment;
import appscrip.interview.project.Model.ModelForHomePage;

public class PresenterForHomepage implements ModelForHomePage.ModelForCustomSnackbar {
    public void callPresenter(FragmentManager fragmentManager, Context appCompatActivity, NameFragment nameFragment, FavPlayerFragment favPlayerFragment, FlagColorFragment flagColorFragment)
    {   PresenterForHomepage presenterForHomepage=new PresenterForHomepage();
        ModelForHomePage modelForHomePage=new ModelForHomePage();
        modelForHomePage.callModel(presenterForHomepage,fragmentManager,nameFragment,favPlayerFragment,flagColorFragment);
    }

    @Override
    public void modelForCustomSnackbar(String msg) {
        CallCustomSnackbar callCustomSnackbar=(MainActivity)MainActivity.mainActivity;
        callCustomSnackbar.callCustomSnackbar(msg);
    }

    public interface  CallCustomSnackbar
    {
       public  void callCustomSnackbar(String msg);
    }
}

