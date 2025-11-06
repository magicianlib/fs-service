create database fs;

--
-- 导出队列
--
drop table if exists export_queue;
create table export_queue
(
    id               uuid
        constraint export_queue_pk default gen_random_uuid()
        primary key,
    user_id          bigint                   not null,
    biz_type         text                     not null,
    query_content    text                     not null,
    query_hash       text                     not null,
    status           text,
    file_name        text                     not null,
    file_description text,
    file_type        text                     not null,
    file_size        bigint,
    file_url         text,
    stats            jsonb,
    start_time       timestamp with time zone,
    end_time         timestamp with time zone,
    failure_reason   text,
    remark           text,
    deleted          bigint        default 0  not null,
    created_at       timestamp with time zone not null,
    updated_at       timestamp with time zone not null
);

comment on table export_queue is '导出队列';

comment on column export_queue.id is '主键';

comment on column export_queue.user_id is '用户';

comment on column export_queue.biz_type is '导出业务类型';

comment on column export_queue.query_content is '导出查询条件';

comment on column export_queue.query_hash is '导出查询条件hash值';

comment on column export_queue.status is '导出状态(wait:待处理, doing:处理中, success:处理成功: failure:处理失败, discard:已作废)';

comment on column export_queue.file_name is '导出文件名';

comment on column export_queue.file_description is '导出文件说明';

comment on column export_queue.file_type is '导出文件类型(excel)';

comment on column export_queue.file_size is '导出文件大小(字节)';

comment on column export_queue.file_url is '导出文件链接';

comment on column export_queue.stats is '导出统计信息';

comment on column export_queue.start_time is '开始执行时间';

comment on column export_queue.end_time is '结束执行时间';

comment on column export_queue.failure_reason is '导出失败原因';

comment on column export_queue.remark is '备注信息';

comment on column export_queue.deleted is '是否已删除(0:未删除, >0:已删除)';

comment on column export_queue.created_at is '创建时间';

comment on column export_queue.updated_at is '更新时间';

create index export_queue_idx_user_id_status
    on export_queue (user_id, status);

create index export_queue_idx_created_at
    on export_queue (created_at desc);

create index export_queue_idx_updated_at
    on export_queue (updated_at desc);