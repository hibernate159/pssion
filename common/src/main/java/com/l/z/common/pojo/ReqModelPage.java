package com.l.z.common.pojo;

public class ReqModelPage {

    private String  userId;
    private String  viewName;
    private String  _csf_token;

    private boolean check;
    private String  msg;

    private int     pageSize;
    private int     currPage;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    public String get_csf_token() {
        return _csf_token;
    }

    public void set_csf_token(String _csf_token) {
        this._csf_token = _csf_token;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrPage() {
        return currPage;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

}
