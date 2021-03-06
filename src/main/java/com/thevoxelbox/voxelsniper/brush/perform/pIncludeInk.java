/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thevoxelbox.voxelsniper.brush.perform;

import com.thevoxelbox.voxelsniper.Message;
import com.thevoxelbox.voxelsniper.SnipeData;
import com.thevoxelbox.voxelsniper.util.VoxelList;
import org.bukkit.block.Block;

/**
 * @author Voxel
 */
public class pIncludeInk extends vPerformer
{

    private VoxelList includeList;
    private byte data;

    public pIncludeInk()
    {
        name = "Include Ink";
    }

    @Override
    public void info(Message vm)
    {
        vm.performerName(name);
        vm.voxelList();
        vm.data();
    }

    @Override
    public void init(SnipeData v)
    {
        w = v.getWorld();
        data = v.getData();
        includeList = v.getVoxelList();
    }

    @SuppressWarnings("deprecation")
    @Override
    public void perform(Block b)
    {
        if (includeList.contains(new int[]{b.getTypeId(), b.getData()}))
        {
            h.put(b);
            b.setData(data);
        }
    }
}
