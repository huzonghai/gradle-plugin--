package com.enjoy.plugin;

public class JGExt {
    //360账号
    private String username;
    //360密码
    private String password;
    //签名路径
    private String keyStorePath;
    //签名密码
    private String keyStorePass;
    //签名别名
    private String keyStoreKeyAlias;
    //别名密码
    private String keyStoreKeyAliasPwd;

    private String jiaGuToolPath;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getKeyStorePath() {
        return keyStorePath;
    }

    public void setKeyStorePath(String keyStorePath) {
        this.keyStorePath = keyStorePath;
    }

    public String getKeyStorePass() {
        return keyStorePass;
    }

    public void setKeyStorePass(String keyStorePass) {
        this.keyStorePass = keyStorePass;
    }

    public String getKeyStoreKeyAlias() {
        return keyStoreKeyAlias;
    }

    public void setKeyStoreKeyAlias(String keyStoreKeyAlias) {
        this.keyStoreKeyAlias = keyStoreKeyAlias;
    }

    public String getKeyStoreKeyAliasPwd() {
        return keyStoreKeyAliasPwd;
    }

    public void setKeyStoreKeyAliasPwd(String keyStoreKeyAliasPwd) {
        this.keyStoreKeyAliasPwd = keyStoreKeyAliasPwd;
    }

    public String getJiaGuToolPath() {
        return jiaGuToolPath;
    }

    public void setJiaGuToolPath(String jiaGuToolPath) {
        this.jiaGuToolPath = jiaGuToolPath;
    }

    @Override
    public String toString() {
        return "JGExt{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", keyStorePath='" + keyStorePath + '\'' +
                ", keyStorePass='" + keyStorePass + '\'' +
                ", keyStoreKeyAlias='" + keyStoreKeyAlias + '\'' +
                ", keyStoreKeyAliasPwd='" + keyStoreKeyAliasPwd + '\'' +
                ", jiaGuToolPath='" + jiaGuToolPath + '\'' +
                '}';
    }
}
