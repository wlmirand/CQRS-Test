package com.framework.services;

import java.util.List;

public interface IService<T> {
    void processCommand(Command command);
    List<T> processQuery(Query query);
}
