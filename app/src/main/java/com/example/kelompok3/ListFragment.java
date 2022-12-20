package com.example.kelompok3;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class ListFragment extends Fragment {
    private String[] dataName;
    private String[] dataDescription;
    private TypedArray dataPhoto;
    private PenyakitAdapter adapter;
    ListView listView;
    private ArrayList<Penyakit> penyakits;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        listView = view.findViewById(R.id.lv_list);
        adapter = new PenyakitAdapter(getContext());
        listView.setAdapter(adapter);
        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View view, int i, long id) {
                if (i == 0) {
                    Intent intent = new Intent(view.getContext(), Influenza.class);
                    startActivity(intent);
                    Toast.makeText(getActivity(), "INFLUENZA", Toast.LENGTH_SHORT).show();
                }
                if (i == 1) {
                    Intent intent = new Intent(view.getContext(), TBC.class);
                    startActivity(intent);
                    Toast.makeText(getActivity(), "TUBERCOLOSIS", Toast.LENGTH_SHORT).show();
                }
                if (i == 2) {
                    Intent intent = new Intent(view.getContext(), Muntaber.class);
                    startActivity(intent);
                    Toast.makeText(getActivity(), "MUNTABER", Toast.LENGTH_SHORT).show();
                }
                if (i == 3) {
                    Intent intent = new Intent(view.getContext(), Tifus.class);
                    startActivity(intent);
                    Toast.makeText(getActivity(), "TIFUS", Toast.LENGTH_SHORT).show();
                }
                if (i == 4) {
                    Intent intent = new Intent(view.getContext(), Pneumenia.class);
                    startActivity(intent);
                    Toast.makeText(getActivity(), "PNEUMENIA", Toast.LENGTH_SHORT).show();
                }
                if (i == 5) {
                    Intent intent = new Intent(view.getContext(), Hepatitis.class);
                    startActivity(intent);
                    Toast.makeText(getActivity(), "HEPATITIS", Toast.LENGTH_SHORT).show();
                }
                if (i == 6) {
                    Intent intent = new Intent(view.getContext(), DBD.class);
                    startActivity(intent);
                    Toast.makeText(getActivity(), "DEMAM BERDARAH", Toast.LENGTH_SHORT).show();
                }
                if (i == 7) {
                    Intent intent = new Intent(view.getContext(), Malaria.class);
                    startActivity(intent);
                    Toast.makeText(getActivity(), "MALARIA", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }

    private void prepare() {
        dataName = getResources().getStringArray(R.array.data_name);
        dataDescription = getResources().getStringArray(R.array.data_description);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
    }

    private void addItem() {
        penyakits = new ArrayList<>();

        for (int i = 0; i < dataName.length; i++) {
            Penyakit penyakit = new Penyakit();
            penyakit.setPhoto(dataPhoto.getResourceId(i, -1));
            penyakit.setName(dataName[i]);
            penyakit.setDescription(dataDescription[i]);
            penyakits.add(penyakit);
        }

        adapter.setPenyakits(penyakits);
    }
}