package io.magicianlib.fs.facade;

import io.magicianlib.fs.request.PageExcelListRequest;
import io.magicianlib.fs.response.PageExcelListResponse;

public interface ExcelFacade {
    PageExcelListResponse page(PageExcelListRequest request);
}