//Bhargav Patel N01373029 SectionB

package bhargav.patel.n01373029;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class BhargavActivity extends AppCompatActivity {
Intent intent = null;
String webs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        RadioButton pizzaLc=findViewById(R.id.BhargavStore1);
        RadioButton pizzaB=findViewById(R.id.BhargavStore2);
        RadioButton pizzaP=findViewById(R.id.BhargavStore3);

        pizzaLc.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                menu.findItem(R.id.BhargavImage).setIcon(R.mipmap.little_caesars_pizza_round);
                            webs="https://littlecaesars.ca";
            }
        });

        pizzaB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menu.findItem(R.id.BhargavImage).setIcon(R.mipmap.boston_pizza_round);
                            webs="https://bostonpizza.com";

            }
        });

        pizzaP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menu.findItem(R.id.BhargavImage).setIcon(R.mipmap.pizza_pizza_round);
                            webs="https://www.pizzapizza.ca";
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
            case R.id.BhargavHelp:
                Toast toast = Toast.makeText(getApplicationContext(), "Tell your friend to get the app and ask them",
                        Toast.LENGTH_LONG);
                toast.show();
                intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.facebook.com"));
                startActivity(intent);
                break;

            case R.id.BhargavImage:
                Toast.makeText(this, "This is the original website for your pizza store selected", Toast.LENGTH_LONG).show();
                intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse(webs));
                startActivity(intent);

                break;

            case R.id.BhargavAddons:
                Toast.makeText(this, "Please do not click this and wake me up", Toast.LENGTH_LONG).show();
                break;

            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

}



