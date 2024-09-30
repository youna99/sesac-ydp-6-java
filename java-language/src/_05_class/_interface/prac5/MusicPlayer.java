package _05_class._interface.prac5;

public class MusicPlayer {
    public static void main(String[] args) {
        Music music;

        music = new Mp3Player();
        System.out.println("=== MP3 Player ===");
        music.play("아이유 블루밍");
        music.stop("아이유 블루밍");

        music = new CdPlayer();
        System.out.println("=== CD Player ===");
        music.play("아이유 꽃갈피");
        music.stop("아이유 꽃갈피");
    }
}
