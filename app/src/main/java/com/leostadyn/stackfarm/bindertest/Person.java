package com.leostadyn.stackfarm.bindertest;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Person implements Parcelable {
    private String name;
    private int grade;

    public Person(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    protected Person(Parcel in) {
        name = in.readString();
        grade = in.readInt();
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(grade);
    }

    @NonNull
    @Override
    public String toString() {

        return this.name+"/"+this.grade+"\n";
    }
}