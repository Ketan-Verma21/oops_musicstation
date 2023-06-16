import java.util.ArrayList;
import java.util.LinkedList;

public class album {
    private String name;
    private String artist;
    private ArrayList<song> songs;
    public album(String name, String artist){
        this.artist=artist;
        this.name=name;
        this.songs=new ArrayList<song>();
    }
    public album(){}


    public song findSong(String title){
        for(song checksong:songs){
            if(checksong.getTitle()==title){
                return checksong;
            }
        }
        return null;
    }


    public boolean addsong(String title, double duration){
        if(findSong(title)==null){
                songs.add(new song(title,duration));
//                System.out.println(title+" song added successfully");
                return true;
        }
        else{
//            System.out.println("song with name "+title+" already exits");
            return false;
        }
    }


    public boolean addtoplaylist(int trackNumber, LinkedList<song> playlist){
        int index=trackNumber-1;
        if(index>0 && index<=this.songs.size()){
            playlist.add(this.songs.get(index));
            return true;
        }
        else{
//            System.out.println("this album does not have song with tracknumber :"+trackNumber);
            return false;
        }
    }

    public boolean addtoplaylist(String title,LinkedList<song> playlist){
        for(song checksong:this.songs){
            if(checksong.getTitle().equals(title)){
                playlist.add(checksong);
                return true;
            }

        }
//        System.out.println(title+" there is no such song in the title");
        return false;
    }

}
