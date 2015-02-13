
package com.ant_robot.mfc.api.pojo;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Collection {

    @Expose
    private String link;
    @Expose
    private Owned owned;

    /**
     * 
     * @return
     *     The link
     */
    public String getLink() {
        return link;
    }

    /**
     * 
     * @param link
     *     The link
     */
    public void setLink(String link) {
        this.link = link;
    }

    public Collection withLink(String link) {
        this.link = link;
        return this;
    }

    /**
     * 
     * @return
     *     The owned
     */
    public Owned getOwned() {
        return owned;
    }

    /**
     * 
     * @param owned
     *     The owned
     */
    public void setOwned(Owned owned) {
        this.owned = owned;
    }

    public Collection withOwned(Owned owned) {
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

}
