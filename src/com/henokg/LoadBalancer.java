package com.henokg;

import java.util.Comparator;
import java.util.List;

/*
 * LoadBalancer Class
 * */
public class LoadBalancer {
    // list of available nodes for balancing
    private List<Node> nodeList;
    // shall balance with sequential algorithm
    private boolean shallBalanceSequentially;
    // hold the latest node to receive a request(used under sequential algorithm)
    private int latestRequestRecieverNodeIndex = 0;

    public LoadBalancer(List<Node> nodeList, boolean shallBalanceSequentially) {
        this.nodeList = nodeList;
        this.shallBalanceSequentially = shallBalanceSequentially;
    }

    /*
     * omit Request request parameter for simplicity
     * */
    public void handleRequest() {
        // is chosen algorithm sequential?
        if (shallBalanceSequentially) {
            // yes, so let's hand request to the appropriate node
            nodeList.get(latestRequestRecieverNodeIndex).handleRequest();
            // increase latest node to receive request index sequentially
            latestRequestRecieverNodeIndex++;
        } else {
            // node with lowest load
            Node nodeAtEase = null;
            // loop through each node
            for (Node node : nodeList) {
                // is load less than 75%?
                if (node.getLoad() < 75) {
                    // yes, so hold as node with lowest load
                    nodeAtEase = node;
                    break;
                }
            }

            // no nodes with load less than 75%?
            if (nodeAtEase == null) {
                // yes, so just choose the one with the lowest load
                nodeAtEase = nodeList.stream().min(Comparator.comparing(Node::getLoad)).get();
            }
            System.out.printf("Node at ease is node with a load of %s%% ", nodeAtEase.getLoad());
        }
    }

}
