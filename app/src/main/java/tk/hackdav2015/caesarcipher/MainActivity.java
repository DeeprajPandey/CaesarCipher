package tk.hackdav2015.caesarcipher;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import tk.hackdav2015.caesarcipher.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void encrypt(View view) {

        int key = 0;
        EditText key_field_value = (EditText)findViewById(R.id.key_field);
        if (key_field_value != null) {
            key = Integer.parseInt( key_field_value.getText().toString() );
        }
        else {
            Toast.makeText(this, "You did not enter a key", Toast.LENGTH_SHORT).show();
            return;
        }

        String plainText = "";
        EditText plaintext_field_value = (EditText) findViewById(R.id.plaintext_field);
        if (plaintext_field_value != null) {
            plainText = plaintext_field_value.getText().toString();
        }
        else {
            Toast.makeText(this, "You did not enter text to encrypt", Toast.LENGTH_SHORT).show();
            return;
        }

        String cipherText = encode(plainText, key);

        TextView disp = (TextView) findViewById(R.id.display);
        if(disp != null) {
            disp.setText(cipherText);
        }
        else {
            Toast.makeText(this, "Display TextView is null", Toast.LENGTH_SHORT).show();
        }
    }

    public String encode(String enc, int offset) {
        offset = offset % 26 + 26;
        StringBuilder encoded = new StringBuilder();
        for (char i : enc.toCharArray()) {
            if (Character.isLetter(i)) {
                if (Character.isUpperCase(i)) {
                    encoded.append((char) ('A' + (i - 'A' + offset) % 26 ));
                } else {
                    encoded.append((char) ('a' + (i - 'a' + offset) % 26 ));
                }
            } else {
                encoded.append(i);
            }
        }
        return encoded.toString();
    }
}