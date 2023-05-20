package net.nyandev.petroleumage;

import com.tterrag.registrate.util.entry.BlockEntityEntry;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.nyandev.petroleumage.content.contraptions.block.petroleum.Pump.PumpJackKineticBaseTileEntity;

import static com.simibubi.create.Create.REGISTRATE;

public class TileEntitiesRegister {
    public static final BlockEntityEntry<PumpJackKineticBaseTileEntity> PUMP_JACK_KINETIC_BASE_TILE_ENTITY = REGISTRATE
            .tileEntity("pump_jack_kinetic_base", PumpJackKineticBaseTileEntity::new)
            .validBlock(BlocksRegister.PUMP_JACK_KINETIC_BASE)
            .register();

    public static void register() {}
}
