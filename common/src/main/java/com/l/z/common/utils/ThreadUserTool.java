package com.l.z.common.utils;

import java.io.Serializable;

public class ThreadUserTool implements Serializable {

    /**
     * 
     */
    private static final long                        serialVersionUID = 1L;

    private static final ThreadLocal<ThreadUserTool> userHolder       = new ThreadLocal<ThreadUserTool>();

    public static final ThreadUserTool getLocalUser() {
        return userHolder.get();
    }

    public static final void setLocalUser(ThreadUserTool currUser) {
        userHolder.set(currUser);
    }

    public static final void removeLocal() {
        userHolder.remove();
    }

    private int    userId;
    private String userIdStr;
    private String userType;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserIdStr() {
        return userIdStr;
    }

    public void setUserIdStr(String userIdStr) {
        this.userIdStr = userIdStr;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

}
