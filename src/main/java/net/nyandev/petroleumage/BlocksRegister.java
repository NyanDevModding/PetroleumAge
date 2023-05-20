package net.nyandev.petroleumage;
import static com.simibubi.create.AllTags.pickaxeOnly;
import static com.simibubi.create.Create.REGISTRATE;

import com.simibubi.create.Create;
import com.simibubi.create.content.AllSections;
import com.simibubi.create.content.contraptions.relays.elementary.BracketedKineticBlockModel;
import com.simibubi.create.content.contraptions.relays.elementary.ShaftBlock;
import com.simibubi.create.foundation.block.BlockStressDefaults;
import com.simibubi.create.foundation.data.BlockStateGen;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.data.SharedProperties;
import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nyandev.petroleumage.CreatePetroleumAge;
import net.nyandev.petroleumage.content.contraptions.block.petroleum.OilPumpSupportBlock;
import net.nyandev.petroleumage.content.contraptions.block.petroleum.Pump.PumpJackKineticBase;

public class BlocksRegister {
//    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CreatePetroleumAge.MOD_ID);

//    public static final BlockEntry<ShaftBlock> AMOGUS_SHAFT = REGISTRATE.block("amogus_shaft", ShaftBlock::new)
//            .initialProperties(SharedProperties::stone)
//            .properties(p -> p.color(MaterialColor.METAL))
//            .transform(BlockStressDefaults.setNoImpact())
//            .transform(pickaxeOnly())
//            .blockstate(BlockStateGen.axisBlockProvider(false))
//            .onRegister(CreateRegistrate.blockModel(() -> BracketedKineticBlockModel::new))
//            .simpleItem()
//            .register();

    public static final BlockEntry<OilPumpSupportBlock> PUMP_SUPPORT = REGISTRATE.block("pump_support", OilPumpSupportBlock::new)
            .initialProperties(Material.METAL)
            .properties(p -> p.color(MaterialColor.METAL))
//            .transform(pickaxeOnly())
            .simpleItem()
            .register();

    public static final BlockEntry<PumpJackKineticBase> PUMP_JACK_KINETIC_BASE = REGISTRATE.block("pump_jack_base", PumpJackKineticBase::new)
            .initialProperties(Material.METAL)
            .properties(p -> p.color(MaterialColor.METAL))
//            .transform(pickaxeOnly())
            .simpleItem()
            .register();

    public static void register() {}
}
