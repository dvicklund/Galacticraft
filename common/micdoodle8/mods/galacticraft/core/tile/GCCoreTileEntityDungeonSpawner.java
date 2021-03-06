package micdoodle8.mods.galacticraft.core.tile;

import java.util.List;
import micdoodle8.mods.galacticraft.API.IDungeonBoss;
import micdoodle8.mods.galacticraft.API.IDungeonBossSpawner;
import micdoodle8.mods.galacticraft.core.entities.GCCoreEntitySkeletonBoss;
import micdoodle8.mods.galacticraft.moon.wgen.dungeon.GCRoomBoss;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import universalelectricity.core.vector.Vector3;
import universalelectricity.prefab.tile.TileEntityAdvanced;

public class GCCoreTileEntityDungeonSpawner extends TileEntityAdvanced implements IDungeonBossSpawner
{
    private IDungeonBoss boss;
    private boolean spawned = false;
    private boolean isBossDefeated = false;
    private boolean playerInRange;
    private boolean lastPlayerInRange;
    private GCRoomBoss room;

    @Override
    public void updateEntity()
    {
        super.updateEntity();

        if (!this.worldObj.isRemote)
        {
            final Vector3 thisVec = new Vector3(this);
            final List l = this.worldObj.getEntitiesWithinAABB(GCCoreEntitySkeletonBoss.class, AxisAlignedBB.getBoundingBox(thisVec.x - 15, thisVec.y - 15, thisVec.z - 15, thisVec.x + 15, thisVec.y + 15, thisVec.z + 15));

            for (final Entity e : (List<Entity>) l)
            {
                if (e instanceof GCCoreEntitySkeletonBoss)
                {
                    if (!e.isDead)
                    {
                        this.boss = (IDungeonBoss) e;
                        ((GCCoreEntitySkeletonBoss) this.boss).setRoom(this.room);
                        this.setBossSpawned(true);
                        this.setBossDefeated(false);
                    }
                }
            }

            if (this.boss == null && !this.getBossDefeated())
            {
                this.setBoss(new GCCoreEntitySkeletonBoss(this.worldObj, new Vector3(this).add(new Vector3(0.0D, 1.0D, 0.0D))));
                ((GCCoreEntitySkeletonBoss) this.boss).setRoom(this.room);
            }

            EntityPlayer closestPlayer = null;

            final Vector3 vec = new Vector3(this);
            closestPlayer = this.worldObj.getClosestPlayer(vec.x, vec.y, vec.z, 40.0D);

            this.playerInRange = closestPlayer != null;

            if (this.playerInRange && !this.lastPlayerInRange)
            {
                if (this.getBoss() != null && !this.getBossSpawned())
                {
                    if (closestPlayer != null && this.boss instanceof Entity)
                    {
                        this.worldObj.spawnEntityInWorld((Entity) this.boss);
                        this.setBossSpawned(true);
                        this.boss.onBossSpawned(this);
                        ((GCCoreEntitySkeletonBoss) this.boss).setRoom(this.room);
                    }
                }
            }

            if (this.getBossDefeated() && closestPlayer == null)
            {
                this.setBossDefeated(false);
            }

            this.lastPlayerInRange = this.playerInRange;
        }
    }

    public void setRoom(GCRoomBoss room)
    {
        this.room = room;
    }

    @Override
    public void setBossDefeated(boolean defeated)
    {
        this.isBossDefeated = defeated;
    }

    @Override
    public boolean getBossDefeated()
    {
        return this.isBossDefeated;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);

        this.setBossSpawned(nbt.getBoolean("spawned"));
        this.playerInRange = this.lastPlayerInRange = nbt.getBoolean("playerInRange");
        this.setBossDefeated(nbt.getBoolean("defeated"));
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt)
    {
        super.writeToNBT(nbt);

        nbt.setBoolean("spawned", this.getBossSpawned());
        nbt.setBoolean("playerInRange", this.playerInRange);
        nbt.setBoolean("defeated", this.getBossDefeated());
    }

    @Override
    public void setBossSpawned(boolean spawned)
    {
        this.spawned = spawned;
    }

    @Override
    public boolean getBossSpawned()
    {
        return this.spawned;
    }

    @Override
    public void setBoss(IDungeonBoss boss)
    {
        this.boss = boss;
    }

    @Override
    public IDungeonBoss getBoss()
    {
        return this.boss;
    }
}
