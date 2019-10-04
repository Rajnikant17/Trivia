package appscrip.interview.project.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import appscrip.interview.project.R;
import appscrip.interview.project.utils.ModelForHistory;

public class AdapterHistory extends RecyclerView.Adapter<AdapterHistory.MyHandler> {
    List<ModelForHistory>  modelForHistoryList;
    Context context;
    public AdapterHistory(Context context, List<ModelForHistory>  modelForHistoryList) {
        this.context=context;
        this.modelForHistoryList = modelForHistoryList;

    }

    @NonNull
    @Override
    public MyHandler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.adapter_history, parent, false);
        MyHandler myHandler = new MyHandler(view);
        return myHandler;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHandler holder, int position) {
        holder.tv_date.setText(modelForHistoryList.get((modelForHistoryList.size()-1)-position).getDate());
        holder.txt_name.setText(modelForHistoryList.get((modelForHistoryList.size()-1)-position).getName());
        holder.tv_bestplayer.setText(modelForHistoryList.get((modelForHistoryList.size()-1)-position).getFavplayer());
        holder.tv_flagcolor.setText(modelForHistoryList.get((modelForHistoryList.size()-1)-position).getFlagcolor());
    }

    @Override
    public int getItemCount() {
        return modelForHistoryList.size();
    }

    public class MyHandler extends RecyclerView.ViewHolder {
        TextView tv_date;
        TextView txt_name;
        TextView tv_bestplayer;
        TextView tv_flagcolor;
        public MyHandler(@NonNull View itemView) {
            super(itemView);
             tv_date=itemView.findViewById(R.id.date);
             txt_name=itemView.findViewById(R.id.txt_name);
               tv_bestplayer=itemView.findViewById(R.id.tv_bestplayer);
                tv_flagcolor=itemView.findViewById(R.id.tv_flagcolor);

        }
    }
}
