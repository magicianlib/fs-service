package io.magicianlib.fs.config.jpa;

import org.hibernate.HibernateException;
import org.hibernate.event.spi.DeleteContext;
import org.hibernate.event.spi.DeleteEvent;
import org.hibernate.event.spi.DeleteEventListener;
import org.springframework.stereotype.Component;

/**
 * Jpa 层面拦截器
 * <p>
 * 只能禁用单条 DELETE 操作，无法禁用批量删除
 * </p>
 *
 * @author magicianlib@gmail.com
 * @see SqlStatementDeleteInterceptor
 */
@Component
public class JpaDeleteEventListener implements DeleteEventListener {
    @Override
    public void onDelete(DeleteEvent event) throws HibernateException {
        handleDelete(event);
    }

    @Override
    public void onDelete(DeleteEvent event, DeleteContext transientEntities) throws HibernateException {
        handleDelete(event);
    }

    private void handleDelete(DeleteEvent event) {
        Object entity = event.getObject();
        throw new UnsupportedOperationException(
                "禁止物理删除，请使用软删除：" + entity.getClass().getSimpleName()
        );
    }
}