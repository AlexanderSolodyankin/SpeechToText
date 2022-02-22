package org.dvp.yask.speechkit.auth;

public class Token
{
    private String iamToken;

    public String getIamToken() {
        return iamToken;
    }

    @Override
    public String toString() {
        return "Token{" +
                "iamToken='" + iamToken + '\'' +
                '}';
    }
}
