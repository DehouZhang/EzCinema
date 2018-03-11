package comp3350.ezcinema.presentation;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import comp3350.ezcinema.R;
import comp3350.ezcinema.objects.MT;

/**
 * Created by 杨 on 2018/3/11.
 */

public class MovieSelectTheaterAdapter extends ArrayAdapter<MT>{

    public MovieSelectTheaterAdapter(@NonNull Context context, ArrayList<MT> list) {
        super(context,0,list);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        MT mMT = getItem(position);


        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_movie_select_theater_adapter_form,parent,false);
        }

        TextView textViewTheaterInfo = (TextView)convertView.findViewById(R.id.textViewTheaterInfo);
        TextView textViewShowTimes = (TextView)convertView.findViewById(R.id.textViewShowTimes);

        textViewTheaterInfo.setText(mMT.getTheaterName());
        textViewShowTimes.setText("Show Times: "+ mMT.showtimeToString());

        return convertView;
    }
}
