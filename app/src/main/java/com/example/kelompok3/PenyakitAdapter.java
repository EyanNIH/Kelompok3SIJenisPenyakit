package com.example.kelompok3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PenyakitAdapter extends BaseAdapter {
    private final Context context;
    private ArrayList<Penyakit> penyakits;

    public void setPenyakits(ArrayList<Penyakit> penyakits) {
        this.penyakits = penyakits;
    }

    public PenyakitAdapter (Context context) {
        this.context = context;
        penyakits = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return penyakits.size();
    }

    @Override
    public Object getItem(int i) {
        return penyakits.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.fragment_list, viewGroup, false);
        }
        ViewHolder viewHolder = new ViewHolder(view);
        Penyakit penyakit = (Penyakit) getItem(i);
        viewHolder.bind(penyakit);
        return view;
    }

    private class ViewHolder {
        private TextView txtName;
        private TextView txtDescription;
        private ImageView imgPhoto;

        ViewHolder(View view) {
            txtName = view.findViewById(R.id.txt_name);
            txtDescription = view.findViewById(R.id.txt_description);
            imgPhoto = view.findViewById(R.id.img_photo);
        }

        void bind(Penyakit penyakit) {
            txtName.setText(penyakit.getName());
            txtDescription.setText(penyakit.getDescription());
            imgPhoto.setImageResource (penyakit.getPhoto());
        }
    }
}
