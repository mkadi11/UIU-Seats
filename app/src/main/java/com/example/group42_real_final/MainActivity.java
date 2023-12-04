//done
package com.example.group42_real_final;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.view.View.OnClickListener;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.group42_real_final.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private Switch nightModeSwitch;
    private SharedPreferences sharedPreferences;
    private String mansi;

    // place objects
    Place union = new Place("Union");
    Place grainger = new Place("Grainger");
    Place arc = new Place("ARC");
    Place bene = new Place("Cafe Bene");

    // buttons
    private TextView unionText;
    private TextView graingerText;
    private TextView arcText;
    private TextView beneText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //sharedPreferences = getPreferences(MODE_PRIVATE);
//        setTheme(getThemePreference());
        setContentView(R.layout.activity_main);

//        binding = ActivityMainBinding.inflate(getLayoutInflater());
//       setContentView(binding.getRoot());


        // initialize all text view objects
        unionText = findViewById(R.id.UnionValue);
        graingerText = findViewById(R.id.GraingerValue);
        arcText = findViewById(R.id.ARCValue);
        beneText = findViewById(R.id.BeneValue);


        //setSupportActionBar(binding.toolbar);


        /*NavController navController = Navigation.findNavController(this, R.id.nav_graph);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        */

//        binding.fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

    }

    // union button functions
    public void onUnBusyClick(View v) {
        union.add(10);
        unionText.setText(union.getAvg());
    }
    public void onUnNeutralClick(View v) {
        union.add(5);
        unionText.setText(union.getAvg());
    }
    public void onUnEmptyClick(View v) {
        union.add(0);
        unionText.setText(union.getAvg());
    }

    // grainger button functions
    public void onGrBusyClick(View v) {
        grainger.add(10);
        graingerText.setText(grainger.getAvg());
    }
    public void onGrNeutralClick(View v) {
        grainger.add(5);
        graingerText.setText(grainger.getAvg());
    }
    public void onGrEmptyClick(View v) {
        grainger.add(0);
        graingerText.setText(grainger.getAvg());
    }

    // arc button functions
    public void onARCBusyClick(View v) {
        arc.add(10);
        arcText.setText(arc.getAvg());
    }
    public void onARCNeutralClick(View v) {
        arc.add(5);
        arcText.setText(arc.getAvg());
    }
    public void onARCEmptyClick(View v) {
        arc.add(0);
        arcText.setText(arc.getAvg());
    }

    // bene button functions
    public void onCBBusyClick(View v) {
        bene.add(10);
        beneText.setText(bene.getAvg());
    }
    public void onCBNeutralClick(View v) {
        bene.add(5);
        beneText.setText(bene.getAvg());
    }
    public void onCBEmptyClick(View v) {
        bene.add(0);
        beneText.setText(bene.getAvg());
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_graph);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

//    private int getThemePreference() {
//        return sharedPreferences.getInt("themePreference", R.style.AppTheme);
//    }
//
//    private void setThemePreference(boolean isDarkMode) {
//        int selectedTheme = isDarkMode ? R.style.AppThemeDark : R.style.AppTheme;
//        AppCompatDelegate.setDefaultNightMode(isDarkMode ? AppCompatDelegate.MODE_NIGHT_YES : AppCompatDelegate.MODE_NIGHT_NO);
//        setTheme(selectedTheme);
//        sharedPreferences.edit().putInt("themePreference", selectedTheme).apply();
//    }
}
