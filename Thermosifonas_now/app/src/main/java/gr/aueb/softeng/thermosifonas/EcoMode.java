package gr.aueb.softeng.thermosifonas;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;



public class EcoMode extends AppCompatActivity {

    private Switch switch1,switch2,switch3,switch4;
    public static int HourMorningStart,
            HourMorningEnd,
            HourNightStart,
            HourNightEnd;

    public static boolean ecoModeFlagMorning,ecoModeFlagNight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eco_mode);

        switch1=(Switch) findViewById(R.id.switch1);
        switch2=(Switch) findViewById(R.id.switch2);

        View root;
        root=findViewById(R.id.switch1).getRootView();
        int color= Color.parseColor("#c7ebc7");
        root.setBackgroundColor(color);


        if(ecoModeFlagNight==true){
            switch2.setChecked(true);
        }
        if(ecoModeFlagMorning==true){
            switch1.setChecked(true);
        }

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(getApplicationContext(),"The eco mode morning on",Toast.LENGTH_SHORT).show();
                    ecoModeFlagMorning=true;
                }else{
                    Toast.makeText(getApplicationContext(),"The eco mode morning off",Toast.LENGTH_SHORT).show();
                    ecoModeFlagMorning=false;
                }
            }
        });
        switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(getApplicationContext(),"The eco mode night on",Toast.LENGTH_SHORT).show();
                    ecoModeFlagNight=true;
                }else{
                    Toast.makeText(getApplicationContext(),"The eco mode night off",Toast.LENGTH_SHORT).show();
                    ecoModeFlagNight=false;
                }
            }
        });

        Calendar calendar=Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance().format(calendar.getTime());
        TextView textViewPeriod=findViewById(R.id.textView8);

        String a=currentDate.substring(0,3);

        if(a.equals("Nov")||a.equals("Dec")||a.equals("Jan")||a.equals("Feb")||a.equals("Mar")||a.equals("Apr")){
            textViewPeriod.setText("Winter Period");
            HourMorningStart=2;
            HourMorningEnd=8;
            HourNightStart=15;
            HourNightEnd=17;
        }else{
            textViewPeriod.setText("Summer Period");
            HourMorningStart=7;
            HourMorningEnd=15;
            HourNightStart=15;
            HourNightEnd=23;
        }


        Button btnBackAutoEco=findViewById(R.id.btnBackAutoEco);
        btnBackAutoEco.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent_btnBackAutoEco = new Intent(v.getContext(), AytoLeitourgies.class);
                startActivity(intent_btnBackAutoEco);
            }
        });




    }
}
