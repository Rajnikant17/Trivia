package appscrip.interview.project.Model;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;

import java.util.ArrayList;
import java.util.List;

import appscrip.interview.project.Activities.SummaryActivity;

public class ModelForFlagColor {
    public Boolean callModel(Context context, Bundle bundle, CheckBox checkbox_white, CheckBox checkbox_yellow, CheckBox checkbox_orange, CheckBox checkbox_green)
    {
        if(checkbox_white.isChecked() || checkbox_yellow.isChecked() || checkbox_orange.isChecked() || checkbox_green.isChecked())
        {
           // bundle=cogetArguments();
            List<String> flagColorslist=new ArrayList<>();
            if (checkbox_white.isChecked())
            {
                flagColorslist.add(checkbox_white.getText().toString());
            }
            if (checkbox_yellow.isChecked())
            {
                flagColorslist.add(checkbox_yellow.getText().toString());
            }
            if(checkbox_orange.isChecked())
            {
                flagColorslist.add(checkbox_orange.getText().toString());
            }

            if(checkbox_green.isChecked())
            {
                flagColorslist.add(checkbox_green.getText().toString());

            }
            bundle.putStringArrayList("flagcolors", (ArrayList<String>) flagColorslist);
            Intent intent=new Intent(context, SummaryActivity.class);
            intent.putExtras(bundle);
            context.startActivity(intent);
            return false;
        }
        else {
            return true;
        }
    }
}
