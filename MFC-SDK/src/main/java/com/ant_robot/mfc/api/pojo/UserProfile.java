package com.ant_robot.mfc.api.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class UserProfile implements Parcelable {

    @Expose
    private String name;
    @Expose
    private String version;
    @Expose
    private User user;

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

    public UserProfile withName(String name) {
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

    public UserProfile withVersion(String version) {
        this.version = version;
        return this;
    }

    /**
     * @return The user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user The user
     */
    public void setUser(User user) {
        this.user = user;
    }

    public UserProfile withUser(User user) {
        this.user = user;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(name).append(version).append(user).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof UserProfile) == false) {
            return false;
        }
        UserProfile rhs = ((UserProfile) other);
        return new EqualsBuilder().append(name, rhs.name).append(version, rhs.version).append(user, rhs.user).isEquals();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(version);
        dest.writeParcelable(user, flags);
    }

    /**
     * Static field used to regenerate object, individually or as arrays
     */
    public static final Creator<UserProfile> CREATOR = new Creator<UserProfile>() {
        public UserProfile createFromParcel(Parcel pc) {
            return new UserProfile(pc);
        }

        public UserProfile[] newArray(int size) {
            return new UserProfile[size];
        }
    };

    /**
     * Ctor from Parcel, reads back fields IN THE ORDER they were written
     */
    public UserProfile(Parcel pc) {
        name = pc.readString();
        version = pc.readString();
        user = pc.readParcelable(User.class.getClassLoader());
    }
}