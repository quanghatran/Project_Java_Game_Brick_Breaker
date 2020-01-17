package Official;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

public class Level2 extends JPanel implements KeyListener, ActionListener {
	private boolean play = false;
	private int score = 0;

	private int totalBricks = 72;

	private Timer timer;
	private int delay = 10;

	private int playerX = 310;

	private int ballposX = 350;
	private int ballposY = 525;
	private int ballXdir = -1;
	private int ballYdir = -2;

	private MapUpgrade map;

	public Level2() {

		map = new MapUpgrade(6, 12);
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
		timer.start();

	}

	public void paint(Graphics g) {
		// background
		g.setColor(Color.black);
		g.fillRect(1, 1, 692, 592);

		// drawing map
		map.draw((Graphics2D) g);

		// borders
		g.setColor(Color.blue);
		g.fillRect(0, 0, 3, 592);
		g.fillRect(0, 0, 692, 3);
		g.fillRect(692, 0, 3, 592);

		// borders of the score
		g.setColor(Color.red);
		g.fillRect(585, 5, 70, 30);

		// the scores
		g.setColor(Color.white);
		g.setFont(new Font("serif", Font.BOLD, 25));
		g.drawString("" + score, 590, 30);

		// the paddle
		g.setColor(Color.green);
		g.fillRect(playerX, 550, 100, 8);

		// the ball

		g.setColor(Color.WHITE);
		g.fillOval(ballposX, ballposY, 18, 18);

		// when you won the game
		if (totalBricks <= 10) {
			play = false;
			ballXdir = 0;
			ballYdir = 0;
			g.setColor(Color.RED);

			g.setFont(new Font("serif", Font.BOLD, 30));
			g.drawString("You Won", 260, 300);

			g.setColor(Color.BLUE);
			;
			g.setFont(new Font("serif", Font.BOLD, 20));
			g.drawString("Press (Enter) to Restart", 230, 350);

			g.setFont(new Font("serif", Font.BOLD, 20));
			g.drawString("Press (Space) to Quit", 230, 400);

			PlaySound(winGame);

		}

		// when you lose the game
		if (ballposY > 570) {
			play = false;
			ballXdir = 0;
			ballYdir = 0;
			g.setColor(Color.RED);

			g.setFont(new Font("serif", Font.BOLD, 30));
			g.drawString("Game Over, Scores: " + score, 190, 300);

			g.setColor(Color.RED);

			g.setFont(new Font("serif", Font.BOLD, 20));
			g.drawString("Press (Enter) to Restart", 230, 350);

			g.setFont(new Font("serif", Font.BOLD, 20));
			g.drawString("Press (Space) to Quit", 230, 400);

			PlaySound(loseGame);
		}

		g.dispose();

	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if (playerX > 580) {
				playerX = 580;
			} else {
				moveRight();
			}
		}

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			if (playerX < 10) {
				playerX = 10;
			} else {
				moveLeft();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (!play) {
				play = true;
				ballposX = 350;
				ballposY = 525;
				ballXdir = -1;
				ballYdir = -2;
				playerX = 310;
				score = 0;
				totalBricks = 72;
				map = new MapUpgrade(6, 12);
				repaint();
			}
		}

		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			System.exit(0);

		}
	}

	public void keyReleased(KeyEvent e) {
	}

	public void keyTyped(KeyEvent e) {
	}

	public void moveRight() {
		play = true;
		playerX += 20;
	}

	public void moveLeft() {
		play = true;
		playerX -= 20;
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

	public void actionPerformed(ActionEvent e) {
		timer.start();
		if (play) {
			if (new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(playerX, 550, 30, 8))) {
				ballYdir = -ballYdir;
				ballXdir = -2;

				PlaySound(pipebang);

			} else if (new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(playerX + 70, 550, 30, 8))) {
				ballYdir = -ballYdir;
				ballXdir = ballXdir + 1;

				PlaySound(pipebang);
			} else if (new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(playerX + 30, 550, 40, 8))) {
				ballYdir = -ballYdir;

				PlaySound(pipebang);

			}

			// check map collision with the ball
			A: for (int i = 0; i < map.map1.length; i++) {
				for (int j = 0; j < map.map1[0].length; j++) {
					if (map.map1[i][j] > 0) {
						// scores++;
						int brickX = j * map.brickWidth1 + 80;
						int brickY = i * map.brickHeight1 + 50;
						int brickWidth = map.brickWidth1;
						int brickHeight = map.brickHeight1;

						Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
						Rectangle ballRect = new Rectangle(ballposX, ballposY, 20, 20);
						Rectangle brickRect = rect;

						if (ballRect.intersects(brickRect)) {
							map.hitBrick(i, j);
							score += 5;
							totalBricks--;

							// when ball hit right or left of brick
							if (ballposX + 19 <= brickRect.x || ballposX + 1 >= brickRect.x + brickRect.width) {
								ballXdir = -ballXdir;
								PlaySound(bongChamGach);
							}
							// when ball hits top or bottom of brick
							else {
								ballYdir = -ballYdir;
								PlaySound(bongChamGach);
							}

							break A;
						}
					}
				}
			}

			ballposX += ballXdir;
			ballposY += ballYdir;

			if (ballposX < 0) {
				ballXdir = -ballXdir;
				PlaySound(pipebang);
			}
			if (ballposY < 0) {
				ballYdir = -ballYdir;
				PlaySound(pipebang);
			}
			if (ballposX > 670) {
				ballXdir = -ballXdir;
				PlaySound(pipebang);
			}

			repaint();

		}
	}

}
