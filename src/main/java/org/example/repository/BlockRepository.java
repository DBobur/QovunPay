package org.example.repository;

import org.example.model.Block;

public class BlockRepository extends BaseRepository<Block> {
    {
        path += "blocks.json";
        type = Block.class;
    }
}
