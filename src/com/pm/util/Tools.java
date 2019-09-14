package com.pm.util;

import java.util.regex.Pattern;

public class Tools {

    //判断字符串是否全部是数字
    public boolean isALLintger(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }
}
