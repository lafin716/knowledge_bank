package com.lafin.knowledge.common.impl;

import javax.servlet.http.HttpServletRequest;

public class Super extends HttpServletRequest {

    int A = 1993;

    int B = 7;

    boolean inited = false;

    public Super() {
        this.A = 93;
        this.B = 16;
    }

    public void init() {
        this.inited = true;
    }
}