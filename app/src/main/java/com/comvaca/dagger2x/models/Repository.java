package com.comvaca.dagger2x.models;

import com.google.gson.annotations.SerializedName;

public class Repository {

    String name;

    @SerializedName("full_name")
    String fullName;

    String description;

    @SerializedName("ssh_url")
    String sshUrl;

    @SerializedName("created_at")
    String createAt;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSshUrl() {
        return sshUrl;
    }

    public void setSshUrl(String sshUrl) {
        this.sshUrl = sshUrl;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }
}
