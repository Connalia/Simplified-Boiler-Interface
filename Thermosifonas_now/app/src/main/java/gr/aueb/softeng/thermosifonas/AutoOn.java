package gr.aueb.softeng.thermosifonas;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static gr.aueb.softeng.thermosifonas.AutoOff.tempAutoOff;

public class AutoOn extends AppCompatActivity {
    public static int tempAutoOn;
    public static boolean flagEditOn=false;

    private Button btnOkON;
    private TextView txtOnNumber,txt_errorUpOn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_on);

        View root;
        root=findViewById(R.id.btnOkON).getRootView();
        int color= Color.parseColor("#e6f9ff");
        root.setBackgroundColor(color);

        btnOkON = (Button) findViewById(R.id.btnOkON);
        txtOnNumber = (TextView) findViewById(R.id.txtOnNumber);
        txt_errorUpOn = (TextView) findViewById(R.id.txt_errorUpOn);
        color= Color.parseColor("#595959");
        btnOkON.setBackgroundColor(color);

        Button btnBackAutoOn = findViewById(R.id.btnBackAutoOn);
        btnBackAutoOn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent_btnBackAutoOn = new Intent(v.getContext(), AytoLeitourgies.class);
                startActivity(intent_btnBackAutoOn);
            }
        });

        if(flagEditOn==false){
            txtOnNumber.setText("");
        }else{
            txtOnNumber.setText("" + tempAutoOn);
        }

        btnOkON.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String input = txtOnNumber.getText().toString();
                txtOnNumber.setText(input);
                if (tempAutoOff <= Integer.parseInt(input)) {
                    Toast.makeText(getApplicationContext(), "Error input: " + input, Toast.LENGTH_SHORT).show();
                    txt_errorUpOn.setText("Temperature can not be bigger than Auto off( " + tempAutoOff + " C).");
                    txtOnNumber.setText("");
                    flagEditOn = false;
                } else {
                    tempAutoOn = Integer.parseInt(input);
                    txt_errorUpOn.setText("");
                    Toast.makeText(getApplicationContext(), "Auto On is: " + input, Toast.LENGTH_SHORT).show();
                    flagEditOn = true;
                }

            }
        });
    }
}
