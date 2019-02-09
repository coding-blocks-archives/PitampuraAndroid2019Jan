package com.codingblocks.listviewcustomadapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentAdapter extends BaseAdapter {

    private ArrayList<Student> students = new ArrayList<>();
    private Context ctx;

    StudentAdapter(ArrayList<Student> studentArrayList, Context context) {
        students = studentArrayList;
        ctx = context;
    }

    //I should return the number of items to be displayed
    @Override
    public int getCount() {
        return students.size();
    }

    //Get the student at `i`th position
    @Override
    public Student getItem(int position) {
        return students.get(position);
    }

    //Used to identify and tag heterogeneous layouts, DO NOT MODIFY if you are not using heterogeneous layouts
    @Override
    public long getItemId(int position) {

        return 0;

//        if (getItem(position) instanceof ImageMessageIncoming) {
//            return 0;
//        } else if (getItem(position) instanceof TextMessageIncoming) {
//            return 1;
//        } else if (getItem(position) instanceof TextMessageOutGoing) {
//            return 2;
//        }
//
//        return -1;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Student currentStudent = getItem(position);

        View inflatedView;

        //initialize inflatedView by inflating the content of item_row.xml and set some data to it

        LayoutInflater layoutInflater = (LayoutInflater)
                ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //If the third param is true, the view will be attached to the parent immediately, else you
        //will have to call `parent.addView()` manually to attach it.

        inflatedView = layoutInflater.inflate(R.layout.item_row, parent, false);

        TextView tvName, tvSurName, tvBatch;

        tvName = inflatedView.findViewById(R.id.tvName);
        tvSurName = inflatedView.findViewById(R.id.tvSurname);
        tvBatch = inflatedView.findViewById(R.id.tvBatch);

        tvName.setText(currentStudent.getName());
        tvSurName.setText(currentStudent.getSurname());
        tvBatch.setText(currentStudent.getBatch());

        return inflatedView;
    }
}
