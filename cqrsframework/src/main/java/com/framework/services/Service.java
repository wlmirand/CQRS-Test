package com.framework.services;


import java.util.List;
import java.util.Map;

/**
 * O CacheService ira processar Commands e Queries
 * Então ele precisa passar os Commands para os respectivos Handlers
 */
public abstract class Service<T> implements IService<T> {

    /**
     * Deve existir um Handler que sabe processar cada tipo de comando
     */
    private Map<Class, ICommandHandler<Command<T>>> mapCommands;

    /**
     * Outro Handler para Queries??
     */
    private Map<Class, IQueryHandler<Query<T>, T>> mapQueries;

    protected Service(
            Map<Class, ICommandHandler<Command<T>>> mapCommands,
            Map<Class, IQueryHandler<Query<T>, T>> mapQueries) {
        this.mapCommands = mapCommands;
        this.mapQueries = mapQueries;
    }

    /**
     * Envia um Command para o seu Handler
     * @param command
     */
    @Override
    public void processCommand(Command command) {
        ICommandHandler handler = mapCommands.get(command.getClass());
        handler.handle(command);
    }

    /**
     * Envia um Query para o seu Handler
     * @param query
     */
    @Override
    public List<T> processQuery(Query query) {
        IQueryHandler handler = mapQueries.get(query.getClass());
        return handler.handle(query);
    }
}
