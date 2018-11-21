package com.framework.services;

import java.util.List;

public interface IQueryHandler<IN extends Query, OUT> {
    List<OUT> handle(IN query);
}
