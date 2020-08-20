package com.fh.meeting.common;

public class SystemConstant {

    public static final String CATELIST_KEY = "cateList";
    public final static String SESSION_KEY="user";
    public final static String CART_KEY="cart:";
    public final static String TOKEN_KEY="token:";
    public static final int CATELIST_KEY_EXPIRE = 10 * 60;
    public static final int REDIS_KEY_EXPIRE = 5*60;
    public final static int TOKEN_EXPIRE = 30 * 60 * 1000;
    public final static int ORDER_STATUS_WAIT = 1;
    public final static int ORDER_STATUS_WAI = 0;
    public final static String REDIS_CATEGORY_KEY = "categoryList:";
    public final static String TEMPLATE_ROOT_PATH= "/template";
    public final static String TEMPLATE_EXCEL_PATH= "excel-template.xml";
    public final static String TEMPLATE_WORD_PATH= "word-template.xml";
    public final static String TEMPLATE_PDF_PATH= "pdf-template.html";
    public final static String LOGIN_COOLOE_KEY= "login_cookie";
    public final static int COOKIE_EXPIRY_TIME= 7*24*60*60;
    public final static String COOKIE_USER_ID="cookie_user_id";

}
