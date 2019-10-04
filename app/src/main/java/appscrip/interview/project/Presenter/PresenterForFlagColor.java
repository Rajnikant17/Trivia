package appscrip.interview.project.Presenter;

import android.content.Context;
import android.os.Bundle;
import android.widget.CheckBox;

import appscrip.interview.project.Model.ModelForFlagColor;

public class PresenterForFlagColor {
    public Boolean callPresenter(Context context, Bundle bundle, CheckBox checkbox_white,CheckBox checkbox_yellow,CheckBox checkbox_orange,CheckBox checkbox_green)
    {
        ModelForFlagColor modelForFlagColor=new ModelForFlagColor();
       return modelForFlagColor.callModel(context,bundle,checkbox_white, checkbox_yellow,checkbox_orange,checkbox_green);
    }
}
