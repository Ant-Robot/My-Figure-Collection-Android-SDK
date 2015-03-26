package com.ant_robot.mfc.api.pojo;

import com.google.gson.annotations.Expose;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class ItemList {

    @Expose
    private String name;
    @Expose
    private String version;
    @Expose
    private Collection collection;

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

    public ItemList withName(String name) {
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

    public ItemList withVersion(String version) {
        this.version = version;
        return this;
    }

    /**
     * @return The collection
     */
    public Collection getCollection() {
        return collection;
    }

    /**
     * @param collection The collection
     */
    public void setCollection(Collection collection) {
        this.collection = collection;
    }

    public ItemList withCollection(Collection collection) {
        this.collection = collection;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(name).append(version).append(collection).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ItemList) == false) {
            return false;
        }
        ItemList rhs = ((ItemList) other);
        return new EqualsBuilder().append(name, rhs.name).append(version, rhs.version).append(collection, rhs.collection).isEquals();
    }

}
