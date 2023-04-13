package com.example.app;

import com.example.app.dao.VoitureRepository;
import com.example.app.model.Voiture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Random;

@SpringBootApplication
public class AppApplication implements CommandLineRunner {
	@Autowired
	private VoitureRepository voitureRepository;
	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);

	}


	@Override
	public void run(String... args) throws Exception {
		for (int i= 0; i<=99; i++){
			String[] arrayColor= {"Rouge","Blanc","Bleu"};
			int rnd = new Random().nextInt(arrayColor.length);

			int leftLimit = 97; // letter 'a'
			int rightLimit = 122; // letter 'z'
			int targetStringLength = 10;
			Random random = new Random();

			String generatedString = random.ints(leftLimit, rightLimit + 1)
					.limit(targetStringLength)
					.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
					.toString();


			Voiture v = new Voiture(generatedString, 100.0 + i,arrayColor[rnd] );



			voitureRepository.save(v);
		}
		List all = voitureRepository.findAll();
		for(int i=0;i<all.size();i++){
			Voiture myV = (Voiture) all.get(i);

			System.out.println(i + 1+": Name: "+ myV.getName()+ " Prix: "+myV.getPrice()+ " Color: "+myV.getColor());
		}
	}
}
