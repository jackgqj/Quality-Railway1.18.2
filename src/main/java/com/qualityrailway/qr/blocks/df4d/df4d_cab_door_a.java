// 文件路径：blocks/df4d/df4d_cab_door_a.java
package com.qualityrailway.qr.blocks.df4d;

import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;


public class df4d_cab_door_a extends DoorBlock {

    // 方块的构造函数：接收BlockBehaviour.Properties作为参数（1个参数）
    public df4d_cab_door_a(BlockBehaviour.Properties properties) {
        super(properties);
        // 初始化代码（如果需要）
        this.openingProgress = 0.0f;
        this.targetOpen = false;
        this.lastProgress = -1;
    }

    // 保留你的其他字段和方法（如openingProgress等）
    private float openingProgress;
    private boolean targetOpen;
    private int lastProgress;
}