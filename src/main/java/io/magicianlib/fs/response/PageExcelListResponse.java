package io.magicianlib.fs.response;

import jakarta.validation.constraints.NotNull;

public class PageExcelListResponse extends AbstractResponse {
    @NotNull
    private Long page;

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }
}