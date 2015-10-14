import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		ArrayList<Satellit> satelliten = new ArrayList<Satellit>();

		Satellit S1 = new Satellit(1, 2, 6);
		Satellit S2 = new Satellit(2, 3, 7);
		Satellit S3 = new Satellit(3, 4, 8);
		Satellit S4 = new Satellit(4, 5, 9);
		Satellit S5 = new Satellit(5, 1, 9);
		Satellit S6 = new Satellit(6, 2, 10);
		Satellit S7 = new Satellit(7, 1, 8);
		Satellit S8 = new Satellit(8, 2, 9);
		Satellit S9 = new Satellit(9, 3, 10);
		Satellit S10 = new Satellit(10, 2, 3);
		Satellit S11 = new Satellit(11, 3, 4);
		Satellit S12 = new Satellit(12, 5, 6);
		Satellit S13 = new Satellit(13, 6, 7);
		Satellit S14 = new Satellit(14, 7, 8);
		Satellit S15 = new Satellit(15, 8, 9);
		Satellit S16 = new Satellit(16, 9, 10);
		Satellit S17 = new Satellit(17, 1, 4);
		Satellit S18 = new Satellit(18, 2, 5);
		Satellit S19 = new Satellit(19, 3, 6);
		Satellit S20 = new Satellit(20, 4, 7);
		Satellit S21 = new Satellit(21, 5, 8);
		Satellit S22 = new Satellit(22, 6, 9);
		Satellit S23 = new Satellit(23, 1, 3);
		Satellit S24 = new Satellit(24, 4, 6);

		satelliten.add(S1);
		satelliten.add(S2);
		satelliten.add(S3);
		satelliten.add(S4);
		satelliten.add(S5);
		satelliten.add(S6);
		satelliten.add(S7);
		satelliten.add(S8);
		satelliten.add(S9);
		satelliten.add(S10);
		satelliten.add(S11);
		satelliten.add(S12);
		satelliten.add(S13);
		satelliten.add(S14);
		satelliten.add(S15);
		satelliten.add(S16);
		satelliten.add(S17);
		satelliten.add(S18);
		satelliten.add(S19);
		satelliten.add(S20);
		satelliten.add(S21);
		satelliten.add(S22);
		satelliten.add(S23);
		satelliten.add(S24);

		Bodenstation base = new Bodenstation(satelliten, args[0]);
		base.getAllMessagesFromSatellite();
	}

}
