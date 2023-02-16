import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;
import java.util.*;

public class SnakeGame extends JFrame {
    private static final long serialVersionUID = 1L;

    private final int WIDTH = 300;
    private final int HEIGHT = 300;
    private final int BLOCK_SIZE = 10;
    private final int DELAY = 100;

    private Snake snake;
    private Food food;

    public SnakeGame() {
        setSize(WIDTH, HEIGHT);
        setTitle("贪吃蛇");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        snake = new Snake();
        food = new Food();

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                snake.changeDirection(e);
            }
        });

        Timer timer = new Timer(DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                snake.move();
                if (snake.checkCollision()) {
                    JOptionPane.showMessageDialog(null, "游戏结束！");
                    System.exit(0);
                }
                if (snake.checkFood(food)) {
                    snake.grow();
                    food.generate();
                }
                repaint();
            }
        });
        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        snake.draw(g);
        food.draw(g);
    }

    public static void main(String[] args) {
        JFrame frame = new SnakeGame();
        frame.setVisible(true);
    }
}

class Snake {
    private ArrayList<Point> snakeBody = new ArrayList<Point>();
    private int direction = KeyEvent.VK_RIGHT;

    public Snake() {
        snakeBody.add(new Point(5, 5));
        snakeBody.add(new Point(4, 5));
        snakeBody.add(new Point(3, 5));
    }

    public void move() {
        Point head = snakeBody.get(0);
        Point newPoint = new Point(head.x, head.y);
        switch (direction) {
            case KeyEvent.VK_UP:
                newPoint.y--;
                break;
            case KeyEvent.VK_DOWN:
                newPoint.y++;
                break;
            case KeyEvent.VK_LEFT:
                newPoint.x--;
                break;
            case KeyEvent.VK_RIGHT:
                newPoint.x++;
                break;
        }
        snakeBody.add(0, newPoint);
        snakeBody.remove(snakeBody.size() - 1);
    }

    public void changeDirection(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP && direction != KeyEvent.VK_DOWN) {
            direction = KeyEvent.VK_UP;
        } else if (key == KeyEvent.VK_DOWN && direction != KeyEvent.VK_UP) {
            direction = KeyEvent.VK_DOWN;
        } else if (key == KeyEvent.VK_LEFT && direction != KeyEvent.VK_RIGHT) {
            direction = KeyEvent.VK_LEFT;
        } else if (key == KeyEvent.VK_RIGHT && direction != KeyEvent.VK_LEFT) {
            direction = KeyEvent.VK_RIGHT;
        }
    }

    public boolean checkCollision() {
        Point head = snakeBody.get(0);
        for (int i = 1; i < snakeBody.size(); i++) {
            Point point = snakeBody.get(i);
            if (head.x == point.x && head.y == point.y) {
                return true;
            }
        }
        return false;
    }

    public boolean checkFood(Food food) {
        Point head = snakeBody.get(0);
        Point foodPoint = food.getFoodPoint();
        if (head.x == foodPoint.x && head.y == foodPoint.y) {
            return true;
        }
        return false;
    }

    public void grow() {
        Point tail = snakeBody.get(snakeBody.size() - 1);
        snakeBody.add(new Point(tail.x, tail.y));
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        for (Point p : snakeBody) {
            g.fillRect(p.x * 10, p.y * 10, 10, 10);
        }
    }
}

class Food {
    private Point foodPoint;

    public Food() {
        generate();
    }

    public void generate() {
        int x = (int) (Math.random() * 30);
        int y = (int) (Math.random() * 30);
        foodPoint = new Point(x, y);
    }

    public Point getFoodPoint() {
        return foodPoint;
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(foodPoint.x * 10, foodPoint.y * 10, 10, 10);
    }
}
