package com.github.ungle.kong.client.test;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import com.github.ungle.kong.client.api.CertificateApi;
import com.github.ungle.kong.client.api.SNIApi;
import com.github.ungle.kong.client.feignclient.KongClientFactory;
import com.github.ungle.kong.client.model.IdNameRelation;
import com.github.ungle.kong.client.requests.CertificateRequest;
import com.github.ungle.kong.client.requests.SNIRequest;
import com.github.ungle.kong.client.response.CertificateResponse;
import com.github.ungle.kong.client.response.SNIResponse;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(value = OrderAnnotation.class)
public class SNIApiTest {
	
	String certificateId;
	CertificateApi certificateApi;
	SNIApi sniApi;
	String cert;
	String key;
	String sniId;
	String sniName;
	
	@BeforeAll
	public void initTest() {
		KongClientFactory kongClientFactory = KongClientFactory.builder()
                .targets(Arrays.asList("http://127.0.0.1:8001")).build();
        certificateApi = kongClientFactory.getApiInstance(CertificateApi.class);
        sniApi = kongClientFactory.getApiInstance(SNIApi.class);
     // self cert for *.kongclient.com
        cert = "-----BEGIN CERTIFICATE-----\r\n"
        		+ "MIID1jCCAr6gAwIBAgICSI4wDQYJKoZIhvcNAQELBQAwczELMAkGA1UEBhMCQ04x\r\n"
        		+ "EDAOBgNVBAgMB1RpYW5qaW4xEDAOBgNVBAcMB1RpYW5qaW4xFTATBgNVBAoMDENI\r\n"
        		+ "SU5BU1NMIEluYzEpMCcGA1UEAwwgQ0hJTkFTU0wgQ2VydGlmaWNhdGlvbiBBdXRo\r\n"
        		+ "b3JpdHkwHhcNMjIxMjA5MDY1MDQ0WhcNMjMxMjA5MDY1MDQ0WjB8MQswCQYDVQQG\r\n"
        		+ "EwJBTDESMBAGA1UECAwJc2ZGREdGSkdKMRIwEAYDVQQKDAlDSEVTR0pORFMxCzAJ\r\n"
        		+ "BgNVBAsMAklUMRkwFwYDVQQDDBAqLmtvbmdjbGllbnQuY29tMR0wGwYJKoZIhvcN\r\n"
        		+ "AQkBFg5hZGRzZEBpd2pqZi54eDCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoC\r\n"
        		+ "ggEBANmtiwE6FNb46EeGeSoDcqV2UFshUFq/ut2HIUbDMbRJZ90KCdoPWN0JEprU\r\n"
        		+ "Jz7rUoAcZAxDpobS7K7gUARgx0lwU7LLoiq5kpxE3yJzTsI7Rn/D0SSO6lruMaL3\r\n"
        		+ "bJ+AtJ2jSC7WDgBah28bbohpYshTdq5XMPKb7FurNpULT86du9++KmEXLCUNjDO0\r\n"
        		+ "VwzjXEBYtuBjjCGyQpei8e7TwohoRX+EKMZTdWFCh0UxiIU6GOTn0zIeFCbEIoa9\r\n"
        		+ "9U4Ja2RHAeWrAXf0ecz6DcB17u3kSFo4/+BSMyTRUG8pr1A313+XtuuWgB8HYXab\r\n"
        		+ "o/MWlbmbRJx/iKIJaqOUlVjvtiMCAwEAAaNrMGkwHwYDVR0jBBgwFoAUXB8j+sjh\r\n"
        		+ "ITHC2Df2iPzSb8JUQzMwCQYDVR0TBAIwADALBgNVHQ8EBAMCBPAwLgYDVR0RBCcw\r\n"
        		+ "JYIJbG9jYWxob3N0ggx3d3cudGVzdC5jb22HBMCoAAGHBH8AAAEwDQYJKoZIhvcN\r\n"
        		+ "AQELBQADggEBAFSpG9Jaqy8HIFn3sBQXcowxnZhSkLbNT95UYRUwFcKtYYA0pnru\r\n"
        		+ "S8F1a2J71oA63+8sP20cy4A+Bwfn12keYxFW7C4+IuOOYq/ooSdj6oZugeeB9YxK\r\n"
        		+ "wZSpW2Cht8G/12PrMeaxCbXxiVyJNb52y+NaN4ZaIFJ4STnkFuZ4dDA/es3s5MKz\r\n"
        		+ "gsQVcucfbZqjAekht2VMuSSXMDObgDy48LKCs75s5g/JutXtdMWcxJ/5fFXD7Oz7\r\n"
        		+ "d7b/5D2X1519hPTICJbohmJ4+bGqiHwpAzXETtm0T+YgL3xZOx1fFSdQooi0bP1F\r\n"
        		+ "Vv4rkKASSF/7/o/KrYibk247zoBob6b905I=\r\n"
        		+ "-----END CERTIFICATE-----";
        
        key ="-----BEGIN PRIVATE KEY-----\r\n"
        		+ "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDZrYsBOhTW+OhH\r\n"
        		+ "hnkqA3KldlBbIVBav7rdhyFGwzG0SWfdCgnaD1jdCRKa1Cc+61KAHGQMQ6aG0uyu\r\n"
        		+ "4FAEYMdJcFOyy6IquZKcRN8ic07CO0Z/w9Ekjupa7jGi92yfgLSdo0gu1g4AWodv\r\n"
        		+ "G26IaWLIU3auVzDym+xbqzaVC0/OnbvfviphFywlDYwztFcM41xAWLbgY4whskKX\r\n"
        		+ "ovHu08KIaEV/hCjGU3VhQodFMYiFOhjk59MyHhQmxCKGvfVOCWtkRwHlqwF39HnM\r\n"
        		+ "+g3Ade7t5EhaOP/gUjMk0VBvKa9QN9d/l7brloAfB2F2m6PzFpW5m0Scf4iiCWqj\r\n"
        		+ "lJVY77YjAgMBAAECggEAMLjsbSjf80IhU6kgw6uj5K83yz4Iq1dQ7zbI1vrnzC/G\r\n"
        		+ "BK6zh9B5lnfqZydnZWjsvWodZrVZt8HMYlQo9OHomWKACXwU3zVMQJgVzbM7hLQZ\r\n"
        		+ "0o006dbnU9UO3Sg+cvEu/D3I8VrOJXwd5luggP39s1MjNGClvxfxbo9DF1dB1MAF\r\n"
        		+ "17Q4flE5ALxZkU6DrvcfODfrh6dvDnVuFTkQiLUNu8ZyVdwmgLm+hSOVB1AYFKUs\r\n"
        		+ "ZP4EJWLYhUzhlLsAQoVrC3LYGg9/IfaJTcevWe1QjMFXycELdMpIxfvsW95ikMfi\r\n"
        		+ "GkgJACgZ2m+MYnr9xGkO3EZaKmOzAnuD+jT+tSDl2QKBgQDuhu4v1sFiN+vHFzbc\r\n"
        		+ "Offq8zts5El6aBVyC8bZheIjOQfi+HM1d2PJOqXggtKzWg+B5wrzFj1uIblGfewx\r\n"
        		+ "T5VHUy/TQiLWs0AWT3HyE1FQi0hMbY4pwB7dtz0ih0r+cbVr+y+NwHut71VCqgHx\r\n"
        		+ "HeH47fSq2xccWWFBHsbTrAqoVQKBgQDpn6FubZ1M7/zjmwOYx7yL5EvxJS8WEonM\r\n"
        		+ "2kSZzSRCeDpbBJsTKPT0wJHUEN3Jlc9IDe2/th3NF3bnzcCgzVUi/LD+EnrUnlEH\r\n"
        		+ "80dpgCQI0oMNsE34zioOli1Lj1duno7vWFJBAQ/Kld5u+N50R1fXxtSUDaO8DXx4\r\n"
        		+ "7d0mhui8lwKBgQDruJCe2j6WT+lEAR8IGIl2uRUbEafDviSjZhwHT5YhdPTkSt+g\r\n"
        		+ "EPKeJMVU0DRlZjU5DRj3Dh17PvyYO001lg5SRFVZE1zWjKJi6fQTZR/Q1zSFwybg\r\n"
        		+ "/6oBNlrGSqnENp8xrTRbg8M2KvU5QkVVAVEV7iMCzi1SqMnBzyZyfOyzWQKBgQDm\r\n"
        		+ "qUc3wl4mkmQ7TNe2Rq6v6A3a332n61HGwlItEFAWmKH1L4z00+FWrbLNkIGKALGR\r\n"
        		+ "UL9GI0c1MU+i+pCPs2u1iYwurow71Lvof5goX+40D7R5FXNGjjcUA85g5fvLKh2x\r\n"
        		+ "zqAXsjanLGVbZ7grUi02zAcizny0tRQKSb+pxFWRrQKBgD4QyNJ67m0+CD7B6N9D\r\n"
        		+ "8Qz/yb5k3GEVeFDvHWJeNMWn0ilvrY3wiI31WttdwknxIQS2DOB43HaGyEbsyKXu\r\n"
        		+ "MEHV9nHL8VyVDo1eQFZoZI3b74V+Bq9KQYqBkFMrY3G5yb8ET2VFKQDzG0iehh7b\r\n"
        		+ "qXEOmGSXd5kaabIpgzJ0QM/n\r\n"
        		+ "-----END PRIVATE KEY-----";
        
        CertificateRequest request = new CertificateRequest();
		request.setCert(cert);
		request.setKey(key);
		CertificateResponse result = certificateApi.add(request);
		certificateId = result.getId();
	}
	
	@Test
	@Order(1)
	public void addTest() {
		SNIRequest sniRequest = new SNIRequest("my-sni.kongclient.com", new IdNameRelation(certificateId));
		SNIResponse result = sniApi.add(sniRequest);
		assertEquals("my-sni.kongclient.com", result.getName());
		sniId = result.getId();
		sniName = result.getName();
	}
	
	@Test
	@Order(2)
	public void findTest() {
		SNIResponse data = sniApi.find().getData().get(0);
		assertEquals(sniId, data.getId());
		data = sniApi.retrieveByCertificate(certificateId, sniId);
		assertEquals(sniId, data.getId());
	}
	
	@Test
	@Order(3)
	public void updateTest() {
		sniName = "my-sni-2.kongclient.com";
		SNIRequest sniRequest = new SNIRequest(sniName, new IdNameRelation(certificateId));
		SNIResponse result = sniApi.update(sniId,sniRequest);
		assertEquals(sniName, result.getName());
	}
	
	@Test
	@Order(4)
	public void deleteTest() {
		sniApi.delete(sniName);
	}
	
	@AfterAll
	public void finalizeTest() {
		certificateApi.delete(certificateId);
	}

}
