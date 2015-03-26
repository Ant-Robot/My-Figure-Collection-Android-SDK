package com.ant_robot.mfc.api.pojo;

import com.google.gson.annotations.Expose;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class AlterItem {

    @Expose
    private String label;
    @Expose
    private String data;
    @Expose
    private boolean reload;

    /**
     * @return The label
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param label The label
     */
    public void setLabel(String label) {
        this.label = label;
    }

    public AlterItem withLabel(String label) {
        this.label = label;
        return this;
    }

    /**
     * @return The data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data The data
     */
    public void setData(String data) {
        this.data = data;
    }

    public AlterItem withData(String data) {
        this.data = data;
        return this;
    }

    /**
     * @return The reload
     */
    public boolean isReload() {
        return reload;
    }

    /**
     * @param reload The reload
     */
    public void setReload(boolean reload) {
        this.reload = reload;
    }

    public AlterItem withReload(boolean reload) {
        this.reload = reload;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(label).append(data).append(reload).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AlterItem) == false) {
            return false;
        }
        AlterItem rhs = ((AlterItem) other);
        return new EqualsBuilder().append(label, rhs.label).append(data, rhs.data).append(reload, rhs.reload).isEquals();
    }

}