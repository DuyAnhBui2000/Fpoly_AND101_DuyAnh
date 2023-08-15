package buiduyanh.fpoly.lab_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

import java.net.URL;
import java.util.List;

public class Test extends AppCompatActivity {

    private TextView rssTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        rssTextView = findViewById(R.id.rssTextView);

        // Đường dẫn URL của RSS feed
        String rssUrl = "https://thanhnien.vn/rss/tieu-dung-thong-minh.rss";

        // Khởi chạy AsyncTask để đọc RSS feed
        ReadRssTask readRssTask = new ReadRssTask();
        readRssTask.execute(rssUrl);
    }

    private class ReadRssTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);
                SyndFeedInput input = new SyndFeedInput();
                SyndFeed feed = input.build(new XmlReader(url));

                StringBuilder result = new StringBuilder();
                List<SyndEntry> entries = feed.getEntries();
                for (SyndEntry entry : entries) {
                    result.append("Title: ").append(entry.getTitle()).append("\n");
                    result.append("Link: ").append(entry.getLink()).append("\n");
                    result.append("Published Date: ").append(entry.getPublishedDate()).append("\n");
                    result.append("\n");
                }

                return result.toString();
            } catch (Exception e) {
                e.printStackTrace();
                return "Error reading RSS feed.";
            }
        }

        @Override
        protected void onPostExecute(String result) {
            rssTextView.setText(result);
        }
    }
}