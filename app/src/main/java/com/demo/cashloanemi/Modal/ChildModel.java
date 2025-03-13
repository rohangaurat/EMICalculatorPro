package com.demo.cashloanemi.Modal;

import java.util.ArrayList;

public class ChildModel {
    ArrayList<Integer> icon;
    ArrayList<String> title;

    public ArrayList<Integer> getIcon() {
        return this.icon;
    }

    public ChildModel(ArrayList<String> arrayList, ArrayList<Integer> arrayList2) {
        this.title = arrayList;
        this.icon = arrayList2;
    }

    public ArrayList<String> getTitle() {
        return this.title;
    }
}
