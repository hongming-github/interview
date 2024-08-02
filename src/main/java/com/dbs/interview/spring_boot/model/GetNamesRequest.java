package com.dbs.interview.spring_boot.model;

import io.swagger.v3.oas.annotations.media.Schema;

public class GetNamesRequest {
    @Schema(name = "page", example = "0", requiredMode = Schema.RequiredMode.REQUIRED)
    private int page;

    @Schema(name = "size", example = "10", requiredMode = Schema.RequiredMode.REQUIRED)
    private int size;

    @Schema(name = "ascending", example = "true", requiredMode = Schema.RequiredMode.REQUIRED)
    private boolean ascending;

    private GetNamesRequest() {
    }

    public GetNamesRequest(int page, int size, boolean ascending) {
        this.page = page;
        this.size = size;
        this.ascending = ascending;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isAscending() {
        return ascending;
    }

    public void setAscending(boolean ascending) {
        this.ascending = ascending;
    }
}
