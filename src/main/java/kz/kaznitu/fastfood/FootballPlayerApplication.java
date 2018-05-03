package kz.kaznitu.fastfood;

import kz.kaznitu.fastfood.models.Server;
import kz.kaznitu.fastfood.repositories.ServerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FootballPlayerApplication implements CommandLineRunner {

	@Autowired
	ServerRepository clubRepository;

	public static void main(String[] args) {
		SpringApplication.run(FootballPlayerApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception{

		Server server1 = new Server();
		server1.setName("Бокс-мастер");
		server1.setPrice(1600);

		Server server2 = new Server();
		server2.setName("Твистер");
		server2.setPrice(1250);

		clubRepository.save(server1);
		clubRepository.save(server2);
	}
}
