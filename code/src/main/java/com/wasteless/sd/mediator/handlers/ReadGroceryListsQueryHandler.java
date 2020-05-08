package com.wasteless.sd.mediator.handlers;

import com.wasteless.sd.Service.GroceryListService;
import com.wasteless.sd.mediator.Handler;
import com.wasteless.sd.mediator.query.ReadGroceryListsQuery;
import com.wasteless.sd.mediator.response.ReadGroceryListsQueryResponse;

public class ReadGroceryListsQueryHandler implements Handler<ReadGroceryListsQuery, ReadGroceryListsQueryResponse> {

    private final GroceryListService groceryListService;

    public ReadGroceryListsQueryHandler(GroceryListService groceryListService) {
        this.groceryListService = groceryListService;
    }

    @Override
    public ReadGroceryListsQueryResponse handle(ReadGroceryListsQuery request) {
        return new ReadGroceryListsQueryResponse(groceryListService.findAllByUsername(request.getPrincipal()));
    }
}
