package com.practice.socketio.payload;

import lombok.Data;

/**
 * 广播消息载荷
 */
@Data
public class BroadcastMessageRequest {
    /**
     * 消息内容
     */
    private String message;
}
