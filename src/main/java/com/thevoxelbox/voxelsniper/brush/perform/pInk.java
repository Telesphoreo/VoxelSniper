/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thevoxelbox.voxelsniper.brush.perform;

import com.thevoxelbox.voxelsniper.CoreProtectManager;
import com.thevoxelbox.voxelsniper.Message;
import com.thevoxelbox.voxelsniper.SnipeData;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

/**
 * @author Voxel
 */
public class pInk extends vPerformer
{

    private byte d;
    private Player player;

    public pInk()
    {
        name = "Ink";
    }

    @Override
    public void init(SnipeData v)
    {
        w = v.getWorld();
        d = v.getData();
        player = v.owner().getPlayer();
    }

    @Override
    public void info(Message vm)
    {
        vm.performerName(name);
        vm.data();
    }

    @SuppressWarnings("deprecation")
    @Override
    public void perform(Block b)
    {
        if (b.getType() != Material.AIR)
        {
            CoreProtectManager.getCoreProtectAPI().logRemoval(player.getName(), b.getLocation(), b.getType(), b.getData());
        }
        h.put(b);
        b.setData(d);
        CoreProtectManager.getCoreProtectAPI().logPlacement(player.getName(), b.getLocation(), b.getType(), d);
    }
}
