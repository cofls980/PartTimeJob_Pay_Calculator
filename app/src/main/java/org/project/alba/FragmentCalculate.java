package org.project.alba;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.Locale;

public class FragmentCalculate extends Fragment{
    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    TextView textView5;
    EditText editText1;
    EditText editText2;
    EditText editText3;
    CheckBox checkBox1;
    CheckBox checkBox2;
    CheckBox checkBox3;
    CheckBox checkBox4;
    FragmentManager fragmentManager;
    FragmentTransaction trans;

    FragmentChoice fragmentChoice;
    FragmentNotmade fragmentNotmade;
    WorkInfo workInfo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_calculate, container, false);

        fragmentChoice = new FragmentChoice();
        fragmentNotmade = new FragmentNotmade();
        workInfo = new WorkInfo();
        //editText1 = (FragmentChoice) getChildFragmentManager().findFragmentById(R.id.editText);
        LinearLayout test = rootView.findViewById(R.id.test);
        test.setVisibility(View.GONE);
        //getChildFragmentManager().beginTransaction().replace(R.id.container_work_info, fragmentChoice).addToBackStack(null).commit();
        /*fragmentManager = getChildFragmentManager();
        trans = fragmentManager.beginTransaction();
        trans.replace(R.id.container_work_info, fragmentChoice).addToBackStack(null).commit();*/
        workInfo.setTextView1(rootView.findViewById(R.id.textView5));
        workInfo.setTextView2(rootView.findViewById(R.id.textView8));
        workInfo.setTextView3(rootView.findViewById(R.id.textView11));
        workInfo.setTextView4(rootView.findViewById(R.id.textView14));
        workInfo.setTextView5(rootView.findViewById(R.id.textView17));

        workInfo.setEditText1(rootView.findViewById(R.id.editText));
        workInfo.setEditText2(rootView.findViewById(R.id.editText2));
        workInfo.setEditText3(rootView.findViewById(R.id.editText3));


        /*textView1 = rootView.findViewById(R.id.textView5);
        textView2 = rootView.findViewById(R.id.textView8);
        textView3 = rootView.findViewById(R.id.textView11);
        textView4 = rootView.findViewById(R.id.textView14);
        textView5 = rootView.findViewById(R.id.textView17);

        editText1 = rootView.findViewById(R.id.editText);
        editText2 = rootView.findViewById(R.id.editText2);
        editText3 = rootView.findViewById(R.id.editText3);*/

        checkBox1 = rootView.findViewById(R.id.checkBox);
        checkBox2 = rootView.findViewById(R.id.checkBox2);
        checkBox3 = rootView.findViewById(R.id.checkBox3);
        checkBox4 = rootView.findViewById(R.id.checkBox4);
        checkBox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox2.isChecked())
                    checkBox2.toggle();
                /*if (checkBox3.isChecked())
                    getChildFragmentManager().beginTransaction().replace(R.id.container_work_info, fragmentNotmade).commit();
                else if (checkBox4.isChecked())
                    getChildFragmentManager().beginTransaction().replace(R.id.container_work_info, fragmentChoice).commit();*/
            }
        });
        checkBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox1.isChecked())
                    checkBox1.toggle();
                //추가
                /*if (checkBox3.isChecked())
                    getChildFragmentManager().beginTransaction().replace(R.id.container_work_info, fragmentNotmade).commit();
                else if (checkBox4.isChecked())
                    getChildFragmentManager().beginTransaction().replace(R.id.container_work_info, fragmentNotmade).commit();*/
            }
        });
        checkBox3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox4.isChecked())
                    checkBox4.toggle();
                //추가

                /*if (checkBox1.isChecked())
                    getChildFragmentManager().beginTransaction().replace(R.id.container_work_info, fragmentNotmade).commit();
                else if (checkBox2.isChecked())
                    getChildFragmentManager().beginTransaction().replace(R.id.container_work_info, fragmentNotmade).commit();*/
            }
        });
        checkBox4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox3.isChecked())
                    checkBox3.toggle();
                //추가
                if (checkBox1.isChecked())
                    test.setVisibility(View.VISIBLE);
                /*if (checkBox1.isChecked())
                    getChildFragmentManager().beginTransaction().replace(R.id.container_work_info, fragmentChoice).commit();
                else if (checkBox2.isChecked())
                    getChildFragmentManager().beginTransaction().replace(R.id.container_work_info, fragmentNotmade).commit();*/
            }
        });
        //checkBox1.setOnClickListener(this::WeeklyOrMonthly(true));

        Button button = rootView.findViewById(R.id.button);
        LinearLayout layoutResult = rootView.findViewById(R.id.LayoutResult);
        layoutResult.setVisibility(View.INVISIBLE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //"계산하기" 버튼 클릭시 키패드 내려가도록
                if (getActivity().getCurrentFocus() != null) {
                    InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputMethodManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
                }
                //Log.d("root", editText1.getText().toString());
                //textShow("계산 버튼");
                //Bundle extras = null;
                //extras.putExtra("text", editText1);
                if (checkBox1.isChecked() && checkBox3.isChecked()) {
                    workInfo.textShow(getActivity(), "아직 제작 전입니다.");
                } else if (checkBox1.isChecked() && checkBox4.isChecked()) {
                    if (workInfo.CalculateWeeklyAndChoice(getActivity()))
                        layoutResult.setVisibility(View.VISIBLE);
                } else if (checkBox2.isChecked() && checkBox3.isChecked()) {
                    workInfo.textShow(getActivity(), "아직 제작 전입니다.");
                } else if (checkBox2.isChecked() && checkBox4.isChecked()) {
                    workInfo.textShow(getActivity(), "아직 제작 전입니다.");
                } else {
                    workInfo.textShow(getActivity(), "체크 박스를 선택해주세요.");
                }
            }
        });
        return rootView;
    }

    /*@Override
    public void getEditText(EditText et1, EditText et2, EditText et3) {
        editText1 = et1;
        editText2 = et2;
        editText3 = et3;
    }*/

    /*public void WeeklyOrMonthly(View view, boolean flag) {
        if (checkBox1.isChecked()) {
            checkBox2.setChecked(false);
        } else if (checkBox2.isChecked()) {
            checkBox1.setChecked(false);
        }
    }*/

    /*public boolean CalculateWeeklyAndChoice() {
        if (editText1.getText().toString().isEmpty() || editText2.getText().toString().isEmpty() || editText3.getText().toString().isEmpty()) {
            textShow("정보를 입력해주세요.");
            return false;
        }
        int hourlyWage = 9160;
        int workHour = Integer.parseInt(editText1.getText().toString());
        int fixedWorkDay = Integer.parseInt(editText2.getText().toString());
        int workDay = Integer.parseInt(editText3.getText().toString());
        int totalHour;
        int bonusHour = 0;
        int bonusWage;

        if (fixedWorkDay < workDay) {
            textShow("근무 규정 및 근무 일 수가 맞지 않습니다.");
            return false;
        }

        //시급
        NumberFormat format = NumberFormat.getNumberInstance();
        textView1.setText(format.format(hourlyWage));

        //총 근무 시간
        totalHour = workHour * workDay;
        textView2.setText(Integer.toString(totalHour));

        //예상 주휴 시간
        if (fixedWorkDay == workDay) {
            if (totalHour < 40) {
                bonusHour = totalHour / 40 * 8;
            } else {
                bonusHour = 8;
            }
        } else {
            bonusHour = 0;
        }
        textView3.setText(Integer.toString(bonusHour));

        //예상 주휴 수당
        bonusWage = bonusHour * hourlyWage;
        textView4.setText(format.format(bonusWage));

        //예상 주급
        textView5.setText(format.format(hourlyWage * totalHour + bonusWage));
        return true;
    }

    public void textShow(String str) {
        Toast.makeText(getContext(), str, Toast.LENGTH_LONG).show();
    }*/
}