package th.ac.tu.siit.cholwich.lab1exercise2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculate(View v) {
        EditText etInput = (EditText) findViewById(R.id.etInput);
        String s = etInput.getText().toString();
        double input = Double.parseDouble(s);

        TextView out = (TextView)findViewById(R.id.tvOutput);

        RadioGroup rgFrom = (RadioGroup) findViewById(R.id.rgFrom);
        int selFrom = rgFrom.getCheckedRadioButtonId();

        RadioGroup rgTo = (RadioGroup) findViewById(R.id.rgTo);
        int selTo = rgTo.getCheckedRadioButtonId();

        if (selFrom == R.id.rbFrmC) { //The user wants to convert from Celsius.

            if (selTo == R.id.rbToC) {
                out.setText(Double.toString(input));
            }
            else if (selTo == R.id.rbToF) {
                input = input * (9.0/5.0) + 32;
                out.setText(Double.toString(input));
            }
            else if (selTo == R.id.rbToK) {
                input = input + 273.15;
                out.setText(Double.toString(input));
            }
        }

        else if (selFrom == R.id.rbFrmF) {

            if (selTo == R.id.rbToC) {
                input = (input-32) * (5.0/9.0);
                out.setText(Double.toString(input));
            }
            else if (selTo == R.id.rbToF) {
                out.setText(Double.toString(input));
            }
            else if (selTo == R.id.rbToK) {
                input = (input+459.67)*(5.0/9.0);
                out.setText(Double.toString(input));
            }
        }

        else if (selFrom == R.id.rbFrmK) {

            if (selTo == R.id.rbToC) {
                input = input - 273.15;
                out.setText(Double.toString(input));
            }
            else if (selTo == R.id.rbToF) {
                input = input * (5/9) - 459.67;
                out.setText(Double.toString(input));
            }
            else if (selTo == R.id.rbToK) { 
                out.setText(Double.toString(input));
            }
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
