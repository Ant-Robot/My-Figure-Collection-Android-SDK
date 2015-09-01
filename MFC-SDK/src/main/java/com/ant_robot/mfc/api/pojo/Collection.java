package com.ant_robot.mfc.api.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Collection implements Parcelable {

    @Expose
    private String link;
    @Expose
    private ItemState owned;
    @Expose
    private ItemState ordered;
    @Expose
    private ItemState wished;

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

    public Collection withLink(String link) {
        this.link = link;
        return this;
    }

    /**
     * @return The ordered
     */
    public ItemState getOrdered() {
        return ordered;
    }

    /**
     * @param ordered The owned
     */
    public void setOrdered(ItemState ordered) {
        this.ordered = ordered;
    }

    public Collection withOrdered(ItemState owned) {
        this.ordered = owned;
        return this;
    }

    /**
     * @return The wished
     */
    public ItemState getWished() {
        return wished;
    }

    /**
     * @param wished The wished
     */
    public void setWished(ItemState wished) {
        this.wished = wished;
    }

    public Collection withWished(ItemState owned) {
        this.wished = owned;
        return this;
    }

    /**
     * @return The owned
     */
    public ItemState getOwned() {
        return owned;
    }

    /**
     * @param owned The owned
     */
    public void setOwned(ItemState owned) {
        this.owned = owned;
    }

    public Collection withOwned(ItemState owned) {
        this.owned = owned;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(link).append(owned).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Collection) == false) {
            return false;
        }
        Collection rhs = ((Collection) other);
        return new EqualsBuilder().append(link, rhs.link).append(owned, rhs.owned).isEquals();
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(link);
        dest.writeParcelable(owned, flags);
        dest.writeParcelable(ordered, flags);
        dest.writeParcelable(wished, flags);
    }

    /**
     * Static field used to regenerate object, individually or as arrays
     */
    public static final Parcelable.Creator<Collection> CREATOR = new Parcelable.Creator<Collection>() {
        public Collection createFromParcel(Parcel pc) {
            return new Collection(pc);
        }

        public Collection[] newArray(int size) {
            return new Collection[size];
        }
    };

    /**
     * Ctor from Parcel, reads back fields IN THE ORDER they were written
     */
    public Collection(Parcel pc) {
        link = pc.readString();
        owned = pc.readParcelable(ItemState.class.getClassLoader());
        ordered = pc.readParcelable(ItemState.class.getClassLoader());
        wished = pc.readParcelable(ItemState.class.getClassLoader());
    }

}
