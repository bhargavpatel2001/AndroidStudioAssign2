package bhargav.patel.n01373029;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class PatelActivity2 extends AppCompatActivity {

    EditText textInputUsername;
    EditText textInputAddress;
    EditText textInputCCard;
    Spinner spinner;

    RadioGroup Radiobtn1_Reciever;
    RadioGroup Radiobtn2_Reciever;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activiy_patel2);

        TextView textName2 = findViewById(R.id.BhargavTV3);
        Intent intent = getIntent();
        Bundle bundle = getIntent().getExtras();
        if (bundle != null);{
            String text2 = bundle.getString("Code");
            textName2.setText(text2);
        }

        spinner = (Spinner) findViewById(R.id.BhargavSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        textInputUsername = findViewById(R.id.BhargavName);
        textInputAddress = findViewById(R.id.BhargavAddress);
        textInputCCard = findViewById(R.id.BhargavCcard);
    }
}

//    public Boolean validateUsername() {
//        String userName = textInputUsername.getText().toString().trim();
//
//        if (userName.isEmpty()) {
//            textInputUsername.setError("Username field needs to be filled");
//            return false;
//        } else if (userName.length() < 3) {
//            textInputUsername.setError("Username is too small");
//            return false;
//        } else {
//            textInputUsername.setError(null);
//            return true;
//        }
//    }
//
//    public Boolean validateAddress() {
//        String address = textInputAddress.getText().toString().trim();
//
//        if (address.isEmpty()) {
//            textInputAddress.setError("Address field needs to be filled");
//            return false;
//        } else {
//            textInputAddress.setError(null);
//            return true;
//        }
//    }
//
//        public Boolean validateCreditCard() {
//            String CreditCard = textInputCCard.getText().toString().trim();
//
//            if (CreditCard.isEmpty()) {
//                textInputCCard.setError("CreditCard field needs to be filled");
//                return false;
//            } else if (CreditCard.length() != 16) {
//                textInputCCard.setError("Invalid Credit Card Number");
//                return false;
//            } else {
//                textInputCCard.setError(null);
//                return true;
//            }
//        }
//
//            public void confirmInput (View v){
//                if (!validateUsername() | !validateAddress() | !validateCreditCard()){
//                    return;
//            }
//
//            String input = "Username:" +  textInputUsername.getText().toString();
//                input += "\n";
//                input = "Address:" +  textInputAddress.getText().toString();
//                input += "\n";
//                input = "CreditCardNumber:" +  textInputCCard.getText().toString();
//
//                Toast.makeText(PatelActivity2.this, input, Toast.LENGTH_SHORT).show();
//
//
//        }
//}
