package cities_roads;

class Node implements Comparable<Node>{
    String path;
    double actualCost;
    double hCost;

    public Node(String path, double actualCost, double hCost) {
        super();
        this.path = path;
        this.actualCost = actualCost;
        this.hCost = hCost;
    }

    public String getPath() {return path;}
    public void setPath(String path) {this.path = path;}

    public double getActualCost() {return actualCost;}
    public void setActualCost(double actualCost) {this.actualCost = actualCost;}

    public double getHeuristicCost() {return hCost;}
    public void setHeuristicCost(double hCost) {this.hCost = hCost;}

    // Function to compare the value of cost
    @Override
    public int compareTo(Node o) {
        double totalCost = actualCost + hCost;
        double totalCost_o = o.getActualCost() + o.getHeuristicCost();
        if(totalCost == totalCost_o) {
            return 0;
        } else if (totalCost > totalCost_o) {
            return 1;
        } else if (totalCost < totalCost_o) {
            return -1;
        }
        return 0;
    }

    // To check if the city is already in the frontier with a higher cost or if its a new city
    @Override
    public boolean equals(Object obj) {
        if(obj != null && obj instanceof Node) {
            Node newNode = (Node)obj;
            String existingCity = getCurrentCity(getPath());
            String newCity = getCurrentCity(newNode.getPath());
            if(existingCity.equalsIgnoreCase(newCity)) {
                return true;
            }
        }
        return false;
    }
    
    final static String PATH_SEPERATOR = ",";
    
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
    
    
    
    
}