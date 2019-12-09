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

import junit.framework.Test;

public class AutoOff extends AppCompatActivity {

    public static int tempAutoOff=45;
    public static boolean flagEditOff=false;
    private int tempAutoOffDefault=45;

    private Button btnOkOFF,btn_defaultOff;
    private TextView txtOffNumber,txt_errorUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_off);

        int color;

        btnOkOFF=(Button) findViewById(R.id.btnOkOFF);
        btn_defaultOff=(Button) findViewById(R.id.btn_defaultOff);
        txtOffNumber=(TextView) findViewById(R.id.txtOffNumber);
        txt_errorUp=(TextView) findViewById(R.id.txt_errorUp);
        color= Color.parseColor("#595959");
        btnOkOFF.setBackgroundColor(color);

        color= Color.parseColor("#ff3333");
        btn_defaultOff.setBackgroundColor(color);

        View root;
        root=findViewById(R.id.btnOkOFF).getRootView();
        color= Color.parseColor("#ffe6e6");
        root.setBackgroundColor(color);


        Button btnBackAutoOff=findViewById(R.id.btnBackAutoOff);
        btnBackAutoOff.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent_btnBackAutoOff = new Intent(v.getContext(), AytoLeitourgies.class);
                startActivity(intent_btnBackAutoOff);
            }
        });

        if(flagEditOff==false){
            tempAutoOff=tempAutoOffDefault;
            txtOffNumber.setText("" + tempAutoOff);
        }else{
            txtOffNumber.setText("" + tempAutoOff);
        }

        btnOkOFF.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String input=txtOffNumber.getText().toString();
                txtOffNumber.setText(input);
                if(tempAutoOffDefault<Integer.parseInt(input)){
                    flagEditOff=false;
                    Toast.makeText(getApplicationContext(),"Error input: "+input,Toast.LENGTH_SHORT).show();
                    txt_errorUp.setText("Temperature can not be bigger than default ( "+tempAutoOffDefault+" ).");
                    tempAutoOff=tempAutoOffDefault;
                    txtOffNumber.setText(""+tempAutoOffDefault);

                }else{
                    tempAutoOff=Integer.parseInt(input);
                    txt_errorUp.setText("");
                    Toast.makeText(getApplicationContext(),"Auto Off is: "+input,Toast.LENGTH_SHORT).show();
                    flagEditOff=true;
                }

            }
        });

        btn_defaultOff.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                flagEditOff=false;
                txtOffNumber.setText(""+tempAutoOffDefault);
                tempAutoOff=tempAutoOffDefault;
            }
        });

    }
}
