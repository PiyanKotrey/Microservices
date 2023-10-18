package co.draxler.inventory_service;

import co.draxler.inventory_service.model.Inventory;
import co.draxler.inventory_service.reository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(InventoryRepository repository){
		return args -> {
			Inventory inventory = new Inventory();
			inventory.setSkuCode("iphone13");
			inventory.setQuantity(1);

			Inventory inventory2 = new Inventory();
			inventory2.setSkuCode("samsunge");
			inventory2.setQuantity(2);

			repository.save(inventory);
			repository.save(inventory2);
		};
	}
}
