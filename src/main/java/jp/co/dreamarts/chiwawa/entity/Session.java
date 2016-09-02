package jp.co.dreamarts.chiwawa.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * sessionテーブルのEntityクラス
 */
@Data
public class Session {
    private String companyId;
    private String loginId;
    private String accessToken;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;
}
