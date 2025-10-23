package io.magicianlib.fs.config.jpa;

import org.hibernate.resource.jdbc.spi.StatementInspector;
import org.springframework.stereotype.Component;

/**
 * 底层 SQL 层面拦截器
 * <p>
 * 直接拦截 DELETE 语句
 * </p>
 *
 * @author Zhang Shilin <br> zhangshilin@shop2cn.com
 * @see JpaDeleteEventListener
 * @since 2025/10/23 15:51
 */
@Component
public class SqlStatementDeleteInterceptor implements StatementInspector {
    @Override
    public String inspect(String sql) {
        sql = sql.toLowerCase().trim();
        if (sql.startsWith("delete from") || sql.startsWith("delete ")) {
            throw new UnsupportedOperationException("拦截器已禁用批量物理删除操作，请使用 update 软删除");
        }
        return sql;
    }
}