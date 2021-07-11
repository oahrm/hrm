package com.hrm.oa.util;


import java.util.regex.Pattern;

public class VerificationUtils {
    /**
     * 手机验证
     * @param phone
     * @return
     */
    public Boolean phoneVer(String phone){
        if(phone == null || phone.equals("")){
            return true;
        }
        String pattern = "^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$";
        return Pattern.matches(pattern, phone);
    }

    /**
     * 邮箱验证
     * @param mail
     * @return
     */
    public Boolean mailVer(String mail){
        if(mail == null || mail.equals("")){
            return true;
        }
        String pattern = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        return Pattern.matches(pattern, mail);
    }

    /**
     * 身份证验证
     * @param id
     * @return
     */
    public Boolean idVer(String id){
        String pattern = "(^[1-9]\\d{5}(((1[89]|20)\\d{2}(((0[13578]|1[0-2])(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)(0[1-9]|[12][0-9]|30))|(02(0[1-9]|[1][0-9]|2[0-8]))))|((((1[89]|20)(0[48]|[2468][048]|[13579][26]))|((19|20)00))0229))\\d{3}(\\d|X|x)$)";
        return Pattern.matches(pattern, id);
    }
}
