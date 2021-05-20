package com.example.homework3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.recyclerview.widget.RecyclerView;

import com.example.homework3.IBM.AnnualEarning;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder>  {
    private List<AnnualEarning> mData;//список данных, которые будем помещать в RecyclerView
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    // передаём данные в конструктор
    MyRecyclerViewAdapter(Context context, List<AnnualEarning> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    // “создает(надувает)” строку(пункт) RecyclerView из xml файла
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.layout, parent, false);
        return new ViewHolder(view);
    }


    // заполняет каждую строк RecyclerView данными
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String date = mData.get(position).getFiscalDateEnding();
        holder.fiscalDateEnding.setText("FiscalDateEnding: " + date);

        String EPS = mData.get(position).getReportedEPS();
        holder.reportedEPS.setText("reportedEPS: " + EPS);
    }

    // общее количество строк
    public int getItemCount() {
        return mData.size();
    }

    // сохраняет и реиспользует view компоненты, когда строка прокручивается(уходит с экрана)
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        EditText fiscalDateEnding;
        EditText reportedEPS;

        ViewHolder(View itemView) {
            super(itemView);
            fiscalDateEnding = itemView.findViewById(R.id.fiscalDateEnding);
            reportedEPS = itemView.findViewById(R.id.reportedEPS);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // получение данных из строки RecyclerView, по которой щелкнули
    String getItem(int id) {
        return mData.get(id).toString();
    }

    // добавление возможности перехата нажатия на кнопку
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    //  Activity будет реализовывать этот метод, щелчек по элементу
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

}
