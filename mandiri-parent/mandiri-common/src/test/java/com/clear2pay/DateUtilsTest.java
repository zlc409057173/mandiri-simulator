package com.clear2pay;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author zlc
 * @Date 2021/7/28 - 11:45
 * @Descriptions 说点什么
 */
public class DateUtilsTest {

    private static final Logger log = LoggerFactory.getLogger(DateUtilsTest.class);

    @Test
    public void testDateFormat(){
        DateTimeFormatter yyddmm = DateTimeFormatter.ofPattern("yyMMdd");
        String nowDate = LocalDate.now().format(yyddmm);
        log.debug("nowDate : {}",nowDate);
    }
}
