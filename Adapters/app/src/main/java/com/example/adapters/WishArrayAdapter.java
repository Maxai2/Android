package com.example.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WishArrayAdapter extends BaseAdapter {

    private final Context context;
    private ArrayList<WishItem> wishes = new ArrayList<>();
    private String sign;

    public WishArrayAdapter(Context context, ArrayList<WishItem> wishes, String sign) {
        this.context = context;
        this.wishes = wishes;
        this.sign = sign;
    }

    public boolean changeSign(String sign)
    {
        this.sign = sign;
        return true;
    }


    @Override
    public int getCount() {
        return wishes.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.wish_item, parent, false);

        ImageView img = (ImageView) rowView.findViewById(R.id.img);
        TextView title = (TextView) rowView.findViewById(R.id.title);
        TextView price = (TextView) rowView.findViewById(R.id.price);
        CheckBox isWish = (CheckBox) rowView.findViewById(R.id.isWish);

        isWish.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                wishes.get(position).isWish = isChecked;
            }
        });

        img.setImageResource(wishes.get(position).img);
        title.setText(wishes.get(position).title);
        price.setText(String.valueOf(wishes.get(position).price) + " " +sign);
        isWish.setChecked(wishes.get(position).isWish);

        return rowView;
    }
}
