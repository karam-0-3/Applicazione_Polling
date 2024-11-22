package com.example.mobifog_polling;

public class WebhookRegistrationBuilder {
    final String node_url;
    final String event_types;

    public WebhookRegistrationBuilder(String node_url, String event_types) {
        this.node_url = node_url;
        this.event_types = event_types;
    }
}
