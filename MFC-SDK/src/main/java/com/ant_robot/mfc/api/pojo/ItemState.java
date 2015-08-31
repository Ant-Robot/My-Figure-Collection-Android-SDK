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

public class ItemState implements Parcelable {

    @Expose
    private String link;
    @SerializedName("num_items")
    @Expose
    private String numItems;
    @SerializedName("num_pages")
    @Expose
    private String numPages;
    @Expose
    private List<Item> item = new ArrayList<Item>();

    /**
     * @return The link
     */
    public String getLink() {
        return link;
    }

    /**
     * @param link The link
     */
    public void setLink(String link) {
        this.link = link;
    }

    public ItemState withLink(String link) {
        this.link = link;
        return this;
    }

    /**
     * @return The numItems
     */
    public String getNumItems() {
        return numItems;
    }

    /**
     * @param numItems The num_items
     */
    public void setNumItems(String numItems) {
        this.numItems = numItems;
    }

    public ItemState withNumItems(String numItems) {
        this.numItems = numItems;
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

    public ItemState withNumPages(String numPages) {
        this.numPages = numPages;
        return this;
    }

    /**
     * @return The item
     */
    public List<Item> getItem() {
        return item;
    }

    /**
     * @param item The item
     */
    public void setItem(List<Item> item) {
        this.item = item;
    }

    public ItemState withItem(List<Item> item) {
        this.item = item;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(link).append(numItems).append(numPages).append(item).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ItemState) == false) {
            return false;
        }
        ItemState rhs = ((ItemState) other);
        return new EqualsBuilder().append(link, rhs.link).append(numItems, rhs.numItems).append(numPages, rhs.numPages).append(item, rhs.item).isEquals();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(link);
        dest.writeString(numItems);
        dest.writeString(numPages);
        dest.writeList(item);
    }

    /**
     * Static field used to regenerate object, individually or as arrays
     */
    public static final Creator<ItemState> CREATOR = new Creator<ItemState>() {
        public ItemState createFromParcel(Parcel pc) {
            return new ItemState(pc);
        }

        public ItemState[] newArray(int size) {
            return new ItemState[size];
        }
    };

    /**
     * Ctor from Parcel, reads back fields IN THE ORDER they were written
     */
    public ItemState(Parcel pc) {
        link = pc.readString();
        numItems = pc.readString();
        numPages = pc.readString();
        item = pc.readArrayList(Item.class.getClassLoader());
    }
}
