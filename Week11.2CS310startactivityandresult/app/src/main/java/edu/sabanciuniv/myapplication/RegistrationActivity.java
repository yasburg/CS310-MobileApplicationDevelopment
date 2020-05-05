package edu.sabanciuniv.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class RegistrationActivity extends AppCompatActivity {
    EditText txtName;
    EditText txtLastname;
    public static final int SELECT_DEPARTMENT = 0;

    TextView txtDept;
    Department selectedDept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        txtName = findViewById(R.id.txtName);
        txtLastname = findViewById(R.id.txtLastName);
        txtDept = findViewById(R.id.txtSelectedDept);

    }


    public void pickDepartment(View v){

        Intent i = new Intent(this,PickDepartmentActivity.class);

        startActivityForResult(i,SELECT_DEPARTMENT);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==SELECT_DEPARTMENT){
            if(resultCode == RESULT_OK){

                selectedDept =  (Department) data.getSerializableExtra("dept");
                txtDept.setText(selectedDept.getName());

            }

        }

    }

    public void toResultClicked(View v){

        Client client = new Client(txtName.getText().toString(),txtLastname.getText().toString(),selectedDept);

        Intent i = new Intent(this, ResultActivity.class);
        i.putExtra("client",client);
        startActivity(i);

    }
}
