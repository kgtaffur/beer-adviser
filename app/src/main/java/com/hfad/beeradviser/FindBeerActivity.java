package com.hfad.beeradviser;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class FindBeerActivity extends Activity {
    private BeerExpert expert = new BeerExpert();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_beer);
    }

    public void onClickFindBeer(View view) {
        // reference to Spinner
        Spinner color = (Spinner) findViewById(R.id.color);
        // selected item from the Spinner
        String beerType = String.valueOf(color.getSelectedItem());

        // reference to Text View
        TextView brands = (TextView) findViewById(R.id.brands);

        List<String> brandsList = this.expert.getBrands(beerType);
        StringBuilder brandsFormatted = new StringBuilder();

        for (String brand : brandsList) {
            brandsFormatted.append(brand).append("\n");
        }

        // display selected item
        brands.setText(brandsFormatted);
    }
}