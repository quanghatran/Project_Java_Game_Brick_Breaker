package Official;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

//implementing ActionListener interface
public class OpenAction implements ActionListener {
	JFrame frame;

	// Creating object of JButtons
	JButton selectLevelButton = new JButton("select level");
	JButton soundButton = new JButton("sound");
	JButton tutorialButton = new JButton("tutorial");
	JButton quitButton = new JButton("quit");
	JButton Easy = new JButton("EASY");
	JButton Hard = new JButton("HARD");
	JButton Medium = new JButton("MEDIUM");
	

	OpenAction() {
		prepareGUI();
		addActionEvents();

	}

	public void prepareGUI() {
		frame = new JFrame();
		frame.setTitle("Game Menu");
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.black);
		frame.setBounds(10, 10, 700, 600);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		selectLevelButton.setBounds(300, 80, 150, 70);
		frame.add(selectLevelButton);

		soundButton.setBounds(300, 150, 150, 70);
		frame.add(soundButton);

		tutorialButton.setBounds(300, 220, 150, 70);
		frame.add(tutorialButton);

		quitButton.setBounds(300, 290, 150, 70);
		frame.add(quitButton);

	}

	public void addActionEvents() {
		// registering action listener to buttons
		selectLevelButton.addActionListener(this);
		soundButton.addActionListener(this);
		tutorialButton.addActionListener(this);
		quitButton.addActionListener(this);

		Easy.addActionListener(this);
		Medium.addActionListener(this);
		Hard.addActionListener(this);

	}

    static File pipebang = new File("pipebang.wav");
	static File loseGame = new File(
			"C:\\Users\\Quang_Ha\\eclipse-workspace\\Official\\30_most_popular_sound_effects_part_3_with_download_link_gaming_trolling_meme_popular_606150 (mp3cut.net).wav");
	static File nhacNen = new File(
			"C:\\Users\\Quang_Ha\\eclipse-workspace\\Official\\kawai_2005_game_dragostea_din_tei_ozone_nhac_game_pikachu_854242 (online-audio-converter.com).wav");
	static File bongChamGach = new File(
			"C:\\Users\\Quang_Ha\\eclipse-workspace\\Official\\popular_sound_effects_youtubers_use_221710 (mp3cut.net).wav");
	static File paddleChamTuong = new File(
			"C:\\Users\\Quang_Ha\\eclipse-workspace\\Official\\swish_swoosh_cutscene_sound_effect_191097 (mp3cut.net).mp3");
	static File winGame = new File(
			"C:\\Users\\Quang_Ha\\eclipse-workspace\\Official\\you_win_perfect_853082 (mp3cut.net).wav");

    static void PlaySound(File Sound) {
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(Sound));
            clip.start();
        } catch (Exception e) {

        }
    }


	@Override
	public void actionPerformed(ActionEvent e) {

		

		if (e.getSource() == selectLevelButton) {
			PlaySound(bongChamGach);
			frame = new JFrame();
			
			frame.getContentPane().setLayout(null);
			frame.getContentPane().setBackground(Color.black);
			frame.setBounds(10, 10, 700, 600);
			frame.setTitle("Select Level");
			frame.setResizable(false);
			frame.setVisible(false);
			frame.setLocationRelativeTo(null);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
			
			
			Easy.setBounds(300, 80, 150, 50);
			frame.add(Easy);

			Medium.setBounds(300, 180, 150, 50);
			frame.add(Medium);

			Hard.setBounds(300, 280, 150, 50);
			frame.add(Hard);

		}

		if (e.getSource() == Easy) {
			PlaySound(bongChamGach);
			frame.setVisible(false);
			JFrame obj = new JFrame();
			GamePlay gamePlay = new GamePlay();
			obj.setBounds(10, 10, 700, 600);
			obj.setTitle("Breakout Ball");
			obj.setResizable(false);
			obj.setVisible(true);
			obj.setLocationRelativeTo(null);
			obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			obj.add(gamePlay);

			obj.setVisible(true);

		}
		
		if (e.getSource() == Medium) {
			PlaySound(bongChamGach);
			frame.setVisible(false);
			JFrame obj = new JFrame();
			Level2 level2 = new Level2();
			obj.setBounds(10, 10, 700, 600);
			obj.setTitle("Breakout Ball");
			obj.setResizable(false);
			obj.setVisible(true);
			obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			obj.add(level2);
			obj.setLocationRelativeTo(null);
			obj.setVisible(true);
		}
			if (e.getSource() == Hard) {
				PlaySound(bongChamGach);
				frame.setVisible(false);
				JFrame obj = new JFrame();
				Level3 level3 = new Level3();
				obj.setBounds(10, 10, 700, 600);
				obj.setTitle("Breakout Ball");
				obj.setResizable(false);
				obj.setVisible(true);
				obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				obj.add(level3);
				obj.setLocationRelativeTo(null);
				obj.setVisible(true);

			}
			if (e.getSource() == tutorialButton) {
				PlaySound(bongChamGach);
				// them phan nay

				new Tutorial();

			}

			if (e.getSource() == quitButton) {
				PlaySound(bongChamGach);
				System.exit(0);

			}
	}
}
