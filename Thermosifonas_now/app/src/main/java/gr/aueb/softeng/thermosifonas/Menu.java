package gr.aueb.softeng.thermosifonas;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {

    public static boolean flagInfoTimer=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        int color;







        View root;
        root=findViewById(R.id.btnAuto).getRootView();
        color= Color.parseColor("#ffffff");
        root.setBackgroundColor(color);


        Button btnAuto=findViewById(R.id.btnAuto);
        btnAuto.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent_logActivity = new Intent(v.getContext(), AytoLeitourgies.class);
                startActivity(intent_logActivity);
            }
        });
        color= Color.parseColor("#595959");
        btnAuto.setBackgroundColor(color);

        Button btnAutoI=findViewById(R.id.btnAytoIcon);
        btnAutoI.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent_logActivity = new Intent(v.getContext(), AytoLeitourgies.class);
                startActivity(intent_logActivity);
            }
        });

        Button btnTimer=findViewById(R.id.btnTimer);
        btnTimer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent_logActivity = new Intent(v.getContext(), Timer.class);
                startActivity(intent_logActivity);
            }
        });
        color= Color.parseColor("#595959");
        btnTimer.setBackgroundColor(color);

        Button btnTimerI=findViewById(R.id.btnTimerIcon);
        btnTimerI.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent_logActivity = new Intent(v.getContext(), Timer.class);
                startActivity(intent_logActivity);
            }
        });

        Button btnTimerInfo=findViewById(R.id.btnTimerInfo);
        btnTimerInfo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                flagInfoTimer=true;
                Intent intent_logActivity = new Intent(v.getContext(), Info.class);
                startActivity(intent_logActivity);
            }
        });

        Button btnBack=findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent_main = new Intent(v.getContext(), MainActivity.class);
                startActivity(intent_main);
            }
        });


    }
}
