package io.magicianlib.fs.repository;

import io.magicianlib.fs.entity.ExportQueueEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ExportQueueEntityRepository extends JpaRepository<ExportQueueEntity, Long>, JpaSpecificationExecutor<ExportQueueEntity> {
}