package com.ant_robot.mfc.api.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Mycollection implements Parcelable {

    @Expose
    private String number;
    @Expose
    private String score;
    @Expose
    private String wishability;

    /**
     * @return The number
     */
    public String getNumber() {
        return number;
    }

    /**
     * @param number The number
     */
    public void setNumber(String number) {
        this.number = number;
    }

    public Mycollection withNumber(String number) {
        this.number = number;
        return this;
    }

    /**
     * @return The score
     */
    public String getScore() {
        return score;
    }

    /**
     * @param score The score
     */
    public void setScore(String score) {
        this.score = score;
    }

    public Mycollection withScore(String score) {
        this.score = score;
        return this;
    }

    /**
     * @return The wishability
     */
    public String getWishability() {
        return wishability;
    }

    /**
     * @param wishability The wishability
     */
    public void setWishability(String wishability) {
        this.wishability = wishability;
    }

    public Mycollection withWishability(String wishability) {
        this.wishability = wishability;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(number).append(score).append(wishability).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Mycollection) == false) {
            return false;
        }
        Mycollection rhs = ((Mycollection) other);
        return new EqualsBuilder().append(number, rhs.number).append(score, rhs.score).append(wishability, rhs.wishability).isEquals();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(number);
        dest.writeString(score);
        dest.writeString(wishability);
    }

    /**
     * Static field used to regenerate object, individually or as arrays
     */
    public static final Creator<Mycollection> CREATOR = new Creator<Mycollection>() {
        public Mycollection createFromParcel(Parcel pc) {
            return new Mycollection(pc);
        }

        public Mycollection[] newArray(int size) {
            return new Mycollection[size];
        }
    };

    /**
     * Ctor from Parcel, reads back fields IN THE ORDER they were written
     */
    public Mycollection(Parcel pc) {
        number = pc.readString();
        score = pc.readString();
        wishability = pc.readString();
    }

}
