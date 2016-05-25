package com.projecttango.experiments.javapointcloud;

import java.util.List;

/**
 * Created by Sarah on 2/4/16.
 */
public class MyBuffer {
    private List<Short> right;
    private List<Short> left;

    public MyBuffer(List<Short> right, List<Short> left) {
        this.right = right;
        this.left = left;
    }

    public List<Short> getRight() {
        return right;

    }

    public List<Short> getLeft() {
        return left;
    }
}
