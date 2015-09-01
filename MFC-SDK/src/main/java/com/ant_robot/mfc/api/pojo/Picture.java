package com.ant_robot.mfc.api.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

public class Picture implements Parcelable {

    @Expose
    private String id;
    @Expose
    private String src;
    @Expose
    private String full;
    @Expose
    private String medium;
    @Expose
    private String author;
    @Expose
    private Date date;
    @Expose
    private Category category;
    @Expose
    private Resolution resolution;
    @Expose
    private String size;
    @Expose
    private String title;
    @Expose
    private String nsfw;
    @Expose
    private String extension;

    /**
     * @return The id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(String id) {
        this.id = id;
    }

    public Picture withId(String id) {
        this.id = id;
        return this;
    }

    /**
     * @return The src
     */
    public String getSrc() {
        return src;
    }

    /**
     * @param src The src
     */
    public void setSrc(String src) {
        this.src = src;
    }

    public Picture withSrc(String src) {
        this.src = src;
        return this;
    }

    /**
     * @return The full
     */
    public String getFull() {
        return full;
    }

    /**
     * @param full The full
     */
    public void setFull(String full) {
        this.full = full;
    }

    public Picture withFull(String full) {
        this.full = full;
        return this;
    }

    /**
     * @return The medium
     */
    public String getMedium() {
        return medium;
    }

    /**
     * @param medium The medium
     */
    public void setMedium(String medium) {
        this.medium = medium;
    }

    public Picture withMedium(String medium) {
        this.medium = medium;
        return this;
    }

    /**
     * @return The author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author The author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    public Picture withAuthor(String author) {
        this.author = author;
        return this;
    }

    /**
     * @return The date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date The date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    public Picture withDate(Date date) {
        this.date = date;
        return this;
    }

    /**
     * @return The category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * @param category The category
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    public Picture withCategory(Category category) {
        this.category = category;
        return this;
    }

    /**
     * @return The resolution
     */
    public Resolution getResolution() {
        return resolution;
    }

    /**
     * @param resolution The resolution
     */
    public void setResolution(Resolution resolution) {
        this.resolution = resolution;
    }

    public Picture withResolution(Resolution resolution) {
        this.resolution = resolution;
        return this;
    }

    /**
     * @return The size
     */
    public String getSize() {
        return size;
    }

    /**
     * @param size The size
     */
    public void setSize(String size) {
        this.size = size;
    }

    public Picture withSize(String size) {
        this.size = size;
        return this;
    }

    /**
     * @return The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    public Picture withTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * @return The nsfw
     */
    public String getNsfw() {
        return nsfw;
    }

    /**
     * @param nsfw The nsfw
     */
    public void setNsfw(String nsfw) {
        this.nsfw = nsfw;
    }

    public Picture withNsfw(String nsfw) {
        this.nsfw = nsfw;
        return this;
    }

    /**
     * @return The extension
     */
    public String getExtension() {
        return extension;
    }

    /**
     * @param extension The extension
     */
    public void setExtension(String extension) {
        this.extension = extension;
    }

    public Picture withExtension(String extension) {
        this.extension = extension;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(src).append(full).append(medium).append(author).append(date).append(category).append(resolution).append(size).append(title).append(nsfw).append(extension).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Picture) == false) {
            return false;
        }
        Picture rhs = ((Picture) other);
        return new EqualsBuilder().append(id, rhs.id).append(src, rhs.src).append(full, rhs.full).append(medium, rhs.medium).append(author, rhs.author).append(date, rhs.date).append(category, rhs.category).append(resolution, rhs.resolution).append(size, rhs.size).append(title, rhs.title).append(nsfw, rhs.nsfw).append(extension, rhs.extension).isEquals();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(src);
        dest.writeString(full);
        dest.writeString(medium);
        dest.writeString(author);
        dest.writeLong(date.getTime());
        dest.writeParcelable(category, flags);
        dest.writeParcelable(resolution, flags);
        dest.writeString(size);
        dest.writeString(title);
        dest.writeString(nsfw);
        dest.writeString(extension);
    }

    /**
     * Static field used to regenerate object, individually or as arrays
     */
    public static final Creator<Picture> CREATOR = new Creator<Picture>() {
        public Picture createFromParcel(Parcel pc) {
            return new Picture(pc);
        }

        public Picture[] newArray(int size) {
            return new Picture[size];
        }
    };

    /**
     * Ctor from Parcel, reads back fields IN THE ORDER they were written
     */
    public Picture(Parcel pc) {
        id = pc.readString();
        src = pc.readString();
        full = pc.readString();
        medium = pc.readString();
        author = pc.readString();
        date = new Date(pc.readLong());
        category = pc.readParcelable(Category.class.getClassLoader());
        resolution = pc.readParcelable(Resolution.class.getClassLoader());
        size = pc.readString();
        title = pc.readString();
        nsfw = pc.readString();
        extension = pc.readString();

    }
}