package buiduyanh.fpoly.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class Bai1 extends AppCompatActivity {






        private EditText editTextSearch;
        private Button buttonSearch;
        private ListView listViewSearchResults;
        private MyDatabaseHelper dbHepler;
        private ArrayList<PhieuMuon> searchResults;
        private SearchAdapter searchAdapter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_search);

            editTextSearch = findViewById(R.id.editTextSearch);
            buttonSearch = findViewById(R.id.buttonSearch);
            listViewSearchResults = findViewById(R.id.listViewSearchResults);
            dbHepler = new MyDatabaseHelper(this);
            searchResults = new ArrayList<>();
            searchAdapter = new SearchAdapter(this, searchResults);
            listViewSearchResults.setAdapter(searchAdapter);

            buttonSearch.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String pageNumberStr = editTextSearch.getText().toString().trim();
                    if (!pageNumberStr.isEmpty()) {
                        int pageNumber = Integer.parseInt(pageNumberStr);
                        searchPhieuMuonByPage(pageNumber);
                    } else {
                        Toast.makeText(SearchActivity.this, "Vui lòng nhập số trang", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            listViewSearchResults.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    PhieuMuon selectedPhieuMuon = searchResults.get(position);
                    // Xử lý khi người dùng chọn phiếu mượn từ kết quả tìm kiếm
                    // Ví dụ: chuyển sang màn hình chi tiết phiếu mượn
                }
            });
        }

        private void searchPhieuMuonByPage(int pageNumber) {
            SQLiteDatabase sqLite = dbHepler.getWritableDatabase();
            searchResults.clear();

            Cursor cursor = sqLite.rawQuery("SELECT * FROM PhieuMuon WHERE SoTrang = " + pageNumber, null);
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                do {
                    PhieuMuon phieuMuon = new PhieuMuon();
                    // Đọc dữ liệu từ con trỏ Cursor và tạo đối tượng PhieuMuon
                    // Gán các thông tin của phiếu mượn vào đối tượng phieuMuon

                    searchResults.add(phieuMuon);
                } while (cursor.moveToNext());
            }

            searchAdapter.notifyDataSetChanged();
            cursor.close();
        }
    }
}