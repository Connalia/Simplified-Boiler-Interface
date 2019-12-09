package gr.aueb.softeng.thermosifonas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static gr.aueb.softeng.thermosifonas.AytoLeitourgies.flagInfoEco;
import static gr.aueb.softeng.thermosifonas.AytoLeitourgies.flagInfoOff;
import static gr.aueb.softeng.thermosifonas.AytoLeitourgies.flagInfoOn;
import static gr.aueb.softeng.thermosifonas.Menu.flagInfoTimer;



public class Info extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        TextView text= findViewById(R.id.txt_Info);
        Button btnBack=findViewById(R.id.btnBackInfo);

        if(flagInfoOn){
            flagInfoOn=false;
            text.setText("AYTO ON:\n\nWith this service, you can set the temperature that you want the water heater to be activated and it will automatically turn on every time it reaches this temperature.");
            btnBack.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent_btnEcoMode = new Intent(v.getContext(), AytoLeitourgies.class);
                    startActivity(intent_btnEcoMode);
                }
            });
        }

        if(flagInfoOff){
            flagInfoOff=false;
            text.setText("AYTO OFF:\n\nWith this service, you can set the temperature that you want the water heater to turn off and it will automatically do it, every time it reaches this temperature.");
            btnBack.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent_btnEcoMode = new Intent(v.getContext(),  AytoLeitourgies.class);
                    startActivity(intent_btnEcoMode);
                }
            });
        }

        if(flagInfoEco){
            flagInfoEco=false;
            text.setText("ECO MODE:\n\nWith this service, you can save energy and money.First you choose the time of the day you want the eco mode to be activated (morning or night). The hours of the morning and night" +
                    "that this mode operates are fixed:\n\n For morning in winter period: 2:00 - 8:00\n For night in winter period: 15:00 - 17:00\n\n For morning in summer period: 7:00 - 15:00\n" +
                    " For night in summer period: 15:00 - 23:00\n\nYou do not have to choose period because the application will automatically show you the right one, based on the current date.So once you turn the eco mode on, the" +
                    "water heater will be automatically on only these hours that the electricity is cheaper. Then you can close it whenever you want or it will close automatically in the auto off temperature.");
            btnBack.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent_btnEcoMode = new Intent(v.getContext(),  AytoLeitourgies.class);
                    startActivity(intent_btnEcoMode);
                }
            });

        }
        if(flagInfoTimer){
            flagInfoTimer=false;
            text.setText("TIMER:\n\nYou can use the timer if you want the water heater to be on a specific amount of time(e.g 20 minutes, which is the default time).When the chosen time passes, the water heater closes by itself.");
            btnBack.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent_btnEcoMode = new Intent(v.getContext(), Menu.class);
                    startActivity(intent_btnEcoMode);
                }
            });
        }








    }

    //flagInfoOn.flagInfoOff,flagInfoEco,flagInfoTimer

}