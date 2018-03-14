package comp3350.ezcinema.presentation;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import comp3350.ezcinema.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentPaypal extends Fragment
{


    public FragmentPaypal()
    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_paypal, container, false);
    }

}
