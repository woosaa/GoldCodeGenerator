import java.util.Arrays;

public class Satellit {
	private int id;
	private int registerSumme1;
	private int registerSumme2;
	private boolean[] chipSequenz = null;

	public Satellit(int id, int registerSumme1, int registerSumme2) {
		this.id = id;
		this.registerSumme1 = registerSumme1;
		this.registerSumme2 = registerSumme2;
		generateChipSequence();
	}

	public int getId() {
		return id;
	}

	public boolean[] getChipSequenz() {
		if (chipSequenz == null) {
			generateChipSequence();
		}
		return chipSequenz;
	}

	private void generateChipSequence() {
		chipSequenz = new boolean[1023];
		boolean[] mutterfolge = new boolean[10];
		boolean[] mutterfolge2 = new boolean[10];

		for (int i = 0; i < mutterfolge.length; i++) {
			mutterfolge[i] = true;
			mutterfolge2[i] = true;
		}

		for (int i = 0; i < chipSequenz.length; i++) {
			boolean letzte = mutterfolge[mutterfolge.length - 1];
			boolean pos2 = mutterfolge[2];
			boolean neue0 = letzte ^ pos2;

			boolean letzteM2 = mutterfolge2[mutterfolge2.length - 1];

			boolean pos1M2 = mutterfolge2[1];
			boolean pos2M2 = mutterfolge2[2];
			boolean pos5M2 = mutterfolge2[5];
			boolean pos7M2 = mutterfolge2[7];
			boolean pos8M2 = mutterfolge2[8];

			boolean neue0M2 = letzteM2 ^ pos1M2 ^ pos2M2 ^ pos5M2 ^ pos7M2
					^ pos8M2;

			chipSequenz[i] = (mutterfolge2[registerSumme1 - 1] ^ mutterfolge2[registerSumme2 - 1])
					^ letzte;

			for (int j = mutterfolge.length - 1; j > 0; j--) {
				mutterfolge[j] = mutterfolge[j - 1];
			}
			mutterfolge[0] = neue0;
			// Neue Mutterfolge 1 shift

			for (int j = mutterfolge2.length - 1; j > 0; j--) {
				mutterfolge2[j] = mutterfolge2[j - 1];
			}

			mutterfolge2[0] = neue0M2;
			// Neue Mutterfolge 2 shift

		}

	}
}
