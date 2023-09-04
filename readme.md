# Age of War

Age of War is a Java console application that allows you to simulate battles between platoons of different soldier classes. The program helps you find the best arrangement of your platoons to win a majority of battles against your opponent.

In general, one soldier of your platoon will be able to handle one soldier of your opponent's platoon
- If your platoon has 100 soldiers and your opponent's platoon has:
* 99 soldiers - You Win
* 100 soldiers - Draw
* 101 soldiers - You Lose

## Platoon Classes
There are 6 classes of soldiers:
- Militia
- Spearmen
- Light Cavalry
- Heavy Cavalry
- Foot Archer
- Cavalry Archer

Each class of soldier has an advantage over other classes of soldiers:

|Unit Class |Advantage Over|
|---|---|
|Militia | Spearmen, LightCavalry|
|Spearmen | LightCavalry, HeavyCavalry|
|LightCavalry | FootArcher, CavalryArcher|
|HeavyCavalry | Militia, FootArcher, LightCavalry|
|CavalryArcher | Spearmen, HeavyCavalry |
|FootArcher | Militia, CavalryArcher |

The soldiers who have advantage over the opponent, will be able to handle twice the amount of opponent's soldiers
If your platoon has 100 Spearmen and your opponent's platoon has:
* 199 HeavyCavalry - You Win
* 200 HeavyCavalry - Draw
* 201 HeavyCavalry - You Lose


## Table of Contents
- [Requirements](#requirements)
- [How to Use](#how-to-use)
- [Program Description](#program-description)
- [Classes](#classes)
- [Sample Input and Output](#sample-input-and-output)

## Requirements

Before running the Platoon Battle Program, ensure that you have the following requirements installed on your system:

- **Java 8+** : You need Java 8 or higher to run this program.
- **Maven 3.6+** : Maven is required for compiling and managing dependencies.


## How to Use

1. Navigate to the `age-of-war` directory.
```
cd age-of-war
```

2. Compile the Java code using the following command: 
```
mvn clean install
```

3. Run the program using the following command:
```
java -jar target/age-of-war-0.0.1.jar
```
4. Follow the on-screen instructions to enter your platoons and your opponent's platoons in the specified format.

## Program Description

The Platoon Battle Program allows you to input platoons with different soldier classes and their respective numbers. The program then calculates the best arrangement of your platoons to win a majority of battles against your opponent based on class advantages and soldier counts.

### Classes

- `Platoon`: Represents a platoon with classType and the number of soldiers. It also provides a method to calculate the advantage of the current platoon classType with another.

- `PlatoonParser`: Implements the `Function<String, Platoon>` interface to parse platoon information from a string.

- `PlatoonPrinter`: Implements the `Consumer<Platoon>` interface to print platoon information to the console.

- `PlatoonBattleService`: Contains the main logic of the program. It calculates the maximum wins for each battle and determines the best arrangement of platoons to achieve at least three wins.

### Sample Input and Output

The program expects 2 line input in the following format:
ClassType1#NumberOfSoldiers1;ClassType2#NumberOfSoldiers2;..
- 1st Line: Your Platoons
- 2nd Line: Opponent Platoons
- For example:
```
Spearmen#10;Militia#30;FootArcher#20;LightCavalry#1000;HeavyCavalry#120
Militia#10;Spearmen#10;FootArcher#1000;LightCavalry#120;CavalryArcher#100
```


After processing the input, the program provides a valid arrangement of platoons with >=3 wins.

- Sample Output:
```
Result:
Spearmen#10;Militia#30;FootArcher#20;HeavyCavalry#120;LightCavalry#1000;

```

- Another example:
```
Militia#100;FootArcher#200;Spearmen#10;LightCavalry#30;CavalryArcher#10
Militia#15;Spearmen#100;FootArcher#200;LightCavalry#50;CavalryArcher#100
```

- Output:
```
Result:
There is no chance of winning
```
