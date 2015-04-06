package com.ant_robot.mfc.api.pojo;

import com.google.gson.annotations.Expose;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Mycollection {

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

}
