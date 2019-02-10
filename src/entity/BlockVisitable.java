package entity;

import block.Block;

public interface BlockVisitable {
    void collide(Block block);
}
