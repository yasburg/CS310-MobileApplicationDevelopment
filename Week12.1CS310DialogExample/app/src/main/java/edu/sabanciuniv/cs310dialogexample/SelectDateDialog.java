package edu.sabanciuniv.cs310dialogexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class SelectDateDialog extends DialogFragment {

    CalendarView calender;
    Button btnSelect;
    SelectDateListener listener;
    int day;
    int month;
    int year;

    public SelectDateDialog(SelectDateListener listener) {
        this.listener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.calendar_dialog_layout,container,false);
        calender = v.findViewById(R.id.calenderview);
        calender.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                SelectDateDialog.this.day = dayOfMonth;
                SelectDateDialog.this.month = month +1;
                SelectDateDialog.this.year = year;

            }
        });
        btnSelect = v.findViewById(R.id.btnselectdate);
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    listener.dateSelected(day,month,year);
                    dismiss();;
            }
        });

        return v;
    }

    public interface SelectDateListener{
        public void dateSelected(int day, int month, int year);
    }

}
