package appscrip.interview.project.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import appscrip.interview.project.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class NameFragment extends Fragment {
    @BindView(R.id.edit_nam)
    EditText edit_nam;
    Bundle bundle;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.name_frag,container,false);
        ButterKnife.bind(this,view);
        bundle=new Bundle();
       // edit_name.getText();
        return view;
    }

    public Boolean callmethod(Fragment fragment)
    {
      if(edit_nam.getText().toString().isEmpty())
      {
        return true;
      }
      else {
          bundle.putString("name", edit_nam.getText().toString());
          fragment.setArguments(bundle);
          return false;
      }
    }
   // public


}
