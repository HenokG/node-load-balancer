package com.henokg;

import sun.misc.Request;

import java.util.Random;

public class Node
{
    int load;

    public Node() {
        this.load = new Random().nextInt(100);;
    }

    /*
    * return random load indicator
    * */
    int getLoad() {
        return load;
    }

    /*
    * handles request
    * omit the Request request parameter for test purposes
    * */
    void handleRequest() {
        System.out.println("Handling Request with Grace:)");
    }
}
