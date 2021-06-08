package com.mmall.concurrency.example.publish;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class UnsafePublish {
    private String[] status = {"a","b","c"};

    public String[] getStatus(){
        return status;
    }

    public static void main(String[] args) {
        UnsafePublish unsafePublish = new UnsafePublish();
        log.info("{}", Arrays.toString(unsafePublish.getStatus()));

        unsafePublish.getStatus()[0] = "d";
        log.info("{}", Arrays.toString(unsafePublish.getStatus()));
    }
}
