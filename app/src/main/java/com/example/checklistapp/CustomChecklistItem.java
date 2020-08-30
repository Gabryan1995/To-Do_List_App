package com.example.checklistapp;

import android.content.Context;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class CustomChecklistItem extends LinearLayout {

    // Components
    ImageView mCheckboxImage;
    ImageView mDeleteButtonImage;
    EditText task;
    Context context;

    CustomChecklistItem(Context context) {
        super(context);
        this.context = context;
        init();
    }

    CustomChecklistItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }
    CustomChecklistItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }

    /**
     * Initializes the Custom View's parameters when created.
     */
    private void init() {
        mCheckboxImage = new ImageView(context);
        mDeleteButtonImage = new ImageView(context);
        task = new EditText(context);

        mCheckboxImage.setBackgroundResource(R.drawable.ic_checkbox_deselected);
        mDeleteButtonImage.setBackgroundResource(R.drawable.ic_delete_opaque);

        task.setText("");
        task.setTextSize(22);
        task.setInputType(InputType.TYPE_TEXT_FLAG_CAP_SENTENCES);
        task.setSingleLine(false);

        ViewGroup.LayoutParams checkboxParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        ((LayoutParams) checkboxParams).gravity = Gravity.CENTER;

        ViewGroup.LayoutParams taskParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        ((LayoutParams) taskParams).weight = 1;

        addView(mCheckboxImage, checkboxParams);
        addView(task, taskParams);
        addView(mDeleteButtonImage, checkboxParams);
    }

    /**
     * Sets the checkbox and task to be selected and disabled, or deselected and enabled.
     */
    public void setChecked(boolean checked) {
        if (checked) {
            mCheckboxImage.setImageDrawable(getResources().getDrawable(R.drawable.ic_checkbox_selected));
            task.setEnabled(false);
        } else {
            mCheckboxImage.setImageDrawable(getResources().getDrawable(R.drawable.ic_checkbox_deselected));
            task.setEnabled(true);
        }
    }

    /**
     * Sets the task if there is any text passed.
     */
    public void setTask(String newTask) {
        task.setText(newTask);
    }
}
