package net.nyandev.petroleumage.content.contraptions.block.petroleum;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.nyandev.petroleumage.BlocksRegister;
import org.jetbrains.annotations.Nullable;

public class OilPumpSupportBlock extends Block {
    public static final EnumProperty<Direction.Axis> HORIZONTAL_AXIS = BlockStateProperties.HORIZONTAL_AXIS;
    public static final BooleanProperty SUPPORT_END = BooleanProperty.create("support_end");

    public OilPumpSupportBlock(Properties properties) {
        super(properties);
        registerDefaultState(this.getStateDefinition().any().setValue(HORIZONTAL_AXIS, Direction.Axis.X).setValue(SUPPORT_END, true));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(HORIZONTAL_AXIS, SUPPORT_END);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        if(!state.getValue(SUPPORT_END))
            return Block.box(1, 0, 1, 15, 16, 15);

        return super.getShape(state, getter, pos, context);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();

        if(isOilPumpSupport(level, pos.below()) && level.getBlockState(pos.below()).getValue(SUPPORT_END)) {
            level.setBlock(pos.below(), level.getBlockState(pos.below()).setValue(SUPPORT_END, false), 2) ;
        }
        return defaultBlockState().setValue(HORIZONTAL_AXIS, context.getHorizontalDirection().getAxis().isHorizontal() ? context.getHorizontalDirection().getAxis() : Direction.Axis.X).setValue(SUPPORT_END, isOilPumpSupport(level, pos.below()));
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean p_60519_) {
        System.out.println(newState + " : " + pos);
        if(state.getValue(SUPPORT_END) && isOilPumpSupport(level, pos.below()))
            level.setBlock(pos.below(), level.getBlockState(pos.below()).setValue(SUPPORT_END, true), 2);

        super.onRemove(state, level, pos, newState, p_60519_);
    }

//    @Override
//    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block nblock, BlockPos npos, boolean p_60514_) {
//        System.out.println("block : " + nblock);
//        System.out.println("pos : " + pos + "; npos : " + npos);
//        if(nblock == BlocksRegister.PUMP_SUPPORT.get() && level.getBlockState(npos).getBlock() != Block && (npos == pos.below() || npos == pos.above()))
//
//
//        super.neighborChanged(state, level, pos, nblock, npos, p_60514_);
//    }

    public boolean isOilPumpSupport(Level level, BlockPos pos) {
        return level.getBlockState(pos).getBlock() == BlocksRegister.PUMP_SUPPORT.get();
    }

    public void changeStateSupportEnd(Level level, BlockPos pos, BlockState state, boolean b) {
        if(level.getBlockState(pos).getBlock() == BlocksRegister.PUMP_SUPPORT.get()) {
            level.setBlock(pos, state.setValue(SUPPORT_END, b), 2);
        } else {
            System.out.println("*ERROR*petroleumage : Frr t'es sérieux ??? tu peux pas changer la blockstate d'un block qu'est pas un PumpSupport en PumpSupport (class : OilPumpSupportBlock)");
        }
    }
}
