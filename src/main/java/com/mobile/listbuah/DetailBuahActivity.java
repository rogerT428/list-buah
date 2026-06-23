package com.mobile.listbuah;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.List;

/**
 * Halaman detail buah.
 * Menampilkan: gambar/emoji buah, nama, asal, rasa, deskripsi, manfaat kesehatan.
 */
public class DetailBuahActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_buah);

        // Ambil data dari Intent
        String nama      = getIntent().getStringExtra("nama");
        String emoji     = getIntent().getStringExtra("emoji");
        String asal      = getIntent().getStringExtra("asal");
        String rasa      = getIntent().getStringExtra("rasa");
        String deskripsi = getIntent().getStringExtra("deskripsi");
        List<String> manfaat = getIntent().getStringArrayListExtra("manfaat");

        // Setup Toolbar dengan tombol back
        Toolbar toolbar = findViewById(R.id.toolbarDetail);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Detail: " + nama);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        // Tampilkan emoji buah (besar di kartu putih)
        TextView tvEmoji = findViewById(R.id.tvDetailEmoji);
        tvEmoji.setText(emoji);

        // Tampilkan nama buah
        TextView tvNama = findViewById(R.id.tvDetailNama);
        tvNama.setText(nama);

        // Tampilkan asal
        TextView tvAsal = findViewById(R.id.tvDetailAsal);
        tvAsal.setText(asal);

        // Tampilkan rasa
        TextView tvRasa = findViewById(R.id.tvDetailRasa);
        tvRasa.setText(rasa);

        // Tampilkan deskripsi
        TextView tvDeskripsi = findViewById(R.id.tvDetailDeskripsi);
        tvDeskripsi.setText(deskripsi);

        // Tambahkan manfaat kesehatan secara dinamis (bullet points)
        LinearLayout containerManfaat = findViewById(R.id.containerManfaat);
        if (manfaat != null) {
            for (String item : manfaat) {
                TextView tvItem = new TextView(this);
                tvItem.setText("• " + item);
                tvItem.setTextSize(14f);
                tvItem.setTextColor(0xFF212121);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                params.setMargins(0, 8, 0, 8);
                tvItem.setLayoutParams(params);
                containerManfaat.addView(tvItem);
            }
        }
    }

    // Tombol back di toolbar
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
