package com.sendgrid.helpers.mail.objects;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sendgrid.helpers.mail.objects.BccSettings;
import com.sendgrid.helpers.mail.objects.ClickTrackingSetting;
import com.sendgrid.helpers.mail.objects.FooterSetting;
import com.sendgrid.helpers.mail.objects.GoogleAnalyticsSetting;
import com.sendgrid.helpers.mail.objects.OpenTrackingSetting;
import com.sendgrid.helpers.mail.objects.SpamCheckSetting;
import com.sendgrid.helpers.mail.objects.SubscriptionTrackingSetting;
import org.junit.Assert;
import org.junit.Test;

public class SettingsSerializationTest {

	private ObjectMapper mapper = new ObjectMapper();

	@Test
	public void testSettingSerialization() throws Exception {
		Setting setting = new Setting();
		setting.setEnable(false);

		String json = mapper.writeValueAsString(setting);
		Assert.assertEquals(json, "{\"enable\":false}");
	}

	@Test
	public void testOpenTrackingSettingSerialization() throws Exception {
		OpenTrackingSetting setting = new OpenTrackingSetting();
		setting.setEnable(false);

		String json = mapper.writeValueAsString(setting);
		Assert.assertEquals(json, "{\"enable\":false}");
	}

	@Test
	public void testClickTrackingSettingSerialization() throws Exception {
		ClickTrackingSetting setting = new ClickTrackingSetting();
		setting.setEnable(false);

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
		GoogleAnalyticsSetting setting = new GoogleAnalyticsSetting();
		setting.setEnable(false);

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
		FooterSetting setting = new FooterSetting();
		setting.setEnable(false);

		String json = mapper.writeValueAsString(setting);
		System.out.println(json);
		Assert.assertEquals(json, "{\"enable\":false}");
	}

	@Test
	public void testBccSettingsSerialization() throws Exception {
		BccSettings settings = new BccSettings();
		settings.setEnable(false);

		String json = mapper.writeValueAsString(settings);
		System.out.println(json);
		Assert.assertEquals(json, "{\"enable\":false}");
	}
}
