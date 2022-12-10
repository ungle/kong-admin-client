package org.kastin.kong.client.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.kastin.kong.client.api.KeyApi;
import org.kastin.kong.client.api.KeySetApi;
import org.kastin.kong.client.feignclient.KongClientFactory;
import org.kastin.kong.client.model.ApiDataList;
import org.kastin.kong.client.model.IdNameRelation;
import org.kastin.kong.client.requests.KeyRequest;
import org.kastin.kong.client.requests.KeySetRequest;
import org.kastin.kong.client.response.KeyResponse;
import org.kastin.kong.client.response.KeySetResponse;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(value = OrderAnnotation.class)
public class KeyAndSetTest {

	String keyName;
	String keyId;
	String keySetName;
	String keySetId;
	KeyApi keyApi;
	KeySetApi keySetApi;
	String jwk;

	@BeforeAll
	public void initTest() {
		KongClientFactory kongClientFactory = KongClientFactory.builder()
				.targets(Arrays.asList("http://127.0.0.1:8001")).build();
		keyApi = kongClientFactory.getApiInstance(KeyApi.class);
		keySetApi = kongClientFactory.getApiInstance(KeySetApi.class);
		keyName = "my-key";
		keySetName = "my-key-set";
		jwk = "{\r\n"
				+ "\"kty\": \"RSA\",\r\n"
				+ "\"kid\":\"42\",\r\n"
				+ "\"n\": \"33TqqLR3eeUmDtHS89qF3p4MP7Wfqt2Zjj3lZjLjjCGDvwr9cJNlNDiuKboODgUiT4ZdPWbOiMAfDcDzlOxA04DDnEFGAf-kDQiNSe2ZtqC7bnIc8-KSG_qOGQIVaay4Ucr6ovDkykO5Hxn7OU7sJp9TP9H0JH8zMQA6YzijYH9LsupTerrY3U6zyihVEDXXOv08vBHk50BMFJbE9iwFwnxCsU5-UZUZYw87Uu0n4LPFS9BT8tUIvAfnRXIEWCha3KbFWmdZQZlyrFw0buUEf0YN3_Q0auBkdbDR_ES2PbgKTJdkjc_rEeM0TxvOUf7HuUNOhrtAVEN1D5uuxE1WSw\",\r\n"
				+ "\"e\": \"AQAB\",\r\n"
				+ "\"d\": \"DjU54mYvHpICXHjc5-JiFqiH8NkUgOG8LL4kwt3DeBp9bP0-5hSJH8vmzwJkeGG9L79EWG4b_bfxgYdeNX7cFFagmWPRFrlxbd64VRYFawZHRJt-2cbzMVI6DL8EK4bu5Ux5qTiV44Jw19hoD9nDzCTfPzSTSGrKD3iLPdnREYaIGDVxcjBv3Tx6rrv3Z2lhHHKhEHb0RRjATcjAVKV9NZhMajJ4l9pqJ3A4IQrCBl95ux6Xm1oXP0i6aR78cjchsCpcMXdP3WMsvHgTlsZT0RZLFHrvkiNHlPiil4G2_eHkwvT__CrcbO6SmI_zCtMmypuHJqcr-Xb7GPJoa64WoQ\",\r\n"
				+ "\"p\": \"8K33pX90XX6PZGiv26wZm7tfvqlqWFT03nUMvOAytqdxhO2HysiPn4W58OaJd1tY4372Qpiv6enmUeI4MidCie-s-d0_B6A0xfhU5EeeaDN0xDOOl8yN-kaaVj9b4HDR3c91OAwKpDJQIeJVZtxoijxl-SRx3u7Vs_7meeSpOfE\",\r\n"
				+ "\"q\": \"7a5KnUs1pTo72A-JquJvIz4Eu794Yh3ftTk_Et-83aE_FVc6Nk-EhfnwYSNpVmM6UKdrAoy5gsCvZPxrq-eR9pEwU8M5UOlki03vWY_nqDBpJSIqwPvGHUB16zvggsPQUyQBfnN3N8XlDi12n88ltvWwEhn1LQOwMUALEfka9_s\",\r\n"
				+ "\"dp\": \"DB9nGuHplY_7Xv5a5UCs5YgxkWPtJFfbIZ1Zr-XHCCY09JIWReOGQG226OhjwixKtOK_OqmAKtMKM9OmKviJRHNbDhbTxumN3u7cL8dftjXpSryiEQlPmWyW94MneI2WNIrvh4wruQuDt8EztgOiDFxwcnUgey8iend7WmZnE7E\",\r\n"
				+ "\"dq\": \"O-bSTUQ4N_UuQezgkF3TDrnBraO67leDGwRbfiE_U0ghQvqh5DA0QSPVzlWDZc9KUitvj8vxsR9o1PW9GS0an17GJEYuetLnkShKK3NWOhBBX6d1yP9rVdH6JhgIJEy_g0Suz7TAFiFc8i7JF8u4QJ05C8bZAMhOLotqftQeVOM\",\r\n"
				+ "\"qi\": \"InfGmkb2jNkPGuNiZ-mU0-ZrOgLza_fLL9ErZ35jUPhGFzdGxJNobklvsNoTd-E2GAU41YkJh24bncMLvJVYxHHA5iF7FBWx1SvpEyKVhhnIcuXGD7N5PbNZzEdmr9C6I7cPVkWO-sUV7zfFukexIcANmsd_oBBGKRoYzP5Tti4\"\r\n"
				+ "}";
	}

	@Test
	@Order(1)
	public void addTest() {
		KeySetRequest keySetRequest = new KeySetRequest();
		keySetRequest.setName(keySetName);
		KeySetResponse keySetResponse = keySetApi.add(keySetRequest);
		assertEquals(keySetName, keySetResponse.getName());
		keySetId = keySetResponse.getId();
		KeyRequest keyRequest = new KeyRequest("42");
		keyRequest.setJwk(jwk);
		keyRequest.setName(keyName);
		keyRequest.setSet(new IdNameRelation(keySetId));
		KeyResponse keyResponse = keyApi.add(keyRequest);
		assertEquals(keyName, keyResponse.getName());
		keyId = keyResponse.getId();
	}

	@Test
	@Order(2)
	public void updateTest() {
		KeyRequest keyRequest = new KeyRequest("42");
		keyRequest.setName(keyName);
		keyRequest.setSet(new IdNameRelation(keySetId));
		keyRequest.setJwk(jwk);
		keyRequest.setTags(Collections.singleton("key-test"));
		KeyResponse response = keyApi.update(keyName, keyRequest);
		assertEquals(keySetId, response.getSet().getId());
		
		KeySetRequest keySetRequest = new KeySetRequest();
		keySetRequest.setName(keySetName);
		keySetRequest.setTags(Collections.singleton("key-test"));
		KeySetResponse keySetResponse = keySetApi.updateKeySet(keyId, keySetRequest);
		assertTrue(keySetResponse.getTags().contains("key-test"));

	}

	@Test
	@Order(3)
	public void findTest() {
		KeySetResponse keySetResponse = keySetApi.getKeySet(keyId);
		assertEquals(keySetId, keySetResponse.getId());

		ApiDataList<KeyResponse> keyResponse = keyApi.find();
		assertEquals(keyId, keyResponse.getData().get(0).getId());

	}

	@Test
	@Order(4)
	public void deleteTest() {
		keySetApi.delete(keySetId);
		keyApi.delete(keyId);
	}

}
