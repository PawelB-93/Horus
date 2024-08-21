package org.example;

import org.example.block.Block;
import org.example.block.CompositeBlock;
import org.example.block.impl.BlockImpl;
import org.example.block.impl.CompositeBlockImpl;
import org.example.structure.impl.Wall;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class WallTest {

    private Wall wall;

    @BeforeEach
    public void init() {
        final Block block1 = new BlockImpl("Silver", "Steel");
        final Block block2 = new BlockImpl("Brown", "Wood");
        final Block block3 = new BlockImpl("Grey", "Rock");
        final Block block4 = new BlockImpl("White", "Rock");

        final CompositeBlock compositeBlock = new CompositeBlockImpl("Yellow", "Wood", List.of(block1, block2));

        this.wall = new Wall(List.of(compositeBlock, block3, block4));
    }

    @Test
    public void testWhenFindBlockByColorIsUsedThenProperBlockShouldBeReturned() {
        //GIVEN
        //WHEN
        final Optional<Block> foundBlock = this.wall.findBlockByColor("Brown");
        //THEN
        assertTrue(foundBlock.isPresent());
        assertEquals("Brown", foundBlock.get().getColor());
        assertEquals("Wood", foundBlock.get().getMaterial());
    }

    @Test
    public void testWhenFindBlockByColorIsUsedAndBlockDoesNotExistThenOptionalEmptyShouldBeReturned() {
        //GIVEN
        //WHEN
        final Optional<Block> foundBlock = this.wall.findBlockByColor("Gold");
        //THEN
        assertTrue(foundBlock.isEmpty());
    }

    @Test
    public void testWhenFindBlocksByMaterialIsUsedThenProperBlocksShouldBeReturned() {
        //GIVEN
        //WHEN
        final List<Block> foundBlocks = this.wall.findBlocksByMaterial("Wood");
        //THEN
        assertEquals(2, foundBlocks.size());
    }

    @Test
    public void testWhenFindBlockByMaterialIsUsedThenEmptyListShouldBeReturned() {
        //GIVEN
        //WHEN
        final List<Block> foundBlocks = this.wall.findBlocksByMaterial("Concrete");
        //THEN
        assertTrue(foundBlocks.isEmpty());

    }

    @Test
    public void testWhenCountIsUsedThenTotalNumberOfBlocksShouldBeReturned() {
        //GIVEN
        //WHEN
        //THEN
        assertEquals(5, this.wall.count());
    }

    @Test
    public void testWhenCountIsUsedAndListIsEmptyThenZeroShouldBeReturned() {
        //GIVEN
        final Wall emptywall = new Wall(Collections.emptyList());
        //WHEN
        //THEN
        assertEquals(0, emptywall.count());
    }
}