//Bhargav Patel N01373029 SectionB

package bhargav.patel.n01373029;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class BhargavActivity extends AppCompatActivity {
    String webs;
    int text;
    int img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button)findViewById(R.id.BhargavMvScreen);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BhargavActivity.this, PatelActivity.class);
                intent.putExtra("textId",text);
                intent.putExtra("imgId",img);
                startActivity(intent);
            }
        });
    }

    // Function onPrepareOptionsMenu
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        // Defining Radio Buttons
        RadioButton pizzaLc = findViewById(R.id.BhargavStore1);
        RadioButton pizzaB = findViewById(R.id.BhargavStore2);
        RadioButton pizzaP = findViewById(R.id.BhargavStore3);

        menu.findItem(R.id.BhargavImage).setVisible(false);

        // First shops setOnClickListener. Basically when they select first radio button and clicks on the image button.
        pizzaLc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menu.findItem(R.id.BhargavImage).setIcon(R.mipmap.little_caesars_pizza_round).setVisible(true);
                text = R.string.Lc_pizza;
                img = R.mipmap.little_caesars_pizza_round;
                webs = "https://littlecaesars.ca";
            }
        });

        // Second shops setOnClickListener. Basically when they select second radio button and clicks on the image button.
        pizzaB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menu.findItem(R.id.BhargavImage).setIcon(R.mipmap.boston_pizza_round).setVisible(true);
                text = R.string.B_pizza;
                img = R.mipmap.boston_pizza_round;
                webs = "https://bostonpizza.com";
            }
        });

        // Third Stores setOnClickListener. Basically when they select third radio button and clicks on the image button.
        pizzaP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menu.findItem(R.id.BhargavImage).setIcon(R.mipmap.pizza_pizza_round).setVisible(true);
                text = R.string.P_pizza;
                img = R.mipmap.pizza_pizza_round;

                webs = "https://www.pizzapizza.ca";
            }
        });
        return super.onPrepareOptionsMenu(menu);
    }

//Menu's OnCreateOptionsMenu Function
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.pizza_menu, menu);
        return true;
    }

    //Menu's onOptionsItemSelected Cases
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = null;
        // Handle item selection
        switch (item.getItemId()) {

            // If the Help button is pressed execute this
            case R.id.BhargavHelp:
                Toast toast = Toast.makeText(getApplicationContext(), "Tell your friend to get the app and ask them",
                        Toast.LENGTH_LONG);
                toast.show();
                intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.facebook.com"));
                startActivity(intent);
                break;

            // If the Image button is pressed execute this
            case R.id.BhargavImage:
                Toast.makeText(this,"This is the original website for your pizza store selected", Toast.LENGTH_LONG).show();
                intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse(webs));
                startActivity(intent);
                break;

            // If the myName button is pressed execute this
            case R.id.BhargavAddons:
                Toast.makeText(this,"Please do not click this and wake me up", Toast.LENGTH_LONG).show();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

//OnBackKeyPressed
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle(R.string.AlertTitle)
                .setMessage(R.string.AlertMsg)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .setNegativeButton("No", null)
                .show();
    }
}




