package com.seed.utils;

import com.seed.utils.generator.ChineseIDCardNumberGenerator;
import com.seed.utils.generator.ChineseMobileNumberGenerator;
import com.seed.utils.generator.ChineseNameGenerator;

/**
 * @Author LianSong
 * @Date 2019/12/26 16:18
 */
public class Generator {
    public static void main(String[] args) {
        for (int i = 0; i < 10000 ; i++) {
            String name = ChineseNameGenerator.getInstance().generate();
            String idCard = ChineseIDCardNumberGenerator.getInstance().generate();
            String phone = ChineseMobileNumberGenerator.getInstance().generate();
            System.out.println(String.format("%s-%s-%s",name,idCard,phone));
        }
    }
}
