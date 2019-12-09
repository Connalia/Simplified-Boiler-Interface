package gr.aueb.softeng.thermosifonas;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class AytoLeitourgies extends AppCompatActivity {

    public static boolean flagInfoOn=false,
            flagInfoOff=false,
            flagInfoEco=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayto_leitourgies);

        int color;

        View root;
        root=findViewById(R.id.btnTempOnIc).getRootView();
        color= Color.parseColor("#ffffff");
        root.setBackgroundColor(color);




        Button btnTempOnIc=findViewById(R.id.btnTempOnIc);
        btnTempOnIc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent_btnTempOnIc = new Intent(v.getContext(), AutoOn.class);
                startActivity(intent_btnTempOnIc);
            }
        });

        Button btnTempOn=findViewById(R.id.btnTempOn);
        //btnTempOn.getBackground().setColorFilter(#ff0000, PorterDuff.Mode.MULTIPLY);
        color= Color.parseColor("#66d9ff");
        btnTempOn.setBackgroundColor(color);


        btnTempOn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent_btnTempOn = new Intent(v.getContext(), AutoOn.class);
                startActivity(intent_btnTempOn);
            }
        });

        Button btnTempOffIc=findViewById(R.id.btnTempOffIc);
        btnTempOffIc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent_btnTempOffIc = new Intent(v.getContext(), AutoOff.class);
                startActivity(intent_btnTempOffIc);
            }
        });

        Button btnTempOff=findViewById(R.id.btnTempOff);
        color= Color.parseColor("#ff3333");
        btnTempOff.setBackgroundColor(color);
        btnTempOff.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent_btnTempOff = new Intent(v.getContext(), AutoOff.class);
                startActivity(intent_btnTempOff);
            }
        });

        Button btnEcoModeIc=findViewById(R.id.btnEcoModeIc);
        btnEcoModeIc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent_btnEcoModeIc = new Intent(v.getContext(), EcoMode.class);
                startActivity(intent_btnEcoModeIc);
            }
        });

        Button btnEcoMode=findViewById(R.id.btnEcoMode);
        //color= Color.parseColor("#79d279");
        //btnEcoMode.setBackgroundColor(color);
        btnEcoMode.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent_btnEcoMode = new Intent(v.getContext(), EcoMode.class);
                startActivity(intent_btnEcoMode);
            }
        });

        Button btnBackMenu=findViewById(R.id.btnBackMenu);
        btnBackMenu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent_btnBackMenu = new Intent(v.getContext(), Menu.class);
                startActivity(intent_btnBackMenu);
            }
        });

        Button btnTemOnIcon=findViewById(R.id.btnTemOnIcon);
        btnTemOnIcon.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                flagInfoOn=true;
                Intent intent_btnTemOnIcon = new Intent(v.getContext(), Info.class);
                startActivity(intent_btnTemOnIcon);
            }
        });

        Button btnTempOffIcon=findViewById(R.id.btnTempOffIcon);
        btnTempOffIcon.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                flagInfoOff=true;
                Intent intent_btnTempOffIcon = new Intent(v.getContext(), Info.class);
                startActivity(intent_btnTempOffIcon);
            }
        });

        Button btnEcoIcon=findViewById(R.id.btnEcoIcon);
        btnEcoIcon.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                flagInfoEco=true;
                Intent intent_btnEcoIcon = new Intent(v.getContext(), Info.class);
                startActivity(intent_btnEcoIcon);
            }
        });

    }


}
