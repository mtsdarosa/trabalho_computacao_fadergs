package com.example.appcupom;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class AdapterCupom extends BaseAdapter {

    private List<Cupom> cupomList;
    private Context context;
    private LayoutInflater inflater;

    public AdapterCupom(Context context, List<Cupom> listaCupons){
        this.cupomList = listaCupons;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return cupomList.size();
    }

    @Override
    public Object getItem(int position) {
        return cupomList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return cupomList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemSuporte item;

        if (convertView == null){
            convertView = inflater.inflate(R.layout.layout_lista, null);

            item = new ItemSuporte();
            item.tvCodigoCupom = convertView.findViewById(R.id.tvListaCodigoCupom);
            item.tvDataValidade = convertView.findViewById(R.id.tvListaDataValidade);
            item.tvValorDesconto = convertView.findViewById(R.id.tvListaValorDescono);
            item.layout = convertView.findViewById(R.id.llFundoLista);
            convertView.setTag(item);
        }else{
            item = (ItemSuporte) convertView.getTag();
        }

        Cupom cupom = cupomList.get(position);
        item.tvCodigoCupom.setText(cupom.getCodigoCupom());
        item.tvDataValidade.setText(cupom.getDataValidade().toString());
        item.tvValorDesconto.setText(String.valueOf(cupom.getValorDesconto()));

        return convertView;
    }

    private class ItemSuporte{
        TextView tvCodigoCupom, tvDataValidade, tvValorDesconto;
        LinearLayout layout;
    }
}
