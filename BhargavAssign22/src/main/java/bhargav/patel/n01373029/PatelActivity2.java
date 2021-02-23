package bhargav.patel.n01373029;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class PatelActivity2 extends AppCompatActivity {

    EditText textInputUsername;
    EditText textInputAddress;
    EditText textInputCCard;
    Spinner spinner;
    Button btnNext;
    String InputUserName;
    String InputAddress;
    String InputCCard;
    String spinnerUse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activiy_patel2);

// Finding Edit Text and Spinner by find View By ID
        textInputUsername = findViewById(R.id.BhargavName);
        textInputAddress = findViewById(R.id.BhargavAddress);
        textInputCCard = findViewById(R.id.BhargavCcard);
        spinner = findViewById(R.id.BhargavSpinner);
        btnNext = findViewById(R.id.BhargavMvScreen3);

        // Reciever information from the order Screen
        TextView textName2 = findViewById(R.id.BhargavTV3);

        Intent intent = getIntent();
        Bundle bundle = getIntent().getExtras();
        if (intent != null);{
            String text2 = intent.getStringExtra("Code2");
            textName2.setText(text2);
        }

        // Labeling spinner and using a string to make a Spinner from the strings.xml file

        spinner = (Spinner) findViewById(R.id.BhargavSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        //Validating UserName

        textInputUsername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (textInputUsername.getText().toString().length() <= 3){
                    textInputUsername.setError("Please have more then 3 Letters");
                }
                else if(textInputUsername.getText().toString().contains("0")){
                    textInputUsername.setError("Please do not user Numbers, only Letters");
                }
                else if(textInputUsername.getText().toString().contains("1")) {
                    textInputUsername.setError("Please do not user Numbers, only Letters");
                }
                else if(textInputUsername.getText().toString().contains("2")) {
                    textInputUsername.setError("Please do not user Numbers, only Letters");
                }
                else if(textInputUsername.getText().toString().contains("3")) {
                    textInputUsername.setError("Please do not user Numbers, only Letters");
                }
                else if(textInputUsername.getText().toString().contains("4")) {
                    textInputUsername.setError("Please do not user Numbers, only Letters");
                }
                else if(textInputUsername.getText().toString().contains("5")) {
                    textInputUsername.setError("Please do not user Numbers, only Letters");
                }
                else if(textInputUsername.getText().toString().contains("6")) {
                    textInputUsername.setError("Please do not user Numbers, only Letters");
                }
                else if(textInputUsername.getText().toString().contains("7")) {
                    textInputUsername.setError("Please do not user Numbers, only Letters");
                }
                else if(textInputUsername.getText().toString().contains("8")) {
                    textInputUsername.setError("Please do not user Numbers, only Letters");
                }
                else if(textInputUsername.getText().toString().contains("9")) {
                    textInputUsername.setError("Please do not user Numbers, only Letters");
                }

                else{
                    textInputUsername.setError(null);
                }
            }
        });

        textInputCCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textInputCCard.getText().toString().length() == 16){
                    textInputCCard.setError(null);
                }
                else{
                    textInputCCard.setError("Please have 16 numbers");
                }
            }
        });

        textInputAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textInputAddress.getText().toString().length() <= 0){
                    textInputAddress.setError("Please fill the Address field");
                }
                else{
                    textInputAddress.setError(null);
                }
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                spinnerUse = spinner.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                if(spinner.equals("Select your Province")){
                    Toast.makeText(PatelActivity2.this, "Select a Provience", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textInputUsername.length() >= 3 && textInputCCard.length() == 16){

                    InputUserName = textInputUsername.getText().toString();
                    InputAddress = textInputAddress.getText().toString();
                    InputCCard = textInputCCard.getText().toString();

                    Intent intent = new Intent(PatelActivity2.this, PatelActivity3.class);
                    intent.putExtra("password",InputUserName);
                    intent.putExtra("password2",InputAddress);
                    intent.putExtra("password3",InputCCard);
                    intent.putExtra("password4",spinnerUse);
                    startActivity(intent);

                }
            }
        });

    }
    @Override
    public void onBackPressed(){
        AlertDialog alertDialog = new AlertDialog.Builder(PatelActivity2.this).create();
        alertDialog.setTitle("Really Exit?");
        alertDialog.setMessage("Are you sure you want to exit?");
        alertDialog.setCancelable(false);
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Intent.ACTION_MAIN);
                        intent.addCategory(intent.CATEGORY_HOME);
                        startActivity(intent);
                    }
                });

        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "No",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        {
                            dialog.cancel();
                        }
                    }
                });

        alertDialog.show();
    }

}
