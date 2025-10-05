package com.qualityrailway.qr.blocks.df4d;

import com.qualityrailway.qr.ModBlockEntities;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class df4d_cab_door_a_Entity extends BlockEntity {
    // 方块实体的构造函数（需要2个参数）
    public df4d_cab_door_a_Entity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.df4d_cab_door_a.get(), pos, state);
        this.openingProgress = 0.0f;
        this.targetOpen = false;
        this.lastProgress = -1;
    }

    private float openingProgress;
    private boolean targetOpen;
    private int lastProgress;
}