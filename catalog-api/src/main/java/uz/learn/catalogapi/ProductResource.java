package uz.learn.catalogapi;

import java.util.List;

import io.quarkus.mongodb.panache.common.reactive.ReactivePanacheUpdate;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import uz.learn.catalogapi.entity.Product;
import uz.learn.catalogapi.repository.ProductRepository;

@Path("/api/v1/products")
public class ProductResource {
   private final ProductRepository repo;
   
   public ProductResource(ProductRepository productRepository) {
	   this.repo = productRepository;
   }
   
   @GET
   public Uni<List<Product>> getProducts(){
	   return repo.getProducts();
   }
   
   @GET
   @Path("/category/{category}")
   public Uni<List<Product>> getProductsByCategory(@PathParam("category")  String category){
	   return repo.getProductsByCategory(category);
   }
   
   @GET
   @Path("/{id}")
   public Uni<Product> getProductsById(@PathParam("id")  String id){
	   return repo.getById(id);
   }
   
   @POST
   public Uni<Response> addProduct( Product product){
	   return repo.persist(product)
			   .onItem().transform(item->Response.noContent().build());
   }
   
   @PUT
   public Uni<Response> updateProduct(Product product){
	   return repo.update(product)
			   .onItem()
			   .transform(item-> Response.ok(Boolean.TRUE).build());
	   
   }
   
   @DELETE
   @Path("/{id}")
   public Uni<Response> deleteProduct(@PathParam("id") String id){
	  return repo.deleteById(id).onItem().transform(res->Response.ok(res).build());
   }
}
