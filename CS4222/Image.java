// Mykola Vaskevych
// 22372199
// CS lm121
import java.util.Arrays;

public class Image {
    private int[][] pixels;
    private int width;
    private int height;

    public Image(int[][] pixels) {
        this.pixels = pixels;
        this.height = pixels.length;
        this.width = pixels[0].length;

    }

    public String toString() {
        return Arrays.deepToString(pixels);
    }

    public void flip(boolean horizontal) {
        int[][] flipped = new int[height][width];
        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                if (horizontal) {
                    flipped[x][y] = pixels[x][width - y - 1];
                } else {
                    flipped[x][y] = pixels[height - x - 1][y];
                }
            }
        }
        pixels = flipped;
    }

    public void rotate(boolean clockwise) {
        int[][] rotated = new int[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (clockwise) {
                    rotated[x][y] = pixels[height - y - 1][x];
                } else {
                    rotated[x][y] = pixels[y][width - x - 1];
                }
            }
        }
        int temp = width;
        pixels = rotated;
        width = height;
        height = temp;
    }


}