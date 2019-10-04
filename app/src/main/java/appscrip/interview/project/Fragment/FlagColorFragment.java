package appscrip.interview.project.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import appscrip.interview.project.Activities.SummaryActivity;
import appscrip.interview.project.Presenter.PresenterForFlagColor;
import appscrip.interview.project.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class FlagColorFragment extends Fragment {
    @BindView(R.id.checkbox_white)
    CheckBox checkbox_white;
    @BindView(R.id.checkbox_yellow)
    CheckBox checkbox_yellow;
    @BindView(R.id.checkbox_orange)
    CheckBox checkbox_orange;
    @BindView(R.id.checkbox_green)
    CheckBox checkbox_green;
    Bundle bundle;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.flagcolor_frag,container,false);
        ButterKnife.bind(this,view);
        bundle=getArguments();
        return view;
    }

    public  Boolean  callmethod()
    {
        PresenterForFlagColor presenterForFlagColor=new PresenterForFlagColor();
        return presenterForFlagColor.callPresenter(getActivity(),bundle,checkbox_white, checkbox_yellow,checkbox_orange,checkbox_green);


    }
}
