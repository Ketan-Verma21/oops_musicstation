
public class song {
    String Title;
    double Duration;
    public song(String title, double duration){
        this.Title=title;
        this.Duration=duration;
    }
    public song(){}
    public String getTitle(){
        return Title;
    }
    public double getDuration(){
        return Duration;
    }

    @Override
    public String toString() {
        return "song{" +
                "Title='" + Title + '\'' +
                ", Duration=" + Duration +
                '}';
    }
}

