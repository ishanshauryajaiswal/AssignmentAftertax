package shaurya.assignment_aftertax;

import android.content.DialogInterface;
import android.graphics.Typeface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    String input = "",result = "";
    TextView i1,i2,i3,i4,i5,i6,i7,i8;
    HashMap<String ,Category> hashMap = new HashMap<String , Category>();
    double price = 0.0 , array[] = new double[100];
    int size=-1;
    TextView textView_input,textView_result,textView_refresh,textView_delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configViews();
        configMap();
    }

    public void button_clicked(View v){
        TextView t = (TextView)v;
        final Category category = hashMap.get(t.getText().toString());
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        final EditText editText = new EditText(getApplicationContext());
        editText.setTextColor(getResources().getColor(R.color.colorAccent));
        editText.setInputType(InputType.TYPE_CLASS_NUMBER
                | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        alert.setMessage("Enter Amount");
        alert.setTitle(category.getCategory_name());
        alert.setView(editText);
        alert.setPositiveButton("CALCULATE", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                if (!editText.getText().toString().isEmpty()) {
                    if (input.isEmpty() || input.equals("0.0")) {
                        price = price +
                                Double.parseDouble(editText.getText().toString())
                                        * (1.0 + category.getCategory_rate());
                        price = Math.round(price * 100.0) / 100.0;
                        result = price + "";
                        array[++size] = price;
                        input = editText.getText().toString();
                    } else {
                        price = price +
                                Double.parseDouble(editText.getText().toString())
                                        * (1.0 + category.getCategory_rate());
                        price = Math.round(price * 100.0) / 100.0;
                        result = price + "";
                        array[++size] = price;
                        input = input + " + " + editText.getText().toString();
                    }
                    Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                    textView_input.setText(input);
                    textView_result.setText(result);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Give Some Input",Toast.LENGTH_SHORT).show();
                }
            }
        });
        alert.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
            }
        });
        alert.show();
    }

    public void refresh(View v){
        input = "0.0";result = "0.0";
        textView_input.setText(input);
        textView_result.setText(result);
        price = 0;
        size = -1;
    }

    public void delete(View v){
        if (input.lastIndexOf('+')!=-1){
            input = input.substring(0,input.lastIndexOf('+'));
        }
        else if(price > 0){
            input = "0.0";
            result = "0.0";
        }
        if(size>0) {
            result = array[--size] + "";
            price = array[size];
            textView_input.setText(input);
            textView_result.setText(result);
        }
        else {
            result = "0.0";
            price = 0;
            array[0] = 0;
            textView_input.setText(input);
            textView_result.setText(result);
        }
    }

    private void configViews() {
        Typeface font_awesome = Typeface.createFromAsset(getAssets(),"fontawesome-webfont.ttf");
        textView_input=(TextView)findViewById(R.id.textView_input);
        textView_result=(TextView)findViewById(R.id.textView_result);
        textView_refresh=(TextView)findViewById(R.id.textView_refresh);
        textView_delete=(TextView)findViewById(R.id.textView_delete);
        textView_refresh.setTypeface(font_awesome);
        textView_delete.setTypeface(font_awesome);
        textView_refresh.setText("\uf0e2");
        textView_delete.setText("\uf060");
        i1=(TextView)findViewById(R.id.icon1);
        i2=(TextView)findViewById(R.id.icon2);
        i3=(TextView)findViewById(R.id.icon3);
        i4=(TextView)findViewById(R.id.icon4);
        i5=(TextView)findViewById(R.id.icon5);
        i6=(TextView)findViewById(R.id.icon6);
        i7=(TextView)findViewById(R.id.icon7);
        i8=(TextView)findViewById(R.id.icon8);
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

    private void configMap() {
        hashMap.put(((TextView)findViewById(R.id.icon1)).getText().toString(),new Category("FOOD",0.05));
        hashMap.put(((TextView)findViewById(R.id.icon2)).getText().toString(),new Category("LIQUOR",0.06));
        hashMap.put(((TextView)findViewById(R.id.icon3)).getText().toString(),new Category("ORNAMENTS",0.07));
        hashMap.put(((TextView)findViewById(R.id.icon4)).getText().toString(),new Category("CLOTHING",0.08));
        hashMap.put(((TextView)findViewById(R.id.icon5)).getText().toString(),new Category("SHIPPING",0.09));
        hashMap.put(((TextView)findViewById(R.id.icon6)).getText().toString(),new Category("ELECTRONICS",0.1));
        hashMap.put(((TextView)findViewById(R.id.icon7)).getText().toString(),new Category("DRUGS",0.11));
        hashMap.put(((TextView)findViewById(R.id.icon8)).getText().toString(),new Category("BOOKS",0.12));
    }
}
