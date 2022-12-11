# kong-admin-client

**A Java Client for Kong Admin API**

Developed based on [feign](https://github.com/OpenFeign/feign) http client

## Compatibility

For kong-admin-client 2.0.0

| Component | Version                            |
| --------- | ---------------------------------- |
| Spring    | spring-boot 2.7.6 or spring 5.3.24 |
| Java      | 1.8                                |
| Kong      | tested in 3.1.0                    |

For Kong version below 3.x, some entity endpoints (like vaults, keys and key-sets) will be unavailable and some rate-limiting policy cannot be supported. For 1.x Kong version, a legacy decoder need to be applied.

## Quick Start

#### Native Java

import by maven

```xml
<dependency>
  <groupId>io.github.ungle</groupId>
  <artifactId>kong-admin-client-core</artifactId>
  <version>2.0.0</version>
</dependency>
```

Then start a client and use:

```java
KongClientFactory kongClientFactory = KongClientFactory.builder()
                .targets(Arrays.asList("http://127.0.0.1:8001")).build();
// you need to cache the api instance
InformationApi informationApi = kongClientFactory.getApiInstance(InformationApi.class);
NodeStatusResponse status = informationApi.getNodeStatus();
```

#### Spring Boot

import by maven

```xml
<dependency>
  <groupId>io.github.ungle</groupId>
  <artifactId>spring-boot-starter-kong-client</artifactId>
  <version>2.0.0</version>
</dependency>
```

Configure via *.properties or *.yml file

```properties
#optional, default is true
kong.client.enabled = true 
#required
kong.client.targets = http://127.0.0.1:8001,http://127.0.0.2:8001
#okhttp properties, optional
kong.client.okhttp.* = ...
#retry properties, optional
kong.client.retry.* = ...
#log level,accepted values are NONE,BASIC,HEADERS and FULL, optional
kong.client.log-level = BASIC

```

Then start to use:

```java
@Autowired
InformationApi api;

@GetMapping("/hello")
public NodeStatusResponse hello() {
  NodeStatusResponse result = api.getNodeStatus();
  return result;
}
```



## Plugin Configuration

For these plugins, entities are supported in this client:

| Plugin     |               |                |
| ---------- | ------------- | -------------- |
| Basic Auth | Oauth2        | IP Restriction |
| HMAC       | Session       | ACL            |
| JWT        | ACME          | Proxy Cache    |
| Key        | Bot Detection | Rate Limiting  |
| LDAP       | CORS          |                |

you can easily build the entities with builders

```java
PluginRequest request = new PluginRequest();
request.setName("rate-limiting");
request.setService(new IdNameRelation(serviceId));
request.setConfig(RateLimitingConfig.builder().withSecond(11L).build());
PluginResponse result = pluginApi.add(request);
```

For other plugin without dedicated builders or custom plugins, you can set the config via [CustomizedMapConfig](https://github.com/ungle/kong-admin-client/blob/master/kong-admin-client-core/src/main/java/io/github/ungle/kong/client/model/plugins/CustomizedMapConfig.java)

```java
CustomizedMapConfig.builder().addProperty("header-name","22").build();
```



## Working with Secured Admin API

Kong Admin API can be secured via [Kong API Loopback](https://docs.konghq.com/gateway/3.1.x/production/running-kong/secure-admin-api/) and kong-admin-client can connected to these endpoints with authenization.

```java
KongClientFactory kongClientFactory = KongClientFactory.builder()
.basicAuth(username, password)
.targets(Arrays.asList("http://127.0.0.1:8001")).build();
```

In spring boot, you can configure via properties file:

```properties
# basic auth
kong.client.auth.basic-auth.username = xxx
kong.client.auth.basic-auth.password = xxx
# key auth
kong.client.auth.key-auth.header-name= xxx
kong.client.auth.key-auth.api-key= xxx
```



For now, kong-admin-client supports Basic Auth and Key Auth secured admin api.



### Working with Older Kong Version

In Kong 1.x, unlike 2.x or 3.x, when you query an empty entity list, you will get:

```java
{
    "next":null,
    "data":{}
}
```

In this case, the data become a json object, different from json list when it contains data.

```json
{
    "next":null,
    "data":[
    {entity...},
    {entity...}
]
}
```

A legacy decoder can be used to avoid error in json decoding process

```java
KongClientFactory kongClientFactory = KongClientFactory.builder()
                .targets(Arrays.asList("http://127.0.0.1:8001"))
.decoder(new KongLegencyDecoder())
.build();
```

**Notice:** kong-admin-client is not fully tested and will not be maintained for adapting kong 1.x, so some features may not work well with kong 1.x


