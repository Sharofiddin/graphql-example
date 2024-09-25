package uz.learn;

import java.util.List;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import uz.learn.core.entity.Order;

@Path("/api/v1/orders")
public class OrderResource {
    
	
    @GET
    @Path("/{username}")
    public Uni<List<Order>> getOrdersByUserName(@PathParam("username") String username) {
        return Order.findByUserName(username);
    }
}
