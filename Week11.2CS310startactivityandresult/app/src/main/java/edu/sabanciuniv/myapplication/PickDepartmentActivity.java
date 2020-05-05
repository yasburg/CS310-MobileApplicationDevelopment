package edu.sabanciuniv.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class PickDepartmentActivity extends AppCompatActivity {

    Spinner spDepartment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_department);
        spDepartment = findViewById(R.id.spDepartment);

        ArrayAdapter<Department> adp = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,Department.getAllDepartments());

        spDepartment.setAdapter(adp);

    }

    public void selectClicked(View v){


        Department selectedDepartment = (Department) spDepartment.getSelectedItem();
        Intent i = new Intent(this, RegistrationActivity.class);
        i.putExtra("dept",selectedDepartment);
        setResult(RESULT_OK,i);
        finish();
    }
}
