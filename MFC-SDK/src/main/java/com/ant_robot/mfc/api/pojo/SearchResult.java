package com.ant_robot.mfc.api.pojo;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class SearchResult {

@Expose
private String name;
@Expose
private String version;
@SerializedName("num_results")
@Expose
private String numResults;
@Expose
private List<Item> item = new ArrayList<Item>();

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

public SearchResult withName(String name) {
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

public SearchResult withVersion(String version) {
this.version = version;
return this;
}

/**
* 
* @return
* The numResults
*/
public String getNumResults() {
return numResults;
}

/**
* 
* @param numResults
* The num_results
*/
public void setNumResults(String numResults) {
this.numResults = numResults;
}

public SearchResult withNumResults(String numResults) {
this.numResults = numResults;
return this;
}

/**
* 
* @return
* The item
*/
public List<Item> getItem() {
return item;
}

/**
* 
* @param item
* The item
*/
public void setItem(List<Item> item) {
this.item = item;
}

public SearchResult withItem(List<Item> item) {
this.item = item;
return this;
}

@Override
public String toString() {
return ToStringBuilder.reflectionToString(this);
}

@Override
public int hashCode() {
return new HashCodeBuilder().append(name).append(version).append(numResults).append(item).toHashCode();
}

@Override
public boolean equals(Object other) {
if (other == this) {
return true;
}
if ((other instanceof SearchResult) == false) {
return false;
}
SearchResult rhs = ((SearchResult) other);
return new EqualsBuilder().append(name, rhs.name).append(version, rhs.version).append(numResults, rhs.numResults).append(item, rhs.item).isEquals();
}

}