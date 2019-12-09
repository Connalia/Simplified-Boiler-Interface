package gr.aueb.softeng.thermosifonas;

import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static gr.aueb.softeng.thermosifonas.AutoOff.flagEditOff;
import static gr.aueb.softeng.thermosifonas.AutoOff.tempAutoOff;
import static gr.aueb.softeng.thermosifonas.AutoOn.flagEditOn;
import static gr.aueb.softeng.thermosifonas.AutoOn.tempAutoOn;
import static gr.aueb.softeng.thermosifonas.EcoMode.HourMorningEnd;
import static gr.aueb.softeng.thermosifonas.EcoMode.HourMorningStart;
import static gr.aueb.softeng.thermosifonas.EcoMode.HourNightEnd;
import static gr.aueb.softeng.thermosifonas.EcoMode.HourNightStart;
import static gr.aueb.softeng.thermosifonas.EcoMode.ecoModeFlagMorning;
import static gr.aueb.softeng.thermosifonas.EcoMode.ecoModeFlagNight;
import static gr.aueb.softeng.thermosifonas.Timer.mTimerRunning;

public class MainActivity extends AppCompatActivity {

    public static boolean currentStateOn;
    private Button buttonONOFF;
    private TextView Celsius;
    private ImageView Img_Eco;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View root;
        root=findViewById(R.id.buttonON).getRootView();
        int color= Color.parseColor("#ffffff");
        root.setBackgroundColor(color);


        initiate();

        autoState();

        autoStateEco();

        autoStateTimer();




    }



    private void autoStateTimer(){
        if(mTimerRunning==true){
            buttonONOFF.setBackgroundResource(R.drawable.on4);
            currentStateOn=true;
        }
        if(mTimerRunning==false){
            buttonONOFF.setBackgroundResource(R.drawable.off4);
            currentStateOn=false;
        }

    }

    private void autoStateEco(){
        buttonONOFF=findViewById(R.id.buttonON);

        Img_Eco=findViewById(R.id.Img_Eco);


        Date currentDate=Calendar.getInstance().getTime();
        String currentDateStr=currentDate.toString();

        currentDateStr=currentDateStr.substring(11,13);//take hour
        int currentDateInt=Integer.parseInt(currentDateStr);

        if(ecoModeFlagMorning==true||ecoModeFlagNight==true){
            //Img_Eco.setBackgroundResource(R.drawable.eco2);
            Img_Eco.setVisibility(View.VISIBLE);

            if(currentDateInt>=HourMorningStart && currentDateInt<HourMorningEnd){
                buttonONOFF.setBackgroundResource(R.drawable.on4);
                currentStateOn=true;
            }
            if(currentDateInt>HourMorningEnd){
                buttonONOFF.setBackgroundResource(R.drawable.off4);
                currentStateOn=false;
            }
            if(currentDateInt>=HourNightStart && currentDateInt>HourNightEnd){
                buttonONOFF.setBackgroundResource(R.drawable.on4);
                currentStateOn=true;
            }
            if(currentDateInt>HourNightEnd){
                buttonONOFF.setBackgroundResource(R.drawable.off4);
                currentStateOn=false;
            }
        }else{
            Img_Eco.setVisibility(View.INVISIBLE);
        }

    }

    private void autoState(){
        buttonONOFF=findViewById(R.id.buttonON);
        Celsius=findViewById(R.id.Celsius);

        String celStr=Celsius.getText().toString();
        int celInt=Integer.parseInt(celStr);

        if(flagEditOn==true && tempAutoOn>=celInt){
            buttonONOFF.setBackgroundResource(R.drawable.on4);
            currentStateOn=true;
        }

        if(tempAutoOff<=celInt){
            buttonONOFF.setBackgroundResource(R.drawable.off4);
            currentStateOn=false;
        }
    }

    private void initiate(){
        buttonONOFF=findViewById(R.id.buttonON);
        buttonONOFF.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Toast.makeText(MainActivity.this,"Click",Toast.LENGTH_SHORT).show();

                if (buttonONOFF.getBackground().getConstantState()==getResources().getDrawable(R.drawable.on4).getConstantState()) {
                    buttonONOFF.setBackgroundResource(R.drawable.off4);
                    currentStateOn=false;
                }else{
                    buttonONOFF.setBackgroundResource(R.drawable.on4);
                    currentStateOn=true;
                }
            }
        });


        Button btn_Menu=findViewById(R.id.btn_Menu);
        btn_Menu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent_btn_Menu = new Intent(v.getContext(), Menu.class);
                startActivity(intent_btn_Menu);
            }
        });

        TextView Celsius=findViewById(R.id.Celsius);

        Celsius.setText("30");


    }


}
