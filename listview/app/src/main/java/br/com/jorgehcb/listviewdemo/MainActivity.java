package br.com.jorgehcb.listviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private ListView listView ;
    private ArrayAdapter<String> listAdapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the ListView resource.
        listView = (ListView) findViewById( R.id.listViewID );

        // Create a ArrayAdapter and populate a List of planet names.
        String[] planets = new String[] { "Mercury", "Venus", "Earth", "Mars",
                "Jupiter", "Saturn", "Uranus", "Neptune"};
        ArrayList<String> planetList = new ArrayList<>();
        planetList.addAll( Arrays.asList(planets) );

        // Create ArrayAdapter using the planet list.

        // (usando este construtor, o R.layout.item_row deve conter unicamente o textview no item_row.xml)
        //listAdapter = new ArrayAdapter<>(this, R.layout.item_row, planetList);

        // (usando este segundo construtor, o R.layout.item_row2 pode conter layouts mais complexo)
        //listAdapter = new ArrayAdapter<>(this, R.layout.item_row2, R.id.textViewID, planetList);

        // (usando simple_list_item_1)
        listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, planetList);

        // Add more planets. If you passed a String[] instead of a List<String>
        // into the ArrayAdapter constructor, you must not add more items.
        // Otherwise an exception will occur.
        listAdapter.add( "Ceres" );
        listAdapter.add( "Pluto" );
        listAdapter.add( "Haumea" );
        listAdapter.add( "Makemake" );
        listAdapter.add( "Eris" );

        // Set the ArrayAdapter as the ListView's adapter.
        listView.setAdapter( listAdapter );

    }
}
