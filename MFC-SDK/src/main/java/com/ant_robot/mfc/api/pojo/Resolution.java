package com.ant_robot.mfc.api.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Resolution implements Parcelable {

    @Expose
    private String width;
    @Expose
    private String height;

    /**
     * @return The width
     */
    public String getWidth() {
        return width;
    }

    /**
     * @param width The width
     */
    public void setWidth(String width) {
        this.width = width;
    }

    public Resolution withWidth(String width) {
        this.width = width;
        return this;
    }

    /**
     * @return The height
     */
    public String getHeight() {
        return height;
    }

    /**
     * @param height The height
     */
    public void setHeight(String height) {
        this.height = height;
    }

    public Resolution withHeight(String height) {
        this.height = height;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(width).append(height).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Resolution) == false) {
            return false;
        }
        Resolution rhs = ((Resolution) other);
        return new EqualsBuilder().append(width, rhs.width).append(height, rhs.height).isEquals();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(width);
        dest.writeString(height);
    }

    /**
     * Static field used to regenerate object, individually or as arrays
     */
    public static final Creator<Resolution> CREATOR = new Creator<Resolution>() {
        public Resolution createFromParcel(Parcel pc) {
            return new Resolution(pc);
        }

        public Resolution[] newArray(int size) {
            return new Resolution[size];
        }
    };

    /**
     * Ctor from Parcel, reads back fields IN THE ORDER they were written
     */
    public Resolution(Parcel pc) {
        width = pc.readString();
        height = pc.readString();
    }
}