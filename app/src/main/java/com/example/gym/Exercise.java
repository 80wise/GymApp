package com.example.gym;

import android.os.Parcel;
import android.os.Parcelable;

public class Exercise implements Parcelable {
    private String name;
    private String pictureUrl;
    private String description;
    private int id;
    private boolean done;

    public Exercise(int id, String name, String pictureUrl, String description, boolean done) {
        this.name = name;
        this.pictureUrl = pictureUrl;
        this.description = description;
        this.id = id;
        this.done = done;
    }

    public Exercise() {
    }


    protected Exercise(Parcel in) {
        name = in.readString();
        pictureUrl = in.readString();
        description = in.readString();
        id = in.readInt();
        done = in.readByte() != 0;
    }

    public static final Creator<Exercise> CREATOR = new Creator<Exercise>() {
        @Override
        public Exercise createFromParcel(Parcel in) {
            return new Exercise(in);
        }

        @Override
        public Exercise[] newArray(int size) {
            return new Exercise[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(pictureUrl);
        parcel.writeString(description);
        parcel.writeInt(id);
        parcel.writeByte((byte) (done ? 1 : 0));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
