package com.wasteless.sd.mediator.handlers;

import com.wasteless.sd.Service.GroceryListService;
import com.wasteless.sd.mediator.Handler;
import com.wasteless.sd.mediator.command.DeleteGroceryListCommand;
import com.wasteless.sd.mediator.response.GenericResponse;

public class DeleteGroceryListCommandHandler implements Handler<DeleteGroceryListCommand, GenericResponse> {

    private final GroceryListService groceryListService;

    public DeleteGroceryListCommandHandler(GroceryListService groceryListService) {
        this.groceryListService = groceryListService;
    }

    @Override
    public GenericResponse handle(DeleteGroceryListCommand request) {
        groceryListService.deleteGroceryList(request.getId());
        return new GenericResponse();
    }
}
