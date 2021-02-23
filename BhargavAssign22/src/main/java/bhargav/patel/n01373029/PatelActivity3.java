//Bhargav Patel N01373029 SectionB
package bhargav.patel.n01373029;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.util.Calendar;

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
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MINUTE, 1000);
        String timer = cal.getTime().toString();

        int random = getRandomNumber(1000, 9999);


    }
    public int getRandomNumber ( int a, int z)
    {
        return (int) ((Math.random() * (z - a)) + a);
    }

        @Override
    public void onBackPressed(){
        AlertDialog alertDialog = new AlertDialog.Builder(PatelActivity3.this).create();
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


