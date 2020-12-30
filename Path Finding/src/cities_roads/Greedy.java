package cities_roads;
import java.util.*;


public class Greedy{
	
	final static String PATH_SEPERATOR = ",";
	static List<Path> ConnectingPath = new ArrayList<Path>();
	static List<City> Loc = new ArrayList<City>();
	
	public static void logOutput(String msg) {
        System.out.println(msg);
    }
	
	public static void updateQueueNode(Queue<Node> queue, Node newNode) {
        // update the queue node when a lower cost path is discovered
        for (Node existingNode : queue) {
            if(existingNode.equals(newNode)) {
                if(existingNode.getActualCost() + existingNode.getHeuristicCost() > newNode.getActualCost() + newNode.getHeuristicCost()) {
                    existingNode.setPath(newNode.getPath());
                    existingNode.setActualCost(newNode.getActualCost());
                    existingNode.setHeuristicCost(newNode.getHeuristicCost());
                }
            }
        }
    }
	
	public static double heurisiticFunc(double lat1,double lat2, double lon1, double lon2) {
		/* Calculation of heuristic cost using the formula
		double lat_sum = lat1 + lat2;
		double lat_sub = lat1 - lat2;
		double long_sub = lon1 - lon2;
		double term1 = Math.pow(69.5 * lat_sub, 2);
		double term2 = Math.pow(69.5 * Math.cos(lat_sum / 360 * Math.PI) * long_sub, 2);
		double hVal = Math.sqrt(term1 + term2);
		return hVal;
		*/
		final int R = 6371; // Radius of the earth
		//System.out.println(lat1+"||"+lat2+"||"+lon1+"||"+lon2);
	    double latDistance = Math.toRadians(lat2 - lat1);
	    double lonDistance = Math.toRadians(lon2 - lon1);
	    double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
	            + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
	            * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
	    double distance = R * c ; // convert to kilometers
	    
	    //double height = el1 - el2;
	    double height =0;
	    distance = Math.pow(distance, 2) + Math.pow(height, 2);
	    int result=(int)(Math.round(Math.sqrt(distance)));
	    System.out.println("The straight euclidean distance is : "+result +" (km) !");
	    return result;
		}
	
	public static double calcHeuristicCost(String path, String destinationCity,List<City> Loc) {
        // Passing values to calculate the heuristic cost of path
        double lat1 = 0;
        double lat2 = 0;
        double lon1 = 0;
        double lon2 = 0;
        for (City city : Loc) {
            if(city.getCityName().equalsIgnoreCase(path)) {
                lat1 = city.getLat();
                lon1 = city.getLon();
                
            }
            if(city.getCityName().equalsIgnoreCase(destinationCity)) {
                lat2 = city.getLat();
                lon2 = city.getLon();
            }
        }
        double hCost = heurisiticFunc(lat1, lat2,lon1, lon2);
        return hCost;
    }
	private double getPathCost(String path,List<Path> ConnectingPath,String criterion) {
	      // Calculate the total path cost
	      String[] cities = path.split(PATH_SEPERATOR);
	      double totalCost = 0.0;
	      for (int i = 0; i < cities.length - 1 ; i++) {
	    	  for(int j=0; j<ConnectingPath.size();j++) {
	    		  if((ConnectingPath.get(j).getDestinationCity().equals(cities[i])) && (ConnectingPath.get(j).getSourceCity().equals(cities[i+1])) ) {
	    			  if(criterion=="distance") {
	    				  totalCost +=ConnectingPath.get(j).getDistanceCost();
	    			  }
	    			  if(criterion=="time") {
	    				  totalCost +=ConnectingPath.get(j).getTimeCost();
	    			  }
	    		  }
	    		  if(ConnectingPath.get(j).getSourceCity().equals(cities[i]) && (ConnectingPath.get(j).getDestinationCity().equals(cities[i+1]) )) {
	    			  if(criterion=="distance") {
	    				  totalCost +=ConnectingPath.get(j).getDistanceCost();
	    			  }
	    			  if(criterion=="time") {
	    				  totalCost +=ConnectingPath.get(j).getTimeCost();
	    			  }
	    		  }
	    	  }
	      }
	      return totalCost;
	  }
	
