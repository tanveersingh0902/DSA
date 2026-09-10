package practice;
// File: PongGame.java
// Simple Pong game (single-player vs basic AI) using Java Swing.
// Compile: javac PongGame.java
// Run:     java PongGame

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PongGame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Pong - Single Player");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);

            GamePanel panel = new GamePanel(800, 500); // width, height
            frame.add(panel);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            panel.startGame();
        });
    }
}

class GamePanel extends JPanel implements ActionListener {
    private final int WIDTH;
    private final int HEIGHT;
    private final int PADDLE_WIDTH = 12;
    private final int PADDLE_HEIGHT = 80;
    private final int BALL_SIZE = 16;

    private Rectangle playerPaddle;
    private Rectangle aiPaddle;
    private Rectangle ball;

    private int playerScore = 0;
    private int aiScore = 0;

    private int ballDX = 4; // ball velocity x
    private int ballDY = 3; // ball velocity y

    private int playerSpeed = 6;
    private int aiSpeed = 4;
    private boolean upPressed = false;
    private boolean downPressed = false;

    private Timer timer;
    private final int DELAY = 16; // ~60 FPS

    private boolean running = false;
    private boolean paused = false;

    GamePanel(int width, int height) {
        this.WIDTH = width;
        this.HEIGHT = height;
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        setFocusable(true);
        initObjects();
        setupInput();
        timer = new Timer(DELAY, this);
    }

    private void initObjects() {
        playerPaddle = new Rectangle(20, (HEIGHT - PADDLE_HEIGHT) / 2, PADDLE_WIDTH, PADDLE_HEIGHT);
        aiPaddle = new Rectangle(WIDTH - 20 - PADDLE_WIDTH, (HEIGHT - PADDLE_HEIGHT) / 2, PADDLE_WIDTH, PADDLE_HEIGHT);
        ball = new Rectangle((WIDTH - BALL_SIZE) / 2, (HEIGHT - BALL_SIZE) / 2, BALL_SIZE, BALL_SIZE);
        ballDX = 4 * (Math.random() < 0.5 ? 1 : -1);
        ballDY = 3 * (Math.random() < 0.5 ? 1 : -1);
    }

    private void resetBall(boolean afterScoreByPlayer) {
        ball.x = (WIDTH - BALL_SIZE) / 2;
        ball.y = (HEIGHT - BALL_SIZE) / 2;
        // send ball to the who lost: if player scored, ball goes to AI, else to player
        ballDX = (afterScoreByPlayer ? -4 : 4);
        ballDY = 3 * (Math.random() < 0.5 ? 1 : -1);
    }

