package com.example.recyclerview.Model;

import android.widget.EditText;

public class VariableHolder {
    private static int editID;
    private static EditText taskName;

    public static int getEditID() {
        return editID;
    }

    public static void setEditID(int editID) {
        VariableHolder.editID = editID;
    }

    public static EditText getTaskName() {
        return taskName;
    }

    public static void setTaskName(EditText taskName) {
        VariableHolder.taskName = taskName;
    }
}
