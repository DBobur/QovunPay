package org.example.service;

import org.example.model.Block;
import org.example.repository.BlockRepository;
import org.example.repository.UserRepository;

public class BlockService extends BaseService<Block, BlockRepository> {
    private static final BlockService blockService = new BlockService();
    private BlockService() {
        super(new BlockRepository());
    }

    public static BlockService getInstance(){
        return blockService;
    }

    @Override
    protected boolean checking(Block block) {
        return false;
    }
}
