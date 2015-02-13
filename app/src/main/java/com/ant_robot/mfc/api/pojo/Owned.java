
package com.ant_robot.mfc.api.pojo;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Owned {

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

    public Owned withLink(String link) {
        this.link = link;
        return this;
    }

    /**
     * 
     * @return
     *     The numItems
     */
    public String getNumItems() {
        return numItems;
    }

    /**
     * 
     * @param numItems
     *     The num_items
     */
    public void setNumItems(String numItems) {
        this.numItems = numItems;
    }

    public Owned withNumItems(String numItems) {
        this.numItems = numItems;
        return this;
    }

    /**
     * 
     * @return
     *     The numPages
     */
    public String getNumPages() {
        return numPages;
    }

    /**
     * 
     * @param numPages
     *     The num_pages
     */
    public void setNumPages(String numPages) {
        this.numPages = numPages;
    }

    public Owned withNumPages(String numPages) {
        this.numPages = numPages;
        return this;
    }

    /**
     * 
     * @return
     *     The item
     */
    public List<Item> getItem() {
        return item;
    }

    /**
     * 
     * @param item
     *     The item
     */
    public void setItem(List<Item> item) {
        this.item = item;
    }

    public Owned withItem(List<Item> item) {
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
        if ((other instanceof Owned) == false) {
            return false;
        }
        Owned rhs = ((Owned) other);
        return new EqualsBuilder().append(link, rhs.link).append(numItems, rhs.numItems).append(numPages, rhs.numPages).append(item, rhs.item).isEquals();
    }

}
