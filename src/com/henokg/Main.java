package com.henokg;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // nodes
        List<Node> nodeList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Node node = new Node();
            nodeList.add(node);
        }

        // load balancer
        LoadBalancer loadBalancer = new LoadBalancer(nodeList, false);
        loadBalancer.handleRequest();
    }
}
