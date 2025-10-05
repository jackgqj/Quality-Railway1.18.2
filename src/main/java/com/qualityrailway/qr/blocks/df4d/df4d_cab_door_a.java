package com.qualityrailway.qr.blocks.df4d;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import com.qualityrailway.qr.ModBlockEntities;

// DF4D驾驶室A侧滑动门方块实体类（处理动画逻辑）
public class df4d_cab_door_a extends BlockEntity {
    // 滑动进度（0.0为关闭，1.0为打开）
    private float openingProgress;
    // 目标状态（true为打开，false为关闭）
    private boolean targetOpen;
    // 动画速度（平滑滑动参数）
    private static final float ANIMATION_SPEED = 0.15f;
    // 性能优化：记录上一帧进度，避免无意义的更新
    private float lastProgress;

    public df4d_cab_door_a(BlockPos pos, BlockState state) {
        super(ModBlockEntities.DF4D_CAB_DOOR_A.get(), pos, state);
        this.openingProgress = 0.0f;
        this.targetOpen = false;
        this.lastProgress = -1;
    }

    // 每tick更新动画（仅在需要时更新）
    public void tick() {
        boolean needsUpdate = false;

        // 根据目标状态更新进度
        if (targetOpen && openingProgress < 1.0f) {
            openingProgress = Math.min(1.0f, openingProgress + ANIMATION_SPEED);
            needsUpdate = true;
        } else if (!targetOpen && openingProgress > 0.0f) {
            openingProgress = Math.max(0.0f, openingProgress - ANIMATION_SPEED);
            needsUpdate = true;
        }

        // 进度变化超过阈值时才同步（减少网络通信）
        if (needsUpdate && Math.abs(openingProgress - lastProgress) > 0.01f) {
            lastProgress = openingProgress;
            setChanged();
            level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 3);
        }
    }

    // 设置目标状态（避免无效调用）
    public void setTargetOpen(boolean targetOpen) {
        if (this.targetOpen != targetOpen) {
            this.targetOpen = targetOpen;
            setChanged();
        }
    }

    // 获取当前滑动进度
    public float getOpeningProgress() {
        return openingProgress;
    }

    // 保存数据到NBT
    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putFloat("Progress", openingProgress);
        tag.putBoolean("Target", targetOpen);
    }

    // 从NBT加载数据
    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        openingProgress = tag.getFloat("Progress");
        targetOpen = tag.getBoolean("Target");
        lastProgress = openingProgress;  // 同步进度记录
    }
}