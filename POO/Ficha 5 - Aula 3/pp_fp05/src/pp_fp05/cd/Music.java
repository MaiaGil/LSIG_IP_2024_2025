package pp_fp05.cd;

public class Music {
    private int number;
    private String name;
    private int durantionTime;//em segundos
    private String authorName;
    private static int Lastnum = 0;

    public Music(String name, int durantionTime, String authorName) {
        this.number = ++this.Lastnum;
        this.name = name;
        this.durantionTime = durantionTime;
        this.authorName = authorName;
    }

    /**
     * Use this propertie to know how the number of your music
     * @return the number of the music
     */
    public int getNumberMusic() {
        return this.number;
    }

    /**
     * Use this propertie to set the name of a Music
     * @param nome the name of the music
     */
    public void setName(String nome){
        this.name = nome;
    }

    /**
     * Use this propertie to set the durantion time of a Music
     * @param durantionTime the durantion time of the music in seconds
     */
     public void setDurantionTime(int durantionTime){
        this.durantionTime = durantionTime;
    }
    
    /**
     * Use this propertie to set the author name 
     * @param authorName the author Name
     */
    public void setAuthor(String authorName){
        this.authorName = authorName;
    }

}
