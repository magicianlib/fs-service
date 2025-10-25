package io.magicianlib.fs.facade;

import io.magicianlib.fs.config.LoggingDirValidator;
import io.magicianlib.fs.request.PageExcelListRequest;
import io.magicianlib.fs.response.PageExcelListResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class ExcelFacadeImpl implements ExcelFacade {
    private static final Logger LOGGER = LogManager.getLogger(LoggingDirValidator.class);
    public PageExcelListResponse page(PageExcelListRequest request) {
        LOGGER.info("测试 MDC");
        return new PageExcelListResponse();
    }
}