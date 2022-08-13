package com.tutorial.AdvancedDSA.M19_Tries;

import java.util.HashMap;

public class TriesNode {
    public Character character;
    public Boolean isEnd;
    public HashMap<Character, TriesNode> children;
    public int count; //Special node for 1 problem

    public TriesNode() {
        this.isEnd = false;
        this.children = new HashMap<>();

        this.count = 1;
    }

    public TriesNode(Character ch) {
        this.character = ch;
        this.isEnd = false;
        this.children = new HashMap<>();

        this.count = 1;
    }
}
