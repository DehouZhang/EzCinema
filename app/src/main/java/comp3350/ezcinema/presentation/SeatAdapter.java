package comp3350.ezcinema.presentation;


import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import comp3350.ezcinema.R;

public class SeatAdapter extends BaseAdapter{

    private Context context;
    private LayoutInflater inflater;
    private int[][] table;

    public SeatAdapter(Context c,int[][] t) {
        context = c;
        inflater = LayoutInflater.from(c);
        table = t;
    }

    @Override
    public int getCount() {
        return 25;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = inflater.inflate(R.layout.layout_seat_select_adapter_form,viewGroup,false);
            TextView textViewSeat = (TextView)view.findViewById(R.id.textViewSeat);

            //read from table and set item
            if (table[i/5][i%5] == 0){
                //enable the item
                textViewSeat.setBackgroundColor(Color.GREEN);
                view.setClickable(false);
            }else{
                //disable the item
                textViewSeat.setBackgroundColor(Color.RED);
                view.setClickable(true);
            }

            textViewSeat.setText((i/5+1)+","+(i%5+1));
        }
        return view;
    }
}
