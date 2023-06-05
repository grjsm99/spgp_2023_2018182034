package tukorea.ge.spgp2018182034.paladog.framework;


public class Metrics {
    public static float scale = 1.0f;
    public static float game_width = 18.0f;
    public static float game_height = 9.5f;
    public static int x_offset = 0, y_offset = 0;

    public static float elapsedTime = 0;
    public static int view_width = 0;
    public static int view_height = 0;

    public static void setGameSize(float width, float height) {
        game_width = width;
        game_height = height;
    }

    public static float toGameX(float x) {
        return (x - x_offset) / scale;
    }
    public static float toGameY(float y) {
        return (y - y_offset) / scale;
    }
}
