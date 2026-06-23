package com.mobile.listbuah;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Adapter untuk ListView buah-buahan.
 * Menampilkan emoji + nama buah di setiap baris.
 * Dilengkapi animasi slide-in saat pertama kali tampil.
 */
public class BuahAdapter extends ArrayAdapter<Buah> {

    private final Context context;
    private final List<Buah> buahList;
    private int lastPosition = -1;

    public BuahAdapter(Context context, List<Buah> buahList) {
        super(context, R.layout.item_buah, buahList);
        this.context = context;
        this.buahList = buahList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.item_buah, parent, false);
            holder = new ViewHolder();
            holder.tvEmoji = convertView.findViewById(R.id.tvBuahEmoji);
            holder.tvNama  = convertView.findViewById(R.id.tvBuahNama);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Buah buah = buahList.get(position);
        holder.tvEmoji.setText(buah.getEmoji());
        holder.tvNama.setText(buah.getNama());

        // Animasi slide dari kiri untuk setiap item baru yang muncul
        if (position > lastPosition) {
            android.view.animation.Animation anim =
                    AnimationUtils.loadAnimation(context, R.anim.slide_in_item);
            convertView.startAnimation(anim);
            lastPosition = position;
        }

        return convertView;
    }

    static class ViewHolder {
        TextView tvEmoji;
        TextView tvNama;
    }
}