	public static int getPathLength(String path) {
        // Get the path length
        String[] cities = path.split(PATH_SEPERATOR);
        return cities.length;
    }
	
	public static boolean goalChecker(String path, String destinationCityName) {
        // To check if the goal or destination has been reached
        String lastVisitedCity = getCurrentCity(path);
        if(lastVisitedCity != null && !lastVisitedCity.trim().equals("") && lastVisitedCity.equalsIgnoreCase(destinationCityName)) {
            return true;
        }
        return false;
    }
	
	public static List<Node> moveGenerator(String currentCity,String criterion) {
        // Defining the move generator with all the neighbours
        List<Node> possibleMoves = new ArrayList<Node>();
        if(currentCity != null) {
            for (Path road : ConnectingPath) {
            	
            	//System.out.println(road.getRoadName());
                if(road.getSourceCity().equalsIgnoreCase(currentCity)) {
                    possibleMoves.add(new Node(road.getDestinationCity(), road.getCost(criterion), 0));
                } else if (road.getDestinationCity().equalsIgnoreCase(currentCity)) {
                    possibleMoves.add(new Node(road.getSourceCity(), road.getCost(criterion), 0));
                 
                }
            }
        }
        return possibleMoves;
    }
	
	public static String getCurrentCity(String currentPath) {
        // To get the value of the last visited city or the current city
        if(currentPath != null) {
            int index = currentPath.lastIndexOf(PATH_SEPERATOR);
            if(index != -1)
            {
                String lastVisitedCity = currentPath.substring(index + 1);
                return lastVisitedCity;
            } else {
                return currentPath;
            }
        }
        return null;
    }

	
	public void Greedy(String sourceCity, String destinationCity,List<Path> ConnectingPath,String criterion,List<City> Loc) {
		Greedy.ConnectingPath=ConnectingPath;
		Greedy.Loc=Loc;
	    Queue<Node> queue = new PriorityQueue<Node>();
	    List<String> visitedList = new ArrayList<String>();
	    queue.add(new Node(sourceCity, 0, 0));
	    int totalNodesExpanded = 0;
	    while(!queue.isEmpty()) {
	        // Check if the queue is empty
	        Node currentNode = queue.remove();
	        
	        // Removing the current node from the queue
	        if(goalChecker(currentNode.getPath(), destinationCity)) {
	            // To check if the goal is achieved
	            logOutput("");
	            logOutput("Total Nodes Expanded by Greedy = " + totalNodesExpanded);
	            logOutput("Path generated by Greedy: " + currentNode.getPath());
	            logOutput("Path length generated by Greedy: " + getPathLength(currentNode.getPath()));
	            double totalCost = getPathCost(currentNode.getPath(),ConnectingPath,criterion); 
	            logOutput("Cost of Greedy: " + totalCost);
	            return;
	        } else {
	            String currentCity = getCurrentCity(currentNode.getPath());
	            // Get the expanded list of cities from the current source
	            if(totalNodesExpanded != 0) {
	                System.out.println("");
	            } else {
	                System.out.println("Nodes Expanded are : ");
	            }
	            System.out.println("The current city is : "+currentCity);
	            totalNodesExpanded++;
	            //System.out.print(currentCity);
	            visitedList.add(currentCity);
	            List<Node> possibleMoves = moveGenerator(currentCity,criterion);
	            System.out.println("The possible moves are : ");
                for(int i = 0; i < possibleMoves.size(); i++ ) {
                	System.out.println(possibleMoves.get(i).getPath());
                }
	            // Defining the move generator
	            for (Node possibleMove : possibleMoves) {
	                if(!visitedList.contains(possibleMove.getPath())) {
	                    // Calculate the heuristic value to add the city in the queue
	                    String newPath = currentNode.getPath() + PATH_SEPERATOR + possibleMove.getPath();
	                    double newHeuristicCost = calcHeuristicCost(possibleMove.getPath(), destinationCity,Loc);
	                    
	                    Node node = new Node(newPath, 0, newHeuristicCost);
	                    if(queue.contains(node)) {
	                        updateQueueNode(queue, node);
	                    } else {
	                        queue.add(node);
	                    }
	                }
	            }
	        }
	    }
	    logOutput("\nNo path found for Greedy");
	}
}

