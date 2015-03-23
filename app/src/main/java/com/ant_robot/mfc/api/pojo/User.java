package com.ant_robot.mfc.api.pojo;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class User {

@Expose
private String id;
@Expose
private String name;
@Expose
private String picture;
@Expose
private String homepage;

/**
* 
* @return
* The id
*/
public String getId() {
return id;
}

/**
* 
* @param id
* The id
*/
public void setId(String id) {
this.id = id;
}

public User withId(String id) {
this.id = id;
return this;
}

/**
* 
* @return
* The name
*/
public String getName() {
return name;
}

/**
* 
* @param name
* The name
*/
public void setName(String name) {
this.name = name;
}

public User withName(String name) {
this.name = name;
return this;
}

/**
* 
* @return
* The picture
*/
public String getPicture() {
return picture;
}

/**
* 
* @param picture
* The picture
*/
public void setPicture(String picture) {
this.picture = picture;
}

public User withPicture(String picture) {
this.picture = picture;
return this;
}

/**
* 
* @return
* The homepage
*/
public String getHomepage() {
return homepage;
}

/**
* 
* @param homepage
* The homepage
*/
public void setHomepage(String homepage) {
this.homepage = homepage;
}

public User withHomepage(String homepage) {
this.homepage = homepage;
return this;
}

@Override
public String toString() {
return ToStringBuilder.reflectionToString(this);
}

@Override
public int hashCode() {
return new HashCodeBuilder().append(id).append(name).append(picture).append(homepage).toHashCode();
}

@Override
public boolean equals(Object other) {
if (other == this) {
return true;
}
if ((other instanceof User) == false) {
return false;
}
User rhs = ((User) other);
return new EqualsBuilder().append(id, rhs.id).append(name, rhs.name).append(picture, rhs.picture).append(homepage, rhs.homepage).isEquals();
}

}