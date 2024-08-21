package org.example.structure.impl;

import org.example.block.Block;
import org.example.block.CompositeBlock;
import org.example.structure.Structure;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Wall implements Structure {
    private final List<Block> blocks;

    public Wall(final List<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    public Optional<Block> findBlockByColor(final String color) {
        return this.findBlocksByColorInComposite(this.blocks, color);
    }

    @Override
    public List<Block> findBlocksByMaterial(final String material) {
        return this.findBlocksByMaterialInComposite(this.blocks, material);
    }

    @Override
    public int count() {
        return this.countBlocks(this.blocks);
    }

    private int countBlocks(final List<Block> blocks) {
        int count = 0;
        for (Block block : blocks) {
            count++;
            if (block instanceof CompositeBlock) {
                count += countBlocks(((CompositeBlock) block).getBlocks());
            }
        }
        return count;
    }

    private Optional<Block> findBlocksByColorInComposite(final List<Block> blocks, final String color) {
        for (Block block : blocks) {
            if (color.equals(block.getColor())) {
                return Optional.of(block);
            }
            if (block instanceof CompositeBlock) {
                Optional<Block> found = findBlocksByColorInComposite(((CompositeBlock) block).getBlocks(), color);
                if (found.isPresent()) {
                    return found;
                }
            }
        }
        return Optional.empty();
    }

    private List<Block> findBlocksByMaterialInComposite(final List<Block> blocks, final String material) {
        List<Block> foundBlocks = new ArrayList<>();
        for (Block block : blocks) {
            if (material.equals(block.getMaterial())) {
                foundBlocks.add(block);
            }
            if (block instanceof CompositeBlock) {
                foundBlocks.addAll(findBlocksByMaterialInComposite(((CompositeBlock) block).getBlocks(), material));
            }
        }
        return foundBlocks;
    }
}
