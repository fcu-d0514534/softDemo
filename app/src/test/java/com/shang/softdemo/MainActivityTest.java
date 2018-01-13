package com.shang.softdemo;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainActivityTest {
    @Test
    public void getURL() throws Exception {
        assertEquals(MainActivity.getURL(0),"http://myweb.fcu.edu.tw/~d0591821/map/");
    }

    @Test
    public void getContent() throws Exception {
        assertEquals(MainActivity.getContent(0),"選擇類別,位置,距離按下確定");
        assertEquals(MainActivity.getContent(4),"使用Message來回報問題");
    }


}