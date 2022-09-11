package main.tutorial.AdvancedDSA.M19_Tries;

import java.util.HashMap;

public class TriesNodeBit {
    public Integer bit;
    public Boolean isEnd;
    public HashMap<Integer, TriesNodeBit> children;

    public TriesNodeBit() {
        this.isEnd = false;
        this.children = new HashMap<>();
    }

    public TriesNodeBit(Integer val) {
        this.bit = val;
        this.isEnd = false;
        this.children = new HashMap<>();
    }
}
