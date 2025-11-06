package io.magicianlib.fs.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.io.Serial;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * 导出队列
 */
@Getter
@Setter
@Accessors(chain = true)
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "export_queue", schema = "public")
public class ExportQueueEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = -4821162522775948414L;
    /**
     * 主键
     */
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    /**
     * 用户
     */
    @Column(name = "user_id", nullable = false)
    private Long userId;

    /**
     * 导出业务类型
     */
    @Column(name = "biz_type", nullable = false, length = Integer.MAX_VALUE)
    private String bizType;

    /**
     * 导出查询条件
     */
    @Column(name = "query_content", nullable = false, length = Integer.MAX_VALUE)
    private String queryContent;

    /**
     * 导出查询条件hash值
     */
    @Column(name = "query_hash", nullable = false, length = Integer.MAX_VALUE)
    private String queryHash;

    /**
     * 导出状态(wait:待处理, doing:处理中, success:处理成功: failure:处理失败, discard:已作废)
     */
    @Column(name = "status", length = Integer.MAX_VALUE)
    private String status;

    /**
     * 导出文件名
     */
    @Column(name = "file_name", nullable = false, length = Integer.MAX_VALUE)
    private String fileName;

    /**
     * 导出文件说明
     */
    @Column(name = "file_description", length = Integer.MAX_VALUE)
    private String fileDescription;

    /**
     * 导出文件类型(excel)
     */
    @Column(name = "file_type", nullable = false, length = Integer.MAX_VALUE)
    private String fileType;

    /**
     * 导出文件大小(字节)
     */
    @Column(name = "file_size")
    private Long fileSize;

    /**
     * 导出文件链接
     */
    @Column(name = "file_url", length = Integer.MAX_VALUE)
    private String fileUrl;

    /**
     * 导出统计信息
     */
    @Column(name = "stats")
    @JdbcTypeCode(SqlTypes.JSON)
    private ExportQueueEntityStats stats;

    /**
     * 开始执行时间
     */
    @Column(name = "start_time")
    private OffsetDateTime startTime;

    /**
     * 结束执行时间
     */
    @Column(name = "end_time")
    private OffsetDateTime endTime;

    /**
     * 导出失败原因
     */
    @Column(name = "failure_reason", length = Integer.MAX_VALUE)
    private String failureReason;

    /**
     * 备注信息
     */
    @Column(name = "remark", length = Integer.MAX_VALUE)
    private String remark;

    /**
     * 是否已删除(0:未删除, >0:已删除)
     */
    @Column(name = "deleted", nullable = false)
    private Long deleted;

    /**
     * 创建时间
     */
    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;

    /**
     * 更新时间
     */
    @Column(name = "updated_at", nullable = false)
    private OffsetDateTime updatedAt;

}