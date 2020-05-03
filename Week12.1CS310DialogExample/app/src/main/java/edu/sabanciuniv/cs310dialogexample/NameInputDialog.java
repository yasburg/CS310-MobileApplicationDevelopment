package edu.sabanciuniv.cs310dialogexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class NameInputDialog extends DialogFragment {

    EditText txtname;
    Button btnOk;
    NameInputDialogListener listener;

    public NameInputDialog(NameInputDialogListener listener) {
        this.listener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.name_dialog_layout,container,false);
        txtname = v.findViewById(R.id.txtname);
        btnOk = v.findViewById(R.id.btnokname);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.nameEntered(txtname.getText().toString());
                dismiss();
            }
        });


        return v;
    }

    public interface NameInputDialogListener{
        public void nameEntered(String name);
    }
}
