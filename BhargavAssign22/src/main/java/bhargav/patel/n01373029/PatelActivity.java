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
    String text2;
    String text3;
    String text4;

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


        if (isSelected == -1) {

            Toast.makeText(PatelActivity.this, "Select one of the Pizza Types", Toast.LENGTH_SHORT).show();

            rb1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    text2 = "Margherita";
                }
            });

            rb2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    text2 = "Pepperoni";
                }
            });

            rb3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    text2 = "Cheese";
                }
            });

            return;
        }

        if (isSelected2 == -1) {

            Toast.makeText(PatelActivity.this, "Select one of the Pizza Size", Toast.LENGTH_SHORT).show();

            radioB1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    text3 = "Small";
                }
            });

            radioB2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    text3 = "Medium";
                }
            });
            radioB3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    text3 = "Large";
                }
            });
            return;
        }

        if (!check1.isChecked() && !check2.isChecked() && !check3.isChecked() && !check4.isChecked() && !check5.isChecked()) {

            Toast.makeText(PatelActivity.this, "Select one of the Pizza Toppings", Toast.LENGTH_SHORT).show();
        }
            if (check1.isChecked()) {
                text4 = "Black Olives";
            }
            if (check2.isChecked()) {
                text4 = "Green Peppers";
            }
            if (check3.isChecked()) {
                text4 = "Mushrooms";
            }
            if (check4.isChecked()) {
                text4 = "Jalapenos";
            }
            if (check5.isChecked()) {
                text4 = "Extra Cheese";
            }
        Intent intent = new Intent(PatelActivity.this, PatelActivity2.class);
        intent.putExtra("Code2", text2);
        intent.putExtra("Code3", text3);
        intent.putExtra("Code4", text4);
        startActivity(intent);
        }

    }
