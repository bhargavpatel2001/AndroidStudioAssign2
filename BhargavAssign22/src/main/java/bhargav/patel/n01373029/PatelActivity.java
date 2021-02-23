//Bhargav Patel N01373029 SectionB

package bhargav.patel.n01373029;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PatelActivity extends AppCompatActivity {

    RadioGroup radiobtnG1;
    RadioGroup radiobtnG2;
    CheckBox check1, check2, check3, check4, check5;
    Button Nextbtn;
    StringBuffer buffer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patel);

        radiobtnG1 = findViewById(R.id.BhargavRGroup2);
        radiobtnG2 = findViewById(R.id.BhargavRGroup3);
        check1 = findViewById(R.id.BhargavPToppings1);
        check2 = findViewById(R.id.BhargavPToppings2);
        check3 = findViewById(R.id.BhargavPToppings3);
        check4 = findViewById(R.id.BhargavPToppings4);
        check5 = findViewById(R.id.BhargavPToppings5);
        buffer = new StringBuffer();
        Nextbtn = findViewById(R.id.BhargavMvScreen2);

        //recieves data from previous Activity
        ImageView img = findViewById(R.id.BhargavImage2);
        TextView textName = findViewById(R.id.BhargavTV2);
        Intent intent = getIntent();
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            int textId = bundle.getInt("textId");
            textName.setText(textId);
            int imgId = bundle.getInt("imgId");
            img.setImageResource(imgId);


        }
        // On clicking the NExt button
        Nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validation();

            }
        });

    }

    public void validation() {
        // getCheckedRadioButton()  will return 1 if no buttons are checked return 0>

        int isSelected = radiobtnG1.getCheckedRadioButtonId();
        int isSelected2 = radiobtnG2.getCheckedRadioButtonId();

        RadioButton rb1 = (RadioButton) findViewById(R.id.BhargavPType1);
        RadioButton rb2 = (RadioButton) findViewById(R.id.BhargavPType2);
        RadioButton rb3 = (RadioButton) findViewById(R.id.BhargavPType3);

        RadioButton radioB1 = (RadioButton) findViewById(R.id.BhargavPSize1);
        RadioButton radioB2 = (RadioButton) findViewById(R.id.BhargavPSize2);
        RadioButton radioB3 = (RadioButton) findViewById(R.id.BhargavPSize3);

        if (rb1.isChecked()) {
            buffer.append(rb1.getText() + "\n");
        }
        if (rb2.isChecked()) {
            buffer.append(rb1.getText() + "\n");
        }
        if (rb3.isChecked()) {
            buffer.append(rb1.getText() + "\n");
        }
        if (radioB1.isChecked()) {
            buffer.append(radioB1.getText() + "\n");
        }
        if (radioB2.isChecked()) {
            buffer.append(radioB2.getText() + "\n");
        }
        if (radioB3.isChecked()) {
            buffer.append(radioB3.getText() + "\n");
        }
        if (check1.isChecked()) {
            buffer.append(check1.getText() + "\n");
        }
        if (check2.isChecked()) {
            buffer.append(check2.getText() + "\n");
        }
        if (check3.isChecked()) {
            buffer.append(check3.getText() + "\n");
        }
        if (check4.isChecked()) {
            buffer.append(check4.getText() + "\n");
        }
        if (check5.isChecked()) {
            buffer.append(check5.getText() + "\n");
        }

        if (isSelected == -1) {

            Toast.makeText(PatelActivity.this, "Select one of the Pizza Types", Toast.LENGTH_SHORT).show();
        } else if (isSelected2 == -1) {

            Toast.makeText(PatelActivity.this, "Select one of the Pizza Size", Toast.LENGTH_SHORT).show();
        } else if (!check1.isChecked() && !check2.isChecked() && !check3.isChecked() && !check4.isChecked() && !check5.isChecked()) {

            Toast.makeText(PatelActivity.this, "Select one of the Pizza Toppings", Toast.LENGTH_SHORT).show();
        } else {
            String send = buffer.toString();
            Intent intent = new Intent(PatelActivity.this, PatelActivity2.class);
            intent.putExtra("Code2", send);

            startActivity(intent);
        }

    }

    }
