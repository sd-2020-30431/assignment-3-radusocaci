package com.wasteless.sd.mediator;

import com.wasteless.sd.Service.GroceryListService;
import com.wasteless.sd.mediator.command.CreateGroceryListCommand;
import com.wasteless.sd.mediator.command.DeleteGroceryListCommand;
import com.wasteless.sd.mediator.handlers.CreateGroceryListCommandHandler;
import com.wasteless.sd.mediator.handlers.DeleteGroceryListCommandHandler;
import com.wasteless.sd.mediator.handlers.ReadGroceryListsQueryHandler;
import com.wasteless.sd.mediator.query.ReadGroceryListsQuery;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

@Component
public class Mediator {

    private final GroceryListService groceryListService;

    private final Map<Class<? extends Request>, Class<? extends Handler<? extends Request, ? extends Response>>> handlerMapper;

    public Mediator(GroceryListService groceryListService) {
        this.groceryListService = groceryListService;
        this.handlerMapper = new HashMap<>();
        handlerMapper.put(ReadGroceryListsQuery.class, ReadGroceryListsQueryHandler.class);
        handlerMapper.put(CreateGroceryListCommand.class, CreateGroceryListCommandHandler.class);
        handlerMapper.put(DeleteGroceryListCommand.class, DeleteGroceryListCommandHandler.class);
    }

    public <T extends Request, R extends Response> Handler<T, R> handle(T request) {
        Class<? extends Handler<? extends Request, ? extends Response>> handlerType = handlerMapper.get(request.getClass());
        Handler<T, R> requestHandler = null;

        try {
            Constructor<?> constructor = handlerType.getConstructors()[0];
            requestHandler = (Handler<T, R>) constructor.newInstance(groceryListService);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return requestHandler;
    }
}
