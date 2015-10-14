import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Bodenstation {
	private ArrayList<Satellit> satelliten;
	private String[] summSignal;

	public Bodenstation(ArrayList<Satellit> satelliten, String recSummenSignal) {
		this.satelliten = satelliten;
		System.out.println("Summensignal lesen... bitte warten");
		FileReader fileReader;
		try {
			fileReader = new FileReader(recSummenSignal);
			BufferedReader reader = new BufferedReader(fileReader);

			String zeile = reader.readLine();
			summSignal = zeile.split(" ");

			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void getMessageFromSatellit(Satellit sat) {

        int erg = 0;
        int delta = 0;
		String[] sumSignalCopy;
        sumSignalCopy = summSignal.clone();

		for(int i = 0; i < sumSignalCopy.length; i++) {

			for (int j = 0; j < sumSignalCopy.length; j++) {

                int sumSig = Integer.parseInt(sumSignalCopy[j]);
                int sigSat = sat.getChipSequenz()[j] ? 1 : -1;

                erg += sumSig * sigSat;
            }

            if(erg < -800) {
                System.out.println("Satellit " + sat.getId() + "\t" + "Wert: " + 0 + " Delta: " + delta);
            } else if (erg > 800) {
                System.out.println("Satellit " + sat.getId() + "\t" + "Wert: " + 1 + " Delta: " + delta);
            }

            erg = 0;
            delta++;
            this.shift(sumSignalCopy);
		}
	}

	public void getAllMessagesFromSatellite() {
        System.out.println("Sendende Satelliten ausgeben: \n");
        for (Satellit satellit : satelliten) {
			getMessageFromSatellit(satellit);
		}
	}

    public void shift(String[] arr) {
        String tmp = arr[0];
        for (int i = 1; i < arr.length; i++)
            arr[i - 1] = arr[i];
        arr[arr.length - 1] = tmp;
    }

}
