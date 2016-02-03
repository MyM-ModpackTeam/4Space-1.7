package mattparks.mods.space.io.dimension;

import mattparks.mods.space.io.IoCore;
import mattparks.mods.space.io.util.ConfigManagerIo;
import mattparks.mods.space.io.world.gen.ChunkProviderIo;
import mattparks.mods.space.io.world.gen.WorldChunkManagerIo;
import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.WorldProviderSpace;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.api.world.IGalacticraftWorldProvider;
import micdoodle8.mods.galacticraft.core.util.ConfigManagerCore;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WorldProviderIo extends WorldProviderSpace implements IGalacticraftWorldProvider {
	@Override
	public Vector3 getFogColor() {
		return new Vector3(182, 108, 10);
	}

	@Override
	public Vector3 getSkyColor() {
		return new Vector3(242, 145, 13);
	}

	@Override
	public boolean canRainOrSnow() {
		return false;
	}

	@Override
	public boolean hasSunset() {
		return false;
	}

	@Override
	public long getDayLength() {
		if (ConfigManagerIo.idDayLength == false) {
			return 24000L;
		}

		else {
			return 60000L;
		}
	}

	@Override
	public boolean shouldForceRespawn() {
		return !ConfigManagerCore.forceOverworldRespawn;
	}

	@Override
	public Class<? extends IChunkProvider> getChunkProviderClass() {
		return ChunkProviderIo.class;
	}

	@Override
	public Class<? extends WorldChunkManager> getWorldChunkManagerClass() {
		return WorldChunkManagerIo.class;
	}

	@Override
	public void setDimension(int var1) {
		this.dimensionId = var1;
		super.setDimension(var1);
	}

	@Override
	protected void generateLightBrightnessTable() {
		final float var1 = 0.0F;

		for (int var2 = 0; var2 <= 15; ++var2) {
			final float var3 = 1.0F - var2 / 15.0F;
			this.lightBrightnessTable[var2] = (1.0F - var3) / (var3 * 3.0F + 1.0F) * (1.0F - var1) + var1;
		}
	}

	@Override
	public float[] calcSunriseSunsetColors(float var1, float var2) {
		return null;
	}

	@Override
	public void registerWorldChunkManager() {
		this.worldChunkMgr = new WorldChunkManagerIo();
	}

	@SideOnly(Side.CLIENT)
	@Override
	public Vec3 getFogColor(float var1, float var2) {
		return Vec3.createVectorHelper((double) 210F / 255F, (double) 120F / 255F, (double) 59F / 255F);
	}

	@Override
	public Vec3 getSkyColor(Entity cameraEntity, float partialTicks) {
		return Vec3.createVectorHelper(154 / 255.0F, 114 / 255.0F, 66 / 255.0F);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public float getStarBrightness(float par1) {
		float f1 = this.worldObj.getCelestialAngle(par1);
		float f2 = 1.0F - (MathHelper.cos(f1 * (float) Math.PI * 2.0F) * 2.0F + 0.25F);

		if (f2 < 0.0F) {
			f2 = 0.0F;
		}

		if (f2 > 1.0F) {
			f2 = 1.0F;
		}

		return f2 * f2 * 0.75F;
	}

	@Override
	public float calculateCelestialAngle(long par1, float par3) {
		return super.calculateCelestialAngle(par1, par3);
	}

	public float calculatePhobosAngle(long par1, float par3) {
		return this.calculateCelestialAngle(par1, par3) * 3000;
	}

	public float calculateDeimosAngle(long par1, float par3) {
		return this.calculatePhobosAngle(par1, par3) * 0.0000000001F;
	}

	@Override
	public IChunkProvider createChunkGenerator() {
		return new ChunkProviderIo(this.worldObj, this.worldObj.getSeed(), this.worldObj.getWorldInfo().isMapFeaturesEnabled());
	}

	@Override
	public boolean isSkyColored() {
		return true;
	}

	@Override
	public double getHorizon() {
		return 44.0D;
	}

	@Override
	public int getAverageGroundLevel() {
		return 44;
	}

	@Override
	public boolean isSurfaceWorld() {
		return true;
	}

	@Override
	public boolean canCoordinateBeSpawn(int var1, int var2) {
		return true;
	}

	@Override
	public boolean canRespawnHere() {
		return !ConfigManagerCore.forceOverworldRespawn;
	}

	@Override
	public String getSaveFolder() {
		return "DIM" + ConfigManagerIo.idDimensionIo;
	}

	@Override
	public String getWelcomeMessage() {
		return "Entering Io";
	}

	@Override
	public String getDepartMessage() {
		return "Leaving Io";
	}

	@Override
	public String getDimensionName() {
		return "Io";
	}

	// @Override
	// public boolean canSnowAt(int x, int y, int z)
	// {
	// return false;
	// }

	@Override
	public boolean canBlockFreeze(int x, int y, int z, boolean byWater) {
		return false;
	}

	@Override
	public boolean canDoLightning(Chunk chunk) {
		return true;
	}

	@Override
	public boolean canDoRainSnowIce(Chunk chunk) {
		return false;
	}

	@Override
	public float getGravity() {
		return (float) (0.08D * (1 - 0.1835));
	}

	@Override
	public int getHeight() {
		return 800;
	}

	@Override
	public double getMeteorFrequency() {
		return 15.5D;
	}

	@Override
	public double getFuelUsageMultiplier() {
		return 1.2D;
	}

	@Override
	public boolean canSpaceshipTierPass(int tier) {
		return tier >= 3;
	}

	@Override
	public float getFallDamageModifier() {
		return 0.1835F;
	}

	@Override
	public float getSoundVolReductionAmount() {
		return 6.0F;
	}

	@Override
	public CelestialBody getCelestialBody() {
		return IoCore.moonIo;
	}

	@Override
	public boolean hasBreathableAtmosphere() {
		return false;
	}

	@Override
	public float getThermalLevelModifier() {
		return 6.0F;
	}

	@Override
	public float getWindLevel() {
		return 0.8F;
	}
}
