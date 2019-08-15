package com.example.fyle.util;

import java.util.List;

public class PagedResult<T> {
    public static final long DEFAULT_OFFSET = 0;
    public static final int DEFAULT_MAX_NO_OF_ROWS = 100;
    private long offset;
    private long  limit;
    private long totalElements;
    private List<T> elements;
    public PagedResult(List<T> elements, long totalElements, long limit, long offset) {
        this.elements = elements;
        this.totalElements = totalElements;
        this.offset =  offset;
        this.limit = limit;
    }
    public boolean hasMore() {
        return totalElements > offset + limit;
    }
    public boolean hasPrevious() {
        return offset > 0 && totalElements > 0;
    }
    public long getTotalElements() {
        return totalElements;
    }
    public long  getOffset() {
        return offset;
    }
    public long getLimit() {
        return limit;
    }
    public List<T> getElements() {
        return elements;
    }
}
