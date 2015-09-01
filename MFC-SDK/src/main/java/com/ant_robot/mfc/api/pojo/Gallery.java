package com.ant_robot.mfc.api.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

public class Gallery implements Parcelable {

    @SerializedName("num_pictures")
    @Expose
    private String numPictures;
    @SerializedName("num_pages")
    @Expose
    private String numPages;
    @Expose
    private List<Picture> picture = new ArrayList<Picture>();

    /**
     * @return The numPictures
     */
    public String getNumPictures() {
        return numPictures;
    }

    /**
     * @param numPictures The num_pictures
     */
    public void setNumPictures(String numPictures) {
        this.numPictures = numPictures;
    }

    public Gallery withNumPictures(String numPictures) {
        this.numPictures = numPictures;
        return this;
    }

    /**
     * @return The numPages
     */
    public String getNumPages() {
        return numPages;
    }

    /**
     * @param numPages The num_pages
     */
    public void setNumPages(String numPages) {
        this.numPages = numPages;
    }

    public Gallery withNumPages(String numPages) {
        this.numPages = numPages;
        return this;
    }

    /**
     * @return The picture
     */
    public List<Picture> getPicture() {
        return picture;
    }

    /**
     * @param picture The picture
     */
    public void setPicture(List<Picture> picture) {
        this.picture = picture;
    }

    public Gallery withPicture(List<Picture> picture) {
        this.picture = picture;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(numPictures).append(numPages).append(picture).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Gallery) == false) {
            return false;
        }
        Gallery rhs = ((Gallery) other);
        return new EqualsBuilder().append(numPictures, rhs.numPictures).append(numPages, rhs.numPages).append(picture, rhs.picture).isEquals();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(numPictures);
        dest.writeString(numPages);
        dest.writeTypedList(picture);
    }

    /**
     * Static field used to regenerate object, individually or as arrays
     */
    public static final Creator<Gallery> CREATOR = new Creator<Gallery>() {
        public Gallery createFromParcel(Parcel pc) {
            return new Gallery(pc);
        }

        public Gallery[] newArray(int size) {
            return new Gallery[size];
        }
    };

    /**
     * Ctor from Parcel, reads back fields IN THE ORDER they were written
     */
    public Gallery(Parcel pc) {
        numPictures = pc.readString();
        numPages = pc.readString();
        picture = pc.readArrayList(Picture.class.getClassLoader());
    }

}