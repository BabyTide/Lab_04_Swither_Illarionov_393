package com.example.lab_04_swither_illarionov_393;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

   CheckBox[] chk;
   EditText[] et, et_c;
   Float [] price;
   EditText et_res;
   RadioButton rb_Message, rb_Toast;
   AlertDialog.Builder dlg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chk = new CheckBox[4];
        et = new EditText[4];
        et_c = new EditText[4];
        price = new Float[4];
        et_res = findViewById(R.id.et_Result);
        rb_Message = findViewById(R.id.rb_Message);
        rb_Toast = findViewById(R.id.rb_Toast);
        chk[0] = findViewById(R.id.checkBoxApple);
        chk[1] = findViewById(R.id.checkBoxStrawberry);
        chk[2] = findViewById(R.id.checkBoxBlueberry);
        chk[3] = findViewById(R.id.checkBoxPotatoes);
        et[0] = findViewById(R.id. editTextApple);
        et[1] = findViewById(R.id.editTextStrawberry);
        et[2] = findViewById(R.id.editTextBlueberry);
        et[3] = findViewById(R.id.editTextPotatoes);
        et_c[0] = findViewById(R.id.et_CostApple);
        et_c[1] = findViewById(R.id.et_CostStraw);
        et_c[2] = findViewById(R.id.et_CostBlue);
        et_c[3] = findViewById(R.id.et_CostPotato);

        dlg = new AlertDialog.Builder(this);
        dlg.setTitle("Announcement");
        dlg.setPositiveButton("Ok", null);
        dlg.setCancelable(true);
    }
    public void OnButton_Click(View V)
    {
        int g;
        double sum = 0;
        String str = "";
        for (int i=0; i < chk.length; i++)
        {
            if (chk[i].isChecked())
            {
                if (et_c[i].getText().toString().equals ("0") || et [i].getText().toString().equals("0"))
                {
                    et_res.setText("Zero value is not appropriate");
                    return;
                }
                price[i] = Float.parseFloat(et_c[i].getText().toString());
                g = Integer.parseInt(et[i]. getText().toString());
                sum += g*price[i];
                str += chk[i].getText() + ": " + et[i].getText() + " x " + et_c[i].getText() + g*price[i] + "\n";
            }

            sum = Math.round(sum);
            str += "Total cost:" + sum;
            if (rb_Message.isChecked())
            {
                dlg.setMessage(str);
                dlg.create().show();
            }
            else if (rb_Toast.isChecked())
            {
                Toast toast = Toast.makeText(getApplicationContext(), str + sum, Toast.LENGTH_LONG);
                toast.show();
            }

            et_res.setText(String.valueOf(Math.round(sum)));

        }
    }

    public void OnRadioButton_click(View V)
    {
        switch ((String)V.getTag())
        {
            case "1":
                rb_Toast.setChecked(false);
                break;
            case "2":
                rb_Message.setChecked(false);
                break;
        }
    }
}