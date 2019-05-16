package com.neonkitty.Velope;

import android.support.annotation.Nullable;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;


public class envelopeFragment extends ListFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.envelope_fragment, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ListView listView = getListView();

        //add button to the bottom of the envelopes listView and add a listener to it
        LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(LAYOUT_INFLATER_SERVICE);
        View footerView = inflater.inflate(R.layout.envelope_fragment_listview_footer, null, false);

        footerView.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addEnvelope();
            }
        });

        listView.addFooterView(footerView);

        //just need to change where this items array comes from to make this work with dynamic data
       String[] items = getResources().getStringArray(R.array.Envelopes);

       //create the arrayAdapter view
        ArrayAdapter adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);

    }

    private void addEnvelope(){
        Toast.makeText(getContext(), "Allen add AddEnvelope Activity", Toast.LENGTH_LONG).show();
    }
}
