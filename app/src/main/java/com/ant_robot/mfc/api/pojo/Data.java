package com.ant_robot.mfc.api.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.Date;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Data {

    @Expose
    private String id;
    @Expose
    private String barcode;
    @Expose
    private String name;
    @SerializedName("release_date")
    @Expose
    private Date releaseDate;
    @Expose
    private String price;

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

    public Data withId(String id) {
        this.id = id;
        return this;
    }

    /**
     * @return The barcode
     */
    public String getBarcode() {
        return barcode;
    }

    /**
     * @param barcode The barcode
     */
    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Data withBarcode(String barcode) {
        this.barcode = barcode;
        return this;
    }

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

    public Data withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * @return The releaseDate
     */
    public Date getReleaseDate() {
        return releaseDate;
    }

    /**
     * @param releaseDate The release_date
     */
    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Data withReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    /**
     * @return The price
     */
    public String getPrice() {
        return price;
    }

    /**
     * @param price The price
     */
    public void setPrice(String price) {
        this.price = price;
    }

    public Data withPrice(String price) {
        this.price = price;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(barcode).append(name).append(releaseDate).append(price).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Data) == false) {
            return false;
        }
        Data rhs = ((Data) other);
        return new EqualsBuilder().append(id, rhs.id).append(barcode, rhs.barcode).append(name, rhs.name).append(releaseDate, rhs.releaseDate).append(price, rhs.price).isEquals();
    }

}
