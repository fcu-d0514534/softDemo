package com.shang.softdemo;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Shang on 2018/1/14.
 */
public class MainActivityTest {

    @Test
    public void getURL() throws Exception {
        assertEquals(MainActivity.getURL(0),"http://myweb.fcu.edu.tw/~d0591821/map/");
        assertEquals(MainActivity.getURL(1),"http://myweb.fcu.edu.tw/~d0512808/map/");
        assertEquals(MainActivity.getURL(2),"http://myweb.fcu.edu.tw/~d0514195/health/health.html");
        assertEquals(MainActivity.getURL(3),"http://www.scu.edu.tw/health/Work/form1.php");
    }

    @Test
    public void getContent() throws Exception {
        assertEquals(MainActivity.getContent(0),"選擇類別,位置,距離按下確定");
        assertEquals(MainActivity.getContent(1),"輸入關鍵字然後跳到google map");
        assertEquals(MainActivity.getContent(2),"自己看圖");
        assertEquals(MainActivity.getContent(3),"使用清單選擇計算卡路里");
        assertEquals(MainActivity.getContent(4),"使用Message來回報問題");
    }


}