package org.project.alba;

import android.content.Context;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;

public class WorkInfo extends AppCompatActivity {
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;
    private EditText editText1;
    private EditText editText2;
    private EditText editText3;

    public WorkInfo() {}

    public void setTextView1(TextView tv) { this.textView1 = tv; }
    public void setTextView2(TextView tv) { this.textView2 = tv; }
    public void setTextView3(TextView tv) { this.textView3 = tv; }
    public void setTextView4(TextView tv) { this.textView4 = tv; }
    public void setTextView5(TextView tv) { this.textView5 = tv; }
    public void setEditText1(EditText et) { this.editText1 = et; }
    public void setEditText2(EditText et) { this.editText2 = et; }
    public void setEditText3(EditText et) { this.editText3 = et; }

    public TextView getTextView1() { return textView1; }
    public TextView getTextView2() { return textView2; }
    public TextView getTextView3() { return textView3; }
    public TextView getTextView4() { return textView4; }
    public TextView getTextView5() { return textView5; }
    public EditText getEditText1() { return editText1; }
    public EditText getEditText2() { return editText2; }
    public EditText getEditText3() { return editText3; }

    public boolean CalculateWeeklyAndChoice(Context context) {
        System.out.println(getEditText1());
        try {
            int hourlyWage = 9160;
            int workHour = Integer.parseInt(getEditText1().getText().toString());
            int fixedWorkDay = Integer.parseInt(getEditText2().getText().toString());
            int workDay = Integer.parseInt(getEditText3().getText().toString());
            int totalHour;
            int bonusHour = 0;
            int bonusWage;

            if (fixedWorkDay < workDay) {
                textShow(context, "근무 규정 및 근무 일 수가 맞지 않습니다.");
                return false;
            }

            //시급
            NumberFormat format = NumberFormat.getNumberInstance();
            getTextView1().setText(format.format(hourlyWage));

            //총 근무 시간
            totalHour = workHour * workDay;
            getTextView2().setText(Integer.toString(totalHour));

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
            getTextView3().setText(Integer.toString(bonusHour));

            //예상 주휴 수당
            bonusWage = bonusHour * hourlyWage;
            getTextView4().setText(format.format(bonusWage));

            //예상 주급
            getTextView5().setText(format.format(hourlyWage * totalHour + bonusWage));
        } catch (NullPointerException e) {
            textShow(context, "정보를 입력해주세요.");
            return false;
        }
        /*if (editText1.getText().toString() != null || editText2.getText().toString() != null || editText3.getText().toString() != null) {
            textShow(context, "정보를 입력해주세요.");
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
            textShow(context, "근무 규정 및 근무 일 수가 맞지 않습니다.");
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
        textView5.setText(format.format(hourlyWage * totalHour + bonusWage));*/
        return true;
    }

    public void textShow(Context context, String str) {
        Toast.makeText(context, str, Toast.LENGTH_LONG).show();
    }
}
