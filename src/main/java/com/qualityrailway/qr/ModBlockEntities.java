package com.qualityrailway.qr;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import com.qualityrailway.qr.qr;
import com.qualityrailway.qr.blocks.df4d.df4d_cab_door_a; // 引入DF4D门实体类

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, qr.MODID);


    // 注册DF4D驾驶室A侧滑动门方块实体类型（新增）
    public static final RegistryObject<BlockEntityType<df4d_cab_door_a>> df4d_cab_door_a =
            BLOCK_ENTITIES.register("df4d_cab_door_a",
                    () -> BlockEntityType.Builder.of(df4d_cab_door_a::new,
                            ModBlocks.df4d_cab_door_a.get()).build(null));
}