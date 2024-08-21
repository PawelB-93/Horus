package org.example.block.impl;

import org.example.block.Block;

public class BlockImpl implements Block {

    private final String color;
    private final String material;

    public BlockImpl(final String color, final String material) {
        this.color = color;
        this.material = material;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public String getMaterial() {
        return this.material;
    }
}
