package io.magicianlib.fs.facade;

import io.magicianlib.fs.request.PageExcelListRequest;
import io.magicianlib.fs.result.PageResult;

public interface ExcelFacade {
    PageResult<?> page(PageExcelListRequest request);
}