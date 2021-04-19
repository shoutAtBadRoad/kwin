package com.kwin.db.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JYP
 * @date 2020/11/18
 **/

public class Shift {

    public static List<Integer> shift(String id){
        List<Integer> list = new ArrayList<>();
        int flag = 0;
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();
        for(int i=0;i<=id.length()-1;i++){
            CharSequence ch = id.subSequence(i,i+1);
            if(ch.equals("-")){
                flag=1;
            }
            if(flag==0){
                a.append(ch);
            }
            else if(!ch.equals("-")){
                b.append(ch);
            }
        }
        list.add(Integer.valueOf(String.valueOf(a)));
        list.add(Integer.valueOf(String.valueOf(b)));
        return list;
    }

}
