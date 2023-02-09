public class Scores implements Comparable <Scores>{
    private String name = "";
    private int waves = 0;
    public Scores (String n, int w) {
        name = n;
        waves = w;
    }
    public int getWave () {
        return waves;
    }
    public String getName () {
        return name;
    }
    @Override
    public int compareTo(Scores s1) {
        if (s1.getWave() > this.getWave())
            return s1.getWave();
        return this.getWave();
    }
}