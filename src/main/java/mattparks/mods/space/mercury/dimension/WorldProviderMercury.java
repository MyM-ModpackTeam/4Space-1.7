package mattparks.mods.space.mercury.dimension;

import mattparks.mods.space.mercury.MercuryCore;
import mattparks.mods.space.mercury.util.ConfigManagerMercury;
import mattparks.mods.space.mercury.world.gen.ChunkProviderMercury;
import mattparks.mods.space.mercury.world.gen.WorldChunkManagerMercury;
import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.WorldProviderSpace;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.api.world.IGalacticraftWorldProvider;
import micdoodle8.mods.galacticraft.core.util.ConfigManagerCore;
import net.minecraft.util.MathHelper;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WorldProviderMercury extends WorldProviderSpace implements IGalacticraftWorldProvider {
	@Override
	public Vector3 getFogColor() {
		return new Vector3(0, 0, 0);
	}

	@Override
	public Vector3 getSkyColor() {
		return new Vector3(0, 0, 0);
	}

	@Override
	public boolean canRainOrSnow() {
		return false;
	}

	@Override
	public float calculateCelestialAngle(long par1, float par3) {
		final int var4 = (int) (par1 % 58320L);
		float var5 = (var4 + par3) / 58320.0F - 0.25F;

		if (var5 < 0.0F) {
			++var5;
		}

		if (var5 > 1.0F) {
			--var5;
		}

		final float var6 = var5;
		var5 = 1.0F - (float) ((Math.cos(var5 * Math.PI) + 1.0D) / 2.0D);
		var5 = var6 + (var5 - var6) / 3.0F;
		return var5;
	}

	public float calculateDeimosAngle(long par1, float par3) {
		return this.calculatePhobosAngle(par1, par3) * 0.0000000001F;
	}

	public float calculatePhobosAngle(long par1, float par3) {
		return this.calculateCelestialAngle(par1, par3) * 3000;
	}

	@Override
	public boolean hasSunset() {
		return false;
	}

	@Override
	public long getDayLength() {
		if (ConfigManagerMercury.idDayLength == false) {
			return 24000L;
		}

		else {
			return 5832000L;
		}
	}

	@Override
	public boolean shouldForceRespawn() {
		return !ConfigManagerCore.forceOverworldRespawn;
	}

	@Override
	public Class<? extends IChunkProvider> getChunkProviderClass() {
		return ChunkProviderMercury.class;
	}

	@Override
	public Class<? extends WorldChunkManager> getWorldChunkManagerClass() {
		return WorldChunkManagerMercury.class;
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
		this.worldChunkMgr = new WorldChunkManagerMercury();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public float getStarBrightness(float par1) {
		final float var2 = this.worldObj.getCelestialAngle(par1);
		float var3 = 1.0F - (MathHelper.cos(var2 * (float) Math.PI * 2.0F) * 2.0F + 0.25F);

		if (var3 < 0.0F) {
			var3 = 0.0F;
		}

		if (var3 > 1.0F) {
			var3 = 1.0F;
		}

		return var3 * var3 * 0.5F + 0.3F;
	}

	/*
	 * @Override public float calculateCelestialAngle(long par1, float par3) {
	 * return super.calculateCelestialAngle(par1, par3); }
	 * 
	 * public float calculatePhobosAngle(long par1, float par3) { return
	 * this.calculateCelestialAngle(par1, par3) * 3000; }
	 * 
	 * public float calculateDeimosAngle(long par1, float par3) { return
	 * this.calculatePhobosAngle(par1, par3) * 0.0000000001F; }
	 */
	@Override
	public IChunkProvider createChunkGenerator() {
		return new ChunkProviderMercury(this.worldObj, this.worldObj.getSeed(), this.worldObj.getWorldInfo().isMapFeaturesEnabled());
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
		return "DIM" + ConfigManagerMercury.idDimensionMercury;
	}

	@Override
	public String getWelcomeMessage() {
		return "Entering Mercury";
	}

	@Override
	public String getDepartMessage() {
		return "Leaving Mercury";
	}

	@Override
	public String getDimensionName() {
		return "Mercury";
	}

	// @Override
	// public boolean canSnowAt(int x, int y, int z)
	// {
	// return false;
	// }

	@Override
	public boolean canBlockFreeze(int x, int y, int z, boolean byWater) {
		if (this.isDaytime()) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean canDoLightning(Chunk chunk) {
		return false;
	}

	@Override
	public boolean canDoRainSnowIce(Chunk chunk) {
		return false;
	}

	@Override
	public float getGravity() {
		return (float) (0.08D * (1 - 0.378));
	}

	@Override
	public int getHeight() {
		return 800;
	}

	@Override
	public double getMeteorFrequency() {
		return 6.0D;
	}

	@Override
	public double getFuelUsageMultiplier() {
		return 0.6D;
	}

	@Override
	public boolean canSpaceshipTierPass(int tier) {
		return tier >= 2;
	}

	@Override
	public float getFallDamageModifier() {
		return 0.378F;
	}

	@Override
	public float getSoundVolReductionAmount() {
		return 10.0F;
	}

	@Override
	public CelestialBody getCelestialBody() {
		return MercuryCore.planetMercury;
	}

	@Override
	public boolean hasBreathableAtmosphere() {
		return false;
	}

	@Override
	public float getThermalLevelModifier() {
		if (this.isDaytime()) {
			return 6.0F;
		} else {
			return -6.0F;
		}
	}

	@Override
	public float getWindLevel() {
		return 0.2F;
	}
}
