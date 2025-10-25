package io.magicianlib.fs.controller;

import io.magicianlib.fs.entity.ExportQueueEntity;
import io.magicianlib.fs.facade.ExcelFacade;
import io.magicianlib.fs.repository.ExportQueueEntityRepository;
import io.magicianlib.fs.request.PageExcelListRequest;
import io.magicianlib.fs.response.PageExcelListResponse;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/excel")
public class ExcelController {
    @Resource
    private ExportQueueEntityRepository exportQueueEntityRepository;

    @Resource
    private ExcelFacade excelFacade;

    @GetMapping("/findAll")
    public List<ExportQueueEntity> findAll() {
        PageExcelListRequest request = new PageExcelListRequest();
        request.setPage(1);
        excelFacade.page(request);
       return exportQueueEntityRepository.findAll();
    }
}