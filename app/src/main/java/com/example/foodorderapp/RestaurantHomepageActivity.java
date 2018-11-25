package com.example.foodorderapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import static com.example.foodorderapp.NearbyRestaurantsActivity.SELECTED_RESTAURANT;

/**
 * The homepage for when a restaurant/food worker logs in.
 */
public class RestaurantHomepageActivity extends AppCompatActivity {

    private TextView tempDisplay;
    private LinearLayout tempLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurant);

        tempDisplay = findViewById(R.id.temp_rest_homepage_text);
        tempLayout = findViewById(R.id.menu_item_linlayout);


        Intent intent = getIntent();
        String restaurantName = intent.getStringExtra(SELECTED_RESTAURANT);
        tempDisplay.setText(restaurantName + " Homepage");

        // Hard coded values for now, this is horrible but this was left until the last second.
        GridLayout gl = new GridLayout(this);
        gl.setOrientation(GridLayout.VERTICAL);
        if (restaurantName.equals("Jimmy Johns")) {
            String[] menuItems = {"Turkey Bacon Sub", "Chips", "Soda"};
            for (int i = 0; i < menuItems.length; i++) {
                GridLayout innergl = new GridLayout(this);
                TextView menuItem = new TextView(this);
                menuItem.setText(menuItems[i]);
                CheckBox myCheckBox = new CheckBox(this);
                innergl.addView(menuItem);
                innergl.addView(myCheckBox);
                menuItem.setVisibility(View.VISIBLE);
                myCheckBox.setVisibility(View.VISIBLE);
                gl.addView(innergl);
            }
        } else if (restaurantName.equals("Jack in the Box")) {
            String[] menuItems = {"Buttery Jack", "Bacon Ultimate Cheeseburger", "Soda"};
            for (int i = 0; i < menuItems.length; i++) {
                GridLayout innergl = new GridLayout(this);
                TextView menuItem = new TextView(this);
                menuItem.setText(menuItems[i]);
                CheckBox myCheckBox = new CheckBox(this);
                innergl.addView(menuItem);
                innergl.addView(myCheckBox);
                menuItem.setVisibility(View.VISIBLE);
                myCheckBox.setVisibility(View.VISIBLE);
                gl.addView(innergl);
            }
        }
        tempLayout.addView(gl);
    }
}
