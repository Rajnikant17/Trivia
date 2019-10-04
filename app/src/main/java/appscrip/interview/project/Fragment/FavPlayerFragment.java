package appscrip.interview.project.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import appscrip.interview.project.Presenter.PresenterForFavPlayer;
import appscrip.interview.project.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class FavPlayerFragment extends Fragment {
    @BindView(R.id.radio_Sachin)
    RadioButton  radio_Sachin;
    @BindView(R.id.radio_virat)
    RadioButton  radio_virat;
    @BindView(R.id.radio_adam)
    RadioButton  radio_adam;
    @BindView(R.id.radio_jacques)
    RadioButton  radio_jacques;
    @BindView(R.id.radiogroup)
    RadioGroup radiogroup;
    Bundle bundle;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.favplayer_frag,container,false);
        ButterKnife.bind(this,view);
        bundle=getArguments();
        return view;
    }

    public Boolean callmethod(Fragment fragment)
    {
        PresenterForFavPlayer presenterForFavPlayer = new PresenterForFavPlayer();
       return presenterForFavPlayer.callPresenter(bundle,fragment, radio_Sachin, radio_virat,radio_adam,radio_jacques);

    }
}
