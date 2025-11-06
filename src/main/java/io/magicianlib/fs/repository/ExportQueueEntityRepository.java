package io.magicianlib.fs.repository;

import io.magicianlib.fs.entity.ExportQueueEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface ExportQueueEntityRepository extends JpaRepository<ExportQueueEntity, UUID>, JpaSpecificationExecutor<ExportQueueEntity> {
}