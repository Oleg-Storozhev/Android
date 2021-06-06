package com.example.homework3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String COLOR = "color";

    // TODO: Rename and change types of parameters

    private String mParam1;
    private String mParam2;
    private int color;
    TextView textView, textView2;

//	Конструкторы фрагментов не рекомендуется переопределять,
//	так как фрагмент может быть уничтожен и восстановлен системой,
//	и если не будет подходящего конструктора, то приложение просто крашнется.

    public BlankFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    //этот метод используют для создания нового фрагмента

    public static BlankFragment newInstance(String param1, String param2, int color) {

        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        // сохраняем данные чтобы передать во фрагмент
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        args.putInt(COLOR, color);
        fragment.setArguments(args);// передаем во фрагмент
        return fragment;

    }

    @Override

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            color = getArguments().getInt(COLOR);
        }

    }

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        // натягиваем layout на фрагмент

        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView = view.findViewById(R.id.text_fragment);
        textView2 = view.findViewById(R.id.text_fragment2);
        textView.setText(mParam1);
        textView2.setText(mParam2);
        view.setBackgroundColor(color);
    }

}