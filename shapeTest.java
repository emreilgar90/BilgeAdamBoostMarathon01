package sinav;

import java.util.Scanner;
import java.util.Arrays;

public class shapeTest {
	private static final int MAX_ITEMS = 4; // bir sabit tanımladık, listeminiz büyüklüğünü belirlemek için
	private Scanner input;
	private Item[] items;
	private int itemCount;

	public static void main(String[] args) {
		shapeTest shapeTest = new shapeTest();

		shapeTest.itemCount = 0;
		shapeTest.items = new Item[MAX_ITEMS];

		shapeTest.menu();
		System.out.println("Bye....");

	}

	private void menu() {

		this.input = new Scanner(System.in);
		while (true) {
			int firstEdge = 0;
			int secondEdge = 0;
			int thirdEgde = 0;
			int fourthEdge = 0;

			System.out.println("**************************************");
			System.out.println("1-Dortgen Alan ve Cevre Hesaplama");
			System.out.println("2-Ucgen Alan ve Cevre Hesaplama");
			System.out.println("Lutfen seciminizi yapiniz:   ");
			System.out.println("**************************************");

			int selection = this.input.nextInt();
			input.nextLine();

			do {
				int i = 1;
				System.out.print("Lutfen " + i + ". kenar uzunlugunu giriniz (0 ile sonlandir): ");
				firstEdge = this.scanEdge(i);
				if (this.isEnd(firstEdge)) {
					return;
				}
				if (this.isExit(firstEdge)) {
					break;
				}
				i++;
				System.out.print("Lutfen " + i + ". kenar uzunlugunu giriniz (0 ile sonlandir): ");
				secondEdge = scanEdge(i);
				if (this.isEnd(secondEdge)) {
					return;
				}
				if (this.isExit(secondEdge)) {
					break;
				}
				i++;
				System.out.print("Lutfen " + i + ". kenar uzunlugunu giriniz (0 ile sonlandir): ");
				thirdEgde = scanEdge(i);
				if (this.isEnd(thirdEgde)) {
					return;
				}
				if (this.isExit(thirdEgde)) {
					break;
				}
				i++;
				System.out.print("Lutfen " + i + ". kenar uzunlugunu giriniz (0 ile sonlandir): ");
				fourthEdge = scanEdge(i);
				if (this.isEnd(fourthEdge)) {
					return;
				}
				if (this.isExit(fourthEdge)) {
					break;
				}
			} while (true);

			if (selection == 2) {
				break;
			}
			if (!this.processSelection(selection, firstEdge, secondEdge, thirdEgde, fourthEdge)) {
				System.err.println("Yanlis secim yaptiniz.Lutfen tekrar deneyin ");
				continue;
			}
		}
		this.input.close();
	}

	private boolean isExit(int edge) {
		if (edge == 0) {
			return true;
		}
		return false;
	}

	private boolean isEnd(int edge) {
		if (edge == -1) {
			return true;
		}
		return false;
	}

	private int scanEdge(int i) {
		int number = this.input.nextInt();
		return number;
	}

	private boolean processSelection(int selection, int firstEdge, int secondEdge, int thirdEgde, int fourthEdge) {
		boolean returnValue = true;

		switch (selection) {
		case 1:
			this.dortgenAlanHesapla(firstEdge, thirdEgde, secondEdge, fourthEdge);
			this.cevreHesapla(firstEdge, thirdEgde, secondEdge, fourthEdge);
			break;
		case 2:
			this.ucgenAlaniHesapla(firstEdge, thirdEgde, secondEdge);
			this.cevreHesapla(firstEdge, thirdEgde, secondEdge, fourthEdge);
		default:
			returnValue = false;
		}
		return returnValue;
	}

	private void cevreHesapla(int firstEdge, int thirdEgde, int secondEdge, int fourthEdge) {
		int sum = firstEdge + thirdEgde + secondEdge + fourthEdge;
		System.out.println("Toplam: " + sum);

	}

	private void ucgenAlaniHesapla(int firstEdge, int thirdEgde, int secondEdge) {
		int area = 0;
		int sum = firstEdge + secondEdge + thirdEgde;
		area = (int) Math.sqrt(sum * (sum - firstEdge) * (sum - secondEdge) * (sum - thirdEgde));
		System.out.println("Alan: " + area);

	}

	private void dortgenAlanHesapla(int firstEdge, int thirdEgde, int secondEdge, int fourthEdge) {
		int area = 0;
		area = (firstEdge + thirdEgde) * secondEdge / 2;
		System.out.println("Alan: " + area);

	}

}
