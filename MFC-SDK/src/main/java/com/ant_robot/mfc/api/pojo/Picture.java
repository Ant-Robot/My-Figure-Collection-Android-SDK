package com.ant_robot.mfc.api.pojo;

import com.google.gson.annotations.Expose;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Picture {

    @Expose
    private String id;
    @Expose
    private String src;
    @Expose
    private String full;
    @Expose
    private String medium;
    @Expose
    private String author;
    @Expose
    private String date;
    @Expose
    private Category category;
    @Expose
    private Resolution resolution;
    @Expose
    private String size;
    @Expose
    private String title;
    @Expose
    private String nsfw;
    @Expose
    private String extension;

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

    public Picture withId(String id) {
        this.id = id;
        return this;
    }

    /**
     * @return The src
     */
    public String getSrc() {
        return src;
    }

    /**
     * @param src The src
     */
    public void setSrc(String src) {
        this.src = src;
    }

    public Picture withSrc(String src) {
        this.src = src;
        return this;
    }

    /**
     * @return The full
     */
    public String getFull() {
        return full;
    }

    /**
     * @param full The full
     */
    public void setFull(String full) {
        this.full = full;
    }

    public Picture withFull(String full) {
        this.full = full;
        return this;
    }

    /**
     * @return The medium
     */
    public String getMedium() {
        return medium;
    }

    /**
     * @param medium The medium
     */
    public void setMedium(String medium) {
        this.medium = medium;
    }

    public Picture withMedium(String medium) {
        this.medium = medium;
        return this;
    }

    /**
     * @return The author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author The author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    public Picture withAuthor(String author) {
        this.author = author;
        return this;
    }

    /**
     * @return The date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date The date
     */
    public void setDate(String date) {
        this.date = date;
    }

    public Picture withDate(String date) {
        this.date = date;
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

    public Picture withCategory(Category category) {
        this.category = category;
        return this;
    }

    /**
     * @return The resolution
     */
    public Resolution getResolution() {
        return resolution;
    }

    /**
     * @param resolution The resolution
     */
    public void setResolution(Resolution resolution) {
        this.resolution = resolution;
    }

    public Picture withResolution(Resolution resolution) {
        this.resolution = resolution;
        return this;
    }

    /**
     * @return The size
     */
    public String getSize() {
        return size;
    }

    /**
     * @param size The size
     */
    public void setSize(String size) {
        this.size = size;
    }

    public Picture withSize(String size) {
        this.size = size;
        return this;
    }

    /**
     * @return The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    public Picture withTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * @return The nsfw
     */
    public String getNsfw() {
        return nsfw;
    }

    /**
     * @param nsfw The nsfw
     */
    public void setNsfw(String nsfw) {
        this.nsfw = nsfw;
    }

    public Picture withNsfw(String nsfw) {
        this.nsfw = nsfw;
        return this;
    }

    /**
     * @return The extension
     */
    public String getExtension() {
        return extension;
    }

    /**
     * @param extension The extension
     */
    public void setExtension(String extension) {
        this.extension = extension;
    }

    public Picture withExtension(String extension) {
        this.extension = extension;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(src).append(full).append(medium).append(author).append(date).append(category).append(resolution).append(size).append(title).append(nsfw).append(extension).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Picture) == false) {
            return false;
        }
        Picture rhs = ((Picture) other);
        return new EqualsBuilder().append(id, rhs.id).append(src, rhs.src).append(full, rhs.full).append(medium, rhs.medium).append(author, rhs.author).append(date, rhs.date).append(category, rhs.category).append(resolution, rhs.resolution).append(size, rhs.size).append(title, rhs.title).append(nsfw, rhs.nsfw).append(extension, rhs.extension).isEquals();
    }

}