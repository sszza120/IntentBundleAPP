package com.sszza120.intentbundleapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class BmiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        
        calBMI();
    }

    private void calBMI() {
        double height, weight, bmi;
        Bundle bundle = this.getIntent().getExtras();

        if (bundle != null){
            height = Double.parseDouble(bundle.getString("HEIGHT"));
            weight = Double.parseDouble(bundle.getString("WEIGHT"));

            height = height/100;
            bmi = weight/(height*height);

            String result = "正常";
            if (bmi<35 && bmi>30)
                result = "中度肥胖";

            TextView txvshow = findViewById(R.id.txvshow);

            txvshow.setText("BMI:" + bmi +"\n"+result);
        }
    }

    public void btnOK(View view) {
        finish();
    }
}
