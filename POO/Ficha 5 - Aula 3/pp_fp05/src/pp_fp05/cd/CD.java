package pp_fp05.cd;
import java.util.Scanner;

public class CD {
    private Scanner in = new Scanner(System.in);
    private String bandName;
    private String name;
    private int durantionTime;//em segundos
    private int launchYear;
    private String publishers;

    private static final int MUSICSIZE = 15;
    private Music[] music;
    private static int countMusics;

    private BandElements[] elements;

    public CD(){
        music = new Music[this.MUSICSIZE];
        countMusics = 0;
    }

    /**
     * Use this propertie to know how many music are in the CD
     * @return the num of musics
     */
    public int getCountMusics() {
        return this.countMusics;
    }

    /**
     * Use this propertie to know the name of the band in the cd
     * @return the name of the band
     */
    public String getBandName() {
        return this.bandName;
    }

    /**
     * Use this propertie to know the name of the CD
     * @return the name the CD
     */
    public String getCDName() {
        return this.name;
    }

    /**
     * Use this propertie to know the duration time of the CD
     * @return the duration time
     */
    public int getDurantionTime() {
        return this.durantionTime;
    }

    /**
     * Use this propertie to know the lauch year of the CD
     * @return the lauch year
     */
    public int getLaunchYear() {
        return this.launchYear;
    }

    /**
     * Use this propertie to know the publishers of the CD
     * @return the name the publishers
     */
    public String getpublishers() {
        return this.publishers;
    }

    /**
     * 
     * @param music the music you want to add to the CD
     */
    public void addMusics(Music music) {
        if(this.countMusics == this.MUSICSIZE) {
            System.out.println("The CD is full, can't add more musics");
            return;
        }
        this.music[this.countMusics++] = music;
    }

    /**
     * Use this method to add a Music to the CD, using the parameters
     * @param name hte name of the music
     * @param durantionTime the durantion of the music
     * @param authorName the author of the music
     */
    public void addMusics(String name, int durantionTime, String authorName){
        Music music = new Music(name, durantionTime, authorName);
        this.addMusics(music);
    }

    /**
     * Use this method to know what is the position of a Music in your CD
     * @param music the Music you want to know
     * @return the position of the Music
     */
    public int searchMusic(Music music){
        int pos = music.getNumberMusic()-1;
        if(pos > 0 || pos < 15){
            System.out.println("That Music is not on the CD");
        }
        return pos;
    }

    /**
     * Use this method to update the caracteristic of a music
     * @param music the music you want to update
     */
    public void updateMusic(Music musica){
        int pos  = searchMusic(musica);
        
        System.out.print("\nChosee the new name - ");
        String nome = in.nextLine();
        this.music[pos].setName(nome);

        System.out.print("\nChosee the new author - ");
        String author = in.nextLine();
        this.music[pos].setAuthor(author);

        System.out.print("\nChosee the new durantion time - ");
        int durantionTime = Integer.parseInt(in.nextLine());
        this.music[pos].setDurantionTime(durantionTime);

        System.out.println("Music updated successfully");
    }

    /**
     * Use this method to remove a Music from your CD
     * @param music the Music you want to delete
     */
    public void deleteMusic(Music music){
        int pos = searchMusic(music);

        if(this.countMusics == 0) {
            System.out.println("The CD ihas no music");
            return;
        }
        
        for(int i = pos; i < countMusics-1; i++){
            this.music[i] = this.music[i+1];
        }
        this.countMusics--;

        System.out.println("Music eleminated successfully");
    }
}
