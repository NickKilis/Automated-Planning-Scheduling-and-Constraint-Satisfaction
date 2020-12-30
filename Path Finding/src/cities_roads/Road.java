package cities_roads;

public class Road {
	private String roadName;
	private String start_city;
	private String dest_city;
    private double distance;
    private double duration;

    public Road(String roadName,String start_city,String dest_city, double distance, double duration) {
        super();
        this.roadName = roadName;
        this.distance = distance;
        this.duration = duration;
    }
    
    public String getRoadName() {return roadName;}
    public void setRoadName(String roadName) {this.roadName = roadName;}

    public String getStartCity() {return start_city;}
    public void setStartCity(String start_city) {this.start_city = start_city;}

    public String getDestCity() {return dest_city;}
    public void setDestCity(String dest_city) {this.dest_city = dest_city;}
    
    public double getDistance() {return distance;}
    public void setDistance(double distance) {this.distance =distance;}
    
    public double getDuration() {return duration;}
    public void setDuration(double duration) {this.duration =duration;}
    
    
}
