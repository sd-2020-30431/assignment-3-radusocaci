package com.wasteless.sd.mediator.handlers;

import com.wasteless.sd.Service.GroceryListService;
import com.wasteless.sd.mediator.Handler;
import com.wasteless.sd.mediator.command.CreateGroceryListCommand;
import com.wasteless.sd.mediator.response.CreateGroceryListCommandResponse;

public class CreateGroceryListCommandHandler implements Handler<CreateGroceryListCommand, CreateGroceryListCommandResponse> {

    private final GroceryListService groceryListService;

    public CreateGroceryListCommandHandler(GroceryListService groceryListService) {
        this.groceryListService = groceryListService;
    }

    @Override
    public CreateGroceryListCommandResponse handle(CreateGroceryListCommand request) {
        return new CreateGroceryListCommandResponse(groceryListService.save(request.getGroceryList()));
    }
}
