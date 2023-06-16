import java.util.*;

public class main {
    private static ArrayList<album>albums=new ArrayList<>();
    public static void main(String[] args) {
        album albuma=new album("album1","lil nas x");
        albuma.addsong("industry baby",4.04);
        albuma.addsong("call me by your name",4.48);
        albums.add(albuma);
        album albumu=new album("album2","imagine dragons");
        albumu.addsong("thunder",3.58);
        albumu.addsong("bones",5.68);
        albums.add(albumu);
        LinkedList<song>playlist_1=new LinkedList<>();
        albums.get(0).addtoplaylist("industry baby",playlist_1);
        albums.get(1).addtoplaylist("thunder",playlist_1);
        albums.get(1).addtoplaylist("bones",playlist_1);
        play(playlist_1);



    }
    private static void play(LinkedList<song> playlist){
        Scanner sc=new Scanner(System.in);
        boolean quit=false;
        boolean forward= false;
        ListIterator<song> listIterator=playlist.listIterator();
        if(playlist.size()==0){
            System.out.println("the playlist is empty");
        }
        else {
            System.out.println("now playing "+listIterator.next().toString());
            printmenu();
        }
        while(!quit){
            int action= sc.nextInt();
            switch (action){
                case 0:
                    System.out.println("playlist complete");
                    break;
                case 1:
                    if(!forward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward=true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("now playing "+listIterator.next().toString());
                    }
                    else{
                        System.out.println("no song available,reached to the end of the playlist");
                        forward=false;
                    }
                    break;
                case 2:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("now playing "+listIterator.previous().toString());
                        }
                        else{
                            System.out.println("we are at the first song of the playlist");
                            forward=false;
                        }
                        break;
                    }
                case 3:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("now playing"+listIterator.previous().toString());
                        }
                        else {
                            System.out.println("we are at the starting of teh playlist");
                        }
                    }
                    else{
                        if(listIterator.hasNext()){
                            System.out.println("now playing "+listIterator.next().toString());
                        }
                        else{
                            System.out.println("we are at the end of the playlist");
                        }
                    }
                    break;
                case 4:
                    printlist(playlist);
                    break;
                case 5:
                    printmenu();
                    break;
                case 6:
                    if(playlist.size()>0){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("we are playing the next song "+listIterator.next().toString());
                            forward=true;
                        }
                        else{
                            if(listIterator.hasPrevious()){
                                System.out.println("now playing "+listIterator.previous().toString());
                            }
                        }
                    }





            }
        }
    }
    private static void printmenu(){
        System.out.println("Available options \n press");
        System.out.println("0 - to quit\n"+
                "1 - to play next song\n"+
                "2 - to play previos song\n"+
                "3 - to replay the current song\n"+
                "4 - list of all songs\n"+
                "5 - print all the available options\n"+
                "6 - delete the current song");
    }
    private static void printlist(LinkedList<song> playlist){
        Iterator<song> iterator=playlist.iterator();
        System.out.println("-----------------");
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
