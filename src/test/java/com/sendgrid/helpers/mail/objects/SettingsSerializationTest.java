package com.sendgrid.helpers.mail.objects;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sendgrid.BCCSettings;
import com.sendgrid.ClickTrackingSettings;
import com.sendgrid.FooterSettings;
import com.sendgrid.GoogleAnalyticsSettings;
import org.junit.Assert;
import org.junit.Test;

public class SettingsSerializationTest {

	private ObjectMapper mapper = new ObjectMapper();

	@Test
	public void testOpenTrackingSettingSerialization() throws Exception {
		OpenTrackingSetting setting = new OpenTrackingSetting();
		setting.setEnable(false);

		String json = mapper.writeValueAsString(setting);
		Assert.assertEquals(json, "{\"enable\":false}");
	}

	@Test
	public void testClickTrackingSettingSerialization() throws Exception {
		ClickTrackingSettings setting = new ClickTrackingSettings();
		setting.enable(false);

		String json = mapper.writeValueAsString(setting);
		System.out.println(json);
		Assert.assertEquals(json, "{\"enable\":false,\"enable_text\":false}");
	}

	@Test
	public void testSubscriptionTrackingSettingSerialization() throws Exception {
		SubscriptionTrackingSetting setting = new SubscriptionTrackingSetting();
		setting.setEnable(false);

		String json = mapper.writeValueAsString(setting);
		System.out.println(json);
		Assert.assertEquals(json, "{\"enable\":false}");
	}

	@Test
	public void testGoogleAnalyticsTrackingSettingSerialization() throws Exception {
		GoogleAnalyticsSettings setting = new GoogleAnalyticsSettings();
		setting.enable(false);

		String json = mapper.writeValueAsString(setting);
		System.out.println(json);
		Assert.assertEquals(json, "{\"enable\":false}");
	}

	@Test
	public void testSpamCheckSettingSerialization() throws Exception {
		SpamCheckSetting setting = new SpamCheckSetting();
		setting.setEnable(false);

		String json = mapper.writeValueAsString(setting);
		System.out.println(json);
		Assert.assertEquals(json, "{\"enable\":false,\"threshold\":0}");
	}

	@Test
	public void testFooterSettingSerialization() throws Exception {
		FooterSettings setting = new FooterSettings();
		setting.enable(false);

		String json = mapper.writeValueAsString(setting);
		System.out.println(json);
		Assert.assertEquals(json, "{\"enable\":false}");
	}

	@Test
	public void testBccSettingsSerialization() throws Exception {
		BCCSettings settings = new BCCSettings();
		settings.enable(false);

		String json = mapper.writeValueAsString(settings);
		System.out.println(json);
		Assert.assertEquals(json, "{\"enable\":false}");
	}
}
