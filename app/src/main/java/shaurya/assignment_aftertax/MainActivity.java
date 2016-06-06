package shaurya.assignment_aftertax;

import android.content.DialogInterface;
import android.graphics.Typeface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView_input,textView_result;
    String input = "",result = "";
    double price = 0.0;
    TextView i1,i2,i3,i4,i5,i6,i7,i8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView_input=(TextView)findViewById(R.id.textView);
        textView_result=(TextView)findViewById(R.id.textView_tax);
        configViews();
    }

    public void button_clicked(View v){

        Button button = (Button)v;
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        final EditText editText = new EditText(getApplicationContext());
        editText.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        editText.setInputType(InputType.TYPE_CLASS_NUMBER
                | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        alert.setMessage("Enter Amount");
        alert.setTitle(button.getText());
        alert.setView(editText);
        alert.setPositiveButton("CALCULATE", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                if(input.isEmpty()){
                    price = price + Double.parseDouble(editText.getText().toString());
                    result = price+"";
                    input = editText.getText().toString();
                }
                else {
                    price = price + Double.parseDouble(editText.getText().toString());
                    result = price+"";
                    input = input + " + " + editText.getText().toString();
                }
                Toast.makeText(getApplicationContext(),input,Toast.LENGTH_SHORT).show();
                textView_input.setText(input);
                textView_result.setText(result);
            }
        });
        alert.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
            }
        });
        alert.show();
    }
    private void configViews() {
        i1=(TextView)findViewById(R.id.icon1);
        i2=(TextView)findViewById(R.id.icon2);
        i3=(TextView)findViewById(R.id.icon3);
        i4=(TextView)findViewById(R.id.icon4);
        i5=(TextView)findViewById(R.id.icon5);
        i6=(TextView)findViewById(R.id.icon6);
        i7=(TextView)findViewById(R.id.icon7);
        i8=(TextView)findViewById(R.id.icon8);
        Typeface font_awesome = Typeface.createFromAsset(getAssets(),"fontawesome-webfont.ttf");
        i1.setTypeface(font_awesome);
        i2.setTypeface(font_awesome);
        i3.setTypeface(font_awesome);
        i4.setTypeface(font_awesome);
        i5.setTypeface(font_awesome);
        i6.setTypeface(font_awesome);
        i7.setTypeface(font_awesome);
        i8.setTypeface(font_awesome);
        i1.setText("\uf0f5");
        i2.setText("\uf0fc");
        i3.setText("\uf219");
        i4.setText("\uf07a");
        i5.setText("\uf0d1");
        i6.setText("\uf10b");
        i7.setText("\uf0fa");
        i8.setText("\uf02d");
    }
    void button_clickedd(View v){
        TextView t=(TextView)v;
        Toast.makeText(getApplicationContext(),t.getText().toString(),Toast.LENGTH_SHORT).show();
    }
}
