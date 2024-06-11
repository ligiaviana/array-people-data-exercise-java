package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Person;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Quantas pessoas serao digitadas? ");
		int n = sc.nextInt();
		Person[] vect = new Person[n];

		for (int i = 0; i < n; i++) {
			System.out.print("Altura da " + (i + 1) + "a" + " pessoa: ");
			double height = sc.nextDouble();
			System.out.print("Gênero da " + (i + 1) + "a" + " pessoa: ");
			char gender = sc.next().charAt(0);
			vect[i] = new Person(height, gender);
		}

		double maiorAltura = vect[0].getHeight();
		double menorAltura = vect[0].getHeight();
		for (int i = 0; i < n; i++) {
			if (vect[i].getHeight() > maiorAltura) {
				maiorAltura = vect[i].getHeight();
			}
			if (vect[i].getHeight() < menorAltura) {
				menorAltura = vect[i].getHeight();
			}

		}
		
		int numeroHomens = 0;
		int numeroMulheres = 0;
		double alturaFemTotal = 0.0;
		for (int i = 0; i < n; i++) {
			if (vect[i].getGender() == 'M') {
				numeroHomens++;
			} else {
				numeroMulheres++;
				alturaFemTotal += vect[i].getHeight();
			}
		}
		
		double avg = alturaFemTotal / numeroMulheres;

		System.out.printf("Maior altura = %.2f%n", maiorAltura);
		System.out.printf("Menor altura = %.2f%n", menorAltura);
		System.out.println("Numero de homens = " + numeroHomens);
		System.out.printf("Media das alturas das mulheres = %.2f%n", avg);

		sc.close();

	}
}
