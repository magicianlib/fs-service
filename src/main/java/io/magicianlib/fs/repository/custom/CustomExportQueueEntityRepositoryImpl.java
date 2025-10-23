package io.magicianlib.fs.repository.custom;

import io.magicianlib.fs.entity.ExportQueueEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaUpdate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomExportQueueEntityRepositoryImpl implements CustomExportQueueEntityRepository<ExportQueueEntity, Long> {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public int updateByExample() {
        CriteriaUpdate<ExportQueueEntity> update = entityManager.getCriteriaBuilder().createCriteriaUpdate(ExportQueueEntity.class);
        CriteriaUpdate<ExportQueueEntity> criteria = entityManager.getCriteriaBuilder().createCriteriaUpdate(ExportQueueEntity.class);
        return 0;
    }
}