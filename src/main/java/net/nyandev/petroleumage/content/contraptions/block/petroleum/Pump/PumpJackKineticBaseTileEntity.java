package net.nyandev.petroleumage.content.contraptions.block.petroleum.Pump;

import com.simibubi.create.content.contraptions.base.HorizontalKineticBlock;
import com.simibubi.create.content.contraptions.base.KineticTileEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class PumpJackKineticBaseTileEntity extends KineticTileEntity {
    public PumpJackKineticBaseTileEntity(BlockEntityType<?> typeIn, BlockPos pos, BlockState state) {
        super(typeIn, pos, state);
    }

    @Override
    public void tick() {
        System.out.println(getSpeed());
        super.tick();
    }
}
