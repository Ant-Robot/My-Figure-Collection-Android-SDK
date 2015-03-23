package com.ant_robot.mfc.api.pojo;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class UserProfile {

@Expose
private String name;
@Expose
private String version;
@Expose
private User user;

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

public UserProfile withName(String name) {
this.name = name;
return this;
}

/**
* 
* @return
* The version
*/
public String getVersion() {
return version;
}

/**
* 
* @param version
* The version
*/
public void setVersion(String version) {
this.version = version;
}

public UserProfile withVersion(String version) {
this.version = version;
return this;
}

/**
* 
* @return
* The user
*/
public User getUser() {
return user;
}

/**
* 
* @param user
* The user
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

}