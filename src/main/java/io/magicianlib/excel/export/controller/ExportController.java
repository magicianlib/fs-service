package io.magicianlib.excel.export.controller;

import io.magicianlib.fs.entity.ExportQueueEntity;
import io.magicianlib.fs.repository.ExportQueueEntityRepository;
import jakarta.annotation.Resource;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExportController {
    @Resource
    private ExportQueueEntityRepository exportQueueEntityRepository;

    @Resource
    private TransactionTemplate transactionTemplate;

    @GetMapping("/findAll")
    public List<ExportQueueEntity> findAll() {
        return exportQueueEntityRepository.findAll();
    }
}