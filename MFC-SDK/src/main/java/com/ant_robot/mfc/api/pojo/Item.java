package com.ant_robot.mfc.api.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Item implements Parcelable {

    @Expose
    private Root root;
    @Expose
    private Category category;
    @Expose
    private Data data;
    @Expose
    private Mycollection mycollection;

    /**
     * @return The root
     */
    public Root getRoot() {
        return root;
    }

    /**
     * @param root The root
     */
    public void setRoot(Root root) {
        this.root = root;
    }

    public Item withRoot(Root root) {
        this.root = root;
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

    public Item withCategory(Category category) {
        this.category = category;
        return this;
    }

    /**
     * @return The data
     */
    public Data getData() {
        return data;
    }

    /**
     * @param data The data
     */
    public void setData(Data data) {
        this.data = data;
    }

    public Item withData(Data data) {
        this.data = data;
        return this;
    }

    /**
     * @return The mycollection
     */
    public Mycollection getMycollection() {
        return mycollection;
    }

    /**
     * @param mycollection The mycollection
     */
    public void setMycollection(Mycollection mycollection) {
        this.mycollection = mycollection;
    }

    public Item withMycollection(Mycollection mycollection) {
        this.mycollection = mycollection;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(root).append(category).append(data).append(mycollection).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Item) == false) {
            return false;
        }
        Item rhs = ((Item) other);
        return new EqualsBuilder().append(root, rhs.root).append(category, rhs.category).append(data, rhs.data).append(mycollection, rhs.mycollection).isEquals();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(root, flags);
        dest.writeParcelable(category, flags);
        dest.writeParcelable(data, flags);
        dest.writeParcelable(mycollection, flags);
    }

    /**
     * Static field used to regenerate object, individually or as arrays
     */
    public static final Creator<Item> CREATOR = new Creator<Item>() {
        public Item createFromParcel(Parcel pc) {
            return new Item(pc);
        }

        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

    /**
     * Ctor from Parcel, reads back fields IN THE ORDER they were written
     */
    public Item(Parcel pc) {
        root = pc.readParcelable(Root.class.getClassLoader());
        category = pc.readParcelable(Category.class.getClassLoader());
        data = pc.readParcelable(Data.class.getClassLoader());
        mycollection = pc.readParcelable(Mycollection.class.getClassLoader());
    }

}
