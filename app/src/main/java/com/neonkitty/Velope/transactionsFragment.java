package com.neonkitty.Velope;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;


public class transactionsFragment extends ListFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.envelope_fragment, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        //to Update this: Make this list pull from a sql database
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(), R.array.Transactions, android.R.layout.simple_list_item_1);
        setListAdapter(adapter);

    }
}
