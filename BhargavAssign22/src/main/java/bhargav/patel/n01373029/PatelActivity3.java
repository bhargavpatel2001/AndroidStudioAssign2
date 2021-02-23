package bhargav.patel.n01373029;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class PatelActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activiy_patel3);

        Intent intent = getIntent();
        String inputUserName = intent.getStringExtra("password");
        String inputAddress = intent.getStringExtra("password2");
        String inputCCard = intent.getStringExtra("password3");
        String spinnerUse = intent.getStringExtra("password4");



    }
}


