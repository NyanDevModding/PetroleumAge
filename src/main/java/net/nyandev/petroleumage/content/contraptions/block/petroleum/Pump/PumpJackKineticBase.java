package net.nyandev.petroleumage.content.contraptions.block.petroleum.Pump;

import com.simibubi.create.content.contraptions.base.HorizontalKineticBlock;
import com.simibubi.create.content.contraptions.base.KineticBlock;
import com.simibubi.create.content.contraptions.components.press.MechanicalPressTileEntity;
import com.simibubi.create.foundation.block.ITE;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.nyandev.petroleumage.TileEntitiesRegister;
import org.jetbrains.annotations.Nullable;

public class PumpJackKineticBase extends HorizontalKineticBlock implements ITE<PumpJackKineticBaseTileEntity> {
    public PumpJackKineticBase(Properties properties) {
        super(properties);
    }

    @Override
    public Direction.Axis getRotationAxis(BlockState state) {
        return Direction.Axis.X;
    }


    @Override
    public Class<PumpJackKineticBaseTileEntity> getTileEntityClass() {
        return PumpJackKineticBaseTileEntity.class;
    }

    @Override
    public BlockEntityType<? extends PumpJackKineticBaseTileEntity> getTileEntityType() {
        return TileEntitiesRegister.PUMP_JACK_KINETIC_BASE_TILE_ENTITY.get();
    }
}
