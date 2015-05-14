package it.neokree.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import it.neokree.example.backpattern.BackAnywhere;
import it.neokree.example.backpattern.BackToFirst;
import it.neokree.example.dark.AccountsDark;
import it.neokree.example.dark.CustomDrawerHeaderDark;
import it.neokree.example.dark.ImageDrawerHeaderDark;
import it.neokree.example.dark.MockedAccountDark;
import it.neokree.example.dark.NoDrawerHeaderDark;
import it.neokree.example.functionalities.ActionBarShadow;
import it.neokree.example.functionalities.CustomAccountSection;
import it.neokree.example.functionalities.DefaultSectionLoaded;
import it.neokree.example.functionalities.KitkatStatusBar;
import it.neokree.example.functionalities.LearningPatternDisabled;
import it.neokree.example.functionalities.MultiPane;
import it.neokree.example.functionalities.NoRippleDelayClick;
import it.neokree.example.functionalities.RealColorSections;
import it.neokree.example.functionalities.RippleBackport;
import it.neokree.example.functionalities.UniqueToolbarColor;
import it.neokree.example.functionalities.master_child.MasterChildActivity;
import it.neokree.example.light.AccountsLight;
import it.neokree.example.light.CustomDrawerHeaderLight;
import it.neokree.example.light.ImageDrawerHeaderLight;
import it.neokree.example.light.MockedAccountLight;
import it.neokree.example.light.NoDrawerHeaderLight;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private List<Sample> samples;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        samples = new ArrayList<>();

        ListView listView = (ListView) findViewById(R.id.listView);

        addSample("Light - Mocked Account", MockedAccountLight.class);
        addSample("Dark  - Mocked Account", MockedAccountDark.class);

        addSample("Light - Accounts", AccountsLight.class);
        addSample("Dark  - Accounts", AccountsDark.class);

        addSample("Light - Drawer Header Image", ImageDrawerHeaderLight.class);
        addSample("Dark  - Drawer Header Image", ImageDrawerHeaderDark.class);

        addSample("Light - No Drawer Header", NoDrawerHeaderLight.class);
        addSample("Dark  - No Drawer Header", NoDrawerHeaderDark.class);

        addSample("Light - Custom Drawer Header", CustomDrawerHeaderLight.class);
        addSample("Dark  - Custom Drawer Header", CustomDrawerHeaderDark.class);

        addSample("Functionality: unique Toolbar Color", UniqueToolbarColor.class);
        addSample("Functionality: ripple backport support", RippleBackport.class);
        addSample("Functionality: ripple backport support: no delay click", NoRippleDelayClick.class);
        addSample("Functionality: multi pane support for tablet", MultiPane.class);
        addSample("Functionality: custom section under account list", CustomAccountSection.class);
        addSample("Functionality: Kitkat trasluncent status bar", KitkatStatusBar.class);
        addSample("Functionality: Master/Child example", MasterChildActivity.class);
        addSample("Functionality: section not pre-rendered", RealColorSections.class);
        addSample("Functionality: default section loaded", DefaultSectionLoaded.class);
        addSample("Functionality: action bar shadow enabled (toolbar elevation)", ActionBarShadow.class);
        addSample("Functionality: learning pattern disabled", LearningPatternDisabled.class);

        addSample("Back Pattern: Back To first", BackToFirst.class);
        addSample("Back Pattern: Back Anywhere", BackAnywhere.class);

        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getTitles()));
        listView.setOnItemClickListener(this);
    }

    private List<String> getTitles() {
        List<String> titles = new ArrayList<String>();
        for (Sample sample : samples) {
            titles.add(sample.title);
        }
        return titles;
    }

    private void addSample(String title, Class<? extends Activity> activity) {
        samples.add(new Sample(title, activity));
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        startActivity(new Intent(this, samples.get(position).activity));
    }

    private static class Sample {
        String title;
        Class<? extends Activity> activity;

        public Sample(String title, Class<? extends Activity> activity) {
            this.title = title;
            this.activity = activity;
        }
    }
}
