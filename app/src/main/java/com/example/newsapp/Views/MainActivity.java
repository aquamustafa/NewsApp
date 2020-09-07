package com.example.newsapp.Views;

import android.graphics.Color;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.newsapp.Adapters.viewpagerAdapter;
import com.example.newsapp.R;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    TextView textView;
    EditText editText;
    String country = "";
    Button button;
    ViewPager pager;
    TabLayout tabs;
    com.example.newsapp.Adapters.viewpagerAdapter viewpagerAdapter;


 /*   String COUNTRY[][] = new String[][]{{"argentina", "ar"},
            {"brazil", "br"}, {"Austria", "ar"}, {"Belgium", "be"}, {"Australia", "au"}, {"canada", "ca"},
            {"Bulgaria", "bg"}, {"Canada", "ca"}, {"China", "cn"}, {"Colombia", "co"}, {"Cuba", "cu"}, {"Czech Republic", "cz"},
            {"Egypt", "eg"}, {"France", "fr"}, {"Germany", "de"}, {"Greece", "gr"}, {"Hong Kong", "hk"}, {"Hungary", "hu"},
            {"India", "in"}, {"Indonesia", "id"}, {"Ireland", "ie"}, {"Italy", "it"}, {"Japan", "jp"}, {"Latvia", "lv"},
            {"Lithuania", "lt"}, {"Malaysia", "my"}, {"Mexico", "mx"}, {"Morocco", "ma"}, {"Netherlands", "nl"},
            {"New Zealand", "nz"}, {"Nigeria", "ng"}, {"Norway", "no"}, {"Philippines", "ph"}, {"Poland", "pl"}, {"portugal", "pt"},
            {"Romania", "ro"}, {"Russia", "ru"}, {"Saudi Arabia", "sa"}, {"Serbia", "rs"}, {"Singapore", "sg"}, {"Slovakia", "sk"},
            {"Slovenia", "si"}, {"South Africa", "za"}, {"South Korea", "kr"}, {"Sweden", "se"}, {"Switzerland", "ch"},
            {"Taiwan", "tw"}, {"Thailand", "th"}, {"Turkey", "tr"}, {"UAE", "ae"}, {"Ukraine", "ua"}, {"United Kingdom", "gb"},
            {"United States", "us"}, {"Venezuela", "ve"}};

  */
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                 WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        pager=findViewById(R.id.viewpager);
        tabs=findViewById(R.id.tabLayout);
        pager.setAdapter(new viewpagerAdapter(getSupportFragmentManager()));
        tabs.setupWithViewPager(pager);
         tabs.setTabTextColors(Color.WHITE,Color.parseColor("Black"));



    }
}



