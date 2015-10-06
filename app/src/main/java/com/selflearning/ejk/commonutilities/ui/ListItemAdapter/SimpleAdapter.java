package com.selflearning.ejk.commonutilities.ui.ListItemAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Custom ArrayAdapter for the Object
 *
 * @author Erik-Jan Krielen ej.krielen@euphoria-it.nl
 * @since 17-9-2015 Creation of this file
 */
public class SimpleAdapter extends ArrayAdapter<Object> {

    private final Context context;

    public SimpleAdapter(Context context, int resourceId){
        super(context, resourceId);
        this.context = context;

    }

    private class ViewHolder {
        // Declare all views that need to be set
        TextView textView;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        Object object = getItem(position);

        if (view == null) {
            view = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
            holder = new ViewHolder();
            holder.textView = (TextView) view.findViewById(android.R.id.text1);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        if (object != null) {
            holder.textView.setText(object.toString());
        }

        return view;
    }



}