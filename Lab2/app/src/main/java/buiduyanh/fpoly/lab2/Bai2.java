package buiduyanh.fpoly.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Bai2 extends AppCompatActivity {

    private EditText nameEditText;
    private EditText emailEditText;
    private EditText phoneEditText;
    private RadioButton maleRadioButton;
    private RadioButton femaleRadioButton;
    private CheckBox musicCheckBox;
    private CheckBox sportCheckBox;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);

        nameEditText = findViewById(R.id.name_edit_text);
        emailEditText = findViewById(R.id.email_edit_text);
        phoneEditText = findViewById(R.id.phone_edit_text);
        maleRadioButton = findViewById(R.id.male_radio_button);
        femaleRadioButton = findViewById(R.id.female_radio_button);
        musicCheckBox = findViewById(R.id.music_check_box);
        sportCheckBox = findViewById(R.id.sport_check_box);
        saveButton = findViewById(R.id.save_button);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String phone = phoneEditText.getText().toString();
                String gender = maleRadioButton.isChecked() ? "Nam" : "Nữ";
                String hobbies = "";
                if (musicCheckBox.isChecked()) {
                    hobbies += "Âm nhạc, ";
                }
                if (sportCheckBox.isChecked()) {
                    hobbies += "Thể thao, ";
                }
                if (!hobbies.isEmpty()) {
                    hobbies = hobbies.substring(0, hobbies.length() - 2);
                }

                String message = "Tên: " + name
                        + "\nEmail: " + email
                        + "\nSố điện thoại: " + phone
                        + "\nGiới tính: " + gender
                        + "\nSở thích: " + hobbies;

                Toast.makeText(Bai2.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}