package it.neokree.example.mockedFragments;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class FragmentList extends ListFragment {
    private ArrayList<String> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        list = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            list.add("Item " + (i + 1));
        }
        setListAdapter(new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_list_item_1, list));
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
