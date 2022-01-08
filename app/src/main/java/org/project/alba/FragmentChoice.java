package org.project.alba;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class FragmentChoice extends Fragment {
    /*public interface EditTextListener {
        void getEditText(EditText et1, EditText et2, EditText et3);
    }
    private EditTextListener editTextListener;*/
    WorkInfo workInfo;
    EditText editText1;
    EditText editText2;
    EditText editText3;
    /*@Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof EditTextListener) {
            this.editTextListener = (EditTextListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement EditTextListener");
        }
    }*/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_choice, container, false);

        workInfo = new WorkInfo();

        editText1 = rootView.findViewById(R.id.editText);
        editText2 = rootView.findViewById(R.id.editText2);
        editText3 = rootView.findViewById(R.id.editText3);

        //editTextListener.getEditText(editText1, editText2, editText3);
        /*workInfo.setEditText1(rootView.findViewById(R.id.editText));
        workInfo.setEditText2(rootView.findViewById(R.id.editText2));
        workInfo.setEditText3(rootView.findViewById(R.id.editText3));*/
        return rootView;
    }

    public EditText getEditText1() {
        return editText1;
    }





    /*@Override
    public void onDetach() {
        super.onDetach();
        editTextListener = null;
    }*/
}
