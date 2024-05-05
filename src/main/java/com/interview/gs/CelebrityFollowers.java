package com.interview.gs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class CelebrityFollowers {

    public static void main(String[] args) {
        // 1, 2, 3, 4, 5 here 3 is the celeb,
        int[][] people = {
                {0, 0, 1, 1, 0},  //Node_ 1, 1 knows 4
                {1, 0, 1, 0, 0},  //Node_ 2, 2 knows 1
                {0, 0, 0, 0, 0},  //Node_ 3
                {0, 0, 1, 0, 0},  //Node_ 4
                {0, 0, 1, 0, 0}   //Node_ 5
        };

        Map<Integer, Node_> peopleGraphMap = fillPeople(people);
    }

    private static Map<Integer, Node_> fillPeople(int[][] people) {
        Map<Integer, Node_> myMap = new HashMap<>();

        // fill map with Node_ names
        for (int i = 0; i < people.length; i++) {
            int Node_Name = i + 1;
            Node_ Node_ = new Node_();
            Node_.setNode_Name(Node_Name);
            myMap.put(Node_Name, Node_);
        }

        for (int i = 0; i < people.length; i++) {
            Node_ currentRowNode_ = myMap.get(i + 1);

            for (int j = 0; j < people[0].length; j++) {
                if (i != j && people[i][j] == 1) {

                    // outgoing direction
                    Node_ outGoingNode_ = new Node_();
                    outGoingNode_.setNode_Name(j + 1);
                    currentRowNode_.getOutGoingDirection().add(outGoingNode_);

                    // incoming direction
                    Node_ inComingNode_ = new Node_();
                    inComingNode_.setNode_Name(i + 1);
                    Node_ currentColumnNode_ = myMap.get(j + 1);
                    currentColumnNode_.getIncomingDirection().add(inComingNode_);
                }
            }
        }
        return myMap;
    }
}

class Node_ {
    Integer Node_Name;
    List<Node_> outGoingDirection = new ArrayList<>();
    List<Node_> incomingDirection = new ArrayList<>();

    public Integer getNode_Name() {
        return Node_Name;
    }

    public void setNode_Name(Integer Node_Name) {
        this.Node_Name = Node_Name;
    }

    public List<Node_> getOutGoingDirection() {
        return outGoingDirection;
    }

    public void setOutGoingDirection(List<Node_> outGoingDirection) {
        this.outGoingDirection = outGoingDirection;
    }

    public List<Node_> getIncomingDirection() {
        return incomingDirection;
    }

    public void setIncomingDirection(List<Node_> incomingDirection) {
        this.incomingDirection = incomingDirection;
    }

    @Override
    public String toString() {
        return "Node_{" +
                "Node_Name=" + Node_Name +
                ", outGoingDirection=" + outGoingDirection +
                ", incomingDirection=" + incomingDirection +
                '}';
    }
}
