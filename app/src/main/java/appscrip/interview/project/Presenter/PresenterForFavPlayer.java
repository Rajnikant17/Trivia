package appscrip.interview.project.Presenter;

import android.os.Bundle;
import android.widget.RadioButton;

import androidx.fragment.app.Fragment;

import appscrip.interview.project.Model.ModelForfavPlayer;

public class PresenterForFavPlayer {
    public Boolean callPresenter(Bundle bundle,Fragment fragment, RadioButton radio_Sachin, RadioButton radio_virat, RadioButton radio_adam, RadioButton radio_jacques)
    {
        ModelForfavPlayer modelForfavPlayer=new ModelForfavPlayer();
        return modelForfavPlayer.callmodel(bundle,fragment, radio_Sachin, radio_virat,radio_adam,radio_jacques);
    }

}
