package io.magicianlib.fs.repository.custom;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import io.magicianlib.fs.entity.ExportQueueEntity;
import io.magicianlib.fs.entity.QExportQueueEntity;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class CustomExportQueueEntityRepositoryImpl implements CustomExportQueueEntityRepository<ExportQueueEntity, Long> {

    private final JPAQueryFactory jpaQueryFactory;

    public CustomExportQueueEntityRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public int updateByExample() {
        QExportQueueEntity entity = QExportQueueEntity.exportQueueEntity;

        ExportQueueEntity record = jpaQueryFactory.selectFrom(entity).where(entity.id.eq(UUID.randomUUID())).fetchOne();

        BooleanBuilder condition = new BooleanBuilder();
        condition.or(condition.or(entity.bizType.eq("")));

        // jpaQueryFactory.update(entity).set(entity.bizType, "").where()

        return 0;
    }
}