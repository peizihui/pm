package com.pm.util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

public class Tools {

    //判断字符串是否全部是数字
    public boolean isALLIntger(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }

    public Date getNowDate() {
        //获取系统时间
        java.util.Date uDate = new java.util.Date();
        //设置时间格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return new java.sql.Date(sdf.parse(sdf.format(uDate)).getTime());
        }catch (ParseException e){
            e.printStackTrace();
            return null;
        }
    }
}
