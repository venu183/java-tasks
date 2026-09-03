import java.util.*;

class ThroneInheritance {

    private String king;
    private Map<String, List<String>> children;
    private Set<String> dead;

    public ThroneInheritance(String kingName) {
        king = kingName;
        children = new HashMap<>();
        dead = new HashSet<>();
    }

    public void birth(String parentName, String childName) {
        children.computeIfAbsent(parentName, k -> new ArrayList<>())
                .add(childName);
    }

    public void death(String name) {
        dead.add(name);
    }

    public List<String> getInheritanceOrder() {
        List<String> result = new ArrayList<>();
        dfs(king, result);
        return result;
    }

    private void dfs(String person, List<String> result) {

        // Add person if alive
        if (!dead.contains(person)) {
            result.add(person);
        }

        // Visit children in birth order
        if (children.containsKey(person)) {
            for (String child : children.get(person)) {
                dfs(child, result);
            }
        }
    }
}