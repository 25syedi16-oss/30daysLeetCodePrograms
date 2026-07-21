import java.util.*;

class ThroneInheritance {
    private String kingName;
    private Map<String, List<String>> familyTree;
    private Set<String> dead;

    public ThroneInheritance(String kingName) {
        this.kingName = kingName;
        this.familyTree = new HashMap<>();
        this.dead = new HashSet<>();
        // Initialize the king's lineage
        this.familyTree.put(kingName, new ArrayList<>());
    }
    
    public void birth(String parentName, String childName) {
        // Ensure the parent exists in the map, then add the child
        familyTree.putIfAbsent(parentName, new ArrayList<>());
        familyTree.get(parentName).add(childName);
    }
    
    public void death(String name) {
        dead.add(name);
    }
    
    public List<String> getInheritanceOrder() {
        List<String> order = new ArrayList<>();
        dfs(kingName, order);
        return order;
    }
    
    // Depth-First Search (Pre-order traversal)
    private void dfs(String current, List<String> order) {
        if (!dead.contains(current)) {
            order.add(current);
        }
        
        // Traverse through all children from oldest to youngest
        List<String> children = familyTree.getOrDefault(current, new ArrayList<>());
        for (String child : children) {
            dfs(child, order);
        }
    }
}