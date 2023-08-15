package buiduyanh.fpoly.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Bai3 extends AppCompatActivity {

    private EditText editTextNumber1;
    private EditText editTextNumber2;
    private EditText editTextOperator;
    private Button buttonCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3);

        // Ánh xạ các thành phần trong layout
        editTextNumber1 = findViewById(R.id.editTextNumber1);
        editTextNumber2 = findViewById(R.id.editTextNumber2);
        editTextOperator = findViewById(R.id.editTextOperator);
        buttonCalculate = findViewById(R.id.buttonCalculate);

        // Gắn sự kiện click cho nút Kết quả
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy giá trị từ EditText
                String number1Str = editTextNumber1.getText().toString();
                String number2Str = editTextNumber2.getText().toString();
                String operator = editTextOperator.getText().toString();

                // Kiểm tra nếu không nhập đủ thông tin
                if (number1Str.isEmpty() || number2Str.isEmpty() || operator.isEmpty()) {
                    Toast.makeText(Bai3.this, "Vui lòng nhập đủ thông tin", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Chuyển đổi chuỗi
                double number1 = Double.parseDouble(number1Str);
                double number2 = Double.parseDouble(number2Str);
                double result = 0;

                // Thực hiện phép tính dựa vào phép toán nhập vào
                switch (operator) {
                    case "+":
                        result = number1 + number2;
                        break;
                    case "-":
                        result = number1 - number2;
                        break;
                    case "x":
                        result = number1 * number2;
                        break;
                    case ":":
                        if (number2 == 0) {
                            Toast.makeText(Bai3.this, "Không thể chia cho 0", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        result = number1 / number2;
                        break;
                    default:
                        Toast.makeText(Bai3.this, "Phép tính không hợp lệ", Toast.LENGTH_SHORT).show();
                        return;
                }

                // Hiển thị kết quả
                Toast.makeText(Bai3.this, "Kết quả: " + result, Toast.LENGTH_SHORT).show();
            }
        });
    }
}