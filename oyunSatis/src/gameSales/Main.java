package gameSales;

import java.util.Date;
import java.util.GregorianCalendar;

import gameSales.Abstract.CampaignService;
import gameSales.Abstract.CategoryService;
import gameSales.Abstract.OrderService;
import gameSales.Abstract.ProductService;
import gameSales.Abstract.UserService;
import gameSales.Adapter.MernisServiceAdapter;
import gameSales.Concrete.CampaignManager;
import gameSales.Concrete.CategoryManager;
import gameSales.Concrete.GameManager;
import gameSales.Concrete.OrderManager;
import gameSales.Concrete.PlayerCheckManager;
import gameSales.Concrete.PlayerManager;
import gameSales.Entity.Campaign;
import gameSales.Entity.Category;
import gameSales.Entity.Game;
import gameSales.Entity.Player;
import gameSales.Entity.Product;
import gameSales.Entity.User;

public class Main {

	public static void main(String[] args) {
		// Categories
		CategoryService categoryService = new CategoryManager();
		Category games = new Category(1, "Games", 0);
		Category category1 = new Category(2, "FPS", 1);
		Category category2 = new Category(3, "MMORPG", 1);
		categoryService.addBulk(new Category[] {games, category1, category2});
		System.out.println("");
		
		// Games
		ProductService productService = new GameManager();
		Product game1 = new Game(1, "Valorant", 
				"Valorant : 5'e 5, karakter tabanlý, taktiksel niþancýlýk oyunu.",
				35, 2, 1);
		Product game2 = new Game(2, "Metin2", 
				"Metin2 : Krallýðýnýn geleceðini korku, acý ve yýkýmdan kurtarmak için gücünü topla ve kýlýcýný çek!.", 
				0, 3, 2);
		productService.addBulk(new Product[] {game1, game2});	
		System.out.println("");
		
		// Players + IdentityNumberValidation
		UserService userService1 = new PlayerManager(new PlayerCheckManager(new MernisServiceAdapter()));
		User player1 = new Player(1, "1000", "Vedat", "Ýnan", "100000000", new GregorianCalendar(1996,5,5).getTime());
		User player2 = new Player(2, "1001", "Emre", "Sezer", "10000000", new GregorianCalendar(1996,6,7).getTime());
		userService1.addBulk(new User[] {player1, player2});
		System.out.println("");
		
		// Campaign
		CampaignService campaignService = new CampaignManager();
		Campaign campaign1 = new Campaign(1, "VALORX05", game1, "summer campaign", "", 50, 
				new GregorianCalendar(2021,5,1).getTime(), 
				new GregorianCalendar(2021,5,4).getTime()) ;
		campaignService.add(campaign1);
		System.out.println("");

		// Order
		OrderService orderService = new OrderManager(userService1,productService,campaignService);
		orderService.add(new Date(),1,1,1,1,35);
		System.out.println("");
	}

}
