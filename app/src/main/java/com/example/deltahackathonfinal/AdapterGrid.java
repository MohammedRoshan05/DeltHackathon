package com.example.deltahackathonfinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;

public class AdapterGrid extends ArrayAdapter<Cells> {

    ArrayList<Cells> cellsArrayList;
    Context context;
    private int tile_clr[];
    public AdapterGrid(ArrayList<Cells> cellsArrayList, Context context) {
        super(context,R.layout.grid_item,cellsArrayList);
        this.cellsArrayList = cellsArrayList;
        this.context = context;
        this.tile_clr = new int[cellsArrayList.size()];
        for(int i = 0; i < tile_clr.length;i++){
            tile_clr[i] = R.drawable.square_corner;
        }
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        Cells cell = getItem(position);
        myViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new myViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent, false);
            viewHolder.layout = (ConstraintLayout) convertView.findViewById(R.id.tile);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (myViewHolder) convertView.getTag();
        }
        viewHolder.layout.setBackgroundColor(tile_clr[position]);
        return convertView;
    }

    private static class myViewHolder{
        ConstraintLayout layout;
    }
    public int getColor(int position){
        return tile_clr[position];
    }

    public void updateColor(int position,int tile_colour){
        tile_clr[position] = tile_colour;
        notifyDataSetChanged();
    }

}
