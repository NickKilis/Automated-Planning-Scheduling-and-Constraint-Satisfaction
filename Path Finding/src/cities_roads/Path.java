package cities_roads;

public class Path {
    private String sourceCity;
    private String road_name;
    private String destinationCity;
    private double distance_cost;
    private double time_cost;

    public Path(String road_name,String sourceCity, String destinationCity, double distance_cost,double time_cost) {
        super();
        this.sourceCity = sourceCity;
        this.road_name = road_name;
        this.destinationCity = destinationCity;
        this.distance_cost = distance_cost;
        this.time_cost = time_cost;
        
    }
    public String getRoadName() {
        return road_name;
    }
    public void setRoadName(String road_name) {
        this.road_name = road_name;
    }
    public String getSourceCity() {
        return sourceCity;
    }
    public void setSourceCity(String sourceCity) {
        this.sourceCity = sourceCity;
    }
    public String getDestinationCity() {
        return destinationCity;
    }
    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }
    public double getCost(String criterion) {
    	if(criterion == "distance")
    		return this.distance_cost;
    	if(criterion == "time")
    		return this.time_cost;
    	return 0.0;
    }
    public void setCost(String criterion,double cost) {
    	if(criterion == "distance")
    		this.distance_cost= cost;
    	if(criterion == "time")
    		this.distance_cost=cost;	
    }
    
    public double getDistanceCost() {return distance_cost;}
    public void setDistance(double distance_cost) {this.distance_cost = distance_cost;}
    
    public double getTimeCost() {return time_cost;}
    public void setTimeCost(double time_cost) {this.time_cost = time_cost;}
    //TO check if source and destination is same
    @Override
    public boolean equals(Object o) {
        if(o != null && o instanceof Path) {
            Path r = (Path)o;
            if(r.getSourceCity().equals(sourceCity) && r.getDestinationCity().equals(destinationCity)) {
                return true;
            } else if(r.getSourceCity().equals(destinationCity) && r.getDestinationCity().equals(sourceCity)) {
                return true;
            }
        }
        return false;
    }
}

