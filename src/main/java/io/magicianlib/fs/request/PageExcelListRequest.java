package io.magicianlib.fs.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

public class PageExcelListRequest extends AbstractRequest {
    @NotNull
    private Integer page;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }
}