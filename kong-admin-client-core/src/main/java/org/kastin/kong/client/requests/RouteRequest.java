package org.kastin.kong.client.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.*;

import org.kastin.kong.client.enums.HttpMethod;
import org.kastin.kong.client.enums.ProtocolEnum;
import org.kastin.kong.client.model.IdNameRelation;
import org.kastin.kong.client.model.IpAddr;

public class RouteRequest extends Request {

    private String name;
    private Set<ProtocolEnum> protocols = new HashSet<>(Arrays.asList(ProtocolEnum.HTTP, ProtocolEnum.HTTPS));
    private Set<HttpMethod> methods;
    private List<String> paths;
    private Map<String, List<String>> headers;

    @JsonProperty("https_redirect_status_code")
    private Integer httpRedirectStatusCode = 426;
    @JsonProperty("regex_priority")
    private Integer regexPriority = 0;
    @JsonProperty("strip_path")
    private Boolean stripPath = true;
    @JsonProperty("preserve_host")
    private Boolean preserveHost = true;
    private Set<String> tags;
    @JsonProperty("request_buffering")
    private Boolean requestBuffering = true;
    @JsonProperty("response_buffering")
    private Boolean responseBuffering = true;
    private List<String> snis;
    private List<IpAddr> sources;
    private List<IpAddr> destinations;
    private IdNameRelation service;

    public RouteRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ProtocolEnum> getProtocols() {
        return protocols;
    }

    public void setProtocols(Set<ProtocolEnum> protocols) {
        this.protocols = protocols;
    }

    public Set<HttpMethod> getMethods() {
        return methods;
    }

    public void setMethods(Set<HttpMethod> methods) {
        this.methods = methods;
    }

    public List<String> getPaths() {
        return paths;
    }

    public void setPaths(List<String> paths) {
        this.paths = paths;
    }

    public Map<String, List<String>> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, List<String>> headers) {
        this.headers = headers;
    }

    public Integer getHttpRedirectStatusCode() {
        return httpRedirectStatusCode;
    }

    public void setHttpRedirectStatusCode(Integer httpRedirectStatusCode) {
        this.httpRedirectStatusCode = httpRedirectStatusCode;
    }

    public Integer getRegexPriority() {
        return regexPriority;
    }

    public void setRegexPriority(Integer regexPriority) {
        this.regexPriority = regexPriority;
    }

    public Boolean getStripPath() {
        return stripPath;
    }

    public void setStripPath(Boolean stripPath) {
        this.stripPath = stripPath;
    }

    public Boolean getPreserveHost() {
        return preserveHost;
    }

    public void setPreserveHost(Boolean preserveHost) {
        this.preserveHost = preserveHost;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    public Boolean getRequestBuffering() {
        return requestBuffering;
    }

    public void setRequestBuffering(Boolean requestBuffering) {
        this.requestBuffering = requestBuffering;
    }

    public Boolean getResponseBuffering() {
        return responseBuffering;
    }

    public void setResponseBuffering(Boolean responseBuffering) {
        this.responseBuffering = responseBuffering;
    }

    public List<String> getSnis() {
        return snis;
    }

    public void setSnis(List<String> snis) {
        this.snis = snis;
    }

    public List<IpAddr> getSources() {
        return sources;
    }

    public void setSources(List<IpAddr> sources) {
        this.sources = sources;
    }

    public List<IpAddr> getDestinations() {
        return destinations;
    }

    public void setDestinations(List<IpAddr> destinations) {
        this.destinations = destinations;
    }

    public IdNameRelation getService() {
        return service;
    }

    public void setService(IdNameRelation service) {
        this.service = service;
    }
}
