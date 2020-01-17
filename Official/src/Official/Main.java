package Official;

import java.io.FileInputStream;

import javax.swing.JButton;
import javax.swing.JFrame;

import javazoom.jl.player.Player;

public class Main {
	public static void main(String[] args) {
		JFrame frame;
		JButton back = new JButton("back");
		frame = new JFrame();
		back.setBounds(10, 5, 70, 30);
		frame.add(back);

		new OpenAction();

		try {
			FileInputStream fis = new FileInputStream(
					"C:\\Users\\Quang_Ha\\Downloads\\NhacNenGamePikachu-VA-4698057.mp3");
			Player play = new Player(fis);
			play.play();

		} catch (Exception d) {
			System.out.println();
		}

	}

}
