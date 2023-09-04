package org.sample.ageofwar;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.sample.ageofwar.functions.PlatoonParser;
import org.sample.ageofwar.functions.PlatoonPrinter;
import org.sample.ageofwar.models.Platoon;
import org.sample.ageofwar.service.PlatoonBattleService;

public class App {

	public static void main(String[] args) {

		System.out.println("Welcome to Age of War!");
		System.out.println("Please enter your platoons and opponent platoons in separate lines in the following format:");
		System.out.println("ClassType1#NumberOfSoldiers1;ClassType2#NumberOfSoldiers2;...");
		System.out.println("For example: Spearmen#10;Militia#30;FootArcher#20;...");


		Scanner scanner = new Scanner(System.in);

		String[] yourPlatoonsInput = scanner.nextLine().split(";");
		String[] opponentPlatoonsInput = scanner.nextLine().split(";");

		PlatoonParser platoonParser = new PlatoonParser();
		PlatoonPrinter platoonPrinter = new PlatoonPrinter();

		List<Platoon> yourPlatoons = Arrays.stream(yourPlatoonsInput)
				.map(platoonParser)
				.collect(Collectors.toList());

		List<Platoon> opponentPlatoons = Arrays.stream(opponentPlatoonsInput)
				.map(platoonParser)
				.collect(Collectors.toList());


		List<Platoon> validArrangement = PlatoonBattleService.findValidArrangement(yourPlatoons, opponentPlatoons);

		System.out.println("Result:");

		if (validArrangement != null) {
			validArrangement.forEach(platoonPrinter);
		} else {
			System.out.println("There is no chance of winning");
		}

		scanner.close();
	}
}
