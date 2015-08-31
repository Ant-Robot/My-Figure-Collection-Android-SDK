package com.ant_robot.mfc.api.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class PictureGallery implements Parcelable {

    @Expose
    private String name;
    @Expose
    private String version;
    @Expose
    private Gallery gallery;

    /**
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name
     */
    public void setName(String name) {
        this.name = name;
    }

    public PictureGallery withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * @return The version
     */
    public String getVersion() {
        return version;
    }

    /**
     * @param version The version
     */
    public void setVersion(String version) {
        this.version = version;
    }

    public PictureGallery withVersion(String version) {
        this.version = version;
        return this;
    }

    /**
     * @return The gallery
     */
    public Gallery getGallery() {
        return gallery;
    }

    /**
     * @param gallery The gallery
     */
    public void setGallery(Gallery gallery) {
        this.gallery = gallery;
    }

    public PictureGallery withGallery(Gallery gallery) {
        this.gallery = gallery;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(name).append(version).append(gallery).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PictureGallery) == false) {
            return false;
        }
        PictureGallery rhs = ((PictureGallery) other);
        return new EqualsBuilder().append(name, rhs.name).append(version, rhs.version).append(gallery, rhs.gallery).isEquals();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(version);
        dest.writeParcelable(gallery, flags);
    }

    /**
     * Static field used to regenerate object, individually or as arrays
     */
    public static final Creator<PictureGallery> CREATOR = new Creator<PictureGallery>() {
        public PictureGallery createFromParcel(Parcel pc) {
            return new PictureGallery(pc);
        }

        public PictureGallery[] newArray(int size) {
            return new PictureGallery[size];
        }
    };

    /**
     * Ctor from Parcel, reads back fields IN THE ORDER they were written
     */
    public PictureGallery(Parcel pc) {
        name = pc.readString();
        version = pc.readString();
        gallery = pc.readParcelable(Gallery.class.getClassLoader());
    }
}