package org.example.block.impl;

import org.example.block.Block;
import org.example.block.CompositeBlock;

import java.util.List;

public class CompositeBlockImpl implements CompositeBlock {

    private final String color;
    private final String material;
    private final List<Block> blocks;

    public CompositeBlockImpl(final String color, final String material, final List<Block> blocks) {
        this.color = color;
        this.material = material;
        this.blocks = blocks;
    }

    @Override
    public List<Block> getBlocks() {
        return this.blocks;
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
