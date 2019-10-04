package appscrip.interview.project.Model;

import android.os.Bundle;
import android.widget.RadioButton;

import androidx.fragment.app.Fragment;

public class ModelForfavPlayer {
    public Boolean callmodel(Bundle bundle,Fragment fragment, RadioButton radio_Sachin, RadioButton radio_virat, RadioButton radio_adam, RadioButton radio_jacques)
    {
        if(radio_Sachin.isChecked() || radio_virat.isChecked() || radio_adam.isChecked() || radio_jacques.isChecked())
        {
            //bundle=getArguments();
            if (radio_Sachin.isChecked())
            {
                bundle.putString("favplayer", radio_Sachin.getText().toString());
            }
            else if (radio_virat.isChecked())
            {
                bundle.putString("favplayer", radio_virat.getText().toString());
            }
            else if(radio_adam.isChecked())
            {
                bundle.putString("favplayer", radio_adam.getText().toString());
            }
            else
            {
                bundle.putString("favplayer", radio_jacques.getText().toString());

            }
            fragment.setArguments(bundle);
            return false;
        }
        else {
            return true;
        }
    }
}
