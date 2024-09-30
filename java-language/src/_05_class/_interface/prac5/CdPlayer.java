package _05_class._interface.prac5;

public class CdPlayer implements Music {

    private String music;

    @Override
    public void play(String music) {
        System.out.println("CD 플레이어에서 '" + music + "' 음악을 재생합니다.");
    }

    @Override
    public void stop(String music) {
        System.out.println("CD 플레이어에서 '" + music + "' 음악을 정지합니다.");
    }
}
