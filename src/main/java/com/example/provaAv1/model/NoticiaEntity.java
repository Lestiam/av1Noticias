package com.example.provaAv1.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "noticias")
public class NoticiaEntity {

    @Id
    private String id;
    private String responseBody;

    public NoticiaEntity(String id, String responseBody) {
        this.id = id;
        this.responseBody = responseBody;
    }

    public NoticiaEntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }
}