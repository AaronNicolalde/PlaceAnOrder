package eduanico.assignment;

import eduanico.assignment.model.CreditCard;
import eduanico.assignment.model.Product;
import eduanico.assignment.service.impl.ProjectServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PlacerAnOrderApplication {

	private static final ProjectServiceImpl service = new ProjectServiceImpl();

	public static void main(String[] args) {
		SpringApplication.run(PlacerAnOrderApplication.class, args);

		Product product = new Product(123, 100);
		CreditCard card = new CreditCard(4100);

		service.generateOrder(product,card);
	}
}
