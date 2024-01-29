package com.practice.websocket.payload.server;

import com.google.common.collect.Lists;
import com.practice.websocket.model.server.Mem;
import com.practice.websocket.payload.KV;
import lombok.Data;

import java.util.List;

/**
 * 內存相关信息实体VO
 */
@Data
public class MemVO {
    List<KV> data = Lists.newArrayList();

    public static MemVO create(Mem mem) {
        MemVO vo = new MemVO();
        vo.data.add(new KV("内存总量", mem.getTotal() + "G"));
        vo.data.add(new KV("已用内存", mem.getUsed() + "G"));
        vo.data.add(new KV("剩余内存", mem.getFree() + "G"));
        vo.data.add(new KV("使用率", mem.getUsage() + "%"));
        return vo;
    }
}