package com.sendgrid;

public final class MailSettingsBuilder {

    private BccSettings bccSettings;
    private Setting bypassListManagement;
    private FooterSetting footerSetting;
    private SpamCheckSetting spamCheckSetting;

    private MailSettingsBuilder() {
    }

    public static MailSettingsBuilder aMailSettings() {
        return new MailSettingsBuilder();
    }

    public MailSettingsBuilder withBccSettings(BccSettings bccSettings) {
        this.bccSettings = bccSettings;
        return this;
    }

    public MailSettingsBuilder withBccSettings(String email) {
        BccSettings settings = new BccSettings();
        settings.setEnable(true);
        settings.setEmail(email);
        return withBccSettings(settings);
    }

    public MailSettingsBuilder withBypassListManagement(Setting bypassListManagement) {
        this.bypassListManagement = bypassListManagement;
        return this;
    }

    public MailSettingsBuilder withBypassListManagement() {
        Setting setting = new Setting();
        setting.setEnable(true);
        return withBypassListManagement(setting);
    }

    public MailSettingsBuilder withFooterSetting(FooterSetting footerSetting) {
        this.footerSetting = footerSetting;
        return this;
    }

    public MailSettingsBuilder withFooterSetting(String text, String html) {
        FooterSetting setting = new FooterSetting();
        setting.setEnable(true);
        setting.setText(text);
        setting.setHtml(html);
        return withFooterSetting(setting);
    }

    public MailSettingsBuilder withSpamCheckSetting(SpamCheckSetting spamCheckSetting) {
        this.spamCheckSetting = spamCheckSetting;
        return this;
    }

    public MailSettingsBuilder withSpamCheckSetting(int spamThreshold, String postToUrl) {
        SpamCheckSetting setting = new SpamCheckSetting();
        setting.setEnable(true);
        setting.setSpamThreshold(spamThreshold);
        setting.setPostToUrl(postToUrl);
        return withSpamCheckSetting(setting);
    }

    public MailSettings build() {
        MailSettings mailSettings = new MailSettings();
        mailSettings.setBccSettings(bccSettings);
        mailSettings.setBypassListManagement(bypassListManagement);
        mailSettings.setFooterSetting(footerSetting);
        mailSettings.setSpamCheckSetting(spamCheckSetting);
        return mailSettings;
    }
}
