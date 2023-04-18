package com.example.app;

import com.example.app.dao.EcoleRepository;
import com.example.app.dao.VoitureRepository;
import com.example.app.model.Ecole;
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
	@Autowired
	private EcoleRepository ecoleRepository;
	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);

	}


	@Override
	public void run(String... args) throws Exception {
		for (int i= 0; i<=20; i++){
			String[] villeArray= {"Paris","Marseille","Toulouse", "Nice", "Nantes", "Montpellier"};
			String[] addressText= {"2 Rue d'Artois","17 Avenue de la Motte-Picquet", "109 Rue Saint Honore", "27 Rue de la Ferronnerie", "10 Rue des Pyramides", "55 Rue de Plaisance", "14 Rue Perignon", "11 Rue Alexandrie", "8 Rue Guenot", "13 Rue du Commandant Rene Mouchotte", "66 Avenue Henri Martin", "3 Boulevard Saint-Michel", "109 Rue Quincampoix", "29 Rue Berger", "194 Rue Alesia", "15 Rue Monsieur le Prince", "33 Rue de Navarin", "40 Rue de Montreuil", "56 Rue des Rosiers", "112 Rue Saint-Maur", "19 Rue Duphot"};
			int rnd = new Random().nextInt(villeArray.length);

			int leftLimit = 97; // letter 'a'
			int rightLimit = 122; // letter 'z'
			int targetStringLength = 4;
			Random random = new Random();

			String generatedString = random.ints(leftLimit, rightLimit + 1)
					.limit(targetStringLength)
					.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
					.toString();

			int num1, num2, num3; //3 numbers in area code
			int set2, set3; //sequence 2 and 3 of the phone number

			Random generator = new Random();

//Area code number; Will not print 8 or 9
			num1 = generator.nextInt(7) + 1; //add 1 so there is no 0 to begin
			num2 = generator.nextInt(8); //randomize to 8 becuase 0 counts as a number in the generator
			num3 = generator.nextInt(8);


			set2 = generator.nextInt(643) + 100;

			set3 = generator.nextInt(8999) + 1000;
			String tel = "(" + num1 + "" + num2 + "" + num3 + ")" + "-" + set2 + "-" + set3;

			Ecole e = new Ecole("E-"+i+generatedString, addressText[i] +", 37000 "+ villeArray[rnd], tel);



			ecoleRepository.save(e);
		}

	}
}
