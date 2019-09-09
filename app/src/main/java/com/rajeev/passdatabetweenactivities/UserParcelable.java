package com.rajeev.passdatabetweenactivities;

import android.os.Parcel;
import android.os.Parcelable;

public class UserParcelable implements Parcelable {
    private String id;
    private String name;
    private String email;

    public UserParcelable(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    protected UserParcelable(Parcel in) {
        id = in.readString();
        name = in.readString();
        email = in.readString();

    }

    public static final Creator<UserParcelable> CREATOR = new Creator<UserParcelable>() {
        @Override
        public UserParcelable createFromParcel(Parcel in) {
            return new UserParcelable(in);
        }

        @Override
        public UserParcelable[] newArray(int size) {
            return new UserParcelable[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(name);
        parcel.writeString(email);


    }
}
