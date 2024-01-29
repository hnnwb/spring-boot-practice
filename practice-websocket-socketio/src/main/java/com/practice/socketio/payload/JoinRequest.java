package com.practice.socketio.payload;

import lombok.Data;

/**
 * 加群载荷
 */
@Data
public class JoinRequest {
    /**
     * 用户id
     */
    private String userId;

    /**
     * 群名称
     */
    private String groupId;
}
