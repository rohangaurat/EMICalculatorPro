package com.demo.cashloanemi.Modal;

import java.util.ArrayList;

public class ParentModel {
    ArrayList<String> parentTitle;

    public ParentModel(ArrayList<String> arrayList) {
        this.parentTitle = arrayList;
    }

    public ArrayList<String> getParentTitle() {
        return this.parentTitle;
    }
}