    private void setupInput() {
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int k = e.getKeyCode();
                if (k == KeyEvent.VK_UP) upPressed = true;
                if (k == KeyEvent.VK_DOWN) downPressed = true;
                if (k == KeyEvent.VK_P) paused = !paused;
                if (k == KeyEvent.VK_R) {
                    restartGame();
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
                int k = e.getKeyCode();
                if (k == KeyEvent.VK_UP) upPressed = false;
                if (k == KeyEvent.VK_DOWN) downPressed = false;
            }
        });
    }

    void startGame() {
        running = true;
        timer.start();
    }

    void restartGame() {
        playerScore = 0;
        aiScore = 0;
        initObjects();
        paused = false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!running || paused) {
            repaint();
            return;
        }
        updatePlayer();
        updateAI();
        updateBall();
        repaint();
    }

    private void updatePlayer() {
        if (upPressed) {
            playerPaddle.y -= playerSpeed;
            if (playerPaddle.y < 0) playerPaddle.y = 0;
        } else if (downPressed) {
            playerPaddle.y += playerSpeed;
            if (playerPaddle.y + PADDLE_HEIGHT > HEIGHT) playerPaddle.y = HEIGHT - PADDLE_HEIGHT;
        }
    }

    // Very simple AI: follows the ball's center with limited speed, with a tiny reaction margin
    private void updateAI() {
        int paddleCenter = aiPaddle.y + PADDLE_HEIGHT / 2;
        int ballCenter = ball.y + BALL_SIZE / 2;
        if (Math.abs(ballCenter - paddleCenter) > 8) {
            if (ballCenter > paddleCenter) {
                aiPaddle.y += aiSpeed;
            } else {
                aiPaddle.y -= aiSpeed;
            }
        }
        // clamp
        if (aiPaddle.y < 0) aiPaddle.y = 0;
        if (aiPaddle.y + PADDLE_HEIGHT > HEIGHT) aiPaddle.y = HEIGHT - PADDLE_HEIGHT;
    }

    private void updateBall() {
        ball.x += ballDX;
        ball.y += ballDY;

        // collision with top/bottom walls
        if (ball.y <= 0) {
            ball.y = 0;
            ballDY = -ballDY;
        } else if (ball.y + BALL_SIZE >= HEIGHT) {
            ball.y = HEIGHT - BALL_SIZE;
            ballDY = -ballDY;
        }

        // collision with player paddle
        if (ball.intersects(playerPaddle)) {
            ball.x = playerPaddle.x + playerPaddle.width; // prevent sticking
            ballDX = Math.abs(ballDX) + 1; // speed up a bit and ensure it's positive to go right
            // tweak dy based on where it hit the paddle to add control
            int hitPos = (ball.y + BALL_SIZE/2) - (playerPaddle.y + PADDLE_HEIGHT/2);
            ballDY = hitPos / 7; // smaller divisor -> bigger angle
            if (ballDY == 0) ballDY = (Math.random() < 0.5) ? 1 : -1;
        }

        // collision with AI paddle
        if (ball.intersects(aiPaddle)) {
            ball.x = aiPaddle.x - BALL_SIZE;
            ballDX = -Math.abs(ballDX) - 1; // go left, speed up
            int hitPos = (ball.y + BALL_SIZE/2) - (aiPaddle.y + PADDLE_HEIGHT/2);
            ballDY = hitPos / 7;
            if (ballDY == 0) ballDY = (Math.random() < 0.5) ? 1 : -1;
        }

        // score check: ball passed left or right edge
        if (ball.x + BALL_SIZE < 0) {
            // AI scored
            aiScore++;
            resetBall(false);
        } else if (ball.x > WIDTH) {
            // Player scored
            playerScore++;
            resetBall(true);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // enable anti-aliasing for smoother text
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        // draw middle dashed line
        g.setColor(Color.GRAY);
        for (int y = 0; y < HEIGHT; y += 20) {
            g.fillRect(WIDTH / 2 - 2, y, 4, 12);
        }

        // draw paddles and ball
        g.setColor(Color.WHITE);
        g.fillRect(playerPaddle.x, playerPaddle.y, playerPaddle.width, playerPaddle.height);
        g.fillRect(aiPaddle.x, aiPaddle.y, aiPaddle.width, aiPaddle.height);
        g.fillOval(ball.x, ball.y, ball.width, ball.height);

        // draw scores
        g.setFont(new Font("Consolas", Font.BOLD, 36));
        String scoreText = playerScore + "   " + aiScore;
        int strWidth = g.getFontMetrics().stringWidth(scoreText);
        g.drawString(scoreText, WIDTH / 2 - strWidth / 2, 50);

        // instructions & state
        g.setFont(new Font("SansSerif", Font.PLAIN, 14));
        g.drawString("UP/DOWN to move | P = Pause | R = Restart", 10, HEIGHT - 10);

        if (!running) {
            drawCenteredMessage(g, "Game Over");
        } else if (paused) {
            drawCenteredMessage(g, "Paused");
        }
    }

    private void drawCenteredMessage(Graphics g, String msg) {
        g.setFont(new Font("Consolas", Font.BOLD, 48));
        int w = g.getFontMetrics().stringWidth(msg);
        g.setColor(Color.YELLOW);
        g.drawString(msg, (WIDTH - w) / 2, HEIGHT / 2);
    }
}

