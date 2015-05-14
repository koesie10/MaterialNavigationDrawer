package it.neokree.example.functionalities.master_child;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import it.neokree.example.R;
import it.neokree.materialnavigationdrawer.MaterialNavigationDrawer;

public class MasterFragment extends Fragment implements View.OnClickListener {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.masterchild_master, container, false);
        ((Button) view.findViewById(R.id.master_button)).setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        ((MaterialNavigationDrawer) this.getActivity()).setFragmentChild(new ChildFragment(), "Child Title");
    }
}
