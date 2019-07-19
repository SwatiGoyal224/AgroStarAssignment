
package Assignment.Assignment;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"name",
"description",
"homepage",
"private"
})
public class GitPojo {

@JsonProperty("name")
private String name;
@JsonProperty("description")
private String description;
@JsonProperty("homepage")
private String homepage;
@JsonProperty("private")
private Boolean _private;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("name")
public String getName() {
return name;
}

@JsonProperty("name")
public void setName(String name) {
this.name = name;
}

@JsonProperty("description")
public String getDescription() {
return description;
}

@JsonProperty("description")
public void setDescription(String description) {
this.description = description;
}

@JsonProperty("homepage")
public String getHomepage() {
return homepage;
}

@JsonProperty("homepage")
public void setHomepage(String homepage) {
this.homepage = homepage;
}

@JsonProperty("private")
public Boolean getPrivate() {
return _private;
}

@JsonProperty("private")
public void setPrivate(Boolean _private) {
this._private = _private;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}