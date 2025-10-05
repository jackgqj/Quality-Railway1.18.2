package com.qualityrailway.qr;

import com.qualityrailway.qr.blocks.df4d.df4d_cab_door_a_Entity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import com.qualityrailway.qr.qr;
import com.qualityrailway.qr.blocks.df4d.df4d_cab_door_a;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, qr.MODID);


    // 注册DF4D驾驶室A侧滑动门方块实体类型（修复后）
    // 注册方块实体（关联到对应的方块）
    public static final RegistryObject<BlockEntityType<df4d_cab_door_a_Entity>> df4d_cab_door_a =
            BLOCK_ENTITIES.register("df4d_cab_door_a",
                    () -> BlockEntityType.Builder.of(df4d_cab_door_a_Entity::new,
                            ModBlocks.df4d_cab_door_a.get()).build(null));
}