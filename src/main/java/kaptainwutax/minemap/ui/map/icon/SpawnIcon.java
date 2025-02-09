package kaptainwutax.minemap.ui.map.icon;

import kaptainwutax.featureutils.Feature;
import kaptainwutax.featureutils.misc.SpawnPoint;
import kaptainwutax.mcutils.util.pos.BPos;
import kaptainwutax.minemap.ui.map.MapContext;
import kaptainwutax.minemap.ui.map.fragment.Fragment;
import kaptainwutax.terrainutils.TerrainGenerator;
import kaptainwutax.terrainutils.terrain.OverworldTerrainGenerator;

import java.util.List;

public class SpawnIcon extends StaticIcon {

    private final BPos pos;

    public SpawnIcon(MapContext context) {
        super(context);
        TerrainGenerator generator = this.getContext().getTerrainGenerator();
        this.pos = generator instanceof OverworldTerrainGenerator ? SpawnPoint.getSpawn((OverworldTerrainGenerator) generator) : null;
    }

    public BPos getPos() {
        return this.pos;
    }

    @Override
    public boolean isValidFeature(Feature<?, ?> feature) {
        return feature instanceof SpawnPoint;
    }

    @Override
    public void addPositions(Feature<?, ?> feature, Fragment fragment, List<BPos> positions) {
        if (this.getPos() != null) {
            positions.add(this.getPos());
        }
    }

}
