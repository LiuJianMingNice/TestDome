package com.example.liujianming.testdemo1.android.states;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

public class SelectedItemState extends View.BaseSavedState {

    private int selectedItem;

    public SelectedItemState(Parcel source) {
        super(source);
        selectedItem =source.readInt();
    }

    public SelectedItemState(Parcelable superState) {
        super(superState);
    }

    public int getSelectedItem() {
        return selectedItem;
    }

    public void SelectedItemState(int selectedItem) {
        this.selectedItem = selectedItem;
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator<SelectedItemState>() {

        @Override
        public SelectedItemState createFromParcel(Parcel source) {
            return new SelectedItemState(source);
        }

        @Override
        public SelectedItemState[] newArray(int size) {
            return new SelectedItemState[size];
        }
    };

    @Override
    public void writeToParcel(Parcel out, int flags) {
        super.writeToParcel(out, flags);
        out.writeInt(selectedItem);
    }
}
